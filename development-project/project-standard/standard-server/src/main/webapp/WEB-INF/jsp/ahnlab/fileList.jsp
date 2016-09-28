<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	/**
	 * @Class Name : EgovFileList.jsp
	 * @Description : 파일 목록화면
	 * @Modification Information
	 * @
	 * @  수정일   	수정자		수정내용
	 * @ ----------	------		---------------------------
	 * @ 2009.03.26	이삼섭		최초 생성
	 * @ 2011.07.20	옥찬우		<Input> Tag id속성 추가( Line : 68 )
	 *
	 *  @author 공통서비스 개발팀 이삼섭
	 *  @since 2009.03.26
	 *  @version 1.0
	 *  @see
	 *
	 */
%>
<!-- link href="<c:url value='/css/egovframework/com/com.css' />" rel="stylesheet" type="text/css"-->

<script type="text/javascript">
  function fn_egov_downFile(atchFileId, fileSn) {
    window.open("<c:url value='/ahnlab/FileDown.do?atchFileId=" + atchFileId
            + "&fileSn=" + fileSn + "'/>");
  }

  function fn_egov_deleteFile(atchFileId, fileSn) {
    forms = document.getElementsByTagName("form");

    for (var i = 0; i < forms.length; i++) {
      if (typeof (forms[i].atchFileId) != "undefined"
              && typeof (forms[i].fileSn) != "undefined"
              && typeof (forms[i].fileListCnt) != "undefined") {
        form = forms[i];
      }
    }

    //form = document.forms[0];
    form.atchFileId.value = atchFileId;
    form.fileSn.value = fileSn;
    form.action = "<c:url value='/cmm/fms/deleteFileInfs.do'/>";
    form.submit();
  }

  function fn_egov_check_file(flag) {
    if (flag == "Y") {
      document.getElementById('file_upload_posbl').style.display = "block";
      document.getElementById('file_upload_imposbl').style.display = "none";
    } else {
      document.getElementById('file_upload_posbl').style.display = "none";
      document.getElementById('file_upload_imposbl').style.display = "block";
    }
  }
</script>

<!-- <form name="fileForm" action="" method="post" >  -->
<input type="hidden" name="atchFileId" value="${atchFileId}">
<input type="hidden" name="fileSn">
<input type="hidden" name="fileListCnt" id="fileListCnt" value="${fileListCnt}">

<!-- </form>  -->

<!--<title>파일목록</title> -->
<c:forEach var="fileVO" items="${fileList}" varStatus="status">
	<td class="listCenter" nowrap>
		<c:choose>
			<c:when test="${updateFlag=='Y'}">
				<c:out value="${fileVO.orignlFileNm}" />
				<img src="<c:url value='/images/egovframework/com/cmm/fms/icon/bu5_close.gif' />" width="19" height="18"
					onClick="fn_egov_deleteFile('<c:out value="${fileVO.atchFileId}"/>','<c:out value="${fileVO.fileSn}"/>');" alt="파일삭제">
			</c:when>
			<c:otherwise>
				<a href="javascript:fn_egov_downFile('<c:out value="${fileVO.atchFileId}"/>','<c:out value="${fileVO.fileSn}"/>')">
					<c:choose>
						<c:when test="${status.index==0}">
							<img src="/css/ahnlab/ico_manual.png" alt="AhnLab">
						</c:when>
						<c:otherwise>
							<img src="/css/ahnlab/ico_download.png" alt="AhnLab">
						</c:otherwise>
					</c:choose>
				</a>
			</c:otherwise>
		</c:choose>
	</td>
</c:forEach>
<c:if test="${fn:length(fileList) == 0}">
</c:if>
