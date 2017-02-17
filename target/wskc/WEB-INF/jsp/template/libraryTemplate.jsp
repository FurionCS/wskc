<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>  
<script type="text/html" id="libraryTemplate">
	<div class="row">
			<div class="col-md-8 col-xs-12 ">
							<!-- BEGIN SAMPLE FORM PORTLET-->
							<div class="portlet light">
									<div class="caption font-green">
										<span class="caption-subject bold uppercase">出库编码:<a href="../library/showLibrary?menuids=5_2&id={{id}}">{{libraryNo}}</a></span>
									</div>
									<hr style="padding:0;margin:5px 0 0 0;">
								<div class="portlet-body form">
								<div class="row">
										<div class="col-md-8 col-sm-12 col-xs-12">
												<div class="portlet-body">
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
																出库类型
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 {{type}} 
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 出库产品
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															 {{productName}}
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 商品总价
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															{{num}}*{{price}}=￥{{num*price | doubleFormat}} (数量*单价)
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 状态
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															<span class="label label-success">
																{{status | statusFormat}} 
															</span>
														</div>
													</div>
													<div class="row static-info">
														<div class="col-md-5 col-sm-5  col-xs-5 name">
															 创建时间
														</div>
														<div class="col-md-7 col-sm-7 col-xs-7 value">
															{{createTime | dateFormat:'yyyy年 MM月 dd日 hh:mm:ss'}}
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
