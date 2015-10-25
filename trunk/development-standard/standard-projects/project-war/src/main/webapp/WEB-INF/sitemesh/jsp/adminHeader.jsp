<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="${pageContext.request.contextPath}/user/login/logout.do" var="logoutUrl" />
<!DOCTYPE html>
<html lang="ko" class="no-js">
	<head></head>
	<body>
		<header class="clearfix">
			<div id="header" class="container">
				<div id="header-logo" class="one-third bm-remove">
					<a href="#" target="_self">
						<img src="${pageContext.request.contextPath}/assets/images/logo.jpg" alt="313 developer group logo">
					</a>
				</div>
				<div id="header-admin" class="one-third bm-remove">
					<ul>
						<li>
							<a>BaroBoard Admin</a>
						</li>
						<li>
							<a id="breadcrumb">Sample/JSTREE</a>
						</li>
					</ul>
				</div>
				<div id="header-cart" class="one-third bm-remove last">
					<a href="#" target="_self">${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.nickName}</a>
					<span>|</span>
					<a href="${logoutUrl}" target="_self">로그아웃</a>
				</div>
				<hr id="r">
			</div>
		</header>
	</body>
</html>
