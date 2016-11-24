<%--
  Created by IntelliJ IDEA.
  User: X201
  Date: 2016/8/30 0030
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>修改</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <script src="${pageContext.request.contextPath}/laydate/laydate.js"></script>

    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/css/moment.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form id="form">
    <input type="hidden" name="uid" value="${userU.uid}">
    <div class="form-group">
        <label for="name">姓名</label>
        <input type="text" class="form-control-6" name="uname" id="name" value="${userU.uname}">
        <label id="namemessage"></label>

    </div>
    <div class="form-group">
        <label for="password">密码</label>
        <input type="password" class="form-control-6" name="upassword" id="password" value="${userU.upassword}">
    </div>
    <div class="form-group">
        <label for="password1">确认密码</label>
        <input type="password" class="form-control-6" id="password1" value="${userU.upassword}">
        <label id="passwordmessage"></label>
    </div>

    <div class="radio">
        <label>

            <input type="radio" name="usex" id="sex1" value="男" <c:if test="${userU.usex=='男'}">checked</c:if>>男
        </label>
    </div>
    <div class="radio">
        <label>
            <input type="radio" name="usex" id="sex2" value="女" <c:if test="${userU.usex=='女'}">checked</c:if>>女
        </label>
    </div>
    <div class="form-group">
        <label for="age">年龄</label>
        <input type="text" class="form-control-6" name="uage" id="age" value="${userU.uage}">
    </div>
    <div class="form-group">
        <label for="email">邮箱地址</label>
        <input type="text" class="form-control-6" name="uemail" id="email" value="${userU.uemail}">
    </div>
    <div class="form-group">
        <label for="phone">手机号码</label>
        <input type="text" class="form-control-6" name="uphone" id="phone" value="${userU.uphone}">
    </div>
    <div class="form-group">
        <label>角色</label>

        <select class="form-control-6" name="urole">
            <option <c:if test="${userU.urole=='管理员'}">selected</c:if>>管理员</option>
            <option <c:if test="${userU.urole=='二级管理员'}">selected</c:if>>二级管理员</option>
            <option <c:if test="${userU.urole=='三级管理员'}">selected</c:if>>三级管理员</option>
        </select>
    </div>
    <div class="form-group">
        <label>权限</label>

        <div class="checkbox">
            <label><input type="checkbox" name="power" value="审核企业信息"/>审核企业信息</label>
            <label><input type="checkbox" name="power" value="审核招商信息"/>审核招商信息</label>
            <label><input type="checkbox" name="power" value="审核招商信息"/>发布招商信息</label>
            <label><input type="checkbox" name="power" value="审核招商信息"/>会员列表</label>
            <label><input type="checkbox" name="power" value="审核招商信息"/>会员添加</label>
            <label><input type="checkbox" name="power" value="审核招商信息"/>会员查询</label>
            <label><input type="checkbox" name="power" value="审核招商信息"/>会员删除</label>
            <label><input type="checkbox" name="power" value="审核招商信息"/>企业信息下载</label>
            <label><input type="checkbox" name="power" value="审核招商信息"/>发送报告</label>
            <label><input type="checkbox" name="power" value="审核招商信息"/>添加路演设备</label>
            <label><input type="checkbox" name="power" value="审核招商信息"/>编辑路演设备</label>
        </div>


    </div>
    <div class="form-group">
        <label for="real">真实姓名</label>
        <input type="text" class="form-control-6" name="urealname" id="real" value="${userU.urealname}">
    </div>
    <div class="form-group">
        <label for="real">出生年月</label>
        <input type="text" name="ubirthday" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'});"
        />


    </div>
    <div class="form-group">
        <label>岗位</label>
        <select class="form-control-6" name="upost">
            <option <c:if test="${userU.upost=='市长'}">selected</c:if>>市长</option>
            <option <c:if test="${userU.upost=='副市长'}">selected</c:if>>副市长</option>
            <option <c:if test="${userU.upost=='党委书记'}">selected</c:if>>党委书记</option>
            <option <c:if test="${userU.upost=='局长'}">selected</c:if>>局长</option>
            <option <c:if test="${userU.upost=='处长'}">selected</c:if>>处长</option>
            <option <c:if test="${userU.upost=='科长'}">selected</c:if>>科长</option>
            <option <c:if test="${userU.upost=='科员'}">selected</c:if>>科员</option>
        </select>
    </div>
    <div class="form-group">
        <label for="unit">就职单位</label>
        <input type="text" class="form-control-6" name="uunit" id="unit" value="${userU.uunit}">
    </div>
    <div class="form-group">
        <label for="card">身份证</label>
        <input type="text" class="form-control-6" name="ucard" id="card" value="${userU.ucard}">
    </div>
    <div class="form-group">
        <label>政治面貌</label>
        <select class="form-control-6" name="upolitical">
            <option <c:if test="${userU.upolitical=='共青团员'}">selected</c:if>>共青团员</option>
            <option <c:if test="${userU.upolitical=='党员'}">selected</c:if>>党员</option>
            <option <c:if test="${userU.upolitical=='群众'}">selected</c:if>>群众</option>
        </select>
    </div>
    <div class="form-group">
        <label for="graduation">毕业院校</label>
        <input type="text" class="form-control-6" name="ugraduation" id="graduation" value="${userU.ugraduation}">
    </div>
    <div class="form-group">
        <label for="major">专业</label>
        <input type="text" class="form-control-6" name="umajor" id="major" value="${userU.umajor}">
    </div>
    <div class="form-group">
        <label for="introduction">个人描述</label>
        <textarea rows="3" name="uintroduction" class="form-control-6" id="introduction">${userU.uintroduction}</textarea>
    </div>


</form>
<button class="btn btn-default" onclick="upu()">修改</button>
</body>
<script>
    function upu() {
        var form1=$("#form").serialize()
        $.post("${pageContext.request.contextPath}/user/upu.do",
            form1



        ,function (data) {
            window.location.href="${pageContext.request.contextPath}/user/list.do";
        })

    }
    $("#name").change(function(){
        $.post("${pageContext.request.contextPath}/user/aj.do",
                {
                    uname:$(this).val()

                },
                function(data){
                    if(data=="success"){
                        $("#namemessage").html("");
                    }else{
                        $("#namemessage").html("用户已存在！");
                    }

                });
    });
    $("#password1").change(function(){
        if($("#password").val()==$("#password1").val()){
            $("#passwordmessage").html("");
        }else{

            $("#passwordmessage").html("两次密码不一致！");
        }

    })
    $("#password").change(function(){
        if($("#password").val()==$("#password1").val()){
            $("#passwordmessage").html("");
        }else{

            $("#passwordmessage").html("两次密码不一致！");
        }

    })
</script>
</html>
