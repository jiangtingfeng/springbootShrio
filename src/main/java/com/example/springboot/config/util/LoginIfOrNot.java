package com.example.springboot.config.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 * @author jiangtingfeng
 * @description 对需要进行进行权限判定的进行判断
 * @date 2020/1/5/005
 */
@Component
public class LoginIfOrNot {

    public String login(String name, String password,String url) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, password);
        try {
            subject.login(usernamePasswordToken);
            return url;
        } catch (AuthenticationException e) {
            usernamePasswordToken.clear();
            return "login";
        }
    }
}
