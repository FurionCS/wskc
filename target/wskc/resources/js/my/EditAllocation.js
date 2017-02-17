/**
   * 编辑提交
   */
  function submitEditAllocation(){
		var id=$("#id").val();
		var counterFee=$("#counterFee").val().trim();
		var num=$("#num").val().trim();
		if(isNaN(num)){
			noty({text:"您填写的数量格式不正确",layout:'topCenter',type:"error",timeout:3000});
			return;
		}
		if(!isDouble(counterFee)){
			noty({text:"您填写的价格格式不正确",layout:'topCenter',type:"error",timeout:3000});
			return;
		}
		var status=$("#status").val().trim();
		var remark=$("#remark").val();
		$.ajax({
			url:"../allocation/EditAllocation",
			type:"POST",
			dataType:"json",
			data:{"id":id,"counterFee":counterFee,"num":num,"status":status,"remark":remark},
			success:function(data){
				if(data!=null){
					if(data.result==1){
						noty({text:data.msg,layout:'topCenter',type:"success",timeout:2000})
						setTimeout(function(){window.location.href="../allocation/showAllocation?menuids=5_0&id="+id},2000);
					}else{
						noty({text:data.msg,layout:'topCenter',type:"error",timeout:3000})
					}
				}else{
					noty({text:"请求出错",layout:'topCenter',type:"error",timeout:2000})
				}
			}
		})
}

