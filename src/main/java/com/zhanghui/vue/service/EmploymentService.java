package com.zhanghui.vue.service;

import com.zhanghui.vue.entity.Employment;

import java.util.List;

/**
 * (Employment)表服务接口
 *
 * @author makejava
 * @since 2020-07-18 17:07:46
 */
public interface EmploymentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Employment queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Employment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param employment 实例对象
     * @return 实例对象
     */
    Employment insert(Employment employment);

    /**
     * 修改数据
     *
     * @param employment 实例对象
     * @return 实例对象
     */
    Employment update(Employment employment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}