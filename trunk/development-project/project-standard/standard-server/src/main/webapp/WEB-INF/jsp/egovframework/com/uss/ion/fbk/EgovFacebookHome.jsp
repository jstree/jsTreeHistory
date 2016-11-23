<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" autoFlush="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<%@ page session="false" %>
<%

/**
 * @Class Name : EgovFacebookHome.jsp
 * @Description : EgovFacebookHome.jsp
 * @Modification Information
 * @
 * @  수정일             수정자              수정내용
 * @ ---------     -----------------    -------------------------
 * @ 2014.11.10    표준프레임워크센터        최초생성
 *
 *  @author 표준프레임워크센터
 *  @since 2014.11.10
 *  @version 1.0
 *  @see
 *
 *  Copyright (C) 2014 by MOGAHA  All right reserved.
 */

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/css/egovframework/com/com.css' />" rel="stylesheet" type="text/css">
<link href="<c:url value='/css/egovframework/com/button.css' />" rel="stylesheet" type="text/css">
<title>Facebook 기능목록</title>
</head>
<body>
    <div id="border" style="width:730px">
    	<ul>
    		<li><span class="button"><a href="<c:url value="/uss/ion/fbk/feed.do" />">Feed</a></span></li>
    		<li><span class="button"><a href="<c:url value="/uss/ion/fbk/albums.do" />">Albums</a></span></li>
    		<li><span class="button"><a href="<c:url value="/uss/ion/fbk/profile.do" />">Profile</a></span></li>
    		<li><span class="button"><a href="<c:url value="/uss/ion/fbk/facebookSignout.do" />">Sign Out</a></span></li>
    	</ul>
    </div>
</body>
</html>