<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- springmvc的from标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- jstl标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息发布更新页面</title>
<link href= "${pageContext.request.contextPath}/css/basestyle.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Validform_v5.3.2.js"></script>
<script type="text/javascript">
	$(document).ready(
					function() {
						$("#provinceid").change(
							function() {
							var provinceName = jQuery("#provinceid option:selected").val();
							$.ajax({
								url : "${pageContext.request.contextPath}/getcityandarea/querycity.do",
								cache : false,
								data : "provinceName="+ provinceName,//encodeURI(encodeURI(selValue)),
								dataType : "json",
								type : "post",
								success : function(data) {
								var ln = $("#city option").size();
								// $("#city").empty(); 
								while (ln > 1) {
								document.getElementById("city").remove(document.getElementById("city").options.length - 1);
								--ln;
								}
								/* $("#city").append("<option>"+"全部"+"</option>");  */
								for (var i = 0; i < data.length; i++) {
								$("#city").append(
								"<option value="+data[i].name+">"+ data[i].name+ "</option>");
							}
						}
					});
				})
			})
	 	$(function() {
		//$(".registerform").Validform(); 
		var demo = $(".registerform").Validform({//指明是哪一表单需要验证,名称需加在form表单上;
			tiptype : 3,
			showAllError : true,
		});
	}) 
</script>
<style>
li {
	list-style-type: none;
}
</style>
</head>
<body>
	<form class="registerform" action="${pageContext.request.contextPath}/releaseinfo/add.do" id="frm" name="frm">
		<ul>
			<li>项目名称：<input type="text" id="projectName" name="projectName" value="" datatype="/[a-zA-Z\u4E00-\u9FA5]+$/" errormsg="请输入中文或英文"/>
				<span style="color: red;">*</span>
			</li>
			<li>项目类型：<input type="radio" name="projectType" value="新项目" datatype="*" errormsg="请选择项目类型！">新项目<input
				type="radio" name="projectType" value="扩建项目">扩建项目 <span style="color: red;">*</span>
			</li>
			<li>合作方式：<input type="checkbox" name="cooperationMode" value="1">合资<input
				type="checkbox" name="cooperationMode" value="2">独资<input
				type="checkbox" name="cooperationMode" value="3">合作  <span style="color: red;">*</span>
			</li>
			<li>PPP项目融资方式： <select name="projectFinancingMode" datatype="*" errormsg="请选择融资方式!">
					<option value>请选择</option>
					<option value="BOT">BOT</option>
					<option value="BOO">BOO</option>
					<option value="BOOT">BOOT</option>
					<option value="BTO">BTO</option>
					<option value="PPP">PPP</option>
			</select> <span style="color: red;">*</span>
			</li>
			<li>项目所属行业：<input type="text" id="projectBusiness"
				name="projectBusiness" value="${matchs.projectBusiness}"datatype="/[a-zA-Z\u4E00-\u9FA5]+$/" errormsg="请输入中文或英文!"/> <span style="color: red;">*</span></li>
			<li>项目地区： <select id="provinceid" name="projectArea" datatype="*" errormsg="请选择地区"/>
					<option>请选择省份</option>
					<c:forEach var="province" items="${plist}">
						<option value="${province.name}">${province.name}</option>
					</c:forEach>
			</select> -- <select id="city" name="city" >
					<option>全部</option>
			</select> <span style="color: red;">*</span>
			</li>
			<li>所属园区：<input type="text" name="parkArea" value="" datatype="/[a-zA-Z\u4E00-\u9FA5]+$/" errormsg="请输入中文或英文!"/> <span style="color: red;">*</span></li>
			<li>项目详细地址：<input type="text" name="projectAddress" value="" datatype="/[a-zA-Z\u4E00-\u9FA5]+$/" errormsg="请输入中文或英文!"/> <span style="color: red;">*</span></li>
			<li>发布位置： WEB：<input name="releasePosition" type="checkbox"
				id="releasePosition" value="WEB" datatype="*" errormsg="请选择发布位置！"/> 信息化大屏：<input
				name="releasePosition" type="checkbox" id="releasePosition"
				value="信息化大屏" /> 自助终端机：<input name="releasePosition"
				type="checkbox" id="releasePosition" value="自助终端机" /> APP：<input
				name="releasePosition" type="checkbox" id="releasePosition"
				value="APP" />  <span style="color: red;">*</span>
			</li>
			<li>投资总额：<input type="text" id="fundBudget" name="fundBudget"
				value=""  datatype="/^[0-9]*$/" errormsg="请输入数字！"/>(单位：万元) <span style="color: red;">*</span>
			</li>
			<li>拟引投资总金额：<input type="text" id="expectedReturn"
				name="expectedReturn" value="" datatype="/^[0-9]*$/" errormsg="请输入数字！"/>(单位：万元) <span style="color: red;">*</span>
			</li>
			<li>预计年销售收入：<input type="text" id="fundBudget" name="fundBudget"
				value="" datatype="/^[0-9]*$/" errormsg="请输入数字！"/>(单位：万元) <span style="color: red;">*</span>
			</li>
			<li>预计投资收回期：<input type="text" id="expectedYear"
				name="expectedYear" value="" datatype="/^[0-9]*$/" errormsg="请输入数字！"/>年 <span style="color: red;">*</span>
			</li>
			<li>预计就业人数：<input type="text" id="expectedPeople"
				name="expectedPeople" value="" datatype="/^[0-9]*$/" errormsg="请输入数字！"/>人 <span style="color: red;">*</span>
			</li>
			<li>项目主要内容：<form:textarea cols="80" rows="10"
					path="releaseinfo.projectContent" datatype="/[a-zA-Z\u4E00-\u9FA5]+$/" errormsg="请输入中文或英文!" /> <span style="color: red;">*</span></li>
			<li>项目主要优势：<form:textarea cols="80" rows="10"
					path="releaseinfo.projectAdvantage" datatype="/[a-zA-Z\u4E00-\u9FA5]+$/" errormsg="请输入中文或英文!"/> <span style="color: red;">*</span></li>
			<li>有限期限：半年：<input type="radio" name="limitedTime" value="1" datatype="*" errormsg="请选择有限期限！">
				一年：<input type="radio" name="limitedTime" value="2"> 一年半：<input
				type="radio" name="limitedTime" value="3"> 两年：<input
				type="radio" name="limitedTime" value="4"> <span style="color: red;">*</span>
			</li>
			<li>项目标注： <select name="projectLabel">
					<option>一般</option>
					<option>重点</option>
			</select> <span style="color: red;">*</span>
			</li>
			<li>项目性质： <select name="projectNature">
					<option>鼓励型</option>
					<option>支持型</option>
					<option>培养型</option>
					<option>示范型</option>
			</select> <span style="color: red;">*</span>
			</li>
			<li>项目环保简述：<form:textarea cols="80" rows="10"
					path="releaseinfo.projectProtection" />
			</li>
			<li>投资者条件简述：<form:textarea cols="80" rows="10"
					path="releaseinfo.investorCondition" /></li>
			<li>项目所属单位：<input type="text" id="projectUnit"
				name="projectUnit" value="" datatype="/[a-zA-Z\u4E00-\u9FA5]+$/" errormsg="请输入中文或英文!"/> <span style="color: red;">*</span></li>
			<li>详细地址：<input type="text" id="address" name="address" value="" datatype="/[a-zA-Z\u4E00-\u9FA5]+$/" errormsg="请输入中文或英文!"> <span style="color: red;">*</span></li>
			<li>联系电话：<input type="text" id="phone" name="phone" value=""  datatype="/^\d{11}$/" errormsg="请输入11位数字!"/> <span style="color: red;">*</span></li>
			<li>联系邮箱：<input type="text" id="email" name="email" value="" datatype="e" errormsg="请输入正确的邮箱号码！"/> <span style="color: red;">*</span></li>
			<li>联系地址：<input type="text" id="address" name="address" value="" datatype="/[a-zA-Z\u4E00-\u9FA5]+$/" errormsg="请输入中文或英文"/> <span style="color: red;">*</span></li>
			<li>传真号码：<input type="text" id="faxNumber" name="faxNumber"
				value="" datatype="/^0\d{2,3}-\d{7,8}$/" errormsg="请输入正确的传真号"/> <span style="color: red;">*</span></li>
			<li><input type="submit" value="保存"> <a
				href="${pageContext.request.contextPath}/releaseinfo/findAll.do"><input
					type="button" value="返回"></a></li>
		</ul>
	</form>
</body>
</html>