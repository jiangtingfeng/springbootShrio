package com.example.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.common.util.Md5Util;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author jiangtingfeng
 * @description
 * @date 2019/12/15/015
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public void updateByTime() {
        User user = baseMapper.selectOne(new QueryWrapper<User>().eq("id",1));
        LocalDateTime now = LocalDateTime.now();
        if (user.getEndTime().isBefore(now)) {
            baseMapper.updateById(user);
        }
    }

    public User isExist(String name, String password) throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        String psw = Md5Util.md5ToLower(password);
        queryWrapper.eq(!StringUtils.isEmpty(name), "name", name)
                .eq(!StringUtils.isEmpty(psw), "password", psw);
        List<User> userList = baseMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return new User(name, password, userList.get(0).getDescription());
    }
}
