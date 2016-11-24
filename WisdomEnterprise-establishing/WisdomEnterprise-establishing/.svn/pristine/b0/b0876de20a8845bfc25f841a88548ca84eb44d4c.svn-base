<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>财务统计查询</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<style type="text/css">
li {list-style-type:none;}
</style>
</head>
<body style="align: center;">
<form action="${pageContext.request.contextPath}/booked/find.do" id="frm">
	<div style="margin-top:50px; width:800px; border:1px solid #F00; margin-left: 200px">
			<ul>
				<li>用户名：<input type="text" id="username" name="username"  placeholder="请输入用户名"></li>
				<li>  记账时间：<input type="text" id="deal1" name="createtimeone" placeholder="记账时间"/>
			 -<input type="text" id="deal2" name="createtimetwo" placeholder="记账时间"></li>
				<li>付款方式：
					<select name="way">
						<option>请选择</option>
						<option>支付宝</option>
						<option>微信</option>
						<option>工商银行</option>
						<option>交通银行</option>
						<option>中国银行</option>
						<option>农业银行</option>
					</select>
				</li>
			</ul>
      	  	<input type="submit" value="查找">
     </div>
</form>

</body>
</html>