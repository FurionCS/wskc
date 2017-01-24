<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="Mytag" prefix="Layout"%>
<Layout:block name="import"></Layout:block>
<%@ page isELIgnored="false" %>
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
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<link rel="Bookmark" href="favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath() %>/resources/Images/Icons/favicon.ico" media="screen" />
<script src="<%=request.getContextPath() %>/resources/Scripts/jquery-1.11.1.min.js"></script>    
<script src="<%=request.getContextPath() %>/resources/Scripts/mxui-1.1.1/plugins/min/jquery.easyui.min.20160630.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/mxcss/easyui.css" />
<script src="<%=request.getContextPath() %>/resources/Scripts/mxui-1.1.1/plugins/min/mxui-opertool.min.20160630.js"></script>

<script src="<%=request.getContextPath() %>/resources/Scripts/mxui-1.1.1/plugins/bootstrap/min/mx-bootstrap.min.20160816.js"></script>

   <!-- Morris -->
<script src="<%=request.getContextPath() %>/resources/assets/js/rapheal.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/assets/js/morris.min.js"></script>
<!-- Morris -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/morris.css" />
<script src="<%=request.getContextPath() %>/resources/Scripts/mxmvc/min/InitHome.min.20160920.js"></script>

<script src="<%=request.getContextPath() %>/resources/Scripts/jquery.signalR-2.2.0.min.js"></script>

<script src="<%=request.getContextPath() %>/resources/signalr/hubs"></script>

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/bootstrap.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/font-awesome.css" />

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/jquery.gritter.css" />

   <!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/mxcss/mxmvc.css?random2c55445e-c71c-4840-b4fc-72ee827a4585" class="ace-main-stylesheet" />
<!--[if lte IE 9]>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/ace-part2.css" class="ace-main-stylesheet" />
<![endif]-->

<!--[if lte IE 9]>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/ace-ie.css" />
<![endif]-->

<!-- inline styles related to this page -->
<!-- ace settings handler -->
<script src="<%=request.getContextPath() %>/resources/assets/js/ace-extra.js"></script>
<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->
<!--[if lt IE 9]>
 <script src="<%=request.getContextPath() %>/resources/Scripts/mxui-1.1.1/plugins/ie8/min/forie8.min.20150214.js"></script>

<![endif]-->
<!-- Endless -->
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='"+<%=request.getContextPath() %>+"/resources/assets/js/jquery.mobile.custom.js'>" + "<" + "/script>");
</script>
<!-- page specific plugin scripts -->
<script src="<%=request.getContextPath() %>/resources/assets/js/ifeng-scroll.js"></script>
<!--[if lte IE 8]>
	  <script src="<%=request.getContextPath() %>/resources/assets/js/excanvas.js"></script>
<![endif]-->
  <style type="text/css">
        .nav-tabs,
        .nav-pills {
            position: relative;
        }
          .dropdown-preview {
            margin: 0 5px;
            display: inline-block;
        }

            .dropdown-preview > .dropdown-menu {
                display: block;
                position: static;
                margin-bottom: 5px;
            }
    </style>
    <script type="text/javascript">
        var isLearn = 'true';
        var isZXTX = 'False';
        var isGWXF = 'False';
    </script>
    <Layout:block name="myCss"></Layout:block>
</head>
<body class="skin-1">
 <!-- #section:basics/navbar.layout -->
    <div id="navbar" class="navbar navbar-default">
        <script type="text/javascript">
            try { ace.settings.check('navbar', 'fixed') } catch (e) {
            }
            var OldWindowNeedResize = true;
            //常用功能变量
            var HotMenuData = StringToJson('[{"MenuID":"e05dd883-d373-4c99-a208-0f94126b54d4","MnuName":"采购订单","URI":"CaiGou/CGOrderBill/Index","Icon":"fa-file-text","ObjID":"7fcf3308-83c5-4168-a2bb-69fff0f56e8e"},{"MenuID":"f8db098d-345b-4e20-9c4c-0d2372c7509e","MnuName":"销售单","URI":"Xiaoshou/XSBill/Index","Icon":"fa-file-text","ObjID":"6d94be91-c5a8-4429-a16a-02ffe18898f6"},{"MenuID":"a35ad2aa-151d-4682-ad7f-4bb50002f338","MnuName":"销售订单","URI":"Xiaoshou/XSOrderBill/Index","Icon":"fa-truck","ObjID":"667908a2-9862-448c-924a-33c46dd00bca"},{"MenuID":"15ab1705-0932-4c8e-8956-7bbeab9bef21","MnuName":"进货单","URI":"CaiGou/CGBill/Index","Icon":"fa-file-text","ObjID":"ab648de6-f18b-4d41-9ccd-d732ba39ecdb"},{"MenuID":"e75cf70d-e257-4c85-8180-9a46f4e0dff2","MnuName":"存货档案","URI":"BaseSet/KC_Inv/Index","Icon":"fa-folder-open","ObjID":"f192a37f-6aba-42a5-88c5-f8145a9a4645"},{"MenuID":"aaf3b208-d8cd-4e3e-96e3-488be7cbc45f","MnuName":"系统参数","URI":"SysBase/ParamItem/Index","Icon":"fa-cog","ObjID":"57444fb4-faf4-4f26-97b9-bc906dd70c84"},{"MenuID":"f9ec70ee-4a58-4d62-af4a-f29f456b4eb8","MnuName":"部门设置","URI":"BaseSet/bd_Department/Index","Icon":"fa-th-list","ObjID":"9043bade-499f-421c-b8d0-582537f5d680"},{"MenuID":"bd8c4235-b6e8-464c-a6fd-22299c049f0b","MnuName":"销售类型","URI":"BaseSet/JX_XSType/Index","Icon":"fa-sitemap","ObjID":"a52c4c1b-e087-4cef-b281-8b5ad7956ad6"}]');
            //首页统计变量
                     

            var MXCloud_Address = 'https://www.mxyun.com/';
            $.browser.set_scType();
            if ($.browser.useapp) { $("body").addClass("mx-xs"); } else { $("body").removeClass("mx-xs"); }
        </script>
        
                    <div style="position:fixed;left:0px;top:0px;">
            </div>
       
      
        <div class="navbar-container" id="navbar-container">
            <!-- #section:basics/sidebar.mobile.toggle -->
            <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
                <span class="sr-only">Toggle sidebar</span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>
            </button>

            <!-- /section:basics/sidebar.mobile.toggle -->
          

            <div class="navbar-header pull-left hidden-xs">
                <!-- #section:basics/navbar.layout.brand -->
                <a href="
                    https://www.mxyun.com
                    " class="navbar-brand " target="_blank" style="padding-top: 0px; padding-bottom: 0px;padding-right:0px;padding-left:5px;">
                    
                    <img src="<%=request.getContextPath() %>/resources/Images/mxlogo.png"  alt="梦想云"  style="height:45px"/> 
                </a>
                <span class="navbar-brand " style="padding-left: 0px;">
                    <small>| </small>
                        cs
                    </span>
                <!-- /section:basics/navbar.layout.brand -->

                <!-- #section:basics/navbar.toggle -->

                <!-- /section:basics/navbar.toggle -->
            </div>
            <!-- #section:basics/navbar.dropdown -->
            <div class="navbar-buttons navbar-header pull-right" role="navigation">
                <ul class="nav ace-nav">
                    <li class="purple">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <i class="ace-icon fa fa-tasks icon-animated-vertical"></i>
                            <span class="badge badge-warning" id="myWorkNum">1</span>
                        </a>

                        <ul class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
                            <li class="dropdown-header">
                                <i class="ace-icon fa fa-tasks"></i>
                          		      待处理任务列表
                                 <i class="ace-icon fa fa-close dropdown-header-close bigger-150"></i>
                            </li>

                            <li class="dropdown-content" data-size="250">
                                <ul class="dropdown-menu dropdown-navbar navbar-pink" id="myWork">
                                </ul>
                            </li>
                        </ul>
                    </li>

                    <li class="dark-opaque">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <i class="ace-icon fa fa-bell icon-animated-bell"></i>
                            <span class="badge badge-warning" id="kcWarringNum">1</span>
                        </a>
                        <ul class="dropdown-menu-right dropdown-navbar  dropdown-menu dropdown-caret dropdown-close">
                            <li class="dropdown-header">
                                <i class="ace-icon fa fa-exclamation-triangle"></i>
                                	预警消息列表
                                 <i class="ace-icon fa fa-close dropdown-header-close bigger-150"></i>
                            </li>
                            <li class="dropdown-content" data-size="250">
                                <ul class="dropdown-menu dropdown-navbar navbar-pink" id="kcWarring">
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <!-- #section:basics/navbar.user_menu -->
                    <li class="light-blue">
                        <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                            <img class="nav-user-photo" src="<%=request.getContextPath() %>/resources/Images/default_user.jpg" alt="我的头像" />
                            <span class="user-info hidden-xs">
                                <small>欢迎您,</small>
                             		   cs
                            </span>

                            <i class="ace-icon fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu-right dropdown-navbar  dropdown-menu  dropdown-caret dropdown-close">
                              <li class="dropdown-header">
                                <i class="ace-icon fa fa-user"></i>
                              		  我的梦想云
                                 <i class="ace-icon fa fa-close dropdown-header-close bigger-150"></i>
                            </li>
                            <li>
                                
                                <a href="#"  onclick="learnLimit()"  class="clearfix">
                                        
                                    <img src="<%=request.getContextPath() %>/resources/Images/default_user.jpg" class="msg-photo" alt="我的头像" />
                                    <span class="msg-body">
                                        <span class="msg-title">
                                           	 用户名
                                        </span>
                                        <span class="msg-title" style="display: block">所属：美丽浙江
                                        </span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                               
                                <a href="#" onclick="learnLimit()"  class="clearfix">
                                    <i class="ace-icon fa fa-edit orange"></i>
                                  		修改密码
                                </a>
                            </li>
                            <li>
                                <a href="#" onclick="userLock()">
                                    <i class="ace-icon fa fa-lock orange"></i>
                                 		 锁住屏幕
                                </a>
                            </li>
                            <li>                               
                                <a href="#" onclick="logout()">
                                    <i class="ace-icon fa fa-power-off red"></i>
                                   		 安全退出
                                </a>
                            </li>
                       
                        </ul>
                    </li>
                    <!-- /section:basics/navbar.user_menu -->
                </ul>
            </div>

            <!-- /section:basics/navbar.dropdown -->
        </div>
        <!-- /.navbar-container -->
    </div>
    <!-- /section:basics/navbar.layout -->
    <div class="main-container" id="main-container">
        <!-- #section:basics/sidebar -->
        <div id="sidebar" class="sidebar  responsive compact">
            <script type="text/javascript">
                try { ace.settings.check('sidebar', 'fixed') } catch (e) { }
            </script>
            <div class="sidebar-shortcuts" id="sidebar-shortcuts" style="z-index:10000;">
                <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                    <button class="btn btn-info  sidebar-collapse" id="sidebar-collapse">
                        <i class="ace-icon fa fa-compress" data-icon1="ace-icon fa fa-compress" data-icon2="ace-icon fa fa-expand"></i>
                    </button>
                    <select id="skin-colorpicker" class="hide">
                        <option data-skin="no-skin" value="#438EB9">#438EB9</option>
                        <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                        <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                        <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                    </select>
                </div>
                <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                    <span class="btn btn-success"></span>
                    <span class="btn btn-info"></span>
                    <span class="btn btn-warning"></span>
                    <span class="btn btn-danger"></span>
                </div>
            </div>
            <ul id="menubar" class="nav nav-list" style="z-index:10000;">
            </ul>
            <!-- /.nav-list -->
            <!-- /section:basics/sidebar.layout.minimize -->
            <script type="text/javascript">
                try { ace.settings.check('sidebar', 'collapsed') } catch (e) { }
            </script>
        </div>
        <!-- /section:basics/sidebar -->
        <div class="main-content">
			<Layout:block name="myContent"></Layout:block>
   		 </div>
   		</div>
    <!-- /.main-container --> 
    <div class="dropdown dropdown-preview RMclickmenu" id="myTabMenu" style="display: none; position: absolute; z-index: 99;">
        <ul class="dropdown-menu dropdown-yellow">
            <li onmousedown ="RefThisTab();">
                <a href="#"  tabindex="-1"><i class="ace-icon fa fa-refresh green " style="margin-right:5px;"></i>刷新</a>
            </li>
            <li class="divider"></li>
            <li onmousedown="CloseThisTab();">
                <a href="#" tabindex="-1" ><i class="ace-icon fa fa-close orange" style="margin-right:5px;"></i>关闭当前页</a>
            </li>
            <li onmousedown="CloseAllTab();">
                <a href="#" tabindex="-1" ><i class="ace-icon fa fa-unlink1 red" style="margin-right:5px;"></i>除此之外全部关闭</a>
            </li>
            <li class="divider"></li>
            <li onmousedown="CloseAllTab('true');">
                <a href="#" tabindex="-1" ><i class="ace-icon fa fa-unlink red" style="margin-right:5px;"></i>关闭所有页面</a>
            </li>     
        </ul>
    </div>
    <div id="homeDialog" class="row no-margin hidden">
    </div>
    <div id="connUserInfo" class="hidden">
        <div class="row">
            <div class="col-xs-12">
	            <div class="width-100" style="height:300px;">
	                     <table id="tt_connUserInfo">
	                      </table>
	           </div>
            </div>
        </div>
    </div>
      <!-- basic scripts -->
    <script src="<%=request.getContextPath() %>/resources/assets/js/jquery-ui.custom.js"></script>
    <script src="<%=request.getContextPath() %>/resources/assets/js/jquery.ui.touch-punch.js"></script>
    <script src="<%=request.getContextPath() %>/resources/assets/js/jquery.sparkline.js"></script>
    <script src="<%=request.getContextPath() %>/resources/assets/js/bootstrap-tabdrop.js"></script>
    <script src="<%=request.getContextPath() %>/resources/assets/js/ace/elements.colorpicker.js"></script>
    <script src="<%=request.getContextPath() %>/resources/assets/js/ace/ace.submenu-hover.js"></script>
    <script src="<%=request.getContextPath() %>/resources/assets/js/ace/elements.scroller.js"></script> 
    <script src="<%=request.getContextPath() %>/resources/assets/js/ace/ace.js"></script>
    <script src="<%=request.getContextPath() %>/resources/assets/js/ace/ace.settings-skin.js"></script>
	<script src="<%=request.getContextPath() %>/resources/assets/js/jquery.gritter.js"></script>
  	<script src="<%=request.getContextPath() %>/resources/assets/js/ace/ace.sidebar-scroll-2.js"></script> 
    <script src="<%=request.getContextPath() %>/resources/assets/js/ace/ace.sidebar.js"></script>
	<script src="<%=request.getContextPath() %>/resources/assets/js/jquery.popupoverlay.min.js"></script>
	<Layout:block name="myJs"></Layout:block>
    <script type="text/javascript">
    var menus = $.parseJSON('[{"title":"基础档案","id":"a08a7698-144f-4620-a4da-0f9b72ecd1c9","iconCls":"fa-database","treedata":[{"id":"e4ec1eb5-be6a-4c8c-848c-60d00c786801","parentid":"a08a7698-144f-4620-a4da-0f9b72ecd1c9","text":"所属行业","iconCls":"fa-bolt","checked":false,"state":null,"iGrade":0,"attributes":{"url":"wskc/basic/industryList","helpurl":null,"objid":"123","blast":true}},{"id":"d9781f3e-0310-447d-85eb-b6f32453d93d","parentid":"a08a7698-144f-4620-a4da-0f9b72ecd1c9","text":"拥有品牌","iconCls":"fa-bolt","checked":false,"state":null,"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"dbb85554-4db0-4d0d-8280-c27b04b0ce5a","parentid":"a08a7698-144f-4620-a4da-0f9b72ecd1c9","text":"旗下产品","iconCls":"fa-bolt","checked":false,"state":null,"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}}],"content":null},{"title":"采购管理","id":"ae334212-5e48-483d-9050-68a311f6826d","iconCls":"fa-shopping-cart","treedata":[{"id":"e05dd883-d373-4c99-a208-0f94126b54d4","parentid":"ae334212-5e48-483d-9050-68a311f6826d","text":"采购","iconCls":"fa-file-text","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiGou/CGOrderBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/caigou/cgdingdang.html","objid":"7fcf3308-83c5-4168-a2bb-69fff0f56e8e","blast":true}},{"id":"15ab1705-0932-4c8e-8956-7bbeab9bef21","parentid":"ae334212-5e48-483d-9050-68a311f6826d","text":"采购列表","iconCls":"fa-file-text","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiGou/CGBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/caigou/cgdang.html","objid":"ab648de6-f18b-4d41-9ccd-d732ba39ecdb","blast":true}}],"content":null},{"title":"销售管理","id":"40694b89-10a4-4a63-a552-4faace2de6ec","iconCls":"fa-dollar","treedata":[{"id":"a35ad2aa-151d-4682-ad7f-4bb50002f338","parentid":"40694b89-10a4-4a63-a552-4faace2de6ec","text":"销售","iconCls":"fa-truck","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"Xiaoshou/XSOrderBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xiaoshou/xsdd.html","objid":"667908a2-9862-448c-924a-33c46dd00bca","blast":true}},{"id":"f8db098d-345b-4e20-9c4c-0d2372c7509e","parentid":"40694b89-10a4-4a63-a552-4faace2de6ec","text":"销售列表","iconCls":"fa-file-text","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"Xiaoshou/XSBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xiaoshou/xsd.html","objid":"6d94be91-c5a8-4429-a16a-02ffe18898f6","blast":true}}],"content":null},{"title":"库存管理","id":"74720bdb-52d0-4471-ba92-949451bb87e6","iconCls":"fa-cubes","treedata":[{"id":"1eb1c37d-e871-486e-8b55-67d0c2134c6f","parentid":"74720bdb-52d0-4471-ba92-949451bb87e6","text":"调拨单","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_DBBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/kucun/diaobo.html","objid":"849a713d-2847-4430-a691-e0982a3bfc34","blast":true}},{"id":"d43696dd-50a8-4384-ac9f-caa37cbb2e20","parentid":"74720bdb-52d0-4471-ba92-949451bb87e6","text":"其它入库单","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_InBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/kucun/qtrk.html","objid":"a810697f-f86e-4be9-ae1e-649e1e533d1c","blast":true}},{"id":"9a9c4f45-a38f-475f-9ed3-d652f89b9a00","parentid":"74720bdb-52d0-4471-ba92-949451bb87e6","text":"其它出库单","iconCls":"fa-file-text","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_OutBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/kucun/qtck.html","objid":"ef634fd7-3fcc-4092-96f8-ea306946c3a3","blast":true}},{"id":"c734d40b-3fb5-4e51-b2f2-66318280566c","parentid":"74720bdb-52d0-4471-ba92-949451bb87e6","text":"库存量查询","iconCls":"fa-file-text","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_KCLCX/Index","helpurl":null,"objid":"ca624691-0f6e-46b5-8bb7-0b788754bebf","blast":true}}],"content":null},{"title":"报表查询","id":"dea4dcb3-3dec-495e-81c2-49fa6f7773b2","iconCls":"fa-file-excel-o","treedata":[{"id":"5ab72978-5675-42cd-b8f7-469de47cd7d9","parentid":"dea4dcb3-3dec-495e-81c2-49fa6f7773b2","text":"采购报表","iconCls":"fa-list-alt","checked":false,"state":null,"children":[{"id":"6b1be61e-96ad-48de-8e4a-9537d7301b8d","parentid":"5ab72978-5675-42cd-b8f7-469de47cd7d9","text":"采购订货明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiGou/CG_CGDHMXRpt/Index","helpurl":null,"objid":"a485dca7-c2a1-40e4-b024-850220e197c9","blast":true}},{"id":"b096cf0d-ee3b-41a7-946e-08a07c11a2b2","parentid":"5ab72978-5675-42cd-b8f7-469de47cd7d9","text":"采购订货统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiGou/CG_CGDHTJRpt/Index","helpurl":null,"objid":"904caf7c-e28d-460d-b0ed-2555541f1d7b","blast":true}},{"id":"8f7b0fda-4c42-4a19-864f-1f53e024c9b4","parentid":"5ab72978-5675-42cd-b8f7-469de47cd7d9","text":"采购进货明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiGou/CG_CGMXRpt/Index","helpurl":null,"objid":"9d1386d2-b070-4abb-8b34-72c145ab939b","blast":true}},{"id":"c949c2b5-5bb6-4705-8073-f7b85d0d6987","parentid":"5ab72978-5675-42cd-b8f7-469de47cd7d9","text":"采购统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiGou/CG_CGTJRpt/Index","helpurl":null,"objid":"1f9822c5-1aaa-4f09-940b-730d802879c4","blast":true}},{"id":"7e0da41c-0888-458b-bda4-e6cb5872df30","parentid":"5ab72978-5675-42cd-b8f7-469de47cd7d9","text":"采购价格分析","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiGou/CGJGFXB/Index","helpurl":null,"objid":"39fd8618-ac64-48ec-96e8-fd45dafe4ac8","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","parentid":"dea4dcb3-3dec-495e-81c2-49fa6f7773b2","text":"销售报表","iconCls":"fa-list-alt","checked":false,"state":null,"children":[{"id":"6fc05fd1-4102-4c47-98cd-a66f247064ed","parentid":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","text":"销售订货明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/XS_XSDHMXRpt/Index","helpurl":null,"objid":"c58a1425-159f-477d-8685-4957acc123fa","blast":true}},{"id":"b5d067c7-e6de-4095-a21d-dbde35b9f6be","parentid":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","text":"销售订货统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/XS_XSDHTJRpt/Index","helpurl":null,"objid":"5ce34188-fefc-4588-bd1f-ba8fcd5854d4","blast":true}},{"id":"01c8a25a-9122-4e6c-8511-9d18a4d35137","parentid":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","text":"销售明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/XS_XSMXRpt/Index","helpurl":null,"objid":"c9730662-149b-4eb1-b58a-b881947b3708","blast":true}},{"id":"2e16cb7e-02c8-484f-93bb-f71411ee62f9","parentid":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","text":"销售统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/XS_XSTJRpt/Index","helpurl":null,"objid":"507f5aa2-4bb2-49fb-885b-4a3dc8b60fd8","blast":true}},{"id":"d50e32d6-7ce5-4250-ac61-1e31a37a07aa","parentid":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","text":"销售毛利统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/XS_MLTJRpt/Index","helpurl":null,"objid":"d160a106-289f-427e-bd3c-87310d14b2a8","blast":true}},{"id":"0082927d-af89-46b4-ae40-08b8ca832797","parentid":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","text":"销售提成明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/TC_XSTCMXRpt/Index","helpurl":null,"objid":"eba9cca3-822e-4e44-8292-68db8c75c1f8","blast":true}},{"id":"bad156be-ea34-4742-9c2f-0c71473df01f","parentid":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","text":"销售提成统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/TC_XSTCTJRpt/Index","helpurl":null,"objid":"f76b007a-9221-403c-a48a-c09ee68bf354","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"130a37cc-5d48-4a08-959c-4d829d58f362","parentid":"dea4dcb3-3dec-495e-81c2-49fa6f7773b2","text":"零售报表","iconCls":null,"checked":false,"state":null,"children":[{"id":"d138ef4d-5820-4eb6-a88d-d26049face2c","parentid":"130a37cc-5d48-4a08-959c-4d829d58f362","text":"零售明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/LS_LSMXRpt/Index","helpurl":null,"objid":"679e8c0f-0ca3-47ee-8d74-4c5ab71c7460","blast":true}},{"id":"07429d0b-399b-403a-a68f-83eea1e55988","parentid":"130a37cc-5d48-4a08-959c-4d829d58f362","text":"零售统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/LS_LSTJRpt/Index","helpurl":null,"objid":"240c41a8-82df-4dbd-b4da-dbda03a0bd13","blast":true}},{"id":"64019a8b-e43c-46ee-9b88-51c90b3f2673","parentid":"130a37cc-5d48-4a08-959c-4d829d58f362","text":"收银流水","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/LS_SYLS/Index","helpurl":null,"objid":"9a6f9fba-3a41-4629-8500-991df319d575","blast":true}},{"id":"40776e28-633e-4928-96af-2a22ab1856f6","parentid":"130a37cc-5d48-4a08-959c-4d829d58f362","text":"零售毛利统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/LS_MLTJRpt/Index","helpurl":null,"objid":"bd7c0cfa-c546-4b9c-b4ec-8396cb0b5760","blast":true}},{"id":"482bbe04-c1e9-48d7-858d-083105de96bc","parentid":"130a37cc-5d48-4a08-959c-4d829d58f362","text":"促销销售明细","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/CX_CXMXRpt/Index","helpurl":null,"objid":"fc636b0f-846a-4d8e-ab9f-2958ed28e396","blast":true}},{"id":"40c64db5-c7f2-489c-a76c-321a9befbca3","parentid":"130a37cc-5d48-4a08-959c-4d829d58f362","text":"促销销售统计","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/CX_CXTJRpt/Index","helpurl":null,"objid":"ec72d500-172e-4966-a775-49d0bde96918","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"ad3465da-21c9-4628-aed5-da184a2dd7f5","parentid":"dea4dcb3-3dec-495e-81c2-49fa6f7773b2","text":"库存报表","iconCls":"fa-bolt","checked":false,"state":null,"children":[{"id":"0e750604-8c1a-4297-896d-d1ec8de6ad86","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"库存余额表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_YEBRpt","helpurl":null,"objid":"43c45142-1cde-48f9-9f50-272996961c0e","blast":true}},{"id":"e5566271-f820-4c04-ac5f-5e52e70dc092","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"收发明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_SFMXRpt","helpurl":null,"objid":"19cc390a-0e49-4106-9e30-30812a9a00ab","blast":true}},{"id":"57489e75-828d-466b-8f96-76ab0b3c012f","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"收发存统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_SFCTJRpt","helpurl":null,"objid":"640bdaf3-73bc-4c09-9cb9-23745c2a595c","blast":true}},{"id":"2c64d734-69e1-46e8-8cb3-7b630c923b5c","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"超储短缺分析表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_CCDQFXRpt","helpurl":null,"objid":"101eaa8b-712a-48f7-9c1a-e497522d5d63","blast":true}},{"id":"3e3b0a31-ba57-44a6-98d7-1009d7eff6a6","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"保质期预警分析表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_BZQGQFXRpt","helpurl":null,"objid":"d6adfe23-004c-45eb-a787-16fe08d2ec72","blast":true}},{"id":"0390ff21-4a39-447e-abfc-a24992ba1f8e","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"负库存量存货查询","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_FKCLCHCXRpt/Index","helpurl":null,"objid":"008bc4fc-bb0f-4820-a304-135da41e3617","blast":true}},{"id":"d0d78b01-0eaa-4687-abc7-c309c0d0ac3c","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"出入库明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_InBillMXRpt/Index","helpurl":null,"objid":"1dd55a38-f73b-42ab-afde-317d3a1a5b64","blast":true}},{"id":"6eb3e0c6-3341-47c9-9bcc-7a807a38801a","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"出入库统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_InBillTJRpt/Index","helpurl":null,"objid":"84949323-ef24-41ca-851b-4d08ab57c6f6","blast":true}},{"id":"5d4f46bd-8723-47b6-8c9a-0937cc843189","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"盘点差异统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_PDCYTJ/Index","helpurl":null,"objid":"c6091e28-ac35-48fb-93ae-19e43855cfe5","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}}],"content":null},{"title":"系统管理","id":"15b74a53-e0bf-4a08-8412-24ed35f5da28","iconCls":"fa-cogs","treedata":[{"id":"5e0c4fd6-241e-4fe3-8b5f-8a8eaa9a2bc8","parentid":"15b74a53-e0bf-4a08-8412-24ed35f5da28","text":"用户管理","iconCls":"fa-user","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"SysSet/User/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xtgl/yhgl.html","objid":"35452e72-c72b-42a4-b2a7-ea299031be49","blast":true}},{"id":"5e0c4fd6-241e-4fe3-8b5f-8a1212342bc8","parentid":"15b74a53-e0bf-4a08-8412-24ed35f5da28","text":"用户日志","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"SysBase/UserLogs/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xtgl/yhrz.html","objid":"a3f4a4c7-0092-4192-9257-82c3fcf8c6f7","blast":true}},{"id":"5f448862-f8cd-44fb-8c57-4295addd32e9","parentid":"15b74a53-e0bf-4a08-8412-24ed35f5da28","text":"系统配置","iconCls":"fa-bolt","checked":false,"state":null,"children":[{"id":"6ad4d622-d291-4ec0-9cce-8b0305be80d6","parentid":"5f448862-f8cd-44fb-8c57-4295addd32e9","text":"角色管理","iconCls":"fa-male","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"SysBase/Roles/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xtgl/juese.html","objid":"015278cf-9244-4f8b-8153-5880011e1bcd","blast":true}},{"id":"5e0c4fd6-241e-4fe3-8b5f-8a12349a2bc8","parentid":"5f448862-f8cd-44fb-8c57-4295addd32e9","text":"角色权限管理","iconCls":"fa-key","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"SysBase/RolesAuths/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xtgl/qxgl.html","objid":"8772cb89-573e-4f00-a08b-f1d4ec512fc1","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}}],"content":null}]'); </script>

</body>
</html>
