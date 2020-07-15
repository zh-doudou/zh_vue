package com.zhanghui.vue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (YxAdmin)实体类
 *
 * @author makejava
 * @since 2020-07-12 18:10:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YxAdmin implements Serializable {
    private static final long serialVersionUID = 941512138123685027L;
    private String id;
    private String username;

    private String password;

    private String status;


}