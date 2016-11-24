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
    		if(confirm("确定要下载所有企业信息吗？")){
    			message = prompt("请输入下载密码:","");
                $("#message").val(message)
                
                $.post("${pageContext.request.contextPath}/enterprise/downpassword.do",{
                    message:message
                },function(data){
                    
                        if(data.status==200){
                            
    			            window.open("${pageContext.request.contextPath}/enterprise/download1.do");
                        }else{
                            alert(data.msg)
                        }
                    
                    
                })
    		}
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
    
    
    function checkAll(name) { 
    	var el = document.getElementsByTagName('input'); 
    	var len = el.length; 
    	for(var i=0; i<len; i++) { 
    	if((el[i].type=="checkbox") && (el[i].name==name)) { 
    	el[i].checked = true; 
    	} 
    	} 
    }
    function clearAll(name) { 
    	var el = document.getElementsByTagName('input'); 
    	var len = el.length; 
    	for(var i=0; i<len; i++) { 
    	if((el[i].type=="checkbox") && (el[i].name==name)) { 
    	el[i].checked = false; 
    	} 
    	} 
    }
    </script>
</head>
<body>
<a href="${pageContext.request.contextPath}/enterprise/addenterprise.do">添加企业</a>
<button onclick="reviewed()">批量审核</button>
<a href="${pageContext.request.contextPath}/enterprise/search.do">企业查询</a>
<button onClick="download()"/>下载企业资料</button>
<table class="table">
<tr>
<td>选择</td>
<td>企业名称</td>
<td>联系人</td>
<td>注册地</td>
<td>注册资金</td>
<td>余额</td>
<td>未来5年投融资意向</td>
<td>状态</td>
<td>操作</td>
</tr>
<c:forEach var="list" items="${list}">
        <tr><td>
        <input type="checkbox" name="check" value="${list.eid }"/></td>
            <td>${list.ename}</td>
            <td>${list.econtacts}</td>
            <td>${list.eaddress}</td>
            <td>${list.eamount}</td>
            <td>${list.balance}</td>
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
            
                <a href="${pageContext.request.contextPath}/enterprise/enterpriseuserlist.do?eid=${list.eid}">修改</a>
                <button onclick="dele(${list.eid},${page.pageNum})">删除</button>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td><input type="checkbox" name="check1" onclick="if(this.checked==true) { checkAll('check'); } else { clearAll('check'); }"/>全选
        </td>
        <td>
            <input type="button" value="上一页" onclick="up(${page.pageNum})">
            <input type="button" value="下一页 " onclick="down(${page.pageNum},${page.pages })">
            共${page.pageNum}/${page.pages}页
        </td>
        <td></td>
    </tr>
    </table>
    
</body>
<script type="text/javascript">

function down(thispage,page) {
    
    if(thispage!=page&&thispage!=0){
       
             window.location.href="${pageContext.request.contextPath}/enterprise/list.do?thispage="+(thispage+1);
         
    }
 
}
function up(thispage) {
    if(thispage!=1&&thispage!=0){
        
             window.location.href="${pageContext.request.contextPath}/enterprise/list.do?thispage="+(thispage-1);
    }
     
 }
</script>
</html>