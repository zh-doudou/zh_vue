package com.zhanghui.vue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Employment)实体类
 *
 * @author makejava
 * @since 2020-07-18 17:07:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employment implements Serializable {
    private static final long serialVersionUID = 167528621462164317L;
    /**
     * 招聘id
     */
    private Integer id;
    /**
     * 职位
     */
    private String name;
    /**
     * 薪资
     */
    private String slary;
    /**
     * 描述
     */
    private String account;
    /**
     * 公司地址
     */
    private String address;
    /**
     * 公司亮点
     */
    private String highlights;
    /**
     * 学历
     */
    private String education;
}