<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<html>
<head>
  <title>主页</title>



</head>
<frameset rows="10%,90%">
		<frame src="${pageContext.request.contextPath }/user/top.do" noresize="noresize" frameborder="0"/>
		<frameset cols="10%,90%">
			<frame src="${pageContext.request.contextPath }/user/right.do" noresize="noresize" scrolling="no" frameborder="0" name="left_frame"/>
			<frame src="${pageContext.request.contextPath }/user/left.do" noresize="noresize" frameborder="0" name="right_frame"/>
		</frameset>
</frameset>
<body>


</body>

</html>
