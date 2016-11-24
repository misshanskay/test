<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>企业修改</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
     <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>
    <script src="${pageContext.request.contextPath}/jQuery.validate/jquery.validate.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form role="form" action="${pageContext.request.contextPath }/enterprise/upenterprise1.do" enctype="multipart/form-data" method="post" onsubmit="return chec()">
<input type="hidden" name="eid" value="${enterprise.eid }">
     <div class="form-group">
    <label for="nome">企业名称</label>
    <input type="text" class="form-control-6" name="ename" id="ename" value="${enterprise.ename }">
    <button>获取企业信息</button>
    </div>
     
     <label>营业执照号</label>
     <input type="text" name="ebusines" id="busines" value="${enterprise.ebusines }">
   <div id="imga1">
       
   
        <img id="imgs" alt="" src="${pageContext.request.contextPath}/${enterprise.ebusiness}" width="200" height="80">
        
    </div>
     <button type="button" onclick="uploada()">修改营业执照</button>
     <br>
     <label>税务登记号</label>
     <input type="text" name="ete" id="te" value="${enterprise.ete }">
   <div id="imga2">
       
   
        <img id="imgs1" alt="" src="${pageContext.request.contextPath}/${enterprise.etex}" width="200" height="80">
        
    </div>
     <button type="button" onclick="uploada1()">修改税务登记证</button>
    
    <div class="form-group">
         <label for="amount">注册金额</label>
         <input type="text" class="form-control-6" id="amount" name="eamount" value="${enterprise.eamount }">
        <label for="amount">万元</label>
     </div>
     <div class="form-group">
         <label for="legal">企业法人</label>
         <input type="text" class="form-control-6" id="legal" name="elegal" value="${enterprise.elegal }">
        
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
        <label for="time">注册时间</label>
      
        <input type="text" id="time" name="time" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'});"
        value="${time }"/>

    </div>
     <div class="form-group">
         <label for="range">经营范围</label>
         <input type="text" class="form-control-6" id="range" name="erange" value="${enterprise.erange }">
        
     </div>
     <div class="form-group">
         <label for="contacts">联系人</label>
         <input type="text" class="form-control-6" id="contacts" name="econtacts" value="${enterprise.econtacts }">
        
     </div>
     <div class="form-group">
         <label for="phone">联系电话</label>
         <input type="text" class="form-control-6" id="phone" name="ephone" value="${enterprise.ephone }">
        <label id="ephonemessage"></label>
     </div>
    <div class="form-group">
        <label for="email">邮箱地址</label>
        <input type="text" class="form-control-6" name="eemail" id="email" value="${enterprise.eemail }">
    	<label id="emailmessage"></label>
    </div>
    
    <div class="form-group">
        <label>招商意向</label>
        <select class="form-control-6" name="eintention" type="intention">
             <option selected="" value="请选择">请选择</option>
                            <option <c:if test="${enterprise.eintention=='找项目'}">selected</c:if>>找项目</option>
                            <option <c:if test="${enterprise.eintention=='找资金'}">selected</c:if>>找资金</option>
                            <option <c:if test="${enterprise.eintention=='找技术'}">selected</c:if>>找技术</option>
                            <option <c:if test="${enterprise.eintention=='找厂址'}">selected</c:if>>找厂址</option>
                            <option <c:if test="${enterprise.eintention=='技术输出'}">selected</c:if>>技术输出</option>
                            <option <c:if test="${enterprise.eintention=='投资输出'}">selected</c:if>>投资输出</option>
                            <option <c:if test="${enterprise.eintention=='其他'}">selected</c:if>>其他</option>
            
        </select>
    </div>
    
    <div class="form-group">
        <label>行业类型</label>
        <select class="form-control-6" name="etype" id="type">
            <option value="请选择">请选择</option>
            				<c:forEach var="list" items="${map1.type}">
                            <option <c:if test="${enterprise.etype==list}">selected</c:if>>${list }</option>
                            </c:forEach>
            
        </select>
    </div>
    

    <button type="submit" class="btn btn-default">修改</button>
    <a href="${pageContext.request.contextPath}/enterprise/reviewed.do?eid="+${enterprise.eid}>返回</a>
</form>
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

function chec() {
    
    
    if($("#ename").val()==null || $("#ename").val()==""){
        alert("请输入企业名")
        return false;
    }
    
    if($("#busines").val()==null || $("#busines").val()==""){
        alert("请输入营业执照号")
        return false;
    }
   
    if($("#te").val()==null || $("#te").val()==""){
        alert("请输入税务登记号")
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
    /* if(($("#telephone1").val()==null || $("#telephone1").val()=="")&&($("#telephone2").val()==null || $("#telephone2").val()=="")&&($("#telephone3").val()==null || $("#telephone3").val()=="")){
        alert("请输入座机号")
        return false;
    } */
    if($("#email").val()==null || $("#email").val()==""){
        alert("请输入联系人邮箱")
        return false;
    }
    
    /* if($("#financingbegin").val()==null || $("#financingbegin").val()==""){
        alert("请输入投融资金额")
        return false;
    }
    if($("#financingout").val()==null || $("#financingout").val()==""){
        alert("请输入投融资金额")
        return false;
    } */
   
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
    
    
    
    var reg4 = /\w+[@]{1}\w+[.]\w+/;
    if(reg4.test($("#email").val())){
    }else{
     alert("请输入正确的email地址");
     return false;
    }
    /* var reg5 =  /^[0-9]{3,4}$/;
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
    } */
    
    /* var reg8 = /^[0-9]*$/g;
    if(reg8.test($("#financingbegin").val())){
    }else{
        alert("投融资金额只能为数字");
        return false;
        }
    var reg9 = /^[0-9]*$/g;
    if(reg9.test($("#financingout").val())){
    }else{
        alert("投融资金额只能为数字");
        return false;
        } */
    return true;
}


$("#ephone").change(function(){
    
    
    if($("#ephone").val().length!=11){
        $("#ephonemessage").html("手机号码必须是11位！");
    }else{
        $("#ephonemessage").html("");
        
    }

 })
    
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
    
	   $("#email").blur(function(){
	   var email = $(this).val();
	   var reg = /\w+[@]{1}\w+[.]\w+/;
	   if(reg.test(email)){
	    $("#emailmessage").html("");
	   }else{
	    $("#emailmessage").html("请输入正确的email地址");
	   }
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
                
              
                   alert("修改成功！")
                 }else{
                     alert(data.msg)
                 }
              
             }
            })
         }
    }
    
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
    

    $(document).ready(function(){
      
        $("#img1").hide();
        $("#img2").hide();
    });
</script>
</html>