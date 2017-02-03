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
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-extended dropdown-notification dropdown-dark" id="header_notification_bar">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<i class="icon-bell"></i>
						<span class="badge badge-success">
						7 </span>
						</a>
						<ul class="dropdown-menu">
							<li class="external">
								<h3><span class="bold">12 pending</span> notifications</h3>
								<a href="extra_profile.html">view all</a>
							</li>
							<li>
								<ul class="dropdown-menu-list scroller" style="height: 250px;" data-handle-color="#637283">
									<li>
										<a href="javascript:;">
										<span class="time">just now</span>
										<span class="details">
										<span class="label label-sm label-icon label-success">
										<i class="fa fa-plus"></i>
										</span>
										New user registered. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">3 mins</span>
										<span class="details">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
										Server #12 overloaded. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">10 mins</span>
										<span class="details">
										<span class="label label-sm label-icon label-warning">
										<i class="fa fa-bell-o"></i>
										</span>
										Server #2 not responding. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">14 hrs</span>
										<span class="details">
										<span class="label label-sm label-icon label-info">
										<i class="fa fa-bullhorn"></i>
										</span>
										Application error. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">2 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
										Database overloaded 68%. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">3 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
										A user IP blocked. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">4 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-warning">
										<i class="fa fa-bell-o"></i>
										</span>
										Storage Server #4 not responding dfdfdfd. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">5 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-info">
										<i class="fa fa-bullhorn"></i>
										</span>
										System Error. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">9 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
										Storage server failed. </span>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
					<!-- END NOTIFICATION DROPDOWN -->
					<li class="separator hide">
					</li>
					<!-- BEGIN INBOX DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-extended dropdown-inbox dropdown-dark" id="header_inbox_bar">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<i class="icon-envelope-open"></i>
						<span class="badge badge-danger">
						4 </span>
						</a>
						<ul class="dropdown-menu">
							<li class="external">
								<h3>You have <span class="bold">7 New</span> Messages</h3>
								<a href="inbox.html">view all</a>
							</li>
							<li>
								<ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
									<li>
										<a href="inbox.html?a=view">
										<span class="photo">
										<img src="<%=request.getContextPath() %>/resources/admin/layout4/img/avatar2.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Lisa Wong </span>
										<span class="time">Just Now </span>
										</span>
										<span class="message">
										Vivamus sed auctor nibh congue nibh. auctor nibh auctor nibh... </span>
										</a>
									</li>
									<li>
										<a href="inbox.html?a=view">
										<span class="photo">
										<img src="<%=request.getContextPath() %>/resources/admin/layout4/img/avatar3.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Richard Doe </span>
										<span class="time">16 mins </span>
										</span>
										<span class="message">
										Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>
										</a>
									</li>
									<li>
										<a href="inbox.html?a=view">
										<span class="photo">
										<img src="<%=request.getContextPath() %>/resources/admin/layout4/img/avatar1.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Bob Nilson </span>
										<span class="time">2 hrs </span>
										</span>
										<span class="message">
										Vivamus sed nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>
										</a>
									</li>
									<li>
										<a href="inbox.html?a=view">
										<span class="photo">
										<img src="<%=request.getContextPath() %>/resources/admin/layout4/img/avatar2.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Lisa Wong </span>
										<span class="time">40 mins </span>
										</span>
										<span class="message">
										Vivamus sed auctor 40% nibh congue nibh... </span>
										</a>
									</li>
									<li>
										<a href="inbox.html?a=view">
										<span class="photo">
										<img src="<%=request.getContextPath() %>/resources/admin/layout4/img/avatar3.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Richard Doe </span>
										<span class="time">46 mins </span>
										</span>
										<span class="message">
										Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
					<!-- END INBOX DROPDOWN -->
					<li class="separator hide">
					</li>
					<!-- BEGIN TODO DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-extended dropdown-tasks dropdown-dark" id="header_task_bar">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<i class="icon-calendar"></i>
						<span class="badge badge-primary">
						3 </span>
						</a>
						<ul class="dropdown-menu extended tasks">
							<li class="external">
								<h3>You have <span class="bold">12 pending</span> tasks</h3>
								<a href="page_todo.html">view all</a>
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
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Application deployment</span>
										<span class="percent">65%</span>
										</span>
										<span class="progress">
										<span style="width: 65%;" class="progress-bar progress-bar-danger" aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">65% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Mobile app release</span>
										<span class="percent">98%</span>
										</span>
										<span class="progress">
										<span style="width: 98%;" class="progress-bar progress-bar-success" aria-valuenow="98" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">98% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Database migration</span>
										<span class="percent">10%</span>
										</span>
										<span class="progress">
										<span style="width: 10%;" class="progress-bar progress-bar-warning" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">10% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Web server upgrade</span>
										<span class="percent">58%</span>
										</span>
										<span class="progress">
										<span style="width: 58%;" class="progress-bar progress-bar-info" aria-valuenow="58" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">58% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Mobile development</span>
										<span class="percent">85%</span>
										</span>
										<span class="progress">
										<span style="width: 85%;" class="progress-bar progress-bar-success" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">85% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">New UI release</span>
										<span class="percent">38%</span>
										</span>
										<span class="progress progress-striped">
										<span style="width: 38%;" class="progress-bar progress-bar-important" aria-valuenow="18" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">38% Complete</span></span>
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
						<s:property value="#session.admin.username"/> </span>
						<!-- DOC: Do not remove below empty space(&nbsp;) as its purposely used -->
						<img alt="" class="img-circle" src="<%=request.getContextPath() %>/resources/admin/layout4/img/avatar9.jpg"/>
						</a>
						<ul class="dropdown-menu dropdown-menu-default">
							<li>
								<a href="extra_profile.html">
								<i class="icon-user"></i> My Profile </a>
							</li>
							<li>
								<a href="page_calendar.html">
								<i class="icon-calendar"></i> My Calendar </a>
							</li>
							<li>
								<a href="inbox.html">
								<i class="icon-envelope-open"></i> My Inbox <span class="badge badge-danger">
								3 </span>
								</a>
							</li>
							<li>
								<a href="page_todo.html">
								<i class="icon-rocket"></i> My Tasks <span class="badge badge-success">
								7 </span>
								</a>
							</li>
							<li class="divider">
							</li>
							<li>
								<a href="../home/lock">
								<i class="icon-lock"></i>锁屏</a>
							</li>
							<li>
								<a href="../home/logout">
								<i class="icon-key"></i> 退出 </a>
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
					<a href="admin">
					<i class="icon-home"></i>
					<span  class="title selected">首页</span>
					 <span class="arrow"></span>
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
                <li id="menupage4">
                    <a href="javascript:;">
                        <i class="fa fa-table"></i>
                        <span class="title">销售管理</span>
                        <span class="arrow "></span>
                    </a>
                     <ul class="sub-menu">
                        <li id="menupage4_0">
                            <a href="../User/UserList.jsp?active=menupage4_0"><i class="fa fa-th"></i>销售</a>
                        </li>
                        <li id="menupage4_1">
                            <a href="../User/AddUser.jsp?active=menupage4_1"><i class="fa fa-th"></i>销售列表</a>
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
                            <a href="../test/test2.jsp?active=menupage5_0"> <i class="fa  fa-circle-o"></i>调拨单</a>
                        </li>
                         <li id="menupage5_0">
                            <a href="../test/test2.jsp?active=menupage5_0"><i class="fa fa-signal"></i>其他入库单</a>
                        </li>
                         <li id="menupage5_0">
                            <a href="../test/test2.jsp?active=menupage5_0"><i class="fa fa-bar-chart-o"></i>其他出库单</a>
                        </li>
                        <li id="menupage5_1">
                            <a href="../test/test2.jsp?active=menupage5_0"><i class="fa fa-tachometer"></i>库存量查询</a>
                        </li>
                         
                    </ul>
                </li>
                <li id="menupage6">
                    <a href="javascript:;">
                        <i class="fa fa-mortar-board"></i>
                        <span class="title">报表查询</span>
                        <span class="arrow "></span>
                    </a>
                     <ul class="sub-menu">
                        <li id="menupage6_0">
                            <a href="javascript:void(0)"><i class="fa fa-male"></i>采购报表<span class="arrow "></span></a>
                            <ul class="sub-menu">
								<li id="menupage6_0">
									<a href="../admin/add?menuids=6_0">
									<i class="icon-user"></i>
									采购统计表
									</a>
								</li>
								<li id="menupage6_0_1">
									<a href="../admin/list?menuids=6_0">
									<i class="icon-user"></i>
										采购明细表
									</a>
								</li>
							</ul>
                        </li>
                        <li id="menupage6_1">
                            <a href="javascript:void(0)"><i class="fa fa-user"></i>销售报表 <span class="arrow "></span></a>
                            <ul class="sub-menu">
								<li id="menupage6_1">
									<a href="../role/add?menuids=6_1">
									<i class="icon-user"></i>
									销售统计表
									</a>
								</li>
								<li id="menupage6_1_1">
									<a href="../role/roles?menuids=6_1">
									<i class="icon-user"></i>
									销售毛利统计表
									</a>
								</li>
							</ul>
                        </li>
                        <li id="menupage6_2">
                            <a href="javascript:void(0)"><i class="fa fa-users"></i>组别 <span class="arrow "></a>
                            <ul class="sub-menu">
								<li id="menupage6_2">
									<a href="../group/add?menuids=6_2">
									<i class="icon-user"></i>
									添加组别
									</a>
								</li>
								<li id="menupage6_2_1">
									<a href="../group/groups?menuids=6_2">
									<i class="icon-user"></i>
									组别列表
									</a>
								</li>
							</ul>
                        </li>
                        <li id="menupage6_3">
                            <a href="../resource/list?menuids=6_3"><i class="fa  fa-graduation-cap"></i>权限</a>
                        </li>
                    </ul>
                </li>
                <li id="menupage7">
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
