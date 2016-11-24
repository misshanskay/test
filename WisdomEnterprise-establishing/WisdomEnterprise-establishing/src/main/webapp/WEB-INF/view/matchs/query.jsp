<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>匹配查询页面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
  $(document).ready(
	function(){
		$("#provinceid").change(
			function (){
				var provincecode = jQuery("#provinceid option:selected").val();
				$.ajax({ 
					url: "${pageContext.request.contextPath}/matchs/querycity.do",
					cache:false,
					data:"provincecode="+provincecode,//encodeURI(encodeURI(selValue)),
					dataType:"json",
					type:"post",
					success: function(data){
			       var ln= $("#city option").size();	
			      // $("#city").empty(); 
					while(ln > 1){
						document.getElementById("city").remove(document.getElementById("city").options.length - 1);						
						 --ln; 
						}
					for(var i =0; i < data.length; i++){
						$("#city").append("<option value="+data[i].name+">"+data[i].name+"</option>"); 
						}
			      }});
			}		
		)
	}	  
  )
  
  function commit(){
	  var fundBudget1 = document.getElementById("fundBudget1").value;
	  var fundBudget2 = document.getElementById("fundBudget2").value;
	  if((fundBudget1=="请输入投融资金额"&&fundBudget2!="请输入投融资金额")||(fundBudget1!="请输入投融资金额"&&fundBudget2=="请输入投融资金额")){
		  alert("请输入投融资金额范围");
		  return false;
	  }else if(fundBudget1!="请输入投融资金额"&&fundBudget2!="请输入投融资金额"){
		 $("#fundBudget").attr("value",fundBudget1+","+fundBudget2);
	  }
	  if(document.getElementById("projectName").value=="请输入投融资关键字"){
		  $("#projectName").attr("value","");
	  }
	  document.getElementById("frm").submit();
  }
</script>
</head>
<body style="align: center;">
<form action="${pageContext.request.contextPath}/matchs/query.do" id="frm">
	<input type="hidden" id="fundBudget" name="fundBudget" value="">   
      	  <div style="margin-top:50px; width:800px; border:1px solid #F00; margin-left: 200px">
      	  	招商意向：<select id="projectFinancingMode" name="projectFinancingMode">
      	  			<option value="">请选择</option>
      	  			<option>找项目</option>
      	  			<option>找资金</option>
      	  			<option>找厂址</option>
      	  			<option>技术输出</option>
      	  			<option>投资输出</option>
      	  			<option>其它</option>
      	  	</select><br/><br/>
      	  	行业选择:<select name="projectBusiness">
      	  			<option value="">请选择</option>
      	  			<option>休闲行业</option>
      	  			<option>其它行业</option>
      	  			<option>农林畜牧</option>
      	  			<option>医药卫生</option>
      	  			<option>水利水电</option>
      	  			<option>信息产业</option>
      	  			<option>家居用品</option>
      	  			<option>体育用品</option>
      	  			<option>冶金矿产</option>
      	  	</select><br/><br/>
      	  	投融资金额：<input type="text" id="fundBudget1" name="fundBudget1" value="请输入投融资金额" onfocus="if (value =='请输入投融资金额'){value =''}"onblur="if (value ==''){value='请输入投融资金额'}"> 万元 至 
      	  	<input type="text" id="fundBudget2" name="fundBudget2" value="请输入投融资金额" onfocus="if (value =='请输入投融资金额'){value =''}"onblur="if (value ==''){value='请输入投融资金额'}"> 万元<br/><br/>
      	  	地区：<select id="provinceid" name="provinceid">
      	  			<option value="">请选择省市</option>
      	  			<c:forEach var="province" items="${plist}">
      	  				<option value="${province.code}">${province.name}</option>
      	  			</c:forEach>
      	  	</select> 
      	  	<select id="city" name="city">
      	  		<option value="">全部</option>
      	  	</select><br/><br/>
      	  	合作方式：<select name="cooperationMode">
      	  			<option value="">请选择</option>
      	  			<option >独资</option>
      	  			<option >合资</option>
      	  			<option >合作</option>
      	  	</select><br/><br/>
      	  	关键字：<input type="text" id="projectName" name="projectName" value="请输入投融资关键字" onfocus="if (value =='请输入投融资关键字'){value =''}"onblur="if (value ==''){value='请输入投融资关键字'}"><br/><br/>
      	  	<input type="button" value="确定" onclick="commit()"> <a href="${pageContext.request.contextPath}/matchs/findAll.do"><input type="button" value="取消"></a> 
      	  </div>
</form>

</body>
</html>