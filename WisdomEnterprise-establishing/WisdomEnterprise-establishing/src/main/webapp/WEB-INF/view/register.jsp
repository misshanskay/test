<%--
  Created by IntelliJ IDEA.
  User: X201
  Date: 2016/8/29 0029
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/zTree_v3-master/css/demo.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/zTree_v3-master/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
     <script src="${pageContext.request.contextPath}/js/jquery-form.js"></script>
    

    
     <script src="${pageContext.request.contextPath}/jQuery.validate/jquery.validate.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
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
    </script>
</head>
<body>
<form id="form"  action="${pageContext.request.contextPath }/user/addu.do" method="post" onsubmit="return chec()">
    <div class="form-group">
        <label for="name">用户名</label>
        <input type="text" class="form-control-6" name="uname" id="name" placeholder="请输入姓名">
        <label id="namemessage"></label>
    </div>
    <div class="form-group">
        <label for="password">密码</label>
        <input type="password" class="form-control-6" name="upassword" id="password" placeholder="请输入密码">
        <label id="passwordmessage"></label>
    </div>
    <div class="form-group">
         <label for="password1">确认密码</label>
         <input type="password" class="form-control-6" name="password1" id="password1" placeholder="请输入确认密码">
     </div>
        <div class="form-group">
        <label for="downpassword">验证密码</label>
        <input type="password" class="form-control-6" id="downpassword" name="downpassword" id="downpassword" placeholder="请输入验证密码,验证密码和密码不能重">
         <label id="downpasswordmessage"></label>
    </div>
     <div class="radio">
         <label>
             <input type="radio" name="userExtend.usex" id="sex1" value="男" checked>男
         </label>
     </div>
     <div class="radio">
         <label>
             <input type="radio" name="userExtend.usex" id="sex2" value="女">女
         </label>
     </div>
    
      <div class="form-group">
        <label for="email">邮箱地址</label>
        <input type="text" class="form-control-6" name="userExtend.uemail" id="email" placeholder="请输入邮箱地址">
    	<label id="emailmessage"></label>
    </div>
    <div class="form-group">
        <label for="phone">手机号码</label>
        <input type="text" class="form-control-6" name="userExtend.uphone" id="phone" placeholder="请输入手机号码">
        <label id="phonemessage"></label>
    </div>
    <div class="form-group">
        <label for="dept">  部门：</label>
        <input type="text" class="form-control-6" name="udept" readonly id="dept">
        <a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a>
        <input type="hidden" value="${ztreeno }" id="deptlist"/>
    </div>
         <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
	<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
</div>
    
    <div class="form-group">
    <label>角色</label>

     <select class="form-control-6" name="part" id="part">
    
        <option value="">--请选择--</option>
        <c:forEach var="list" items="${list }">
        <option>${list.pname }</option>
        </c:forEach>
        
    </select>
    </div>
    
    
     <label>头像</label>
   <input type="hidden" id="imgsrc" name="userExtend.imgsrc">
   <div id="img1">
   <button type="button" onclick="upload()">选择头像</button>
        
    </div>
   <label id="png">只能传png格式图片</label>
    <div class="form-group">
    <label for="real">真实姓名</label>
    <input type="text" class="form-control-6" name="userExtend.urealname" id="real" placeholder="请输入真实姓名">
    </div>
    <div class="form-group">
        <label>出生年月</label>
       
        <input type="text" id="birthday" name="birthday" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'});">

    </div> 
  
    
    <div class="form-group">
        <label>岗位</label>
        <select class="form-control-6" name="userExtend.upost">
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
        <input type="text" class="form-control-6" name="userExtend.uunit" id="unit" placeholder="请输入就职单位">
    </div>
    <div class="form-group">
        <label for="card">身份证</label>
        <input type="text" class="form-control-6" name="userExtend.ucard" id="card" placeholder="请输入身份证号">
        <label id="cardmessage"></label>
    </div>
    <div class="form-group">
        <label>政治面貌</label>
        <select class="form-control-6" name="userExtend.upolitical">
        <option>共青团员</option>
        <option>党员</option>
        <option>群众</option>
        </select>
    </div>
    <div class="form-group">
        <label>地址</label>
        <select name="address1" onchange="province(this)" id="pro">
            <option selected="" value="0">请选择省</option>
                            <c:forEach var="list" items="${map}">
                            <option value="${list.name }">${list.name }</option>
                            </c:forEach>
            
        </select>
        <select name="address2" onchange="city(this)" id="city1">
            <option selected="" value="0">请选择市</option>
        </select>
        <select name="address3" id="area1">
            <option selected="" value="0">请选择区</option>
        </select>
        <input type="text" class="form-control-6" name="address4" placeholder="请输入具体住址">
    </div>
    <div class="form-group">
        <label for="graduation">毕业院校</label>
        <input type="text" class="form-control-6" name="userExtend.ugraduation" id="graduation" placeholder="请输入毕业院校">
    </div>
    <div class="form-group">
        <label for="major">专业</label>
        <input type="text" class="form-control-6" name="userExtend.umajor" id="major" placeholder="请输入专业">
    </div>
    <div class="form-group">
        <label for="introduction">个人描述</label>
        <textarea rows="3" name="userExtend.uintroduction" class="form-control-6" id="introduction"></textarea>
    </div> 

    <button type="submit" class="btn btn-default">注册</button>
</form>
<a href="${pageContext.request.contextPath}/user/list.do">返回</a>
<form action="${pageContext.request.contextPath}/user/fileupload.do" id="form1" method="post" enctype="multipart/form-data">

<input type="file" name="img" id="img" onchange="upload1()"/>
</form>
</body>
<script>



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



function upload() {
    
    $("#img").click();
}
function upload1(){
    var arr = $("#img").val().split('.');
    
    if(arr[arr.length-1]!="png"){
        alert("只能传png图片!")
    }else{
    	$("#png").html("");
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
                   $("#imgsrc").val(data.data)
              
                   alert("上传成功！")
                 }else{
                     alert(data.msg)
                 }
              
             }
            })
    }
    
}

  
function chec() {
    if($("#name").val()==null || $("#name").val()==""){
    	alert("请输入用户名")
    	return false;
    }
    if($("#password").val()==null || $("#password").val()==""){
        alert("请输入密码")
        return false;
    }
   
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
    var reg1 = /^[0-9a-zA-Z]*$/g;
    if(reg1.test($("#name").val())){
     $("#namemessage").html("");
     $.post("${pageContext.request.contextPath}/user/aj.do",
             {
                 uname:$("#name").val()
             },
             function(data){
                 if(data=="success"){
                 }else{
                    alert("用户已存在！");
                    return false;
                 }
             });
    }else{
     alert("用户名只能为字母或数字");
     return false;
    }
    
    if($("#password").val()==$("#password1").val()){
    }else{

        alert("两次密码不一致！");
        return false;
    }
    var reg2 = /^[0-9]{11}$/;
    if(reg2.test($("#phone").val())){
        
    }else{
               alert("手机号码必须是数字11位！");
        return false;
        
    }
    var reg3 = /^[\u4E00-\u9FA5A-Za-z]+$/;
    if(reg3.test($("#real").val())){
        
    }else{
               alert("姓名必须为汉字或字母");
        return false;
        
    }
    
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
    var reg5 = /^[0-9a-zA-Z]{6,16}$/;
    if(reg5.test($("#password").val())){
    }else{
        alert("密码只能为字母或数字，只能6到16位");
        return false;
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


    $("#name").change(function(){
    	if($("#name").val()==""){
    		$("#namemessage").html("");
    	}
    	var reg = /^[0-9a-zA-Z]*$/g;
        if(reg.test($("#name").val())){
         $("#namemessage").html("");
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
        }else{
         $("#namemessage").html("用户名只能为字母或数字");
        }
        
    });
    $("#password1").change(function(){
    	
            if($("#password").val()==$("#password1").val()){
                $("#passwordmessage").html("");
            }else{

                $("#passwordmessage").html("两次密码不一致！");
            }
        
        
       

    })
    
    $("#imgsrc").change(function(){
    	var arr = $("#imgsrc").val().split('.');
    	
    	if(arr[arr.length-1]!="png"){
    		alert("只能传png图片!")
    	}else{
    		
    	$("#png").html("");
    	}

    })
    
    $("#phone").change(function(){
    	
    	var reg = /^[0-9]{11}$/;
        if(reg.test($("#phone").val())){
            
		    	   $("#phonemessage").html("");
        }else{
		    	   $("#phonemessage").html("手机号码必须是数字11位！");
            
            
        }
    })
    
    $("#real").change(function(){
        
        var reg = /^[\u4E00-\u9FA5A-Za-z]+$/;
        if(reg.test($("#real").val())){
            
                   $("#realmessage").html("");
        }else{
                   $("#realmessage").html("姓名必须为汉字或字母");
            
            
        }
    })
    
    $("#card").change(function(){
    	var reg = /^[0-9a-zA-Z]*$/g;
        if(reg.test($("#card").val())){
            
                   $("#cardmessage").html("");
        
			       if($("#card").val().length!=15&&$("#card").val().length!=18){
			           $("#cardmessage").html("身份证号必须是15位或18位！");
			       }else{
			           $("#cardmessage").html("");
			           
			       }
        }else{
            $("#cardmessage").html("身份证号码必须是数字或字母！");
     
     
 }

    })
    
    $("#password").change(function(){
    	var reg = /^[0-9a-zA-Z]{6,16}$/;
        if(reg.test($("#password").val())){
        	
            $("#passwordmessage").html("");
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
        }else{
            $("#passwordmessage").html("密码只能为字母或数字，只能6到16位");
           }
        

    })
    
    $("#downpassword").change(function(){
       
    	
    	var reg = /^[0-9a-zA-Z]{6}$/;
	    if(reg.test($("#downpassword").val())){
	    	$("#downpasswordmessage").html("");
	        if($("#password").val()==$("#downpassword").val()){
	            $("#downpasswordmessage").html("登陆密码和验证密码不能相同！");
	        }else{
	            $("#downpasswordmessage").html("");
	            
	        }
        }else{
            $("#downpasswordmessage").html("验证密码只能为字母或数字，只能为6位");
           }
    })
    
	   $("#email").blur(function(){
	   var email = $(this).val();
	   var reg = /\w+[@]{1}\w+[.]\w+/;
	   if(reg.test(email)){
	    $("#emailmessage").html("");
	   }else{
	    $("#emailmessage").html("请输入正确的email地址");
	   }
	  }); 
 
    
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
