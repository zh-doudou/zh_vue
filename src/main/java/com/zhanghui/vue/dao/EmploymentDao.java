package com.zhanghui.vue.dao;

import com.zhanghui.vue.entity.Employment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Employment)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-18 17:07:46
 */
public interface EmploymentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Employment queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Employment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param employment 实例对象
     * @return 对象列表
     */
    List<Employment> queryAll(Employment employment);

    /**
     * 新增数据
     *
     * @param employment 实例对象
     * @return 影响行数
     */
    int insert(Employment employment);

    /**
     * 修改数据
     *
     * @param employment 实例对象
     * @return 影响行数
     */
    int update(Employment employment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}