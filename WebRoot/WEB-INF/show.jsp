<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table>
    	<tr>
    		<th>标题：</th>
    		<td>${mail.title }</td>
    	</tr>
    	<tr>
    		<th>发件人：</th>
    		<td>${mail.sender.account }</td>
    	</tr>
    	<tr>
    		<th>发件时间：</th>
    		<td>${mail.createTime }</td>
    	</tr>
    	<tr>
    		<th>正文：</th>
    		<td>
    			${mail.content }
    		</td>
    	</tr>
    </table>
  </body>
</html>
