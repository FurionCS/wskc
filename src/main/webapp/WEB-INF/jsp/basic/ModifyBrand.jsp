<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
修改品牌授权
</Layout:overwrite>
<%-- <Layout:overwrite name="Mycss"></Layout:overwrite> --%>
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>修改品牌授权</h1>
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
								<span class="caption-subject bold uppercase">修改品牌授权</span>
							</div>
						</div>
						<div class="portlet-body form">
							<form role="form">
								<div class="form-body">
									<div class="form-group form-md-line-input has-success"> 
									       <input type="hidden" value=${ubpu.id } id="id"/>
					                        <input type="text" class="form-control" id="brand" value="${ubpu.brandName }" disabled>
					                        <label for="form_control_1">品牌名称</label>
					                </div>
					                <div class="form-group form-md-line-input has-success">
										<input type="text" class="form-control" id="code" placeholder="授权码为11位" value="">
										<label for="form_control_1">上家授权码</label>
									</div>
									<div class="form-group form-md-line-input has-warning">
										<input type="text" class="form-control" id="remark" placeholder="用于标记上家" value=${ubpu.pUserRemark }>
										<label for="form_control_1">上家备注</label>
									</div>
								</div>
								<div class="form-actions noborder">
									<a href="javascript:void(0)" class="btn btn-lg blue" onclick="submitModifyBrand()">修改</a>
									<a href="../basic/brandList?menuids=2_2&industryId=0" class="btn btn-lg default">返回</a>
								</div>
							</form>
						</div>
					</div>
					<!-- END SAMPLE FORM PORTLET-->
				</div>
</div>
</Layout:overwrite>
<Layout:overwrite name="MyScript">
<script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-suggest-plugin.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/Brand.js"></script>
</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>