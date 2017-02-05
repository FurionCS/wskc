<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
入库列表
</Layout:overwrite>
<Layout:overwrite name="Mycss">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/dropload/dropload.css">
</Layout:overwrite> 
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>入库列表</h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<ul class="page-breadcrumb breadcrumb">
		<li>
			<a href="javascript:void(0)">库存管理</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">入库单</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">入库单列表</a>
		</li>
</ul>
<div class="form-group" >
			<div class="col-md-8 col-xs-12" style="margin-bottom: 10px;padding:0;">
				<div class="input-icon right">
					<i class="fa fa-search" onclick="searchByStr()"></i>
					<input type="text" class="form-control input-circle" id="search" placeholder="搜索编号,产品名称,品牌名称">
				</div>
			</div>
</div>
<div class="allocationList">
	<div id="ListBody" >
	</div>
</div>
<jsp:include page="../template/allocationTemplate.jsp"></jsp:include>
</Layout:overwrite>
<Layout:overwrite name="MyScript">
<script src="<%=request.getContextPath() %>/resources/js/my/dropload/dropload.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/template/template.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/public.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/AllocationList.js"></script>
</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>