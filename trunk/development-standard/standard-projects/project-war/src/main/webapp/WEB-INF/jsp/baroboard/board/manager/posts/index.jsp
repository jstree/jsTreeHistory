<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>
<!DOCTYPE html>
<html lang="ko" class="js">
<head>
<title>${pageName}</title>
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css" media="all" />
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
	}).on("click", "#searching", function(){
		var queryStr = $("#searchForm").serialize();
		window.location.href = '${pageContext.request.contextPath}/board/manager/posts/index.do?'+queryStr;
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
	window.location.href = '${pageContext.request.contextPath}/board/manager/posts/index.do';
}

function moveCallback(r){
	if(r.status){
		alert("저장되었습니다.");
	}else{
		alert("오류입니다.");
	}
	window.location.href = '${pageContext.request.contextPath}/board/manager/posts/index.do';
}

</script>
</head>
<body>
	<section class="clearfix">
		<nav>
			<div class="container bm-medium">
				<div class="one-whole">
					<div class="no-display">article</div>
					<div class="text-center">
						<h1 class="bm-remove">게시글 관리</h1>
						<p class="bm-remove">
							<a href="/" target="_self">Home</a> &nbsp;/&nbsp; BOARD &nbsp;/&nbsp; 게시글 관리
						</p>
					</div>
				</div>
			</div>
		</nav>
		<form name = "searchForm" id = "searchForm">
			<div id="search" class="one-whole boxed p-twenty">
				<div class="responsive-row">
					<div class="item-name">게시판</div>
					<div class="item-value">
						<select id = "boardId" name = "boardId">
							<option value="">모두 </option>
						<c:forEach var="result" items="${boardInfo}" varStatus="status">
							<option value="${result.c_id }" <c:if test="${result.c_id == postsManageVO.boardId }">selected</c:if>>${result.c_title }</option>
						</c:forEach>
						</select>
					</div>
				</div>
				<div class="responsive-row">
					<div class="item-name">제목</div>
					<div class="item-value">
						<input id="c_title" type="text" name = "c_title" value = "${postsManageVO.c_title }"/>
					</div>
				</div>
				<div class="responsive-row">
					<div class="item-name">작성자</div>
					<div class="item-value">
						<input id="regNickName" type="text" name="regNickName" value = "${postsManageVO.regNickName }"/>
					</div>
				</div>
				<div class="responsive-row">
					<div class="item-name">내용</div>
					<div class="item-value">
						<input id="content" type="text" name="content" value = "${postsManageVO.content }"/>
					</div>
				</div>
				<div class="responsive-row has-two-value">
					<div class="item-name">작성일자</div>
					<div class="item-value">
						<label for="from"></label>
						<input type="text" id="fromDt" name="fromDt" value = "${postsManageVO.fromDt }">
						<label for="to">~</label>
						<input type="text" id="toDt" name="toDt" value="${postsManageVO.toDt }">
					</div>
					</div>
				</div>
				<div class="responsive-row">
						<input type="button" name="searching" id = "searching" value="검색"/>
				</div>
			</form>
		<article>
			<div class="clearfix">
				<div class="container bm-remove">
					<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="article-body rte" itemprop="articleBody">
							<div class="tablet-mobile alpha bm-remove last">
								<div class="text-right">
									<a href="#" class="right"><input type="button" name="save" id = "save" value="저장"/></a>
									<a href="#" class="right"><input type="button" name = "postsAllDelete" id = "postsAllDelete" value="일괄삭제"/></a>
								</div>
								<div>
									<table id="boardTable" class="board-table display">
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
													<td class="dt-center"><input type = "checkbox" name = "chk" id = "chk" value = "${board.boardId}@${board.c_id}"></td>
													<td class="dt-center">
														<select id = "boardId">
														<c:forEach var="result" items="${boardInfo}" varStatus="status">
															<option value="${result.c_id }" <c:if test="${result.c_title == board.boardName }">selected</c:if>>${result.c_title }</option>
														</c:forEach>
														</select>
													</td>
													<td>${board.c_title}</a></td>
													<td class="dt-center"><a class="user-context" data-id="${board.regId}">${board.regNickName}</a></td>
													<td class="dt-center"><fmt:formatDate value="${dateFmt}" pattern="yyyy-MM-dd"/></td>
													<td class="dt-center">${fn:substring(board.content,0,10) }...</td>
													<td class="dt-center">${board.viewCnt}</td>
													<td class="dt-center">${board.likeCnt}</td>
													<td class="dt-center"><a href = "javascript:postsDelete('${board.boardId}@${board.c_id}');">Delete</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div>
									<div id="pagingDiv">
										<c:if test="${leftPage != null}">
											<span><a href="#" onclick = getPage('${leftPage }');>◀</a></span>
										</c:if>
										<span> <c:forEach var="i" begin="${startPageNum}" end="${endPageNum}" step="1">
												<c:choose>
													<c:when test="${i eq currentPageNum}">
														<a href="#" class="underline" onclick = getPage('${i }')>${i}</a>
													</c:when>
													<c:otherwise>
														<a href="#" onclick = getPage('${i }')>${i}</a>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</span>
										<c:if test="${rightPage != null}">
											<span><a href="#" onclick = getPage('${rightPage }')>▶</a></span>
										</c:if>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>
	</section>
</body>
</html>