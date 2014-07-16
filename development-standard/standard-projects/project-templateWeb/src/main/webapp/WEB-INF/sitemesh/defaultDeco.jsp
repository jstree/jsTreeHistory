<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" autoFlush="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 국제화 : 지역별 메세지 및 숫자,날짜 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- Core : 변수, 흐름제어, url처리 -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %><!-- DB  -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><!-- 함수 : collection, String 처리  -->
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %><!-- XML처리 -->

<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<!--[if lt IE 7 ]> <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie6 older" style="width:100%;height:100%;margin:0;padding:0;"> <![endif]-->
<!--[if IE 7 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie7 older" style="width:100%;height:100%;margin:0;padding:0;"> <![endif]-->
<!--[if IE 8 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie8" style="width:100%;height:100%;margin:0;padding:0;"> <![endif]-->
<!--[if IE 9 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie9" style="width:100%;height:100%;margin:0;padding:0;"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="ko-KR" style="width:100%;height:100%;margin:0;padding:0;">
<!--<![endif]-->
<head>
<c:choose>
	<c:when test="${pageContext.request.serverName=='localhost'||pageContext.request.serverName=='127.0.0.1'}">
		<jsp:include page="/jsp/www313cokr/index/meta/script.inc.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="/jsp/www313cokr/index/meta/script.inc.jsp"></jsp:include>
	</c:otherwise>
</c:choose>

<title><decorator:title default="본 페이지는 사이트메쉬 템플릿 엔진을 사용하였습니다." /></title>

<!-- CSS Setting -->
<link rel="icon" href="./favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="./favicon.ico" type="image/x-icon" />

<decorator:head/>

<script type="text/javascript">
// <![CDATA[
$(document).ready(function($){

});
// ]]>
</script>

</head> 

<body style="width:100%; height:100%;margin:0;padding:0;">

<decorator:body />

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
</body>
</html> 