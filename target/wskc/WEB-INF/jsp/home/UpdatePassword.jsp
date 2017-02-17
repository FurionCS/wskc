<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
修改密码
</Layout:overwrite>
<%-- <Layout:overwrite name="Mycss"></Layout:overwrite> --%>
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>修改密码</h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<ul class="page-breadcrumb breadcrumb">
		<li>
			<a href="javascript:void(0)">个人管理</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">修改密码</a>
		</li>
</ul>
<div class="row">
	<div class="col-md-8 col-xs-12 ">
					<!-- BEGIN SAMPLE FORM PORTLET-->
					<div class="portlet light">
						<div class="portlet-title">
							<div class="caption font-green">
								<i class="icon-pin font-green"></i>
								<span class="caption-subject bold uppercase">修改密码</span>
							</div>
						</div>
						<div class="portlet-body form">
							<form role="form">
								<div class="form-body">
					                <div class="form-group form-md-line-input has-success">
										<input type="password" class="form-control" id="password" placeholder="密码长度为6-12位" value="">
										<label for="form_control_1">新密码</label>
									</div>
									<div class="form-group form-md-line-input has-warning">
										<input type="password" class="form-control" id="cpassword" placeholder="">
										<label for="form_control_1">重复密码</label>
									</div>
								</div>
								<div class="form-actions noborder">
									<a href="javascript:void(0)" class="btn btn-lg blue" onclick="submitPassword()">提交</a>
								</div>
							</form>
						</div>
					</div>
					<!-- END SAMPLE FORM PORTLET-->
				</div>
</div>
<input type="hidden" id="id" value="${user.id }"/>
</Layout:overwrite>
<Layout:overwrite name="MyScript">
<script src="<%=request.getContextPath() %>/resources/global/plugins/bootstrap-suggest-plugin.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/my/home/home.js"></script>
</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>