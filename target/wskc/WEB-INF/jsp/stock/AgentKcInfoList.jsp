<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
产品代理库存详细列表
</Layout:overwrite>
<Layout:overwrite name="Mycss">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/dropload/dropload.css">
</Layout:overwrite> 
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>产品代理库存详细列表</h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<ul class="page-breadcrumb breadcrumb">
		<li>
			<a href="javascript:void(0)">查询</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="../stock/AgentKc?menuids=6_2">代理库存量查询</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">产品库存详细</a>
		</li>
</ul>
<div class="productAgentInfoList">
	<div id="ListBody" >
	</div>
</div>
<input type="hidden" value="${pd.id }" id="productId"/> 
<input type="hidden" value="${pd.brandId }" id="brandId"/> 
<jsp:include page="../template/productAgentInfoTemplate.jsp"></jsp:include>
</Layout:overwrite>
<Layout:overwrite name="MyScript">
<script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-suggest-plugin.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/dropload/dropload.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/template/template.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/public.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/stock/AgentStockInfoList.js?v=3"></script>
</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>