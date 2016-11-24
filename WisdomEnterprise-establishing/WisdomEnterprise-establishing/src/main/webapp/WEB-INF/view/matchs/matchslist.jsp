<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>匹配推荐显示页面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
 function commit(thispage){
	document.getElementById("thispage").value=thispage;
	document.getElementById("frm").action="${pageContext.request.contextPath}/matchs/query.do";
	document.getElementById("frm").submit();
 }
 
	$(document).ready(function() {
		$("#select").click(function() {
			if (this.checked) {
				$("input[name='id']").each(function() {
					this.checked = true
				});
			} else {
				$("input[name='id']").each(function() {
					this.checked = false
				});
			}

		})
	})
	
	function  download(){
		var ids = "";
		$("input[name='id']").each(
			function(){
				if(this.checked){
					ids+=$(this).val()+",";
				}
			}		
		)
		document.getElementById("ids").value=ids;
		document.getElementById("frm").action="${pageContext.request.contextPath}/matchs/export.do";
		document.getElementById("frm").submit();
		 if(ids!=""){
				$("#select").checked = false;
				$("input[name='id']").each(
						function (){
							this.checked = false;	
							}
					)
			} 
	}
</script>
</head>
<body style="width: 800px">
	<form action="" id="frm">
		<input type="hidden" id="ids" name="ids" value="">
		<input type="button" value="下载匹配资料" onclick="download()" style="float: right;">
		<a href="${pageContext.request.contextPath}/matchs/toQuery.do"><input type="button" value="手动匹配" style="float: right;"></a>  
		<table border="1" width="800">
			<tr>
				<td>选择</td>
				<td>匹配时间</td>
				<td>企业名称</td>
				<td>项目名称</td>
				<td>状态</td>
				<td>匹配度</td>
				<td>操作</td>
			</tr>

			<c:forEach var="matchs" items="${mlist}">
				<tr>
					<td><input type="checkbox" id="id" name="id" value="${matchs.id}"></td>
					<td><fmt:formatDate value="${matchs.matchTime}" pattern="yyyy-MM-dd"/></td>
					<td>${matchs.companyName}</td>
					<td>${matchs.projectName}</td>
					<td>
						<c:if test="${matchs.state==1}">
							已购买
						</c:if>
						<c:if test="${matchs.state==2}">
							未购买
						</c:if>
					</td>
					<td>${matchs.matchDegree}</td>
					<td><a
						href="${pageContext.request.contextPath}/matchs/checks.do?id=${matchs.id}&status=${matchs.state}">查看</a>
						<a
						href="${pageContext.request.contextPath}/matchs/toedit.do?id=${matchs.id}">编辑</a>
						<a
						href="${pageContext.request.contextPath}/matchs/delete.do?id=${matchs.id}" onclick="if(confirm('确定删除吗?')==false)return false;">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="checkbox" id="select" name="select">全选</td>
				<td colspan="5"><font size="2">共 ${page.totalPageCount} 页</font>
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
		<c:if test="${matchs!=null}">
				<input type="hidden" name="projectFinancingMode" value="${matchs.projectFinancingMode}">
				<input type="hidden" name="projectBusiness" value="${matchs.projectBusiness}">
				<input type="hidden" name="fundBudget" value="${matchs.fundBudget}">
				<input type="hidden" name="projectArea" value="${matchs.projectArea}">
				<input type="hidden" name="projectName" value="${matchs.projectName}">
	 </c:if>
	 <input type="hidden" name="thispage" id="thispage" vlaue="">
	</form>
</body>
</html>