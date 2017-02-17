/**
 * 品牌收索
 */
$("#product").bsSuggest({
    indexId: 2,             //data.value 的第几个数据，作为input输入框的内容
    indexKey: 1,            //data.value 的第几个数据，作为input输入框的内容
    allowNoKeyword: false,  //是否允许无关键字时请求数据。为 false 则无输入时不执行过滤请求
    multiWord: true,        //以分隔符号分割的多关键字支持
    separator: ",",         //多关键字支持时的分隔符，默认为空格
    getDataMethod: "url",   //获取数据的方式，总是从 URL 获取
    showHeader: true,       //显示多个字段的表头
    autoDropup: true,       //自动判断菜单向上展开
    effectiveFields: ["code","Keyword","brandName","size"], 
    effectiveFieldsAlias:{code: "编码", Keyword: "名称",size:"规格",brandName:"品牌"},
    url: '../purchase/productSearch?q=', /*优先从url ajax 请求 json 帮助数据，注意最后一个参数为关键字请求参数*/
//     jsonp: 'callback',               //如果从 url 获取数据，并且需要跨域，则该参数必须设置
    // url 获取数据时，对数据的处理，作为 fnGetData 的回调函数
    fnProcessData: function(json){
        var index, len, data = {value: []};

        if(! json || ! json.obj || ! json.obj.length) {
            return false;
        }
        for (index = 0; index < json.obj.length; index++) {
            data.value.push({
                "code": json.obj[index].code,
                "Keyword": json.obj[index].productName,
                "brandName": json.obj[index].brandName,
                "size":json.obj[index].size,
                "brandId":json.obj[index].brandId,
                "productId":json.obj[index].productId,
            });
        }
        console.log('淘宝搜索 API: ', data);
        return data;
    }
}).on('onDataRequestSuccess', function (e, result) {
    console.log('onDataRequestSuccess: ', result);
    $("#brandId").val("");
    $("#brandName").val("");
    $("#productId").val("");
    $("#productName").val("");
}).on('onSetSelectValue', function (e, keyword, data) {
    console.log('onSetSelectValue: ', keyword, data);
    $("#brandId").val(data.brandId);
    $("#brandName").val(data.brandName);
    $("#productId").val(data.productId);
    $("#productName").val(data.Keyword);
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
 * 提交采购单
 */
var flag=false;
function submitPurchase(){
	if(flag){
		return;
	}
	flag=true;
	   console.log($("#createTime").val());
		var brandId=$("#brandId").val();
		var brandName=$("#brandName").val();
		var productId=$("#productId").val();
		var productName=$("#productName").val();
		if(brandId==""||brandName=="" || productId=="" || productName==""){
			noty({text:"请选择产品,如没有请添加",layout:'topCenter',type:"error",timeout:3000});
			flag=false;
			return;
		}
		var price=$("#price").val().trim();
		var num=$("#num").val().trim();
		if(!isUnsigedInteger(num)){
			noty({text:"您填写的数量格式不正确",layout:'topCenter',type:"error",timeout:3000});
			flag=false;
			return;
		}
		var deliveryFee=$("#deliveryFee").val().trim();
		var otherFee=$("#otherFee").val().trim();
		if(deliveryFee==""){
			deliveryFee=0;
		}
		if(otherFee==""){
			otherFee=0;
		}
		if(!isDouble(price)||!isDouble(deliveryFee)||!isDouble(otherFee)){
			noty({text:"您填写的价格格式不正确",layout:'topCenter',type:"error",timeout:3000});
			flag=false;
			return;
		}
		var status=$("#status").val().trim();
		var remark=$("#remark").val();
		var createTime=$("#createTime").val();
		if(createTime==""){
			createTime=new Date();
		}else{
			var regEx = new RegExp("\\-","gi"); 
			createTime=createTime.replace(regEx,"/"); 
		}
		$.ajax({
			url:"../purchase/AddPurchase",
			type:"POST",
			dataType:"json",
			data:{"brandId":brandId,"brandName":brandName,"productId":productId,"productName":productName,"price":price,"num":num,"deliveryFee":deliveryFee,"otherFee":otherFee,"status":status,"remark":remark,"createTime":new Date(createTime)},
			success:function(data){
				if(data!=null){
					if(data.result==1){
						noty({text:data.msg,layout:'topCenter',type:"success",timeout:2000})
						setTimeout(function(){window.location.href="../purchase/PurchaseList?menuids=3_1"},2000);
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
	$('#purchaseForm')[0].reset();
}

