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
/* Common */
a {
	color: #f45b4f;
}


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

/* Comment Reply */
div.write-comment.for-copy {
	visibility: collapse;
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
									<input id="articleID" type="hidden" value="${article.c_id}" />
									<span id="articleTitle"><h3>${article.c_title}</h3></span> 
									<span id="articleInfo">
										<span id="firstInfoRow">
											<span><a class="user-context">${article.regNickName}</a></span>
											<span id="articleDt">2015-05-03 09:15:25</span>
										</span>
										<span id="secondInfoRow">
											<span>조회수: ${article.viewCnt}</span>
											<span>추천수: 0</span>
											<span id="articleAttachment"><a id="attachmentFile">첨부 (3)</a></span>
										</span>
									</span>
								</div>
								<!-- 내용 -->
								<div id="articleContent">
								${article.content} 
								</div>
								<!-- 코멘트 -->
								<div id="comment">
									<c:forEach var="comment" items="${commentList}" varStatus="status">
									<div data-id="${comment.c_id}" root-id="${comment.rootCommentID}" class="rdc-detail" style="padding-left: ${(comment.c_level -2) * 10}px">
										<div class="rdc-header">
											<span class="rdc-reg-id">${comment.regNickName}</span>
											<span class="rdc-reg-date">${comment.regDT}</span>
											<span><a onclick="addCommentReply(this, ${comment.c_id})">답글달기</a></span>
											<span><a href="">삭제</a></span>
										</div>
										
										<div class="rdc-body"><p>${comment.c_title}</p></div>
									</div>
									</c:forEach>
									
									<!-- 
									<div style="padding-left: 20px;" class="rdc-detail">
										<div class="rdc-header">
											<span class="rdc-reg-id">테스트2</span>
											<span class="rdc-reg-date">2015-07-05 12:11:30</span>
											<span><a onclick="addCommentReply(this, ${comment.c_id})">답글달기</a></span>
											<span><a href="">삭제</a></span>
										</div>
										<div class="rdc-body"><p>글쓴이만 보이는 코멘트입니다.</p></div>
									</div>
									 -->
								</div>
								<!-- 코멘트작성 -->
								<div id="writeRootCommentDiv" class="write-comment">
									<div class="write-comment-header">
										<div>코멘트작성</div>
										<div>
											<input class="author-only" type="checkbox" name="authorOnly">
											<label for="authorOnly">글쓴이만 보기</label>
										</div>
									</div>
									<div class="write-comment-body"><textarea class="write-comment-input"></textarea></div>
									<div class="write-comment-btn"><button onclick="addComment(this, 'root')">등록</button></div>								
								</div>
								<!-- 코멘트 리플 복사 -->
								<div class="write-comment for-reply for-copy">
									<div class="write-comment-header">
										<div>코멘트 답글 작성</div>
										<div>
											<input class="author-only" type="checkbox" name="authorOnly">
											<label for="authorOnly">글쓴이만 보기</label>
										</div>
									</div>
									<div class="write-comment-body"><textarea class="write-comment-input"></textarea></div>
									<div class="write-comment-btn"><button>등록</button></div>								
								</div>
								<!-- 하단 Action 칸 -->
								<div id="articleAction">
									<span>
										<a href="${pageContext.request.contextPath}/board/modifyArticle.do?c_id=${article.c_id}">수정</a>
										<a onclick="deleteThisArticle(${article.c_id})">삭제</a>
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
	<script>
	
	function addCommentReply(btn, ref) {
		var copiedCommentDivCheck = $('div.for-reply.copied');
		if($(copiedCommentDivCheck).length != 0) {
			$(copiedCommentDivCheck).remove();
		}

		var parentComment = $(btn).closest('.rdc-detail');
		var parentID = $(parentComment).attr('data-id');
		var rootID = $(parentComment).attr('root-id');
		
		var copiedCommentDiv = $('div.for-reply.for-copy').clone().removeClass('for-copy').addClass('copied');
		$(copiedCommentDiv).find('.write-comment-btn').children('button').attr('onclick', 'addComment(this, '+ parentID +')')
		$(copiedCommentDiv).attr('root-id', rootID);
		$(parentComment).append(copiedCommentDiv);
	}
	
	function addComment(btn, ref) {
		
		var commentDiv = $(btn).parent('div').closest('.write-comment');
		var viewOnlyRegIDFL = $(commentDiv).find('.author-only').is(":checked") ? '1' : '0';
		var c_title = $(commentDiv).find('.write-comment-input').val();
		var articleID = $('#articleID').val();
		var obj = {
				articleID: articleID,
				viewOnlyRegIDFL: viewOnlyRegIDFL,
				c_title: c_title
		};
		
		if(c_title == '') {
			alert('코멘트 내용을 입력해주세요.');
			return;
		}
		
		if(ref == 'root') {
			obj.isRoot = '1';
			
			
			console.log(obj);
			
		} else {
			obj.isRoot = '0';
			obj.ref = ref;
			var rootID = $(commentDiv).attr('root-id');
			obj.rootCommentID = rootID;
			
			console.log(obj);
		}	
		
		$.ajax({
	   		  url: '${pageContext.request.contextPath}/board/addComment.do',
	   		  method: 'POST',
	   		  contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
	   		  data: obj,
	   		}).done(function(data){
	   			alert('저장되었습니다.');
				window.location.href = '${pageContext.request.contextPath}/board/readArticle.do?c_id='+ articleID;
	   		}).fail(function(data){
	   			alert('저장에 실패하였습니다.');
	   			console.log(data); 
	   		})
	}
	</script>
</body>
</html>