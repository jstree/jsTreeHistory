<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags" %>

<!DOCTYPE html>
<html lang="ko" class="js">
<head>
<title>${boardName} - 글 수정하기</title>
<!-- !!!  FOR THIS PAGE ONLY !!! -->
<script src="${pageContext.request.contextPath}/assets/js/ckeditor/ckeditor.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/assets/css/newArticle.css" rel="stylesheet" type="text/css" media="all" />

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
							<form id="articleForm" action="${pageContext.request.contextPath}/board/submitModifiedArticle.do?c_id=${article.c_id}" method="post" accept-charset="utf-8">
								<div id="titleDiv">
									<span>
										<label>제목</label>
									</span>
									<span>
										<input id="articleTitle" name="c_title" type="text" value="${article.c_title}"/>
									</span>
									<!-- TODO : Admin일경우 공지선택가능 -->
									<span id="announceSpan">
										<input type="checkbox" id="announcementFL" name="announcementFL" value="1" <c:if test="${article.announcementFL == '1'}">checked</c:if> />
										<label for="announcementFL">공지</label>
									</span>										
								</div>
								<div>
									<textarea name="content" id="editor" rows="10" cols="80">${article.content}</textarea>
									<script>
										CKEDITOR.replace('editor');
									</script>
								</div>
								<div id="additionalInputs">
									<div class="additional-input-div">
										<span>
											<input id="allowCommentFL" type="checkbox" name="allowCommentFL" value="1" <c:if test="${article.allowCommentFL == '1'}">checked</c:if> />
											<label for="allowCommentFL">댓글 허용</label>
										</span>
										<span>
											<input id="allowTrackbackFL" type="checkbox" name="allowTrackbackFL" value="1" <c:if test="${article.allowTrackbackFL == '1'}">checked</c:if> />
											<label for="allowTrackbackFL">엮인글 허용</label>
										</span>
										<span>
											<input id="alertResponseFL" type="checkbox" name="alertResponseFL" value="1" <c:if test="${article.alertResponseFL == '1'}">checked</c:if> />
											<label for="alertResponseFL">알림</label>
										</span>
										<span>
											<input id="openArticleFL" type="checkbox" name="openArticleFL" value="1" <c:if test="${article.openArticleFL == '1'}">checked</c:if> />
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
$(document).ready(function(){
	$('#articleForm').on('submit',function(e){
	    e.preventDefault();
	    if ($.trim($('#articleTitle').val()) != '') {
	    	CKEDITOR.instances.editor.updateElement();	// CKEditor를 refresh함
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
})
	</script>
</body>
</html>