<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>角色修改</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<form role="form" action="${pageContext.request.contextPath }/part/updatap.do" method="post">
    <div class="form-group">
        <label for="name">修改角色 </label>
        
    </div>
    <hr>
    <div class="form-group">
        <label for="name">角色名称 </label>
        <input type="text" class="form-control-6" name="pname" id="name" value="${part.pname }">
        <label id="namemessage"></label>
    </div>


        <input type="hidden"name="pid" id="pid" value="${part.pid }">
    

   
        <div class="form-group">
        <label>权限</label>
 
        <div class="checkbox">
        <table>
        <tr>
            <td><label><input type="checkbox" name="power" value="审核企业信息" <c:forEach var="list" items="${list}">
 <c:if test="${list=='审核企业信息' }">checked</c:if>
 </c:forEach>/>审核企业信息</label></td>
            <td><label><input type="checkbox" name="power" value="审核招商信息" <c:forEach var="list" items="${list}">
 <c:if test="${list=='审核招商信息' }">checked</c:if>
 </c:forEach>/>审核招商信息</label></td>
           <td><label><input type="checkbox" name="power" value="发布招商信息" <c:forEach var="list" items="${list}">
 <c:if test="${list=='发布招商信息' }">checked</c:if>
 </c:forEach>/>发布招商信息</label></td>
            <td><label><input type="checkbox" name="power" value="会员列表" <c:forEach var="list" items="${list}">
 <c:if test="${list=='会员列表' }">checked</c:if>
 </c:forEach>/>会员列表</label></td>
            <td><label><input type="checkbox" name="power" value="会员添加" <c:forEach var="list" items="${list}">
 <c:if test="${list=='会员添加' }">checked</c:if>
 </c:forEach>/>会员添加</label></td>
            <td><label><input type="checkbox" name="power" value="会员查询" <c:forEach var="list" items="${list}">
 <c:if test="${list=='会员查询' }">checked</c:if>
 </c:forEach>/>会员查询</label></td>
		</tr>
		<tr>
            <td><label><input type="checkbox" name="power" value="会员删除" <c:forEach var="list" items="${list}">
 <c:if test="${list=='会员删除' }">checked</c:if>
 </c:forEach>/>会员删除</label></td>
            <td><label><input type="checkbox" name="power" value="企业信息下载" <c:forEach var="list" items="${list}">
 <c:if test="${list=='企业信息下载' }">checked</c:if>
 </c:forEach>/>企业信息下载</label></td>
            <td><label><input type="checkbox" name="power" value="发送报告" <c:forEach var="list" items="${list}">
 <c:if test="${list=='发送报告' }">checked</c:if>
 </c:forEach>/>发送报告</label></td>
            <td><label><input type="checkbox" name="power" value="添加路演设备" <c:forEach var="list" items="${list}">
 <c:if test="${list=='添加路演设备' }">checked</c:if>
 </c:forEach>/>添加路演设备</label></td>
            <td><label><input type="checkbox" name="power" value="编辑路演设备" <c:forEach var="list" items="${list}">
 <c:if test="${list=='编辑路演设备' }">checked</c:if>
 </c:forEach>/>编辑路演设备</label></td>
        </tr>
        </table>
        </div>


    </div>
    <button type="submit" class="btn btn-default">添加角色</button>
    <a href="${pageContext.request.contextPath }/part/rack.do">取消</a>
</form>
</body>
<script type="text/javascript">
	$("#name").change(function(){
	    $.post("${pageContext.request.contextPath}/part/aj.do",
	            {
	                pname:$(this).val()
	
	            },
	            function(data){
	                if(data=="success"){
	                    $("#namemessage").html("");
	                }else{
	                    $("#namemessage").html("角色已存在！");
	                }
	
	            });
	});
	
</script>
</html>