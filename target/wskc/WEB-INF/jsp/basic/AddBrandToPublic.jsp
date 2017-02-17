<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
添加品牌
</Layout:overwrite>
<%-- <Layout:overwrite name="Mycss"></Layout:overwrite> --%>
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>添加品牌到库</h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<ul class="page-breadcrumb breadcrumb">
		<li>
			<a href="javascript:void(0)">基础档案</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">品牌管理</a>
		</li>
</ul>
<div class="row">
	<div class="col-md-8 col-xs-12 ">
					<!-- BEGIN SAMPLE FORM PORTLET-->
					<div class="portlet light">
						<div class="portlet-title">
							<div class="caption font-green">
								<i class="icon-pin font-green"></i>
								<span class="caption-subject bold uppercase">添加品牌到库</span>
							</div>
						</div>
						<div class="portlet-body form">
							<form role="form">
								<div class="form-body">
									<div class="form-group form-md-line-input has-success">
										<select class="form-control" id="industryId" name="industryId">
											<option value="0" selected>点击选择</option>
											<c:forEach var="i" items="${liud}">
												<option value="${i.industryId }">${i.industryName }</option>
											</c:forEach>
										</select>
										<label for="form_control_1" >行业列表</label>
									</div>
									<div class="form-group form-md-line-input has-success">
										<input type="text" class="form-control" id="name" placeholder="品牌全称,与注册时一致">
										<label for="form_control_1">品牌全称</label>
									</div>
									<div class="form-group form-md-line-input has-success">
										<input type="text" class="form-control" id="company" placeholder="请填写注册时公司名称">
										<label for="form_control_1">公司</label>
									</div>
								</div>
								<div class="form-actions noborder">
									<a href="javascript:void(0)" class="btn btn-lg blue" onclick="submitBrandToPublic()">提交</a>
									<a href="../basic/addBrand?menuids=2_2" class="btn btn-lg default">返回</a>
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