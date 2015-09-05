<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>
<!DOCTYPE html>
<html lang="ko" class="js">
<head>
<title>${pageName}</title>
<style type="text/css">
.center {
    text-align: center;
}
.right {
    text-align: right;
}
.chk {
    height: 13px !important;
}
select {
	height: 100%;
	display: inline !important;
}
input[type="text"] {
	width: 192px !important;
    height: 30px !important;
    display: inline !important;
}
#divBtns {
    text-align: right;
    margin-top: 10px;
}
.compact {
	min-width: 71px;
    min-height: 37px;
}
#divPagination {
	text-align: center;
	margin-top: 10px;
	font-size: 1.1em;
}
.currentPage {
	font-weight: bold !important;
}
</style>
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css" media="all" />
<script>
$(document).ready(function(){
	$(document).on("click", "#commentAllDelete", function(){
		var chks = [];
		$("input[name=chk]:checked").each(function() {
			chks.push($(this).val());
		});

		if(chks.length == 0){
			alert("삭제할 항목을 체크해주시기 바랍니다.");
			return;
		}
		
		var params = {"chk": chks};
		callAjax( null
                , "${pageContext.request.contextPath}/board/manager/comment/commentDelete.do"
                , null
                , "POST"
                , 'json'
                , params
                , 'application/json'
                , callback);
	}).on("click", "#searchBtn", function(){
		linkPage();
	});
});

function commentDelete(data){
	var chks = [];
	chks.push(data);
	var params = {chk: chks};
	callAjax( null
            , "${pageContext.request.contextPath}/board/manager/comment/commentDelete.do"
            , null
            , "POST"
            , 'json'
            , params
            , 'application/json'
            , callback);
}

function callback(r){
	if(r.status){
		alert("삭제되었습니다.");
	}else{
		alert("오류입니다.");
	}
	linkPage();
}

function linkPage(pageNo){
	if(typeof(pageNo) == "number"){
		$("#pageNo").val(pageNo);
	}
	var queryStr = $("#searchForm").serialize();
	window.location.href = '${pageContext.request.contextPath}/board/manager/comment/index.do?'+queryStr;
}
</script>
</head>
<body>
	<section class="clearfix">
	<div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
	    <div id="samDiv" class="tablet-mobile alpha bm-remove last">
		<form name = "searchForm" id = "searchForm">
			<div id="search" class="one-whole boxed p-twenty">
				<div class="responsive-row">
					<label for="boardId">게시판</label>
						<select id = "boardId" name = "boardId">
							<option value="">모두 </option>
						<c:forEach var="result" items="${boardInfo}" varStatus="status">
							<option value="${result.c_id }" <c:if test="${result.c_id == commentManageVO.boardId }">selected</c:if>>${result.c_title }</option>
						</c:forEach>
						</select>
					<label for="regNickName">작성자</label>
						<input id="regNickName" type="text" name="regNickName" value = "${commentManageVO.regNickName }"/>
					<label for="c_title">내용</label>
						<input id="c_title" type="text" name="c_title" value = "${commentManageVO.c_title }"/>
					<label for="ftDate">작성일자</label>
						<label for="from"></label>
						<input type="text" id="fromDt" name="fromDt" value = "${commentManageVO.fromDt }">
						<label for="to">~</label>
						<input type="text" id="toDt" name="toDt" value="${commentManageVO.toDt }">
						<input type = "hidden" name = "pageNo" id = "pageNo" />
						<input type="button" name="searchBtn" id = "searchBtn" value="검색"/>
					</div>
					
			</form>
			</div>
			
			<div id="divBtns">
	            <a href="#" class="right"><input type="button" name = "commentAllDelete" id = "commentAllDelete" value="일괄삭제"/></a>
	        </div>
			<div class="dataTables_wrapper no-footer">
					<table id="boardTable">
						<thead>
							<tr>
								<th>선택</th>
								<th>게시판</th>
								<th>내용</th>
								<th>작성자</th>
								<th class="desktop">작성일자</th>
								<th>비고</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="board" items="${list}" varStatus="status">
							<fmt:parseDate value="${board.regDt}" var="dateFmt" pattern="yyyyMMddHHmmss"/>
								<tr>
									<td class="dt-center"><input type = "checkbox" name = "chk" id = "chk" value = "${board.boardId}@${board.c_id}"></td>
									<td class="dt-center">${board.boardName }</td>
									<td>${board.c_title}</a></td>
									<td class="dt-center"><a class="user-context" data-id="${board.regId}">${board.regNickName}</a></td>
									<td class="dt-center"><fmt:formatDate value="${dateFmt}" pattern="yyyy-MM-dd"/></td>
									<td class="dt-center"><a href = "javascript:commentDelete('${board.boardId}@${board.c_id}');">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
			<div id="pagingDiv">
				<ui:pagination paginationInfo = "${paginationInfo}" type="asyncText" jsFunction="linkPage"/>
			</div>
	</section>
</body>
</html>