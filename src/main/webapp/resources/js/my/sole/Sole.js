
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
            url: "../sole/SoleList",
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
                    	html+=template('soleTemplate', data);
                    }
                    if(Data.length<1 && me==undefined){
                    	html+="<div class='col-md-8 col-xs-12' style='text-align: center;'>已无数据</div>"
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
 * 下拉加载
 */
  $('.soleList').dropload({
	  	scrollArea:window,
	    domDown : {
            domClass   : 'dropload-down col-md-12',
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
  function submitEditSole(){
		var id=$("#id").val();
		var factPrice=$("#factPrice").val().trim();
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
		if(!isDouble(price)||!isDouble(factPrice)||!isDouble(deliveryFee)||!isDouble(otherFee)){
			noty({text:"您填写的价格格式不正确",layout:'topCenter',type:"error",timeout:3000});
			return;
		}
		var status=$("#status").val().trim();
		var remark=$("#remark").val();
		$.ajax({
			url:"../sole/EditSole",
			type:"POST",
			dataType:"json",
			data:{"id":id,"factPrice":factPrice,"price":price,"num":num,"deliveryFee":deliveryFee,"otherFee":otherFee,"status":status,"remark":remark},
			success:function(data){
				if(data!=null){
					if(data.result==1){
						noty({text:data.msg,layout:'topCenter',type:"success",timeout:2000})
						setTimeout(function(){window.location.href="../sole/showSole?menuids=4_1&id="+id},2000);
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
		  return "待出库";
	  }else if(data==4){
		  return "完成";
	  }
  });