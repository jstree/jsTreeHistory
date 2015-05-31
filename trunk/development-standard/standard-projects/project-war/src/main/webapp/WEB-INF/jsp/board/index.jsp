<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags" %>

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
									<table id="boardTable" class="board-table display" cellspacing="0" width="100%">
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
													<td>${article.c_id}</td>
													<td><a>${article.c_title} (1)</a></td>
													<td>${article.regId}</td>
													<td>${article.regDt}</td>
													<td>${article.viewCnt}</td>
													<td>0</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									${ fn:length(articleList) }
									<c:choose>
										<c:when test="${not empty articleList}" >
											존재
										</c:when>
										<c:otherwise>
											없음 ㅠㅠ
										</c:otherwise>
									</c:choose>
									
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