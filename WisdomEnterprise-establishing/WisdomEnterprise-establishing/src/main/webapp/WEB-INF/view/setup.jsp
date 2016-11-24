<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<title>系统设置</title>
<script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-form.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	
	$("#file").hide();
	$("#base").hide();
	$("#butt3").hide();
	$("#butt2").hide();
	$("#b2").hide();
	})
	function base() {
	$("#labe").hide();
	$("#butt1").hide();
	$("#base").show();
	$("#butt2").show();
	$("#butt3").show();
		
	}
 function base1() {
		var base=$("#base").val()
		$.post("${pageContext.request.contextPath}/user/upbase.do",{
			base:base
		},function(data){
			$("#labe").show();
			$("#butt1").show();
			$("#labe").html(data.data)
			$("#base").hide();
			$("#butt2").hide();
			$("#butt3").hide();
		})
			
		}
 function base2() {
		$("#labe").show();
		$("#butt1").show();
		$("#base").hide();
		$("#butt2").hide();
		$("#butt3").hide();
			
		}
 function file() {
		
		$("#b1").hide();
		
		$("#file").show();
		
			
		}
 function upfile() {
	 $("#form1").ajaxSubmit({
		 type : 'post',
		 url:'/WisdomEnterprise-establishing/user/upfile.do',
	      dataType:'json',
	      success:function(data){
	    	  if(data.status==200){
	    	  var name=getRootPath()+"/"+data.data
	    	  var value = "<img src='"+name+"' height='60' width='234' />";
		        $("#setimg").empty().append(value);
	    	 
	  		$("#b1").show();
	  		
	  		$("#img").hide();
	  		$("#file").hide();
	    	  }else{
	    		  alert(data.msg)
	    	  }
	       
	      }
   	});
		
			
		}
 
 function pagenumber(obj) {
	 $.post("${pageContext.request.contextPath}/user/uppagenumber.do",{
         pagenumber:obj.value
     },function(data){
         obj.value=data.data
     })
}
 
 function getRootPath(){      
	    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp      
	    var curWwwPath=window.document.location.href;      
	    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp      
	    var pathName=window.document.location.pathname;      
	    var pos=curWwwPath.indexOf(pathName);      
	    //获取主机地址，如： http://localhost:8083      
	    var localhostPaht=curWwwPath.substring(0,pos);      
	    //获取带"/"的项目名，如：/uimcardprj      
	    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);      
	    return(projectName);  
	}  
 
</script>
</head>
<body>

<img id="img" src="${pageContext.request.contextPath}/${imgsrc }" width="234px" height="60px"/>
<div id="setimg"></div>
logo:
<button onclick="file()" id="b1">修改</button>
</div>
<form  id="form1" name="form1" method="post" action="${pageContext.request.contextPath}/user/upfile.do" enctype="multipart/form-data">
<input type="file" id="file" name="file" onchange="upfile()"/>

</form>


备案号信息：<label id="labe">${base }</label>
<input type="text" value="${base }" id="base"/>
<button onclick="base()" id="butt1">修改</button>
<button onclick="base1()" id="butt2">确定</button>
<button onclick="base2()" id="butt3">取消</button><br>
每页记录数<input type="text" value="${pagenumber }" onchange="pagenumber(this)"/>
</body>
</html>