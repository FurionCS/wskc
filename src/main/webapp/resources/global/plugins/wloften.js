//时间格式（年月日）-----------------------------------将json传回来的string转换
function DateTime(date) {
    var NowDate = new Date();
    var NowDate2 = new Date(NowDate.getFullYear() + "/" + (NowDate.getMonth() + 1) + "/" + NowDate.getDate());
    var time = strtime.replace("下午", "").replace("上午", "").replace("AM", "").replace("PM", "").replace(/-/g, "/");
    if (time.indexOf("20") != 0)//不是以20开头，表示string省略了20
    {
        time = "20" + time;
    }
    var isam = (strtime.toString().indexOf("下午") > 0 || strtime.toString().indexOf("PM") > 0) ? false : true;
    var oDate = new Date(time);
    if (!isam)//是下午要加上12小时
    {
        oDate.setHours(oDate.getHours() + 12);
    }
    return oDate.Format("yyyy-MM-dd");
}
//修改时间格式（跟现在时间对比）————————————————将json传回来的string转换
function simpleTime(strtime) {
    if (strtime.length <= 0 || strtime == "undifend")
        return "";
    var NowDate = new Date();
    var NowDate2 = new Date(NowDate.getFullYear() + "/" + (NowDate.getMonth() + 1) + "/" + NowDate.getDate());
    var time = strtime.replace("下午", "").replace("上午", "").replace("AM", "").replace("PM", "").replace(/-/g, "/");
    if (time.indexOf("20") != 0)//不是以20开头，表示string省略了20
    {
        time = "20" + time;
    }
    var isam = (strtime.toString().indexOf("下午") > 0 || strtime.toString().indexOf("PM") > 0) ? false : true;
    var oDate = new Date(time);
    if (!isam)//是下午要加上12小时
    {
        oDate.setHours(oDate.getHours() + 12);
    }
    var oDate2 = new Date(oDate.getFullYear() + "/" + (oDate.getMonth() + 1) + "/" + oDate.getDate());;
    var date3 = NowDate2.getTime() - oDate2.getTime()  //时间差的毫秒数
    //计算出相差天数
    var days = Math.floor(date3 / (24 * 3600 * 1000))

    if (days == 0)//当天内的显示时间
    {
        return oDate.getHours() + ":" + oDate.getMinutes();
    }
    else if (days == 1) {
        return "昨天  " + oDate.getHours() + ":" + oDate.getMinutes();
    }
    else if (days == 2) {
        return "前天  " + oDate.getHours() + ":" + oDate.getMinutes();
    }
    else if (Number(NowDate.getFullYear() - oDate.getFullYear()) >= 1) {
        return oDate.Format("yyyy-MM-dd hh:mm");
    }
    else {
        return oDate.Format("MM-dd hh:mm");
    }
}
//缩短文字内容
function simpleText(txt, num)
{
    if (txt.length > num)
        return txt.substr(0, num)+"...";
    else
        return txt;
}
//控制时间格式————————————————将date类型转换成制定的格式的string类型
Date.prototype.Format = function (fmt) { //author: meizz   
    var o = {
        "M+": this.getMonth() + 1,                 //月份   
        "d+": this.getDate(),                    //日   
        "h+": this.getHours(),                   //小时   
        "m+": this.getMinutes(),                 //分   
        "s+": this.getSeconds(),                 //秒   
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度   
        "S": this.getMilliseconds()             //毫秒   
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
//获取URL参数
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return unescape(r[2]);
    return null;
}
//获取cookie
function getCookie(name) {
    var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if (arr != null && unescape(arr[2]) != "")
        return unescape(arr[2]); return null;
}
//写cookie
function setCookie(name, value) {

    //$.cookie('the_cookie', null, { path: '/' });
    //var startDate = new Date();
    //var endDate = startDate.getTime() + (3 * 60 * 60 * 1000);//3小时后Cookie过期
    //var now = "";
    //now = now + (startDate.getHours() + 3) + "点";
    //now = now + startDate.getMinutes() + "分";
    //$.cookie('the_cookie', '为您提供免费WIFI至    ' + now, { expires: endDate, domain: 'zzcxyz.com', path: '/' });


    var strsec = 3 * 60 * 60 * 1000;
    var exp = new Date();
    exp.setTime(exp.getTime() + strsec * 1);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}
//删除cookies
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}
//跳转新的页面
function Gotonew(href) {
    location.href = href;
}
//页内跳转新panel
function Goto(divid) {
    $.ui.loadContent(divid, false, false, "slide");
}
/*function goto(url) {
    window.location.href = url;
}
*/
//判断是否邮件
function IsEmail(email)
{
    var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if (!reg.test(email)) {
        return false;
    }
    else
        return true;
}
//bootstrap内容页面左栏修改选中页
function SelectMenu(obj)
{
    $(obj).parents().find(".tree").find(".selected").removeClass("selected");
    $(obj).addClass("selected");
}

function checkNumber(nubmer) {
    var re = /^[0-9]+.?[0-9]*$/;  
    if (!re.test(nubmer)) {
        return false;
    }
    return true;
}
//是否是手机号码
function IsPhone(tel) {
    var reg = /^0?1[3|4|5|8][0-9]\d{8}$/;
    if (reg.test(tel)) {
        return true;
    } else {
        return false;
    };
}