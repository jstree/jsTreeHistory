<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쪽지 보내기</title>
<link href="${pageContext.request.contextPath}/assets/css/backbone.scss.css?20" rel="stylesheet" type="text/css" media="all" />
<!-- !!!  FOR THIS PAGE ONLY !!! -->
<link href="${pageContext.request.contextPath}/assets/css/common_popup.css" rel="stylesheet" type="text/css" media="all">
</head>
<body>
	<div class="container clearfix">
		<div class="one-whole boxed">
			<header>
				<h2>쪽지 보내기</h2>
			</header>
			<section class="">
				<div>
					<div class="item-name">수신자</div>
					<div class="item-value">펜펜</div>
				</div>
				<div>
					<div class="item-name">제목</div>
					<div class="item-value"><input/></div>
				</div>
				<div>
					<div class="item-name">내용</div>
					<div class="item-value"><textarea></textarea></div>
				</div>
				<div>
					<button id="closeBtn" onclick="javascript: window.close();">보내기</button>
				</div>
			</section>
		</div>
	</div>
</body>
</html>