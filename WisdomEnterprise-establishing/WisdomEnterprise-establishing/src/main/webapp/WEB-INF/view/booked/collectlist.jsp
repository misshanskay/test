<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>财务统计</title>
<script type="text/javascript">
 function commit(thispage){
	document.getElementById("thispage").value=thispage;
	document.getElementById("frm").action="${pageContext.request.contextPath}/booked/findall.do";
	document.getElementById("frm").submit();
 }
</script>
</head>
<body style="width: 800px">
	<form action="" id="frm">		
		<table border="1" width="800">
			<tr>
				<td>支付宝入账</td>				
				<td>微信入账</td>				
				<td>工行入账</td>				
				<td>交行入账</td>				
				<td>中行入账</td>				
				<td>农行入账</td>				
				<td>现金入账</td>				
				<td>合计入账</td>				
				<td>合计消费</td>				
				<td>余额</td>							
			</tr>

			<c:forEach var="booked" items="${blist}">
				<tr>
					<c:if test="${booked.way=='微信'}">
					</c:if>
				</tr>
			</c:forEach>
			<tr>
				<td><a href="${paeContext.request.contextPath}/booked/export.do"><input type="button" value="下载列表" style="float: right;"></a></td>
				<td colspan="7"><font size="2">共 ${page.totalPageCount} 页</font>
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
	 <input type="hidden" name="thispage" id="thispage" vlaue="">
	</form>
</body>
</html>