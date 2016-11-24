<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告信息修改页面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
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
	
	var orderNum=$("#orderNum").val();
	if(orderNum==null||orderNum==''){
		 alert("输入排序号！");
	}
	var regs=/[a-zA-Z\u4E00-\u9FA5]+$/;  
	if(orderNum!=null){
	    if(!/^[0-9]+$/.test(orderNum)){
	        alert("请输入数字!");
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
	document.getElementById("frm").action="${pageContext.request.contextPath}/notice/update.do";
	document.getElementById("frm").submit();
}
/* $(document).ready(function(){
	$("#orderNum").click(
			function(){


			}  
	      )
})
 */
</script>

</head>
<body style="margin: 10px">
<form action="" id="frm">
<div id="p" title="修改公告信息" style="padding: 10px">
 	<table cellspacing="20px">
   		<tr>
   			<td width="10px">公告标题：</td>
   			<td><input type="text" id="title" name="title"  value="${notice.title}"/></td>
   		</tr>
   		<tr>
   			<td>排序：</td>
   			<td><input type="text" id="orderNum" name="orderNum" value="${notice.orderNum}"/>当前最大排序号为${orderNumMax}号</td>
   		</tr>
   		<tr>
   			<td>接收终端：</td>
   			<td>
			全部:<input id="receiveTerminal" name="receiveTerminal" type="checkbox" value="全部" ${fn:containsIgnoreCase(notice.receiveTerminal,'全部')?"checked":""}/>		
			政府端后台:<input id="receiveTerminal" name="receiveTerminal" type="checkbox" value="政府端后台" ${fn:containsIgnoreCase(notice.receiveTerminal,'政府端后台')?"checked":""}/>		
			企业端后台:<input id="receiveTerminal" name="receiveTerminal" type="checkbox" value="企业端后台" ${fn:containsIgnoreCase(notice.receiveTerminal,'企业端后台')?"checked":""}/>		
			信息大屏:<input id="receiveTerminal" name="receiveTerminal" type="checkbox" value="信息大屏" ${fn:containsIgnoreCase(notice.receiveTerminal,'信息大屏')?"checked":""}/>		
			自助终端:<input id="receiveTerminal" name="receiveTerminal" type="checkbox" value="自助终端" ${fn:containsIgnoreCase(notice.receiveTerminal,'自助终端')?"checked":""}/>		
			门户前台:<input id="receiveTerminal" name="receiveTerminal" type="checkbox" value="门户前台" ${fn:containsIgnoreCase(notice.receiveTerminal,'门户前台')?"checked":""}/>		
   			</td>
   		</tr>
   		<tr>
   			<td valign="top">内容：</td>
   			<td>
				   <!-- <script id="content" type="text/plain" style="width:100%;height:500px;"></script> -->
   				<textarea id="content" name="content"  style="width:100%;height:500px;"></textarea> 
   			</td>
   		</tr>
   		<tr>
   			<td></td>
   			<td align="center">
   				<input type="button" value="确定" onclick="submits()">
   				<a href="${pageContext.request.contextPath}/notice/findAll.do"><input type="button" value="取消"></a>
   			</td>
   		</tr>
   	</table>
   	<input type="hidden" name="id" id="id" value="${notice.id}">
 </div>
</form>
 <script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('content');
    var contents = '${notice.content}';
     ue.addListener("ready", function () {
        // editor准备好之后才可以使用
        ue.setContent(contents);
        }); 
  /* ue.addListener("ready",function(){
        //通过ajax请求数据
        UE.ajax.request("${pageContext.request.contextPath}/admin/blog/findById.do",
            {
                method:"post",
                async : false,  
                data:{"id":"${param.id}"},
                onsuccess:function(result){
                	result = eval("(" + result.responseText + ")");  
                	$("#title").val(result.title);
                	$("#keyWord").val(result.keyWord);
       				$("#blogTypeId").combobox("setValue",result.blogType.id);
       				UE.getEditor('editor').setContent(result.content);
                }
            }
        );
    });  */
</script>
</body>
</html>