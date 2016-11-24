<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告添加页面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<!-- 配置文件 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript">
	function submits(){
		var title=$("#title").val();
		var content=UE.getEditor('content').getContent();
		
		if(title==null || title==''){
			alert("请公告标题！");
			return false;
		}
		var reg=/[a-zA-Z\u4E00-\u9FA5]+$/;  
		if(title!=null){
		if(reg.test(title)) {  
               
             }else{
            	 alert("输入内容包含非法字符，输入内容只能是中文或英文！");
            	 return false;  
             }  
             
		}
		var i = 0;
		$("input[name='receiveTerminal']").each(
			function(){			
				if(this.checked==false){
					i++;
				}	
			}		
		)
		if(i==6){
			alert("至少选择一个终端！");
			return false;
		}
		if(content==null || content==''){
			alert("请输入内容！");
			return false;
		}
		document.getElementById("frm").action="${pageContext.request.contextPath}/notice/add.do";
		document.getElementById("frm").submit();
	}
</script>

</head>
<body>
<form action="" id="frm">
	<div id="p" title="编写公告信息" style="padding:10px">
 	<table>
   		<tr>
   			<td width="80px"><span style="color: red;">*</span>公告标题：</td>
   			<td><input type="text" id="title" name="title" style="width: 400px;"/></td>
   		</tr>
   		<tr>
   			<td width="80px"><span style="color: red;">*</span>接收终端：</td>
   			<td>
   			<input type="checkbox" id="receiveTerminal" name="receiveTerminal"  value="全部"/>全部<input type="checkbox" id="receiveTerminal" name="receiveTerminal" value="政府端后台 "/>政府端后台 
   			<input type="checkbox" id="receiveTerminal" name="receiveTerminal"  value="企业端后台"/>企业端后台<input type="checkbox" id="receiveTerminal" name="receiveTerminal"  value="信息化大屏"/>信息化大屏
   			<input type="checkbox" id="receiveTerminal" name="receiveTerminal"  value="自助终端"/>自助终端<input type="checkbox" id="receiveTerminal" name="receiveTerminal"  value="门户前台"/>门户前台
   			</td>
   		</tr>
   		<tr>
   			<td valign="top"><span style="color: red;">*</span>公告内容：</td>
   			<td>
				  <!--  <script id="editor" type="text/plain" style="width:100%;height:500px;"></script> -->
   				  <textarea id="content" name="content" style="width:100%;height:500px;"></textarea>
   			</td>
   		</tr>
   		<tr>
   			<td></td>
   			<td align="center">
   				<input type="button" value="确定" onclick="submits()">
   			</td><td><a href="${pageContext.request.contextPath}/notice/findAll.do"><input type="button" value="取消"></a></td>
   		</tr>
   	</table>
 </div>
 
 <script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('content');
</script>
	
</form>

</body>
</html>