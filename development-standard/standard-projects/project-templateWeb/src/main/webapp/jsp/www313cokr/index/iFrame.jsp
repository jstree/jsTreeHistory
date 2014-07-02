<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" autoFlush="true"%>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html> 
<!--[if lt IE 7 ]> <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie6 older"> <![endif]-->
<!--[if IE 7 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie7 older"> <![endif]-->
<!--[if IE 8 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie8"> <![endif]-->
<!--[if IE 9 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="ko-KR">
<!--<![endif]-->

<head>
<!-- Style Setting -->
<style type="text/css">
div#iframeWrapper{
	position:		relative;
	width:			974px;
	height:		100%;
	margin: 		0;
	padding: 		0;
	left:			3px;
}
</style>

<script type="text/javascript">
// <![CDATA[
// ]]>
</script>


</head> 
<body> 
<!-- ******************************* menu.jsp start***-->
<div id="iframeWrapper">
	<% 
		String requestUrlString = "";
		if(request.getParameter("wr_id")!=null){
			requestUrlString = request.getParameter("url") + "&wr_id=" + request.getParameter("wr_id");
		}else{
			requestUrlString = request.getParameter("url");
		}
	%>
	<iframe 	src="<%=requestUrlString%>"
				width="100%" height="100%" id="iFrameLayer"
				frameborder="0" marginwidth="0" marginheight="0" align="top" 
				scrolling="auto"></iframe>
</div>
<!-- ******************************* menu.jsp end***-->
</body>
</html> 