<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/EasyTree/css/easyTree.css">
<script src="${pageContext.request.contextPath}/EasyTree/src/jquery.js"></script>
<script src="${pageContext.request.contextPath}/EasyTree/src/easyTree.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-2.2.3.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>  
</head>
<body>
 <style type="text/css">  
    .menu{width:300px;}  
    .has_children{background:#8080ff; color:#fff; cursor:pointer;}  
    .highlight{color:#fff; background:green;}  
    .div{padding:0px; margin:10px 0px;}  
    div a{background:#888; display:none; float:left; width:300px;}  
  
</style>  
    <div class="menu">  
        <div class="has_children">  
            <span>用户管理</span>  
            <a href="${pageContext.request.contextPath}/user/list.do" target="right_frame">政府用户</a>  
            <a href="${pageContext.request.contextPath}/#">企业用户</a>  
        </div>  
          
        <div class="has_children">  
            <span>企业管理</span>  
            <a>1</a>  
            <a>2</a>  
            
        </div>  
    </div>  
    <script type="text/javascript">  
        $(document).ready(function(){  
            //原理说明：  
            /* 
                首先我们要找到这个菜单的标题，在他的身上加上一个单击事件， 
                之后的$(this)就代表着这个has_children对象，给他加上一个选中的状态，并将这个菜单下的所有的a标签显示出来；  
                写到这一步，我们的菜单就基本上写完了，但是现在有个问题就是我们单击后菜单就不会回去了，下面们我们在使用 
                siblings（）这个函数也就是遍历同胞元素，去除掉所有同胞元素的样式，并且他们的菜单内容全部的隐藏掉！ 
            */  
            $(".has_children").click(function(){  
                $(this).addClass("highlight").children("a").show().end();  
                $(this).siblings().removeClass("highlight").children("a").hide();  
            });  
        });  
    </script>  
</body>
</html>