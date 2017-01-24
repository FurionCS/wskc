function deleteIndustry(industryId,code){
	if(code==2){
	 industryId=$("#industryId").val();
	}
	if(industryId<1 || isNaN(industryId)){
		noty({text:"请选择要删除的行业",layout:'topCenter',type:"error",timeout:2000})
		return;
	}
	$.ajax({
		url:"../basic/deleteIndustryUser?menuids=2_1",
		type:"POST",
		dataType:"json",
		data:{"industryId":industryId},
		success:function(data){
			if(data!=null){
				if(data.result==1){
					$("#tr_"+industryId).remove();
					noty({text:data.msg,layout:'topCenter',type:"success",timeout:2000})
				}else{
					noty({text:data.msg,layout:'topCenter',type:"error",timeout:2000})
				}
			}else{
				noty({text:"请求出错",layout:'topCenter',type:"error",timeout:2000})
			}
		}
	})
}

function selectIndustry(industryId,obj){
	var style=$(obj).attr("style"); 
	if(style!=undefined){
		$("#industryId").val(-1);
		$(obj).removeAttr("style");
	}
	else{
		$(obj).siblings().removeAttr("style");
		$("#industryId").val(industryId);
		$(obj).css("background-color","rgb(255,228,141)");
	}
}
