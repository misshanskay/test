<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
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
	
	function check(id){
		show("win2");
		show("win");
		$.ajax({
			url: "${pageContext.request.contextPath}/releaseinfo/pay.do",
			cache:false,
			data:"id="+id,
			dataType:"json",
			type:"post",
			success:function(data){
				if(data==1){
					alert("余额不足!请充值");
				}else{
		            var htmls = "<table>";
			           /*  for(var i=0;i<data.length;i++){ */
			                htmls += "<tr><td>"+"项目所属单位:"+data[0]+"</td></tr><tr><td>"+"详细地址:"+data[1]+"</td></tr>"+
			                "<tr><td>"+"联系人:"+data[2]+"</td></tr><tr><td>"+"联系电话:"+data[3]+"</tr></td><tr><td>"
			                +"联系邮箱："+data[4]+"</td></tr><tr><td>"+"联系传真号码:"+data[5]+"</td></tr>";
			           /*  } */
			            htmls += "</table>";
			            //假设你的区域3是一个div，div的id="quyu3"
			            document.getElementById("win1").innerHTML=htmls;
				}

			}
		})
	}
	
	
</script>

<style type="text/css">
	#win {
		position:absolute;
		top:50%;
		left:50%;
		width:400px;
		height:200px;
		background:#00FF00;
		margin:102px 0 0 -202px;
		/* line-height: 200px; */
		text-align: center;
		border: 4px solid #CCC;
		display: none;
		font-size: 3px;
		}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息发查看页面</title>
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
			</tr><br/>
			<tr><td>项目类型： ${releaseinfo.projectType}</td></tr><br/>
			<tr><td>合作模式： ${releaseinfo.cooperationMode}</td></tr><br/>
			<tr><td>项目所属行业： ${releaseinfo.projectType}</td></tr><br/>
			<tr><td>项目地区： ${releaseinfo.projectArea}--${releaseinfo.city}</td><br/>
			</tr>
		</div>
		
		<div style="margin-left: 80px; width: 800px; height: 80px;  text-align: center; margin-top: 50px">
			<tr>
				<td>投资总额： ${releaseinfo.fundBudget}万元</td>
			</tr>
		</div>
		
		<div style="margin-left: 80px; width: 800px; height: 100px;  text-align: center; margin-top: 50px">
			<tr>
				<td>项目主要内容： ${releaseinfo.projectContent}</td>
			</tr>
		</div>
		<div id="win2"  style="display:block; margin-left: 80px; width: 800px; height: 50px;  text-align: center; margin-top: 50px">
				<input type="button" value="查看联系方式" onclick="show('win')">
		</div>
		<div id="win1" class="win1" style="display:none; margin-left: 80px; width: 800px; height: 50px;  text-align: center; margin-top: 50px">
		</div>
		<div id="win" class="win">
		<tr>
			<td>${releaseinfo.projectName}</td>
		</tr>
		<hr/>
		<tr>
			<td>所需招商币：50 币</td>
		</tr>	
		<tr>
			<td><input type="button" value="确认支付" onclick="check('${releaseinfo.id}')"></td>
			<td><a href="跳转充值页面"><input type="button" value="充值"></a></td>
		</tr>
		<hr/>
		<tr>
			<td>说明： 1招商币=人民币</td>
		</tr>
	</div>
		<div id="" style="margin-left: 80px; width: 800px; height: 100px;  text-align: center; margin-top: 50px">
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
					WEB：<input type="checkbox" value="WEB" ${fn:containsIgnoreCase(releaseinfo.releasePosition,'WEB')?"checked":""}/>
				</td>
				<td>
					信息化大屏：<input type="checkbox" value="信息化大屏" ${fn:containsIgnoreCase(releaseinfo.releasePosition,'信息化大屏')?"checked":""}/>
				</td>
				<td>
					自助终端机：<input  type="checkbox" value="自助终端机" ${fn:containsIgnoreCase(releaseinfo.releasePosition,'自助终端机')?"checked":""}/>
				</td>
				<td>
					APP<input type="checkbox" value="APP" ${fn:containsIgnoreCase(releaseinfo.releasePosition,'APP')?"checked":""}/>
				</td>
			</tr>
		</div>
		
		<div style="margin-left: 80px; width: 800px; height: 100px;  text-align: center; margin-top: 50px">
			<tr>
				<td>
					<c:if test="${releaseinfo.state==2}">
							已审核通过						
					</c:if> 
					<c:if test="${releaseinfo.state==3}">
							审核未通过
					</c:if>
				</td>
			</tr>
		</div>	
		<div style="margin-left: 80px; width: 800px; height: 100px;  text-align: center; margin-top: 50px">
			<tr>
				<td><a href="${pageContext.request.contextPath}/releaseinfo/findAll.do"><input type="button" value="返回"></a></td>
			</tr>
		</div>				
	</form>
</body>
</html>