<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入款列表</title>
<script type="text/javascript">
 function commit(thispage){
	document.getElementById("thispage").value=thispage;
	document.getElementById("frm").action="${pageContext.request.contextPath}/booked/findAll.do";
	document.getElementById("frm").submit();
 }
</script>
</head>
<body style="width: 800px">
	<form action="" id="frm">	
	<tr>
		<td><a href="${pageContext.request.contextPath}/booked/expense.do"><input type="button" value="消费列表"></a></td>
		<td><a href="${pageContext.request.contextPath}/booked/toreduce.do"><input type="button" value="入账扣款"></a></td>
		<td><a href="${pageContext.request.contextPath}/booked/topm.do"><input type="button" value="充值订单管理"></a></td>
		<td><a href="${pageContext.request.contextPath}/booked/toquery.do"><input type="button" value="会员财务查询"></a></td>
	</tr>
		<table border="1" width="800">
			<tr>
				<td>序号</td>
				<td>会员名称</td>
				<td>摘要</td>
				<td>发生额</td>
				<td>余额</td>
				<td>转账方式</td>
				<td>备注</td>
				<td>时间</td>
			</tr>
			<%
			int rowNum =0;
			%>
			<c:forEach var="booked" items="${blist}">
				<tr>
				<c:if test="${booked.type==1}">
					<td><%=++rowNum%></td>
					<td>${booked.userName}</td>
					<td>真实入账</td>
					<td>${booked.deal}</td>
					<td>${booked.balance}</td>
					<td>${booked.way}</td>
					<td>${booked.note}</td><!--  pattern="yyyy年MM月dd日  HH:mm:ss E" -->
					<td><fmt:formatDate value="${booked.createTime}" pattern="yyyy年MM月dd日  HH:mm:ss"/></td>
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