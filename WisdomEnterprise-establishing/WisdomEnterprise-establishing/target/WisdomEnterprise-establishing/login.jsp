<%--
  Created by IntelliJ IDEA.
  User: X201
  Date: 2016/9/1 0001
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form role="form" action="j_spring_security_check" method="post">
    <div class="form-group">
        <label for="name">姓名</label>
        <input type="text" class="form-control" name="j_username" id="name" placeholder="请输入姓名" value="${userU.uname}">
        <label id="message">${message}</label>

    </div>
    <div class="form-group">
        <label for="password">密码</label>
        <input type="password" class="form-control" name="j_password" id="password" placeholder="请输入密码">
    </div>


    <button type="submit" class="btn btn-default">登陆</button>
</form>
</body>
</html>
