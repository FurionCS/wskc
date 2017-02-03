<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
用户产品信息
</Layout:overwrite>
<%-- <Layout:overwrite name="Mycss"></Layout:overwrite> --%>
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>用户产品信息</h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<ul class="page-breadcrumb breadcrumb">
		<li>
			<a href="javascript:void(0)">基础档案</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">旗下产品</a>
		</li>
</ul>
<div class="row">
	<div class="col-md-8 col-xs-12 ">
					<!-- BEGIN SAMPLE FORM PORTLET-->
					<div class="portlet light">
						<div class="portlet-title">
							<div class="caption font-green">
								<i class="icon-pin font-green"></i>
								<span class="caption-subject bold uppercase">用户产品信息</span>
							</div>
						</div>
						<div class="portlet-body form">
							<form role="form">
								<div class="form-body">
					                <div class="form-group form-md-line-input has-success">
										<input type="text" class="form-control" id="productName" placeholder="" value="${upd.productName }" disabled>
										<label for="form_control_1">产品名称</label>
									</div>
									<div class="form-group form-md-line-input has-warning">
										<input type="text" class="form-control" id="remark" placeholder="" value="${upd.brandName }" disabled>
										<label for="form_control_1">品牌名称</label>
									</div>
									<div class="form-group form-md-line-input has-warning">
										<input type="text" class="form-control" id="remark" placeholder="" value="${upd.size }" disabled>
										<label for="form_control_1">产品规格</label>
									</div>
									<div class="form-group form-md-line-input has-warning">
										<input type="text" class="form-control" id="remark" placeholder="" value="${upd.unit }" disabled>
										<label for="form_control_1">产品单位</label>
									</div>
									<div class="form-group form-md-line-input has-warning">
										<input type="text" class="form-control" id="remark" placeholder="" value="${upd.num }" disabled>
										<label for="form_control_1">产品库存</label>
									</div>
									<div class="form-group form-md-line-input has-warning">
										<input type="text" class="form-control" id="remark" placeholder="" value="${upd.totleMoney }" disabled>
										<label for="form_control_1">产品库存金额</label>
									</div>
									<div class="form-group form-md-line-input has-warning">
										<input type="text" class="form-control" id="remark" placeholder="" value="${upd.createTime }" disabled>
										<label for="form_control_1">产品创建时间</label>
									</div>
								</div>
								<div class="form-actions noborder">
									<a href="../basic/productList?menuids=2_3" class="btn btn-lg default">返回</a>
								</div>
							</form>
						</div>
					</div>
					<!-- END SAMPLE FORM PORTLET-->
				</div>
</div>
<input type="hidden" id="brandId"/>
<input type="hidden" id="brandName"/>
</Layout:overwrite>
<Layout:overwrite name="MyScript">
<script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-suggest-plugin.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/Brand.js"></script>
</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>