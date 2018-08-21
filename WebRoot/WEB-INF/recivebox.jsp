<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'recivebox.jsp' starting page</title>
    
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
    		<th>标题</th>
    		<th>收件日期</th>
    		<th>发件人</th>
    		<th>状态</th>
    		<th>操作</th>    	
    	</tr>
    	<c:forEach items="${list }" var="item">
    		<tr>
    			<td>
    				<a href="mail2?op=read&id=${item.mailId }">${item.title }</a>
    			</td>
    			<td>${item.createTime }</td>
    			<td>${item.sender.account}</td>
    			<td>${item.reciver.state==0? '未读':'已读' }</td>
    			<td>
    				<a href="mail2?op=del&id=${item.mailId }">删除</a>
    			</td>
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>
