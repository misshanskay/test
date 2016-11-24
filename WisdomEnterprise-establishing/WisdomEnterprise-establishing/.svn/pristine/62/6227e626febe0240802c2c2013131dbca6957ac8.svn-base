<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>角色添加</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<form role="form" action="${pageContext.request.contextPath }/part/addp.do" method="post">
    <div class="form-group">
        <label for="name">添加角色 </label>
        
    </div>
    <hr>
    <div class="form-group">
        <label for="name">角色名称 </label>
        <input type="text" class="form-control-6" name="pname" id="name" placeholder="请输入角色名">
        <label id="namemessage"></label>
    </div>
    <div class="form-group">
        <label for="name">角色编号</label>
        <input type="text" class="form-control-6" name="pid" id="pid" placeholder="请输入编号">
        <label id="idmessage"></label>
    </div>
   
        <div class="form-group">
        <label>权限</label>

        <div class="checkbox">
        <table>
        <tr>
            <td><label><input type="checkbox" name="power" value="审核企业信息"/>审核企业信息</label></td>
            <td><label><input type="checkbox" name="power" value="审核招商信息"/>审核招商信息</label></td>
           <td><label><input type="checkbox" name="power" value="发布招商信息"/>发布招商信息</label></td>
            <td><label><input type="checkbox" name="power" value="会员列表"/>会员列表</label></td>
            <td><label><input type="checkbox" name="power" value="会员添加"/>会员添加</label></td>
            <td><label><input type="checkbox" name="power" value="会员查询"/>会员查询</label></td>
		</tr>
		<tr>
            <td><label><input type="checkbox" name="power" value="会员删除"/>会员删除</label></td>
            <td><label><input type="checkbox" name="power" value="企业信息下载"/>企业信息下载</label></td>
            <td><label><input type="checkbox" name="power" value="发送报告"/>发送报告</label></td>
            <td><label><input type="checkbox" name="power" value="添加路演设备"/>添加路演设备</label></td>
            <td><label><input type="checkbox" name="power" value="编辑路演设备"/>编辑路演设备</label></td>
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
	$("#pid").change(function(){
	    $.post("${pageContext.request.contextPath}/part/aj1.do",
	            {
	                pid:$(this).val()
	
	            },
	            function(data){
	                if(data=="success"){
	                    $("#idmessage").html("");
	                }else{
	                    $("#idmessage").html("编号已存在！");
	                }
	
	            });
	});
</script>
</html>