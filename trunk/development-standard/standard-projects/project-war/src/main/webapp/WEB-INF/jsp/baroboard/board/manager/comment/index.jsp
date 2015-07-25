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
	}).on("click", "#aa", function(){
		var queryStr = $("#searchForm").serialize();
		window.location.href = '${pageContext.request.contextPath}/board/manager/comment/index.do?'+queryStr;
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
	window.location.href = '${pageContext.request.contextPath}/board/manager/comment/index.do';
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
						<h1 class="bm-remove">댓글 관리</h1>
						<p class="bm-remove">
							<a href="/" target="_self">Home</a> &nbsp;/&nbsp; BOARD &nbsp;/&nbsp; 댓글 관리
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
							<option value="${result.c_id }" <c:if test="${result.c_id == commentManageVO.boardId }">selected</c:if>>${result.c_title }</option>
						</c:forEach>
						</select>
					</div>
				</div>
				<div class="responsive-row">
					<div class="item-name">작성자</div>
					<div class="item-value">
						<input id="regNickName" type="text" name="regNickName" value = "${commentManageVO.regNickName }"/>
					</div>
				</div>
				<div class="responsive-row">
					<div class="item-name">내용</div>
					<div class="item-value">
						<input id="c_title" type="text" name="c_title" value = "${commentManageVO.c_title }"/>
					</div>
				</div>
				<div class="responsive-row has-two-value">
					<div class="item-name">작성일자</div>
					<div class="item-value">
						<label for="from"></label>
						<input type="text" id="fromDt" name="fromDt" value = "${commentManageVO.fromDt }">
						<label for="to">~</label>
						<input type="text" id="toDt" name="toDt" value="${commentManageVO.toDt }">
					</div>
					</div>
				</div>
				<div class="responsive-row">
						<input type="button" name="aa" id = "aa" value="검색"/>
				</div>
			</form>
		<article>
			<div class="clearfix">
				<div class="container bm-remove">
					<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="article-body rte" itemprop="articleBody">
							<div class="tablet-mobile alpha bm-remove last">
								<div class="text-right">
									<!-- <a href="#" class="right"><input type="button" name="save" id = "save" value="저장"/></a> -->
									<a href="#" class="right"><input type="button" name = "commentAllDelete" id = "commentAllDelete" value="일괄삭제"/></a>
								</div>
								<div>
									<table id="boardTable" class="board-table display">
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
								<div>
									<div id="pagingDiv">
										<c:if test="${leftPage != null}">
											<span><a href="${pageContext.request.contextPath}/board/index.do?boardID=${boardID}&pageNum=${leftPage}">◀</a></span>
										</c:if>
										<span> <c:forEach var="i" begin="${startPageNum}" end="${endPageNum}" step="1">
												<c:choose>
													<c:when test="${i eq currentPageNum}">
														<a href="${pageContext.request.contextPath}/board/index.do?boardID=${boardID}&pageNum=${i}" class="underline">${i}</a>
													</c:when>
													<c:otherwise>
														<a href="${pageContext.request.contextPath}/board/index.do?boardID=${boardID}&pageNum=${i}">${i}</a>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</span>
										<c:if test="${rightPage != null}">
											<span><a href="${pageContext.request.contextPath}/board/index.do?boardID=${boardID}&pageNum=${rightPage}">▶</a></span>
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