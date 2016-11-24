<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>订单查询</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>

    <script type="text/javascript">
    
    function allorder() {
		window.location.href="${pageContext.request.contextPath}/order/list.do"
	}
    function notorder() {
        window.location.href="${pageContext.request.contextPath}/order/list1.do"
    }
    function todayorder() {
        window.location.href="${pageContext.request.contextPath}/order/list2.do"
    }
    
    </script>

</head>
<body>

<button onclick="allorder()">所有订单</button>
<button onclick="notorder()">未付款订单</button>
<button onclick="seachorder()">订单查询</button>
<button onclick="todayorder()">今日订单</button>
<form action="${pageContext.request.contextPath}/order/seachorder.do" method="post">
<div class="form-group">
        <label>用户名</label>
        <input type="text" class="form-control-6" name="uname" placeholder="请输入用户名">
        
    </div>
<div class="form-group">
        <label>订单金额</label>
        <input type="text" class="form-control-6" name="money1">
        <label>到</label>
        <input type="text" class="form-control-6" name="money2">
        
    </div>
<div class="form-group">
        <label>产品类型</label>
        <select class="form-control-6" name="type">
        
        <option value="">--请选择--</option>
        <option>项目信息</option>
        
        
    </select>
        
    </div>
    <div class="form-group">
        <label>订单编号</label>
        <input type="text" class="form-control-6" name="orderid" placeholder="请输入订单编号">
        
    </div>
    <div class="form-group">
        <label>付款状态</label>
        <select class="form-control-6" name="status">
    
        <option value="">所有</option>
        <option value="1">已付款</option>
        <option value="0">未付款</option>
        
        
    </select>
        
    </div>
    
    <button type="submit" class="btn btn-default">查找</button>
    </form>
</body>
<script type="text/javascript">

</script>
</html>