<%--
  Created by IntelliJ IDEA.
  User: X201
  Date: 2016/8/26 0026
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</head>
<body>
<form role="form" action="j_spring_security_check" method="post" onsubmit="return chec()">
    <div class="form-group">
        <label for="name">姓名</label>
        <input type="text" class="form-control" name="j_username" id="name" placeholder="请输入姓名" value="${userU.uname}">
        <label id="message">${message}</label>

    </div>
    <div class="form-group">
        <label for="password">密码</label>
        <input type="password" class="form-control" name="j_password" id="password" placeholder="请输入密码">
    </div>
    <div class="form-group">
        <label>身份</label>

        <select class="form-control-6" id="role">
            <option value="government">政府用户</option>
            <option value="enterprise">企业用户</option>
        </select>
    </div>

    <button type="submit" class="btn btn-default">登陆</button>
</form>
</body>
<script>
   function chec() {

        $("#name").val($("#name").val()+","+$("#role  option:selected").val())
        return true;
    }
</script>
</html>
