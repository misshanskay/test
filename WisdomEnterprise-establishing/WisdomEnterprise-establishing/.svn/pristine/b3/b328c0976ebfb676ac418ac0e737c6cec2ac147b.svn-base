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
 <script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
function search() {
	
	window.location.href="${pageContext.request.contextPath}/statistics/money.do?time1="+$("#time1").val()+"&time2="+$("#time2").val();
}
</script>
</head>
<body>
<font size=6>统计分析</font>
<a href="${pageContext.request.contextPath}/statistics/money.do">财务统计</a>
<a href="${pageContext.request.contextPath}/statistics/user.do">会员统计</a>
<a href="#">招商信息分析</a>
<hr>
从<input type="text" id="time1" name="time1" onfocus="WdatePicker({dateFmt: 'yyyy-MM'});" value="${time1 }">
到<input type="text" id="time2" name="time2" onfocus="WdatePicker({dateFmt: 'yyyy-MM'});" value="${time2 }">
<input type="button" value="查询" onclick="search()">
<table class="table">
<tr>
<c:forEach var="list" items="${list}">
        <td>${list}<td>
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
    </table>
    <div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
</div>
</body>
<script language="JavaScript">
(function($){ // encapsulate jQuery
	var chart;
	
	$(document).ready(function() {

	    chart = new Highcharts.Chart({
	        chart: {
	            renderTo: 'container',
	            type: 'line',
	            marginRight: 90,
	            marginBottom: 100
	        },
	        title: {
	            text: '财务统计曲线图',
	            x: -20 //center
	        },
	        subtitle: {
	            text: '',
	            x: -20
	        },
	        xAxis: {
	            categories: ${s}
	        },
	        yAxis: {
	            title: {
	                text: '数量'
	            },
	            plotLines: [{
	                value: 0,
	                width: 2,
	                color: '#808080'
	            }]
	        },
	        tooltip: {
	            formatter: function() {
	                    return '<b>'+ this.series.name +'</b><br/><br/>'+
	                    this.x +': '+ this.y +'个';
	            }
	        },
	        legend: {
	            layout: 'vertical',
	            align: 'right',
	            verticalAlign: 'top',
	            x: 10,
	            y: 150,
	            borderWidth: 0
	        },
	        series:[${s1},${s2},${s3}]
	         
	    });
	});
	})(jQuery);
</script>
</html>