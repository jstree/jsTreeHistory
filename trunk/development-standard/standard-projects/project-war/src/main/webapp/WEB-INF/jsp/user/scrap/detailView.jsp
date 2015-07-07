<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>
<!DOCTYPE html>
<html lang="ko" class="js">
<head>
<title>${pageName}</title>
<!-- !!!  FOR THIS PAGE ONLY !!! -->
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

span#articleInfo > span > span {
	margin: 0 5px;
}

span#articleAttachment {
	text-align: right;
}



/* Article Content */
div#articleContent {
	margin: 40px 0;
}

/* Comment */
div.rdc-detail {
	margin-bottom: 10px;
}
div.rdc-header > span {
	padding-right : 10px;
}

span.rdc-reg-id {
	 font-weight: bold;
}
span.rdc-reg-date {
}


/* Comment Write */
div.write-comment {
	overflow: hidden;
}

div.write-comment > div {
	
	float: left;
}

div.write-comment-header {
	width: 20%;
	text-align: center;
}

div.write-comment-body {
	width: 50%;
}

textarea.write-comment-input {
	
	display: inline;
	width: 300px !important;
	height: 70px !important;
}
div.write-comment-btn {
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
<script>
function deleteThisArticle(c_id){
	if(confirm('스크랩 게시물을 삭제 하시겠습니까?') == true) {
		location.href ='${pageContext.request.contextPath}/user/scrap/delete.do?c_id=' + c_id;
		parent.location.reload();
		window.close();		
	}
}
</script>

<!-- Jquery Context Menu -->
<link href="${pageContext.request.contextPath}/assets/css/backbone.scss.css?20" rel="stylesheet" type="text/css" media="all" />
<!--  <link href="${pageContext.request.contextPath}/assets/js/jqueryContextMenu/jquery.contextMenu.css" rel="stylesheet" type="text/css" media="all" />-->
<script src="${pageContext.request.contextPath}/assets/js/jqueryContextMenu/jquery.ui.position.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/jqueryContextMenu/jquery.contextMenu.js" type="text/javascript"></script>
</head>
<body>
	<section class="clearfix">
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
										<span id="firstInfoRow">
											<span><a class="user-context">${article.regNickName}</a></span>
											<span id="articleDt">2015-05-03 09:15:25</span>
										</span>
										<span id="secondInfoRow">
											<span>조회수: ${article.viewCnt}</span>
											<span>추천수: 0</span>
											<span id="articleAttachment"><a href="#" id="attachmentFile">첨부 (3)</a></span>
										</span>
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
										<a href="#" onclick="deleteThisArticle(${article.c_id})">스크랩 삭제</a>
										<a href="#">답글쓰기</a>
										<a href="#" onclick="window.open('about:blank', '_self').close();">닫기</a>
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