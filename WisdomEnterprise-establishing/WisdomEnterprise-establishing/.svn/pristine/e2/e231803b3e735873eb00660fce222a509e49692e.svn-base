<%--
  Created by IntelliJ IDEA.
  User: X201
  Date: 2016/8/31 0031
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basestyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/zTree_v3-master/css/demo.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/zTree_v3-master/css/metroStyle/metroStyle.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/zTree_v3-master/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/zTree_v3-master/js/jquery.ztree.excheck.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/zTree_v3-master/js/jquery.ztree.exedit.js"></script>
    <script type="text/javascript">
var setting = {
        view: {
            addHoverDom: addHoverDom,
            removeHoverDom: removeHoverDom,
            selectedMulti: false
        },
        /* check: {
            enable: true
             ,chkStyle: 'checkbox'
            ,radioType: "level" 
        }, */
        callback:{
        	beforeRemove:beforeRemove,
        	beforeDrop:beforeDrop,
            onDrop: zTreeOnDrop,
            onRightClick: OnRightClick,
            onRemove: zTreeOnRemove,
            onRename: zTreeOnRename,
            onClick:zTreeOnClick
           
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        edit: {
            enable: true,
            showRemoveBtn: showRemoveBtn,
            showRenameBtn: showRenameBtn
        }
    };
    
	function zTreeOnClick(event, treeId, treeNode) {
	    if(treeNode.id<0){
	    	
	    var id=-treeNode.id;
	    $("#div4").hide()
	    $("#div6").show()
	    $("#div8").hide()
	    
	    $("#div5").load("${pageContext.request.contextPath}/user/information.do?id="+id,null,function(){})
	    }else{
	    	
	    	$("#div4").hide()
	        $("#div6").show()
	        $("#div8").show()
	        $("#id").val(treeNode.id)
	        $("#thispage1").val(1)
	        $("#div5").load("${pageContext.request.contextPath}/user/deptinformation.do?id="+treeNode.id,null,function(){})
	       
	    }
	    
	};
    
    
	function zTreeOnRename(event, treeId, treeNode, isCancel) {
		 $.post("${pageContext.request.contextPath}/dept/updatedept.do",{
			did:treeNode.id,
			dname:treeNode.name
		},function(data){
			if(data!="success"){
				alert("失败！")
			}
		}) 
		
	}
	
             /* 使部门显示修改和删除按钮用户不显示的方法 */
    function showRemoveBtn(treeId, treeNode){
    	if(treeNode.id<0){return false;}
    	return true;
    }
    function showRenameBtn(treeId, treeNode){
    	if(treeNode.id<0){return false;}
    	return true;
    }
    /* 拖拽菜单是的方法 */
    function beforeDrop(treeId, treeNodes, targetNode, moveType){
    	
    		
    	if(targetNode==null){
    		return false;
    	}
    	if(targetNode.id>0){
    		
    		return true;
    	}
    	alert("目标不是部门！")
    	return false;
    	
    }
function zTreeOnDrop(event, treeId, treeNodes, targetNode, moveType) {
	var id2;
	
    	
    		if(treeNodes[0].id<0){
    			
    			 $.post("${pageContext.request.contextPath}/user/moveuser.do",{
    				uid:treeNodes[0].id,
    				did:targetNode.id
    			},function(data){
    				if(data!="success"){
    					alert("移到失败！")
    				}
    			})
    		}else{
    			if(moveType=="inner"){
                    
                    id2=targetNode.id
                }else{
                    if(targetNode.getParentNode()==null){
                    	
                    	id2=0
                    }else{
                    	id2=targetNode.getParentNode().id
                    }
                }
    			$.post("${pageContext.request.contextPath}/dept/movedept.do",{
    				did:treeNodes[0].id,
    				pid:id2
    			},function(data){
    				if(data!="success"){
    					alert("移到失败！")
    				}
    			})
    		
    	}
};

	/* 删除部门节点的方法 */
	function beforeRemove(treeId, treeNode){
		
		if(treeNode.children!=null){
			alert("请先处理此部门下的部门和员工！");
			return false;
		}
		return true;
		
	};
	function zTreeOnRemove(event, treeId, treeNode) {
		$.post("${pageContext.request.contextPath}/dept/removedept.do",{
			did:treeNode.id
		},function(data){
			
		})
	}
    
	
	function OnRightClick(event, treeId, treeNode) {
		if(treeNode.id<0){
			if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
				zTree.cancelSelectedNode();
				showRMenu("root", event.clientX, event.clientY);
			} else if (treeNode && !treeNode.noR) {
				zTree.selectNode(treeNode);
				showRMenu("node", event.clientX, event.clientY);
			}
		}
		
	}

	function showRMenu(type, x, y) {
		$("#rMenu ul").show();
		if (type=="root") {
			$("#m_del").hide();
			$("#m_upd").hide();
			
		} else {
			$("#m_del").show();
			$("#m_upd").show();
			
		}
		rMenu.css({"top":y+"px", "left":x+"px", "visibility":"visible"});

		$("body").bind("mousedown", onBodyMouseDown);
	}
	function hideRMenu() {
		if (rMenu) rMenu.css({"visibility": "hidden"});
		$("body").unbind("mousedown", onBodyMouseDown);
	}
	function onBodyMouseDown(event){
		if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length>0)) {
			rMenu.css({"visibility" : "hidden"});
		}
	}
	var addCount = 1;
	function addTreeNode() {
		 window.location.href="${pageContext.request.contextPath}/user/register.do";
	}
	function removeTreeNode() {
		hideRMenu();
		var nodes = zTree.getSelectedNodes();
		
				$.post("${pageContext.request.contextPath}/user/removeuser.do",{
					uid:nodes[0].id
				},function(data){
					
				})
				zTree.removeNode(nodes[0]);
			
	}
	function updateTreeNode(){
		var nodes = zTree.getSelectedNodes();
		var uid=-nodes[0].id;
		 window.location.href="${pageContext.request.contextPath}/user/updata.do?uid="+uid;
	}

	var zTree, rMenu;
	
	
    $(document).ready(function(){
    	/* $.post("${pageContext.request.contextPath}/index/aj.do",function(data){
    		alert("123")
    		alert(data)
    		var json = eval(data);
    		zNodes=json;
    		alert("123")
    		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
    	}) */
    	
    	var json = eval($("#ztee").val());
    	zNodes=json;
    	$.fn.zTree.init($("#treeDemo"), setting, zNodes)
    	zTree = $.fn.zTree.getZTreeObj("treeDemo");
		rMenu = $("#rMenu");
		$("#div6").hide()
    });

    
    function addHoverDom(treeId, treeNode) {
    	if(treeNode.id>0){
    		var sObj = $("#" + treeNode.tId + "_span");
            if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
                + "' title='add node' onfocus='this.blur();'></span>";
            sObj.after(addStr);
            var btn = $("#addBtn_"+treeNode.tId);
            if (btn) btn.bind("click", function(){
                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                $.post("${pageContext.request.contextPath}/dept/adddept.do",{
							pid:treeNode.id
					},function(data){
					
					zTree.addNodes(treeNode, {id:data.data, pId:treeNode.id, name:"新建部门"});
					})
                
                return false;
            });
    	}
        
    };
    function removeHoverDom(treeId, treeNode) {
        $("#addBtn_"+treeNode.tId).unbind().remove();
    };
    
</script>
<style type="text/css">
div#rMenu {position:absolute; visibility:hidden; top:0; background-color: #555;text-align: left;padding: 2px;}
div#rMenu ul li{
	margin: 1px 0;
	padding: 0 5px;
	cursor: pointer;
	list-style: none outside none;
	background-color: #DFDFDF;
}

.clearFloat:after {
　　visibility: hidden;
　　clear: both;
　　display: block;
　　height: 0px;
　　content: "."
　　}
.clearFloat {
　　zoom: 1;
　　}
	</style>
</head>
<body class="clearFloat">

<div style="float:left;">
<input type="hidden" value="${ztreeno }" id="ztee"/>

<div >
    <ul id="treeDemo" class="ztree"></ul>
</div>
 <div id="rMenu">
	<ul>
		<li id="m_add" onclick="addTreeNode();">添加用户</li>
		<li id="m_upd" onclick="updateTreeNode();">用户修改</li>
		<li id="m_del" onclick="removeTreeNode();">删除用户</li>
		
	</ul>
</div>
</div>

<div id="div4" style="width:850px;float:left;margin:10px 20px;">
<a href="${pageContext.request.contextPath}/user/register.do">添加用户</a>
<input typt="text" id="search"/><button onclick="search()">搜索</button>
<a href="${pageContext.request.contextPath}/part/list.do">角色管理</a>
<table id="table1" class="table">
    <tr>
        <th >用户名</th>
        <th >真实姓名</th>
        <th >就职单位</th>
        <th >职务</th>
        <th >编辑</th>
    </tr>

    <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.uname}</td>
            <td>${list.userExtend.urealname}</td>
            <td>${list.userExtend.uunit}</td>
            <td>${list.userExtend.upost}</td>
            <td>
                <a href="${pageContext.request.contextPath}/user/updata.do?uid=${list.uid}">修改</a>
                <button onclick="dele(${list.uid},${thispage})">删除</button>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td></td>
        <td>
            <button id="up" onclick="up(${thispage})">上一页</button>
            <button id="down" onclick="down(${thispage},${page1 })">下一页</button>
            共${thispage}/${page1}页
        </td>
        <td></td>
    </tr>
</table>
</div>
<div id="div6" style="width:850px;float:left;margin:10px 20px;">
<div id="div5">

</div>
<div id="div8">
<input type="hidden" id="id">
<input type="hidden" id="thispage1">
<button onclick="up1()">上一页</button>
            <button onclick="down1()">下一页</button>
         
</div>
<div id="div7">
<input type="button" value="返回" onclick="tui()">
</div>
</div>

</body>
<script>
function up1() {
	$("#div5").load("${pageContext.request.contextPath}/user/deptinformation.do?id="+$("#id").val()+"&thispage="+($("#thispage1").val()-1),null,function(){
		$.post("${pageContext.request.contextPath}/user/information1.do",{
            id:$("#id").val(),
            thispage:$("#thispage1").val()-1
        },function(data){
            
                if(data.status==200){
                    
                	$("#thispage1").val($("#thispage1").val()-1);
                }else{
                   
                }
            
            
        })
		
	})
}
function down1() {
    $("#div5").load("${pageContext.request.contextPath}/user/deptinformation.do?id="+$("#id").val()+"&thispage="+(Number($("#thispage1").val())+Number(1)),null,function(){
    	$.post("${pageContext.request.contextPath}/user/information1.do",{
            id:$("#id").val(),
            thispage:Number($("#thispage1").val())+Number(1)
        },function(data){
            
                if(data.status==200){
                    
                    $("#thispage1").val(Number($("#thispage1").val())+Number(1));
                }else{
                   
                }
            
            
        })
    	
    })
}

function tui() {
	$("#div4").show()
	$("#div6").hide()
	
}

	function search(){
		var uname=$("#search").val();
		if($("#search").val()!=""){
			 $.post("${pageContext.request.contextPath}/user/searchu.do",{
		            uname:uname
		        },function (data) {
		        	if(data.status==100){
		        		alert(data.msg)
		        	}else if(data.status==200){
		        		
		        		
		        		
		        		$("#table1  tr:not(:first)").html("");
		        		var tr =  '<tr><td>'+data.data.uname+'</td><td>'+data.data.userExtend.urealname+'</td><td>'+data.data.userExtend.uunit+'</td><td>'+data.data.userExtend.upost+'</td><td><a href="${pageContext.request.contextPath}/user/updata.do?uid='+data.data.uid+'">修改</a><button onclick="dele('+data.data.uid+','+data.thispage+')">删除</button></td></tr>';
		                $("#table1").append(tr);
		        	}
		        })
		}else{
			$.post("${pageContext.request.contextPath}/user/all.do",{
                thispage:0
            },function (data) {
                if(data.status==1){
                    alert(data.msg)
                }
                $("#table1  tr:not(:first)").html("");
                for(var i=0;i<data.data.length;i++){
                    var tr =  '<tr><td>'+data.data[i].uname+'</td><td>'+data.data[i].userExtend.urealname+'</td><td>'+data.data[i].userExtend.uunit+'</td><td>'+data.data[i].userExtend.upost+'</td><td><a href="${pageContext.request.contextPath}/user/updata.do?uid='+data.data[i].uid+'">修改</a><button onclick="dele('+data.data[i].uid+','+data.thispage+')">删除</button></td></tr>';
                    $("#table1").append(tr);
               }
                var td='<tr><td></td><td><button id="up" onclick="up('+data.thispage+')">上一页</button><button id="down" onclick="down('+data.thispage+','+data.page+')">下一页</button>共'+(data.thispage)+'/'+data.page+'页</td><td></td></tr>';
                $("#table1").append(td);

            });
		}
	}

    function up(thispage) {

        if(thispage!=1){
        	$.post("${pageContext.request.contextPath}/user/all.do",{
                thispage:thispage-1
            },function (data) {
                if(data.status==1){
                    alert(data.msg)
                }
                $("#table1  tr:not(:first)").html("");
                for(var i=0;i<data.data.length;i++){
                    var tr =  '<tr><td>'+data.data[i].uname+'</td><td>'+data.data[i].userExtend.urealname+'</td><td>'+data.data[i].userExtend.uunit+'</td><td>'+data.data[i].userExtend.upost+'</td><td><a href="${pageContext.request.contextPath}/user/updata.do?uid='+data.data[i].uid+'">修改</a><button onclick="dele('+data.data[i].uid+','+data.thispage+')">删除</button></td></tr>';
                    $("#table1").append(tr);
               }
                var td='<tr><td></td><td><button id="up" onclick="up('+data.thispage+')">上一页</button><button id="down" onclick="down('+data.thispage+','+data.page+')">下一页</button>共'+(data.thispage)+'/'+data.page+'页</td><td></td></tr>';
                $("#table1").append(td);

            });

        }

        
    }
    function down(thispage,page1) {
    	
    	if(thispage!=page1){
    		thispage=thispage+1;
            $.post("${pageContext.request.contextPath}/user/all.do",{
                thispage:thispage
            },function (data) {
                if(data.status==1){
                    alert(data.msg)
                }
                $("#table1  tr:not(:first)").html("");
                for(var i=0;i<data.data.length;i++){
                     var tr = '<tr><td>'+data.data[i].uname+'</td><td>'+data.data[i].userExtend.urealname+'</td><td>'+data.data[i].userExtend.uunit+'</td><td>'+data.data[i].userExtend.upost+'</td><td><a href="${pageContext.request.contextPath}/user/updata.do?uid='+data.data[i].uid+'">修改</a><button onclick="dele('+data.data[i].uid+','+data.thispage+')">删除</button></td></tr>';
                     $("#table1").append(tr);
                }
               
                var td='<tr><td></td><td><button id="up" onclick="up('+data.thispage+')">上一页</button><button id="down" onclick="down('+data.thispage+','+data.page+')">下一页</button>共'+(data.thispage)+'/'+data.page+'页</td><td></td></tr>';
                $("#table1").append(td);

            });
    	}
       

    }
    function dele(uid,thispage) {
    	 if(confirm("确定要删除吗？")){
    		 $.post("${pageContext.request.contextPath}/user/dele.do",{
    	            uid:uid,
    	            thispage:thispage
    	        },function (data) {

    	            down((data-1))

    	        });
    	 }
       

    }
</script>
</html>
