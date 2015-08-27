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
<customTags:assetsJsExtendNas theRestOfFileName="/js/ajax.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/jquery.form.js"></customTags:assetsJsExtendNas>


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
									<input id="boardID" name="boardID" type="hidden" value="test" />
									<input id="isGuestFL" name="isGuestFL" type="hidden" value="${isGuestFL}" />
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
											</select>
											<div id="fileListDiv" style="display: none">
												<input id="fileInput0" name="files" type="file" />
											</div>
										</div>
										<div>
											<a id="addFileBtn" class="file-btn">추가</a>
											<a id="removeFileBtn" class="file-btn">삭제</a>
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
		var FILE_ARR = [];
		var FILE_CNT_NUM = 0;
		
		$(document).ready(function(){
			
			// 파일추가 버튼
			$('#addFileBtn').click(function(){
				
				if(FILE_ARR.length >= 10) {
					alert('첨부파일은 10개까지 가능합니다.');
					return;
				}
				
				var fileID = 'fileInput' + FILE_CNT_NUM;
				var targetFileID = '#' + fileID;

				$(targetFileID).change(function(){
					if(this.value.length != 0) {	// 변경이 있을때만
						
						var fileName = this.value.split('\\').pop();
						
						$('#fileAttachSelect').append( $('<option>', {
						    value: fileID,
						    text: fileName
						}));
						
						FILE_ARR.push(fileID);
						
						var inputStr = '<input id="fileInput' + ++FILE_CNT_NUM +'" name="files" type="file">';
						$('#fileListDiv').append(inputStr);
						
					}
				});
				
				$(targetFileID).trigger('click');
				
			});	
		
			// 파일 삭제 버튼
			$('#removeFileBtn').click(function(){
				$('#fileAttachSelect option:selected').each(function(){
					$('#' + $(this).val()).remove();
					
					for(var i=0; i<FILE_ARR.length; i++) {
						if(FILE_ARR[i] == $(this).val()) {
							FILE_ARR.splice(i, 1);
							break;
						}
					}
					
					$(this).remove();
				});
			});			
			
			
		});	
	</script>
	
	<script>
$('#articleForm').on('submit',function(e){
    e.preventDefault();
    CKEDITOR.instances.editor.updateElement();	// CKEditor를 refresh함
    if ($.trim($('#articleTitle').val()) != '') {
    	
    	$('#articleForm').ajaxForm({	
			 type : 'post'			
			,dataType : 'text'
			,contentType : 'multipart/form-data'
			,beforeSubmit: function(formArray, jqForm, options){
				
			}
			,success : function(r, stat){
		   		var resultObj = jQuery.parseJSON(r.replace(/(<([^>]+)>)/ig,""));

				alert(resultObj);
				window.location.href = '${pageContext.request.contextPath}/board/readArticle.do?c_id='+resultObj.c_id ;
				
			}
			,error : function(r){
				alert(r);
			}
		});
    } else {
    	alert("글제목을 입력해주세요.");
    }	    
});
	</script>
</body>
</html>