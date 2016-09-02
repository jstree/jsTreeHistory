<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" autoFlush="true"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>
<!DOCTYPE html>
<html lang="ko" class="no-js">
	<head data-placeholder-focus="false" data-placeholder-live="false">
		<c:choose>
			<c:when test="${pageContext.request.serverName=='localhost'||pageContext.request.serverName=='127.0.0.1'}">
				<jsp:include page="/WEB-INF/jsp/community/common/script.inc.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="/WEB-INF/jsp/community/common/script.inc.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
		<title><decorator:title default="JsTree 아키텍쳐, 바로보드 Java 설치형 게시판 솔루션, 오픈소스 313 자바 개발자 그룹 커뮤니티" /></title>	
		<page:applyDecorator name="headPanel" page="/WEB-INF/jsp/sitemesh/style.jsp"/>
		<page:applyDecorator name="headPanel" page="/WEB-INF/jsp/sitemesh/script.jsp"/>
		<decorator:head/>
		<!-- CSS Setting -->
		<link rel="icon" href="${pageContext.request.contextPath}/assets/images/community/common/favicon/favicon.ico" type="image/x-icon" />
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/community/common/favicon/favicon.ico" type="image/x-icon" />
		<script type="text/javascript">
		// <![CDATA[
		$(document).ready(function($){
		
		});
		// ]]>
		</script>				
	</head>
	<body class="template-index">
		<div class="page-border clearfix">
			<decorator:body/>
		</div>
	</body>
</html>