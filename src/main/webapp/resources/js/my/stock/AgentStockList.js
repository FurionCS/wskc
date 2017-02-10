var pageSize = 2; //一页显示的记录数
var pageIndex = 1; //当前页
var PSize = 2;
var orderby = "", strSearch = "";
var brandId=-1;
var pageCount=0;
var productId=-1; 
var maxNum=-1;


function getList(me) {
        $.ajax({
            url: "../stock/AgentKc",
            type: "POST",
            data: { "brandId":brandId,"productId":productId},
            dataType: "json",
            success: function (result) {  
                if (result!=null) {
                    var Data=result.obj;
                    var html = "";
                    if(Data.length<1|| Data==undefined || me!=undefined){
           	    		 // 无数据
                           me.noData();
                    }
                    for (var i = 0; i < Data.length; i++) {
                    	var data=Data[i];
                    	html+=template('productAgentTemplate', data);
                    }
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
   * 产品收索
   */
  $("#product").bsSuggest({
      idField: 'code',             //data.value 的第几个数据，作为input输入框的内容
      indexKey: 1,            //data.value 的第几个数据，作为input输入框的内容
      allowNoKeyword: false,  //是否允许无关键字时请求数据。为 false 则无输入时不执行过滤请求
      multiWord: true,        //以分隔符号分割的多关键字支持
      separator: ",",         //多关键字支持时的分隔符，默认为空格
      getDataMethod: "url",   //获取数据的方式，总是从 URL 获取
      showHeader: true,       //显示多个字段的表头
      autoDropup: true,       //自动判断菜单向上展开
      effectiveFields: ["code","Keyword","size"], 
      effectiveFieldsAlias:{code: "编码", Keyword: "名称",size:"规格"},
      url: '../purchase/productSearch?q=', /*优先从url ajax 请求 json 帮助数据，注意最后一个参数为关键字请求参数*/
//       jsonp: 'callback',               //如果从 url 获取数据，并且需要跨域，则该参数必须设置
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
                  "productId":json.obj[index].productId,
                  "size":json.obj[index].size,
                  "brandId":json.obj[index].brandId
              });
          }
          console.log(' API: ', data);
          return data;
      }
  }).on('onDataRequestSuccess', function (e, result) {
      console.log('onDataRequestSuccess: ', result);
      $("#productId").val("-1");
  }).on('onSetSelectValue', function (e, keyword, data) {
      console.log('onSetSelectValue: ', keyword, data);
      $("#productId").val(data.productId);
      $("#brandId").val(data.brandId);
  }).on('onUnsetSelectValue', function () {
      console.log("onUnsetSelectValue");
  });
  
  /**
   * 检索
   */
  function serachAgent(){
	  if($("#product").val().trim()!=""){
		  productId=$("#productId").val();
	  }
	   brandId=$("#brandId").val().trim();
	  
	  if(brandId==""){
		  noty({text:"请选择品牌",layout:'topCenter',type:"error",timeout:3000});
	  }
	  $("#cancle").click();
	  setTimeout(function(){getList()},500);
  }