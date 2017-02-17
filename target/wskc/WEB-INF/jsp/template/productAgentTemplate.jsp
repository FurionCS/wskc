<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>  
<script type="text/html" id="productAgentTemplate">
	<div class="row">
			<div class="col-md-8 col-xs-12 ">
							<!-- BEGIN SAMPLE FORM PORTLET-->
							<div class="portlet light">
									<div class="caption font-green">
										<span class="caption-subject bold uppercase">产品编码:<a href="../stock/productAgent?menuids=6_2&productId={{productId}}">{{code}}</a></span>
									</div>
									<hr style="padding:0;margin:5px 0 0 0;">
								<div class="portlet-body form">
								<div class="row">
										<div class="col-md-8 col-sm-12 col-xs-12">
												<div class="portlet-body">
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
																产品名称
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 {{productName}} 
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 品牌名称
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 {{brandName}}
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															产品规格
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															{{size}}
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 代理总库存
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															{{totalNum}}
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 最大库存
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
																{{maxNum}} 
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 最小库存
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															{{minNum}} 
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
</script>
