<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
添加销售单
</Layout:overwrite>
<Layout:overwrite name="Mycss">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
</Layout:overwrite> 
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>添加销售单</h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<ul class="page-breadcrumb breadcrumb">
		<li>
			<a href="javascript:void(0)">销售管理</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">销售单</a>
		</li>
</ul>
<div class="row">
	<div class="col-md-8 col-xs-12 ">
					<!-- BEGIN SAMPLE FORM PORTLET-->
					<div class="portlet light">
						<div class="portlet-title">
							<div class="caption font-green">
								<i class="icon-pin font-green"></i>
								<span class="caption-subject bold uppercase">销售单</span>
							</div>
						</div>
						<div class="portlet-body form">
							<form role="form" id="soleForm">
								<div class="form-body">
										<div class="form-group form-md-line-input  has-error" >
											<input type="text" class="form-control edited" readonly="" value="自动编码" id="form_control_1">
											<label for="form_control_1">销售单编码</label>
										</div>
										<div class="form-group form-md-line-input  has-info">
											<select class="form-control" id="types">
												<c:forEach var="type" items="${types }">
													<option value="${type  }">${type }</option>
												</c:forEach>
											</select>
											<label for="form_control_1">销售类型</label>
										</div>
					                  <div class="form-group form-md-line-input"> 
					                   	<label for="form_control_1" >产品</label>
										  	<div class="input-group">
						                        <input type="text" class="form-control" id="product" placeholder="请检索产品,注意同产品不同规格">
						                        <div class="input-group-btn">
						                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" style="height: 34px;border:none;border-bottom:1px solid #e5e5e5">
						                                <span class="caret"></span>
						                            </button>
						                            <ul class="dropdown-menu dropdown-menu-right" role="menu">
						                            </ul>
						                        </div>
						                        <!-- /btn-group -->
						                    </div>
					                  </div>
									<div class="form-group form-md-line-input has-success ">
											<input type="text" id="price" class="form-control">
											<label for="form_control_1">成本单价(元,必填),默认取库存平均价</label>
									</div>
									<div class="form-group form-md-line-input has-success ">
											<input type="text" id="factPrice" class="form-control">
											<label for="form_control_1">销售单价(元,必填)</label>
									</div>
									<div class="form-group form-md-line-input has-success ">
											<input type="text" id="num" class="form-control" >
											<label for="form_control_1">数量(必填)</label>
									</div>
									<div class="form-group form-md-line-input has-success ">
							 				<input type="text" id="deliveryFee" class="form-control" >
											<label for="form_control_1">快递费用(元,选填)</label>
									</div>
									<div class="form-group form-md-line-input has-success ">
											<input type="text" id="otherFee" class="form-control" >
											<label for="form_control_1">其他费用(元,选填)</label>
									</div>
									<div class="form-group form-md-line-input has-success ">
											<input type="text" id="customer" class="form-control">
											<label for="form_control_1">消费者</label>
									</div>
									<div class="form-group form-md-line-input ">
										<label for="form_control_1">销售日期</label>
										<div class="input-group date form_datetime" data-date="2012-12-21T15:25:00Z">
											<span class="input-group-btn">
												<button class="btn  date-set" style="background: none;" type="button"><i class="fa fa-calendar"></i></button>
												<button class="btn  date-reset" style="background: none;" type="button"><i class="fa fa-times"></i></button>
											</span>
											<input type="text" size="16" readonly="" class="form-control" id="createTime" value="" placeholder="默认当前时间">
										</div>
										<!-- /input-group -->
									</div>
									<div class="form-group form-md-line-input form-md-floating-label has-info">
										<select class="form-control" id="status">
											<option value=""></option>
											<c:forEach var="statu" items="${status }">
												<option value="${statu.key  }">${statu.value }</option>
											</c:forEach>
										</select>
										<label for="form_control_1">状态</label>
									</div>
									<div class="form-group form-md-line-input">
										<textarea class="form-control" rows="3" id="remark" placeholder="填写销售单备注" style="margin: 0px -4px 0px 0px;"></textarea>
										<label for="form_control_1">备注</label>
									</div>
								</div>
								<div class="form-actions noborder">
									<a href="javascript:void(0)" class="btn col-md-4 col-md-offset-4  col-xs-12 btn-lg blue" onclick="submitSole()">提交</a>
								</div>
							</form>
						</div>
					</div>
					<!-- END SAMPLE FORM PORTLET-->
				</div>
</div>
<input type="hidden" id="brandId"/>
<input type="hidden" id="brandName"/>
<input type="hidden" id="productId"/>
<input type="hidden" id="productName"/>
<input type="hidden" id="kcnum"/>
</Layout:overwrite>
<Layout:overwrite name="MyScript">
<script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-suggest-plugin.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/public.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/sole/AddSole.js?v=8"></script>
</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>