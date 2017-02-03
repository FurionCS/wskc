<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
添加行业
</Layout:overwrite>
<%-- <Layout:overwrite name="Mycss"></Layout:overwrite> --%>
<Layout:overwrite name="MyContent">
<div class="page-head">
				<!-- BEGIN PAGE TITLE -->
				<div class="page-title hidden-xs">
					<h1>行业列表</h1>
				</div>
				<!-- END PAGE TITLE -->
			</div>
	<ul class="page-breadcrumb breadcrumb">
				<li>
					<a href="javascript:void(0)">基础档案</a>
					<i class="fa fa-circle"></i>
				</li>
				<li>
					<a href="javascript:void(0)">所有行业</a>
				</li>
			</ul>	
<div class="row">
<div class="col-md-12">
<div class="portlet-body form">
<form role="form" method="post" action="../basic/addIndustryUser?menuids=2_1">
	<div class="form-body">
		<div class="form-group form-md-line-input has-success">
										<select class="form-control" id="industryId" name="industryId">
											<option value="0" selected>点击选择</option>
											<c:forEach var="i" items="${li}">
												<option value="${i.id }">${i.name }</option>
											</c:forEach>
										</select>
										<label for="form_control_1" >行业列表</label>
									</div>
									<span style="color:red;">${msg }</span>
									<div class="row">
										<div class="col-md-offset-4 col-xs-offset-3 col-xs-12 col-md-12">
											<input type="submit" class="btn green btn-lg" value="提交"/>
											<a href="../basic/industryList?menuids=2_1" class="btn default btn-lg">返回</a>
										</div>
									</div>
	</div>
</form>
</div>
</div>
</div>
</Layout:overwrite>
<Layout:overwrite name="MyScript">

</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>