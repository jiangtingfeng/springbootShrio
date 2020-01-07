package com.example.springboot.controller;

import com.example.springboot.config.util.RedisUtil;
import com.example.springboot.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author jiangtingfeng
 * @description redisController
 * @date 2019/12/30/030
 */
@Slf4j
@RequestMapping("/redis")
@Api("springboot + redis")
@RestController
public class RedisController {

    /*
     *功能描述 redis中存储的过期时间60s
     */
    private static int ExpireTime = 60;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/set",method = RequestMethod.GET)
    @ApiModelProperty("为redis添加字段值")
    public boolean redisset(String key, String value){
        UserEntity userEntity =new UserEntity();
        userEntity.setId(Long.valueOf(1));
        userEntity.setGuid(String.valueOf(1));
        userEntity.setName("zhangsan");
        userEntity.setAge(String.valueOf(20));
        userEntity.setCreateTime(new Date());
//      return redisUtil.set(key,userEntity,ExpireTime);

        return redisUtil.set(key,value);
}

    @RequestMapping(value = "get",method = RequestMethod.GET)
    @ApiModelProperty("获取相应的字段值")
    public Object redisget(String key){
        return redisUtil.get(key);
    }

    @RequestMapping(value = "expire",method = RequestMethod.GET)
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }

}
