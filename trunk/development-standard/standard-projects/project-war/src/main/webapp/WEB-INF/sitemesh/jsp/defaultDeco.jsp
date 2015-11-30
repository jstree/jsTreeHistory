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
<!--[if lt IE 7 ]> <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie6 older"> <![endif]-->
<!--[if IE 7 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie7 older"> <![endif]-->
<!--[if IE 8 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie8"> <![endif]-->
<!--[if IE 9 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]>	<html lang="ko" class="no-js"> <![endif]-->
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
		<page:applyDecorator name="headPanel" page="/WEB-INF/sitemesh/jsp/style.jsp"/>
		<page:applyDecorator name="headPanel" page="/WEB-INF/sitemesh/jsp/script.jsp"/>
		<decorator:head/>
		<script type="text/javascript">
		// <![CDATA[
		$(document).ready(function($){
		
		});
		// ]]>
		</script>				
	</head>
	<body class="template-index">
		<div class="page-border clearfix">
			<page:applyDecorator name="bodyPanel" page="/WEB-INF/sitemesh/jsp/header.jsp"/>
			<page:applyDecorator name="bodyPanel" page="/WEB-INF/sitemesh/jsp/navigation.jsp"/>
			<decorator:body/>
			<page:applyDecorator name="bodyPanel" page="/WEB-INF/sitemesh/jsp/no-display.jsp"/>
			<page:applyDecorator name="bodyPanel" page="/WEB-INF/sitemesh/jsp/footer.jsp"/>
		</div>
		<!-- ANALYTICS START -->
		<!-- https://www.google.com/analytics/settings/home?scid=18527803 web log Analyzer  -->
		<script type="text/javascript">
			//<![CDATA[
			var _gaq = _gaq || [];
			_gaq.push(['_setAccount', 'UA-18527803-1']);
			_gaq.push(['_trackPageview']);
			_gaq.push(['_trackPageLoadTime']);
			(function() {
			var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
			})();
			//]]>
		</script>
		<!-- ANALYTICS END -->
		<!-- Piwik -->
		<script type="text/javascript"> 
			var _paq = _paq || [];
			_paq.push(['trackPageView']);
			_paq.push(['enableLinkTracking']);
			(function() {
			  var u=(("https:" == document.location.protocol) ? "https" : "http") + "://www.313.co.kr/php/piwik-1.12/";
			  _paq.push(['setTrackerUrl', u+'piwik.php']);
			  _paq.push(['setSiteId', 1]);
			  var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0]; g.type='text/javascript';
			  g.defer=true; g.async=true; g.src=u+'piwik.js'; s.parentNode.insertBefore(g,s);
			})();
		</script>
		<noscript><p><img src="http://www.313.co.kr/php/piwik-1.12/piwik.php?idsite=1" style="border:0" alt="" /></p></noscript>
		<!-- End Piwik Code -->
		<!-- NAVER ANALYTICS START -->
		<script type="text/javascript" src="http://wcs.naver.net/wcslog.js"></script>
		<script type="text/javascript">
			if(!wcs_add) var wcs_add = {};
			wcs_add["wa"] = "1244b972beb34c";
			wcs_do();
		</script>
		<!-- NAVER ANALYTICS END -->
	</body>
</html>