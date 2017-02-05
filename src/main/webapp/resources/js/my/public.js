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
/**
 * 添加日期选择器语言
 */
$.fn.datetimepicker.dates['zh-CN'] = {  
        days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],  
        daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],  
        daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],  
        months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],  
        monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],  
        today: "今天",  
        suffix: [],  
        meridiem: ["上午", "下午"]  
}; 

/**
 * 判断是否是double
 * @param obj
 * @returns
 */
function isDouble(obj){
    var reg = /^-?\d+(\.\d+)?$/;
	return reg.test(obj);
}
/**
 * 判断是否正整数
 * @param obj
 * @returns
 */
function isUnsigedInteger(obj){
    var  reg =/^[0-9]*[1-9][0-9]*$/;
    return reg.test(obj);
}
/** 
 * 对日期进行格式化， 
 * @param date 要格式化的日期 
 * @param format 进行格式化的模式字符串
 *     支持的模式字母有： 
 *     y:年, 
 *     M:年中的月份(1-12), 
 *     d:月份中的天(1-31), 
 *     h:小时(0-23), 
 *     m:分(0-59), 
 *     s:秒(0-59), 
 *     S:毫秒(0-999),
 *     q:季度(1-4)
 * @return String
 * @author yanis.wang
 * @see	http://yaniswang.com/frontend/2013/02/16/dateformat-performance/
 */
template.helper('dateFormat', function (date, format) {

    date = new Date(date);

    var map = {
        "M": date.getMonth() + 1, //月份 
        "d": date.getDate(), //日 
        "h": date.getHours(), //小时 
        "m": date.getMinutes(), //分 
        "s": date.getSeconds(), //秒 
        "q": Math.floor((date.getMonth() + 3) / 3), //季度 
        "S": date.getMilliseconds() //毫秒 
    };
    format = format.replace(/([yMdhmsqS])+/g, function(all, t){
        var v = map[t];
        if(v !== undefined){
            if(all.length > 1){
                v = '0' + v;
                v = v.substr(v.length-2);
            }
            return v;
        }
        else if(t === 'y'){
            return (date.getFullYear() + '').substr(4 - all.length);
        }
        return all;
    });
    return format;
});
/**
 * 保留两位小数
 */
template.helper('doubleFormat', function (date) {
	return date.toFixed(2);
});


