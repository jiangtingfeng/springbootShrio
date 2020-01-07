<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/5/005
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <P>
        请输入的你的注册信息
    </P>
    <form action="/user/register" method="get">
        用户名：<input type="text" name = "name" />
        密码： <input type="password" name = "password"/>
        <input type="submit" name="submit" value="注册"/>
    </form>
</body>
</html>
