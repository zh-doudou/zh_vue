package com.zhanghui.vue.service.impl;

import com.zhanghui.vue.dao.EmploymentDao;
import com.zhanghui.vue.entity.Employment;
import com.zhanghui.vue.service.EmploymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employment)表服务实现类
 *
 * @author makejava
 * @since 2020-07-18 17:07:46
 */
@Service("employmentService")
public class EmploymentServiceImpl implements EmploymentService {
    @Resource
    private EmploymentDao employmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Employment queryById(Integer id) {
        return this.employmentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Employment> queryAllByLimit(int offset, int limit) {
        return this.employmentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param employment 实例对象
     * @return 实例对象
     */
    @Override
    public Employment insert(Employment employment) {
        this.employmentDao.insert(employment);
        return employment;
    }

    /**
     * 修改数据
     *
     * @param employment 实例对象
     * @return 实例对象
     */
    @Override
    public Employment update(Employment employment) {
        this.employmentDao.update(employment);
        return this.queryById(employment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.employmentDao.deleteById(id) > 0;
    }
}