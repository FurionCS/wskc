<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ page isELIgnored="false" %>

<Layout:block name="import"></Layout:block>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<!-- BEGIN HEAD -->
<head>
<title><Layout:block name="title"></Layout:block></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- UC强制全屏 -->
<meta name="full-screen" content="yes">
<!-- QQ强制全屏 -->
<meta name="x5-fullscreen" content="true">
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="<%=request.getContextPath() %>/resources/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/resources/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/resources/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/resources/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/global/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="<%=request.getContextPath() %>/resources/global/css/components-rounded.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/resources/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/resources/admin/layout4/css/layout.css" rel="stylesheet" type="text/css"/>
<link id="style_color" href="<%=request.getContextPath() %>/resources/admin/layout4/css/themes/light.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/resources/admin/layout4/css/custom.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/resources/admin/layout4/css/themes/default.css" ref="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="<%=request.getContextPath() %>/resources/global/img/mouse.ico"/>
<Layout:block name="Mycss"></Layout:block>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed page-sidebar-closed-hide-logo ">
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner">
		<!-- BEGIN LOGO -->
		<div class="page-logo hidden-xs">
			<a href="index.html">
			<img src="<%=request.getContextPath() %>/resources/admin/layout4/img/logo-light.png" alt="logo" class="logo-default"/>
			</a>
			<div class="menu-toggler sidebar-toggler" style="float:left">
				<!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
			</div>
		</div>
		<!-- END LOGO -->
	
		<!-- BEGIN PAGE TOP -->
		<div class="page-top">
			
			<!-- BEGIN TOP NAVIGATION MENU -->
			<div class="top-menu">
				<ul class="nav navbar-nav pull-right">
					<li class="separator hide">
					</li>
					<!-- BEGIN NOTIFICATION DROPDOWN -->
					<li class="separator hide">
					</li>
					<!-- BEGIN INBOX DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-extended dropdown-tasks dropdown-dark" id="header_inbox_bar">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<i class="icon-bell"></i>
						<span class="badge badge-danger">
						0 </span>
						</a>
						<ul class="dropdown-menu extended tasks">
							<li class="external">
								<h3>您有<span class="bold">0条</span>库存警告</h3>
							</li>
							<li>
								<ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
								</ul>
							</li>
						</ul>
					</li>
					<!-- END INBOX DROPDOWN -->
					<li class="separator hide">
					</li>
					<!-- BEGIN TODO DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-extended dropdown-tasks dropdown-dark" id="header_task_bar" style="display:none">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<i class="icon-bell"></i>
						<span class="badge badge-primary">
						3 </span>
						</a>
						<ul class="dropdown-menu extended tasks">
							<li class="external">
								<h3>您有<span class="bold">12 条</span> 待处理业务</h3>
							</li>
							<li>
								<ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">New release v1.2 </span>
										<span class="percent">30%</span>
										</span>
										<span class="progress">
										<span style="width: 40%;" class="progress-bar progress-bar-success" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">40% Complete</span></span>
										</span>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
					<!-- END TODO DROPDOWN -->
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-user dropdown-dark">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<span class="username username-hide-on-mobile">
						您好！${loginer.userNike }
						</span>
						<!-- DOC: Do not remove below empty space(&nbsp;) as its purposely used -->
						<img alt="" class="img-circle" src="${loginer.url }"/>
						</a>
						<ul class="dropdown-menu dropdown-menu-default">
							<li>
								<a href="../home/ShowUser">
								<i class="icon-user"></i>个人信息</a>
							</li>
							<li>
								<a href="../home/updatePassword">
								<i class="icon-key"></i>更改密码</a>
							</li>
							<li>
								<a href="../home/login">
								<i class="fa fa-location-arrow"></i>退出</a>
							</li>
 						</ul>
					</li>
					<!-- END USER LOGIN DROPDOWN -->
				</ul>
			</div>
			<!-- END TOP NAVIGATION MENU -->
				<!-- BEGIN RESPONSIVE MENU TOGGLER -->
			<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse" style="float: left;margin-left: 20px;">
			</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		</div>
		<!-- END PAGE TOP -->
	</div>
	<!-- END HEADER INNER -->
</div>
<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<div class="page-sidebar navbar-collapse collapse">
			<ul class="page-sidebar-menu " id="menuall" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
				<li class="start active">
					<a href="../home/index">
					<i class="icon-home"></i>
					<span  class="title">首页</span>
					</a>
				</li>
				 <li id="menupage2">
                    <a href="javascript:;">
                        <i class="icon-diamond"></i>
                        <span class="title">基础档案</span>
                        <span class="arrow "></span>
                    </a>
                     <ul class="sub-menu">
                     	<li id="menupage2_1">
                            <a href="../basic/industryList?menuids=2_1"> <i class="fa fa-briefcase"></i>所属行业</a>
                        </li>
                        <li id="menupage2_2">
                            <a href="../basic/brandList?menuids=2_2&industryId=0"> <i class="fa fa-circle-o-notch"></i>拥有品牌</a>
                        </li>
                        <li id="menupage2_3">
                            <a href="../basic/productList?menuids=2_3"><i class="fa fa-turkish-lira"></i>旗下产品</a>
                        </li>
                    </ul>
                </li>
                <li id="menupage3">
                    <a href="javascript:;">
                        <i class="fa fa-list-alt"></i>
                        <span class="title">采购管理</span>
                        <span class="arrow "></span>
                    </a>
                     <ul class="sub-menu">
                        <li id="menupage3_1">
                            <a href="../purchase/AddPurchase?menuids=3_1"><i class="fa  fa-list-ul"></i>采购</a>
                        </li>
                        <li id="menupage3_2">
                            <a href="../purchase/PurchaseList?menuids=3_2"><i class="fa   fa-align-justify"></i>采购列表</a>
                        </li>
                    </ul>
                </li>
				 <li id="menupage5">
                    <a href="javascript:;">
                        <i class="fa fa-eye"></i>
                        <span class="title">库存管理</span>
                        <span class="arrow "></span>
                    </a>
                     <ul class="sub-menu">
                        <li id="menupage5_0">
                            <a href="javascript:void(0)"> <i class="fa  fa-circle-o"></i>调拨单 <span class="arrow "></span></a>
                            <ul class="sub-menu">
								<li id="menupage5_0_1">
									<a href="../allocation/AllocationList?menuids=5_0">
									<i class="icon-user"></i>
									调拨单列表
									</a>
								</li>
								<li id="menupage5_0_2">
									<a href="../allocation/AddAllocation?menuids=5_0">
									<i class="icon-user"></i>
									添加调拨单
									</a>
								</li>
							</ul>
                        </li>
                         <li id="menupage5_1">
                            <a href="javascript:void(0)"><i class="fa fa-signal"></i>入库单 <span class="arrow "></span></a>
                             <ul class="sub-menu">
								<li id="menupage5_1_1">
									<a href="../storage/StorageList?menuids=5_1">
									<i class="icon-user"></i>
									入库单列表
									</a>
								</li>
								<li id="menupage5_1_2">
									<a href="../storage/AddStorage?menuids=5_1">
									<i class="icon-user"></i>
									添加入库单
									</a>
								</li>
							</ul>
                        </li>
                         <li id="menupage5_2">
                            <a href="javascript:void(0)"><i class="fa fa-bar-chart-o"></i>出库单<span class="arrow "></span></a>
                             <ul class="sub-menu">
								<li id="menupage5_2_1">
									<a href="../library/LibraryList?menuids=5_2">
									<i class="icon-user"></i>
									出库单列表
									</a>
								</li>
								<li id="menupage5_2_2">
									<a href="../library/AddLibrary?menuids=5_2">
									<i class="icon-user"></i>
									添加出库单
									</a>
								</li>
							</ul>
                        </li>
                        <li id="menupage5_3">
                            <a href="../stock/StockList?menuids=5_3"><i class="fa fa-tachometer"></i>库存量查询</a>
                        </li>
                    </ul>
                </li>
                 <li id="menupage4">
                    <a href="javascript:;">
                        <i class="fa fa-table"></i>
                        <span class="title">销售管理</span>
                        <span class="arrow "></span>
                    </a>
                     <ul class="sub-menu">
                        <li id="menupage4_0">
                            <a href="../sole/AddSole?menuids=4_0"><i class="fa fa-th"></i>销售</a>
                        </li>
                        <li id="menupage4_1">
                            <a href="../sole/SoleList?menuids=4_1"><i class="fa fa-th"></i>销售列表</a>
                        </li>
                    </ul>
                </li>
                <li id="menupage6">
                    <a href="javascript:;">
                        <i class="fa fa-mortar-board"></i>
                        <span class="title">查询</span>
                        <span class="arrow "></span>
                    </a>
                     <ul class="sub-menu">
                        <li id="menupage6_0">
                            <a href="javascript:void(0)"><i class="fa fa-male"></i>采购图表<span class="arrow "></span></a>
                            <ul class="sub-menu">
								<li id="menupage6_0">
									<a href="../purchase/PurchaseChart?menuids=6_0">
									<i class="icon-user"></i>
									采购统计图表
									</a>
								</li>
							</ul>
                        </li>
                        <li id="menupage6_1">
                            <a href="javascript:void(0)"><i class="fa fa-user"></i>销售图表<span class="arrow "></span></a>
                            <ul class="sub-menu">
								<li id="menupage6_1">
									<a href="../sole/SoleChart?menuids=6_1">
									<i class="icon-user"></i>
									销售统计图表
									</a>
								</li>
								<li id="menupage6_1_1">
									<a href="../sole/SoleNetChart?menuids=6_1">
									<i class="icon-user"></i>
									销售净利润图表
									</a>
								</li>
							</ul>
                        </li>
                        <li id="menupage6_2">
                            <a href="javascript:void(0)"><i class="fa fa-users"></i>代理库存查询<span class="arrow "></span></a>
                            <ul class="sub-menu">
								<li id="menupage6_2">
									<a href="../stock/AgentKc?menuids=6_2">
									<i class="icon-user"></i>
									直属代理
									</a>
								</li>
								<li id="menupage6_2">
									<a href="../stock/AgentKcTree?menuids=6_2">
									<i class="icon-user"></i>
									代理库存树
									</a>
								</li>
							</ul>
                        </li>
                    </ul>
                </li>
                <li id="menupage7" style="display:none">
                    <a href="javascript:;">
                        <i class="fa fa-eye"></i>
                        <span class="title">系统管理</span>
                        <span class="arrow "></span>
                    </a>
                     <ul class="sub-menu">
                        <li id="menupage7_0">
                            <a href="../test/test2.jsp?active=menupage7_0"> <i class="fa  fa-circle-o"></i>用户管理</a>
                        </li>
                         <li id="menupage7_0">
                            <a href="../test/test2.jsp?active=menupage7_0"><i class="fa fa-signal"></i>用户日志</a>
                        </li>
                         <li id="menupage7_0">
                            <a href="../test/test2.jsp?active=menupage7_0"><i class="fa fa-bar-chart-o"></i>系统配置<span class="arrow "></a>
                             <ul class="sub-menu">
								<li id="menupage6_2">
									<a href="../group/add?menuids=6_2">
									<i class="icon-user"></i>
									角色管理
									</a>
								</li>
								<li id="menupage6_2_1">
									<a href="../group/groups?menuids=6_2">
									<i class="icon-user"></i>
									角色权限管理
									</a>
								</li>
							</ul>
                        </li>
                    </ul>
                </li>
		</ul>
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN PAGE HEADER-->
			
			
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
	 	<Layout:block name="MyContent"></Layout:block>
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<input id="menu"  value='${menuids}' hidden/>
<!-- BEGIN FOOTER -->
<div class="page-footer hidden-xs">
	<div class="page-footer-inner">
		 2016 &copy; NetShop by cs. <a href="http://github.com/FurionCS" title="程胜的github" target="_blank">github</a>
	</div>
	<div class="scroll-to-top">
		<i class="icon-arrow-up"></i>
	</div>
</div>
<jsp:include page="/WEB-INF/jsp/template/warnStockTemplate.jsp"></jsp:include> 
<!-- <div id="coverdiv"> <div id="cover"> </div> 	</div> -->
<script src="<%=request.getContextPath() %>/resources/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="<%=request.getContextPath() %>/resources/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/global/plugins/wloften.js" type="text/javascript"></script>

<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<%=request.getContextPath() %>/resources/global/scripts/metronic.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/admin/layout4/scripts/layout.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/admin/layout4/scripts/demo.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/admin/pages/scripts/table-managed.js"></script>
<!-- beigin noty -->
<script src="<%=request.getContextPath() %>/resources/admin/noty/jquery.noty.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/admin/noty/packaged/jquery.noty.packaged.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/admin/noty/layouts/topCenter.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/admin/noty/themes/default.js" type="text/javascript"></script>
 <!-- end noty -->   
<script src="<%=request.getContextPath() %>/resources/js/core/jquery.basic.tool.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/js/template/template.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/home/warnStock.js"></script>
<Layout:block name="MyScript"></Layout:block>
<script>

jQuery(document).ready(function() {       
   Metronic.init(); // init metronic core components
   Layout.init(); // init current layout
   var menuid ="menupage"+$("#menu").val();
   if (menuid == null || menuid == "menupage") {
       return;
   }
   else {
       $("#menuall").children().removeClass("active");
       $("#" + menuid).addClass("active");
       $("#" + menuid).children("a").children(".arrow").addClass("open");
		
       if (menuid.split("_").length > 1) {
           $("#" + menuid.split("_")[0]).addClass("active");
           $("#" + menuid.split("_")[0]).children("a").children(".arrow").addClass("open");
           $("#" + menuid.split("_")[0]).children("a").append("<span class=\"selected\"></span>");
       }
   }
});
</script>
</body>
<!-- END BODY -->

</html>
