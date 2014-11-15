<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" autoFlush="true"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 국제화 : 지역별 메세지 및 숫자,날짜 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- Core : 변수, 흐름제어, url처리 -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %><!-- DB  -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><!-- 함수 : collection, String 처리  -->
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %><!-- XML처리 -->

<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>
<!DOCTYPE html>
<!-- Nero v1.1, Copyright 2014, Cloud Eight, https://www.cloud-eight.com -->

<!--[if lt IE 7 ]><html class="no-js ie ie6" lang="ko"><![endif]-->
<!--[if IE 7 ]><html class="no-js ie ie7" lang="ko"><![endif]-->
<!--[if IE 8 ]><html class="no-js ie ie8" lang="ko"><![endif]-->
<!--[if IE 9 ]><html class="no-js ie ie9" lang="ko"><![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head data-placeholder-focus="false" data-placeholder-live="false">
		<c:choose>
			<c:when test="${pageContext.request.serverName=='localhost'||pageContext.request.serverName=='127.0.0.1'}">
				<jsp:include page="/jsp/www313cokr/index/meta/script.inc.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="/jsp/www313cokr/index/meta/script.inc.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
		<title><decorator:title default="This page has been using the SiteMesh template engine." /></title>	
		<page:applyDecorator name="headPanel" page="/WEB-INF/jsp/sitemesh/resource.jsp"/>
		<script type="text/javascript">
		// <![CDATA[
		$(document).ready(function($){
		
		});
		// ]]>
		</script>				
	</head>
	<body id="dongmin-lee" class="template-index" itemscope itemtype="http://schema.org/WebPage">
		<div id="fb-root"></div>
		<page:applyDecorator name="bodyPanel" page="/WEB-INF/jsp/sitemesh/embededScript.jsp"/>
		<div class="page-border clearfix">
			<page:applyDecorator name="bodyPanel" page="/WEB-INF/jsp/sitemesh/header.jsp"/>
			<page:applyDecorator name="bodyPanel" page="/WEB-INF/jsp/sitemesh/navigation.jsp"/>
			<decorator:body/>
			<page:applyDecorator name="bodyPanel" page="/WEB-INF/jsp/sitemesh/footer.jsp"/>
		</div>
		<page:applyDecorator name="bodyPanel" page="/WEB-INF/jsp/sitemesh/no_display.jsp"/>
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
<iframe allowTransparency="true" frameborder="0" id="admin_bar_iframe" src="https://dongmin-lee.myshopify.com/admin/bar?u=http://dongmin-lee.myshopify.com/" style="height: 40px; position: fixed; top: 0; left: 0; right: 0; z-index: 2147483647; background: #191919" width="100%">{}</iframe>