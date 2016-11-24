<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>充值订单管理</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
 function commit(thispage){
	document.getElementById("thispage").value=thispage;
	document.getElementById("frm").action="${pageContext.request.contextPath}/booked/findall.do";
	document.getElementById("frm").submit();
 }
 
	function show(win){
		var win = document.getElementById(win);
		if(win){
			 if(win.style.display=='block'){  
				 win.style.display='none';  
				   }else{  
					   win.style.display='block';  
				   }  
		}
	}
	
	function show1(win){
		$("input[name='sdcl']").each(
		 function (){
			 $(this).attr("disabled","disabled"); 
		 }		
		);
		show('win1');
		document.getElementById("ih").value=win;
	}
	
	function show2(){
		var win = document.getElementById("ih").value;
		show('win1');
		show(win);
		$("input[name='sdcl']").each(
				 function (){
					 $(this).removeAttr("disabled"); 
				 }		
				);
	}
	
	function update(state){
		if(state==1){
			$("#state").val(2);
		}
		if(state==2){
			$("#state").val(2);
			var note = $("#note").val();
			if(note==null&&note==""){
				alert("请输入备注！");
				return false;
			}
		}
		document.getElementById("frm").action="${pageContext.request.contextPath}/booked/update.do";
		document.getElementById("frm").submit();
	}
	
</script>
<style type="text/css">
a{
text-decoration:none;
}
li {list-style-type: none;}
	.win {
		position:absolute;
		top:100%;
		left:35%;
		width:600px;
		height:400px;
		background:#fff;
		 margin:-500px 0 15px -202px; 
		/* line-height: 200px; */
		text-align: center;
		border: 4px solid #CCC;
		display: none;
		font-size: 25px;
		}
		
	#win1 {
		position:absolute;
		z-index:4;
		top:100%;
		left:35%;
		width:400px;
		height:200px;
		background:#fff;
		margin:-400px 0 15px -150px; 
		line-height: 80px;
		text-align: center; 
		border: 4px solid #CCC;
		display: none;
		font-size: 25px;
		}
td{
	width: 50px;
}
</style>
</head>
<body style="width: 1000px">
	<form action="${pageContext.request.contextPath}/booked/fquery.do" id="frm">
	<input type="hidden" id="flag" value="${flag}">		
		<table border="1" width="100%">
			<tr>
				<td>会员名：<input type="text" id="username" name="username"></td>
				<td colspan="3">发生时间：<input type="text" id="startTime" name="startTime"/>
				--<input type="text" name="endTime" id="endTime"></td>
				<td>支付供应商：
					<select id="supplier" name="supplier">
						<option value="">请选择</option>
						<option>支付宝</option>
						<option>微信</option>
						<option>块钱</option>
						<option>网银在线</option>
					</select>
				</td>
				<td >凭证订单编号：<input type="text" id="orderNumber" name="orderNumber"></td>
				<td colspan="2" ><input type="submit" value="查询"/></td>
			</tr>
			<tr>
				<td>序号</td>
				<td>会员名</td>
				<td>订单号</td>
				<td>发生额</td>
				<td>转账方式</td>
				<td>状态</td>
				<td>时间</td>
				<td>操作</td>
			</tr>
			<% 
				int rowNum=0;
			%>
			<c:forEach var="booked" items="${plist}">
				<tr>
					<c:if test="${booked.type==1}">
					<td><%=++rowNum %></td>
					<td>${booked.account.enterpriseName}</td>
					<td>${booked.number}</td>
					<td>${booked.deal}</td>
					<td>${booked.way}</td>
					<td>
						<c:if test="${booked.state==1}">
							已完成
						</c:if>
						<c:if test="${booked.state==0}">
							未完成
						</c:if>
					</td>
					<td>${booked.createTime}</td>
					<td>
						<input id="sdcl" name="sdcl" type="button" value="手工处理"  style="border:0px;color:blue;" onclick="show('<%=rowNum %>')"/>
							 <div id="<%=rowNum %>" class="win">
								<ul>
									<li>订单信息↓↓↓</li>
									<hr style="border:1px dashed #000; height:1px">
									<li>订单编号：${booked.number}</li>
									<li>会员名称：${booked.account.enterpriseName}</li>
									<li>操作金额:${booked.deal}</li>
									<li>支付方式：${booked.way}</li>
									<li>发生时间：${booked.createTime}</li>
									<li>当前状态：
										<c:if test="${booked.state==1}">
											已完成
										</c:if>
										<c:if test="${booked.state==0}">
											未完成
										</c:if>
									</li>
									<hr style="border:1px dashed #000; height:1px">
									<li>
										<c:if test="${booked.state==1}">
											<input type="button" value="关闭" onclick="show('<%=rowNum%>')">
										</c:if>
										<c:if test="${booked.state==0}">
										<input type="hidden" name="id" value="${booked.id}">
										<input type="hidden" name="deal" value="${booked.deal}">
										<input type="hidden" name="number" value="${booked.number}">
										<input type="hidden" id="state" name="state" value="">
										<input type="hidden" name="userName" value="${booked.account.enterpriseName}">
											<input type="button" value="转手工处理,并给客户入款" onclick="update(1)">
											<input type="button" value="转手工处理,但不给客户入款" onclick="show1('<%=rowNum%>')">
										</c:if>
									</li>
								</ul>
							</div>
					 </td>
					</c:if>
				</tr>
			</c:forEach>
			<div id="win1" class="win1">
			<input type="hidden" id="ih" value="">
				备注：<input type="text" id="note" name="note" style="width: 300px;height: 40px" value="">
				<input type="button" value="确定" onclick="update(2)">  <input type="button" value="取消" onclick="show2()">
			</div>
			<tr>
				<td><a href="${pageContext.request.contextPath}/booked/export.do"><input type="button" value="下载列表"></a></td>
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