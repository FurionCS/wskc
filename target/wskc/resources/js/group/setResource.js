$(function(){
	var _cs=new Array();
	var t=$("#tree").mytree({
			url:$("#treePath").val(),
			mine:{listChild:0,expandAll:true},
			callback:{
				onAsyncSuccess:initTree,
				beforeCheck:function(treeId,treeNode){
					if(!treeNode.checked){
						//ps中的节点应该进行添加操作
						var ps =t.getCheckParentNodes(treeNode,false);
						ps.push(treeNode);
						addGroupResource(ps);
					}else{
						var cs=new Array();
						t.getCheckChildNodes(treeNode,true,cs);
						cs.push(treeNode);
						deleteGroupResource(cs);
					}
				},
				onCheck:function(event,treeId,treeNode){
					if(!treeNode.checked){
						var ps=t.getCheckParentNodes(treeNode,false);
						deleteGroupResource(ps);
					}
				}
			},
			check:{
				enable:true,
				chkboxType: { "Y": "p", "N": "ps" }
			}
		});
	function hander(msg,exc){
		alert(msg);
	}
	dwr.engine.setErrorHandler(hander);
	function addGroupResource(cs){
		var gid=$("#gid").val();
		for(var i=0;i<cs.length;i++){
			var c=cs[i];
			if(c.id>0){
				dwrService.addGroupResource(gid,c.id);
			}
		}
	}
	function deleteGroupResource(cs){
		var gid=$("#gid").val();
		for(var i=0;i<cs.length;i++){
			var c=cs[i];
			if(c.id>0){
				dwrService.deleteGroupResource(gid,c.id);
			}
		}
	}
	function initTree(){
		/*var n=t.getNodeByParam("id",7,null);
		t.checkNode(n,true,true);*/
		var rids=$("input[name='rids']");
		t.expandAll(true);
		for(var i=0;i<rids.length;i++){
			var rid=rids[i].value;
			var n=t.getNodeByParam("id",rid,null);
			t.checkNode(n,true,true);
		}
	}
});