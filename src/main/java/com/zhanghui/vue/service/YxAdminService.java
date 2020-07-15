package com.zhanghui.vue.service;

import com.zhanghui.vue.entity.YxAdmin;

import java.util.HashMap;
import java.util.List;

/**
 * (YxAdmin)表服务接口
 *
 * @author makejava
 * @since 2020-07-12 18:10:26
 */
public interface YxAdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    YxAdmin queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<YxAdmin> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param yxAdmin 实例对象
     * @return 实例对象
     */
    HashMap<String, String> insert(YxAdmin yxAdmin);

    /**
     * 修改数据
     *
     * @param yxAdmin 实例对象
     * @return 实例对象
     */
    YxAdmin update(YxAdmin yxAdmin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}