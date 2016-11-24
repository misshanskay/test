<%--
  Created by IntelliJ IDEA.
  User: X201
  Date: 2016/8/29 0029
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <script src="${pageContext.request.contextPath}/laydate/laydate.js"></script>

    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/css/moment.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form role="form" action="/user/register.do">
    <div class="form-group">
        <label for="name">姓名</label>
        <input type="text" class="form-control-6" name="uname" id="name" placeholder="请输入姓名">
        <label id="namemessage"></label>

    </div>
    <div class="form-group">
        <label for="password">密码</label>
        <input type="password" class="form-control-6" name="upassword" id="password" placeholder="请输入密码">
    </div>
    <div class="form-group">
         <label for="password1">确认密码</label>
         <input type="password" class="form-control-6" id="password1" placeholder="请输入确认密码">
        <label id="passwordmessage"></label>
     </div>

     <div class="radio">
         <label>
             <input type="radio" name="usex" id="sex1" value="男" checked>男
         </label>
     </div>
     <div class="radio">
         <label>
             <input type="radio" name="usex" id="sex2" value="女">女
         </label>
     </div>
     <div class="form-group">
         <label for="age">年龄</label>
         <input type="text" class="form-control-6" name="uage" id="age" placeholder="请输入年龄">
     </div>
    <div class="form-group">
        <label for="email">邮箱地址</label>
        <input type="text" class="form-control-6" name="uemail" id="email" placeholder="请输入邮箱地址">
    </div>
    <div class="form-group">
        <label for="phone">手机号码</label>
        <input type="text" class="form-control-6" name="uphone" id="phone" placeholder="请输入手机号码">
    </div>
    <div class="form-group">
    <label>角色</label>

    <select class="form-control-6" name="urole">
        <option>管理员</option>
        <option>二级管理员</option>
        <option>三级管理员</option>
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
    <input type="text" class="form-control-6" name="urealname" id="real" placeholder="请输入真实姓名">
    </div>
    <div class="form-group">
        <label for="real">出生年月</label>
       <%-- <input class="laydate-icon" name="ubirthday" onclick="laydate()"><br /><br />--%>
        <input type="text" name="ubirthday" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});"
        />

    </div>
    <div class="form-group">
        <label>岗位</label>
        <select class="form-control-6" name="upost">
            <option>市长</option>
            <option>副市长</option>
            <option>党委书记</option>
            <option>局长</option>
            <option>处长</option>
            <option>科长</option>
            <option>科员</option>
        </select>
    </div>
    <div class="form-group">
        <label for="unit">就职单位</label>
        <input type="text" class="form-control-6" name="uunit" id="unit" placeholder="请输入就职单位">
    </div>
    <div class="form-group">
        <label for="card">身份证</label>
        <input type="text" class="form-control-6" name="ucard" id="card" placeholder="请输入身份证号">
    </div>
    <div class="form-group">
        <label>政治面貌</label>
        <select class="form-control-6" name="upolitical">
        <option>共青团员</option>
        <option>党员</option>
        <option>群众</option>
        </select>
    </div>
    <div class="form-group">
        <label for="graduation">毕业院校</label>
        <input type="text" class="form-control-6" name="ugraduation" id="graduation" placeholder="请输入毕业院校">
    </div>
    <div class="form-group">
        <label for="major">专业</label>
        <input type="text" class="form-control-6" name="umajor" id="major" placeholder="请输入专业">
    </div>
    <div class="form-group">
        <label for="introduction">个人描述</label>
        <textarea rows="3" name="uintroduction" class="form-control-6" id="introduction"></textarea>
    </div>

    <button type="submit" class="btn btn-default">登陆</button>
</form>

</body>
<script>
    ;!function(){
        laydate({
            elem: '#demo'
        })
    }();
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
