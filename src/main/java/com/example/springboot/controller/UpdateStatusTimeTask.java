package com.example.springboot.controller;

import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author jiangtingfeng
 * @description
 * @date 2019/12/16/016
 */
@Component
public class UpdateStatusTimeTask {
    @Autowired
    private UserService userService;
    @Scheduled(cron = "0/5 * * * * ?")
    public void update() {
        userService.updateByTime();
    }
}
