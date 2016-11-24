<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>日志列表</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/autosuggest.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/autosuggest.js"></script>
    
</head>
<body>
<input type="hidden" id="status" value="${sta }"/>
<button onclick="all1()">所有日志</button>
<button onclick="select1()">24小时内</button>
<button onclick="select2()">7天内</button>

<button onClick="select3()"/>30天内</button>
 <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
日志查询
</button> 
<table class="table">
<tr>
<td>序号</td>
<td>会员名</td>
<td>操作类别</td>
<td>时间</td>
<td>IP地址</td>
<td>结果</td>
<td>备注 </td>
</tr>
<c:forEach var="list" items="${list}" varStatus="st">
        <tr><td>${st.index+1 }
        </td>
            <td>${list.uname}</td>
            <td>${list.type}</td>
            <td><fmt:formatDate value="${list.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${list.ip}</td>
            <td><c:if test="${list.result==1}"><span style="color:green">成功</span></c:if><c:if test="${list.result==0}"><span style="color:red">失败</span></c:if></td>
            <td>${list.remark}</td>
            
        </tr>
    </c:forEach>
    
    <tr>
        <td><input type="button" value="日志下载" onclick="download(${page.pageNum})"></td>
        <td>
            <input type="button" value="上一页" onclick="up(${page.pageNum})">
            <input type="button" value="下一页 " onclick="down(${page.pageNum},${page.pages })">
            共${page.pageNum}/${page.pages}页
        </td>
        <td></td>
    </tr>
    
    
    
    </table>
  <input type="hidden" id="operator" name="operator" value="${operator }"> 
   <input type="hidden" id="uname" name="uname" value="${logger.uname}"> 
   <input type="hidden" id="type" name="type" value="${logger.type}"> 
   <input type="hidden" id="ip" name="ip" value="${logger.ip}"> 
   <input type="hidden" id="result" name="result" value="${logger.result}"> 
   <input type="hidden" id="time1" name="time1" value="${time1}"> 
   <input type="hidden" id="time2" name="time2" value="${time2}"> 
   <input type="hidden" id="remark" name="remark" value="${logger.remark}">  
   
 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                   日志查询
                </h4>
            </div>
            <div class="modal-body">
               <form id="form1" action="${pageContext.request.contextPath}/logger/seach.do" method="post">
                       <input type="hidden" name="thispage" value="1"/>
                      <div class="form-group">
                            <label>操作者</label>
                            <select id="s1" class="form-control-6" name="operator">
                                <option>所有</option>
                                <option>政府端</option>
                                <option>企业端</option>
                            </select>
                            <label>用户名</label>
                            <input type="text" class="form-control" style="" id="t1" name="uname"/>
                            
                            
                        </div>
                        <div class="form-group">
                            <label>操作类型</label>
                            <select class="form-control-6" name="type">
                                
                                  <option value="">请选择</option>
                                  <option value="系统登陆">系统登陆</option>
                                  <option value="系统登出">系统登出</option>
                                  <option value="用户添加">用户添加</option>
                                  <option value="企业注册">企业注册</option>
                                  <option value="企业审核">企业审核</option>
                                  <option value="企业信息下载">企业信息下载</option>
                                  <option value="招商信息发布">招商信息发布</option>
                                  <option value="招商信息审核">招商信息审核</option>
                                  <option value="招商信息下载">招商信息下载</option>
                                  <option value="发起办文">发起办文</option>
                                  <option value="办文">办文</option>
                                  <option value="办文查询">办文查询</option>
                                  <option value="监控与催办">监控与催办</option>
                                  <option value="工作委托">工作委托</option>
                                  <option value="修改个人信息">修改个人信息</option>
                                  <option value="充值">充值</option>
                                  <option value="消费">消费</option>
                                  <option value="下载财务报表">下载财务报表</option>
                                  <option value="公告发布">公告发布</option>
                                  <option value="公告查询">公告查询</option>
                                  <option value="手动匹配招商信息">手动匹配招商信息</option>
                                  <option value="日志查询">日志查询</option>
                                  <option value="修改路演设备">修改路演设备</option>
                                  <option value="添加路演设备">添加路演设备</option>
                                  <option value="修改系统参数">修改系统参数</option>
                                
                            </select>
                            
                            
                        </div>
                        <div class="form-group">
                            <label>IP地址</label>
                            <input type="text" class="form-control-6" name="ip">
                        </div>
                        <div class="form-group">
                            <label>结果</label>
                            <select class="form-control-6" name="result">
                                <option value="2">全选</option>
                                <option value="1">成功</option>
                                <option value="0">失败</option>
                                
                            </select>
                        </div>
                        <div class="form-group">
                            <label>操作时间</label>
                           
                            <input type="text" name="time1" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});">
                            <label>到</label>
                            <input type="text" name="time2" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});">
                        </div> 
                        <div class="form-group">
                            <label>描述</label>
                            <textarea rows="3" name="remark" class="form-control-6"></textarea>
                        </div> 
               </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="seach()">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> 
</body>
    <script type="text/javascript">
    function seach() {
        $("#form1").submit();
    }
    function selectuname(obj) {
        //alert(obj.innerHTML)
        if(obj.value!="" && obj.value!=null){
            $.post("${pageContext.request.contextPath}/user/selectuser.do",{
                uname:obj.value,
                status:$("#s1  option:selected").text()
               
            },function (data) {
                if(data.status=200){
                    for(var i=0;i<data.data.length;i++){
                        var value="<label onclick='selectuname(this)'>"+data.data[i]+"</label>"
                        
                        var offset=$("#t1").offset()
                        $('#div1').css('left',offset.left + $("#t1").width() + 2 + 'px') 
                        .css('top',offset.top + 'px') .fadeIn();
                        $("#div1").empty().append(value)
                        $("#div1").show()
                        
                    }
                }
                

            });
        }else{
             $("#div1").empty()
             $("#div1").hide()
        }
        
    }
    
    
     $(document).ready(function () {
        $("#t1").autosuggest({
            url: '${pageContext.request.contextPath}/user/selectuser.do',
            
            method: 'post',
            minLength: 1,
            highlight: true,
            immediate: true,
            queryParamName: 'uname',extra: {
                status: $("#s1  option:selected").text()
               
            },
            dataCallback:function(data) {
                var json = [];
                
                if (data.status == 200) {
                    for (var i = 0; i < data.data.length; i++) {
                        json.push({ value: data.data[i] });
                    }
                    
                    return  json;
                } 
                
                return json;
            }
            
        });

        
    }); 
    
    function down(thispage,page) {
        if(thispage!=page&&thispage!=0){
            if($("#status").val()==24){
                 window.location.href="${pageContext.request.contextPath}/logger/list.do?thispage="+(thispage+1);
             }else if($("#status").val()==7){
                 window.location.href="${pageContext.request.contextPath}/logger/alllist1.do?thispage="+(thispage+1);
             }else if($("#status").val()==30){
                 window.location.href="${pageContext.request.contextPath}/logger/alllist2.do?thispage="+(thispage+1);
             }else if($("#status").val()==0){
                 window.location.href="${pageContext.request.contextPath}/logger/alllist.do?thispage="+(thispage+1);
             }else{
                 window.location.href="${pageContext.request.contextPath}/logger/seach.do?thispage="+(thispage+1)+"&operator="+$("#operator").val()+"&uname="+$("#uname").val()+"&type="+$("#type").val()+"&ip="+$("#ip").val()+"&result="+$("#result").val()+"&time1="+$("#time1").val()+"&time2="+$("#time2").val()+"&remark="+$("#remark").val();
             }
        }
     
 }
    function up(thispage) {
        
        if(thispage!=1&&thispage!=0){
            if($("#status").val()==24){
                 window.location.href="${pageContext.request.contextPath}/logger/list.do?thispage="+(thispage-1);
             }else if($("#status").val()==7){
                 window.location.href="${pageContext.request.contextPath}/logger/alllist1.do?thispage="+(thispage-1);
             }else if($("#status").val()==30){
                 window.location.href="${pageContext.request.contextPath}/logger/alllist2.do?thispage="+(thispage-1);
             }else if($("#status").val()==0){
                 window.location.href="${pageContext.request.contextPath}/logger/alllist.do?thispage="+(thispage-1);
             }else{
                 window.location.href="${pageContext.request.contextPath}/logger/seach.do?thispage="+(thispage-1)+"&operator="+$("#operator").val()+"&uname="+$("#uname").val()+"&type="+$("#type").val()+"&ip="+$("#ip").val()+"&result="+$("#result").val()+"&time1="+$("#time1").val()+"&time2="+$("#time2").val()+"&remark="+$("#remark").val();
             }
        }
         
     }
    
    function all1() {
       
        window.location.href="${pageContext.request.contextPath}/logger/alllist.do?thispage=1";
 }
    
    function select1() {
        window.location.href="${pageContext.request.contextPath}/logger/list.do?thispage=1";
 }
    
    function select2() {
        window.location.href="${pageContext.request.contextPath}/logger/alllist1.do?thispage=1";
 }
    
    function select3() {
        window.location.href="${pageContext.request.contextPath}/logger/alllist2.do?thispage=1";
 }
    function download(obj) {
            message = prompt("请输入下载密码:","");
            $("#message").val(message)
            
            $.post("${pageContext.request.contextPath}/enterprise/downpassword.do",{
                message:message
            },function(data){
                if(data.status==200){
                   
                   window.open("${pageContext.request.contextPath}/logger/download.do?status="+$("#status").val());
                    
                }else{
                    alert(data.msg)
                }
            })
        
    }
    
    </script>
</html>