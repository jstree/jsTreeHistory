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
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css" media="all" />
<!-- Jquery Context Menu -->
<link href="${pageContext.request.contextPath}/assets/js/jqueryContextMenu/jquery.contextMenu.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/assets/js/jqueryContextMenu/jquery.ui.position.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/jqueryContextMenu/jquery.contextMenu.js" type="text/javascript"></script>
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
<script>
function readScrap(c_id){
	var popupUrl = '${pageContext.request.contextPath}/user/scrap/readScrapPopup.do?postingId=' +  c_id;
	var popupOption = 'width=760, height=500, left=150, top=150, resizable=no, scrollbars=no, status=no;'; 
	window.open(popupUrl, '', popupOption);
}
</script>
</head>
<body>
	<section class="clearfix">
		<nav>
			<div class="container bm-medium">
				<div class="one-whole">
					<div class="no-display">scrap</div>
				</div>
			</div>
		</nav>
		<article>
			<div class="clearfix">
				<div class="container bm-remove">
					<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="article-body rte" itemprop="articleBody">
							<div class="tablet-mobile alpha bm-remove last">
								<div>
									<table id="boardTable" class="board-table display">
										<thead>
											<tr>
												<th>번호</th>
												<th>게시판명</th>
												<th>제목</th>
												<th>작성자</th>
												<th class="desktop">스크랩일자</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="scrap" items="${scrapList}" varStatus="status">
												<tr>
												    <td class="dt-center">${scrap.c_id}</td>
													<td class="dt-center">${scrap.boardName}</td>
													<td><a href="#" onclick="readScrap(${scrap.postingId})">${scrap.c_title}</a></td>
													<td class="dt-center">${scrap.nickName}</td>
													<td class="dt-center">
														<fmt:parseDate value="${scrap.scrapDt}" var="scrapDateFmt" pattern="yyyyMMddHHmmss"/>
														<fmt:formatDate value="${scrapDateFmt}" pattern="yyyy-MM-dd HH:mm:ss"/>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div>
									<div id="pagingDiv">
										<c:if test="${leftPage != null}">
											<span><a href="${pageContext.request.contextPath}/user/scrap/index.do?pageNum=${leftPage}">◀</a></span>
										</c:if>
										<span> <c:forEach var="i" begin="${startPageNum}" end="${endPageNum}" step="1">
												<c:choose>
													<c:when test="${i eq currentPageNum}">
														<a href="${pageContext.request.contextPath}/user/scrap/index.do?pageNum=${i}" class="underline">${i}</a>
													</c:when>
													<c:otherwise>
														<a href="${pageContext.request.contextPath}/user/scrap/index.do?pageNum=${i}">${i}</a>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</span>
										<c:if test="${rightPage != null}">
											<span><a href="${pageContext.request.contextPath}/user/scrap/index.do?pageNum=${rightPage}">▶</a></span>
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