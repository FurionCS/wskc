<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
添加用户产品
</Layout:overwrite>
<%-- <Layout:overwrite name="Mycss"></Layout:overwrite> --%>
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>添加用户产品</h1>
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
								<span class="caption-subject bold uppercase">添加用户产品</span>
							</div>
							<div class="actions">
								<a class="btn btn-circle btn-icon-only blue" href="../basic/AddProduct?menuids=2_3">
								<i class="icon-cloud-upload"></i>
								</a>
							</div>
						</div>
						<div class="portlet-body form">
							<form role="form">
								<div class="form-body">
									<div class="form-group"> 
									<label for="taobao">产品</label>
									  <div class="input-group">
					                        <input type="text" class="form-control" id="product" placeholder="如搜索不到请点击右上角按钮添加到库">
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
										<input type="text" class="form-control" id="num" placeholder="为整数,如1">
										<label for="form_control_1">初始库存量</label>
									</div>
									<div class="form-group form-md-line-input has-warning">
										<input type="text" class="form-control" id="totalMoney" placeholder="如100.0">
										<label for="form_control_1">初始库存金额</label>
									</div>
									<div class="form-group form-md-line-input has-warning">
										<input type="text" class="form-control" id="warnNum" placeholder="为整数,如1">
										<label for="form_control_1">库存警告数量</label>
									</div>
								</div>
								<div class="form-actions noborder">
									<a href="javascript:void(0)" class="btn btn-lg blue" onclick="submitUserProduct()">提交</a>
									<a href="../basic/productList?menuids=2_3" class="btn btn-lg default">返回</a>
								</div>
							</form>
						</div>
					</div>
					<!-- END SAMPLE FORM PORTLET-->
				</div>
</div>
<input type="hidden" id="productId"/>
</Layout:overwrite>
<Layout:overwrite name="MyScript">
<script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-suggest-plugin.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/UserProduct.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/public.js"></script>
</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>