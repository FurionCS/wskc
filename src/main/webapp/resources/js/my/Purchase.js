
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
                    if(Data.length<1|| Data==undefined){
           	    		 // 无数据
                           me.noData();
                    }
                    for (var i = 0; i < Data.length; i++) {
                    	var data=Data[i];
                    	html+=template('purchaseTemplate', data);
                    }
                    html=$("#ListBody").html()+html;
                    $("#ListBody").html(html);
                }
                else {
                    
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

