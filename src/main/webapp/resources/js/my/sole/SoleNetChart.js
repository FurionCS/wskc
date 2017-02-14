$(document).ready(function () {
    	var isphone=false;
    	isphone=browserRedirect();   
    	var pagewidth = $(window).width();
    	var pageheight = $(window).height();
    	if (isphone) {
    	 	window.addEventListener("onorientationchange" in window ? "orientationchange" : "resize", hengshuping, false);
    	 	$("#report_box").height(340);
    		$("#report_box").width("100%");
    	}
    	else {
    		$("#report_box").height("500px");
    		$("#report_box").width("100%");
    	}
       //下面是加载echarts报表
    	getSoleChart($("#brandId").val());
    	init();
    });
    	
    function hengshuping(){
    	if(window.orientation==180||window.orientation==0){
    		$("#report_box").height(340);
    		$("#report_box").width("100%");
    		//下面是加载echarts报表
        	init();
    	}
    	if(window.orientation==90||window.orientation==-90){
    		$("#report_box").height(340);
    		$("#report_box").width("100%");  
    		//下面是加载echarts报表
        	init();
    	}
    }

    	
    function init(){
    	///折现报表实现代码
    	var myChart = echarts.init(document.getElementById('report_box'));
    	option = {
    		    tooltip: {
    		        trigger: 'axis',
    		        confine:true 
    		    },
    		    legend: {
    		        data:productName,
    		        padding:[0,50,30,0]
    		    },
    		    grid: {
    		        left: '3%',
    		        right: '4%',
    		        bottom: '3%',
    		        containLabel: true
    		    },
    		    
    		    xAxis: {
    		        type: 'category',
    		        boundaryGap: false,
    		        data: month
    		    },
    		    yAxis: {
    		        type: 'value'
    		    },
    		    series: soleData
    		};
    	myChart.setOption(option);
    }
 $("#brandId").change(function(){
	  productName=[];
	  month=[];
	  soleData=[];
	 	getSoleChart($("#brandId").val());
 })
    
/**
 * 
 */
 var productName=[];
 var month=[];
 var soleData=[];
function getSoleChart(brandId){
	$.ajax({
		url:"../sole/SoleNetChart",
		type:"POST",
		dataType:"json",
		data:{"brandId":brandId},
		success:function(data){
			if(data!=null){
				if(data.result==1){
					productName=data.obj.productName;
					month=data.obj.month;
					for(var i=0;i<data.obj.totalMoney.length;i++){
						soleData[i]={name:productName[i],type:'line',areaStyle: {normal: {}},data:data.obj.totalMoney[i]}
					}
					init();
				}else{
					noty({text:data.msg,layout:'topCenter',type:"error",timeout:3000})
				}
			}else{
				noty({text:"请求出错",layout:'topCenter',type:"error",timeout:2000})
			}
		}
	})
}
