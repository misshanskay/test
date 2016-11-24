<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>用户修改</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/zTree_v3-master/css/demo.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/zTree_v3-master/css/zTreeStyle/zTreeStyle.css" type="text/css">
    
    <script src="${pageContext.request.contextPath}/laydate/laydate.js"></script>

    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/zTree_v3-master/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/zTree_v3-master/js/jquery.ztree.excheck.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/zTree_v3-master/js/jquery.ztree.exedit.js"></script>
    <script type="text/javascript">
    var setting = {
            view: {
                dblClickExpand: false
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                
                onClick: onClick
            }
        };

        

        
        
        function onClick(e, treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
            nodes = zTree.getSelectedNodes(),
            v = "";
            nodes.sort(function compare(a,b){return a.id-b.id;});
            for (var i=0, l=nodes.length; i<l; i++) {
                v += nodes[i].name + ",";
            }
            if (v.length > 0 ) v = v.substring(0, v.length-1);
            var cityObj = $("#dept");
            cityObj.attr("value", v);
        }

        function showMenu() {
            var cityObj = $("#dept");
            var cityOffset = $("#dept").offset();
            $("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

            $("body").bind("mousedown", onBodyDown);
        }
        function hideMenu() {
            $("#menuContent").fadeOut("fast");
            $("body").unbind("mousedown", onBodyDown);
        }
        function onBodyDown(event) {
            if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
                hideMenu();
            }
        }

        $(document).ready(function(){
            var json = eval($("#deptlist").val());
            var zNodes=json;
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
            $("#img").hide();
        });
        
        /* function part(){
            var pname=$("#urole").val();
            $.post("${pageContext.request.contextPath}/user/seletepart.do",{
                pname:pname
            },function(data){
                var json=data.data
                $("[name='power']").prop("checked",false);
                $.each(json,function(index){
                    
                    $("input:checkbox[value='"+json[index]+"']").prop('checked',true);
                })
                    
                
            })
            
            
        } */
        
        function getRootPath(){      
            //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp      
            var curWwwPath=window.document.location.href;      
            //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp      
            var pathName=window.document.location.pathname;      
            var pos=curWwwPath.indexOf(pathName);      
            //获取主机地址，如： http://localhost:8083      
            var localhostPaht=curWwwPath.substring(0,pos);      
            //获取带"/"的项目名，如：/uimcardprj      
            var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);      
            return(projectName);  
        } 
    </script>
</head>
<body>
<form id="form" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user/upu.do" onsubmit="return chec()">
    <input type="hidden" name="uid" value="${userU.uid}">
    <div class="form-group">
        <label for="name">姓名</label>
        <input type="text" class="form-control-6" name="uname" id="name" value="${userU.uname}" disabled='disabled'>
        <label id="namemessage"></label>

    </div>
    <div class="form-group">
        <label for="password">密码</label>
        <input type="password" class="form-control-6" name="upassword" id="password">
    </div>
    <div class="form-group">
        <label for="password1">确认密码</label>
        <input type="password" class="form-control-6" name="upassword1" id="password1">
        <label id="passwordmessage"></label>
    </div>

    </div>
        <div class="form-group">
        <label for="downpassword">验证密码</label>
        <input type="password" class="form-control-6" id="downpassword" name="downpassword" id="downpassword" value="${userU.downpassword}">
        <label id="downpasswordmessage"></label>
    </div>

    <div class="radio">
        <label>

            <input type="radio" name="userExtend.usex" id="sex1" value="男" <c:if test="${userU.userExtend.usex=='男'}">checked</c:if>>男
        </label>
    </div>
    <div class="radio">
        <label>
            <input type="radio" name="userExtend.usex" id="sex2" value="女" <c:if test="${userU.userExtend.usex=='女'}">checked</c:if>>女
        </label>
    </div>
    
    <div class="form-group">
        <label for="email">邮箱地址</label>
        <input type="text" class="form-control-6" name="userExtend.uemail" id="email" value="${userU.userExtend.uemail}">
    </div>
    <div class="form-group">
        <label for="phone">手机号码</label>
        <input type="text" class="form-control-6" name="userExtend.uphone" id="phone" value="${userU.userExtend.uphone}">
        <label id="phonemessage"></label>
    </div>
    
     <div class="form-group">
        <label for="dept">  部门：</label>
        <input type="text" class="form-control-6" name="udept" readonly id="dept" value="${dname}">
        <a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a>
        <input type="hidden" value="${ztreeno }" id="deptlist"/>
    </div>
         <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
    <ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
</div>
    
    <div class="form-group">
    <label>角色</label>

    <select class="form-control-6" name="part" id="part">
    
        <option>--请选择--</option>
        <c:forEach var="list" items="${list1 }">
        <option <c:if test="${pname==list.pname}">selected</c:if>>${list.pname }</option>
        </c:forEach>
        
    </select>
    </div>
     <label>头像</label>
   <div id="img1">
       
   
        <img id="imgs" alt="" src="${pageContext.request.contextPath }/${userU.userExtend.imgsrc}" width="80" height="100">
        
    </div>
   <button type="button" onclick="upload()">修改头像</button>
    <div class="form-group">
        <label for="real">真实姓名</label>
        <input type="text" class="form-control-6" name="userExtend.urealname" id="real" value="${userU.userExtend.urealname}">
    </div>
    <div class="form-group">
        <label for="real">出生年月</label>
        <input type="text" name="birthday" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'});"
        value="${birthday}"/>

	
    
    </div>
    <div class="form-group">
        <label>岗位</label>
        <select class="form-control-6" name="userExtend.upost">
            <option <c:if test="${userU.userExtend.upost=='市长'}">selected</c:if>>市长</option>
            <option <c:if test="${userU.userExtend.upost=='副市长'}">selected</c:if>>副市长</option>
            <option <c:if test="${userU.userExtend.upost=='党委书记'}">selected</c:if>>党委书记</option>
            <option <c:if test="${userU.userExtend.upost=='局长'}">selected</c:if>>局长</option>
            <option <c:if test="${userU.userExtend.upost=='处长'}">selected</c:if>>处长</option>
            <option <c:if test="${userU.userExtend.upost=='科长'}">selected</c:if>>科长</option>
            <option <c:if test="${userU.userExtend.upost=='科员'}">selected</c:if>>科员</option>
        </select>
    </div>
    <div class="form-group">
        <label for="unit">就职单位</label>
        <input type="text" class="form-control-6" name="userExtend.uunit" id="unit" value="${userU.userExtend.uunit}">
    </div>
    <div class="form-group">
        <label for="card">身份证</label>
        <input type="text" class="form-control-6" name="userExtend.ucard" id="card" value="${userU.userExtend.ucard}">
        <label id="cardmessage"></label>
    </div>
    <div class="form-group">
        <label>政治面貌</label>
        <select class="form-control-6" name="userExtend.upolitical">
            <option <c:if test="${userU.userExtend.upolitical=='共青团员'}">selected</c:if>>共青团员</option>
            <option <c:if test="${userU.userExtend.upolitical=='党员'}">selected</c:if>>党员</option>
            <option <c:if test="${userU.userExtend.upolitical=='群众'}">selected</c:if>>群众</option>
        </select>
    </div>
    <div class="form-group">
        <label>地址</label>
        <select name="address1" onchange="province(this)" id="pro">
            <option selected="" value="0">请选择省</option>
                            <c:forEach var="list" items="${map}">
                            <option value="${list.name }" <c:if test="${list.name==address1 }">selected</c:if>>${list.name }</option>
                            </c:forEach>
            
        </select>
        <select name="address2" onchange="city(this)" id="city1">
            <option selected="" value="0">请选择市</option>
            <c:forEach var="list" items="${city}">
                            <option value="${list.name }" <c:if test="${list.name==address2 }">selected</c:if>>${list.name }</option>
                            </c:forEach>
        </select>
        <select name="address3" id="area1">
            <option selected="" value="0">请选择区</option>
            <c:forEach var="list" items="${area}">
                            <option value="${list.name }" <c:if test="${list.name==address3 }">selected</c:if>>${list.name }</option>
                            </c:forEach>
        </select>
        <input type="text" class="form-control-6" name="address4" value="${address4 }">
    </div>
    
    <div class="form-group">
        <label for="graduation">毕业院校</label>
        <input type="text" class="form-control-6" name="userExtend.ugraduation" id="graduation" value="${userU.userExtend.ugraduation}">
    </div>
    <div class="form-group">
        <label for="major">专业</label>
        <input type="text" class="form-control-6" name="userExtend.umajor" id="major" value="${userU.userExtend.umajor}">
    </div>
    <div class="form-group">
        <label for="introduction">个人描述</label>
        <textarea rows="3" name="userExtend.uintroduction" class="form-control-6" id="introduction">${userU.userExtend.uintroduction}</textarea>
    </div>
	<input type="submit" value="修改"/>

</form>
<form action="${pageContext.request.contextPath}/user/fileupload.do" id="form1" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${userU.uid }"/>
<input type="file" name="img" id="img" onchange="upload1()"/>
</form>
<!-- <button class="btn btn-default" onclick="upu()">修改</button> -->
</body>
<script>
    /* function upu() {
        var form1=$("#form").serialize()
        $.post("${pageContext.request.contextPath}/user/upu.do",
            form1



        ,function (data) {
            window.location.href="${pageContext.request.contextPath}/user/list.do";
        })

    } */
   
    
    
    function chec() {
        
        
       
        if($("#downpassword").val()==null || $("#downpassword").val()==""){
            alert("请输入验证密码")
            return false;
        }
        if($("#dept").val()==null || $("#dept").val()==""){
            alert("请选择部门")
            return false;
        }
        if($("#part").val()==null || $("#part").val()==""){
            alert("请选择角色")
            return false;
        }
        
        
        if($("#password").val()==$("#password1").val()){
        }else{

            alert("两次密码不一致！");
            return false;
        }
        if($("#phone").val()!=null &&$("#phone").val()!=""){
        	
	        var reg2 = /^[0-9]{11}$/;
	        if(reg2.test($("#phone").val())){
	            
	        }else{
	                   alert("手机号码必须是数字11位！");
	            return false;
	            
	        } 
        }
        if($("#real").val()!=null &&$("#real").val()!=""){
        	
	        var reg3 = /^[\u4E00-\u9FA5A-Za-z]+$/;
	        if(reg3.test($("#real").val())){
	            
	        }else{
	                   alert("真实姓名必须为汉字或字母");
	            return false;
	            
	        } 
        }
        if($("#card").val()!=null &&$("#card").val()!=""){
        	
	        var reg4 = /^[0-9a-zA-Z]*$/g;
	        if(reg4.test($("#card").val())){
	                   if($("#card").val().length!=15&&$("#card").val().length!=18){
	                       alert("身份证号必须是15位或18位！");
	                       return false;
	                   }else{
	                   }
	                }else{
	                    alert("身份证号码必须是数字或字母！");
	             return false;
	             
	        } 
        }
        if($("#password").val()!=null &&$("#password").val()!=""){
        	
	        var reg5 = /^[0-9a-zA-Z]{6,16}$/;
	        if(reg5.test($("#password").val())){
	        }else{
	            alert("密码只能为字母或数字，只能6到16位");
	            return false;
	           }
        }
        var reg6 = /^[0-9a-zA-Z]{6}$/;
        if(reg6.test($("#downpassword").val())){
        }else{
            alert("验证密码只能为字母或数字，只能6位");
            return false;
           }
        if($("#password").val()==$("#downpassword").val()){
            alert("验证密码和密码不能相同！");
            return false;
        }else{
        }
        return true;
    } 
    
    function upload() {
    	
		$("#img").click();
	}
    function upload1(){
        var arr = $("#img").val().split('.');
        
        if(arr[arr.length-1]!="png"){
            alert("只能传png图片!")
        }else{
        	$("#form1").ajaxSubmit({
                type : 'post',
                url:'/WisdomEnterprise-establishing/user/fileupload.do',
                 dataType:'json',
                 success:function(data){
                     if(data.status==200){
                     var name=getRootPath()+"/"+data.data
                     $("#imgs").remove();
                     var value = "<img  id='imgs' src='"+name+"' height='100' width='80' />";
                       $("#img1").empty().append(value);
                    
                  
                       alert("修改成功！")
                     }else{
                         alert(data.msg)
                     }
                  
                 }
                })
        }
    	
    }
   
    	
    
    
    
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
        if($("#password").val()==$("#downpassword").val()){
            $("#downpasswordmessage").html("登陆密码和验证密码不能相同！");
        }else{
            $("#downpasswordmessage").html("");
            
        }

    })
    
    $("#phone").change(function(){
        
        
       if($("#phone").val().length!=11){
           $("#phonemessage").html("手机号码必须是11位！");
       }else{
           $("#phonemessage").html("");
           
       }

    })
    
    $("#card").change(function(){
        
        
       if($("#card").val().length!=15&&$("#card").val().length!=18){
           $("#cardmessage").html("身份证号必须是15位或18位！");
       }else{
           $("#cardmessage").html("");
           
       }

    })
     
    $("#downpassword").change(function(){
       
        if($("#password").val()==$("#downpassword").val()){
            $("#downpasswordmessage").html("登陆密码和验证密码不能相同！");
        }else{
            $("#downpasswordmessage").html("");
            
        }

    })
    
     function province(obj){
        if(obj.value!=0){
            $.post("${pageContext.request.contextPath}/enterprise/city.do",{
                name:obj.value
                
            },function (data) {
                $("#city1").empty();
                $("#area1").empty();
                $("#city1").append("<option value='0'>--请选择--</option>");
                $("#area1").append("<option value='0'>--请选择--</option>");
                for(var i=0;i<data.data.length;i++){
                $("#city1").append('<option value='+data.data[i].name+'>'+data.data[i].name+'</option>');
                    
                }

            }); 
        }else{
            
            $("#city1").empty();
            $("#area1").empty();
        }
    }
    
    function city(obj){
        if(obj.value!=0){
            $.post("${pageContext.request.contextPath}/enterprise/area.do",{
                name:obj.value
                
            },function (data) {
               
                $("#area1").empty();
               
                $("#area1").append("<option value='0'>--请选择--</option>");
                for(var i=0;i<data.data.length;i++){
                    
                $("#area1").append('<option value='+data.data[i].name+'>'+data.data[i].name+'</option>');
                    
                }

            }); 
        }else{
            $("#area1").empty();
        }
         
    }
</script>
</html>
