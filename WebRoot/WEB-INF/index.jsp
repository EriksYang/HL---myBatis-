<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<frameset rows="120,*">
	<frame name="top" noresize="noresize" src="top.jsp">
	<frameset cols="240,*">
		<frame name="menu" noresize="noresize" src="menu.jsp">
		<frame name="content">	
	</frameset>
</frameset>
