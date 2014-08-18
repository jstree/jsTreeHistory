<%
 /**
  * @Class Name : EgovMobileDeviceIdent.jsp
  * @Description : EgovMobileDeviceIdent 화면
  * @Modification Information
  * @
  * @  수정일   	수정자		수정내용
  * @ ----------	------		---------------------------
  * @ 2011.08.11	정홍규		최초 생성
  *
  *  @author 정홍규 
  *  @since 2011.08.11
  *  @version 1.
  *  @see
  *  
  */
%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html> 
<head> 
<title>모바일 화면</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
        
	<!-- eGovFrame Common import -->
	<link rel="stylesheet" href="<c:url value='/css/egovframework/mbl/cmm/jquery.mobile-1.3.2.css'/>"/>
	<link rel="stylesheet" href="<c:url value='/css/egovframework/mbl/cmm/EgovMobile-1.3.2.css'/>"/>
	<script type="text/javascript" src="<c:url value='/js/egovframework/mbl/cmm/jquery-1.9.1.js'/>"></script>
	
		
	<script type="text/javascript" src="<c:url value='/js/egovframework/mbl/cmm/jquery.mobile-1.3.2.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/egovframework/mbl/cmm/EgovMobile-1.3.2.js'/>"></script>
	
	<!-- 신규공통컴포넌트 import -->
	<link rel="stylesheet" href="<c:url value='/css/egovframework/mbl/mcomd/egovMcomd.css'/>"/>
	<script type="text/javascript">
		var contextPath = "${pageContext.request.contextPath}";
	</script>
	<script type="text/javascript" src="<c:url value='/js/egovframework/mbl/com/mdi/mdi.js'/>"></script>
</head>

<body onLoad="fn_egov_initl_mobileDeviceInfolist();">

	<!--리스트 페이지 -->
	<div id="deviceIdent" data-role="page" data-theme="d">
		<div data-role="header" data-position="inline" data-theme="z">
		    <a href="<c:url value='/index.jsp'/>" data-ajax="false" data-icon="home" class="ui-btn-left">메인</a>
			<h1><img src="<c:url value='/images/egovframework/mbl/mcomd/h1_logo.png'/>"/></h1>
			<div class="ui-body-a mcomd-title"><h3>모바일 기기 식별</h3></div>
		</div>
		
		<div data-role="content">
			<form name="DeviceIdentForm" method="post">
				<ul data-role="deviceidentview">
				</ul>
			</form>
		</div>
		
		<div data-role="footer" data-theme="z" data-position="fixed" class="egovBar">
			<h4>Copyright(c)2011 Ministry of republic administration and security.</h4>
		</div>
	</div>

</body>
</html>