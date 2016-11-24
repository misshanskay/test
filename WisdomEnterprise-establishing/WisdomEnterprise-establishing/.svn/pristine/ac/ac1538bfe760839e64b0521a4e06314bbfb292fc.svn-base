<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入账扣款</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
		function submits(){
			var username=$("#userName").val();
			var note=$("#note").val();
			var deal=$("#deal").val();
			var number=$("#number").val();
			var way=$("#way option:selected").val();
			var type=$("#type option:selected").val();
			
			if(username==null || username==''){
				alert("请输入用户名！");
				return false;
			}else if(deal==null || deal==''){
				alert("请输入金额");
				return false;
			}else if(number==null || number==''){
				alert("请输入订单号！");
				return false;
			}else if(way==null||way==""){
				alert("请选择付款方式！");
				return false;
			}else if(type==null||type==''){
				alert("请选择记账摘要！");
				return false;
			}
			$.ajax({ 
				url: "${pageContext.request.contextPath}/booked/reduce.do",
				cache:false,
				data:"type="+type+"&userName="+username+"&deal="+deal+"&number="+number+"&way="+way+"&note="+note,
				type:"POST",
				success: function(data){
					if(data==1){
						resetValue();
						alert("入账成功！");
					}else if(data==2){
						resetValue();
						alert("扣款成功！");
					}else if(data==0){
						alert("入账失败或扣款失败！");
					}
					}
				})			
		}
		
		// 重置数据
		function resetValue(){
			$("#userName").val("");
			$("#type option:first").attr("selected","selected");
			$("#way option:first").attr("selected","selected");
			$("#deal").val("");
			$("#number").val("");
			$("#note").val("");
		}
		
	//查询用户是否存在
	 function checkNameIsExist(){
      
	        var userName = $.trim($("#userName").val());    
	        $.ajax({    
	            type:"POST",   
	            url:"${pageContext.request.contextPath}/account/check.do",
	            data:"userName="+userName,
	            cache:false,
	            success: function(data){    
	            	if(data==0){
	            		alert("用户不存在，请重新输入！");
	            		$("#userName").val("");
	            	}   
	           }     
	        }); 
		}
	 
	//查询订单是否存在
	 function checkNumIsExist(){
	      
	        var number = $.trim($("#number").val());    
	        $.ajax({    
	            type:"POST",   
	            url:"${pageContext.request.contextPath}/account/checknum.do",
	            data:"number="+number,
	            cache:false,
	            success: function(data){    
	            	if(data==0){
	            		alert("订单不存在，请重新输入！");
	            		$("#number").val("");
	            	}   
	           }     
	        }); 
		}
</script>
<style type="text/css">
li {list-style-type:none; }
</style>
</head>
<body style="align: center;">
<form action="" id="frm">
	<div style="margin-top:50px; width:800px; border:1px solid #F00; margin-left: 200px">
			<ul>
				<li>
					记账摘要:
					 <select id="type" name="type">
							<option value="">请选择</option>
							<option value="1">入账</option>
							<option value="3">扣账</option>
					 </select><span style="color: red;">*</span>
				</li>
				<li><!-- onblur="checkNameIsExist();" -->
					 用户名：<input type="text" id="userName" name="userName"/><span style="color: red;">*</span>
				</li>
				<li>
					记账金额：<input type="text" id="deal" name="deal">元<span style="color: red;">*</span>
				</li>
				<li><!-- onblur="checkNumIsExist()" -->
					 订单编号：<input type="text" id="number" name="number"/><span style="color: red;">*</span>
				</li>
				<li>
					付款方式：
					 <select id="way" name="way">
					 		<option value="">请选择</option>
							<option>支付宝</option>
							<option>微信</option>
							<option>网银在线</option>
							<option>现金</option>
							<option>公司账号</option>
							<option>邮政汇款</option>
					 </select><span style="color: red;">*</span>
				</li>
				<li>
					备注：<input type="text" id="note" name="note">
				</li>
				<li>
						<input type="button" value="确定" onclick="submits()">
				</li>
			</ul>   
     </div>
</form>
</body>
</html>