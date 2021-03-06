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
            url: "../storage/StorageList",
            type: "POST",
            data: { "pageSize": pageSize, "offset": pageIndex-1, "str":strSearch},
            dataType: "json",
            success: function (result) {  
                if (result!=null) {
                    var Data=result.obj.datas;
                    var html = "";
                    if(Data.length<1|| Data==undefined || me!=undefined){
           	    		 // 无数据
                           me.noData();
                    }
                    for (var i = 0; i < Data.length; i++) {
                    	var data=Data[i];
                    	html+=template('storageTemplate', data);
                    }
                    html=$("#ListBody").html()+html;
                    $("#ListBody").html(html);
                }
                else {
                    $("#ListBody").html(html);
                }
            },
            error: function () {
                console.log("error");
            }
        });
    }


/**
 * 下拉加载
 */
  $('.storageList').dropload({
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
   * 格式化状态
   */
  template.helper('statusFormat', function (data) {
	  if(data==0){
		  return "作废";
	  }else if(data==1){
		  return "待审";
	  }else if(data==2) {
		  return "已审";
	  }
  });
  