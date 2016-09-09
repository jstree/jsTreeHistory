<%--
/**
 * @Class Name  : EgovMainImageUpdt.java
 * @Description : EgovMainImageUpdt jsp
 * @Modification Information
 * @
 * @  수정일         수정자          수정내용
 * @ -------    --------    ---------------------------
 * @ 2009.02.01    lee.m.j          최초 생성
 *
 *  @author lee.m.j
 *  @since 2009.03.11
 *  @version 1.0
 *  @see
 *  
 *  Copyright (C) 2009 by MOPAS  All right reserved.
 */
 --%>

<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/css/egovframework/com/cmm/com.css' />" rel="stylesheet" type="text/css">
<link href="<c:url value='/css/egovframework/com/cmm/button.css' />" rel="stylesheet" type="text/css">
<title>사용자부재 수정</title>
<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/fms/EgovMultiFile.js'/>"></script>
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="mainImage" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javaScript" language="javascript">

function fncSelectUserAbsnceList() {
    var varFrom = document.getElementById("userAbsnce");
    varFrom.action = "<c:url value='/uss/ion/uas/selectUserAbsnceList.do'/>";
    varFrom.submit();       
}

function fncUserAbsnceUpdate() {


    var varFrom = document.getElementById("userAbsnce");
    varFrom.action = "<c:url value='/uss/ion/uas/updtUserAbsnce.do'/>";

    if(confirm("저장 하시겠습니까?")){
        varFrom.submit();
    }
}

function fncUserAbsnceDelete() {
    var varFrom = document.getElementById("userAbsnce");
    varFrom.action = "<c:url value='/uss/ion/uas/removeUserAbsnce.do'/>";
    if(confirm("삭제 하시겠습니까?")){
        varFrom.submit();
    }
}

</script>
</head>

<body>
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>
<div id="border" style="width:730px">
<table border="0">
  <tr>
    <td width="700">
<form:form commandName="userAbsnce" action="${pageContext.request.contextPath}/uss/ion/uas/updtUserAbsnce.do' />" method="post">  
<table width="100%" cellpadding="8" class="table-search" border="0">
 <tr>
  <td width="40%" class="title_left">
   <h1><img src="<c:url value='/images/egovframework/com/cmm/icon/tit_icon.gif' />" width="16" height="16" hspace="3" align="middle" alt="제목아이콘이미지">&nbsp;사용자부재 수정</h1>
  </td>
 </tr>
</table>

<table width="100%" cellpadding="8" class="table-line" summary="사용자부재정보를 수정한다.">
  <caption>사용자부재 수정</caption>
  <tr>
    <th class="required_text" width="20%" scope="row" nowrap>사용자ID<img src="<c:url value='/images/egovframework/com/cmm/icon/required.gif' />" width="15" height="15" alt="필수입력표시"></th>
    <td class="lt_text" nowrap><input name="userId" id="userId" title="사용자ID" type="text" value="<c:out value='${userAbsnce.userId}'/>" size="30" class="readOnlyClass" readonly></td>
  </tr>
  <tr>
    <th class="required_text" width="20%" scope="row" nowrap>사용자명<img src="<c:url value='/images/egovframework/com/cmm/icon/required.gif' />" width="15" height="15" alt="필수입력표시"></th>
    <td class="lt_text" nowrap><input name="userNm" id="userNm" title="사용자명" type="text" value="<c:out value='${userAbsnce.userNm}'/>" maxLength="50" size="30"  class="readOnlyClass" readonly></td>
  </tr>
  <tr>
    <th class="required_text" width="20%" scope="row" nowrap>부재여부<img src="<c:url value='/images/egovframework/com/cmm/icon/required.gif' />" width="15" height="15" alt="필수입력표시"></th>
    <td class="lt_text" nowrap>
      <select name="userAbsnceAt" id="userAbsnceAt" title="부재여부">
          <option value="Y" <c:if test="${userAbsnce.userAbsnceAt == 'Y'}">selected</c:if> >Y</option>
          <option value="N" <c:if test="${userAbsnce.userAbsnceAt == 'N'}">selected</c:if> >N</option>
      </select>
   </td> 
  </tr>
  <tr>
    <th class="required_text" width="20%" scope="row" nowrap>등록일시<img src="<c:url value='/images/egovframework/com/cmm/icon/no_required.gif' />" width="15" height="15" alt="선택입력표시"></th>
    <td class="lt_text" nowrap><input name="lastUpdusrPnttm" id="lastUpdusrPnttm" title="등록일시" type="text" value="<c:out value="${userAbsnce.lastUpdusrPnttm}"/>" maxLength="50" size="20" class="readOnlyClass" readonly></td>
  </tr>
</table>
 
<table width="100%" cellpadding="8">
  <tr>
    <td align="center">
	   <table border="0" cellspacing="0" cellpadding="0">
	    <tr> 
	      <td><span class="button"><input type="submit" value="<spring:message code="button.save" />" onclick="fncUserAbsnceUpdate(); return false;"></span></td>
	      <td>&nbsp;&nbsp;</td>
	      <td><span class="button"><a href="<c:url value='/uss/ion/uas/removeUserAbsnce.do'/>?userId=<c:out value='${userAbsnceVO.userId}'/>&amp;selAbsnceAt=<c:out value='${userAbsnceVO.selAbsnceAt}'/>" onclick="fncUserAbsnceDelete(); return false;"><spring:message code="button.delete" /></a></span></td>
	      <td>&nbsp;&nbsp;</td>
	      <td><span class="button"><a href="<c:url value='/uss/ion/uas/selectUserAbsnceList.do'/>?pageIndex=<c:out value='${userAbsnceVO.pageIndex}'/>&amp;searchKeyword=<c:out value="${userAbsnceVO.searchKeyword}"/>&amp;searchCondition=1&amp;selAbsnceAt=<c:out value="${userAbsnceVO.selAbsnceAt}"/>" onclick="fncSelectUserAbsnceList(); return false;"><spring:message code="button.list" /></a></span></td>
	    </tr>
	   </table>  
   </td>
  </tr>  
</table>
  
<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="<c:out value='${userAbsnceVO.searchCondition}'/>">
<input type="hidden" name="searchKeyword" value="<c:out value='${userAbsnceVO.searchKeyword}'/>">
<input type="hidden" name="pageIndex" value="<c:out value='${userAbsnceVO.pageIndex}'/>">
<input type="hidden" name="selAbsnceAt" value="<c:out value='${userAbsnceVO.selAbsnceAt}'/>">
</form:form>

</td>
</tr>
</table>

</DIV>
</body>
</html>

