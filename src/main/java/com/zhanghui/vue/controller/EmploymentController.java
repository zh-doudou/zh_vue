package com.zhanghui.vue.controller;

import com.zhanghui.vue.entity.Employment;
import com.zhanghui.vue.service.EmploymentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employment)表控制层
 *
 * @author makejava
 * @since 2020-07-18 17:07:46
 */
@RestController
@RequestMapping("employment")
public class EmploymentController {
    /**
     * 服务对象
     */
    @Resource
    private EmploymentService employmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Employment selectOne(Integer id) {
        return this.employmentService.queryById(id);
    }


    @CrossOrigin
    @GetMapping("selectAll")
    public List<Employment> selectAll() {
        List<Employment> employments = this.employmentService.queryAllByLimit(0, 100);
        return employments;
    }
}