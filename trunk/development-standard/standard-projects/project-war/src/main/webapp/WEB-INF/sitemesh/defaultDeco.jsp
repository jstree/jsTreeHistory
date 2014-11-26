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
		<title><decorator:title default="313 Developer Group page has been using the SiteMesh template engine." /></title>	
		<page:applyDecorator name="headPanel" page="/WEB-INF/jsp/sitemesh/style.jsp"/>
		<page:applyDecorator name="headPanel" page="/WEB-INF/jsp/sitemesh/script.jsp"/>
		<decorator:head/>
		<!-- CSS Setting -->
		<link rel="icon" href="${pageContext.request.contextPath}/images/community/common/favicon/favicon.ico" type="image/x-icon" />
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/community/common/favicon/favicon.ico" type="image/x-icon" />
		<script type="text/javascript">
		// <![CDATA[
		$(document).ready(function($){
		
		});
		// ]]>
		</script>				
	</head>
	<body class="template-index">
		<div class="page-border clearfix">
			<page:applyDecorator name="bodyPanel" page="/WEB-INF/jsp/sitemesh/header.jsp"/>
			<page:applyDecorator name="bodyPanel" page="/WEB-INF/jsp/sitemesh/navigation.jsp"/>
			<decorator:body/>
			<page:applyDecorator name="bodyPanel" page="/WEB-INF/jsp/sitemesh/no-display.jsp"/>
			<page:applyDecorator name="bodyPanel" page="/WEB-INF/jsp/sitemesh/footer.jsp"/>
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
			  var u=(("https:" == document.location.protocol) ? "https" : "http") + "://www.313.co.kr/php/piwik-1.12//";
			  _paq.push(['setTrackerUrl', u+'piwik.php']);
			  _paq.push(['setSiteId', 1]);
			  var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0]; g.type='text/javascript';
			  g.defer=true; g.async=true; g.src=u+'piwik.js'; s.parentNode.insertBefore(g,s);
			})();
		</script>
		<noscript><p><img src="http://www.313.co.kr/php/piwik-1.12/piwik.php?idsite=1" style="border:0" alt="" /></p></noscript>
		<!-- End Piwik Code -->		
	</body>
</html>