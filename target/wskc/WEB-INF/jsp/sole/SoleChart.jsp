<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
销售图表
</Layout:overwrite>
<Layout:overwrite name="Mycss">
</Layout:overwrite> 
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>销售图表</h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<ul class="page-breadcrumb breadcrumb">
		<li>
			<a href="javascript:void(0)">查询</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">销售图表</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">销售统计报表</a>
		</li>
</ul>
<div class="form-group" >
		<div class="col-md-6">
			<div class="btn-group ">
					<div class="form-group form-md-line-input" style="padding-top:0px; margin: 0" >
						<select class="form-control" id="brandId">
							<c:forEach var="ubpud" items="${lubpud}">
								<option value="${ubpud.brandId }">${ubpud.brandName }</option>
							</c:forEach>
						</select>
					</div>
			</div>
		</div>
</div>


<div class="row">
			<div class="col-md-12 col-xs-12 ">
							<!-- BEGIN SAMPLE FORM PORTLET-->
							<div class="portlet">
									<div class="caption font-green" style="text-align:center">
										<span class="caption-subject bold uppercase" >各月各产品销售金额折线图</span>
									</div>
									<hr style="padding:0;margin:5px 0 0 0;">
								<div class="portlet-body form">
								<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
												<div class="portlet-body">
													 <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
   													 <div id="report_box" style="height:400px;padding:0 0 30px 0;"></div>
												</div>
										</div>
									</div>
								</div>
							</div>
							<!-- END SAMPLE FORM PORTLET-->
						</div>
		</div>
<div class="row">
			<div class="col-md-12 col-xs-12 ">
							<!-- BEGIN SAMPLE FORM PORTLET-->
							<div class="portlet">
									<div class="caption font-green" style="text-align:center">
										<span class="caption-subject bold uppercase" >各月各产品销售数量折线图</span>
									</div>
									<hr style="padding:0;margin:5px 0 0 0;">
								<div class="portlet-body form">
								<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
												<div class="portlet-body">
													 <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
   													 <div id="report_box_num" style="height:400px;padding:0 0 30px 0;"></div>
												</div>
										</div>
									</div>
								</div>
							</div>
							<!-- END SAMPLE FORM PORTLET-->
						</div>
		</div>
</Layout:overwrite>
<Layout:overwrite name="MyScript">
<!-- ECharts单文件引入 -->
<script src="<%=request.getContextPath() %>/resources/js/echart/echarts.common.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/MyChart.js" ></script>
<script src="<%=request.getContextPath() %>/resources/js/my/sole/SoleChart.js?v=3" ></script>
</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>