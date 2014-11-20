<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false" body-content="scriptless" description="NAS 연동 Script 출력 태그"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ attribute name="theRestOfFileName" %>

<c:choose>
	<c:when test="${pageContext.request.serverName=='localhost'}">
		<script type="text/javascript" src='http://localhost:8080/js${theRestOfFileName}' charset="utf-8"></script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript" src='http://nas.313.co.kr:5002/js${theRestOfFileName}' charset="utf-8"></script>
	</c:otherwise>
</c:choose>