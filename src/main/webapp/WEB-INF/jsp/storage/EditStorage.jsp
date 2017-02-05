<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
入库单编辑
</Layout:overwrite>
<Layout:overwrite name="Mycss">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/dropload/dropload.css">
</Layout:overwrite> 
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>入库单编辑</h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<ul class="page-breadcrumb breadcrumb">
		<li>
			<a href="javascript:void(0)">入库管理</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="../storage/StorageList?menuids=5_1">入库单列表</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="../storage/showStorage?menuids=5_1&id=${psd.id }">采购单详情</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">采购单编辑</a>
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
									</div>
								<div class="portlet-body form">
									<form role="form">
										<div class="form-body">
											<div class="form-group form-md-line-input  has-error" >
												<input type="hidden" value="${psd.id }" id="id"/>
												<input type="text" class="form-control edited" readonly="" value="${psd.productName }" id="form_control_1">
												<label for="form_control_1">产品名称</label>
											</div>
											<div class="form-group form-md-line-input  has-error" >
												<input type="text" class="form-control edited" readonly="" value="${psd.brandName }" id="form_control_1">
												<label for="form_control_1">品牌名称</label>
											</div>
											<div class="form-group form-md-line-input has-success ">
													<input type="text" id="price" class="form-control" value="${psd.price }">
													<label for="form_control_1">单价(元,必填)</label>
											</div>
											<div class="form-group form-md-line-input has-success ">
													<input type="text" id="num" class="form-control" value="${psd.num }" >
													<label for="form_control_1">数量(必填)</label>
											</div>
											<div class="form-group form-md-line-input  has-info">
												<select class="form-control" id="status">
													<option value=""></option>
													<c:forEach var="statu" items="${status }">
														<c:if test="${psd.status==statu.key }">
														<option value="${statu.key  }" selected>${statu.value }</option>
														</c:if>
														<c:if test="${psd.status!=statu.key }">
														 <option value="${statu.key  }">${statu.value }</option>
														</c:if>
													</c:forEach>
												</select>
												<label for="form_control_1">状态</label>
											</div>
											<div class="form-group form-md-line-input">
												<textarea class="form-control" rows="3" id="remark" placeholder="填写入库单备注" style="margin: 0px -4px 0px 0px;">${psd.remark }</textarea>
												<label for="form_control_1">备注</label>
											</div>
									</div>
									<div class="form-actions noborder">
										<a href="javascript:void(0)" class="btn col-md-4 col-md-offset-2 col-xs-offset-1 col-xs-5 btn-lg blue" onclick="submitEditStorage()">提交</a>
										<a href="../purchase/showStorage?menuids=5_1&id=${psd.id}" class="btn col-md-4   col-xs-5 btn-lg default" >返回</a>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!-- END SAMPLE FORM PORTLET-->
				</div>
		</div>
</Layout:overwrite>
<Layout:overwrite name="MyScript">
<script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-suggest-plugin.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/EditStorage.js?v=1"></script>
</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>