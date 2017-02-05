<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
采购单详情
</Layout:overwrite>
<Layout:overwrite name="Mycss">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/dropload/dropload.css">
</Layout:overwrite> 
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>采购单详情</h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<ul class="page-breadcrumb breadcrumb">
		<li>
			<a href="javascript:void(0)">采购管理</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="../purchase/PurchaseList?menuids=3_2">采购单列表</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">采购单详情</a>
		</li>
</ul>

<div class="purchaseList">
		<div class="row">
			<div class="col-md-8 col-xs-12 ">
							<!-- BEGIN SAMPLE FORM PORTLET-->
							<div class="portlet light">
									<div class="portlet-title">
										<div class="caption font-green">
											<span class="caption-subject bold uppercase">采购编码:${pd.purchaseNo }<a></a></span>
										</div>
										<div class="actions">
											<a href="../purchase/EditPurchase?menuids=3_2&id=${pd.id }" class="btn btn-default btn-sm">
											<i class="fa fa-pencil"></i> 编辑 </a>
										</div>
									</div>
								<div class="portlet-body form">
								<div class="row">
										<div class="col-md-8 col-sm-12 col-xs-12">
												<div class="portlet-body">
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 产品编码
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 ${pd.code }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 产品名称
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 ${pd.productName }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 品牌名称
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 ${pd.brandName }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 数量
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pd.num }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 单价(元)
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pd.price }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 快递费(元)
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pd.deliveryFee }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															其他费用(元)
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pd.otherFee }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															总费用(元)
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															<fmt:formatNumber type="number" value="${pd.otherFee+pd.deliveryFee+pd.price*pd.num }" pattern="0.00" maxFractionDigits="2"/> 
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 规格
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pd.size }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 单位
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pd.unit }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 创建时间
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pd.createTime }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 备注
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${pd.remark }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 状态
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															<span class="label label-success">
															 <c:if test="${pd.status==0 }">已收货</c:if>
															 <c:if test="${pd.status==1 }">未收货</c:if>
															 <c:if test="${pd.status==2 }">已退货</c:if>
															 <c:if test="${pd.status==3 }">部分退货</c:if>
															 <c:if test="${pd.status==4 }">作废</c:if>
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
<script src="<%=request.getContextPath() %>/resources/js/my/Purchase.js"></script>
</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>