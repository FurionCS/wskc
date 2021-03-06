<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
拥有品牌
</Layout:overwrite>
<%-- <Layout:overwrite name="Mycss"></Layout:overwrite> --%>
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>品牌列表</h1>
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
<div class="col-md-12">
					<!-- BEGIN BORDERED TABLE PORTLET-->
					<div class="portlet box yellow">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-coffee"></i>品牌
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
										<div class="btn-group pull-left">
											<a id="sample_editable_1_new" href="../basic/addBrand?menuids=2_2" class="btn green">
											添加 <i class="fa fa-plus"></i>
											</a>
										</div>
										<div class="btn-group pull-left visible-xs-block"  style="margin-left:3px;">
											<a id="deleteUserBrand" onclick="deleteUserBrand(0,2)" class="btn red">
											删除 <i class="fa  fa-trash-o"></i>
											</a>
										</div>
									</div>
									<c:if test="${fn:length(liud)>0 }">
									<div class="col-md-6">
										<div class="btn-group pull-right">
												<button class="btn dropdown-toggle" data-toggle="dropdown" aria-expanded="false">行业<i class="fa fa-angle-down"></i>
												</button>
												<ul class="dropdown-menu pull-right">
													<li>
														<a href="../basic/brandList?menuids=2_2&industryId=0">
														所有行业 </a>
													</li>
													<c:forEach var="iud" items="${liud }">
														<li>
															<a href="../basic/brandList?menuids=2_2&industryId=${iud.industryId }">
															${iud.industryName } </a>
														</li>
													</c:forEach>
												</ul>
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
										 品牌名称
									</th>
									<th>
										授权码
									</th>
									<th>
										上家
									</th>
									<th>
										创建时间
									</th>
									<th class="hidden-xs">
										操作
									</th>
								</tr>
								</thead>
								<tbody>
								<c:forEach var="ubpd" items="${lubpd }">
								<tr onclick="selectTr(${ubpd.brandId},this)" id="tr_${ubpd.brandId }">
									<td>
										 <a href="../basic/editUserBrandPUser?menuids=2_2&brandId=${ubpd.brandId }" >${ubpd.brandName }</a>
									</td>
									<td>
										 <a href="javascript:void(0)" title="分享授权码">${ubpd.authCode }</a>
									</td>
									<td>
										 <a href="../basic/editUserBrandPUser?menuids=2_2&brandId=${ubpd.brandId }">${ubpd.puserRemark }</a>
									</td>
									<td>
										${ubpd.createTime }
									</td>
									<td class="hidden-xs">
										<a href="../basic/editUserBrandPUser?menuids=2_2&brandId=${ubpd.brandId }"  class="label label-info" style="color: white;">修改</a>
										<a href="javascript:void(0)" onclick="deleteUserBrand(${ubpd.brandId },1)" class="label label-Danger" style="color: white;">删除</a>
									</td>
								</tr>
								</c:forEach>
								
								</tbody>
								</table>
								
							</div>
							<c:if test="${fn:length(lubpd)<1 }">
									<p style="text-align: center;">该行业下暂无品牌</p>
								</c:if>
						</div>
					</div>
					<!-- END BORDERED TABLE PORTLET-->
				</div>
					
</div>
<input type="hidden" value="-1" id="hid"/>
</Layout:overwrite>
 <Layout:overwrite name="MyScript">
 <script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-suggest-plugin.js"></script>
 <script type="text/javascript" src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
  <script src="<%=request.getContextPath() %>/resources/js/my/Brand.js"></script>
 <script src="<%=request.getContextPath() %>/resources/js/my/public.js"></script>
 </Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>