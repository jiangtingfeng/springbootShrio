package com.example.springboot.config.shiro;


import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import lombok.SneakyThrows;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class ShiroRealmImpl extends AuthorizingRealm{

    @Autowired
    private UserService userService;



    //验证授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        String roles = user.getDescription();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if(null != roles && roles.length() > 0) {
            simpleAuthorizationInfo.addRoles(Arrays.asList(roles.split(",")));
        }

        return simpleAuthorizationInfo;
    }



    //验证用户登录信息
    @SneakyThrows
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String name = usernamePasswordToken.getUsername();
        String password = usernamePasswordToken.getPassword() != null ? new String(usernamePasswordToken.getPassword()) : null;
        User user = userService.isExist(name, password);

        if (null == user) {
            return null;
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
