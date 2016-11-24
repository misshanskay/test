<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>企业审核</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
     <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
</head>
<body>


     <div class="form-group">
    <label for="nome">企业名称:${enterprise.ename }</label>
    </div>
     <div class="form-group">
    <img src="${pageContext.request.contextPath}/${enterprise.ebusiness}" width="200" height="80"/>
    <label for="business">营业执照号</label>
    <label for="busines">${enterprise.ebusines }</label>
    </div>
    <div class="form-group">
    <img src="${pageContext.request.contextPath}/${enterprise.etex}" width="200" height="80"/>
    <label for="tex">税务登记号</label>
    <label for="te">${enterprise.ete }</label>
    </div>
    <div class="form-group">
         <label for="amount">注册金额:${enterprise.eamount }</label>
        <label for="amount">万元</label>
     </div>
     <div class="form-group">
         <label for="legal">企业法人:${enterprise.elegal }</label>
        
     </div>
      
    <div class="form-group">
        <label>注册地址:${enterprise.eaddress}</label>
    </div>
    
   
     <div class="form-group">
        <label for="time">注册时间:${time }</label>

    </div>
     <div class="form-group">
         <label for="range">经营范围:${enterprise.erange }</label>
        
     </div>
     <div class="form-group">
         <label for="contacts">联系人:${enterprise.econtacts }</label>
        
     </div>
     <div class="form-group">
         <label for="phone">联系电话:${enterprise.ephone }</label>
        
     </div>
    <div class="form-group">
        <label for="email">邮箱地址:${enterprise.eemail }</label>
    </div>
    
    <div class="form-group">
        <label>招商意向:${enterprise.eintention}</label>
    </div>
    
    <div class="form-group">
        <label>行业类型:${enterprise.etype}</label>
    </div>
    <table id="table1" class="table">
    <tr>
        <th >用户名</th>
        <th >真实姓名</th>
        <th >就职单位</th>
        <th >职务</th>
        <th >编辑</th>
    </tr>

    <c:forEach var="list" items="${enterprise.userU}">
        <tr>
            <td>${list.uname}</td>
            <td>${list.userExtend.urealname}</td>
            <td>${list.userExtend.uunit}</td>
            <td>${list.userExtend.upost}</td>
            <td>
            <input type="button" value="修改" onclick="update(${list.uid})">
                <input type="button" id="in1" style="color:<c:if test="${list.enabled==1 }">green</c:if><c:if test="${list.enabled==0 }">red</c:if>" onclick="dele(${list.uid},this)" value="<c:if test="${list.enabled==1 }">启用</c:if><c:if test="${list.enabled==0 }">禁用</c:if>">
                
                </input>
            </td>
        </tr>
    </c:forEach>
    
</table>
<c:if test="${enterprise.estatus==1 }">
<a href="${pageContext.request.contextPath}/enterprise/reviewed1.do?eid=${enterprise.eid}&status=2">审核通过</a>
    <a href="${pageContext.request.contextPath}/enterprise/reviewed1.do?eid=${enterprise.eid}&status=3">审核不通过</a>
</c:if>
<br>
    <a href="${pageContext.request.contextPath}/enterprise/list.do">返回</a>
    
</body>
</html>