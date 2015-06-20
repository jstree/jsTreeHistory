<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 보기</title>
<link href="${pageContext.request.contextPath}/assets/css/backbone.scss.css?20" rel="stylesheet" type="text/css" media="all" />
<!-- !!!  FOR THIS PAGE ONLY !!! -->
<link href="${pageContext.request.contextPath}/assets/css/common_popup.css" rel="stylesheet" type="text/css" media="all">
</head>
<body>
	<div class="container clearfix">
		<div class="one-whole boxed">
		
			<header>
				<h2>회원 정보</h2>
			</header>
			<section class="">
			<c:choose>
				<c:when test="${user.indiInfoOpenFl == '0'}">
				<div>
					<div class="item-name">닉네임</div>
					<div class="item-value">${user.c_title}</div>
				</div>
				
				<div>
					<div class="item-name">이메일</div>
					<div class="item-value"><a href="mailto:${user.email}">${user.email}</a></div>
				</div>
				<div>
					<div class="item-name">홈페이지</div>
					<div class="item-value"><a href="${user.homepageUrl}">${user.homepageUrl}</a></div>
				</div>
				<div>
					<div class="item-name">블로그</div>
					<div class="item-value"><a href="${user.blogUrl}">${user.blogUrl}</a></div>
				</div>
				</c:when>
				<c:otherwise>
				<h3>정보 비공개 회원입니다.</h3>
				</c:otherwise>
			</c:choose>
				<div>
					<button id="closeBtn" onclick="javascript: window.close();">닫기</button>
				</div>
			</section>
		</div>
	</div>
</body>
</html>