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
        var menus = $.parseJSON('[{"title":"基础档案","id":"a08a7698-144f-4620-a4da-0f9b72ecd1c9","iconCls":"fa-database","treedata":[{"id":"e4ec1eb5-be6a-4c8c-848c-60d00c786801","parentid":"a08a7698-144f-4620-a4da-0f9b72ecd1c9","text":"机构人员","iconCls":"fa-bolt","checked":false,"state":null,"children":[{"id":"13bc386f-322b-4fce-8613-15482e482d67","parentid":"e4ec1eb5-be6a-4c8c-848c-60d00c786801","text":"组织机构","iconCls":"fa-sitemap","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/bd_Corp/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/gjzzjg.html","objid":"900e4631-091c-427f-b2d1-4776f94f53dc","blast":true}},{"id":"f9ec70ee-4a58-4d62-af4a-f29f456b4eb8","parentid":"e4ec1eb5-be6a-4c8c-848c-60d00c786801","text":"部门设置","iconCls":"fa-th-list","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/bd_Department/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/gjbmss.html","objid":"9043bade-499f-421c-b8d0-582537f5d680","blast":true}},{"id":"a5942937-2f0e-4c81-82d3-118d679c63b4","parentid":"e4ec1eb5-be6a-4c8c-848c-60d00c786801","text":"人员档案","iconCls":"fa-newspaper-o","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/Person/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/gjryda.html","objid":"923a0cde-3982-4574-9953-1538f041d434","blast":true}},{"id":"f2e1328c-3c8f-4a80-a2d4-7c2dbe3b622e","parentid":"e4ec1eb5-be6a-4c8c-848c-60d00c786801","text":"人员类别","iconCls":"fa-sitemap","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/PersonClass/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/gjryclass.html","objid":"13aa57a0-3f9d-4ed8-b1af-5c5df737b1e7","blast":true}},{"id":"3da49e04-79c6-4953-906b-6a72557c8996","parentid":"e4ec1eb5-be6a-4c8c-848c-60d00c786801","text":"职称","iconCls":"fa-mortar-board (alias)","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/PersonTitle/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/gjjob.html","objid":"3291b810-dd34-4138-918b-be71e37d6067","blast":true}},{"id":"86522fd1-652c-40c3-b7e3-49e864dc220e","parentid":"e4ec1eb5-be6a-4c8c-848c-60d00c786801","text":"人员属性","iconCls":"fa-sitemap","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/PersonType/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/gjpattr.html","objid":"9963e30b-7e88-44f8-80d2-faf1d1e905f8","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"3d50ab5a-d041-49a3-9bd1-c082ece7591a","parentid":"a08a7698-144f-4620-a4da-0f9b72ecd1c9","text":"仓库存货","iconCls":"fa-bolt","checked":false,"state":null,"children":[{"id":"938e706d-c72e-4cc4-a5c7-93babfaea433","parentid":"3d50ab5a-d041-49a3-9bd1-c082ece7591a","text":"仓库设置","iconCls":"fa-home","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/KC_WareHouse/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/ckseet.html","objid":"672c67c0-e8d1-4b58-9ece-f4fc48f63f46","blast":true}},{"id":"e75cf70d-e257-4c85-8180-9a46f4e0dff2","parentid":"3d50ab5a-d041-49a3-9bd1-c082ece7591a","text":"存货档案","iconCls":"fa-folder-open","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/KC_Inv/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/ckdanan.html","objid":"f192a37f-6aba-42a5-88c5-f8145a9a4645","blast":true}},{"id":"7507203a-540d-49f2-9fcc-750bcf37ce35","parentid":"3d50ab5a-d041-49a3-9bd1-c082ece7591a","text":"存货套餐","iconCls":"fa-folder-open","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/KC_Inv_TC/Index","helpurl":null,"objid":"2f01128e-01a0-47c9-914e-b5d508873ce8","blast":true}},{"id":"b4bee419-f4d9-49e1-beea-f7030dc9bf68","parentid":"3d50ab5a-d041-49a3-9bd1-c082ece7591a","text":"存货分类","iconCls":"fa-sitemap","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/KC_InvClass/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/ckchclass.html","objid":"d4cf6c50-36ae-4061-bc29-e375b53aa6aa","blast":true}},{"id":"dbf6c440-3dd7-429e-8f1f-fed18376a515","parentid":"3d50ab5a-d041-49a3-9bd1-c082ece7591a","text":"单位换算","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/KC_UnitConvert/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/ckdwhs.html","objid":"3068da44-5ccb-40ed-a560-1ae92331dbee","blast":true}},{"id":"6b241b4a-7f47-4cb0-9ff8-acd523e06a7b","parentid":"3d50ab5a-d041-49a3-9bd1-c082ece7591a","text":"辅助属性","iconCls":"fa-sitemap","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/KC_InvProperty/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/ckfzsx.html","objid":"04a87635-ff1a-4910-a80a-b684e5e70bc4","blast":true}},{"id":"d4adde63-f1da-499c-af7e-ac40f981d9b0","parentid":"3d50ab5a-d041-49a3-9bd1-c082ece7591a","text":"存货批号表","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/KC_PiCi/Index","helpurl":null,"objid":"6de2c065-68b9-48a8-a22b-6cc2cb67dfbf","blast":true}},{"id":"29784388-fce1-47aa-a103-cc396298aa91","parentid":"3d50ab5a-d041-49a3-9bd1-c082ece7591a","text":"存货明细表","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/KC_InvMX/Index","helpurl":null,"objid":"5321cf33-9af0-433b-994f-2bf53c89314a","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"d9781f3e-0310-447d-85eb-b6f32453d93d","parentid":"a08a7698-144f-4620-a4da-0f9b72ecd1c9","text":"往来单位","iconCls":"fa-bolt","checked":false,"state":null,"children":[{"id":"57e9fad5-a090-4ea9-a00b-d6ef614a3e50","parentid":"d9781f3e-0310-447d-85eb-b6f32453d93d","text":"往来单位","iconCls":"fa-retweet","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/JX_InOutUnit/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/wldawei.html","objid":"3d71fe8f-09d5-41cd-aed1-718fe6287266","blast":true}},{"id":"255846e4-c4e0-4a08-bd09-0e81ed413f06","parentid":"d9781f3e-0310-447d-85eb-b6f32453d93d","text":"单位分类","iconCls":"fa-sitemap","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/JX_InOutUnitClass/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/wldwclass.html","objid":"8f269d6d-f14b-4bec-93f6-1f6a6567e2e1","blast":true}},{"id":"0dea704f-40d1-4b9f-a66f-878b07c8fa1f","parentid":"d9781f3e-0310-447d-85eb-b6f32453d93d","text":"地区设置","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/JX_UnitArea/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/wldq.html","objid":"970fcb3a-0e1c-47d3-a8ca-f4e9bfb988d8","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"dbb85554-4db0-4d0d-8280-c27b04b0ce5a","parentid":"a08a7698-144f-4620-a4da-0f9b72ecd1c9","text":"云打印配置","iconCls":"fa-bolt","checked":false,"state":null,"children":[{"id":"ca6991fa-fd30-4407-b048-930b641a8d45","parentid":"dbb85554-4db0-4d0d-8280-c27b04b0ce5a","text":"云打印客户端","iconCls":"fa-print","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"Print/PrintClient/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/yunprint.html","objid":"2f0ee39a-d4f8-432c-995b-8cbced2e589b","blast":true}},{"id":"d77b1e75-8bf1-4ef3-84e3-6a5848ea9163","parentid":"dbb85554-4db0-4d0d-8280-c27b04b0ce5a","text":"云打印模板","iconCls":"fa-print","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"Print/PrintMode/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/yunprintmod.html","objid":"b219051d-407b-4e94-a1b4-00507b6fd8e8","blast":true}},{"id":"100701cc-70f2-44c3-801d-0d08b9c10a36","parentid":"dbb85554-4db0-4d0d-8280-c27b04b0ce5a","text":"云打印日志","iconCls":"fa-print","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"Print/PrintLogsRpt/Index","helpurl":null,"objid":"0c780997-a327-4bea-8315-fc1952108fa7","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"984e310b-c037-416e-935e-571ae682baa7","parentid":"a08a7698-144f-4620-a4da-0f9b72ecd1c9","text":"其它设置","iconCls":"fa-bolt","checked":false,"state":null,"children":[{"id":"08877042-8f8b-470f-9e17-9347c69bff4b","parentid":"984e310b-c037-416e-935e-571ae682baa7","text":"结算账户","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiWu/XJYH/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/caiwu/xjyh.html","objid":"c6fba578-6f3d-4ebc-bb29-f52ee5622c0d","blast":true}},{"id":"ad79fc11-3196-430d-8695-a81c4b5bd86b","parentid":"984e310b-c037-416e-935e-571ae682baa7","text":"结算方式","iconCls":"fa-sitemap","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiWu/CW_JSType/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/qtjs.html","objid":"209c94ae-d184-4006-b7b6-d3bae64c314b","blast":true}},{"id":"1a6edf7a-143b-4ac8-b2bf-190c1a76dd89","parentid":"984e310b-c037-416e-935e-571ae682baa7","text":"发运方式","iconCls":"fa-truck","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/JX_FYFS/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/qtfh.html","objid":"9e022c7a-7525-458b-97da-539ff73f6b1f","blast":true}},{"id":"175d3f28-f6d0-4a7d-8cf5-442ceb3bca67","parentid":"984e310b-c037-416e-935e-571ae682baa7","text":"价格级别","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/KC_MorePrice/Index","helpurl":null,"objid":"ebb081a6-f6c7-4dd1-a2d3-183064196e83","blast":true}},{"id":"3c3139d6-df48-4d21-9ec6-4905052bc4ca","parentid":"984e310b-c037-416e-935e-571ae682baa7","text":"电子条码秤设置","iconCls":"fa-ellipsis-h","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/KC_InvBarWeight/Index","helpurl":null,"objid":"5ab5129f-a403-43e6-ab75-b26120cc9e34","blast":true}},{"id":"71ae7187-c2d4-44bb-a47e-2fd3c50913cf","parentid":"984e310b-c037-416e-935e-571ae682baa7","text":"标记设置","iconCls":"fa-flag","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/bd_Flag/Index","helpurl":null,"objid":"dfb527d4-5901-4ca6-a674-44d55e3b7960","blast":true}},{"id":"8b4de549-f23b-489e-adf6-487881bb9b74","parentid":"984e310b-c037-416e-935e-571ae682baa7","text":"常用词汇","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/Summary/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/jcda/qtch.html","objid":"4ba63558-d3af-4e7b-8f0f-c0b525d1205d","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}}],"content":null},{"title":"电商管理","id":"fcc35cef-e3fc-4796-8824-f7e24b9d2eac","iconCls":"fa-desktop","treedata":[{"id":"33af2750-2c2c-4dde-a3d1-8b65617ffbd4","parentid":"fcc35cef-e3fc-4796-8824-f7e24b9d2eac","text":"网店管理","iconCls":"fa-home","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"EShop/MyShop/Index","helpurl":null,"objid":"7bcf3ff9-8814-49b7-87c9-ae5087e1836a","blast":true}},{"id":"bafa4cb4-c4df-427f-9ce3-585a5782f34f","parentid":"fcc35cef-e3fc-4796-8824-f7e24b9d2eac","text":"商品对应管理","iconCls":"fa-link","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"EShop/ES_Inv/Index","helpurl":null,"objid":"d499b3f5-b9fa-4bd3-9340-740a63b7d1ba","blast":true}},{"id":"edfca3e1-f2c6-421c-81ae-c02b3651f06b","parentid":"fcc35cef-e3fc-4796-8824-f7e24b9d2eac","text":"快递管理","iconCls":"fa-truck","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"EShop/ES_Express/Index","helpurl":null,"objid":"53e1f7b9-d89b-47c5-9ff0-8442888294ab","blast":true}},{"id":"8028a8ad-76fb-45b1-8866-b0a3494fde5e","parentid":"fcc35cef-e3fc-4796-8824-f7e24b9d2eac","text":"订单管理","iconCls":"fa-file-text","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"EShop/ES_OrderBill/Index","helpurl":null,"objid":"776d2f08-3635-4b00-a9c8-26f1c796ead2","blast":true}}],"content":null},{"title":"采购管理","id":"ae334212-5e48-483d-9050-68a311f6826d","iconCls":"fa-shopping-cart","treedata":[{"id":"5bc20564-4e03-471b-b7f1-1ee05dd3bc8c","parentid":"ae334212-5e48-483d-9050-68a311f6826d","text":"设置","iconCls":"fa-bolt","checked":false,"state":null,"children":[{"id":"89ed6bfc-1d81-4247-a75a-f20445c14613","parentid":"5bc20564-4e03-471b-b7f1-1ee05dd3bc8c","text":"采购类型","iconCls":"fa-sitemap","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/JX_CGType/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/caigou/cgclass.html","objid":"f219432e-ac10-40a5-9af6-fcc8f10dc552","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"e05dd883-d373-4c99-a208-0f94126b54d4","parentid":"ae334212-5e48-483d-9050-68a311f6826d","text":"采购订单","iconCls":"fa-file-text","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiGou/CGOrderBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/caigou/cgdingdang.html","objid":"7fcf3308-83c5-4168-a2bb-69fff0f56e8e","blast":true}},{"id":"15ab1705-0932-4c8e-8956-7bbeab9bef21","parentid":"ae334212-5e48-483d-9050-68a311f6826d","text":"进货单","iconCls":"fa-file-text","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiGou/CGBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/caigou/cgdang.html","objid":"ab648de6-f18b-4d41-9ccd-d732ba39ecdb","blast":true}}],"content":null},{"title":"销售管理","id":"40694b89-10a4-4a63-a552-4faace2de6ec","iconCls":"fa-dollar","treedata":[{"id":"ae68efa8-920f-4376-9723-e69cdbd11fa1","parentid":"40694b89-10a4-4a63-a552-4faace2de6ec","text":"设置","iconCls":"fa-bolt","checked":false,"state":null,"children":[{"id":"bd8c4235-b6e8-464c-a6fd-22299c049f0b","parentid":"ae68efa8-920f-4376-9723-e69cdbd11fa1","text":"销售类型","iconCls":"fa-sitemap","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/JX_XSType/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xiaoshou/xsclass.html","objid":"a52c4c1b-e087-4cef-b281-8b5ad7956ad6","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"a35ad2aa-151d-4682-ad7f-4bb50002f338","parentid":"40694b89-10a4-4a63-a552-4faace2de6ec","text":"销售订单","iconCls":"fa-truck","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"Xiaoshou/XSOrderBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xiaoshou/xsdd.html","objid":"667908a2-9862-448c-924a-33c46dd00bca","blast":true}},{"id":"f8db098d-345b-4e20-9c4c-0d2372c7509e","parentid":"40694b89-10a4-4a63-a552-4faace2de6ec","text":"销售单","iconCls":"fa-file-text","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"Xiaoshou/XSBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xiaoshou/xsd.html","objid":"6d94be91-c5a8-4429-a16a-02ffe18898f6","blast":true}}],"content":null},{"title":"零售管理","id":"c5614674-a527-4f13-9225-3024ac50bfcc","iconCls":"fa-shopping-basket","treedata":[{"id":"b894651f-c56f-477e-8aef-cb35305889d1","parentid":"c5614674-a527-4f13-9225-3024ac50bfcc","text":"设置","iconCls":null,"checked":false,"state":null,"children":[{"id":"102eb618-6e2c-48eb-8d32-2465c6c94c23","parentid":"b894651f-c56f-477e-8aef-cb35305889d1","text":"支付方式设置","iconCls":"fa-user-times","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/KC_Store_JSType/Index","helpurl":null,"objid":"ce98eb91-af0f-468e-968a-38fbf1e63b86","blast":true}},{"id":"91a30360-4ce7-4663-ac59-1bdb449e562d","parentid":"b894651f-c56f-477e-8aef-cb35305889d1","text":"门店设置","iconCls":"fa-home","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/KC_Store/Index","helpurl":null,"objid":"c1ac6214-ca25-4a00-bf81-80bd00e10672","blast":true}},{"id":"68f3f2b2-b10f-42c0-af1a-a0c4687e33b2","parentid":"b894651f-c56f-477e-8aef-cb35305889d1","text":"客户端收银员","iconCls":"fa-user-times","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/JX_PosOper/Index","helpurl":null,"objid":"2c97a1ec-c686-45d1-bd20-a1853f34309c","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"c5000b7c-2582-464b-8b6b-ed5544c7a50d","parentid":"c5614674-a527-4f13-9225-3024ac50bfcc","text":"零售单","iconCls":"fa-desktop","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/Cashier/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xiaoshou/ls.html","objid":"425259fe-5518-4e6e-94e8-390d8eee7118","blast":true}},{"id":"869b3549-f346-4eae-ab11-97599e98d890","parentid":"c5614674-a527-4f13-9225-3024ac50bfcc","text":"促销计划","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/V_CXBill/Index","helpurl":null,"objid":"a5048aa0-f644-4880-8a9b-64925e7beccf","blast":true}}],"content":null},{"title":"库存管理","id":"74720bdb-52d0-4471-ba92-949451bb87e6","iconCls":"fa-cubes","treedata":[{"id":"9e39ae80-9e6c-4b9f-8146-de1920a3a745","parentid":"74720bdb-52d0-4471-ba92-949451bb87e6","text":"设置","iconCls":"fa-bolt","checked":false,"state":null,"children":[{"id":"602224c3-cf9f-4220-b1fd-d02dd10051b0","parentid":"9e39ae80-9e6c-4b9f-8146-de1920a3a745","text":"出入库类别","iconCls":"fa-sitemap","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"BaseSet/KC_InOutType/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/kucun/kcclass.html","objid":"326f94b2-a0c1-4376-b567-312efb7e49e8","blast":true}},{"id":"d5ec8d5d-5d41-4030-83c5-2d845149bd13","parentid":"9e39ae80-9e6c-4b9f-8146-de1920a3a745","text":"期初库存","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_QCBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/kucun/qckc.html","objid":"386189ad-05b1-435d-8a1c-a830b98ca23b","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"1eb1c37d-e871-486e-8b55-67d0c2134c6f","parentid":"74720bdb-52d0-4471-ba92-949451bb87e6","text":"调拨单","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_DBBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/kucun/diaobo.html","objid":"849a713d-2847-4430-a691-e0982a3bfc34","blast":true}},{"id":"dac69765-2a2d-480f-85c5-8e52b1ca4188","parentid":"74720bdb-52d0-4471-ba92-949451bb87e6","text":"拆装单","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_CZBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/kucun/caizhuang.html","objid":"bd286bc4-6fb0-40d7-8e4b-af8aabec4b9a","blast":true}},{"id":"432255a6-c64f-4d16-b9ab-33c42c06703a","parentid":"74720bdb-52d0-4471-ba92-949451bb87e6","text":"盘点单","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_PDBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/kucun/pandian.html","objid":"70674c80-cbea-479a-a615-b46c4226d6f2","blast":true}},{"id":"d43696dd-50a8-4384-ac9f-caa37cbb2e20","parentid":"74720bdb-52d0-4471-ba92-949451bb87e6","text":"其它入库单","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_InBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/kucun/qtrk.html","objid":"a810697f-f86e-4be9-ae1e-649e1e533d1c","blast":true}},{"id":"9a9c4f45-a38f-475f-9ed3-d652f89b9a00","parentid":"74720bdb-52d0-4471-ba92-949451bb87e6","text":"其它出库单","iconCls":"fa-file-text","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_OutBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/kucun/qtck.html","objid":"ef634fd7-3fcc-4092-96f8-ea306946c3a3","blast":true}},{"id":"cd908442-59c4-468c-bc97-fdfbe1e77e1f","parentid":"74720bdb-52d0-4471-ba92-949451bb87e6","text":"成本调整单","iconCls":"fa-file-text","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_CBTZBill/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/kucun/cbtz.html","objid":"38414949-c62b-4791-ae8c-122b337d63c5","blast":true}},{"id":"c734d40b-3fb5-4e51-b2f2-66318280566c","parentid":"74720bdb-52d0-4471-ba92-949451bb87e6","text":"库存量查询","iconCls":"fa-file-text","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_KCLCX/Index","helpurl":null,"objid":"ca624691-0f6e-46b5-8bb7-0b788754bebf","blast":true}}],"content":null},{"title":"会员管理","id":"666e4046-4edc-4b8a-b899-a3af79ce960c","iconCls":"fa-trophy","treedata":[{"id":"d020d378-af04-447c-b6b7-0e9cb58383de","parentid":"666e4046-4edc-4b8a-b899-a3af79ce960c","text":"设置","iconCls":null,"checked":false,"state":null,"children":[{"id":"6fbe0bfa-dfba-49ad-8f10-a782d2f74fae","parentid":"d020d378-af04-447c-b6b7-0e9cb58383de","text":"会员类别","iconCls":"fa-sitemap","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"HuiYuan/V_MemberType/Index","helpurl":null,"objid":"69673fc0-e664-4e8d-9509-8ec3c201f592","blast":true}},{"id":"42057e4d-1808-4904-af25-2676488a0e24","parentid":"d020d378-af04-447c-b6b7-0e9cb58383de","text":"积分规则","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"HuiYuan/V_JFRole/Index","helpurl":null,"objid":"a79ecb70-f88d-456e-8f80-6b647a9b8c4b","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"e405ce79-89b3-4403-a305-95de4303501a","parentid":"666e4046-4edc-4b8a-b899-a3af79ce960c","text":"会员档案","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"HuiYuan/V_Member/Index","helpurl":null,"objid":"c3fb7e1f-cf3f-487e-9528-ad8fae76a669","blast":true}},{"id":"d8f08748-a4b5-415e-9cf5-fffb5618b490","parentid":"666e4046-4edc-4b8a-b899-a3af79ce960c","text":"礼品管理","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"HuiYuan/V_Gift/Index","helpurl":null,"objid":"7cadee54-d98d-4127-801d-d9601d068e52","blast":true}},{"id":"64a7f6d7-5bcb-4688-a27d-0f3dd600d5c5","parentid":"666e4046-4edc-4b8a-b899-a3af79ce960c","text":"积分兑换","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"HuiYuan/V_JFDHBill/Index","helpurl":null,"objid":"212d4b73-7f54-4fa9-9390-85d14f214a42","blast":true}},{"id":"a2684016-6a44-48a7-a8bb-28ecd4c21c5e","parentid":"666e4046-4edc-4b8a-b899-a3af79ce960c","text":"会员充值","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"HuiYuan/V_VMCZBill/Index","helpurl":null,"objid":"9cb62a68-6300-40cf-9d3a-cdcbc616a208","blast":true}},{"id":"2f4b2868-f026-4d2a-8c81-cb90f0a296f7","parentid":"666e4046-4edc-4b8a-b899-a3af79ce960c","text":"日常查询","iconCls":null,"checked":false,"state":null,"children":[{"id":"87a720e9-71a2-4b3a-9e83-d9f4bdbe343f","parentid":"2f4b2868-f026-4d2a-8c81-cb90f0a296f7","text":"会员积分使用明细","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"HuiYuan/V_HYJFMXRpt/Index","helpurl":null,"objid":"f4f5b57a-bd0a-481f-aa28-2eb5e3cae23f","blast":true}},{"id":"31a14984-59cc-45c8-b2bd-a13d373d62b6","parentid":"2f4b2868-f026-4d2a-8c81-cb90f0a296f7","text":"会员储值明细","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"HuiYuan/V_HYCZMXRpt/Index","helpurl":null,"objid":"513540e6-b557-462e-82e7-8ec80d83eb88","blast":true}},{"id":"c89e3197-ef3a-434c-9b81-5b41f7b7190f","parentid":"2f4b2868-f026-4d2a-8c81-cb90f0a296f7","text":"会员消费明细","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"HuiYuan/HY_XFMXRpt/Index","helpurl":null,"objid":"b3415e93-c572-4d6b-919f-08275b09d645","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}}],"content":null},{"title":"报表查询","id":"dea4dcb3-3dec-495e-81c2-49fa6f7773b2","iconCls":"fa-file-excel-o","treedata":[{"id":"5ab72978-5675-42cd-b8f7-469de47cd7d9","parentid":"dea4dcb3-3dec-495e-81c2-49fa6f7773b2","text":"采购报表","iconCls":"fa-list-alt","checked":false,"state":null,"children":[{"id":"6b1be61e-96ad-48de-8e4a-9537d7301b8d","parentid":"5ab72978-5675-42cd-b8f7-469de47cd7d9","text":"采购订货明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiGou/CG_CGDHMXRpt/Index","helpurl":null,"objid":"a485dca7-c2a1-40e4-b024-850220e197c9","blast":true}},{"id":"b096cf0d-ee3b-41a7-946e-08a07c11a2b2","parentid":"5ab72978-5675-42cd-b8f7-469de47cd7d9","text":"采购订货统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiGou/CG_CGDHTJRpt/Index","helpurl":null,"objid":"904caf7c-e28d-460d-b0ed-2555541f1d7b","blast":true}},{"id":"8f7b0fda-4c42-4a19-864f-1f53e024c9b4","parentid":"5ab72978-5675-42cd-b8f7-469de47cd7d9","text":"采购进货明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiGou/CG_CGMXRpt/Index","helpurl":null,"objid":"9d1386d2-b070-4abb-8b34-72c145ab939b","blast":true}},{"id":"c949c2b5-5bb6-4705-8073-f7b85d0d6987","parentid":"5ab72978-5675-42cd-b8f7-469de47cd7d9","text":"采购统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiGou/CG_CGTJRpt/Index","helpurl":null,"objid":"1f9822c5-1aaa-4f09-940b-730d802879c4","blast":true}},{"id":"7e0da41c-0888-458b-bda4-e6cb5872df30","parentid":"5ab72978-5675-42cd-b8f7-469de47cd7d9","text":"采购价格分析","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"CaiGou/CGJGFXB/Index","helpurl":null,"objid":"39fd8618-ac64-48ec-96e8-fd45dafe4ac8","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","parentid":"dea4dcb3-3dec-495e-81c2-49fa6f7773b2","text":"销售报表","iconCls":"fa-list-alt","checked":false,"state":null,"children":[{"id":"6fc05fd1-4102-4c47-98cd-a66f247064ed","parentid":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","text":"销售订货明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/XS_XSDHMXRpt/Index","helpurl":null,"objid":"c58a1425-159f-477d-8685-4957acc123fa","blast":true}},{"id":"b5d067c7-e6de-4095-a21d-dbde35b9f6be","parentid":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","text":"销售订货统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/XS_XSDHTJRpt/Index","helpurl":null,"objid":"5ce34188-fefc-4588-bd1f-ba8fcd5854d4","blast":true}},{"id":"01c8a25a-9122-4e6c-8511-9d18a4d35137","parentid":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","text":"销售明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/XS_XSMXRpt/Index","helpurl":null,"objid":"c9730662-149b-4eb1-b58a-b881947b3708","blast":true}},{"id":"2e16cb7e-02c8-484f-93bb-f71411ee62f9","parentid":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","text":"销售统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/XS_XSTJRpt/Index","helpurl":null,"objid":"507f5aa2-4bb2-49fb-885b-4a3dc8b60fd8","blast":true}},{"id":"d50e32d6-7ce5-4250-ac61-1e31a37a07aa","parentid":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","text":"销售毛利统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/XS_MLTJRpt/Index","helpurl":null,"objid":"d160a106-289f-427e-bd3c-87310d14b2a8","blast":true}},{"id":"0082927d-af89-46b4-ae40-08b8ca832797","parentid":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","text":"销售提成明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/TC_XSTCMXRpt/Index","helpurl":null,"objid":"eba9cca3-822e-4e44-8292-68db8c75c1f8","blast":true}},{"id":"bad156be-ea34-4742-9c2f-0c71473df01f","parentid":"9f0b5d0c-89c8-4554-896c-8e5a11bd39c8","text":"销售提成统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/TC_XSTCTJRpt/Index","helpurl":null,"objid":"f76b007a-9221-403c-a48a-c09ee68bf354","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"130a37cc-5d48-4a08-959c-4d829d58f362","parentid":"dea4dcb3-3dec-495e-81c2-49fa6f7773b2","text":"零售报表","iconCls":null,"checked":false,"state":null,"children":[{"id":"d138ef4d-5820-4eb6-a88d-d26049face2c","parentid":"130a37cc-5d48-4a08-959c-4d829d58f362","text":"零售明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/LS_LSMXRpt/Index","helpurl":null,"objid":"679e8c0f-0ca3-47ee-8d74-4c5ab71c7460","blast":true}},{"id":"07429d0b-399b-403a-a68f-83eea1e55988","parentid":"130a37cc-5d48-4a08-959c-4d829d58f362","text":"零售统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/LS_LSTJRpt/Index","helpurl":null,"objid":"240c41a8-82df-4dbd-b4da-dbda03a0bd13","blast":true}},{"id":"64019a8b-e43c-46ee-9b88-51c90b3f2673","parentid":"130a37cc-5d48-4a08-959c-4d829d58f362","text":"收银流水","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/LS_SYLS/Index","helpurl":null,"objid":"9a6f9fba-3a41-4629-8500-991df319d575","blast":true}},{"id":"40776e28-633e-4928-96af-2a22ab1856f6","parentid":"130a37cc-5d48-4a08-959c-4d829d58f362","text":"零售毛利统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/LS_MLTJRpt/Index","helpurl":null,"objid":"bd7c0cfa-c546-4b9c-b4ec-8396cb0b5760","blast":true}},{"id":"9c0504e5-d10a-45ff-92da-a7600d0b48a5","parentid":"130a37cc-5d48-4a08-959c-4d829d58f362","text":"营业员提成明细","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/TC_TCMXRpt/Index","helpurl":null,"objid":"9720fef6-70ae-48c3-a85b-0171e6465937","blast":true}},{"id":"a29fe6cf-5078-4a8e-9d08-4e2274c7aaf7","parentid":"130a37cc-5d48-4a08-959c-4d829d58f362","text":"营业员提成统计","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/TC_TCTJRpt/Index","helpurl":null,"objid":"8a4a691c-75b8-4adf-8f63-cb49393b95cb","blast":true}},{"id":"482bbe04-c1e9-48d7-858d-083105de96bc","parentid":"130a37cc-5d48-4a08-959c-4d829d58f362","text":"促销销售明细","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/CX_CXMXRpt/Index","helpurl":null,"objid":"fc636b0f-846a-4d8e-ab9f-2958ed28e396","blast":true}},{"id":"40c64db5-c7f2-489c-a76c-321a9befbca3","parentid":"130a37cc-5d48-4a08-959c-4d829d58f362","text":"促销销售统计","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"XiaoShou/CX_CXTJRpt/Index","helpurl":null,"objid":"ec72d500-172e-4966-a775-49d0bde96918","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}},{"id":"ad3465da-21c9-4628-aed5-da184a2dd7f5","parentid":"dea4dcb3-3dec-495e-81c2-49fa6f7773b2","text":"库存报表","iconCls":"fa-bolt","checked":false,"state":null,"children":[{"id":"0e750604-8c1a-4297-896d-d1ec8de6ad86","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"库存余额表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_YEBRpt","helpurl":null,"objid":"43c45142-1cde-48f9-9f50-272996961c0e","blast":true}},{"id":"e5566271-f820-4c04-ac5f-5e52e70dc092","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"收发明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_SFMXRpt","helpurl":null,"objid":"19cc390a-0e49-4106-9e30-30812a9a00ab","blast":true}},{"id":"57489e75-828d-466b-8f96-76ab0b3c012f","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"收发存统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_SFCTJRpt","helpurl":null,"objid":"640bdaf3-73bc-4c09-9cb9-23745c2a595c","blast":true}},{"id":"2c64d734-69e1-46e8-8cb3-7b630c923b5c","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"超储短缺分析表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_CCDQFXRpt","helpurl":null,"objid":"101eaa8b-712a-48f7-9c1a-e497522d5d63","blast":true}},{"id":"3e3b0a31-ba57-44a6-98d7-1009d7eff6a6","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"保质期预警分析表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_BZQGQFXRpt","helpurl":null,"objid":"d6adfe23-004c-45eb-a787-16fe08d2ec72","blast":true}},{"id":"0390ff21-4a39-447e-abfc-a24992ba1f8e","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"负库存量存货查询","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_FKCLCHCXRpt/Index","helpurl":null,"objid":"008bc4fc-bb0f-4820-a304-135da41e3617","blast":true}},{"id":"d0d78b01-0eaa-4687-abc7-c309c0d0ac3c","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"出入库明细表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_InBillMXRpt/Index","helpurl":null,"objid":"1dd55a38-f73b-42ab-afde-317d3a1a5b64","blast":true}},{"id":"6eb3e0c6-3341-47c9-9bcc-7a807a38801a","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"出入库统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_InBillTJRpt/Index","helpurl":null,"objid":"84949323-ef24-41ca-851b-4d08ab57c6f6","blast":true}},{"id":"5d4f46bd-8723-47b6-8c9a-0937cc843189","parentid":"ad3465da-21c9-4628-aed5-da184a2dd7f5","text":"盘点差异统计表","iconCls":"fa-list-alt","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"KuCun/KC_PDCYTJ/Index","helpurl":null,"objid":"c6091e28-ac35-48fb-93ae-19e43855cfe5","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}}],"content":null},{"title":"系统管理","id":"15b74a53-e0bf-4a08-8412-24ed35f5da28","iconCls":"fa-cogs","treedata":[{"id":"aaf3b208-d8cd-4e3e-96e3-488be7cbc45f","parentid":"15b74a53-e0bf-4a08-8412-24ed35f5da28","text":"系统参数","iconCls":"fa-cog","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"SysBase/ParamItem/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xtgl/cssz.html","objid":"57444fb4-faf4-4f26-97b9-bc906dd70c84","blast":true}},{"id":"5e0c4fd6-241e-4fe3-8b5f-8a8eaa9a2bc8","parentid":"15b74a53-e0bf-4a08-8412-24ed35f5da28","text":"用户管理","iconCls":"fa-user","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"SysSet/User/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xtgl/yhgl.html","objid":"35452e72-c72b-42a4-b2a7-ea299031be49","blast":true}},{"id":"5e0c4fd6-241e-4fe3-8b5f-8a1212342bc8","parentid":"15b74a53-e0bf-4a08-8412-24ed35f5da28","text":"用户日志","iconCls":"fa-leaf","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"SysBase/UserLogs/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xtgl/yhrz.html","objid":"a3f4a4c7-0092-4192-9257-82c3fcf8c6f7","blast":true}},{"id":"5f448862-f8cd-44fb-8c57-4295addd32e9","parentid":"15b74a53-e0bf-4a08-8412-24ed35f5da28","text":"系统配置","iconCls":"fa-bolt","checked":false,"state":null,"children":[{"id":"41e5d065-58b0-4828-bb97-531e212345eb","parentid":"5f448862-f8cd-44fb-8c57-4295addd32e9","text":"编码规则","iconCls":"fa-barcode","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"SysBase/CodingRule/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xtgl/bmgz.html","objid":"3ed6f4e8-b9a6-4f50-bdbb-456afb753119","blast":true}},{"id":"6ad4d622-d291-4ec0-9cce-8b0305be80d6","parentid":"5f448862-f8cd-44fb-8c57-4295addd32e9","text":"角色管理","iconCls":"fa-male","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"SysBase/Roles/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xtgl/juese.html","objid":"015278cf-9244-4f8b-8153-5880011e1bcd","blast":true}},{"id":"5e0c4fd6-241e-4fe3-8b5f-8a12349a2bc8","parentid":"5f448862-f8cd-44fb-8c57-4295addd32e9","text":"角色权限管理","iconCls":"fa-key","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"SysBase/RolesAuths/Index","helpurl":"http://www.mxyun.com/help/jxc?geturl=jxc/xtgl/qxgl.html","objid":"8772cb89-573e-4f00-a08b-f1d4ec512fc1","blast":true}},{"id":"679952d5-dbad-48c6-87e2-75f520f76539","parentid":"5f448862-f8cd-44fb-8c57-4295addd32e9","text":"数据权限管理","iconCls":"fa-key","checked":false,"state":null,"children":null,"iGrade":0,"attributes":{"url":"SysSet/DA_DataAuth/Index","helpurl":null,"objid":"c571af7c-3b01-499c-89c9-8a9d2d1e744f","blast":true}}],"iGrade":0,"attributes":{"url":null,"helpurl":null,"objid":"","blast":false}}],"content":null}]');
    </script>

</body>
</html>
