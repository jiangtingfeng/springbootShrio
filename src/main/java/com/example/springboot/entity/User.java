package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jiangtingfeng
 * @description
 * @date 2019/12/15/015
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String password;
    private String description;
    private String salt;
    @TableField("startTime")
    private LocalDateTime startTime;
    @TableField("endTime")
    private LocalDateTime endTime;
    public User(){

    }
    public User(String name, String password, String description) {
        this.name = name;
        this.password = password;
        this.description = description;
    }
}
