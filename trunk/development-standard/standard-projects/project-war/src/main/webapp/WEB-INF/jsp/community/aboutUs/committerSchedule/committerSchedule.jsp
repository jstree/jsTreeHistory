<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head>
		<script type="text/javascript">
			$(function(){
				$.ajax({
					 async : false
					,type: 'GET'
					,url: "${pageContext.request.contextPath}/committerScheduleMonthList.do"
					,data : {}
					,success : function (page) {
						$("#contentsBody").html(page);
					}
					,error : function(e){
					}
				});
			});
		</script>	
	</head>
	<body>
		<main id="template-article-liquid" class="clearfix" role="main" itemscope itemtype="http://schema.org/Article"><nav>
				<div class="container bm-medium">
					<div class="one-whole">
						<div class="no-display">article</div>
						<div class="text-center">
							<h1 class="bm-remove">
								커미터 일정관리
							</h1>
						</div>
					</div>
				</div>
			</nav>
			<article>
				<div class="clearfix">
					<div class="container bm-remove">
						<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
							<div class="article-body rte" id="contentsBody"></div>
						</div>
					</div>
				</div>
			</article>
		</main>
	</body>
</html>
