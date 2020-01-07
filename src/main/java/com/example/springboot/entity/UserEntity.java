package com.example.springboot.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author jiangtingfeng
 * @description 实体类
 * @date 2019/12/30/030
 */
@Data
public class UserEntity {
    private Long id;
    private String guid;
    private String name;
    private String age;
    private Date createTime;
}
