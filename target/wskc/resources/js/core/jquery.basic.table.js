(function($){
	var _setting;
	$.fn.mytable=function(opts){
		var setting = $.extend({
			pageSize:5,
			pageIndex:1,
			PSize:5,
			count:0,
			pageCount:0,
			orderby:opts?(opts.orderby||""):"",
			showUrl: opts?(opts.showUrl||"../admin/list"):"../admin/list",
			delUrl: opts?(opts.delUrl||"../admin/delete"):"../admin/delete",
			strSearch:""
		},opts||{});
		_setting=setting;
		 getList(); 
		 $("#pagesize").change(function () {
	            if (this.value < 0) {
	            	_setting.pageSize = _setting.count;
	            } else
	            	_setting.pageSize = this.value;
	            _setting.pageIndex = 1;
	            getList();
	        });
	    $("#search").keyup(function(){
	    		_setting.strSearch =this.value;
	              getList();
	    });
	    
	}
	 
	  function deleteUser(id){
	    	if(id==undefined){
		    	var lst = document.getElementsByClassName("checkboxes");
		        var str = "", shopnum = "";
		        for (var i = 1; i < lst.length; i++) {
		            if (lst[i].checked) {
		                str += (str == "") ? lst[i].value : ("," + lst[i].value);
		            }
		        }
	    	}else{
	    		str=""+id;
	    	}
	        if (str.length > 0)
	            noty({
	                text: '确定要删除选中的用户吗？',
	                type: 'information',
	                layout: 'center',
	                buttons: [
	                    {
	                        addClass: 'btn blue', text: '确定', onClick: function ($noty) {
	                            $.ajax({
	                                url: _setting.delUrl,
	                                type: "POST",
	                                data: {
	                                    "user.name": str  //用user.name代替id列表
	                                },
	                                dataType: "json",
	                                success: function (result) {
	                                    if (result.code == 1) {               
	                                        $noty.close();
	                                        noty({ text: "成功删除"+result.count+"条记录", type: 'information', layout: 'center', timeout: 2000 });
	                                        getList();
	                                        uncheckAll();
	                                    }
	                                    else {
	                                        noty({ text: "删除失败", type: 'warning', layout: 'center', timeout: 2000 });
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
	            url: _setting.showUrl,
	            type: "POST",
	            data: { "pageSize": _setting.pageSize, "offset": _setting.pageIndex-1, "strSearch": _setting.strSearch},
	            dataType: "json",
	            success: function (result) {  
	                if (result!=null) {
	                   _setting.count = result.total;
	                    var data=result.datas;
	                    var html = "";
	                    for (var i = 0; i < data.length; i++) {
	                        html += '<tr class="odd gradeX">';
	                        html += '<td class="sorting_1"><div class="checker"><span><input type="checkbox" onclick="checkItem(this);" class="checkboxes" value=' + data[i].id+ '></span></div></td>'; 
	                        html += '<td class="hidden-480">' + data[i].username+ '</td>';
	                        html += '<td class="hidden-480">' + data[i].nickname + '</td>';
	                        html += '<td class="hidden-480"><a href="mailto:userwow@gmail.com">'+ data[i].email + '</a></td>';
	                        html += '<td class="hidden-480">' + data[i].phone + '</td>';
	                        html += '<td class="hidden-480">' + StandardTime(data[i].createDate) + '</td>';
	                        html += '<td class="hidden-480">' + data[i].status + '</td>';
	                        html += '<td class="hidden-480"><a href="UserAction_getUserByIDForEdit?user.userID=' + data[i].id + '" class="label label-success" style="color: white;">编辑</a>';
	                        html += '<a onclick="deleteUser('+data[i].id+')" class="label label-danger" style="color: white;margin-left:5px;">删除</a></td></tr>';
	                    }
	                    $("#ListBody").html(html);
	                }
	                else {
	                	_setting.count=0;
	                    var html = "";
	                    html += "<tr class='odd gradeX'>";
	                    html += "<td colspan='10' style='text-align:center'>抱歉，还没有任何信息</td>";
	                    html += "</tr>";
	                    $("#ListBody").html(html);
	                }
	                $("#chk_All").attr("checked", false).closest("span").removeClass("checked");

	                GetPageInfo(_setting.count);
	            },
	            error: function () {
	                console.log("error");
	            }
	        });
	    }
	 function GetPageInfo(count) {
	        var pageHtml = "";
	        if (_setting.count != 0) {
	            recordCount = count;
	            _setting.pageCount = Math.ceil(recordCount / _setting.pageSize);

	            if (_setting.pageIndex == 1) {
	                pageHtml += "<li class='prev disabled' ><a>← <span class='hidden-480'>上一页</span></a></li>";
	            }
	            else {
	                pageHtml += "<li class='prev' onclick='GotoPage(" + Number(_setting.pageIndex - 1) + ")'><a>← <span class='hidden-480'>上一页</span></a></li>";
	            }

	            var PNumCount = Math.ceil(_setting.pageCount / _setting.PSize);//判断总分页
	            var PNum = parseInt((_setting.pageIndex - 1) / _setting.PSize);//判断第几页分页
	            if (PNum >= 1)
	                pageHtml += "<li onclick='GotoPage(" + Number((PNum - 1) * _setting.PSize + 1) + ")'><a >...</a></li>";
	            for (var j = PNum * _setting.PSize; j < (_setting.pageCount <= _setting.PSize * (PNum + 1) ? _setting.pageCount : _setting.PSize * (PNum + 1)) ; j++) {
	                if (j == _setting.pageIndex - 1) {
	                    pageHtml += "<li class=\"active\"><a >" + (j + 1) + "</a></li>";
	                }
	                else {
	                    pageHtml += "<li onclick='GotoPage(" + (j + 1) + ")'><a >" + (j + 1) + "</a></li>";
	                }
	            }
	            if ((PNum + 1) < PNumCount)
	                pageHtml += "<li onclick='GotoPage(" + Number((PNum + 1) * _setting.PSize + 1) + ")'><a >...</a></li>";

	            if (_setting.pageIndex == _setting.pageCount) {
	                pageHtml += " <li class='next disabled'><a><span class='hidden-480'>下一页</span> → </a></li>";
	            }
	            else {
	                pageHtml += " <li class='next' onclick='GotoPage(" + Number(_setting.pageIndex + 1) + ")'><a><span class='hidden-480'>下一页</span> → </a></li>";
	            }
	            $("#pagePart").html(pageHtml);
	            if (_setting.pageSize * _setting.pageIndex > recordCount) {
	                if (recordCount == 0) {
	                    $("#pageInfo").html("显示第 0 条数据到 0 条数据，总共 0 页");
	                }
	                else {
	                    $("#pageInfo").html("显示第 " + ((_setting.pageIndex - 1) * _setting.pageSize + 1) + " 条数据到 " + recordCount + " 条数据，总共 " + _setting.pageCount + " 页");
	                }
	            }
	            else {
	                $("#pageInfo").html("显示第 " + ((_setting.pageIndex - 1) * _setting.pageSize + 1) + " 条数据到 " + _setting.pageSize * _setting.pageIndex + " 条数据，总共 " + _setting.pageCount + " 页");
	            }
	        }
	        else {
	            pageHtml += "<li class='prev disabled' ><a>← <span class='hidden-480'>上一页</span></a></li>";
	            pageHtml += " <li class='next disabled'><a><span class='hidden-480'>下一页</span> → </a></li>";
	            $("#pageInfo").html("显示 0 条数据到 0 条数据，总共 0 页");
	        }
	        $("#pagePart").html(pageHtml);
	        if (_setting.pageIndex > _setting.pageCount) {
	            _setting.pageIndex = _setting.pageCount;
	        }
	    }
	  //跳转该页
	function GotoPage(topage) {
			_setting.pageIndex = topage;
	        if (0 < topage && topage <= _setting.pageCount)
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
})(jQuery)
