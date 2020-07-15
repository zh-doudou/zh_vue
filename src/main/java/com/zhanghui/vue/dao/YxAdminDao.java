package com.zhanghui.vue.dao;

import com.zhanghui.vue.entity.YxAdmin;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (YxAdmin)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-12 18:10:26
 */
public interface YxAdminDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    YxAdmin queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<YxAdmin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param yxAdmin 实例对象
     * @return 对象列表
     */
    List<YxAdmin> queryAll(YxAdmin yxAdmin);

    /**
     * 新增数据
     *
     * @param yxAdmin 实例对象
     * @return 影响行数
     */
    int insert(YxAdmin yxAdmin);

    /**
     * 修改数据
     *
     * @param yxAdmin 实例对象
     * @return 影响行数
     */
    int update(YxAdmin yxAdmin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}