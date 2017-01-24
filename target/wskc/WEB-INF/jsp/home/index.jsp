<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
首页
</Layout:overwrite>
<%-- <Layout:overwrite name="Mycss"></Layout:overwrite> --%>
<Layout:overwrite name="myContent">
            <div class="widget-box transparent" style="margin: 0px;">
                <div class="widget-header" style="background-color: #f9f9f9">
                        <div class="widget-toolbar no-border" style="float: left; padding: 0px;">
                            <ul class="nav  nav-tabs nav-pills" id="myTab">
                                <li id="tab-FirstPage"><a data-toggle="tab" href="#tab-menuFirstPage"><i class="green ace-icon fa fa-home"></i>首页</a></li>
                            </ul>
                        </div>
                </div>
                <div class="widget-body">
                    <div class="widget-main padding-0">
                        <div id="myTabContent" class="tab-content" style="padding: 0px;">
                            <div id="tab-menuFirstPage" class="tab-pane fade" style="background-color: #fcfcfc;">
                                

                                <div style="padding: 10px 50px" id="homePage">
                                   
                                    
                                     <div class="row" style="padding-top: 10px;"></div>
                                    
<div class="row" id="CountMark" >     
                                       
<div class="col-sm-6 col-md-3">
    
 <div class="panel-stat3 no-radius btn-danger" id="cm0101" style="margin-bottom: 5px;margin-top: 5px;padding-top: 15px; padding-bottom: 15px;height: 137px;">
  <div style="height: 41px;" onclick="addTabByCountMark('0e750604-8c1a-4297-896d-d1ec8de6ad86','1')" >
   <h2 class="m-top-none" id="h2010101" style="margin-bottom: 0px;">0.00</h2>
   <h5 style="margin-top: 2px; margin-bottom: 0px;">库存总量</h5>
  </div>
  <div style="height: 41px; margin-top: 20px;"  onclick="addTabByCountMark('0e750604-8c1a-4297-896d-d1ec8de6ad86','1')">
   
   <h2 class="m-top-none" id="h2010102" style="margin-bottom: 0px;">0.00</h2>
   <h5 style="margin-top: 2px; margin-bottom: 0px;">库存成本</h5>
   
  </div>
  <div class="stat-icon"><i class="fa fa-3x fa-cubes"></i></div>
  <div class="refresh-button" onclick="RefreshCm('0101');"><i class="fa fa-refresh"></i></div>
  <div class="loading-overlay"><i class="loading-icon fa fa-refresh fa-spin fa-lg"></i></div>
 </div>

</div>
    <script type="text/javascript" >
        CardListFirst.push('0101');
    </script>
                                       
<div class="col-sm-6 col-md-3">
    
 <div class="panel-stat3 no-radius btn-info" id="cm0202" style="margin-bottom: 5px;margin-top: 5px;padding-top: 15px; padding-bottom: 15px;height: 137px;">
  <div style="height: 41px;" onclick="addTabByCountMark('d50e32d6-7ce5-4250-ac61-1e31a37a07aa','2')" >
   <h2 class="m-top-none" id="h2020201" style="margin-bottom: 0px;">0.00</h2>
   <h5 style="margin-top: 2px; margin-bottom: 0px;">本月销售总额</h5>
  </div>
  <div style="height: 41px; margin-top: 20px;"  onclick="addTabByCountMark('d50e32d6-7ce5-4250-ac61-1e31a37a07aa','2')">
   
   <h2 class="m-top-none" id="h2020202" style="margin-bottom: 0px;">0.00</h2>
   <h5 style="margin-top: 2px; margin-bottom: 0px;">本月销售毛利</h5>
   
  </div>
  <div class="stat-icon"><i class="fa fa-3x fa-dollar"></i></div>
  <div class="refresh-button" onclick="RefreshCm('0202');"><i class="fa fa-refresh"></i></div>
  <div class="loading-overlay"><i class="loading-icon fa fa-refresh fa-spin fa-lg"></i></div>
 </div>

</div>
    <script type="text/javascript" >
        CardListFirst.push('0202');
    </script>
                                       
<div class="col-sm-6 col-md-3">
    
 <div class="panel-stat3 no-radius btn-warning" id="cm0203" style="margin-bottom: 5px;margin-top: 5px;padding-top: 15px; padding-bottom: 15px;height: 137px;">
  <div style="height: 41px;" onclick="addTabByCountMark('d50e32d6-7ce5-4250-ac61-1e31a37a07aa','3')" >
   <h2 class="m-top-none" id="h2020301" style="margin-bottom: 0px;">0.00</h2>
   <h5 style="margin-top: 2px; margin-bottom: 0px;">本周销售总额</h5>
  </div>
  <div style="height: 41px; margin-top: 20px;"  onclick="addTabByCountMark('d50e32d6-7ce5-4250-ac61-1e31a37a07aa','3')">
   
   <h2 class="m-top-none" id="h2020302" style="margin-bottom: 0px;">0.00</h2>
   <h5 style="margin-top: 2px; margin-bottom: 0px;">本周销售毛利</h5>
   
  </div>
  <div class="stat-icon"><i class="fa fa-3x fa-dollar"></i></div>
  <div class="refresh-button" onclick="RefreshCm('0203');"><i class="fa fa-refresh"></i></div>
  <div class="loading-overlay"><i class="loading-icon fa fa-refresh fa-spin fa-lg"></i></div>
 </div>

</div>
    <script type="text/javascript" >
        CardListFirst.push('0203');
    </script>
                                       
<div class="col-sm-6 col-md-3">
    
 <div class="panel-stat3 no-radius btn-success" id="cm0302" style="margin-bottom: 5px;margin-top: 5px;padding-top: 15px; padding-bottom: 15px;height: 137px;">
  <div style="height: 41px;" onclick="addTabByCountMark('c949c2b5-5bb6-4705-8073-f7b85d0d6987','3')" >
   <h2 class="m-top-none" id="h2030201" style="margin-bottom: 0px;">0.00</h2>
   <h5 style="margin-top: 2px; margin-bottom: 0px;">本周采购额</h5>
  </div>
  <div style="height: 41px; margin-top: 20px;"  onclick="addTabByCountMark('','')">
   
   <div class="count2" style="padding-top: 10px;"><i class="fa fa-arrow-circle-o-up fa-lg  bigger-150"></i><span class="m-left-xs" style="font-size: 15px;">0.00%比上周</span></div>
   
  </div>
  <div class="stat-icon"><i class="fa fa-3x fa-shopping-cart"></i></div>
  <div class="refresh-button" onclick="RefreshCm('0302');"><i class="fa fa-refresh"></i></div>
  <div class="loading-overlay"><i class="loading-icon fa fa-refresh fa-spin fa-lg"></i></div>
 </div>

</div>
    <script type="text/javascript" >
        CardListFirst.push('0302');
    </script>
</div>
<div class="hr hr-15 col-xs-12 " style="border-top-color:#ededed"></div>
                                    
<div class="row" id="Chart">
     
<div class="col-sm-6 col-xs-12">
    <div id="csChart_XS_YWYPM">
        <div class=" endless panel fadeInDown animation-delay4 widget-box bg-white> " data-url="/SYChart/Chart_XS_YWYPM" data-num="0"  id="ChartChart_XS_YWYPM"  style="border-color:#ddd">
            
            <div class="panel-body">
                <div class="pull-right text-right">
                    <div id="dropdown_SreachTypeChart_XS_YWYPM" class="no-border mx-fpchart-tool">
                        <a href="javascript:void(0)" class="inline btn-group btn-trans" id="reloadChart_XS_YWYPM" onclick="RefreshCs('Chart_XS_YWYPM')" style="margin: 0px 7px 0px 0px"><i class="ace-icon fa fa-refresh bigger-150"></i></a>

                        <div class="inline btn-group"><a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown"><i class="ace-icon fa fa-cog bigger-150"></i></a>
                            <ul class="dropdown-menu dropdown-menu-right dropdown-125 dropdown-lighter dropdown-close dropdown-caret" style="z-index: 9998">
       
                                <li  data-chart="1"   data-code="Chart_XS_YWYPM" class="dropdown-li " ><a href="javascript:void(0)">本周</a></li>
       
                                <li  data-chart="2"   data-code="Chart_XS_YWYPM" class="dropdown-li " ><a href="javascript:void(0)">本月</a></li>
       
                                <li  data-chart="3"   data-code="Chart_XS_YWYPM" class="dropdown-li active" ><a href="javascript:void(0)">本季度</a></li>
       
                                <li  data-chart="4"   data-code="Chart_XS_YWYPM" class="dropdown-li " ><a href="javascript:void(0)">本年</a></li>
       
                                <li  data-chart="5"   data-code="Chart_XS_YWYPM" class="dropdown-li " ><a href="javascript:void(0)">去年</a></li>
    
                               </ul>
                        </div>

                    </div>
                </div>
                <div class="pull-center text-center">
                    <h4 class="no-margin"  style="font-size:14px;"><span id="CtitleChart_XS_YWYPM">按业务员销售排名</span></h4>
                </div>
                <div id="ChartsChart_XS_YWYPM" style="height: 150px; position: relative;"></div>
            </div>
                        
            <div class="panel-footer">
                <div class="row">

                    <div class="col-xs-6">
                        <h5 class="no-margin">销售总额</h5>
                    </div>
                    <div class="col-xs-6 text-right">
                        <h5 class="no-margin"><span id="TotalMoneyChart_XS_YWYPM01">￥0.00</span></h5>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div> 
    <script type="text/javascript" >
        ChartListFirst.push('Chart_XS_YWYPM');
    </script>
     
<div class="col-sm-6 col-xs-12">
    <div id="csChart_XS_KHPM">
        <div class=" endless panel fadeInDown animation-delay4 widget-box bg-white> " data-url="/SYChart/Chart_XS_KHPM" data-num="1"  id="ChartChart_XS_KHPM"  style="border-color:#ddd">
            
            <div class="panel-body">
                <div class="pull-right text-right">
                    <div id="dropdown_SreachTypeChart_XS_KHPM" class="no-border mx-fpchart-tool">
                        <a href="javascript:void(0)" class="inline btn-group btn-trans" id="reloadChart_XS_KHPM" onclick="RefreshCs('Chart_XS_KHPM')" style="margin: 0px 7px 0px 0px"><i class="ace-icon fa fa-refresh bigger-150"></i></a>

                        <div class="inline btn-group"><a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown"><i class="ace-icon fa fa-cog bigger-150"></i></a>
                            <ul class="dropdown-menu dropdown-menu-right dropdown-125 dropdown-lighter dropdown-close dropdown-caret" style="z-index: 9998">
       
                                <li  data-chart="1"   data-code="Chart_XS_KHPM" class="dropdown-li " ><a href="javascript:void(0)">本周</a></li>
       
                                <li  data-chart="2"   data-code="Chart_XS_KHPM" class="dropdown-li " ><a href="javascript:void(0)">本月</a></li>
       
                                <li  data-chart="3"   data-code="Chart_XS_KHPM" class="dropdown-li active" ><a href="javascript:void(0)">本季度</a></li>
       
                                <li  data-chart="4"   data-code="Chart_XS_KHPM" class="dropdown-li " ><a href="javascript:void(0)">本年</a></li>
       
                                <li  data-chart="5"   data-code="Chart_XS_KHPM" class="dropdown-li " ><a href="javascript:void(0)">去年</a></li>
    
                               </ul>
                        </div>

                    </div>
                </div>
                <div class="pull-center text-center">
                    <h4 class="no-margin"  style="font-size:14px;"><span id="CtitleChart_XS_KHPM">按照客户销售排名</span></h4>
                </div>
                <div id="ChartsChart_XS_KHPM" style="height: 150px; position: relative;"></div>
            </div>
                        
            <div class="panel-footer">
                <div class="row">

                    <div class="col-xs-6">
                        <h5 class="no-margin">销售总额</h5>
                    </div>
                    <div class="col-xs-6 text-right">
                        <h5 class="no-margin"><span id="TotalMoneyChart_XS_KHPM01">￥0.00</span></h5>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div> 
    <script type="text/javascript" >
        
        ChartListFirst.push('Chart_XS_KHPM');
    </script>
     
<div class="col-sm-6 col-xs-12">
    <div id="csChart_XS_MonthBJ">
        <div class=" endless panel fadeInDown animation-delay4 widget-box bg-white> " data-url="/SYChart/Chart_XS_MonthBJ" data-num="2"  id="ChartChart_XS_MonthBJ"  style="border-color:#ddd">
            
            <div class="panel-body">
                <div class="pull-right text-right">
                    <div id="dropdown_SreachTypeChart_XS_MonthBJ" class="no-border mx-fpchart-tool">
                        <a href="javascript:void(0)" class="inline btn-group btn-trans" id="reloadChart_XS_MonthBJ" onclick="RefreshCs('Chart_XS_MonthBJ')" style="margin: 0px 7px 0px 0px"><i class="ace-icon fa fa-refresh bigger-150"></i></a>

                        <div class="inline btn-group"><a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown"><i class="ace-icon fa fa-cog bigger-150"></i></a>
                            <ul class="dropdown-menu dropdown-menu-right dropdown-125 dropdown-lighter dropdown-close dropdown-caret" style="z-index: 9998">
       
                                <li  data-chart="4"   data-code="Chart_XS_MonthBJ" class="dropdown-li active" ><a href="javascript:void(0)">本年</a></li>
       
                                <li  data-chart="5"   data-code="Chart_XS_MonthBJ" class="dropdown-li " ><a href="javascript:void(0)">去年</a></li>
    
                               </ul>
                        </div>

                    </div>
                </div>
                <div class="pull-center text-center">
                    <h4 class="no-margin"  style="font-size:14px;"><span id="CtitleChart_XS_MonthBJ">按月销售比较分析</span></h4>
                </div>
                <div id="ChartsChart_XS_MonthBJ" style="height: 150px; position: relative;"></div>
            </div>
                        
            <div class="panel-footer">
                <div class="row">

                    <div class="col-xs-6">
                        <h5 class="no-margin">销售总额</h5>
                    </div>
                    <div class="col-xs-6 text-right">
                        <h5 class="no-margin"><span id="TotalMoneyChart_XS_MonthBJ01">￥0.00</span></h5>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div> 
    <script type="text/javascript" >
        
        ChartListFirst.push('Chart_XS_MonthBJ');
    </script>
     
<div class="col-sm-6 col-xs-12">
    <div id="csChart_KC_InvBJ">
        <div class=" endless panel fadeInDown animation-delay4 widget-box bg-white> " data-url="/SYChart/Chart_KC_InvBJ" data-num="3"  id="ChartChart_KC_InvBJ"  style="border-color:#ddd">
            
            <div class="panel-body" style="padding-top: 0px; padding-bottom: 0px;">
                <div class="pull-right text-right">
                    <div id="dropdown_SreachTypeChart_KC_InvBJ" class="no-border mx-fpchart-tool">
                        <a href="javascript:void(0)" class="inline btn-group btn-trans" id="reloadChart_KC_InvBJ" onclick="RefreshCs('Chart_KC_InvBJ')" style="margin: 0px 7px 0px 0px"><i class="ace-icon fa fa-refresh bigger-150"></i></a>

                    </div>
                </div>
                <div class="" style="top: 10px; right: 40%; position: absolute;"  >
                    <h4 class="no-margin" style="font-size:14px;"><span id="CtitleChart_KC_InvBJ">库存成本构成分析</span></h4>
                </div>
                <div style="height:15.4px"></div>
                <div id="ChartsChart_KC_InvBJ" style="height: 180px; position: relative;"></div>
            </div>
                        
            <div class="panel-footer">
                <div class="row">

                    <div class="col-xs-6">
                        <h5 class="no-margin">库存成本</h5>
                    </div>
                    <div class="col-xs-6 text-right">
                        <h5 class="no-margin"><span id="TotalMoneyChart_KC_InvBJ01">￥0.00</span></h5>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div> 
    <script type="text/javascript" >
        
        ChartListFirst.push('Chart_KC_InvBJ');
    </script>

</div>

                                    
                                     <div class="hr hr-15 col-xs-12 " style="border-top-color:#ededed"></div>
                                    
                                    <div class="row" id="fastMenu" >
                                        <div class="col-sm-6 col-xs-12">
                                            <div class="row left"></div>
                                        </div>
                                        <div class="col-sm-6 col-xs-12">
                                            <div class="row right"></div>
                                        </div>                                        
                                    </div>
                                    
                                     <div class="hr hr-15 col-xs-12 " style="border-top-color:#ededed"></div>
                                    
                                    <div class="row"  > 
                                        <div class="col-xs-12 col-sm-6 col-md-7 col-lg-7" style="padding:5px;">
                                     
                                        <div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
                                            <div class="width-100" style="overflow:hidden;">
                                            <div id="MainInfo" class="newslist"  style="width: 10000px; "> 
            <ul style="">
            
            
            </ul>
        </div>
                                                </div>
                                        </div>
                                            </div>     

                                        
                                      <div class="col-xs-12 col-sm-6 col-md-5 col-lg-5">   
                                          <div class="col-xs-12">
                                          <div >
                                              <div class="input-group input-icon">
																<input id="qs_input" class="form-control" type="text" placeholder="存货快速查询..." style="border:1px solid #6fb3e0;"/>
																<span class="input-group-btn">
																	<button id="qs_btn" class="btn  btn-info btn-no-border" type="button" style="height: 34px;">
																		查询
																	</button>
																</span>
                                                  <i class="ace-icon fa fa-search" style="color:#6fb3e0;"></i>
															</div>

                                     
                                          </div>
                                              </div>
                                        </div>
                                        
                                   </div>
                                    <p class="fonths text-center row" style="margin-top:20px;">
                                          ©2016 梦想云
                                    </p>
                                </div>                            
                                 
                            </div>

                        </div>
                    </div>
                </div>
            </div>
</Layout:overwrite>
<%-- <Layout:overwrite name="MyScript"></Layout:overwrite> --%>

<%@ include file="/share/_Layout.jsp"%>
      