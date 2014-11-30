<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head>
		<script type="text/javascript">
			$(function(){
				$("a").click(function(event){
					//event.preventDefault(); 메뉴 링크가 먹지 않아 주석처리
				});
				
				$.ajax({
					 async : false
					,type: 'GET'
					,url: "${pageContext.request.contextPath}/sub/committerScheduleMonthList.do"
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
		<section id="template-article-liquid" class="clearfix" role="main" itemscope itemtype="http://schema.org/Article">
			<nav>
				<div class="container bm-medium">
					<div class="one-whole">
						<div class="no-display">article</div>
						<div class="text-center">
							<h1 class="bm-remove">
								커미터 일정관리
							</h1>
							<p class="bm-remove">
								<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
								&nbsp;/&nbsp;
								About Us
								&nbsp;/&nbsp;
								Schedule Management
							</p>							
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
		</section>
	</body>
</html>
