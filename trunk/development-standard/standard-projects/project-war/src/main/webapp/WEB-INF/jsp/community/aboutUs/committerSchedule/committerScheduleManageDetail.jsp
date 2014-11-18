<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- Core : 변수, 흐름제어, url처리 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><!-- 함수 : collection, String 처리  -->
<!DOCTYPE html>
<html lang="ko" class="no-js">
	<head>
	<style type="text/css">
		table {width:100%; border-top:3px solid #ccc; border-collapse:collapse}
		caption {margin:1% 0 0.5%}
		th, td {border:1px solid #ccc}
		th {padding:1% 0.5%; background:#fafafa; font-weight:bold}
		td {padding:0.5% 2%;}
		
		/*.schedule {padding:10%}*/
		.schedule label, .schedule select, .schedule input, .schedule textarea {margin:0}
		.schedule select {width:auto; min-width:150px; height:30px; padding:0}
		.schedule caption {font-size:20px; text-align:left; font-weight:bold}
		.schedule th, .schedule td {vertical-align:middle}
		.schedule th em {color:#ff0000}
		.schedule em {padding:3px 10px}
		.schedule input[type=text], .schedule input[type=file] {height:30px}
		.schedule input[type=text], .schedule textarea {width:80%; max-width:none}
		.schedule input[type=radio] + label {padding-right:15px}
		.schedule .date {*zoom:1}
		.schedule .date:after {display:block; content:""; clear:both}
		.schedule .date * {float:left}
		.schedule .date input[type=text]{width:10%; text-align:center}
		.schedule .date input[type=image]{margin:5px 0 0 10px;}
		.schedule .date p {width:400px; margin:0}
		.schedule .date p select {width:50px; min-width:inherit; margin:0 5px 0 10px}
		.schedule .date p select:first-child {margin-left:0}
		.schedule .date p select + span {position:relative; top:4px}
		.schedule .date em + input + input {margin-right:30px !important}
		.schedule .btn_center {padding:30px 0; text-align:center}
		.schedule .btn_gray {background:#f5f5f5; border:1px solid #ddd; color:#666; margin:0}
		.schedule a.btn_gray {display:inline-block; width:125px; height:40px; padding-top:8px; text-align:center}
	</style>
	<script type="text/javascript">		
		function fnGetList(year, month, searchKeyword, searchCondition){
			$.ajax({
				 async : false
				,type: 'GET'
				,url: "${pageContext.request.contextPath}/sub/committerScheduleMonthList.do"
				,data : {
					 year  : year
					,month : month
					,searchKeyword   : searchKeyword
					,searchCondition : searchCondition
				}
				,success : function (page) {
					$("#contentsBody").html(page);
				}
				,error : function(e){
				}
			});
		}
	</script>
	</head>
	<body>
		<!-- 보기 -->
		<% pageContext.setAttribute("crlf", "\r\n"); %>
		<div class="schedule">
			<table>
				<caption>일정관리 상세보기</caption>
				<colgroup>
					<col width="20%" />
					<col width="*" />
				</colgroup>
				<tr>
					<th scope="row">일정구분</th>
					<td>
						<c:forEach items="${schdulSe}" var="schdulSeInfo" varStatus="status">
							<c:if test="${schdulSeInfo.code eq resultList[0].schdulSe}">
								<c:out value="${fn:replace(schdulSeInfo.codeNm , crlf , '<br/>')}" escapeXml="false" />    
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th scope="row">중요도</th>
					<td>
						<c:forEach items="${schdulIpcrCode}" var="schdulSeInfo" varStatus="status">
							<c:if test="${schdulSeInfo.code == resultList[0].schdulIpcrCode}">
								<c:out value="${fn:replace(schdulSeInfo.codeNm , crlf , '<br/>')}" escapeXml="false" />
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th scope="row">부서</th>
					<td>
						<c:out value="${fn:replace(resultList[0].schdulDeptName , crlf , '<br/>')}" escapeXml="false" />
					</td>
				</tr>
				<tr>
					<th scope="row">일정명</th>
					<td>
						<c:out value="${fn:replace(resultList[0].schdulNm , crlf , '<br/>')}" escapeXml="false" />
					</td>
				</tr>
				<tr>
					<th scope="row">일정내용</th>
					<td>
						<c:out value="${fn:replace(resultList[0].schdulCn , crlf , '<br/>')}" escapeXml="false" />
					</td>
				</tr>
				<tr>
					<th scope="row">반복구분</th>
					<td>
						<c:forEach items="${reptitSeCode}" var="schdulSeInfo" varStatus="status">
							<c:if test="${schdulSeInfo.code == resultList[0].reptitSeCode}">    
								<c:out value="${fn:replace(schdulSeInfo.codeNm , crlf , '<br/>')}" escapeXml="false" />
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th scope="row">날짜/시간</th>
					<td>
						${fn:substring(resultList[0].schdulBgnde, 0, 4)}-${fn:substring(resultList[0].schdulBgnde, 4, 6)}-${fn:substring(resultList[0].schdulBgnde, 6, 8)}&nbsp;${fn:substring(resultList[0].schdulBgnde, 8, 10)}시  ${fn:substring(resultList[0].schdulBgnde, 10, 12)}분 ~      
						${fn:substring(resultList[0].schdulEndde, 0, 4)}-${fn:substring(resultList[0].schdulEndde, 4, 6)}-${fn:substring(resultList[0].schdulEndde, 6, 8)}&nbsp;${fn:substring(resultList[0].schdulEndde, 8, 10)}시  ${fn:substring(resultList[0].schdulEndde, 10, 12)}분
					</td>
				</tr>
				<tr>
					<th scope="row">담당자</th>
					<td>
						<c:out value="${resultList[0].schdulChargerName}" escapeXml="false" />
					</td>
				</tr>
				<tr>
					<th scope="row">파일첨부</th>
					<td>
						<c:out value="${resultList[0].atchFileId}" escapeXml="false" />
					</td>
				</tr>
			</table>
			<div class="btn_center">
				<a onclick="fnGetList('${year}','${month}','${searchKeyword}','${searchCondition}');" href="#" class="btn_gray">목록</a>
			</div>
		</div>
		<!-- // 보기 -->
	</body>
</html>
