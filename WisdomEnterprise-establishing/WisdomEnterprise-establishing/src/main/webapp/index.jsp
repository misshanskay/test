<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%
  String base_path = request.getContextPath();
  String base_basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+base_path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>主页</title>
  <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
function check(){
	alert($("#we").val())
	$("input:checkbox[value='123']").attr('checked','true');
	
}
function check() {
	var value=124;
	$("input:checkbox[value='"+value+"']").prop('checked',true);
}
function uncheck() {
	var value=124;
	$("input:checkbox[value='"+value+"']").prop('checked',false);
}
</script>
</head>
<body>
<button onclick="check()">1111</button>
<button onclick="uncheck()">1111</button>
<select id="we" onchange="check()">
<option>111</option>
<option>112</option>
<option>114</option>
<option>113</option>

</select>
<input type="checkbox" name="1" value="123"  id="we">123
<input type="checkbox" name="1" value="124">124
<input type="checkbox" name="1" value="125">125
<input type="checkbox" name="1" value="126">126
</body>
</html>
