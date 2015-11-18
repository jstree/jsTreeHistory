<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>
<!DOCTYPE html>
<html lang="ko" class="js">
<head>
<title>${pageName}</title>
<!-- !!!  FOR THIS PAGE ONLY !!! -->
<script>
	$(document).ready(function() {
		
		$('#boardTable').dataTable({
			responsive : {
				details : false
			},
			paging : false,
			searching : false,
			ordering : false,
			info : false

		});
	});
</script>
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css" media="all" />
<!-- Jquery Context Menu -->
<link href="${pageContext.request.contextPath}/assets/js/jqueryContextMenu/jquery.contextMenu.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/assets/js/jqueryContextMenu/jquery.ui.position.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/jqueryContextMenu/jquery.contextMenu.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
	$.contextMenu({
		selector: '.user-context',
		trigger: 'left',
		items: {
			'userInfo': {
				name: '회원정보 보기',
				callback: function(key, option) {
					var userID = $(this).attr('data-id');
					var popupUrl = '${pageContext.request.contextPath}/board/getUserInfoPopup.do?c_id='+userID;
					var popupOption = 'width=370, height=360, left=150, top=150, resizable=no, scrollbars=no, status=no;'; 
					window.open(popupUrl, '', popupOption);
				}
			},
			'sendNote': {
				name: '쪽지 보내기',
				callback: function(key, option) {
					var userID = $(this).attr('data-id');
					var popupUrl = '${pageContext.request.contextPath}/board/sendNotePopup.do?c_id='+userID;
					var popupOption = 'width=370, height=360, left=150, top=150, resizable=no, scrollbars=no, status=no;'; 
					window.open(popupUrl, '', popupOption);
				}
			},
			'showArticles': {
				name: '게시글 보기',
				callback: function(key, option) {
					var userNickName = $(this).text();
					var params = {
							type: 'nickName',
							searchKeyword: userNickName
					}
					var url = '${pageContext.request.contextPath}/board/searchArticle.do?' + $.param(params);
					location.href = url;
				}
			}
		}
	});
})
</script>
</head>
<body>
	<section class="clearfix">
		<nav>
			<div class="container bm-medium">
				<div class="one-whole">
					<div class="no-display">article</div>
					<div class="text-center">
						<h1 class="bm-remove">자유게시판</h1>
						<p class="bm-remove">
							<a href="/" target="_self">Home</a> &nbsp;/&nbsp; BOARD &nbsp;/&nbsp; ${boardName}
						</p>
					</div>
				</div>
			</div>
		</nav>
		<article>
			<div class="clearfix">
				<div class="container bm-remove">
					<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="article-body rte" itemprop="articleBody">
							<div class="tablet-mobile alpha bm-remove last">
								<div class="text-right">
									<button class="right">글쓰기</button>
								</div>
								<div>
									<table id="boardTable" class="board-table display">
										<thead>
											<tr>
												<th>번호</th>
												<th>제목</th>
												<th>작성자</th>
												<th class="desktop">작성일자</th>
												<th class="not-mobile">조회수</th>
												<th class="desktop ">추천수</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="article" items="${articleList}" varStatus="status">
												<tr>
													<td class="dt-center">${article.c_id}</td>
													<td><a href="${pageContext.request.contextPath}/board/readArticle.do?c_id=${article.c_id}">${article.c_title} &nbsp; (${article.commentCnt})</a></td>
													<td class="dt-center"><a class="user-context" data-id="${article.regID}">${article.regNickName}</a></td>
													<fmt:parseDate value="${article.regDt}" var="articleDateFmt" pattern="yyyyMMddHHmmss"/>
													<td class="dt-center"><fmt:formatDate value="${articleDateFmt}" pattern="yyyy-MM-dd"/></td>
													<td class="dt-center">${article.viewCnt}</td>
													<td class="dt-center">0</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div>
									<div id="pagingDiv">
										<c:if test="${leftPage != null}">
											<span><a href="${pageContext.request.contextPath}/board/searchArticle.do?boardID=${boardID}&searchKeyword=${reqSearchArticle.searchKeyword}&type=${reqSearchArticle.type}&pageNum=${leftPage}">◀</a></span>
										</c:if>
										<span> 
										<c:choose>
											<c:when test="${fn:length(articleList) eq 0}">
												<a href="#" class="underline">1</a>
											</c:when>
											<c:otherwise>
												<c:forEach var="i" begin="${startPageNum}" end="${endPageNum}" step="1">
													<c:choose>
														<c:when test="${i eq currentPageNum}">
															<a href="${pageContext.request.contextPath}/board/searchArticle.do?boardID=${boardID}&searchKeyword=${reqSearchArticle.searchKeyword}&type=${reqSearchArticle.type}&pageNum=${i}" class="underline">${i}</a>
														</c:when>
														<c:otherwise>
															<a href="${pageContext.request.contextPath}/board/searchArticle.do?boardID=${boardID}&searchKeyword=${reqSearchArticle.searchKeyword}&type=${reqSearchArticle.type}&pageNum=${i}">${i}</a>
														</c:otherwise>
													</c:choose>
												</c:forEach>	
											</c:otherwise>
										</c:choose>
										</span>
										<c:if test="${rightPage != null}">
											<span><a href="${pageContext.request.contextPath}/board/searchArticle.do?boardID=${boardID}&searchKeyword=${reqSearchArticle.searchKeyword}&type=${reqSearchArticle.type}&pageNum=${rightPage}">▶</a></span>
										</c:if>
									</div>
									<div id="searchDiv">
										<form method="get" action="${pageContext.request.contextPath}/board/searchArticle.do?boardID=${boardID}">
											<input type="text" name="searchKeyword" value="${reqSearchArticle.searchKeyword}"/>
											<select name="type">
												<option value="title" <c:if test="${reqSearchArticle.type == 'title'}">selected</c:if>>제목</option>
												<option value="content" <c:if test="${reqSearchArticle.type == 'content'}">selected</c:if>>내용</option>
												<option value="title_content" <c:if test="${reqSearchArticle.type == 'title_content'}">selected</c:if>>제목+내용</option>
												<option value="nickName" <c:if test="${reqSearchArticle.type == 'nickName'}">selected</c:if>>닉네임</option>
											</select>
											<input type="submit" value="검색"/>
										</form>
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