<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>企业添加</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
     <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
<form role="form" action="${pageContext.request.contextPath }/enterprise/addenter.do" method="post" onsubmit="return chec()">
    <div class="form-group">
        <label for="name">用户名</label>
        <input type="text" class="form-control-6" name="uname" id="name" placeholder="请输入用户名">
        <label id="namemessage"></label>
    </div>
    <div class="form-group">
        <label for="password">密码</label>
        <input type="password" class="form-control-6" name="upassword" id="password" placeholder="请输入密码">
        <label id="passwordmessage"></label>
    </div>
    <div class="form-group">
         <label for="password1">确认密码</label>
         <input type="password" class="form-control-6" id="password1" placeholder="请输入确认密码">
     </div>
     </div>
        <div class="form-group">
        <label for="downpassword">验证密码</label>
        <input type="password" class="form-control-6" id="downpassword" name="downpassword" id="downpassword" placeholder="请输入验证密码">
        <label id="downpasswordmessage"></label>
    </div>
    
     <div class="form-group">
    <label for="name">企业名称</label>
    <input type="text" class="form-control-6" name="ename" id="ename" placeholder="请输入企业名称">
    <button>获取企业信息</button>
    </div>
     <div class="form-group">
    <label for="business">营业执照号</label>
    <input type="text" class="form-control-6" name="ebusines" id="busines" placeholder="请输入营业执照号">
    <label id="businesmessage"></label>
    </div>
        <input type="hidden" id="business" name="ebusiness">
    <div id="imga1">
        <button type="button" onclick="uploada()">请上传营业执照</button>
    </div>
    <div class="form-group">
    <label for="tex">税务登记号</label>
    <input type="text" class="form-control-6" name="ete" id="te" placeholder="请输入税务登记号">
    <label id="temessage"></label>
    </div>
        <input type="hidden" id="tex" name="etex">
    <div id="imga2">
        <button type="button" onclick="uploada1()">请上传税务登记证</button>
    </div>
    <div class="form-group">
         <label for="amount">注册金额</label>
         <input type="text" class="form-control-6" id="amount" name="eamount" placeholder="请输入注册金额">
        <label for="amount">万元</label>
        <label id="amountmessage"></label>
     </div>
     <div class="form-group">
         <label for="legal">企业法人</label>
         <input type="text" class="form-control-6" id="legal" name="elegal" placeholder="请输入企业法人">
        <label id="legalmessage"></label>
     </div>
      
    <div class="form-group">
        <label>注册地址</label>
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
        <label for="time">注册时间</label>
       
        <input type="text" id="time" name="time" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'});"/>

    </div>
     <div class="form-group">
         <label for="range">经营范围</label>
         <input type="text" class="form-control-6" id="range" name="erange" placeholder="请输入经营范围">
        
     </div>
     <div class="form-group">
         <label for="contacts">联系人</label>
         <input type="text" class="form-control-6" id="contacts" name="econtacts" placeholder="请输入联系人">
        
     </div>
     <div class="form-group">
         <label for="phone">手机</label>
         <input type="text" class="form-control-6" id="phone" name="ephone" placeholder="请输入联系人手机">
        <label id="phonemessage"></label>
     </div>
     <div class="form-group">
         <label>座机</label>
         <input type="text" id="telephone1" name="etelephone1">
         <input type="text" id="telephone2" name="etelephone2">
         <input type="text" id="telephone3" name="etelephone3">
        <label id="telephonemessage"></label>
     </div>
    <div class="form-group">
        <label for="email">邮箱地址</label>
        <input type="text" class="form-control-6" name="eemail" id="email" placeholder="请输入联系人邮箱">
    	<label id="emailmessage"></label>
    </div>
    
    <div class="form-group">
        <label>招商意向</label>
        <select class="form-control-6" name="eintention" id="intention">
             <option selected="" value="请选择">请选择</option>
                            <option value="找项目">找项目</option>
                            <option value="找资金">找资金</option>
                            <option value="找技术">找技术</option>
                            <option value="找厂址">找厂址</option>
                            <option value="技术输出">技术输出</option>
                            <option value="投资输出">投资输出</option>
                            <option value="其他">其他</option>
            
        </select>
    </div>
    
    <div class="form-group">
        <label>行业类型</label>
        <select class="form-control-6" name="etype" id="type">
            <option selected="" value="请选择">请选择</option>
            				<c:forEach var="list" items="${map1.type}">
                            <option value="${list }">${list }</option>
                            </c:forEach>
            
        </select>
    </div>
    <div class="form-group">
        <label>投资融金额</label>
        <input type="text" class="form-control-6" name="efinancingbegin" id="financingbegin" placeholder="请输入投资融金额">
        
        <label>万元  到</label>
        <input type="text" class="form-control-6" name="efinancingout" id="financingout" placeholder="请输入投资融金额">万元
        <label id="financingmessage"></label>
    </div>

    <button type="submit" class="btn btn-default">添加</button>
</form>
<a href="${pageContext.request.contextPath}/enterprise/list.do">返回</a>
<form action="${pageContext.request.contextPath}/enterprise/fileupload.do" id="form1" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${enterprise.eid }"/>
<input type="file" name="img1" id="img1" onchange="upload1()"/>
</form>
<form action="${pageContext.request.contextPath}/enterprise/fileupload1.do" id="form2" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${enterprise.eid }"/>
<input type="file" name="img2" id="img2" onchange="upload2()"/>
</form>
</body>
<script>

$("#financingbegin").change(function(){
            var reg = /^[0-9]*$/g;
            if(reg.test($("#financingbegin").val())){
                       $("#financingmessage").html("");
            }else{
                $("#financingmessage").html("投融资金额只能为数字");
                }
         
         
     }) 
     
     $("#financingout").change(function(){
            var reg = /^[0-9]*$/g;
            if(reg.test($("#financingout").val())){
                
                       $("#financingmessage").html("");
            
                       
            }else{
                $("#financingmessage").html("投融资金额只能为数字");
                }
         
         
     }) 


function chec() {
	
    if($("#name").val()==null || $("#name").val()==""){
        alert("请输入用户名")
        return false;
    }
    if($("#ename").val()==null || $("#ename").val()==""){
        alert("请输入企业名")
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
    if($("#busines").val()==null || $("#busines").val()==""){
        alert("请输入营业执照号")
        return false;
    }
    if($("#business").val()==null || $("#business").val()==""){
        alert("请选择营业执照号")
        return false;
    }
    if($("#te").val()==null || $("#te").val()==""){
        alert("请输入税务登记号")
        return false;
    }
    if($("#tex").val()==null || $("#tex").val()==""){
        alert("请选择税务登记号")
        return false;
    }
    if($("#amount").val()==null || $("#amount").val()==""){
        alert("请输入注册金额")
        return false;
    }
    if($("#legal").val()==null || $("#legal").val()==""){
        alert("请输入企业法人")
        return false;
    }
    if($("#time").val()==null || $("#time").val()==""){
        alert("请选择注册时间")
        return false;
    }
    if($("#range").val()==null || $("#range").val()==""){
        alert("请输入经营范围")
        return false;
    }
    if($("#contacts").val()==null || $("#contacts").val()==""){
        alert("请输入联系人")
        return false;
    }
    if($("#phone").val()==null || $("#phone").val()==""){
        alert("请输入联系手机")
        return false;
    }
    if(($("#telephone1").val()==null || $("#telephone1").val()=="")&&($("#telephone2").val()==null || $("#telephone2").val()=="")&&($("#telephone3").val()==null || $("#telephone3").val()=="")){
        alert("请输入座机号")
        return false;
    }
    if($("#email").val()==null || $("#email").val()==""){
        alert("请输入联系人邮箱")
        return false;
    }
    if($("#intention").val()==null || $("#intention").val()==""){
        alert("请输入招商意向")
        return false;
    }
    if($("#type").val()==null || $("#type").val()==""){
        alert("请输入行业类别")
        return false;
    }
    if($("#financingbegin").val()==null || $("#financingbegin").val()==""){
        alert("请输入投融资金额")
        return false;
    }
    if($("#financingout").val()==null || $("#financingout").val()==""){
        alert("请输入投融资金额")
        return false;
    }
    var reg = /^[0-9a-zA-Z]*$/g;
    if(reg.test($("#name").val())){
     $.post("${pageContext.request.contextPath}/user/aj.do",
             {
                 uname:$("#name").val()

             },
             function(data){
                 if(data=="success"){
                 }else{
                     alert.html("用户已存在！");
                     return false;
                 }
             });
    }else{
     alert("用户名只能为字母或数字");
     return false;
    }
    var reg1 = /^[\u4E00-\u9FA5A-Za-z]+$/;
    if(reg1.test($("#legal").val())){
    }else{
        alert("企业法人不能为数字");
        return false;
        }
    var reg2 = /^[0-9]*$/g;
    if(reg2.test($("#busines").val())){
    }else{
     alert("营业执照号必须为数字");
     return false;
     }
    var reg10 = /^[0-9]*$/g;
    if(reg10.test($("#te").val())){
    }else{
     alert("税务登记号必须为数字");
     return false;
     }
    
    
    var reg11 = /^(\d+(\.\d+)?)|(\-1)$/;
    if(reg11.test($("#amount").val())){
    }else{
     alert("注册金额必须为数字");
     return false;
     }
    var reg3 = /^[0-9]{11}$/;
    if(reg3.test($("#phone").val())){
    }else{
              alert("手机号码必须是数字11位！");
              return false;
    }
    
    
    if($("#password").val()==$("#password1").val()){
    	var reg15 = /^[0-9a-zA-Z]{6,16}$/;
        if(reg15.test($("#password").val())){
        }else{
            alert("密码只能为字母或数字，只能6到16位");
            return false;
           }
    }else{

        alert("两次密码不一致！");
        return false;
    }
    if($("#password").val()==$("#downpassword").val()){
        alert("登陆密码和验证密码不能相同！");
        return false;
    }else{
        
    }
    var reg4 = /\w+[@]{1}\w+[.]\w+/;
    if(reg4.test($("#email").val())){
    }else{
     alert("请输入正确的email地址");
     return false;
    }
    var reg5 =  /^[0-9]{3,4}$/;
    if(reg5.test($("#telephone1").val())){
    }else{
     alert("3,4位的区号,只能是数字");
     return false;
    }
    var reg6 =  /^[0-9]{7,8}$/;
    if(reg6.test($("#telephone2").val())){
    }else{
     alert("7,8为的座机号,只能是数字");
     return false;
    }
    
    var reg7 =  /^[0-9]{2,4}$/;
    if(reg7.test($("#telephone3").val())){
    }else{
    alert.html("2-4位的分机,只能是数字");
    return false;
    }
    
    var reg8 = /^(\d+(\.\d+)?)|(\-1)$/;
    if(reg8.test($("#financingbegin").val())){
    }else{
        alert("投融资金额只能为数字");
        return false;
        }
    var reg9 = /^(\d+(\.\d+)?)|(\-1)$/;
    if(reg9.test($("#financingout").val())){
    }else{
        alert("投融资金额只能为数字");
        return false;
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
                     return true;
                 }else{
                     $("#namemessage").html("用户已存在！");
                     return false;
                 }
             });
    }else{
     $("#namemessage").html("用户名只能为字母或数字");
     return false;
    }
    
});

$("#legal").change(function(){
            var reg = /^[\u4E00-\u9FA5A-Za-z]+$/;
            if(reg.test($("#legal").val())){
                       $("#legalmessage").html("");
            }else{
                $("#legalmessage").html("企业法人不能为数字");
                }
     }) 
$("#busines").change(function(){
    var reg = /^[0-9]*$/g;
    if(reg.test($("#busines").val())){
               $("#businesmessage").html("");
    }else{
        $("#businesmessage").html("营业执照号必须为数字");
        }
 
 
})


$(document).ready(function(){
    
        $("#img1").hide();
        $("#img2").hide();
});

function uploada() {
    
    $("#img1").click();
}
function upload1(){
     var arr = $("#img1").val().split('.');
     
     if(arr[arr.length-1]!="png"){
         alert("只能传png图片!")
     }else{
    $("#form1").ajaxSubmit({
        type : 'post',
        url:'/WisdomEnterprise-establishing/enterprise/fileupload.do',
         dataType:'json',
         success:function(data){
             if(data.status==200){
             var name=getRootPath()+"/"+data.data
             $("#imgs").remove();
             var value = "<img  id='imgs' src='"+name+"' height='80' width='200' />";
               $("#imga1").empty().append(value);
               $("#business").val(data.data);
               
          
               alert("修改成功！")
             }else{
                 alert(data.msg)
             }
          
         }
        })
     }
}

function uploada1() {
    
    $("#img2").click();
}
function upload2(){
     var arr = $("#img2").val().split('.');
     
     if(arr[arr.length-1]!="png"){
         alert("只能传png图片!")
     }else{
    $("#form2").ajaxSubmit({
        type : 'post',
        url:'/WisdomEnterprise-establishing/enterprise/fileupload1.do',
         dataType:'json',
         success:function(data){
             if(data.status==200){
             var name=getRootPath()+"/"+data.data
             $("#imgs1").remove();
             var value = "<img  id='imgs1' src='"+name+"' height='80' width='200' />";
               $("#imga2").empty().append(value);
               $("#tex").val(data.data);
          
               alert("修改成功！")
             }else{
                 alert(data.msg)
             }
          
         }
        })
     }
}
    
    
$("#te").change(function(){
    var reg = /^[0-9]*$/g;
    if(reg.test($("#te").val())){
               $("#temessage").html("");
    }else{
        $("#temessage").html("税务登记号必须为数字");
        }
 
 
})
$("#amount").change(function(){
    var reg = /^[0-9]*$/g;
    if(reg.test($("#amount").val())){
               $("#amountmessage").html("");
    }else{
        $("#amountmessage").html("注册金额必须为数字");
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
    
$("#phone").change(function(){
        
        var reg = /^[0-9]{11}$/;
        if(reg.test($("#phone").val())){
                   $("#phonemessage").html("");
        }else{
                   $("#phonemessage").html("手机号码必须是数字11位！");
        }
    })
    
      $("#business").change(function(){
    	  var arr = $("#business").val().split('.');
          
          if(arr[arr.length-1]!="png"){
              alert("只能传png图片!")
          }else{
        	  
          $("#png1").html("");
          }
      })
          $("#tex").change(function(){
              var arr = $("#tex").val().split('.');
              
              if(arr[arr.length-1]!="png"){
                  alert("只能传png图片!")
              }else{
                  
              $("#png2").html("");
              }
        
        

     })
    
    
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
    
    $("#password1").change(function(){
        if($("#password").val()==$("#password1").val()){
            $("#passwordmessage").html("");
        }else{

            $("#passwordmessage").html("两次密码不一致！");
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
    $("#telephone1").change(function(){
        
        var reg =  /^[0-9]{3,4}$/;
        if(reg.test($("#telephone1").val())){
         $("#telephonemessage").html("");
        }else{
         $("#telephonemessage").html("3,4位的区号");
        }
       });
$("#telephone2").change(function(){
        
        var reg =  /^[0-9]{7,8}$/;
        if(reg.test($("#telephone2").val())){
         $("#telephonemessage").html("");
        }else{
         $("#telephonemessage").html("7,8为的座机号");
        }
       });
$("#telephone3").change(function(){
    
    var reg =  /^[0-9]{2,4}$/;
    if(reg.test($("#telephone3").val())){
     $("#telephonemessage").html("");
    }else{
     $("#telephonemessage").html("2,4位的分机");
    }
   });
    
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
</html>