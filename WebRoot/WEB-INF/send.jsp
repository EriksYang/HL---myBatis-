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
    
    <title>My JSP 'send.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		/*
		*{
			margin: 0px;
			padding:0px;
		}
		*/
		
		ul{
			width:178px;
			margin:0px;
			padding:0px;
			list-style:none;
			position:absolute;
			border:solid 1px gray;
		}
		
		#drop{
			width:180px;
			position: relative;
		}
	</style>
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
		//存储选中的文本内容
		var text = [];
		//存储选中的用户值
		var vales = [];
		
		$(function(){
			$("#dropBox").hide();
		});
		
		$(function(){
			$("#drop").bind("click",function(){
				$("#dropBox").toggle();
			});
			
			$("input[type='checkbox']").bind("change",function(){
				if($(this).prop("checked")){
					//将当前选项对应的文本值添加到数组中
					text.push( $(this).next().text());
					//将数组赋值给drop元素
					$("#drop").val(text);
					
					//将用户Id添加到数组中
					vales.push($(this).val());
					alert(vales);
					$("#reciver").val(vales);
				}
				else{
					//取消选中时，移除元素项的值
					var idx = getIndex($(this).next().text());
					//移除指定索引位置的元素
					//splice(索引位置，移除数量)
					text.splice(idx,1);
					$("#drop").val(text);
					
					//移除用户Id的值
					vales.splice(idx,1);
					$("#reciver").val(vales);
				}
			});
		});
		
		/*
		* 获取文本在数组中的索引位置
		*/
		function getIndex(val){
			//遍历数组对象
			for(var i = 0;i<text.length;i++){
				//将元素的值与val进行比对
				if(text[i]==val)
					//如果值相同则返回索引位置
					return i;
			}
			
			return -1;
		}
		
		
	</script>
  </head>
  
  <body>
    <form action="mail?op=save" method="post">
    	<table>
    		<tr>
    			<th width="80">标题：</th>
    			<td>
    				<input type="text" name="title" />
    			</td>
    		</tr>
    		<tr>
    			<th>收件人：</th>
    			<td>
    				<!--  
    				<select name="reciver" multiple="multiple">
    					<c:forEach items="${list}" var="user">
	    					<option value="${user.userId }">${user.account }</option>
	    				</c:forEach>
    				</select>
    				-->
    				<input type="text" id="drop" />
    				<ul id="dropBox">

    					<c:forEach items="${list}" var="user">
	    					<li><input type="checkbox" value="${user.userId }"  id="${user.userId }"/><label for="${user.userId }">${user.account }</label></li>
	    				</c:forEach>
    				</ul>
    				<input type="text" name="reciver" id="reciver"/>
    			</td>
    		</tr>
    		<tr>
    			<th>正文：</th>
    			<td>
    				<textarea rows="8" cols="80" name="content"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<input type="submit" value="发送" />
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
