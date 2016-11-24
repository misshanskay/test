<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> <!-- springmvc的from标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- jstl标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息发布更新页面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
$(document).ready(
		function(){
			$("#provinceid").change(
				function (){
					var provincecode = jQuery("#provinceid option:selected").val();
					$.ajax({ 
						url: "${pageContext.request.contextPath}/releaseinfo/querycity.do",
						cache:false,
						data:"provincecode="+provincecode,//encodeURI(encodeURI(selValue)),
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
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/releaseinfo/update.do" id="frm" name="frm">
	项目名称：<input type="text"  id="title" name="title" value="${releaseinfo.projectName}"><br/>
	项目类型：<input type="text"  id="itemType" name="itemType" value="${releaseinfo.projectType}"><br/>
	合作方式： <select id="cooperationMode" name="cooperationMode">
				<c:if test="${releaseinfo.cooperationMode==1}">
				<option value="1">合资</option>
				<option value="2">独资</option>
				<option value="3">合作</option>
				</c:if>
				<c:if test="${releaseinfo.cooperationMode==2}">
				<option value="2">独资</option>
				<option value="1">合资</option>
				<option value="3">合作</option>
				</c:if>			
				<c:if test="${releaseinfo.cooperationMode==3}">
				<option value="3">合作</option>
				<option value="1">合资</option>
				<option value="2">独资</option>
				</c:if>
		   </select><br/>
	PPP项目融资方式：<select>
			<option>请选择</option>
			<option>BOT</option>
			<option>BOO</option>
			<option>BOOT</option>
			<option>BTO</option>
			<option>PPP</option>
	</select><br/>
	项目所属行业：<input type="text"  id="projectBusiness" name="projectBusiness" value="${releaseinfo.projectBusiness}"><br/>
	项目地区：
		<select id="provinceid" name="projectArea">
		<option>${releaseinfo.projectArea}</option>
		<c:forEach var="province" items="${plist}">
			<option value="${province.code}">${province.name}</option>
		</c:forEach>
	</select>
	--
	<select id="city" name="city">
		<option>${releaseinfo.city}</option>		
	</select><br/><br/>
	所属园区：<input type="text" name="parkArea" value="${releaseinfo.parkArea}"><br/><br/>
	项目详细地址：<input type="text" name="projectAddress" value="${releaseinfo.projectAddress}"><br/><br/>
	发布位置：
	<input name="releasePosition" type="checkbox" id="releasePosition" value="WEB" ${fn:containsIgnoreCase(releaseinfo.releasePosition,'WEB')?"checked":""}/>		
	<input name="releasePosition" type="checkbox" id="releasePosition" value="信息化大屏" ${fn:containsIgnoreCase(releaseinfo.releasePosition,'信息化大屏')?"checked":""}/>
	<input name="releasePosition" type="checkbox" id="releasePosition" value="自助终端机" ${fn:containsIgnoreCase(releaseinfo.releasePosition,'自助终端机')?"checked":""}/>		
	<input name="releasePosition" type="checkbox" id="releasePosition" value="APP" ${fn:containsIgnoreCase(releaseinfo.releasePosition,'APP')?"checked":""}/><br/>		
	投资总额：<input type="text"  id="fundBudget" name="fundBudget" value="${releaseinfo.fundBudget}"><br/>
	拟引投资总金额：<input type="text"  id="expectedReturn" name="expectedReturn" value="${releaseinfo.expectedReturn}"><br/>
	预计年销售收入：<input type="text"  id="fundBudget" name="fundBudget" value="${releaseinfo.fundBudget}"><br/>
	预计投资收回期：<input type="text"  id="expectedYear" name="expectedYear" value="${releaseinfo.expectedYear}"><br/>
	预计就业人数：<input type="text"  id="expectedPeople" name="expectedPeople" value="${releaseinfo.expectedPeople}"><br/>
	项目主要内容：<form:textarea path="releaseinfo.projectContent"/><br/><br/>
	项目主要优势：<form:textarea path="releaseinfo.projectAdvantage"/><br/><br/>
	有限期限：<input type="text"  id="limitedTime" name="limitedTime" value="${releaseinfo.limitedTime}"><br/>
	项目标注：<input type="text"  id="projectLabel" name="projectLabel" value="${releaseinfo.projectLabel}"><br/>
	项目性质：<input type="text"  id="projectNature" name="projectNature" value="${releaseinfo.projectNature}"><br/>
	项目环保简述：<input type="text"  id="projectProtection" name="projectProtection" value="${releaseinfo.projectProtection}"><br/>
	投资者条件简述：<input type="text"  id="investorCondition" name="investorCondition" value="${releaseinfo.investorCondition}"><br/>
	项目所属单位：<input type="text"  id="projectUnit" name="projectUnit" value="${releaseinfo.projectUnit}"><br/>
	详细地址：<input type="text"  id="address" name="address" value="${releaseinfo.address}"><br/>
	联系电话：<input type="text"  id="phone" name="phone" value="${releaseinfo.phone}"><br/>
	 联系邮箱：<input type="text"  id="email" name="email" value="${releaseinfo.email}"><br/>
	 联系地址：<input type="text"  id="address" name="address" value="${releaseinfo.address}"><br/>
	传真号码：<input type="text"  id="faxNumber" name="faxNumber" value="${releaseinfo.faxNumber}"><br/>
	<input type="hidden" id="id" name="id" value="${releaseinfo.id}">
    <input type="submit" value="更新"> <a href="${pageContext.request.contextPath}/releaseinfo/findAll.do"><input type="button" value="返回"></a>	
    </form>
</body>
</html>