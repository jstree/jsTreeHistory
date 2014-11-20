<%
/**
 * 	통합 서비스의 Index 페이지 입니다. 
 * 	JSP 페이지의 파일 Name은 소문자로 시작합니다
 * 	JSTL을 적극적으로 사용합니다.
 * 	본 페이지에서는 ajax/common.js 파일을 보시면 무엇을 로드하여 div에 맵핑하는지 알수 있습니다.
 *
 * 	@author : 이동민
 * 	@date   : 2011. 4. 15.
 * 	-------------------------- Modification Log ------------------------------------
 * 	Ver No   	Date           	Author           	Modification
 *	0.0.1  		2011. 04. 15.    	이동민 				Initial Version
 *  0.0.1  		2012. 01. 04.    	이동민 				khld.co.kr 과 313.co.kr 의 사이트는 같은 사이트인것으로 간주하여 개발한다.
 *  0.0.1  		2012. 01. 04.    	이동민 				DaesungGlobal의 사이트는 아이피로 서비스가 구분되어야 한다. 향후 domain 정책의 변경이 필요하다.
 */
%>

<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.com/jquery-1.5.2.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/design/css/common.css" media="screen"/>
<link rel="stylesheet" type="text/css" media="screen" href="themes/redmond/jquery-ui-1.8.2.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="themes/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" media="screen" href="themes/ui.multiselect.css" />

<script src="js/jquery-ui-1.8.2.custom.min.js" type="text/javascript"></script>
<script src="js/jquery.layout.js" type="text/javascript"></script>
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="js/jquery.tablednd.js" type="text/javascript"></script>
<script src="js/jquery.contextmenu.js" type="text/javascript"></script>
<script src="js/ui.multiselect.js" type="text/javascript"></script>


<table id="list2"></table>
<div id="pager2" ></div>
<script src="jsonex.js" type="text/javascript"> </script>