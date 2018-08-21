<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
    <form action="user?op=reg" method="post">
    	<table>
    		<caption>新用户注册</caption>
    		<tr>
    			<th>账号：</th>
    			<td>
    				<input type="text" name="account" />
    			</td>
    		</tr>
    		<tr>
    			<th>密码：</th>
    			<td>
    				<input type="password" name="pwd" />
    			</td>
    		</tr>   
    		<tr>
    			<td colspan="2">
    				<input type="submit" value="登录" />
    				<input type="reset" value="重置" />
    			</td>
    		</tr> 		
    	</table>
    </form>
  </body>
</html>
