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

<!-- Jquery Context Menu -->
<link href="${pageContext.request.contextPath}/assets/css/backbone.scss.css?20" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.2.min.js"></script>
<!--  <link href="${pageContext.request.contextPath}/assets/js/jqueryContextMenu/jquery.contextMenu.css" rel="stylesheet" type="text/css" media="all" />-->
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
					var popupUrl = '${pageContext.request.contextPath}/board/getUserInfoPopup.do?c_id=${article.regID}';
					var popupOption = 'width=370, height=360, left=150, top=150, resizable=no, scrollbars=no, status=no;'; 
					window.open(popupUrl, '', popupOption);
				}
			},
			'sendNote': {
				name: '쪽지 보내기',
				callback: function(key, option) {
					var popupUrl = '${pageContext.request.contextPath}/board/sendNotePopup.do?c_id=${article.regID}';
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
											<span id="articleDt">${article.regDt}</span>
										</span>
										<span id="secondInfoRow">
											<span>조회수: ${article.viewCnt}</span>
											<span>추천수: ${article.likeCnt}</span>
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
										<c:choose>
											<c:when test="${comment.isDeletedFL == '1' }">
											<div class="rdc-body"><p><i class="fa fa-times"></i><span class="bold">삭제된 코멘트 입니다.</span></p></div>
											</c:when>
											<c:when test="${comment.viewForRegOnlyFL == '1'}">
											<div class="rdc-body"><p><i class="fa fa-lock"></i><span class="bold">글쓴이만 볼 수 있는 코멘트 입니다.</span></p></div>
											</c:when>
											<c:otherwise>
											<div class="rdc-header">
												<span class="rdc-reg-id">${comment.regNickName}</span>
												<span class="rdc-reg-date">${comment.regDT}</span>
												<%-- TODO : 일반사용자만 코멘트 작성 가능 --%>
												<span><a onclick="addCommentReply(this, ${comment.c_id})">답글달기</a></span>
												<span><a onclick="deleteThisReply(this, ${comment.c_id})">삭제</a></span>
											</div>
											<div class="rdc-body"><p>${comment.c_title}</p></div>
											</c:otherwise>
										</c:choose>
									</div>
									</c:forEach>
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
								
								<!-- 하단 Action -->
								<div id="articleAction">
									<span>
										<%-- 일반 사용자 : 아이디 체크값 받아서 수정/삭제 가능여부 체크 --%>
										<c:choose>
											<c:when test="${article.likeFL == '0'}">
												<a id="likeAnchor" onclick="likeArticle(${article.c_id})">좋아요</a>
											</c:when>
											<c:otherwise>
												<a onclick="cancelLikeArticle(${article.c_id})">좋아요 취소</a>
											</c:otherwise>
										</c:choose>
										<%-- 수정/삭제 --%>
										<c:if test="${loginedUserID eq article.regID}">
											<a onclick="modifyThisArticle(${article.c_id}, 0)">수정</a>
											<a onclick="deleteThisArticle(${article.c_id}, 0)">삭제</a>
										</c:if>
										<%-- TODO : 답글가능여부 체크, 일반 사용자만 답글 달기 가능 --%>
										<%-- 
										<a href="${pageContext.request.contextPath}/board/newReplyArticle.do?c_id=${article.c_id}">답글쓰기</a>
										--%>
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
	<script>
	function modifyThisArticle(c_id, isGuestUser) {

		 var form = document.createElement('form');
		 form.setAttribute('method', 'post');
		 form.setAttribute('action', '${pageContext.request.contextPath}/board/modifyArticle.do');
		 
		 var idInput = document.createElement('input');
		 idInput.setAttribute('type', 'hidden');
		 idInput.setAttribute('name', 'c_id');
		 idInput.setAttribute('value', c_id);
		 form.appendChild(idInput);
		 
		 if($('#isGuestFL').val() == '1') { // 게스트사용자
			 var guestPassword = $('#guestPassword').val();
			 if(guestPassword == '') {
				 alert('글 비밀번호를 입력해주세요.');
				 return;
			 }
			 var encryptedPW = Sha256.hash(guestPassword);
			 
			 var pwInput = document.createElement('input');
			 pwInput.setAttribute('type', 'hidden');
			 pwInput.setAttribute('name', 'guestPW');
			 pwInput.setAttribute('value', encryptedPW);
			 form.appendChild(pwInput);
		 }
		 
		form.submit();		 
	 }
	
	function likeArticle(articleID) {
		var obj = {};
		obj.articleID = articleID;
		$.ajax({
	   		  url: '${pageContext.request.contextPath}/board/likeArticle.do',
	   		  method: 'POST',
	   		  contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
	   		  data: obj
	   		}).done(function(data){
				$('#likeAnchor').text('좋아요 취소');
				$('#likeAnchor').attr('onclick','cancelLikeArticle(${article.c_id})');
	   		}).fail(function(data){
	   			alert('좋아요 작업에 실패하였습니다.');
	   			console.log(data); 
	   		})
	}
	
	function cancelLikeArticle(articleID) {
		var obj = {};
		obj.articleID = articleID;
		$.ajax({
	   		  url: '${pageContext.request.contextPath}/board/cancelLikeArticle.do',
	   		  method: 'POST',
	   		  contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
	   		  data: obj
	   		}).done(function(data){
				$('#likeAnchor').text('좋아요');
				$('#likeAnchor').attr('onclick','likeArticle(${article.c_id})');
	   		}).fail(function(data){
	   			alert('좋아요 취소 작업에 실패하였습니다.');
	   			console.log(data); 
	   		})
	}
	
	function deleteThisReply(btn, c_id){
		if(confirm("코멘트를 삭제하시겠습니까?") == true){
			var obj = {};
			obj.c_id = $(btn).parent('div').closest('.write-comment').attr('data-id');

			$.ajax({
	   		  url: '${pageContext.request.contextPath}/board/deleteComment.do',
	   		  method: 'POST',
	   		  contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
	   		  data: obj
	   		}).done(function(data){
	   			alert('삭제되었습니다.');
				window.location.href = '${pageContext.request.contextPath}/board/readArticle.do?c_id='+ articleID;
	   		}).fail(function(data){
	   			alert('삭제에 실패하였습니다.');
	   			console.log(data); 
	   		})
		}
	}
	
	
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

</script>
</body>
</html>