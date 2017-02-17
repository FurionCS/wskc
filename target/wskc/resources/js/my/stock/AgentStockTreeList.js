
var brandId=-1;

var productId=-1; 
var url="";
/**
 * 检索
 */
function serachAgent(){
	  productId=$("#productId").val();
	  brandId=$("#brandId").val().trim();
	  if(brandId==""){
		  noty({text:"请选择品牌",layout:'topCenter',type:"error",timeout:3000});
	  }
	  $("#cancle").click();
	  url="../stock/AgentKcTreeInfo?brandId="+brandId+"&productId="+productId;
	  setTimeout(function(){getTree(productId,brandId)},500);
}
function getTree(productId,brandId){
	var id=$("#userId").val();
	var zNodes =[
	 			{ id:id, pId:0, name:"本人",isParent:"true",icon:"../resources/css/tree/img/diy/10.png"}	
	 		];
	var setting = {
			data: {
				simpleData: {
					enable: true
				}
			}
			,async: {
				enable: true,
				url:"../stock/AgentKcTreeInfo",
				autoParam:["id"],
				otherParam: { "brandId":brandId, "productId":productId},
				dataFilter: filter
			}
		};
	function filter(treeId, parentNode, childNodes) {
		if (!childNodes) return null;
		for (var i=0, l=childNodes.length; i<l; i++) {
			childNodes[i].name = childNodes[i].name.replace('','');
		}
		return childNodes;
	}
	$.fn.zTree.init($("#tree"), setting,zNodes);
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
      $("#brandId").val("-1");
      $("#kctree").html("库存树")
  }).on('onSetSelectValue', function (e, keyword, data) {
      console.log('onSetSelectValue: ', keyword, data);
      $("#productId").val(data.productId);
      $("#brandId").val(data.brandId);
      $("#kctree").html(data.Keyword);
  }).on('onUnsetSelectValue', function () {
      console.log("onUnsetSelectValue");
  });
  
