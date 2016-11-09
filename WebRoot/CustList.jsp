<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript">
    	function checkAll(allCB){
			var cbs = document.getElementsByName("delId");
			for(var i = 0;i<cbs.length;i++){
				cbs[i].checked = allCB.checked;	
			}    	
    	
    	
    	}
    
    
    </script>

  </head>
  
  <body>
  	<h1>客户列表</h1>
  	<form action="${pageContext.request.contextPath }/servlet/BatchDelCustSer" method="POST">
    <table border="1" >
    
    	<tr>
    		<th><input type="checkbox" onclick="checkAll(this)"/>全选</th>
    		<th>客户姓名</th>
    		<th>客户性别</th>
    		<th>出生年月</th>
    		<th>客户电话</th>
    		<th>客户邮箱</th>
    		<th>客户爱好</th>
    		<th>客户类型</th>
    		<th>修改客户</th>
    		<th>删除客户</th>
    	</tr>
    	
    		<c:forEach items="${requestScope.custs }" var="cust">
    		<tr>
    			<td align="center"> <input type="checkbox" name="delId" value="${cust.id }" /></td>
    			
    			<td>${cust.name }</td>
    			<td>${cust.gender }</td>
    			<td>${cust.birthday }</td>
    			<td>${cust.cellphone }</td>
    			<td>${cust.email }</td>
    			<td>${cust.preference }</td>
    			<td>${cust.type }</td>
    			<td><a href="${pageContext.request.contextPath }/servlet/FindCustServlet?id=${cust.id}">修改</a></td>
    			<td><a href="${pageContext.request.contextPath }/servlet/DeleteCustServlet?id=${cust.id}">删除</a></td>
    		</tr>
    		</c:forEach>
    	
    	
    </table>
    	<input type="submit" value="批量删除"/>
    </form>
  </body>
</html>
