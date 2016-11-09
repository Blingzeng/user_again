<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
    <h1>欢迎光临，这是主页</h1>
    <a href="${pageContext.request.contextPath }/AddCust.jsp">注册</a>
   	<a href="${pageContext.request.contextPath }/servlet/FindAllCust">查看用户</a>
  </body>
</html>
