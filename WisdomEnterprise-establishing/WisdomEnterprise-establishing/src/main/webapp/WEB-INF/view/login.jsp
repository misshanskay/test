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
<img src="${pageContext.request.contextPath}/${imgsrc}" width="234px" height="60px">
<form role="form" action="../j_spring_security_check" method="post" onsubmit="return chec()">
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
    记住我<input type="checkbox" name="_spring_security_remember_me">
    <button type="submit" class="btn btn-default">登录</button>
</form>
<input type="button" onclick="password()" value="忘记密码"/><br>
技术支持：市县招商网 <br>
<label>${base }</label>

</body>
<script>
/*  $(document).ready(function(){
	
	var uname=document.cookie.split(";")[0].split("=")[1];
	var upassword=document.cookie.split(";")[1].split("=")[1];
	$.post("${pageContext.request.contextPath}/user/login1.do",{
		uname:uname,
		upassword:upassword
	},function(data){
		if(data.status==200){
			
			 window.location.href="${pageContext.request.contextPath}/user/index.do";
		}
	})
	
}); */ 

    function chec() {
        $("#name").val($("#name").val()+","+$("#role  option:selected").val())
        return true;
    } 
    function password(){
    	var uname=$("#name").val()
    	alert(uname)
    	if(uname==null){
    		alert("请输入用户名！")
    	}else{
    		if(confirm("你确定找回密码吗?")){
    			alert(1111)
    			$.post("${pageContext.request.contextPath}/user/find.do",{
    				uname:uname
    				
    			},function(data){
    				if(data.status==200){
    					alert("新密码已发送你的邮箱！");
    					
    				}
    			})
    		}
    		
    	}
    	 
    }
</script>
</html>
