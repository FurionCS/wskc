var pageSize = 5; //一页显示的记录数
var pageIndex = 1; //当前页
var PSize = 5;
var orderby = "", strSearch = "";
var brandId=0;
var count = 0;  //总记录数
var pageCount=0;
getList(); 
$("#brand").change(function () {
    pageIndex = 1;
    getList();
});
function updateUserProductStatus(stockId,status,type){
			if(type==2){
				stockId=$("#hid").val();
				status=$("#status").val();
			}
			var text="";
			if(status==1){
				text="停用后,该产品的相关信息不能查询"
			}else{
				text="启用后,该产品的相关信息能查询了"
			}
            noty({
                text: text,
                type: 'information',
                layout: 'center',
                buttons: [
                    {
                        addClass: 'btn blue', text: '确定', onClick: function ($noty) {
                            $.ajax({
                                url: "../basic/updateUserProductStatus",
                                type: "POST",
                                data: {
                                    "stockId": stockId,
                                    "status":status
                                },
                                dataType: "json",
                                success: function (result) {
                                    if (result.result == 1) {               
                                        $noty.close();
                                        noty({ text:result.msg , type: 'information', layout: 'center', timeout: 2000 });
                                        var stopBtn=$("#stopBtn");
                                    	var restartBtn=$("#restartBtn");
                                        if(stopBtn!=undefined){
                                    		$(stopBtn).css("cssText","display: none!important");
                                    	}
                                		if(restartBtn!=undefined){
                                    		$(restartBtn).css("cssText","display: none!important");
                                    	}
                                        getList();
                                    }
                                    else {
                                        noty({ text:result.msg, type: 'warning', layout: 'center', timeout: 2000 });
                                    }
                                },
                                error: function () {
                                    noty({ text: "检查网络设置", type: 'warning', layout: 'center', timeout: 2000 });
                                }

                            });

                        }
                    },
                    {
                        addClass: 'btn red', text: '取消', onClick: function ($noty) {
                            $noty.close();
                        }
                    }
                ]
            });
    };
    function getList() {
        $.ajax({
            url: "../basic/findUserProduct",
            type: "POST",
            data: { "pageSize": pageSize, "offset": pageIndex-1, "brandId":brandId},
            dataType: "json",
            success: function (result) {  
                if (result!=null) {
                	count = result.obj.total;
                    var data=result.obj.datas;
                    var html = "";
                    for (var i = 0; i < data.length; i++) {
                    	html+=""
                    	html+='<tr onclick="selectTr('+data[i].stockId+','+data[i].status+',this)" id="tr_'+data[i].stockId+'">';
						html+='<td><a  href="../basic/showUserProduct?menuids=2_3&stockId='+data[i].stockId+'">'+data[i].productName+'</a></td>';
						html+='<td>'+data[i].size+'</td>';
						html+='<td>'+data[i].unit+'</td>';
						html+='<td>'+data[i].brandName+'</td>';
						if(data[i].status==1){
							html+='<td>正常</td>';
						}else{
							html+='<td>停用</td>';
						}
						html+='<td class="hidden-xs">';
						if(data[i].status==1){
							html+='<a href="javascript:void(0)" onclick="updateUserProductStatus('+data[i].stockId+','+data[i].status+',1)" class="label label-Danger" style="color: white;">停用</a>';
						}
						else{
							html+='<a href="javascript:void(0)" onclick="updateUserProductStatus('+data[i].stockId+','+data[i].status+',1)" class="label label-info" style="color: white;">启用</a>';
						}
						html+='</td></tr>';
                    }
                    $("#ListBody").html(html);
                }
                else {
                	count=0;
                    var html = "";
                    html += "<tr class='odd gradeX'>";
                    html += "<td colspan='10' style='text-align:center'>抱歉，还没有任何信息</td>";
                    html += "</tr>";
                    $("#ListBody").html(html);
                }
                $("#chk_All").attr("checked", false).closest("span").removeClass("checked");

                GetPageInfo(count);
            },
            error: function () {
                console.log("error");
            }
        });
    }

    function GetPageInfo(count) {
        var pageHtml = "";
        if (count != 0) {
            recordCount = count;
            pageCount = Math.ceil(recordCount / pageSize);

            if (pageIndex == 1) {
                pageHtml += "<li class='prev disabled' ><a><span class=' '>上一页</span></a></li>";
            }
            else {
                pageHtml += "<li class='prev' onclick='GotoPage(" + Number(pageIndex - 1) + ")'><a><span class=' '>上一页</span></a></li>";
            }

            var PNumCount = Math.ceil(pageCount / PSize);//判断总分页
            var PNum = parseInt((pageIndex - 1) / PSize);//判断第几页分页
            if (PNum >= 1)
                pageHtml += "<li onclick='GotoPage(" + Number((PNum - 1) * PSize + 1) + ")'><a >...</a></li>";
            for (var j = PNum * PSize; j < (pageCount <= PSize * (PNum + 1) ? pageCount : PSize * (PNum + 1)) ; j++) {
                if (j == pageIndex - 1) {
                    pageHtml += "<li class=\"active\"><a >" + (j + 1) + "</a></li>";
                }
                else {
                    pageHtml += "<li onclick='GotoPage(" + (j + 1) + ")'><a >" + (j + 1) + "</a></li>";
                }
            }
            if ((PNum + 1) < PNumCount)
                pageHtml += "<li onclick='GotoPage(" + Number((PNum + 1) * PSize + 1) + ")'><a >...</a></li>";

            if (pageIndex == pageCount) {
                pageHtml += " <li class='next disabled'><a><span class=''>下一页</span>  </a></li>";
            }
            else {
                pageHtml += " <li class='next' onclick='GotoPage(" + Number(pageIndex + 1) + ")'><a><span class=' '>下一页</span> </a></li>";
            }
            $("#pagePart").html(pageHtml);
            if (pageSize * pageIndex > recordCount) {
                if (recordCount == 0) {
                    $("#pageInfo").html("显示第 0 条数据到 0 条数据，总共 0 页");
                }
                else {
                    $("#pageInfo").html("显示第 " + ((pageIndex - 1) * pageSize + 1) + " 条数据到 " + recordCount + " 条数据，总共 " + pageCount + " 页");
                }
            }
            else {
                $("#pageInfo").html("显示第 " + ((pageIndex - 1) * pageSize + 1) + " 条数据到 " + pageSize * pageIndex + " 条数据，总共 " + pageCount + " 页");
            }
        }
        else {
            pageHtml += "<li class='prev disabled' ><a>← <span class=' '>上一页</span></a></li>";
            pageHtml += " <li class='next disabled'><a><span class=' '>下一页</span> → </a></li>";
            $("#pageInfo").html("显示 0 条数据到 0 条数据，总共 0 页");
        }
        $("#pagePart").html(pageHtml);
        if (pageIndex > pageCount) {
            pageIndex = pageCount;
        }
    }
    //跳转该页
    function GotoPage(topage) {
        pageIndex = topage;
        if (0 < topage && topage <= pageCount)
        	getList();
    }
    
  //取消选中  
    function uncheckAll()   {   
    	 var lst = document.getElementsByClassName("checkboxes");
    	 for (var i = 1; i < lst.length; i++) {
    		 if(lst[i].checked){
    			 lst[i].checked=false;
    		 }
    	 }
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
	//选中所有
    function CheckAll(obj) {
        var chkItems = $(obj).closest("table").find(".checkboxes")
        if (chkItems.length > 0) {
            for (var i = 1; i < chkItems.length; i++) {
                chkItems[i].checked = obj.checked;
                checkItem(chkItems[i]);
            }
        }
    }
    //选中一个
    function checkItem(obj) {
        if (obj.checked) {
            $(obj).closest("span").addClass("checked");
        }
        else {
            $(obj).closest("span").removeClass("checked");
        }
    }
    function selectTr(id,status,obj){
    	
    	var style=$(obj).attr("style"); 
    	var stopBtn=$("#stopBtn");
    	var restartBtn=$("#restartBtn");
    	if(style!=undefined){
    		$("#hid").val(-1);
    		$("#status").val(-1);
    		$(obj).removeAttr("style");
    		if(stopBtn!=undefined){
        		$(stopBtn).css("cssText","display: none!important");
        	}
    		if(restartBtn!=undefined){
        		$(restartBtn).css("cssText","display: none!important");
        	}
    	}
    	else{
    		$(obj).siblings().removeAttr("style");
    		$("#hid").val(id);
    		$("#status").val(status);
    		$(obj).css("background-color","rgb(255,228,141)");
    		
    		if(stopBtn!=undefined && status==1){
    			$(restartBtn).css("cssText","display: none!important");
    			$(stopBtn).css("cssText","display: block");
        	}
    		if(restartBtn!=undefined && status==0){
    			$(stopBtn).css("cssText","display: none!important");
    			$(restartBtn).css("cssText","display: block");
    		}
    	}
    }
    
    /**
     * 产品收索
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
        effectiveFieldsAlias:{Id: "序号", Keyword: "产品名称"},
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
                    "产品编号": json.obj[index].code,
                    "规格":json.obj[index].size
                });
            }
            console.log('淘宝搜索 API: ', data);
            return data;
        }
    }).on('onDataRequestSuccess', function (e, result) {
        console.log('onDataRequestSuccess: ', result);
        $("#productId").val("");
    }).on('onSetSelectValue', function (e, keyword, data) {
        console.log('onSetSelectValue: ', keyword, data);
        $("#productId").val(data.Id);
    }).on('onUnsetSelectValue', function () {
        console.log("onUnsetSelectValue");
    });
    
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
	  var warnNum=$("#warnNum").val();
	  var totalMoney=$("#totalMoney").val();
	  if(isNaN(num)|| !isDouble(totalMoney)||isNaN(warnNum)){
			noty({text:"库存量或总金额,警告数量格式不对",layout:'topCenter',type:"error",timeout:3000})
			return;
	  }
	  $.ajax({
			url:"../basic/AddUserProduct",
			type:"POST",
			dataType:"json",
			data:{"productId":productId,"num":num,"totalMoney":totalMoney,"warnNum":warnNum},
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
  
