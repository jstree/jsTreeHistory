<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
	<head></head>
	<body>
		<header class="clearfix">
			<div id="header" class="container">
				<div id="header-search" class="one-third bm-remove">
					<form action="${pageContext.request.contextPath}/" method="get" class="clearfix" novalidate>
						<input type="hidden" name="type" value="product">
						<input type="text" name="q" class="inline-block w-small bm-remove tip-r-fade" placeholder="KEYWORD SEARCH" autocomplete="off" value="" data-tooltip="Press Enter To Search" />
						<button type="submit" class="tablet-mobile bm-remove tip-r-fade" data-tooltip="Search">
						<i class="fa fa-search"></i>
						</button>
					</form>
				</div>
				<div id="header-logo" class="one-third bm-remove">
					<a href="${pageContext.request.contextPath}/" target="_self">
						<c:set var="logPath" value="${logUrl}" />
						<img src="${pageContext.request.contextPath}${logPath}" alt="313 developer group logo">
					</a>
				</div>
				<div id="header-cart" class="one-third bm-remove last">
					<c:choose>
						<c:when test="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username == null}">
						  <c:url value="${pageContext.request.contextPath}/account/accountSign.do" var="SignInUrl" />
							<a href="${SignInUrl}" target="_self">
								Sign In
							</a>
						</c:when>
						<c:otherwise>
						  <c:url value="${pageContext.request.contextPath}/user/login/logout.do" var="logoutUrl" />
							<a href="${logoutUrl}" target="_self">
								Log Out
							</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</header>
	</body>
</html>
