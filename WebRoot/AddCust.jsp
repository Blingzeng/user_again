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
 	
    <h1>请填写正确填写相关信息</h1>
    <form action="${pageContext.request.contextPath }/servlet/AddCustServlet" method="post">
    	<table>
    		<tr>
    			<td>账户名称</td>
    			<td><input  type="text" name="name"/></td>
    			
    		</tr>
    		<tr>
    			<td>性别</td>
    			<td><input type="radio" name="gender" value="man"/>男
    				<input type="radio" name="gender" value="woman"/>女
    			</td>
    			
    			
    		</tr>
    		<tr>
    			<td>客户出生年月</td>
    			<td><input type="text" name="birthday" /></td>
    			
    		</tr>
    		<tr>
    			<td>手机号码</td>
    			<td><input type="text" name="cellphone" /></td>
    			
    		</tr>
    		<tr>
    			<td>电子邮箱</td>
    			<td><input type="text" name="email" /></td>
    			
    		</tr>
    		<tr>
    			<td>爱好</td>
    			<td>
    				<input type="checkbox" name="preference" value="篮球"/>篮球
    				<input type="checkbox" name="preference" value="足球"/>足球
    				<input type="checkbox" name="preference" value="排球"/>排球
    				<input type="checkbox" name="preference" value="水球"/>水球
    				<input type="checkbox" name="preference" value="网球"/>网球
    				<input type="checkbox" name="preference" value="乒乓球"/>乒乓球
    			</td>
    			
    		</tr>
    		<tr>
    			<td>客户类型</td>
    			<td>
    				<select name="type">
    					<option value="砖石用户">砖石用户</option>
    					<option value="铂金用户">铂金用户</option>
    					<option value="黄金用户">黄金用户</option>
    					<option value="白银用户">白银用户</option>
    					<option value="青铜用户">青铜用户</option>
    				</select>
    			</td>
    			
    		</tr>
    		<tr>
    			<td colspan="2" >
    				<input type="submit" value="提交"/>
    			</td>
    		</tr>
	    	
    	</table>
    
    </form>
  </body>
</html>
