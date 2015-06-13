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
								<!-- 제목 날짜 첨부 -->
								<div class="">
								${article.c_title}
								</div>
								<!-- 내용 -->
								<div>
								${article.content}
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