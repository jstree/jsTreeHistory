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
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css" media="all" />
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
</style>

<script>
$(document).ready(function(){
	$(document).on("click", "#save", function(){
		var chks = [];
		$("input[name=chk]:checked").each(function() {
			var moveboardId = $(this).parent().parent().find('#boardId option:selected').val();
			chks.push($(this).val()+"@"+moveboardId);
			
		});
		if(chks.length == 0){
			alert("저장할 항목을 체크해주시기 바랍니다.");
			return;
		}
		
		var params = {"chk": chks};
		callAjax( null
                , "${pageContext.request.contextPath}/board/manager/posts/postsBoardMove.do"
                , null
                , "POST"
                , 'json'
                , params
                , 'application/json'
                , moveCallback);
	}).on("click", "#postsAllDelete", function(){
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
                , "${pageContext.request.contextPath}/board/manager/posts/postsDelete.do"
                , null
                , "POST"
                , 'json'
                , params
                , 'application/json'
                , deleteCallback);
	}).on("click", "#searchBtn", function(){
		linkPage();
	});
});

function postsDelete(data){
	var chks = [];
	chks.push(data);
	var params = {chk: chks};
	callAjax( null
            , "${pageContext.request.contextPath}/board/manager/posts/postsDelete.do"
            , null
            , "POST"
            , 'json'
            , params
            , 'application/json'
            , deleteCallback);
}

function deleteCallback(r){
	if(r.status){
		alert("삭제되었습니다.");
	}else{
		alert("오류입니다.");
	}
	linkPage();
}

function moveCallback(r){
	if(r.status){
		alert("저장되었습니다.");
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
	window.location.href = '${pageContext.request.contextPath}/board/manager/posts/index.do?'+queryStr;
}
</script>
</head>
<body>
<div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
	<section class="clearfix">
		<div id="samDiv" class="tablet-mobile alpha bm-remove last">
		<form name = "searchForm" id = "searchForm">
			<div id="search" class="one-whole boxed p-twenty">
				<div class="responsive-row">
					<label>게시판</label>
						<select id = "boardId" name = "boardId" style="width: 90px !important">
							<option value="">모두 </option>
						<c:forEach var="result" items="${boardInfo}" varStatus="status">
							<option value="${result.c_id }" <c:if test="${result.c_id == postsManageVO.boardId }">selected</c:if>>${result.c_title }</option>
						</c:forEach>
						</select>
					<label for ="title">제목</label>
						<input id="c_title" type="text" name = "c_title" value = "${postsManageVO.c_title }" style="width: 120px !important"/>
					<label for = "regNickName">작성자</label>
						<input id="regNickName" type="text" name="regNickName" value = "${postsManageVO.regNickName }"/>
					<label for="content">내용</label>
						<input id="content" type="text" name="content" value = "${postsManageVO.content }"/>
					<label for ="ftdate">작성일자</label>
						<label for="from"></label>
						<input type="text" id="fromDt" name="fromDt" value = "${postsManageVO.fromDt }" style="width: 90px !important">
						<label for="to">~</label>
						<input type="text" id="toDt" name="toDt" value="${postsManageVO.toDt }" style="width: 90px !important">
						<input type="button" name="searchBtn" id = "searchBtn" class="compact" value="검색"/>
				</div>
				<input type = "hidden" name = "pageNo" id = "pageNo" />
			</form>
			</div>
			<div id="divBtns">
	            <a href="#" class="right"><input type="button" name="save" id = "save" value="저장"/></a>
				<a href="#" class="right"><input type="button" name = "postsAllDelete" id = "postsAllDelete" value="일괄삭제"/></a>
	        </div>
				<div class="dataTables_wrapper no-footer">
					<table id="boardTable">
						<thead>
							<tr>
								<th>선택</th>
								<th>게시판</th>
								<th>제목</th>
								<th>작성자</th>
								<th class="desktop">작성일자</th>
								<th class="not-mobile">내용</th>
								<th class="desktop ">조회수</th>
								<th class="desktop ">추천수</th>
								<th>비고</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="board" items="${list}" varStatus="status">
							<fmt:parseDate value="${board.regDt}" var="dateFmt" pattern="yyyyMMddHHmmss"/>
								<tr>
									<td><input type = "checkbox" name = "chk" id = "chk" value = "${board.boardId}@${board.c_id}"></td>
									<td>
										<select id = "boardId" style="width: 90px !important">
										<c:forEach var="result" items="${boardInfo}" varStatus="status">
											<option value="${result.c_id }" <c:if test="${result.c_title == board.boardName }">selected</c:if>>${result.c_title }</option>
										</c:forEach>
										</select>
									</td>
									<td>${board.c_title}</a></td>
									<td><a class="user-context" data-id="${board.regId}">${board.regNickName}</a></td>
									<td><fmt:formatDate value="${dateFmt}" pattern="yyyy-MM-dd"/></td>
									<td>${fn:substring(board.content,0,10) }...</td>
									<td>${board.viewCnt}</td>
									<td>${board.likeCnt}</td>
									<td><a href = "javascript:postsDelete('${board.boardId}@${board.c_id}');">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				</div>
				<div id="pagingDiv">
					<ui:pagination paginationInfo = "${paginationInfo}" type="asyncText" jsFunction="linkPage"/>
				</div>
			</div>
	</section>
</div>
</body>
</html>