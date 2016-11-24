<%--
  Created by IntelliJ IDEA.
  User: X201
  Date: 2016/8/31 0031
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/css/moment.js"></script>
</head>
<body>

<table id="table1" class="table">
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>操作</th>
    </tr>

    <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.uname}</td>
            <td>${list.uage}</td>
            <td>${list.usex}</td>
            <td>
                <a href="${pageContext.request.contextPath}/user/updata.do?uid=${list.uid}">修改</a>
                <button onclick="dele(${list.uid},${thispage})">删除</button>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td></td>
        <td>
            <button id="up" onclick="up(${thispage})">上一页</button>
            <button id="down" onclick="down(${thispage})">下一页</button>
            共${thispage}/${page1}页
        </td>
        <td></td>
    </tr>
</table>
</body>
<script>
    function up(thispage) {

        if(thispage!=0){
            thispage=thispage-1;
        }

        $.post("${pageContext.request.contextPath}/user/all.do",{
            thispage:thispage
        },function (data) {
            if(data.status==1){
                alert(data.msg)
            }
            var json = eval(data.json); //数组


            $("#table1  tr:not(:first)").html("");
            $.each(json, function (index) {
                //循环获取数据
                var name = json[index].uname;
                var age = json[index].uage;
                var sex = json[index].usex;

                var tr =  '<tr><td>'+name+'</td><td>'+age+'</td><td>'+sex+'</td><td><a href="${pageContext.request.contextPath}/user/updata.do?uid='+json[index].uid+'">修改</a><button onclick="dele('+json[index].uid+','+data.thispage+')">删除</button></td></tr>';
                $("#table1").append(tr);
            });
            var td='<tr><td></td><td><button id="up" onclick="up('+data.thispage+')">上一页</button><button id="down" onclick="down('+data.thispage+')">下一页</button>共'+(data.thispage+1)+'/'+data.page+'页</td><td></td></tr>';
            $("#table1").append(td);

        });

    }
    function down(thispage) {

        thispage=thispage+1;
        $.post("${pageContext.request.contextPath}/user/all.do",{
            thispage:thispage
        },function (data) {
            if(data.status==1){
                alert(data.msg)
            }
            var json = eval(data.json); //数组


            $("#table1  tr:not(:first)").html("");
            $.each(json, function (index) {
                //循环获取数据
                var name = json[index].uname;
                var age = json[index].uage;
                var sex = json[index].usex;

                var tr = '<tr><td>'+name+'</td><td>'+age+'</td><td>'+sex+'</td><td><a href="${pageContext.request.contextPath}/user/updata.do?uid='+json[index].uid+'">修改</a><button onclick="dele('+json[index].uid+','+data.thispage+')">删除</button></td></tr>';
                $("#table1").append(tr);
            });
            var td='<tr><td></td><td><button id="up" onclick="up('+data.thispage+')">上一页</button><button id="down" onclick="down('+data.thispage+')">下一页</button>共'+(data.thispage+1)+'/'+data.page+'页</td><td></td></tr>';
            $("#table1").append(td);

        });

    }
    function dele(uid,thispage) {

        $.post("${pageContext.request.contextPath}/user/dele.do",{
            uid:uid,
            thispage:thispage
        },function (data) {

            down((data-1))

        });

    }
</script>
</html>
