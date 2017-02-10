<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/html" id="warnStockTemplate">
<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<i class="icon-bell"></i>
						<span class="badge badge-danger">
						{{obj.length}} </span>
						</a>
						<ul class="dropdown-menu">
							<li class="external">
								<h3>您有<span class="bold">{{obj.length}} 条</span>库存警告</h3>
							</li>
							<li>
								<ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
									{{each obj}}
									<li>
										<a href="javascript:void(0)">
										<span class="photo">
											{{$value.brandName}}
										</span>
										<span class="subject">
										<span class="from">
										{{$value.productName}}</span><br>
										<span class="">
										库存：{{$value.num}},库存不足,警告值：{{$value.warnNum}}</span><br>
										<span class="">{{$value.modifyTime | dateFormat:'yyyy年 MM月 dd日 hh:mm'}}</span>
										</span>
										
										</a>
									</li>
									{{/each}}
								</ul>
							</li>
						</ul>
		</script>