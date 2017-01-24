<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="Mytag" prefix="Layout"%>
<Layout:block name="import_res"></Layout:block>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<!-- BEGIN HEAD -->
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no">
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
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/config.css" />
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
    <Layout:block name="myCss_res"></Layout:block>
</head>
<body>
	<Layout:block name="myContent_res"></Layout:block>
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
	<Layout:block name="myJs_res"></Layout:block>
</body>
</html>