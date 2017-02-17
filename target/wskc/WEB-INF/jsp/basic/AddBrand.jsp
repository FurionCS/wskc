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
		<h1>添加品牌</h1>
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
								<span class="caption-subject bold uppercase">添加品牌</span>
							</div>
							<div class="actions">
								<a class="btn btn-circle btn-icon-only blue" href="../basic/addBrandToPublic?menuids=2_2">
								<i class="icon-cloud-upload"></i>
								</a>
							</div>
						</div>
						<div class="portlet-body form">
							<form role="form">
								<div class="form-body">
									<div class="form-group"> 
									<label for="taobao">品牌</label>
									  <div class="input-group">
					                        <input type="text" class="form-control" id="brand" placeholder="如搜索不到请点击右上角按钮添加到库">
					                        <div class="input-group-btn">
					                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" style="height: 34px;">
					                                <span class="caret"></span>
					                            </button>
					                            <ul class="dropdown-menu dropdown-menu-right" role="menu">
					                            </ul>
					                        </div>
					                        <!-- /btn-group -->
					                    </div>
					                  </div>
					                <div class="form-group form-md-line-input has-success">
										<input type="text" class="form-control" id="code" placeholder="授权码为11位,可不填">
										<label for="form_control_1">上家授权码</label>
									</div>
									<div class="form-group form-md-line-input has-warning">
										<input type="text" class="form-control" id="remark" placeholder="用于标记上家,可不填">
										<label for="form_control_1">上家备注</label>
									</div>
								</div>
								<div class="form-actions noborder">
									<a href="javascript:void(0)" class="btn btn-lg blue" onclick="submitBrand()">提交</a>
									<a href="../basic/brandList?menuids=2_2&industryId=0" class="btn btn-lg default">返回</a>
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