<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
产品代理库存列表
</Layout:overwrite>
<Layout:overwrite name="Mycss">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/dropload/dropload.css">
</Layout:overwrite> 
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>产品代理库存列表</h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<ul class="page-breadcrumb breadcrumb">
		<li>
			<a href="javascript:void(0)">查询</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">代理库存量查询</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">直属代理库存</a>
		</li>
</ul>
<div class="form-group" >
		<div class="col-md-8 col-xs-12" style="margin-bottom: 10px;padding:0;">
			<a href="#large" class="btn blue"  data-toggle="modal">设置 <i class="fa  fa-cog"></i></a>
<!-- 			<a href="javascript:;" class="btn grey-cascade">导出 <i class="fa  fa-download"></i></a> -->
		</div>
</div>

<div class="modal fade " id="large" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;margin-top: 100.5px;">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
				<h4 class="modal-title">参数设置</h4>
			</div>
			<div class="modal-body">
				<div class="form-group form-md-line-input  has-info" style="padding:0">
					<label for="form_control_1">品牌</label>
					<select class="form-control" id="brandId">
						<c:forEach var="ubpd" items="${lubpd }">
							<option value="${ubpd.brandId }">${ubpd.brandName }</option>
						</c:forEach>
					</select>
				</div>
				  <div class="form-group form-md-line-input"  style="padding:0"> 
	                   	<label for="form_control_1" >产品</label>
						  	<div class="input-group">
		                        <input type="text" class="form-control" id="product" placeholder="不选为所有,注意同产品不同规格">
		                        <div class="input-group-btn">
		                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" style="height: 34px;border:none;border-bottom:1px solid #e5e5e5">
		                                <span class="caret"></span>
		                            </button>
		                            <ul class="dropdown-menu dropdown-menu-right" role="menu">
		                            </ul>
		                        </div>
		                        <!-- /btn-group -->
		                    </div>
	                  </div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn default" id="cancle" data-dismiss="modal">取消</button>
				<button type="button" class="btn blue" onclick="serachAgent()">查询</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<div class="productAgentList">
	<div id="ListBody" >
	</div>
</div>
<input type="hidden" value="" id="productId"/> 
<jsp:include page="../template/productAgentTemplate.jsp"></jsp:include>
</Layout:overwrite>
<Layout:overwrite name="MyScript">
<script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-suggest-plugin.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/dropload/dropload.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/template/template.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/public.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/stock/AgentStockList.js?v=1"></script>
</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>