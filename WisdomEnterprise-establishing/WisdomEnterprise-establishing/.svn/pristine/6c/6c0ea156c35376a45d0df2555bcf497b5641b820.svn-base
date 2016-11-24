<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>角色列表</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/list.do">用户列表</a>
<a href="${pageContext.request.contextPath}/part/addpart.do">添加角色</a>
<table id="table1" class="table">
    <tr>
        <th >编号</th>
        <th >角色名</th>
        
        <th >编辑</th>
    </tr>

     <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.pid}</td>
            <td>${list.pname}</td>
            
            <td>
                <a href="${pageContext.request.contextPath}/part/updata.do?pid=${list.pid}">修改</a>
                <button onclick="dele(${list.pid})">删除</button>
            </td>
        </tr>
    </c:forEach>
    
</table>

</body>
</html>