<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
用户产品列表
</Layout:overwrite>
<%-- <Layout:overwrite name="Mycss"></Layout:overwrite> --%>
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>产品列表</h1>
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
<div class="col-md-12">
					<!-- BEGIN BORDERED TABLE PORTLET-->
					<div class="portlet box yellow">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-coffee"></i>用户产品列表
							</div>
							<div class="tools hidden-xs" >
								<a href="javascript:;" class="collapse" data-original-title="" title="">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title="">
								</a>
								<a href="javascript:;" class="reload" data-original-title="" title="">
								</a>
								<a href="javascript:;" class="remove" data-original-title="" title="">
								</a>
							</div>
						</div>
						<div class="portlet-body">
								<div class="table-toolbar">
							<div class="row">
									<div class="col-md-6">
										<div class="btn-group pull-left" style="margin-right:3px;">
											<a id="sample_editable_1_new" href="../basic/addUserProduct?menuids=2_3" class="btn green">
											添加 <i class="fa fa-plus"></i>
											</a>
										</div>
										<div class="btn-group pull-left visible-xs-block" id="stopBtn" style="display:none !important" >
											<a id="deleteUserBrand" onclick="updateUserProductStatus(0,0,2)" class="btn red">
											停用 <i class="fa  fa-lock"></i>
											</a>
										</div>
										<div class="btn-group pull-left visible-xs-block" id="restartBtn" style="display:none !important">
											<a id="deleteUserBrand" onclick="updateUserProductStatus(0,0,2)" class="btn blue">
											重用<i class="fa  fa-unlock"></i>
											</a>
										</div>
									</div>
									<c:if test="${fn:length(lubpud)>0 }">
									<div class="col-md-6">
										<div class="btn-group pull-right">
												<div class="form-group form-md-line-input" style="padding-top:0px; margin: 0" >
													<select class="form-control" id="brand">
														<option value="0" selected>请选择品牌</option>
														<c:forEach var="ubpud" items="${lubpud}">
															<option value="${ubpud.brandId }">${ubpud.brandName }</option>
														</c:forEach>
													</select>
												</div>
										</div>
									</div>
									</c:if>
								</div>
							</div>
							<div class="table-scrollable">
								<table class="table table-bordered table-hover">
								<thead>
								<tr>
									<th>
										 产品名称
									</th>
									<th>
										规格
									</th>
									<th>
										单位
									</th>
									<th>
										品牌名称
									</th>
									<th>
										状态
									</th>
									<th class="hidden-xs">
										操作
									</th>
								</tr>
								</thead>
								<tbody id="ListBody">
								
								</tbody>
								</table>
							</div>
							<div class="row">
									<div class="col-md-5 col-sm-5 hidden-xs" >
										<div id="pageInfo" class="dataTables_info" id="sample_1_info" role="status" aria-live="polite"></div>
									</div>
									<div class="col-md-7 col-sm-7 col-xs-12">
										<div class="dataTables_paginate paging_bootstrap_full_number" id="sample_1_paginate">
											<ul id="pagePart" class="pagination" style="visibility: visible;">
											</ul>
										</div>
								  </div>
							</div>
						</div>
					</div>
					<!-- END BORDERED TABLE PORTLET-->
				</div>
</div>
<input type="hidden" value="-1" id="hid"/>
<input type="hidden" value="-1" id="status"/>
</Layout:overwrite>
 <Layout:overwrite name="MyScript">
 <script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-suggest-plugin.js"></script>
 <script src="<%=request.getContextPath() %>/resources/js/my/UserProduct.js"></script>
 </Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>