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
<style>
/* Article Header */
div#articleHeader {
	overflow: hidden;
}

div#articleHeader h3 {
	display: inline !important;
}

span#articleInfo {
	float: right;
}

span#articleInfo > span {
	display:block;
}

span#articleAttachment {
	text-align: right;
}


/* Article Content */
div#articleContent {
	margin: 40px 0;
}

/* Comment */

/* Comment Write */
div#writeComment {
	overflow: hidden;
}

div#writeComment > div {
	
	float: left;
}

div#commentHeader {
	width: 20%;
	text-align: center;
}

div#commentBody {
	width: 50%;
}

textarea#commentInput {
	
	display: inline;
	width: 300px !important;
	height: 70px !important;
}
div#commentBtn {
	width: 20%;
}

/* Article Action */
div#articleAction {
	text-align: right;
}

div#articleAction span {
}

div#articleAction span a {
	margin: 0 10px;
}
</style>
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
					<div id="article" class="one-whole boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="article-body rte" itemprop="articleBody">
							<div class="tablet-mobile alpha bm-remove last">
								<!-- 제목 날짜 첨부 -->
								<div id="articleHeader" class="">
									<span id="articleTitle"><h3>${article.c_title}</h3></span> 
									<span id="articleInfo">
										<span>
											<span>${article.regNickName}</span>
											<span id="articleDt">2015-05-03 09:15:25</span>
										
										</span>
										<span id="articleAttachment">첨부 <a>(3)</a></span>
									</span>
								</div>
								<!-- 내용 -->
								<div id="articleContent">
								${article.content} 
								</div>
								<!-- 댓글 -->
								<div id="comment">
								</div>
								<!-- 댓글작성 -->
								<div id="writeComment">
									<div id="commentHeader">
										<div>댓글작성</div>
										<div>
											<input id="authorOnly" type="checkbox" name="authorOnly">
											<label for="authorOnly">글쓴이만 보기</label>
										</div>
									</div>
									<div id="commentBody"><textarea id="commentInput"></textarea></div>
									<div id="commentBtn"><button>등록</button></div>								
								</div>
								<!-- 하단 Action 칸 -->
								<div id="articleAction">
									<span>
										<a>답글쓰기</a>
										<a>수정</a>
										<a>삭제</a>
										<a>목록가기</a>
									</span>
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