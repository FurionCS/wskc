
var pageSize = 2; //一页显示的记录数
var pageIndex = 1; //当前页
var PSize = 2;
var orderby = "", strSearch = "";
var brandId=0;
var pageCount=0;
getList(); 
function searchByStr(){
	 pageIndex = 1;
	 $("#ListBody").html("");
	 strSearch=$("#search").val().trim();
	 getList();
}
function getList(me) {
        $.ajax({
            url: "../purchase/PurchaseList",
            type: "POST",
            data: { "pageSize": pageSize, "offset": pageIndex-1, "str":strSearch},
            dataType: "json",
            success: function (result) {  
                if (result!=null) {
                    var Data=result.obj.datas;
                    var html = "";
                    if(Data.length<1 && me!=undefined){
           	    		 // 无数据
                           me.noData();
                    }
                    for (var i = 0; i < Data.length; i++) {
                    	var data=Data[i];
                    	html+=template('purchaseTemplate', data);
                    }
                    html=$("#ListBody").html()+html;
                    if( Data.length<pageSize&&Data.length>0){
                    	html+='<div class="col-md-8 col-xs-12" style="text-align:center">已无数据</div>';
                    }
                    $("#ListBody").html(html);
                }
                else {
                    if(me==undefined){
                    	html+='<div class="col-md-8 col-xs-12">已无数据</div>';
                    }
                    $("#ListBody").html(html);
                }
                $("#chk_All").attr("checked", false).closest("span").removeClass("checked");
            },
            error: function () {
                console.log("error");
            }
        });
    }

    /**标准化时间*/
	function StandardTime(Time){
		if(Time==null){
			return "未知时间";
		}
		else{
			return new Date(Time).Format("yyyy-MM-dd"); 
		}
	}

  /**
   * 提交添加用户产品
   */
  function submitUserProduct(){
	  var productId=$("#productId").val().trim();
	  if(productId==undefined || productId=="" || productId<1){
			noty({text:"请选择产品,如没有请添加",layout:'topCenter',type:"error",timeout:3000})
			return;
	  }
	  var num=$("#num").val();
	  var totalMoney=$("#totalMoney").val();
	  if(isNaN(num)|| !isDouble(totalMoney)){
			noty({text:"库存量或总金额格式不对",layout:'topCenter',type:"error",timeout:3000})
			return;
	  }
	  $.ajax({
			url:"../basic/AddUserProduct",
			type:"POST",
			dataType:"json",
			data:{"productId":productId,"num":num,"totalMoney":totalMoney},
			success:function(data){
				if(data!=null){
					if(data.result==1){
						noty({text:data.msg,layout:'topCenter',type:"success",timeout:2000})
						setTimeout(function(){window.location.href="../basic/productList?menuids=2_3"},2000);
					}else{
						noty({text:data.msg,layout:'topCenter',type:"error",timeout:3000})
					}
				}else{
					noty({text:"请求出错",layout:'topCenter',type:"error",timeout:2000})
				}
			}
		})
	  
	  
  }
  
/**
 * 下拉加载
 */
  $('.purchaseList').dropload({
	  	scrollArea:window,
	    domDown : {
            domClass   : 'dropload-down',
            domRefresh : '<div class="dropload-refresh col-md-8">上拉加载更多</div>',
            domLoad    : '<div class="dropload-load col-md-8"><span class="loading"></span>加载中...</div>',
            domNoData  : '<div class="dropload-noData col-md-8">已无数据</div>'
        },
        autoLoad:false,
        distance:40,
	    loadDownFn : function(me){
	    	pageIndex++;
	    	getList(me); 
	    	me.resetload();
	    }
	});
  
  /**
   * 编辑提交
   */
  function submitEditPurchase(){
		var id=$("#id").val();
		var price=$("#price").val().trim();
		var num=$("#num").val().trim();
		if(isNaN(num)){
			noty({text:"您填写的数量格式不正确",layout:'topCenter',type:"error",timeout:3000});
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
			return;
		}
		var status=$("#status").val().trim();
		var remark=$("#remark").val();
		$.ajax({
			url:"../purchase/EditPurchase",
			type:"POST",
			dataType:"json",
			data:{"id":id,"price":price,"num":num,"deliveryFee":deliveryFee,"otherFee":otherFee,"status":status,"remark":remark},
			success:function(data){
				if(data!=null){
					if(data.result==1){
						noty({text:data.msg,layout:'topCenter',type:"success",timeout:2000})
						setTimeout(function(){window.location.href="../purchase/showPurchase?menuids=3_2&id="+id},2000);
					}else{
						noty({text:data.msg,layout:'topCenter',type:"error",timeout:3000})
					}
				}else{
					noty({text:"请求出错",layout:'topCenter',type:"error",timeout:2000})
				}
			}
		})
}
  /**
   * 格式化状态
   */
  template.helper('statusFormat', function (data) {
	  if(data==0){
		  return "作废";
	  }else if(data==1){
		  return "待审";
	  }else if(data==2) {
		  return "已审";
	  }else if(data==3){
		  return "待入库";
	  }else if(data==4){
		  return "完成";
	  }
  });
