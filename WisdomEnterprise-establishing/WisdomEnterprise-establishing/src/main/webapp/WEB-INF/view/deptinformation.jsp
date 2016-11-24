<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>
</head>
<body>

<table class="table">
<tr>
        <th >用户名</th>
        <th >真实姓名</th>
        <th >就职单位</th>
        <th >职务</th>
        <th >编辑</th>
    </tr>

    <c:forEach var="list" items="${page.list}">
        <tr>
            <td>${list.uname}</td>
            <td>${list.userExtend.urealname}</td>
            <td>${list.userExtend.uunit}</td>
            <td>${list.userExtend.upost}</td>
            <td>
                <a href="${pageContext.request.contextPath}/user/updata.do?uid=${list.uid}">修改</a>
                <button onclick="dele(${list.uid},${page.pageNum})">删除</button>
            </td>
        </tr>
    </c:forEach>
    <tr><td>  共${page.pageNum}/${page.pages}页 </td>
    </tr>
    </table>
</body>
<script type="text/javascript">
function down(thispage,page,id) {
    
    if(thispage!=page&&thispage!=0){
        
             window.location.href="${pageContext.request.contextPath}/user/deptinformation.do?thispage="+(thispage+1)+"&id="+id;
             
         
    }
 
}
function up(thispage,id) {
    if(thispage!=1&&thispage!=0){
        
             window.location.href="${pageContext.request.contextPath}/user/deptinformation.do?thispage="+(thispage-1)+"&id="+id;
             
        
    }
     
 }
</script>
</html>