package com.zhanghui.vue.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.zhanghui.vue.entity.YxAdmin;
import com.zhanghui.vue.dao.YxAdminDao;
import com.zhanghui.vue.service.YxAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * (YxAdmin)表服务实现类
 *
 * @author makejava
 * @since 2020-07-12 18:10:26
 */
@Service("yxAdminService")
public class YxAdminServiceImpl implements YxAdminService {
    @Resource
    private YxAdminDao yxAdminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public YxAdmin queryById(String id) {
        return this.yxAdminDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<YxAdmin> queryAllByLimit(int offset, int limit) {
        return this.yxAdminDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param yxAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public HashMap<String, String> insert(YxAdmin yxAdmin) {
        HashMap<String, String> map = new HashMap<>();
        ;
        try {
            if (StringUtils.isEmpty(yxAdmin.getId())) {
                yxAdmin.setId(UUID.randomUUID().toString().replace("-", ""));
                if (yxAdminDao.insert(yxAdmin) > 0) {
                    map.put("success", "添加成功");
                } else {
                    map.put("success", "添加失败");
                }

            } else {
                System.out.println("更新操作");
                if (yxAdminDao.update(yxAdmin) > 0) {
                    map.put("success", "更新用户信息成功");
                } else {
                    map.put("success", "false");
                    map.put("message", "用户信息更新失败");
                }
            }
        } catch (Exception e) {
            map.put("success", "false");
            map.put("message", "用户信息更新失败");
        }
        return map;
    }

    /**
     * 修改数据
     *
     * @param yxAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public YxAdmin update(YxAdmin yxAdmin) {
        this.yxAdminDao.update(yxAdmin);
        return this.queryById(yxAdmin.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.yxAdminDao.deleteById(id) > 0;
    }
}