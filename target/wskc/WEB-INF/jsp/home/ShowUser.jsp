<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
展示用户
</Layout:overwrite>
<Layout:overwrite name="Mycss">
</Layout:overwrite> 
<Layout:overwrite name="MyContent">
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title hidden-xs">
		<h1>用户信息</h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<ul class="page-breadcrumb breadcrumb">
		<li>
			<a href="javascript:void(0)">个人管理</a>
			<i class="fa fa-circle"></i>
		</li>
		<li>
			<a href="javascript:void(0)">信息展示</a>
		</li>
</ul>
<div class="row">
			<div class="col-md-8 col-xs-12 ">
							<!-- BEGIN SAMPLE FORM PORTLET-->
							<div class="portlet light">
									<div class="actions"  style="margin-left:3px;overflow:hidden">
										<span class="caption-subject bold uppercase font-green" style="position: relative;top:5px">个人信息</span>
										<a href="../home/EditUser" data-toggle="modal" data-original-title="" class="btn btn-default btn-sm" style="float:right">
										<i class="fa  fa-edit"></i>修改 </a>
									</div>
									<hr style="padding:0;margin:5px 0 0 0;">
								<div class="portlet-body form">
								<div class="row">
										<div class="col-md-8 col-sm-12 col-xs-12">
												<div class="portlet-body">
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															用户昵称
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 ${user.userNike }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															  用户名
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${user.userName }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															用户性别
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${user.gender }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															邮箱
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${user.email }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 城市
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
																${user.city }
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															创建时间
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															${user.createTime }
														</div>
													</div>
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
</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>