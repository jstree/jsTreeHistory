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
<script>
function deleteThisArticle(c_id){
	if(confirm('게시물을 지우시겠습니까?') == true) {
		$.ajax({
			 method: 'GET'
			,url: '${pageContext.request.contextPath}/board/deleteArticle.do?c_id=' + c_id
			,success: function(data){
				alert('삭제하였습니다.');
				location.href = '${pageContext.request.contextPath}/board/index.do';
			}
			,fail: function(data) {
				alert('글 삭제에 실패하였습니다.');
			}
		});
	}	
}
</script>

<!-- Jquery Context Menu -->
<link href="${pageContext.request.contextPath}/assets/js/jqueryContextMenu/jquery.contextMenu.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/assets/js/jqueryContextMenu/jquery.ui.position.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/jqueryContextMenu/jquery.contextMenu.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
	$.contextMenu({
		selector: '#attachmentFile',
		trigger: 'left',
		items: {
			'atc1': {
				name: 'TestExcep.xls',
				callback: function(key, option) {
					alert("atc1 Download");
				}
			},
			'atc2': {
				name: '내꺼.pdf',
				callback: function(key, option) {
				}
			},
			'atc3': {
				name: 'zip.zip',
				callback: function(key, option) {
				}
			}
		}
	});
	
	$.contextMenu({
		selector: '.user-context',
		trigger: 'left',
		items: {
			'userInfo': {
				name: '회원정보 보기',
				callback: function(key, option) {
					var popupUrl = '${pageContext.request.contextPath}/board/getUserInfoPopup.do?c_id=${article.regId}';
					var popupOption = 'width=370, height=360, left=150, top=150, resizable=no, scrollbars=no, status=no;'; 
					window.open(popupUrl, '', popupOption);
				}
			},
			'sendNote': {
				name: '쪽지 보내기',
				callback: function(key, option) {
					var popupUrl = '${pageContext.request.contextPath}/board/sendNotePopup.do?c_id=${article.regId}';
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
										<a href="${pageContext.request.contextPath}/board/modifyArticle.do?c_id=${article.c_id}">수정</a>
										<a href="#" onclick="deleteThisArticle(${article.c_id})">삭제</a>
										<a href="${pageContext.request.contextPath}/board/newReplyArticle.do?c_id=${article.c_id}">답글쓰기</a>
										<a href="${pageContext.request.contextPath}/board/index.do">목록가기</a>
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