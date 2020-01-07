<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/3/003
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="application/msexcel" pageEncoding="utf-8"%>
<%
    response.setHeader("Content-disposition","inline; filename=coomidity.xls");
    //以上这行设定传送到前端浏览器时的档名为test1.xls
    //就是靠这一行，让前端浏览器以为接收到一个excel档

%>
<% response.setContentType("application/vnd.ms-excel;charset=GBK");  //防止导出excel中文乱码 %>
