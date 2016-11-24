<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>企业查询</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-form.js"></script> 
    <script type="text/javascript">
    
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

</head>
<body>
<form role="form" id="form" action="${pageContext.request.contextPath }/enterprise/searchenterprise.do" method="post">
    <div class="form-group">
        <label for="name">企业名称</label>
        <input type="text" class="form-control-6" name="ename" id="name" placeholder="请输入企业名称">
    </div>
    <div class="form-group">
        <label for="buines">营业执照号</label>
        <input type="text" class="form-control-6" name="ebuines" id="buines" placeholder="请输入营业执照号">
    </div>
     <div class="form-group">
        <label for="te">税务登记号</label>
        <input type="text" class="form-control-6" name="ete" id="te" placeholder="请输入税务登记号">
    </div>
    
     <div class="form-group">
        <label>注册地址</label>
        <select name="address1" onchange="province(this)" id="pro">
            <option selected="" value="">请选择省</option>
                            <c:forEach var="list" items="${map}">
                            <option value="${list.name }">${list.name }</option>
                            </c:forEach>
            
        </select>
        <select name="address2" onchange="city(this)" id="city1">
            <option selected="" value="">请选择市</option>
        </select>
        <select name="address3" id="area1">
            <option selected="" value="">请选择区</option>
        </select>
        <input type="text" class="form-control-6" name="address4" placeholder="请输入具体住址">
    </div>
    
     <div class="form-group">
        <label>注册金额</label>
        <input type="text" class="form-control-6" name="amount1">
        <label>万元   到</label>
        <input type="text" class="form-control-6" name="amount2">
        <label>万元 </label>
    </div>
    
    <div class="form-group">
        <label>招商意向</label>
        <select class="form-control-6" name="eintention">
             <option selected="" value="">请选择</option>
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
        <select class="form-control-6" name="etype">
            <option selected="" value="">请选择</option>
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
        
    </div>
    
     <div class="form-group">
         <label for="contacts">联系人</label>
         <input type="text" class="form-control-6" id="contacts" name="econtacts" placeholder="请输入联系人">
        
     </div>
     <div class="form-group">
         <label for="phone">联系电话</label>
         <input type="text" class="form-control-6" id="phone" name="ephone" placeholder="请输入联系人电话">
        
     </div>
    <div class="form-group">
        <label for="email">邮箱地址</label>
        <input type="text" class="form-control-6" name="eemail" id="email" placeholder="请输入联系人邮箱">
        <label id="emailmessage"></label>
    </div>
    <button type="submit">查询</button>
    </form>
    <a href="${pageContext.request.contextPath}/enterprise/list.do">返回</a>
    

</table>
</body>
<script type="text/javascript">

</script>
</html>