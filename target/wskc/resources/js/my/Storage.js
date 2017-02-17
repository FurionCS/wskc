/**
 * 采购单搜索
 */
$("#purchase").bsSuggest({
    indexId: 0,             //data.value 的第几个数据，作为input输入框的内容
    indexKey: 0,            //data.value 的第几个数据，作为input输入框的内容
    allowNoKeyword: false,  //是否允许无关键字时请求数据。为 false 则无输入时不执行过滤请求
    multiWord: true,        //以分隔符号分割的多关键字支持
    separator: ",",         //多关键字支持时的分隔符，默认为空格
    getDataMethod: "url",   //获取数据的方式，总是从 URL 获取
    showHeader: true,       //显示多个字段的表头
    autoDropup: true,       //自动判断菜单向上展开
    effectiveFields: ["Id","brandName"],
    effectiveFieldsAlias:{Id: "编码-产品名称", brandName: "品牌"},
    url: '../purchase/PurchaseSearch?q=', /*优先从url ajax 请求 json 帮助数据，注意最后一个参数为关键字请求参数*/
//     jsonp: 'callback',               //如果从 url 获取数据，并且需要跨域，则该参数必须设置
    // url 获取数据时，对数据的处理，作为 fnGetData 的回调函数
    fnProcessData: function(json){
        var index, len, data = {value: []}; 
        if(! json || ! json.obj || ! json.obj.length) {
            return false;
        }
        for (index = 0; index < json.obj.length; index++) {
            data.value.push({
                "Id": json.obj[index].purchaseNo+"  "+json.obj[index].productName,
                "brandName": json.obj[index].brandName,
                "brandId":json.obj[index].brandId,
                "productId":json.obj[index].productId,
                "productName":json.obj[index].productName,
                "num":json.obj[index].num,
                "price":json.obj[index].price,
                "purchaseNo":json.obj[index].purchaseNo
            });
        }
        console.log('淘宝搜索 API: ', data);
        return data;
    }
}).on('onDataRequestSuccess', function (e, result) {
    console.log('onDataRequestSuccess: ', result);
    $("#price").val("");
    $("#num").val("");
    $("#brandId").val("");
    $("#brandName").val("");
    $("#productId").val("");
    $("#productName").val("");
    $("#relevanceNo").val("0");
}).on('onSetSelectValue', function (e, keyword, data) {
    console.log('onSetSelectValue: ', keyword, data);
    $("#price").val(data.price);
    $("#num").val(data.num);
    $("#brandId").val(data.brandId);
    $("#brandName").val(data.brandName);
    $("#productId").val(data.productId);
    $("#productName").val(data.productName);
    $("#relevanceNo").val(data.purchaseNo);
}).on('onUnsetSelectValue', function () {
    console.log("onUnsetSelectValue");
});

/**
 * 调拨单搜索
 */
$("#allocation").bsSuggest({
    indexId: 0,             //data.value 的第几个数据，作为input输入框的内容
    indexKey: 0,            //data.value 的第几个数据，作为input输入框的内容
    allowNoKeyword: false,  //是否允许无关键字时请求数据。为 false 则无输入时不执行过滤请求
    multiWord: true,        //以分隔符号分割的多关键字支持
    separator: ",",         //多关键字支持时的分隔符，默认为空格
    getDataMethod: "url",   //获取数据的方式，总是从 URL 获取
    showHeader: true,       //显示多个字段的表头
    autoDropup: true,       //自动判断菜单向上展开
    effectiveFields: ["Id","brandName"],
    effectiveFieldsAlias:{Id: "编码-产品名称", brandName: "品牌"},
    url: '../allocation/AllocationSearch?type=1&q=', /*优先从url ajax 请求 json 帮助数据，注意最后一个参数为关键字请求参数*/
//     jsonp: 'callback',               //如果从 url 获取数据，并且需要跨域，则该参数必须设置
    // url 获取数据时，对数据的处理，作为 fnGetData 的回调函数
    fnProcessData: function(json){
        var index, len, data = {value: []}; 
        if(! json || ! json.obj || ! json.obj.length) {
            return false;
        }
        for (index = 0; index < json.obj.length; index++) {
            data.value.push({
                "Id": json.obj[index].allocationNo+"  "+json.obj[index].productName,
                "brandName": json.obj[index].brandName,
                "brandId":json.obj[index].brandId,
                "productId":json.obj[index].productId,
                "productName":json.obj[index].productName,
                "num":json.obj[index].num,
                "allocationNo":json.obj[index].allocationNo
            });
        }
        console.log('淘宝搜索 API: ', data);
        return data;
    }
}).on('onDataRequestSuccess', function (e, result) {
    console.log('onDataRequestSuccess: ', result);
    $("#num").val("");
    $("#brandId").val("");
    $("#brandName").val("");
    $("#productId").val("");
    $("#productName").val("");
    $("#relevanceNo").val("0");
}).on('onSetSelectValue', function (e, keyword, data) {
    console.log('onSetSelectValue: ', keyword, data);
    $("#num").val(data.num);
    $("#brandId").val(data.brandId);
    $("#brandName").val(data.brandName);
    $("#productId").val(data.productId);
    $("#productName").val(data.productName);
    $("#relevanceNo").val(data.allocationNo);
}).on('onUnsetSelectValue', function () {
    console.log("onUnsetSelectValue");
});
$(".form_datetime").datetimepicker({
	language:  'zh-CN', 
    format: "yyyy-mm-dd hh:ii:ss",
    autoclose: true,
    todayBtn: true,
    startDate: new Date(),
    minuteStep: 10
});

/**
 * 产品收索
 */
$("#product").bsSuggest({
    indexId: 0,             //data.value 的第几个数据，作为input输入框的内容
    indexKey: 1,            //data.value 的第几个数据，作为input输入框的内容
    allowNoKeyword: false,  //是否允许无关键字时请求数据。为 false 则无输入时不执行过滤请求
    multiWord: true,        //以分隔符号分割的多关键字支持
    separator: ",",         //多关键字支持时的分隔符，默认为空格
    getDataMethod: "url",   //获取数据的方式，总是从 URL 获取
    showHeader: true,       //显示多个字段的表头
    autoDropup: true,       //自动判断菜单向上展开
    effectiveFields: ["code","Keyword","size","unit"],
    effectiveFieldsAlias:{code: "序号", Keyword: "产品名称",size:"规格",unit:"单位"},
    url: '../basic/ProductSearch?q=', /*优先从url ajax 请求 json 帮助数据，注意最后一个参数为关键字请求参数*/
    //  jsonp: 'callback',               //如果从 url 获取数据，并且需要跨域，则该参数必须设置
    // 	url 获取数据时，对数据的处理，作为 fnGetData 的回调函数
    fnProcessData: function(json){
        var index, len, data = {value: []};

        if(! json || ! json.obj || ! json.obj.length) {
            return false;
        }
        for (index = 0; index < json.obj.length; index++) {
            data.value.push({
                "Id": json.obj[index].id,
                "Keyword": json.obj[index].name,
                "code": json.obj[index].code,
                "size":json.obj[index].size,
                "unit":json.obj[index].unit,
                "brandId":json.obj[index].brandId
            });
        }
        console.log('淘宝搜索 API: ', data);
        return data;
    }
}).on('onDataRequestSuccess', function (e, result) {
    console.log('onDataRequestSuccess: ', result);
    $("#productId").val("");
    $("#brandId").val("");
    $("#productName").val("");
}).on('onSetSelectValue', function (e, keyword, data) {
    console.log('onSetSelectValue: ', keyword, data);
    $("#productId").val(data.Id);
    $("#brandId").val(data.brandId);
    $("#productName").val(data.Keyword);
    $("#relevanceNo").val("0");
}).on('onUnsetSelectValue', function () {
    console.log("onUnsetSelectValue");
});
/**
 * 界面切换
 */
$("#types").change(function (){
	var i=$(this).children('option:selected').val(); 
	if(i=="采购入库"){
		$("#purchaseDiv").show();
		$("#allocationDiv").hide();
		$("#productDiv").hide();
	}else if(i=="调拨入库"){
		$("#allocationDiv").show();
		$("#purchaseDiv").hide();
		$("#productDiv").hide();
	}else if(i=="其他入库"){
		$("#purchaseDiv").hide();
		$("#allocationDiv").hide();
		$("#productDiv").show();
	}
})


/**
 * 添加入库单
 */
var flag=false;
function submitStorage(){
	if(flag){
		return;
	}
	flag=true;
	var brandId=$("#brandId").val().trim();
	var brandName=$("#brandName").val().trim();
	var productId=$("#productId").val().trim();
	var productName=$("#productName").val().trim();
	var price=$("#price").val();
	var num=$("#num").val();
	var type=$("#types").val(); 
	var status=$("#status").val();
	if(brandId==""||brandId<0 || productId=="" ||productId<0){
		noty({text:"请选择对应产品,或关联采购单,调拨单",layout:'topCenter',type:"error",timeout:3000})
		flag=false;
		return;
	}
	if(!isUnsigedInteger(num)){
		noty({text:"数量为整数",layout:'topCenter',type:"error",timeout:3000})
		flag=false;
		return;
	}
	var remark=$("#remark").val();
	var createTime=$("#createTime").val();
	if(createTime==""){
		createTime=new Date();
	}else{
		var regEx = new RegExp("\\-","gi"); 
		createTime=createTime.replace(regEx,"/"); 
	}
	if(status==""){
		noty({text:"请选择状态",layout:'topCenter',type:"error",timeout:3000})
		flag=false;
		return;
	}
	var relevanceNo=$("#relevanceNo").val();
	$.ajax({
		url:"../storage/AddStorage",
		type:"POST",
		dataType:"json",
		data:{"brandId":brandId,"brandName":brandName,"productId":productId,"productName":productName,"price":price,"num":num,"type":type,"status":status,"remark":remark,"createTime":createTime,"relevanceNo":relevanceNo},
		success:function(data){
			if(data!=null){
				if(data.result==1){
					noty({text:data.msg,layout:'topCenter',type:"success",timeout:2000})
					setTimeout(function(){window.location.href="../storage/StorageList?menuids=5_1"},2000);
					clearForm();
					flag=false;
				}else{
					noty({text:data.msg,layout:'topCenter',type:"error",timeout:3000})
					flag=false;
				}
			}else{
				noty({text:"请求出错",layout:'topCenter',type:"error",timeout:2000})
				flag=false;
			}
		}
	})
}
function clearForm(){
	$('#storageForm')[0].reset();
}


