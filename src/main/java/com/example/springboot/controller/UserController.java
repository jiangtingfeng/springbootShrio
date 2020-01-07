package com.example.springboot.controller;

import com.example.springboot.common.util.ExcelUtils;
import com.example.springboot.common.util.Md5Util;
import com.example.springboot.config.util.LoginIfOrNot;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author jiangtingfeng
 * @description
 * @date 2019/12/15/015
 */
@Controller
@Api(value = "springboot + jsp",tags = "相关接口")
@RequestMapping("user")
public class UserController {

    @Autowired
    private LoginIfOrNot loginIfOrNot;
    @Autowired
    @Qualifier(value = "taskExecutor")
    private TaskExecutor executor;



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String name, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, password);
        try {
            subject.login(usernamePasswordToken);
            return "redirect:/user/test";
        } catch (AuthenticationException e) {
            usernamePasswordToken.clear();
            return "login";
        }
    }

    @RequestMapping(value = "/reg",method = RequestMethod.GET)
    @ApiModelProperty("注册页面")
    public String reg() {
        return "register";
    }


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    @ApiModelProperty("注册")
    public String register(@RequestParam("name") String name,@RequestParam("password") String password) throws Exception {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setDescription("cest1");
        userService.save(user);
        return "login";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ApiModelProperty("获取jsp的值")
    public ModelAndView get(){
        ModelAndView m = new ModelAndView("hello");
        Date date = new Date();
        m.addObject("now",date);
        m.addObject("name","jiang");
        return m;
    }

    @GetMapping("/getExcel")
    @ApiModelProperty("导出报表")
    public void getExcel(HttpServletResponse response) throws Exception {
        List<User> list = userService.list();
        HashMap<String,String> topMap = new LinkedHashMap<>();
        topMap.put("id","id");
        topMap.put("name","姓名");
        topMap.put("password","密码");
        topMap.put("description","描述");
        topMap.put("startTime","创建时间");
        topMap.put("endTime","更新时间");
        String excelName = "测试";
        ExcelUtils.listToExcel(list, topMap,excelName,response);
    }
}
