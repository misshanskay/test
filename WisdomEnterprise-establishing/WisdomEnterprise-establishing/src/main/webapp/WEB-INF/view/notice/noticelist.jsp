<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告信息显示页面</title>
<script type="text/javascript">
	function check(){
		var sbtitle=document.getElementById("div1");  
		if(sbtitle){  
		   if(sbtitle.style.display=='block'){  
		   sbtitle.style.display='none';  
		   }else{  
		   sbtitle.style.display='block';  
		   }  
		}  
	}
	
	function commit(thispage){
		document.getElementById("thispage").value=thispage;
		document.getElementById("frm").action="${pageContext.request.contextPath}/notice/select.do";
		document.getElementById("frm").submit();
	}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/notice/select.do" id="frm">
<input type="hidden" name="thispage" id="thispage" value="">
<a href="${pageContext.request.contextPath}/notice/toAdd.do">发布公告</a>  <input type="button" value="公告查询" onclick="check()">
	 	<table border="1" width="600">
 		<tr>
 			<td>会员名</td>
 			<td>公告标题</td>
 			<td>发布时间</td>
 			<td>排列顺序</td>
 			<td>操作</td>
 		</tr>
 		
 		<c:forEach var="notice" items="${nlist}">
 		<tr>
 			<td>${notice.memberName}</td>
 			<td>${notice.title}</td>
 			<td>${notice.createTime}</td>
 			<td>${notice.orderNum}</td>
 			<td><a href="${pageContext.request.contextPath}/notice/toupdate.do?id=${notice.id}">编辑</a>
 			 <a href="${pageContext.request.contextPath}/notice/delete.do?id=${notice.id}" onclick="if(confirm('确定删除吗？')==false){return false;}">删除</a></td>
 		</tr>
 		</c:forEach>
			<tr>
				<td colspan="6"><font size="2">共 ${page.totalPageCount} 页</font>
				 <font size="2">第 ${page.thispage} 页</font>
				 	<input type="button" value="首页" onclick="commit('1')">
				 	<c:if test="${page.thispage - 1 > 0}">
				 		<input type="button" value="上一页" onclick="commit('${page.thispage - 1}')">
				 	</c:if>
				 	<c:if test="${page.thispage + 1 <= page.totalPageCount}">
				 		<input type="button" value="下一页" onclick="commit('${page.thispage + 1}')">
				 	</c:if>
					<input type="button" value="尾页" onclick="commit('${page.totalPageCount}')">
				</td>
			</tr>
 	</table>
 	<div id="div1" style="display: none;">
 		<tr>
 			<td>公告标题：<input type="text" name="title" id="title"></td>
 			<td>发布时间：<input type="text" name="createTime" id="createTime"></td>
 			<td>正文：<input type="text" name="content" id="content"></td>
 			<td>发布人：<input type="text" name="memberName" id="memberName"></td>
 			<td>
 			<input type="submit" id="chaxun" value="查询">
 		</tr>
 	</div>
</form>
</body>
</html>