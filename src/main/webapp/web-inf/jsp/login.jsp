<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/5/005
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">

<head>
    <title>登录页面</title>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
</head>

<body>
<p>登录页面</p>
<form action="/user/login" method="get">
    name: <input type="text" name="name"/>
    password: <input type="password" name="password"/>
    <button type="submit">登录</button>
</form>
</body>

</html>