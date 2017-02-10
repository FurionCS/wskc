
/**
 * 添加产品到库
 */
function submitProduct(){
	var brandId=$("#brandId").val();
	if(brandId==""||brandId<0){
		noty({text:"请选择品牌",layout:'topCenter',type:"error",timeout:3000})
		return;
	}
	var name=$("#name").val().trim();
	var code=$("#code").val().trim();
	var size=$("#size").val().trim();
	var unit=$("#unit").val().trim();
	if(name=="" || code =="" || size=="" || unit==""){
		noty({text:"请填写完整的信息",layout:'topCenter',type:"error",timeout:3000})
		return;
	}
	$.ajax({
		url:"../basic/AddProduct",
		type:"POST",
		dataType:"json",
		data:{"brandId":brandId,"name":name,"code":code,"size":size,"unit":unit},
		success:function(data){
			if(data!=null){
				if(data.result==1){
					noty({text:data.msg,layout:'topCenter',type:"success",timeout:2000})
					setTimeout(function(){window.location.href="../basic/addUserProduct?menuids=2_3"},2000);
				}else{
					noty({text:data.msg,layout:'topCenter',type:"error",timeout:3000})
				}
			}else{
				noty({text:"请求出错",layout:'topCenter',type:"error",timeout:2000})
			}
		}
	})
}


