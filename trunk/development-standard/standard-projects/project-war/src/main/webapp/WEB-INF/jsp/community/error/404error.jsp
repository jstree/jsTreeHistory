<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head></head>
	<body>
		<section class="clearfix">
			<div class="container bm-medium">
				<div class="one-whole">
					<div class="text-center">
						<h1 class="bm-remove">
							Page Not Found
						</h1>
						<p class="bm-remove">
							<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
							&nbsp;/&nbsp;
							Error
						</p>
					</div>
				</div>
			</div>
			<div class="clearfix">
				<div class="container bm-medium">
					<div class="one-whole boxed p-twenty animate-in clearfix text-center" data-anim-type="fade-in" data-anim-delay="0">
						<h4>요청한 페이지를 찾을 수 없습니다.</h4>
						<p class="bm-larger tm-larger text-center">
							찾으시려는 페이지의 이름이 변경되었거나, 존재하지 않는 페이지입니다.<br /> 
							입력하신 페이지 주소가 정확한지 다시 한번 확인해주십시오. <br />
							<br />
							<a href="javascript:history.back()" target="_self">이전 페이지로 돌아가기</a><br />
						</p>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>
