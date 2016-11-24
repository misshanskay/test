<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>企业列表</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>
    <script type="text/javascript">
    function reviewed() {
        var chk_value =[];
        $('input[name="check"]:checked').each(function(){
        chk_value.push($(this).val());
        });
        if(chk_value.length==0){
            alert("你还没有选择企业！")
        }else{
             var json = JSON.stringify(chk_value)
            $.post("${pageContext.request.contextPath}/enterprise/reviewed2.do",{
                estatuss:json
            },function(){
                window.location.href="${pageContext.request.contextPath}/enterprise/list.do";
            })
        }
    
    }
    
    function download(obj) {
        var chk=[]
        $('input[name="check"]:checked').each(function(){
        chk.push($(this).val());
        });
        
            
        if(chk.length!=0){
            message = prompt("请输入下载密码:","");
            $("#message").val(message)
            $("#chk").val(chk[0])
            $.post("${pageContext.request.contextPath}/enterprise/downpassword.do",{
                message:message
            },function(data){
                if(data.status==200){
                    for(var i=0;i<chk.length;i++){
                        
                     window.open("${pageContext.request.contextPath}/enterprise/download.do?chk="+chk[i]);
                    }
                }else{
                    alert(data.msg)
                }
            })
        }else{
            alert("请选择要下载的企业")
            
        }
    }
    
    function dele(eid,thispage) {
        
         if(confirm("确定要删除吗？")){
             $.post("${pageContext.request.contextPath}/enterprise/dele.do",{
                    eid:eid
                 },function(data){
                     if(data.status==200){
                         window.location.href="${pageContext.request.contextPath}/enterprise/list.do?thispage="+(thispage-1);
                     }
                 })
            }
         
    }
    </script>
</head>
<body>
<a href="${pageContext.request.contextPath}/enterprise/list.do">返回</a>

<table class="table">
<tr>
<td>选择</td>
<td>企业名称</td>
<td>联系人</td>
<td>注册地</td>
<td>注册资金</td>
<td>未来5年投融资意向</td>
<td>状态</td>
<td>操作</td>
</tr>
<c:forEach var="list" items="${page.list}">
        <tr><td>
        <input type="checkbox" name="check" value="${list.eid }"/></td>
            <td>${list.ename}</td>
            <td>${list.econtacts}</td>
            <td>${list.eaddress}</td>
            <td>${list.eamount}</td>
            <td>${list.eintention}</td>
            <td>
            <c:if test="${list.estatus==1}"><span style="color:red">待审核</span></c:if>
            <c:if test="${list.estatus==2}"><span style="color:green">已审核</span></c:if>
            <c:if test="${list.estatus==3}"><span style="color:black">未通过</span></c:if>
            </td>
            
            <td>
                
            <c:if test="${list.estatus==1}"><a href="${pageContext.request.contextPath}/enterprise/reviewed.do?eid=${list.eid}">审核</a></c:if>
            <c:if test="${list.estatus==2}"><a href="${pageContext.request.contextPath}/enterprise/reviewed.do?eid=${list.eid}">查看</a></c:if>
            <c:if test="${list.estatus==3}"><a href="${pageContext.request.contextPath}/enterprise/reviewed.do?eid=${list.eid}">查看</a></c:if>
            
                <a href="${pageContext.request.contextPath}/enterprise/selectenterprise.do?eid=${list.eid}">查看</a>
                <a href="${pageContext.request.contextPath}/enterprise/enterpriseuserlist.do?eid=${list.eid}">修改</a>
                <button onclick="dele(${list.eid},${page.pageNum})">删除</button>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td></td>
        <td>
            <input type="button" value="上一页" onclick="up(${page.pageNum})">
            <input type="button" value="下一页 " onclick="down(${page.pageNum},${page.pages })">
            共${page.pageNum}/${page.pages}页
        </td>
        <td></td>
    </tr>
    </table>
    <form id="form1" action="${pageContext.request.contextPath }/enterprise/searchenterprise.do" method="post">
    
		    <input type="hidden" id="thispage" name="thispage" value="${page.pageNum }"> 
		    <input type="hidden" id="name" name="ename" value="${enterprise.ename }"> 
		   <input type="hidden" id="busines" name="ebusines" value="${enterprise.ebusines}"> 
		   <input type="hidden" id="te" name="ete" value="${enterprise.ete}"> 
		   <input type="hidden" id="address1" name="address1" value="${address1}"> 
		   <input type="hidden" id="address2" name="address2" value="${address2}"> 
		   <input type="hidden" id="address3" name="address3" value="${address3}"> 
		   <input type="hidden" id="address4" name="address4" value="${address4}"> 
		   <input type="hidden" id="amount1" name="amount1" value="${amount1}"> 
		   <input type="hidden" id="amount2" name="amount2" value="${amount2}">
		   <input type="hidden" id="eintention" name="eintention" value="${enterprise.eintention}">
		   <input type="hidden" id="etype" name="etype" value="${enterprise.etype}">
		   <input type="hidden" id="efinancingbegin" name="efinancingbegin" value="${enterprise.efinancingbegin}">
		   <input type="hidden" id="efinancingout" name="efinancingout" value="${enterprise.efinancingout}">
    </form>
</body>
<script type="text/javascript">

function down(thispage,page) {
    
    if(thispage!=page&&thispage!=0){
        $("#thispage").val(thispage+1)
         $("#form1").sumbit();
    }
 
}
function up(thispage) {
    if(thispage!=1&&thispage!=0){
    	$("#thispage").val(thispage-1)
        $("#form1").sumbit();
    }
     
 }
</script>
</html>