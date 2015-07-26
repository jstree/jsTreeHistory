<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags" %>

<!DOCTYPE html>
<html lang="ko" class="js">
<head>
<title>${boardName} - 글쓰기</title>
<!-- !!!  FOR THIS PAGE ONLY !!! -->
<script src="${pageContext.request.contextPath}/assets/js/ckeditor/ckeditor.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/assets/css/newArticle.css" rel="stylesheet" type="text/css" media="all" />

<style>
/* 
div#titleDiv > div {
	max-width: 300px;
}

 */
 
div#titleDiv > div > span:first-child {
	width : 60px;
}
div#titleDiv > div input {
	display: inline !important;
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
						<h1 class="bm-remove">${boardName}</h1>
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
							<c:choose>
								<c:when test="${not empty parentArticle}">
							<form id="articleForm" action="${pageContext.request.contextPath}/board/submitNewReplyArticle.do" method="post" accept-charset="utf-8">
								</c:when>
								<c:otherwise>
							<form id="articleForm" action="${pageContext.request.contextPath}/board/submitNewArticle.do" method="post" accept-charset="utf-8">
								</c:otherwise>
							</c:choose>
								<div id="titleDiv">
									<div>
										<span>
											<label>제목</label>
										</span>
										<span>
											<c:choose>
												<c:when test="${not empty parentArticle}">
												<input id="rootArticleID" name="rootArticleID" type="hidden" value="${parentArticle.rootArticleID}" />
												<input id="parentArticleID" name="ref" type="hidden" value="${parentArticle.c_id}" />
												<input id="articleTitle" name="c_title" type="text"	value="RE: ${parentArticle.c_title}" />
												</c:when>
												<c:otherwise>
												<input id="articleTitle" name="c_title" type="text"	/>
												</c:otherwise>
											</c:choose>
										</span>
									</div>
									<input id="isGuestFL" name="isGuestFL" type="hidden" value="${isGuestFL}" />
									<%-- 게스트글 닉네임, 비밀번호 입력 --%> 
									<div>
										<span>
											<label>닉네임</label>
										</span>
										<input id="guestNickName" name="guestNickName"type="text" />
									</div>
									<div>
										<span>
											<label>글 비밀번호</label>
										</span>
										<input id="guestPW" name="guestPW"type="password" />
									</div>
								</div>
								<div>
									<textarea name="content" id="editor" rows="10" cols="80"></textarea>
									<script>
										CKEDITOR.replace('editor');
									</script>
								</div>
								<div id="additionalInputs">
									<div class="additional-input-div">
										<span>
											<input id="allowCommentFL" type="checkbox" name="allowCommentFL" value="1" checked />
											<label for="allowCommentFL">댓글 허용</label>
										</span>
										<span>
											<input id="allowTrackbackFL" type="checkbox" name="allowTrackbackFL" value="1" checked />
											<label for="allowTrackbackFL">엮인글 허용</label>
										</span>
										<span>
											<input id="alertResponseFL" type="checkbox" name="alertResponseFL" value="1" checked />
											<label for="alertResponseFL">알림</label>
										</span>
										<span>
											<input id="openArticleFL" type="checkbox" name="openArticleFL" value="1" checked />
											<label for="openArticleFL">공개</label>
										</span>
									</div>
									<div class="additional-input-div">
										<div>
											파일 첨부
											<select id="fileAttachSelect"multiple="multiple" size=3>
												<option>test1.html</option>
												<option>test2.css</option>
												<option>test3.css</option>
												<option>test4.css</option>
												<option>test5.css</option>
											</select>
										</div>
										<div>
											<button class="file-btn">추가</button>
											<button class="file-btn">삭제</button>
										</div>
									</div>
									<div class="action-btn-div">
										<input type="submit" value="저장"/>
									</div>
								</div>
							</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>
	</section>
	<script>
$('#articleForm').on('submit',function(e){
    e.preventDefault();
    CKEDITOR.instances.editor.updateElement();	// CKEditor를 refresh함
    if ($.trim($('#articleTitle').val()) != '') {
    	
   		if( $.trim($('#guestNickName').val()) == '') {
   			alert('닉네임을 입력해주세요.');
   			return;
   		}
   		if( $.trim($('#guestPW').val()) == '') {
   			alert('글 비밀번호를 입력해주세요.');
   			return;
   		}
   		
    	$.ajax({
   		  url: this.action,
   		  method: 'POST',
   		  contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
   		  data: $('#articleForm').serialize(),
   		}).done(function(data){
   			alert('저장되었습니다.');
			window.location.href = '${pageContext.request.contextPath}/board/readArticle.do?c_id='+data.c_id ;
   		}).fail(function(data){
   			alert('저장에 실패하였습니다.');
   			console.log(data); 
   		})
    } else {
    	alert("글제목을 입력해주세요.");
    }	    
});
	</script>
</body>
</html>