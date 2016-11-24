
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath }/zTree_v3-master/css/demo.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/zTree_v3-master/css/metroStyle/metroStyle.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.2.3.min.js"></script>
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
            onRename: zTreeOnRename
           
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
	
    	
    		if(treeNodes[0].id<0){
    			/* $.each(treeNodes,function(index,domEle){
    				alert(domEle.id)
    			}) */
    			 $.post("${pageContext.request.contextPath}/user/moveuser.do",{
    				uid:treeNodes[0].id,
    				did:targetNode.id
    			},function(data){
    				if(data!="success"){
    					alert("移到失败！")
    				}
    			})
    		}else{
    			$.post("${pageContext.request.contextPath}/dept/movedept.do",{
    				did:treeNodes[0].id,
    				pid:targetNode.id
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
		
    });

    var newCount = 1;
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
					
					zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"新建部门"});
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
	</style>
</head>

<body>
<div>
<input type="hidden" value="${ztreeno }" id="ztee"/>
<a href="${pageContext.request.contextPath}/user/list.do">用户列表</a>

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
</body>
<script type="text/javascript">
	
	
</script>
</html>
