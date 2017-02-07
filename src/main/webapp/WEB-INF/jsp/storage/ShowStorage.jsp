<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
入库单详情
</Layout:overwrite>
<Layout:overwrite name="Mycss">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/dropload/dropload.css">
</Layout:overwrite> 
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>入库单详情</h1>
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
			<a href="../storage/StorageList?menuids=5_1">入库单列表</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">入库单详情</a>
		</li>
</ul>

<div class="purchaseList">
		<div class="row">
			<div class="col-md-8 col-xs-12 ">
							<!-- BEGIN SAMPLE FORM PORTLET-->
							<div class="portlet light">
									<div class="portlet-title">
										<div class="caption font-green">
											<span class="caption-subject bold uppercase">入库编码:${psd.storageNo }<a></a></span>
										</div>
										<c:if test="${psd.status==1 }">
											<div class="actions">
												<a href="../storage/EditStorage?menuids=5_1&id=${psd.id }" class="btn btn-default btn-sm">
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
															入库类型
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${psd.type }
														</div>
													</div>
													<c:if test="${psd.type!='其他入库' }">
														<div class="row static-info">
															<div class="col-md-5 col-sm-5  col-xs-5 name">
																 关联编号
															</div>
															<div class="col-md-7 col-sm-7 col-xs-7 value">
																${psd.relevanceNo }
															</div>
														</div>
													</c:if>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 产品编码
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 ${psd.code }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 产品名称
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 ${psd.productName }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 品牌名称
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 ${psd.brandName }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 数量
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${psd.num }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 单价(元)
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${psd.price }
														</div>
													</div>
													
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															总费用(元)
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															<fmt:formatNumber type="number" value="${psd.price*psd.num }" pattern="0.00" maxFractionDigits="2"/> 
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 规格
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${psd.size }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 单位
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${psd.unit }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 创建时间
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${psd.createTime }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 修改时间
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${psd.modifyTime }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 备注
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${psd.remark }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 状态
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															<span class="label label-success">
															 <c:if test="${psd.status==0 }">作废</c:if>
															 <c:if test="${psd.status==1 }">待审</c:if>
															 <c:if test="${psd.status==2 }">已审</c:if>
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