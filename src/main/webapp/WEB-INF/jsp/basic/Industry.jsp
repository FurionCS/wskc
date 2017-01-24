<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="Mytag" prefix="Layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
行业信息
</Layout:overwrite>
<Layout:overwrite name="Mycss">

</Layout:overwrite> 
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
					<a href="javascript:void(0)">所属行业</a>
				</li>
			</ul>	
<div class="row">
<div class="col-md-12">
					<!-- BEGIN SAMPLE TABLE PORTLET-->
					<div class="portlet box purple">
						<div class="portlet-title">
							<div class="caption" style="font-size:16px;">
								<i class="fa fa-comments"></i>行业列表
							</div>
							<div class="tools hidden-xs">
								<a href="javascript:;" class="collapse" data-original-title="" title="">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title="">
								</a>
								<a href="javascript:;" class="reload" data-original-title="" title="">
								</a>
								<a href="javascript:;" class="remove" data-original-title="" title="">
								</a>
							</div>
							<c:if test="${fn:length(liud)<2}">
								<div class="actions"  style="margin-left:3px">
									<a href="addIndustryUser?menuids=2_1" data-toggle="modal" data-original-title="" class="btn btn-default btn-sm">
									<i class="fa fa-plus"></i> 添加 </a>
								</div>
							</c:if>
							<c:if test="${fn:length(liud)>0 }">
								<div class="actions hidden-lg"> 
									<a href="javascript:void(0)" onclick="deleteIndustry(0,2)" data-toggle="modal" data-original-title="" class="btn btn-default btn-sm">
									<i class="fa  fa-trash-o"></i>删除</a>
								</div>
							</c:if>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-striped table-hover">
								<thead>
								<tr>
									<th>
										 行业编号
									</th>
									<th>
										 行业名称
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
									<c:forEach var="iud" items="${liud }">
										<tr onclick="selectIndustry(${iud.industryId},this)" id="tr_${iud.industryId }">
											<td>
												 ${iud.industryId }
											</td>
											<td>
												 ${iud.industryName }
											</td>
											<td>
												 ${iud.modifyTime }
											</td>
											<td class="hidden-xs">
												<a href="javascript:void(0)" onclick="deleteIndustry(${iud.industryId },1)" class="label label-Danger" style="color: white;">删除</a>
											</td>
										</tr>
								</c:forEach>
								</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- END SAMPLE TABLE PORTLET-->
				</div>
</div>
<input type="hidden" value="-1" id="industryId"/>
</Layout:overwrite>
<Layout:overwrite name="MyScript">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/my/Industry.js"></script>

</Layout:overwrite> 

<%@ include file="/share/_LayoutB.jsp"%>