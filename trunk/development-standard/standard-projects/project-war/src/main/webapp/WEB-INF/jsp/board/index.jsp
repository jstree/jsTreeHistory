<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
									<a href="${pageContext.request.contextPath}/board/newArticle.do?boardID=${boardID}" class="right">글쓰기</a>
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
											<c:forEach var="announce" items="${announceList}" varStatus="status">
												<tr>
													<td class="dt-center font-bold">공지</td>
													<td class="font-bold"><a href="${pageContext.request.contextPath}/board/readArticle.do?c_id=${announce.c_id}">${announce.c_title} &nbsp; (${announce.commentCnt})</a></td>
													<td class="dt-center">${announce.regNickName}</td>
													<td class="dt-center">${announce.regDt}</td>
													<td class="dt-center">${announce.viewCnt}</td>
													<td class="dt-center">${announce.likeCnt}</td>
												</tr>
											</c:forEach>
											<c:forEach var="article" items="${articleList}" varStatus="status">
												<tr>
													<td class="dt-center">${article.c_id}</td>
													<c:choose>
														<c:when test="${article.c_level == 2}">
															<td><a href="${pageContext.request.contextPath}/board/readArticle.do?c_id=${article.c_id}">${article.c_title} &nbsp; (${article.commentCnt})</a></td>
														</c:when>
														<c:otherwise>
															<td><i style="padding: 0  5px 0 ${ (article.c_level - 2) * 10 }px" class="fa fa-chevron-right"></i><a href="${pageContext.request.contextPath}/board/readArticle.do?c_id=${article.c_id}">${article.c_title} &nbsp; (${article.commentCnt})</a></td>
														</c:otherwise>
													</c:choose>
													
													<td class="dt-center"><a class="user-context" data-id="${article.regId}">${article.regNickName}</a></td>
													<td class="dt-center">${article.regDt}</td>
													<td class="dt-center">${article.viewCnt}</td>
													<td class="dt-center">${article.likeCnt}</td>
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
									<div id="searchDiv">
										<form action="${pageContext.request.contextPath}/board/searchArticle.do" method="GET">
											<input type="text" name="searchKeyword" placeholder="검색 키워드"/>
											<select name="type">
												<option value="title">제목</option>
												<option value="content">내용</option>
												<option value="title_content">제목+내용</option>
												<option value="nickName">닉네임</option>
											</select>
											<input type="hidden" name="boardID" value="${boardID}" />
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