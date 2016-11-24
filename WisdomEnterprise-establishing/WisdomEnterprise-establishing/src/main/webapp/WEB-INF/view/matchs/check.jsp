<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看页面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
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
	
	function check(id){
		show("win2");
		show("win");
		$.ajax({
			url: "${pageContext.request.contextPath}/matchs/watch.do",
			cache:false,
			data:"id="+id,
			dataType:"json",
			type:"post",
			success:function(data){
				if(data==1){
					alert("余额不足！请充值！");
				}else{
		           var htmls = "<table>";	          
	                htmls += "<tr><td>"+"项目所属单位:"+data[0]+"</td></tr><tr><td>"+"详细地址:"+data[1]+"</td></tr>"+
	                "<tr><td>"+"联系人:"+data[2]+"</td></tr><tr><td>"+"联系电话:"+data[3]+"</tr></td><tr><td>"
	                +"联系邮箱："+data[4]+"</td></tr><tr><td>"+"联系传真号码:"+data[5]+"</td></tr>";	      
	            htmls += "</table>";	          
	            document.getElementById("win1").innerHTML=htmls;	
				}
	           
			}
		})
	}
</script>
<style type="text/css">
	#win {
		position:absolute;
		top:80%;
		left:50%;
		width:400px;
		height:400px;
		background:#fff;
		margin:102px 0 0 -202px;
		/* line-height: 200px; */
		text-align: center;
		border: 4px solid #CCC;
		display: none;
		font-size: 25px;
		}
</style>
</head>
<body>
<form action="">
	<div style="margin-left:80px;width:800px;height:50px;border:1px solid red;text-align:center;margin-top: 50px">
		<tr>
			<td><font size="6px">${matchs.projectName}</font></td>
		</tr>
	</div>
	<hr/>
	<div style="margin-left:80px;width:800px;height:50px;border:1px solid red;text-align:center;margin-top: 30px">
		<tr>
			<td>发布者：${matchs.issuer}</td>
			<td>发布时间:<fmt:formatDate value="${matchs.issueTime}" pattern="yyyy-MM-dd"/></td>
		</tr>
	</div>
	<div style="margin-left:80px;width:800px;height:300px;border:1px solid red;text-align:center;margin-top: 30px">
		<tr style="width: 800px">
			<td>基本信息</td>
		</tr>
		<tr>
			<td>项目名称：${matchs.projectName}</td>
		</tr>
		<tr>
			<td>项目类型：${matchs.projectFinancingMode}</td>
		</tr>
		<tr>
			<td>合作模式：${matchs.cooperationMode}</td>
		</tr>
		<tr>
			<td>项目所属行业：${matchs.projectBusiness}</td>
		</tr>
		<tr>
			<td>项目地区：${matchs.projectArea}</td>
		</tr>
	</div>
	<div style="margin-left:80px;width:800px;height:50px;border:1px solid red;text-align:center;margin-top: 30px">
		<tr>
			<td>资金预算</td>
			<td>投资总额${matchs.fundBudget}万元</td>
		</tr>
	</div>
	<div style="margin-left:80px;width:800px;height:300px;border:1px solid red;text-align:center;margin-top: 30px">
		<tr>
			<td>项目主要内容</td>
			<td>项目主要内容：${matchs.projectContent}</td>
		</tr>
	</div>
	<c:if test="${status==2}">
	<div style="margin-left:80px;width:800px;height:220px;border:1px solid red;text-align:center;margin-top: 30px">
		<div id="win2" style="display: block;">
			<tr>
				<td >项目联系信息</td>
				<td><input type="button" value="查看联系方式" onclick="show('win')"></td>
			</tr>
		</div>
		<div id="win1" class="win1">
		</div>
	</div>
	</c:if>
		<c:if test="${status !=null && status==1}">
	<div style="margin-left:80px;width:800px;height:220px;border:1px solid red;text-align:center;margin-top: 30px">
				<tr><td>项目所属单位：${matchs.projectUnit}</td></tr>
				<tr><td>详细地址：${matchs.address}</td></tr>
				<tr><td>联系人：${matchs.linkman}</td></tr>
				<tr><td>联系电话：${matchs.phone}</td></tr>
				<tr><td>联系邮箱：${matchs.email}</td></tr>
				<tr><td>传真号码：${matchs.faxNumber}</td></tr>		
	</div>
	</c:if>
	<div id="win" class="win">
		<tr>
			<td>${matchs.projectName}</td>
		</tr>
		<hr/>
		<tr>
			<td>所需招商币：50 币</td>
			<td>当前余额：
				<c:if test="${balance !=null}">
					${balance}
				</c:if>
			</td>
		</tr><br><br>
		<tr>
			<td><input type="button" value="确认支付" onclick="check('${matchs.id}')"></td>
			<td><a href="跳转充值页面"><input type="button" value="充值"></a></td>
		</tr>
		<hr/>
		<tr>
			<td>说明： 1招商币=人民币</td>
		</tr><br/><br/>
		<tr>
			<input type="button" value="取消" onclick="show('win')">
		</tr>
	</div>
	<div style="margin-left:80px;width:800px;height:50px;border:1px solid red;text-align:center;margin-top: 30px">
		<a href="${pageContext.request.contextPath}/matchs/findAll.do"><input type="button" value="返回"></a>
	</div>
</form>
</body>
</html>