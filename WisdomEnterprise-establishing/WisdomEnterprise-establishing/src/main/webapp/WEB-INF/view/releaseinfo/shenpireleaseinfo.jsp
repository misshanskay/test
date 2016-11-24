<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function shenhe(ids) {
		if (ids == 2) {
			document.getElementById("str").value = 2;
			document.getElementById("frm").action = "${pageContext.request.contextPath}/releaseinfo/edits.do";
		} else {
			document.getElementById("str").value = 3;//审批不通过
			document.getElementById("frm").action = "${pageContext.request.contextPath}/releaseinfo/edits.do";
		}
		document.getElementById("frm").submit();

	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息发布审批页面</title>
</head>
<body>
	<form action="" id="frm">
		<div style="margin-left: 80px; width: 800px; height: 50px;  text-align: center; margin-top: 50px">
			<tr>
				<td><font size="6px">${releaseinfo.projectName}</font></td>
			</tr>
		</div>
		<hr>
		<div style="margin-left: 80px; width: 800px; height: 50px;  text-align: center; margin-top: 50px">
			<tr>
				<td>发布人： ${releaseinfo.issuer}</td>
				<td>发布时间： ${releaseinfo.createTime}</td>
			</tr>
		</div>
		<div style="margin-left: 80px; width: 800px; height: 200px;  text-align: center; margin-top: 50px">
			<tr>
				<td>项目名称： ${releaseinfo.projectName}</td>
				<td>项目类型： ${releaseinfo.projectType}</td>
				<td>合作模式： ${releaseinfo.cooperationMode}</td>
				<td>项目所属行业： ${releaseinfo.projectType}</td>
				<td>项目地区： ${releaseinfo.projectArea}--${releaseinfo.city}</td>
			</tr>
		</div>
		
		<div style="margin-left: 80px; width: 800px; height: 80px;  text-align: center; margin-top: 50px">
			<tr>
				<td>投资总额： ${releaseinfo.fundBudget}</td>
			</tr>
		</div>
		
		<div style="margin-left: 80px; width: 800px; height: 100px;  text-align: center; margin-top: 50px">
			<tr>
				<td>项目主要内容： ${releaseinfo.projectContent}</td>
			</tr>
		</div>
		
		<div style="margin-left: 80px; width: 800px; height: 100px;  text-align: center; margin-top: 50px">
			<tr>
				<td>联系人： ${releaseinfo.linkman}</td>
				<td>联系地址： ${releaseinfo.address}</td>
			</tr>
			<tr>
				<td>联系电话： ${releaseinfo.phone}</td>
				<td>转真号码： ${releaseinfo.faxNumber}</td>
			</tr>
			<tr>
				<td>联系邮箱：${releaseinfo.email}</td>
			</tr>
		</div>
		
		<div style="margin-left: 80px; width: 800px; height: 100px;  text-align: center; margin-top: 50px">
			<tr>
				<td>发布位置</td>
				<td>
					<input type="checkbox" value="WEB" ${fn:containsIgnoreCase(releaseinfo.releasePosition,'WEB')?"checked":""}/>
				</td>
				<td>
					<input type="checkbox" value="信息化大屏" ${fn:containsIgnoreCase(releaseinfo.releasePosition,'信息化大屏')?"checked":""}/>
				</td>
				<td>
					<input  type="checkbox" value="自助终端机" ${fn:containsIgnoreCase(releaseinfo.releasePosition,'自助终端机')?"checked":""}/>
				</td>
				<td>
					<input type="checkbox" value="APP" ${fn:containsIgnoreCase(releaseinfo.releasePosition,'APP')?"checked":""}/>
				</td>
			</tr>
		</div>
		<div style="margin-left: 80px; width: 800px; height: 100px;  text-align: center; margin-top: 50px">
			<tr>
				<td><input type="button" value="审批通过" onclick="shenhe(2)"></td>
				<td><input type="button" value="审批不通过" onclick="shenhe(3)"></td>
				<input type="hidden" name="id" id="id" value="${releaseinfo.id}">
				<input type="hidden" name="str" id="str" value="">
			</tr>
		</div>
				
	</form>
</body>
</html>