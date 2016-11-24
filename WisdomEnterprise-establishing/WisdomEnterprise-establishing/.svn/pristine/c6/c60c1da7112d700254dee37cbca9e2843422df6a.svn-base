<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> <!-- springmvc的from标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- jstl标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>发布信息更新页面</title>
<link href= "${pageContext.request.contextPath}/css/basestyle.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Validform_v5.3.2.js"></script>
<script type="text/javascript">
		$(document).ready(
				function(){
					$("#provinceid").change(
						function (){
							var provincename = jQuery("#provinceid option:selected").val();
							$.ajax({ 
								url: "${pageContext.request.contextPath}/getcityandarea/querycity.do",
								cache:false,
								data:"provinceName="+provincename,//encodeURI(encodeURI(selValue)),
								dataType:"json",
								type:"post",
								success: function(data){
						       var ln= $("#city option").size();	
						       $("#city").empty(); 
								/* while(ln > 1){
									document.getElementById("city").remove(document.getElementById("city").options.length - 1);						
									 --ln; 
									} */
									$("#city").append("<option>"+"全部"+"</option>"); 
								for(var i =0; i < data.length; i++){
									$("#city").append("<option value="+data[i].name+">"+data[i].name+"</option>"); 
									}
						      }});
						}		
					)
				}	  
			  )
	  
	  $(document).ready(
		function(){
			$("#city").change(
				function (){
					var cityName = jQuery("#city option:selected").val();
					$.ajax({ 
						url: "${pageContext.request.contextPath}/getcityandarea/queryarea.do",
						cache:false,
						data:"cityName="+cityName,//encodeURI(encodeURI(selValue)),
						dataType:"json",
						type:"post",
						success: function(data){
				       var ln= $("#area option").size();	
				       $("#area").empty(); 
						/* while(ln > 1){
							document.getElementById("city").remove(document.getElementById("city").options.length - 1);						
							 --ln; 
							} */
							$("#area").append("<option>"+"全部"+"</option>"); 
						for(var i =0; i < data.length; i++){
							$("#area").append("<option value="+data[i].name+">"+data[i].name+"</option>"); 
							}
				      }});
				}		
			)
		}	  
	  )
</script>
<style>
li {list-style-type:none;}
</style>
<script type="text/javascript">
$(function(){
	//$(".registerform").Validform(); 
  	 var demo=$(".registerform").Validform({//指明是哪一表单需要验证,名称需加在form表单上;
		tiptype:3,
		showAllError:true,
	});   
  	
})
</script>
</head>
<body>
 <form  class="registerform" action="${pageContext.request.contextPath}/matchs/edit.do" id="frm" name="frm" method="get">
	<ul>
		<li>项目发布人：${matchs.issuer}</li>
		<li>项目发布时间：<input type="text"  id="issuetime" name="issuetime" value='<fmt:formatDate value="${matchs.issueTime}" pattern="yyyy-MM-dd"/>'></li>
		<li>项目名称：<input type="text" id="projectName" name="projectName" value="${matchs.projectName}" datatype="/[a-zA-Z\u4E00-\u9FA5]+$/" errormsg="请输入中文或英文"/><div class="Validform_checktip"></div></li>
		<li>企业名称：${matchs.companyName}</li>
		<li>项目类型：<select name="projectFinancingMode">
						<option>${matchs.projectFinancingMode}</option>
						<c:forEach var="pfm" items="${map.type}">
							<option>${pfm}</option>
						</c:forEach>
				</select>
		</li>
		<li>合作模式： <select id="cooperationMode" name="cooperationMode">
				<c:if test="${matchs.cooperationMode=='1'}">
				<option value='1' >合资</option>
				<option value='2'>独资</option>
				<option value='3'>合作</option>
				</c:if>
				<c:if test="${matchs.cooperationMode=='2'}">
				<option value='2'>独资</option>
				<option value='1'>合资</option>
				<option value='3'>合作</option>
				</c:if>			
				<c:if test="${matchs.cooperationMode=='3'}">
				<option value='3'>合作</option>
				<option value='1'>合资</option>
				<option value='2'>独资</option>
				</c:if>
		   </select>
		 </li>
		<li>项目所属行业：<input type="text"  id="projectBusiness" name="projectBusiness" value="${matchs.projectBusiness}"></li>
		<li>项目地区：
				<select id="provinceid" name="projectArea">
					<option>${matchs.projectArea}</option>
					<c:forEach var="province" items="${plist}">
						<option value="${province.name}">${province.name}</option>
					</c:forEach>
				</select>
				--
				<select id="city" name="city">
					<option value="${matchs.city}">${matchs.city}</option>		
				</select>
				--
				<select id="area" name="area">
					<option value="${matchs.area}">${matchs.area}</option>		
				</select><input type="text" id="detailAddress" name="detailAddress" value="${matchs.detailAddress}"></li>
		<li>投资总额：<input type="text"  id="fundBudget" name="fundBudget" value="${matchs.fundBudget}" datatype="n" errormsg="请输入数字！"/>
				<select name=" Money">
					<option>${matchs.money}</option>
					<option value="人民币">人民币</option>
					<option value="美元">欧元</option>
					<option value="欧元">欧元</option>
					<option value="港币">港币</option>
				</select>
		</li>
		<li>匹配度：${matchs.matchDegree}</li>
		<li>项目主要内容：<form:textarea cols="50" rows="10" path="matchs.projectContent"/></li>
		<li>项目所属单位：<input type="text"  id="projectUnit" name="projectUnit" value="${matchs.projectUnit}" datatype="/[a-zA-Z\u4E00-\u9FA5]+$/" errormsg="请输入中文或英文"/></li>
		<li>联系人：<input type="text"  id="linkman" name="linkman" value="${matchs.linkman}"></li>
		<li>手机号码：<input  type="text"  id="phone" name="Phone" value="${matchs.phone}" datatype="/^1\d{10}$/" errormsg="请输入11位数字！"/></li>
		<li>座机号码：<input  type="text"  id="telephone" name="telephone" value="${matchs.telephone}" datatype="/((0\d{2,3})-)(\d{7,8})(-(\d{3,}))*$/" errormsg="请输入正确的座机号"/></li>
		<li> 联系邮箱：<input type="text"  id="email" name="email" value="${matchs.email}" datatype="e" errormsg="请输入正确的邮箱号码！"/></li>
		<li> 联系地址：<input type="text"  id="address" name="address" value="${matchs.address}"></li>
		<li>传真号码：<input type="text"  id="faxNumber" name="faxNumber" value="${matchs.faxNumber}" datatype="/^0\d{2,3}-\d{7,8}$/" errormsg="请输入正确的传真号"/></li>
	</ul>		
	<input type="hidden" id="id" name="id" value="${matchs.id}">
    <input type="submit" class="inputon" value="更新"/> <a href="${pageContext.request.contextPath}/matchs/findAll.do"><input type="button" value="返回"></a>	
    </form>
</body>
</html>