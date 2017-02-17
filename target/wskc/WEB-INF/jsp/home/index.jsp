<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ taglib uri="Mytag" prefix="Layout"%>
<%-- <Layout:overwrite name="import"></Layout:overwrite> --%>
<Layout:overwrite name="title">
首页
</Layout:overwrite>
<%-- <Layout:overwrite name="Mycss"></Layout:overwrite> --%>
<Layout:overwrite name="MyContent">
<div class="row margin-top-10">
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<div class="dashboard-stat2">
						<div class="display">
							<div class="number">
								<h3 class="font-green-sharp"><fmt:formatNumber type="number" value="${total.kcTotalMoney }" pattern="0.00" maxFractionDigits="2"/> </h3>
								<small>库存总金额</small>
							</div>
							<div class="icon">
								<i class="icon-pie-chart"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<div class="dashboard-stat2">
						<div class="display">
							<div class="number">
								<h3 class="font-red-haze"><fmt:formatNumber type="number" value="${total.soleTotalMoney }" pattern="0.00" maxFractionDigits="2"/></h3>
								<small>本月销售总金额</small>
							</div>
							<div class="icon">
								<i class="icon-like"></i>
							</div>
						</div>
						
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<div class="dashboard-stat2">
						<div class="display">
							<div class="number">
								<h3 class="font-blue-sharp"><fmt:formatNumber type="number" value="${total.purchaseTotalMoeny }" pattern="0.00" maxFractionDigits="2"/></h3>
								<small>本月进货总金额</small>
							</div>
							<div class="icon">
								<i class="icon-basket"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<div class="dashboard-stat2">
						<div class="display">
							<div class="number">
								<h3 class="font-purple-soft"><fmt:formatNumber type="number" value="${total.netMoeny }" pattern="0.00" maxFractionDigits="2"/></h3>
								<small>本月净利润</small>
							</div>
							<div class="icon">
								<i class="icon-user"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
</Layout:overwrite>
<%-- <Layout:overwrite name="MyScript"></Layout:overwrite> --%>

<%@ include file="/share/_LayoutB.jsp"%>