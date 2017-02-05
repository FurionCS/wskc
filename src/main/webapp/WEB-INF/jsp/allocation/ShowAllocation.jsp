<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
调拨单详情
</Layout:overwrite>
<Layout:overwrite name="Mycss">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/dropload/dropload.css">
</Layout:overwrite> 
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>调拨单详情</h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<ul class="page-breadcrumb breadcrumb">
		<li>
			<a href="javascript:void(0)">库存管理</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">调拨单</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="../allocation/AllocationList?menuids=5_0">调拨单列表</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">调拨单详情</a>
		</li>
</ul>

<div class="purchaseList">
		<div class="row">
			<div class="col-md-8 col-xs-12 ">
							<!-- BEGIN SAMPLE FORM PORTLET-->
							<div class="portlet light">
									<div class="portlet-title">
										<div class="caption font-green">
											<span class="caption-subject bold uppercase">调拨编码:${pad.allocationNo }<a></a></span>
										</div>
										<c:if test="${pad.status==1 }">
											<div class="actions">
												<a href="../allocation/EditAllocation?menuids=5_0&id=${pad.id }" class="btn btn-default btn-sm">
												<i class="fa fa-pencil"></i> 编辑 </a>
											</div>
										</c:if>
									</div>
								<div class="portlet-body form">
								<div class="row">
										<div class="col-md-8 col-sm-12 col-xs-12">
												<div class="portlet-body">
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															调拨类型
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pad.type }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 调给人
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 ${pad.allocationTo }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 产品编码
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 ${pad.code }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 产品名称
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 ${pad.productName }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 品牌名称
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 ${pad.brandName }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 数量
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pad.num }
														</div>
													</div>
													
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															调拨费用(元)
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
														${pad.counterFee }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 规格
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pad.size }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 单位
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pad.unit }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 创建时间
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pad.createTime }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 修改时间
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pad.modifyTime }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 备注
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pad.remark }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 状态
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															<span class="label label-success">
															 <c:if test="${pad.status==0 }">作废</c:if>
															 <c:if test="${pad.status==1 }">待审</c:if>
															 <c:if test="${pad.status==2 }">已审</c:if>
													       </span>
														</div>
													</div>
												</div>
										</div>
									</div>
								</div>
							</div>
							<!-- END SAMPLE FORM PORTLET-->
						</div>
		</div>
</div>
<jsp:include page="../template/purchaseTemplate.jsp"></jsp:include>
</Layout:overwrite>
<Layout:overwrite name="MyScript">
<script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-suggest-plugin.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/public.js"></script>
</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>