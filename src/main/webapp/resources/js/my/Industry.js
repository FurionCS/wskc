function deleteIndustry(industryId,code){
	if(code==2){
	 industryId=$("#hid").val();
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
					setTimeout(function(){history.go(0)},2000);
				}else{
					noty({text:data.msg,layout:'topCenter',type:"error",timeout:2000})
				}
			}else{
				noty({text:"请求出错",layout:'topCenter',type:"error",timeout:2000})
			}
		}
	})
}




