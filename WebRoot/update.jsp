<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>


  </head>
  
  <body>
  	
   	<form action="${pageContext.request.contextPath }/servlet/UpdateServlet" method="post">
    	<table>
    		<tr>
    			<td>账户名称</td>
    			<td><input  type="text" name="name" value="${cust.name }" readonly="readonly" style="background-color: silver"/></td>
    			
    		</tr>
    		<tr>
    			<td>性别</td>
    			<td>
    			
    			<input type="radio" name="gender" value="man" 
    				<c:if test="${cust.gender=='man' }">checked="checked"</c:if>
    			/>男
    			<input type="radio" name="gender" value="woman"
    				<c:if test="${cust.gender=='women' }">checked="checked"</c:if>
    			/>女
    			</td>
    			
    			
    		</tr>
    		<tr>
    			<td>客户出生年月</td>
    			<td><input type="text" name="birthday" value="${cust.birthday }"/></td>
    			
    		</tr>
    		<tr>
    			<td>手机号码</td>
    			<td><input type="text" name="cellphone" value="${cust.cellphone }"/></td>
    			
    		</tr>
    		<tr>
    			<td>电子邮箱</td>
    			<td><input type="text" name="email" value="${cust.email }"/></td>
    			
    		</tr>
    		<tr>
    			<td>爱好</td>
    			<td>
    				<input type="checkbox" name="preference" value="篮球"
    					<c:forTokens items="${cust.preference}" delims="," var="pref">
  							<c:if test="${pref=='篮球'}">checked="checked"</c:if>
  						</c:forTokens>
    				/>篮球
    				<input type="checkbox" name="preference" value="足球"
    					<c:forTokens items="${cust.preference}" delims="," var="pref">
  							<c:if test="${pref=='足球'}">checked="checked"</c:if>
  						</c:forTokens>
    				/>足球
    				<input type="checkbox" name="preference" value="排球"
    					<c:forTokens items="${cust.preference}" delims="," var="pref">
  							<c:if test="${pref=='排球'}">checked="checked"</c:if>
  						</c:forTokens>
    				/>排球
    				<input type="checkbox" name="preference" value="水球"
    					<c:forTokens items="${cust.preference}" delims="," var="pref">
  							<c:if test="${pref=='水球'}">checked="checked"</c:if>
  						</c:forTokens>
    				/>水球
    				<input type="checkbox" name="preference" value="网球"
    					<c:forTokens items="${cust.preference}" delims="," var="pref">
  							<c:if test="${pref=='网球'}">checked="checked"</c:if>
  						</c:forTokens>
    				/>网球
    				<input type="checkbox" name="preference" value="乒乓球"
    					<c:forTokens items="${cust.preference}" delims="," var="pref">
  							<c:if test="${pref=='乒乓球'}">checked="checked"</c:if>
  						</c:forTokens>
    				/>乒乓球
    			</td>
    			
    		</tr>
    		<tr>
    			<td>客户类型</td>
    			<td>
    				<select name="type">
    					<option value="砖石用户"
    						<c:if test="${cust.type=='钻石用户'}">selected="selected"</c:if>
    					>砖石用户</option>
    					<option value="铂金用户"
    						<c:if test="${cust.type=='铂金用户'}">selected="selected"</c:if>
    					>铂金用户</option>
    					<option value="黄金用户"
    						<c:if test="${cust.type=='黄金用户'}">selected="selected"</c:if>
    					>黄金用户</option>
    					<option value="白银用户"
    						<c:if test="${cust.type=='白银用户'}">selected="selected"</c:if>
    					>白银用户</option>
    					<option value="青铜用户"
    						<c:if test="${cust.type=='青铜用户'}">selected="selected"</c:if>
    					>青铜用户</option>
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
