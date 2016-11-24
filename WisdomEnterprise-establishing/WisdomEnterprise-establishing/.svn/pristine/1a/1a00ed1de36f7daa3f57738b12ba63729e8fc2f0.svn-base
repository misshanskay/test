<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>统计分析</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/autosuggest.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/Highcharts-4.2.6/js/highcharts.js"></script>   
   <script src="${pageContext.request.contextPath}/Highcharts-4.2.6/js/modules/data.js"></script> 
</head>
<body>
<table class="table">
<tr>
<c:forEach var="list" items="${list}">
        <td>${list }<td>
    </c:forEach></tr> 
    <tr>
   <c:forEach var="list1" items="${list1}">
        <td>${list1 }<td>
    </c:forEach>
    </tr>
    <tr>
   <c:forEach var="list2" items="${list2}">
        <td>${list2 }<td>
    </c:forEach>
    </tr>
    <tr>
   <c:forEach var="list3" items="${list3}">
        <td>${list3 }<td>
    </c:forEach>
    </tr>
    <tr>
   <c:forEach var="list4" items="${list4}">
        <td>${list4 }<td>
    </c:forEach>
    </tr>
    <tr>
   <c:forEach var="list5" items="${list5}">
        <td>${list5 }<td>
    </c:forEach>
    </tr>
    <tr>
   <c:forEach var="list6" items="${list6}">
        <td>${list6 }<td>
    </c:forEach>
    </tr>
    </table>
    <div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
</div>
</body>
<script language="JavaScript">
//定义一个Highcharts的变量，初始值为null
var oChart = null;
//定义oChart的布局环境
//布局环境组成：X轴、Y轴、数据显示、图标标题
var oOptions = { 
 //设置图表关联显示块和图形样式
 chart: { 
  renderTo: 'container', //设置显示的页面块
  type:'line' 
 },
 //图标标题
 title: { 
  text: '图表展示范例', //设置标题
  //text: null, //设置null则不显示标题
 },
 //x轴
  xAxis: {
  title: {
   text: 'X 轴 标 题'
  },
  categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'] 
 }, 
 //y轴
  yAxis: {
  title: { text: 'Y 轴 标 题' }, //设置Y轴标题关闭
 }, 
 //数据列
 series: [] 
}; 
 $(document).ready(function(){
	 oChart = new Highcharts.Chart(oOptions);

 LoadSerie_Ajax();
}); 
//异步读取数据并加载到图表
function LoadSerie_Ajax() { 
  oChart.showLoading(); 
  $.ajax({ 
   url : '${pageContext.request.contextPath}/statistics/data.do',
   type : 'POST',
   dataType : 'json',
   async : false, //同步处理后面才能处理新添加的series
   contentType: "application/x-www-form-urlencoded; charset=utf-8", 
   success : function(ss){
	   
	   var m=[120,360,560,60,360,160,40,360,60]
       var oSeries = {
    		     name: "第二条",
    		     
                     data:m
               
    		    };
       var oSeries1 = {
               name: "第3条",
               
                   data:[120,360,560,60,360,160,40,360,60]
             
              };
       
       /* oChart.addAxis({
    	   title: {
    		   text: 'X 轴 标 题'
    		  },
    		  categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'] 
    		 },true); */
       oChart.addSeries(oSeries)
       oChart.addSeries(oSeries1)
	   
	  
   }
  });
  oChart.hideLoading(); 
}
</script>
</html>