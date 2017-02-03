function selectTr(id,obj){
	var style=$(obj).attr("style"); 
	if(style!=undefined){
		$("#hid").val(-1);
		$(obj).removeAttr("style");
	}
	else{
		$(obj).siblings().removeAttr("style");
		$("#hid").val(id);
		$(obj).css("background-color","rgb(255,228,141)");
	}
}