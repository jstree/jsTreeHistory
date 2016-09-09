<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false"
	body-content="scriptless" trimDirectiveWhitespaces="true" description="NAS 연동 CSS 출력 태그"%><%@ taglib
	prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><c:set
	var="osName" value="<%=System.getProperty(\"os.name\")%>" />
<c:set var="osName" value="${fn:toLowerCase(osName)}" />
<c:choose>
	<c:when test="${ fn:indexOf(osName, 'win') != -1 }">
		&#13;&#10;
	</c:when>
	<c:when
		test="${ fn:indexOf(osName, 'nux') != -1 or fn:indexOf(osName, 'nix') != -1 or fn:indexOf(osName, 'aix') != -1 or fn:indexOf(osName, 'sunos') != -1 }">
		&#10;
	</c:when>
	<c:when test="${ fn:indexOf(osName, 'mac') != -1 }">
		&#13;
	</c:when>
</c:choose>