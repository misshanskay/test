<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
欢迎用户：${userU.uname}
 <a href="${pageContext.request.contextPath}/user/list.do">用户列表</a>
</body>
</html>