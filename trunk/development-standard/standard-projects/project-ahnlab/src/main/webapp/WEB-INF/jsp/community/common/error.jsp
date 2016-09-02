<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<page:applyDecorator name="default">
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
							Page ERROR
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
						<h4>어플리케이션에서 에러가 발생하였습니다.</h4>
						<p class="bm-larger tm-larger text-center">
							요청을 처리하지 못하고 에러가 발생하였습니다.
							<br />
							해당 에러는 자동으로 서버에 기록되며,
							<br />
							기록된 에러는 자동으로 관리자 및 개발자에게 통지됩니다.
							<br />
							<a href="javascript:history.back()" target="_self">이전 페이지로 돌아가기</a><br />
						</p>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>
</page:applyDecorator>