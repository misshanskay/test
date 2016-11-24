<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>订单列表</title>
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
    function seachorder() {
        window.location.href="${pageContext.request.contextPath}/order/seach.do"
    }
    </script>

</head>
<body>
<input type="hidden" id="status" value="${sta }">
<button onclick="allorder()">所有订单</button>
<button onclick="notorder()">未付款订单</button>
<button onclick="seachorder()">订单查询</button>
<button onclick="todayorder()">今日订单</button>
<table class="table">
<tr>
<td>序号</td>
<td>订单号</td>
<td>会员名</td>
<td>发生额</td>
<td>产品类型</td>
<td>状态</td>
<td>时间</td>
<td>操作</td>
</tr>
<c:forEach var="list" items="${page.list}" varStatus="st">
        <tr><td>${st.index+1 }
        </td>
            <td>${list.orderid}</td>
            <td>${list.uname}</td>
            <td>${list.money}</td>
            <td>${list.type}</td>
            <td><c:if test="${list.status==1}"><span style="color:green">已付款</span></c:if><c:if test="${list.status==0}"><span style="color:red">未付款</span></c:if></td>
            <td><fmt:formatDate value="${list.updatetime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            
            <td><c:if test="${list.status==1}"><input type="button" style="color:green" value="查看详情" onclick="ddd(${list.mid},${list.status })"></c:if><c:if test="${list.status==0}"><input type="button" style="color:red" value="付款"></c:if></td>
            
            
        </tr>
    </c:forEach>
    <c:if test="${sta!=100 }">
    <tr>
        <td></td>
        <td>
            <input type="button" value="上一页" onclick="up(${page.pageNum})">
            <input type="button" value="下一页 " onclick="down(${page.pageNum},${page.pages })">
            共${thispage}/${page.pages}页
        </td>
        <td></td>
    </tr>
    
    </c:if>
    
    </table>
<input type="hidden" id="orderid" name="orderid" value="${uorder.orderid }"> 
   <input type="hidden" id="type" name="type" value="${uorder.type}"> 
   <input type="hidden" id="uname" name="uname" value="${uorder.uname}"> 
   <input type="hidden" id="status1" name="status" value="${uorder.status}"> 
   <input type="hidden" id="money1" name="money1" value="${money1}"> 
   <input type="hidden" id="money2" name="money2" value="${money2}"> 

</body>
<script type="text/javascript">

function ddd(mid ,status) {
	
             window.location.href="${pageContext.request.contextPath}/matchs/checks.do?id="+mid+"&status="+status;
}


function down(thispage,page) {
	
    if(thispage!=page&&thispage!=0){
        if($("#status").val()==0){
             window.location.href="${pageContext.request.contextPath}/order/list.do?thispage="+(thispage+1);
         }else if($("#status").val()==1){
             window.location.href="${pageContext.request.contextPath}/order/list1.do?thispage="+(thispage+1);
         }else if($("#status").val()==2){
             window.location.href="${pageContext.request.contextPath}/order/list2.do?thispage="+(thispage+1);
         }else{
             window.location.href="${pageContext.request.contextPath}/order/seachorder.do?thispage="+(thispage+1)+"&orderid="+$("#orderid").val()+"&type="+$("#type").val()+"&status"+$("#status1").val()+"&uname="+$("#uname").val()+"&money1="+$("#money1").val()+"&money2="+$("#money2").val();
        	 
         }
    }
 
}
function up(thispage) {
    if(thispage!=1&&thispage!=0){
        if($("#status").val()==0){
             window.location.href="${pageContext.request.contextPath}/order/list.do?thispage="+(thispage-1);
         }else if($("#status").val()==1){
             window.location.href="${pageContext.request.contextPath}/order/alllist1.do?thispage="+(thispage-1);
         }else if($("#status").val()==2){
             window.location.href="${pageContext.request.contextPath}/order/alllist2.do?thispage="+(thispage-1);
         }else{
             window.location.href="${pageContext.request.contextPath}/order/seachorder.do?thispage="+(thispage-1)+"&orderid="+$("#orderid").val()+"&type="+$("#type").val()+"&status"+$("#status1").val()+"&uname="+$("#uname").val()+"&money1="+$("#money1").val()+"&money2="+$("#money2").val();
        	 
         }
    }
     
 }
</script>
</html>