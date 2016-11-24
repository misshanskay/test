<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- 这是jstl标签 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>发布信息显示页面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#select").click(function() {
			if (this.checked) {
				$("input[name='id']").each(function() {
					this.checked = true
				});
			} else {
				$("input[name='id']").each(function() {
					this.checked = false
				});
			}

		})
	})

	function edits() {
		/*  var str="";
		 $("input[name='ids']").each(function(){
			 if(this.checked==true)
			   str+=$(this).val()+",";
			  }); */
		document.getElementById("frm").action = "${pageContext.request.contextPath}/releaseinfo/edits.do";
		document.getElementById("frm").submit();
	}

	//当选择按照状态查询时
	$(document).ready(
		function() {
		$("#state").change(
			function() {
			//获取被选中的选项
			//var datas = $(this).children("option:selected").val(); 
			document.getElementById("frm").action = "${pageContext.request.contextPath}/releaseinfo/edit.do";
			document.getElementById("frm").submit();
										}
								)
					}

			)

/* 	$(document).ready(
		function() {
		$("#itemBusiness")
		.change(
		function() {
		//var datas = $(this).children("option:selected").val();
		document.getElementById("frm").action = "${pageContext.request.contextPath}/releaseinfo/findByIB.do";
		document.getElementById("frm").submit();
						})
					}) */
					
					
	$(document).ready(
		function(){
			$("#projectBusiness").change(
				function (){
					document.getElementById("frm").action="${pageContext.request.contextPath}/releaseinfo/selectByCondition.do";
					document.getElementById("frm").submit();
					
				}		
			)
		}		
	)
	
		$(document).ready(
		function(){
			$("#issuer").change(
				function (){
					document.getElementById("frm").action="${pageContext.request.contextPath}/releaseinfo/selectByCondition.do";
					document.getElementById("frm").submit();
					
				}		
			)
		}		
	)
	
	
		function show(win){
		var win = document.getElementById(win);
		if(win){
			 if(win.style.display=='block'){  
				 win.style.display='none';  
				   }else{  
					   win.style.display='block';  
				   }  
		}
	}
	
	function download(){
		var ids="";
		$("input[name='id']").each(
			function(){
				if(this.checked){
					ids+=$(this).val()+",";
				}
			}		
		)
		document.getElementById("ids").value=ids;
		document.getElementById("frm").action="${pageContext.request.contextPath}/releaseinfo/export.do";
		document.getElementById("frm").submit();
		 if(ids!=""){
			$("#select").checked = false;
			$("input[name='id']").each(
					function (){
						this.checked = false;	
						}
				)
		}  
	}
	
	function verification(){
		var code = document.getElementById("code").value;
		$.ajax({
			url:"${pageContext.request.contextPath}/releaseinfo/code.do",
			data:"code="+code,
			cache:false,
			type:"post",
			success:function(result){
				if(result==null){	
					alert("验证码错误！请重新输入");
				}else{
					 show('win');	
					 download();
				}
			}
		})
	}
</script>

<style type="text/css">
	#win {
		position:absolute;
		top:20%;
		left:50%;
		width:400px;
		height:300px;
		background:#fff;
		margin:102px 0 0 -202px;
		/* line-height: 200px; */
		text-align: center;
		border: 4px solid #CCC;
		display: none;
		font-size: 25px;
		}
</style>
</head>
<body style="width: 1000px">
	<form action="" id="frm">
		<input type="hidden" id="str" name="str" value="2">
		<input type="hidden" id="ids" name="ids" value="">
		<table width="%100" border="1">
			<tr>
				<td>招商信息</td>
				<td>
        <select name="projectBusiness" id="projectBusiness">
            <option value="">请选择</option>
            <c:forEach var="list" items="${map1.type}">
            <option value="${list }">${list }</option>
            </c:forEach>
            
        </select>
				</td>
				<td>
					<select id="issuer" name="issuer">
						<option value="">所有发布者</option>
						<option>濮阳县</option>
						<option>企业</option>
					</select>
				</td>
				<td><a
					href="${pageContext.request.contextPath}/releaseinfo/toAdd.do">发布信息</a></td>
				<td>
					<input type="button" value="企业查询" onclick="query()">
				</td>
				<td><input type="button" value="批量审批" onclick="edits()">
				</td>
				<td><input type="button" value="下载招商信息" onclick="show('win')"></td>
			</tr>
			<tr>
				<td>选择</td>
				<td>发布时间</td>
				<td>项目名称</td>
				<td>发 布 人</td>
				<td>项目类型</td>
				<td>状 &nbsp;态</td>
				<td>操 作</td>
			</tr>
				<c:forEach var="releaseinfo" items="${riList}">
				<tr>
					<td><input type="checkbox" id="id" name="id" value="${releaseinfo.id}"></td>
					<td>${releaseinfo.createTime}</td>					
					<td>${releaseinfo.projectName}</td>					
					<td>${releaseinfo.issuer}</td>					
					<td>${releaseinfo.projectType}</td>					
					<td>
						<c:if test="${releaseinfo.state==3||releaseinfo.state==2}">
							已审核						
						</c:if> 
						<c:if test="${releaseinfo.state==1}">
							待审核
						</c:if>
					</td>					
					<td>
						<c:if test="${releaseinfo.state==3||releaseinfo.state==2}">
							<a href="${pageContext.request.contextPath}/releaseinfo/check.do?id=${releaseinfo.id}">查看</a>					
						</c:if> 
						<c:if test="${releaseinfo.state==1}">
							<a href="${pageContext.request.contextPath}/releaseinfo/shenhe.do?id=${releaseinfo.id}">审核</a>
						</c:if>
							<a href="${pageContext.request.contextPath}/releaseinfo/toUpdate.do?id=${releaseinfo.id}">编辑</a>
							<a href="${pageContext.request.contextPath}/releaseinfo/delete.do?id=${releaseinfo.id}" onclick="if(confirm('确定删除吗?')==false){return false}">删除</a>
					</td>					
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7"><input type="checkbox" id="select" name="select">全选</td>
			</tr>
		</table>
	<div id="win" class="win">
		<tr>
			<td>下载密码密码验证</td>
		</tr>
		<hr/>
		<tr>
			<td>下载密码：</td>
			<td><input type="text" id="code" name="code"></td>
		</tr><br><br>
		<tr>
			<td><input type="button" value="确定" onclick="verification()"></td>
			<td><input type="button" value="取消" onclick="show('win')"></td>
		</tr>
	</div>
	</form>
</body>
</html>