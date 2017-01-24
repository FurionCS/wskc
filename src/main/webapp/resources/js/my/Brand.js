/**
 * 品牌收索
 */
$("#brand").bsSuggest({
    indexId: 2,             //data.value 的第几个数据，作为input输入框的内容
    indexKey: 1,            //data.value 的第几个数据，作为input输入框的内容
    allowNoKeyword: false,  //是否允许无关键字时请求数据。为 false 则无输入时不执行过滤请求
    multiWord: true,        //以分隔符号分割的多关键字支持
    separator: ",",         //多关键字支持时的分隔符，默认为空格
    getDataMethod: "url",   //获取数据的方式，总是从 URL 获取
    showHeader: true,       //显示多个字段的表头
    autoDropup: true,       //自动判断菜单向上展开
    effectiveFieldsAlias:{Id: "序号", Keyword: "品牌名称"},
    url: '../basic/brandSearch?q=', /*优先从url ajax 请求 json 帮助数据，注意最后一个参数为关键字请求参数*/
//     jsonp: 'callback',               //如果从 url 获取数据，并且需要跨域，则该参数必须设置
    // url 获取数据时，对数据的处理，作为 fnGetData 的回调函数
    fnProcessData: function(json){
        var index, len, data = {value: []};

        if(! json || ! json.obj || ! json.obj.length) {
            return false;
        }
        for (index = 0; index < json.obj.length; index++) {
            data.value.push({
                "Id": json.obj[index].id,
                "Keyword": json.obj[index].name,
                "公司": json.obj[index].company
            });
        }
        console.log('淘宝搜索 API: ', data);
        return data;
    }
}).on('onDataRequestSuccess', function (e, result) {
    console.log('onDataRequestSuccess: ', result);
    $("#brandId").val("");
    $("#brandName").val("");
}).on('onSetSelectValue', function (e, keyword, data) {
    console.log('onSetSelectValue: ', keyword, data);
    $("#brandId").val(data.Id);
    $("#brandName").val(data.Keyword);
}).on('onUnsetSelectValue', function () {
    console.log("onUnsetSelectValue");
});


function submitBrand(){
	var brandId=$("#brandId").val();
	var brandName=$("#brandName").val();
	if(brandId==""||brandName==""){
		noty({text:"请选择品牌,如没有请申请添加",layout:'topCenter',type:"error",timeout:3000})
		return;
	}
	var code=$("#code").val().trim();
	var remark=$("#remark").val().trim();
	if(code.length>0&&code.length!=8){
		noty({text:"授权码为8位",layout:'topCenter',type:"error",timeout:3000})
		return;
	}
	$.ajax({
		url:"../basic/addUserBrandPUser",
		type:"POST",
		dataType:"json",
		data:{"brandId":brandId,"brankName":brandName,"authCode":code,"pUserRemark":remark},
		success:function(data){
			if(data!=null){
				if(data.result==1){
					noty({text:"成功添加该品牌",layout:'topCenter',type:"success",timeout:2000})
					setTimeout(function(){window.location.href="../basic/brandList?menuids=2_2&industryId=0"},2000);
				}else{
					noty({text:data.msg,layout:'topCenter',type:"error",timeout:3000})
				}
			}else{
				noty({text:"请求出错",layout:'topCenter',type:"error",timeout:2000})
			}
		}
	})
	
	
	
}