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
											<c:forEach var="announce" items="${announceList}" varStatus="status">
												<tr>
													<td class="dt-center font-bold">공지</td>
													<td class="font-bold"><a>${announce.c_title} &nbsp; (${announce.commentCnt})</a></td>
													<td class="dt-center">${announce.regId}</td>
													<td class="dt-center">${announce.regDt}</td>
													<td class="dt-center">${announce.viewCnt}</td>
													<td class="dt-center">0</td>
												</tr>
											</c:forEach>
											<c:forEach var="article" items="${articleList}" varStatus="status">
												<tr>
													<td class="dt-center">${article.c_id}</td>
													<td><a>${article.c_title} &nbsp; (${article.commentCnt})</a></td>
													<td class="dt-center">${article.regId}</td>
													<td class="dt-center">${article.regDt}</td>
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
										<form action="${pageContext.request.contextPath}/board/searchArticle.do">
											<input type="text" name="searchKeyword" placeholder="검색 키워드"/>
											<select name="type">
												<option value="title">제목</option>
												<option value="content">내용</option>
												<option value="title_content">제목+내용</option>
												<option value="nickName">닉네임</option>
												<option value="date_range">기간</option>
											</select>
											<input type="hidden" name="boardID" value="${boardID}" />
											<input type="submit" title="검색"/>
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