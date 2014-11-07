<%--
  Class Name : EgovNoticeList.jsp
  Description : 게시물 목록화면
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2009.03.19   이삼섭          최초 생성
     2011.08.31   JJY       경량환경 버전 생성
 
    author   : 공통서비스 개발팀 이삼섭
    since    : 2009.03.19  
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="egovframework.com.cmm.service.EgovProperties" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ImgUrl" value="/images/egovframework/cop/bbs/"/>
<%-- <link href="<c:url value='/'/>css/common.css" rel="stylesheet" type="text/css" > --%>
<c:if test="${anonymous == 'true'}"><c:set var="prefix" value="/anonymous"/></c:if>
<script type="text/javascript" src="<c:url value='/js/EgovBBSMng.js' />" ></script>
<c:choose>
<c:when test="${preview == 'true'}">
<script type="text/javascript">
<!--
    function press(event) {
    }

    function fn_egov_addNotice() {
    }
    
    function fn_egov_select_noticeList(pageNo) {
    }
    
    function fn_egov_inqire_notice(nttId, bbsId) {      
    }
//-->
</script>
</c:when>
<c:otherwise>
<script type="text/javascript">
<!--
    function press(event) {
        if (event.keyCode==13) {
            fn_egov_select_noticeList('1');
        }
    }

    function fn_egov_addNotice() {
        document.frm.action = "<c:url value='/cop/bbs${prefix}/addBoardArticle.do'/>";
        document.frm.submit();
    }
    
    function fn_egov_select_noticeList(pageNo) {
        document.frm.pageIndex.value = pageNo;
        document.frm.action = "<c:url value='/cop/bbs${prefix}/selectBoardList.do'/>";
        document.frm.submit();  
    }
    
    function fn_egov_inqire_notice(nttId, bbsId) {
        document.subForm.nttId.value = nttId;
        document.subForm.bbsId.value = bbsId;
        document.subForm.action = "<c:url value='/cop/bbs${prefix}/selectBoardArticle.do'/>";
        document.subForm.submit();          
    }
    
    function tmpSelectArticle(selectedArticle){
    	selectedArticle.parentElement.submit();
    }
//-->
</script>
</c:otherwise>
</c:choose>
<!-- 전체 레이어 시작 -->

<!-- 검색 필드 박스 시작 -->
<div id="search_field">
	<form name="frm" action ="<c:url value='/cop/bbs${prefix}/selectBoardList.do'/>" method="post">
		<input type="hidden" name="bbsId" value="<c:out value='${boardVO.bbsId}'/>" />
		<input type="hidden" name="nttId"  value="0" />
		<input type="hidden" name="bbsTyCode" value="<c:out value='${brdMstrVO.bbsTyCode}'/>" />
		<input type="hidden" name="bbsAttrbCode" value="<c:out value='${brdMstrVO.bbsAttrbCode}'/>" />
		<input type="hidden" name="authFlag" value="<c:out value='${brdMstrVO.authFlag}'/>" />
		<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
		<fieldset>
		<legend>조건정보 영역</legend>
			<div class="sf_start">
				<select class="inline-block" name="searchCnd" class="select" title="검색조건 선택">
					<option value="0" <c:if test="${searchVO.searchCnd == '0'}">selected="selected"</c:if> >제목</option>
					<option value="1" <c:if test="${searchVO.searchCnd == '1'}">selected="selected"</c:if> >내용</option>             
					<option value="2" <c:if test="${searchVO.searchCnd == '2'}">selected="selected"</c:if> >작성자</option>            
				</select>
				<input class="inline-block" name="searchWrd" type="text" size="35" value='<c:out value="${searchVO.searchWrd}"/>' maxlength="35" onkeypress="press(event);" title="검색어 입력"> 
				<a class="button" href="#LINK" onclick="javascript:fn_egov_select_noticeList('1'); return false;">조회</a>
				<% if(null != session.getAttribute("LoginVO")){ %>
				<c:if test="${brdMstrVO.authFlag == 'Y'}">
				<a class="button" href="<c:url value='/cop/bbs${prefix}/addBoardArticle.do'/>?bbsId=<c:out value="${boardVO.bbsId}"/>">등록</a>
				</c:if>
				<%} %>
			</div>
		</fieldset>
	</form>
</div>
<!-- //검색 필드 박스 끝 -->
<!-- table add start -->
<div>
    <table summary="번호, 제목, 게시시작일, 게시종료일, 작성자, 작성일, 조회수   입니다" cellpadding="0" cellspacing="0">
    <caption>게시물 목록</caption>
    <colgroup>
	    <col width="10%">
	    <col>  
	    <c:if test="${brdMstrVO.bbsAttrbCode == 'BBSA01'}">
	    <col width="10%">
	    <col width="10%">
	    </c:if>
	    <c:if test="${anonymous != 'true'}">
	    <col width="10%">
	    </c:if>
	    <col width="15%">
	    <col width="8%">
    </colgroup>
    <thead>
	    <tr>
		    <th scope="col" nowrap="nowrap">번호</th>
		    <th scope="col" nowrap="nowrap">제목</th>
		    <c:if test="${brdMstrVO.bbsAttrbCode == 'BBSA01'}">
		    <th scope="col" nowrap="nowrap">게시시작일</th>
		    <th scope="col" nowrap="nowrap">게시종료일</th>
		    </c:if>
		    <c:if test="${anonymous != 'true'}">
		    <th scope="col" nowrap="nowrap">작성자</th>
		    </c:if>
		    <th scope="col" nowrap="nowrap">작성일</th>
		    <th scope="col" nowrap="nowrap">조회수</th>
	    </tr>
    </thead>
    <tbody>                 

    <c:forEach var="result" items="${resultList}" varStatus="status">
    <!-- loop 시작 -->                                
    <tr>
       <!--td class="lt_text3" nowrap="nowrap"><input type="checkbox" name="check1" class="check2"></td-->
       <td><b><c:out value="${paginationInfo.totalRecordCount+1 - ((searchVO.pageIndex-1) * searchVO.pageSize + status.count)}"/></b></td>            
       <td align="left">
           <form name="subForm" method="post" action="<c:url value='/cop/bbs${prefix}/selectBoardArticle.do'/>">
           <c:if test="${result.replyLc!=0}">
               <c:forEach begin="0" end="${result.replyLc}" step="1">
                   &nbsp;
               </c:forEach>
               <img src="<c:url value='/images/reply_arrow.gif'/>" alt="reply arrow"/>
           </c:if>
           <c:choose>
               <c:when test="${result.isExpired=='Y' || result.useAt == 'N'}">
                   <c:out value="${result.nttSj}" />
               </c:when>
               <c:otherwise>
                  <input type="hidden" name="bbsId" value="<c:out value='${result.bbsId}'/>" />
                  <input type="hidden" name="nttId"  value="<c:out value="${result.nttId}"/>" />
                  <input type="hidden" name="bbsTyCode" value="<c:out value='${brdMstrVO.bbsTyCode}'/>" />
                  <input type="hidden" name="bbsAttrbCode" value="<c:out value='${brdMstrVO.bbsAttrbCode}'/>" />
                  <input type="hidden" name="authFlag" value="<c:out value='${brdMstrVO.authFlag}'/>" />
                  <input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
<%--                   <input type="submit" style="width:320px;border:solid 0px black;text-align:left;" value="<c:out value="${result.nttSj}"/>" > --%>
                  <a href="#" onclick="test(this);" >
                  <c:out value="${result.nttSj}"/>
                  </a>
               </c:otherwise>
           </c:choose>
           </form>
       </td>
       <c:if test="${brdMstrVO.bbsAttrbCode == 'BBSA01'}">
           <td ><c:out value="${result.ntceBgnde}"/></td>
           <td ><c:out value="${result.ntceEndde}"/></td>
       </c:if>
       <c:if test="${anonymous != 'true'}">
           <td ><c:out value="${result.frstRegisterNm}"/></td>
       </c:if>
       <td><c:out value="${result.frstRegisterPnttm}"/></td>
       <td><c:out value="${result.inqireCo}"/></td>
     </tr>
     </c:forEach>     
     <c:if test="${fn:length(resultList) == 0}">
     <tr>
	     <c:choose>
		     <c:when test="${brdMstrVO.bbsAttrbCode == 'BBSA01'}">
		         <td colspan="7" ><spring:message code="common.nodata.msg" /></td>
		     </c:when>
		     <c:otherwise>
			     <c:choose>
			     <c:when test="${anonymous == 'true'}">
			     <td colspan="4" ><spring:message code="common.nodata.msg" /></td>
			     </c:when>
			     <c:otherwise>
			     <td colspan="5" ><spring:message code="common.nodata.msg" /></td>
			     </c:otherwise>
			     </c:choose>     
		     </c:otherwise>
	     </c:choose>       
     </tr>      
     </c:if>  
     </tbody>
     </table>
  </div>
<!-- 페이지 네비게이션 시작 -->
<div id="paging_div">
    <ul class="paging_align">
        <ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_noticeList" />    
    </ul>
</div>

<!-- pagination 관련해서 수정할때 참조할 디자인(CSS)  
<div class="pagination">
<span class="page-links text-center">
<span class="page-link void-link prev"><i class="fa fa-angle-double-left"></i></span>
<a href="" target="_self" class="page-link active tip-t-fade" data-tooltip="Current Page">1</a>
<a href="/collections/all?page=2" target="_self" class="page-link tip-t-fade" data-tooltip="Page 2">2</a>
<a href="/collections/all?page=2" target="_self" class="page-link next tip-t-fade" data-tooltip="Next"><i class="fa fa-angle-double-right"></i></a>
</span>
</div>
 -->
<!-- //페이지 네비게이션 끝 -->  
