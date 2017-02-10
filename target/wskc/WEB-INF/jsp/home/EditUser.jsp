<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
修改用户信息
</Layout:overwrite>
<%-- <Layout:overwrite name="Mycss"></Layout:overwrite> --%>
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>修改信息</h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<ul class="page-breadcrumb breadcrumb">
		<li>
			<a href="javascript:void(0)">个人管理</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">修改信息</a>
		</li>
</ul>
<div class="row">
	<div class="col-md-8 col-xs-12 ">
					<!-- BEGIN SAMPLE FORM PORTLET-->
					<div class="portlet light">
						<div class="portlet-title">
							<div class="caption font-green">
								<i class="icon-pin font-green"></i>
								<span class="caption-subject bold uppercase">修改信息</span>
							</div>
						</div>
						<div class="portlet-body form">
							<form role="form">
								<div class="form-body">
					                <div class="form-group form-md-line-input has-success">
										<input type="text" class="form-control" id="userNike" placeholder="" value="${user.userNike }">
										<label for="form_control_1">用户昵称</label>
									</div>
									<div class="form-group form-md-line-input has-warning">
										<input type="text" class="form-control" id="email" placeholder="" value="${user.email }">
										<label for="form_control_1">邮箱</label>
									</div>
									<div class="form-group form-md-line-input has-warning">
										<input type="text" class="form-control" id="city" placeholder="" value="${user.city }">
										<label for="form_control_1">城市</label>
									</div>
									<div class="form-group form-md-line-input has-success">
										<select class="form-control" id="gender" name="industryId">
											<option value="男"<c:if test="${user.gender=='男' }"> selected</c:if> >男</option>
											<option value="女" <c:if test="${user.gender=='女' }"> selected</c:if>>女</option>
											<option value="保密" <c:if test="${user.gender=='保密' }"> selected</c:if>>保密</option>
										</select>
										<label for="form_control_1" >性别</label>
									</div>
								</div>
								<div class="form-actions noborder">
									<a href="javascript:void(0)" class="btn btn-lg blue" onclick="submitUser()">提交</a>
									<a href="../home/ShowUser" class="btn btn-lg default">返回</a>
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