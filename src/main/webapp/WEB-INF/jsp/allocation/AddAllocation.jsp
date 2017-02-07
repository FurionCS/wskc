<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
添加调拨单
</Layout:overwrite>
<Layout:overwrite name="Mycss">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
</Layout:overwrite> 
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>添加调拨单</h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<ul class="page-breadcrumb breadcrumb">
		<li>
			<a href="javascript:void(0)">库存管理</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">调拨单</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">添加调拨单</a>
		</li>
</ul>
<div class="row">
	<div class="col-md-8 col-xs-12 ">
					<!-- BEGIN SAMPLE FORM PORTLET-->
					<div class="portlet light">
						<div class="portlet-title">
							<div class="caption font-green">
								<i class="icon-pin font-green"></i>
								<span class="caption-subject bold uppercase">调拨单</span>
							</div>
						</div>
						<div class="portlet-body form">
							<form role="form">
								<div class="form-body">
										<div class="form-group form-md-line-input  has-error" >
											<input type="text" class="form-control edited" readonly="" value="自动编码" id="form_control_1">
											<label for="form_control_1">调拨单编码</label>
										</div>
									<div class="form-group form-md-radios">
										<label>调拨类型</label>
										<div class="md-radio-inline">
										<div class="md-radio">
											<input type="radio" id="radio6" name="type" class="md-radiobtn" value="调入"checked="">
											<label for="radio6">
											<span class="inc"></span>
											<span class="check"></span>
											<span class="box"></span>
											调入 </label>
										</div>
										<div class="md-radio">
											<input type="radio" id="radio7" name="type" class="md-radiobtn" value="调出">
											<label for="radio7">
											<span class="inc"></span>
											<span class="check"></span>
											<span class="box"></span>
											调出 </label>
										</div>
									</div>
								</div>
					                <div class="form-group form-md-line-input" id="productDiv"> 
										<label for="taobao">产品</label>
										  <div class="input-group">
						                        <input type="text" class="form-control" id="product" placeholder="">
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
											<input type="text" id="allocationTo" class="form-control" placeholder="调出时为收货人,调入时为发货人">
											<label for="form_control_1">调给人</label>
									</div>
									<div class="form-group form-md-line-input has-success ">
											<input type="text" id="num" class="form-control" >
											<label for="form_control_1">数量(必填)</label>
									</div>
									<div class="form-group form-md-line-input has-success ">
											<input type="text" id="counterFee" class="form-control" >
											<label for="form_control_1">费用</label>
									</div>
									<div class="form-group form-md-line-input">
										<label for="form_control_1">创建日期</label>
										<div class="input-group date form_datetime" data-date="2012-12-21T15:25:00Z">
											<span class="input-group-btn">
												<button class="btn  date-set" style="background: none;" type="button"><i class="fa fa-calendar"></i></button>
												<button class="btn  date-reset" style="background: none;" type="button"><i class="fa fa-times"></i></button>
											</span>
											<input type="text" size="16" readonly="" class="form-control" id="createTime" value="" placeholder="默认当前时间">
										</div>
										<!-- /input-group -->
									</div>
									<div class="form-group form-md-line-input  has-info">
										<select class="form-control" id="status">
											<option value=""></option>
											<c:forEach var="statu" items="${status }">
												<option value="${statu.key  }">${statu.value }</option>
											</c:forEach>
										</select>
										<label for="form_control_1">状态</label>
									</div>
									<div class="form-group form-md-line-input">
										<textarea class="form-control" rows="3" id="remark" placeholder="填写入库单备注" style="margin: 0px -4px 0px 0px;"></textarea>
										<label for="form_control_1">备注</label>
									</div>
								</div>
								<div class="form-actions noborder">
									<a href="javascript:void(0)" class="btn col-md-4 col-md-offset-4  col-xs-12 btn-lg blue" onclick="submitAllocation()">提交</a>
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
</Layout:overwrite>
<Layout:overwrite name="MyScript">
<script src="<%=request.getContextPath() %>/resources/js/template/template.js"></script>
<script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-suggest-plugin.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/public.js" ></script>
<script src="<%=request.getContextPath() %>/resources/js/my/AddAllocation.js" ></script>
</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>