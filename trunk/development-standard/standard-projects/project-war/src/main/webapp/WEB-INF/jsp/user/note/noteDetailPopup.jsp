<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세 조회</title>
<link href="${pageContext.request.contextPath}/assets/css/backbone.scss.css?20" rel="stylesheet" type="text/css" media="all" />
<!-- !!!  FOR THIS PAGE ONLY !!! -->
<link href="${pageContext.request.contextPath}/assets/css/common_popup.css" rel="stylesheet" type="text/css" media="all">

<style type="text/css">
.responsive-row button {float:right}
section + section {display:none}
</style>

<customTags:assetsJsExtendNas theRestOfFileName="/js/jquery-1.11.2.min.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/ajax.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/jquery.form.js"></customTags:assetsJsExtendNas>

<script type="text/javascript">	
	jQuery.browser = {};
	(function () {
	    jQuery.browser.msie = false;
	    jQuery.browser.version = 0;
	    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
	        jQuery.browser.msie = true;
	        jQuery.browser.version = RegExp.$1;
	    }
	})();
	
	$(function () {		
		
		$('#rtnNote').bind('click', function(e){
			$('#noteDetailSection').hide();
			$('#noteSendSection').show();
		});
		
		$("#sendForm").submit(function() {			
			return false; // cancel conventional submit
	    });
		
		$('#sendNoteForm').ajaxForm({	
			 type : 'post'			
			,contentType : 'multipart/form-data'			
			,beforeSubmit: function(formArray, jqForm, options){
				var saveFileNm = "";
				$(formArray).each( function(idx, value){
					if('attachFile' == this.name && '' != this.value && null != this.value){
						saveFileNm = this.value;
						return false;
					}
				});
				if('' == saveFileNm || null == saveFileNm){
					options.contentType = 'application/x-www-form-urlencoded; charset=UTF-8';	
				}
			}
			,success : function(r, stat){
					   		var fileList = jQuery.parseJSON(r.replace(/(<([^>]+)>)/ig,""));
						
							var fileNmList = [];
							$(fileList).each(function(i){
								fileNmList.push({'storeFileNm' : this.storeFileNm, 'c_title' : this.c_title});
							});
							
							callAjax(  null
					                  , '${pageContext.request.contextPath}/user/note/sendNote.do'
					                  , null
					                  , 'post'
					                  , 'json'
					                  , {
					                   		'c_title'  : $('#c_title').val()
					                   		,'content' : $('#content').val()
					                  		,'userNoteByUserList'     : [{'userId' : $('#c_id').val(), 'noteTypeCode' : 3}]
					                   		,'userNoteAttachFileList' : fileNmList
					                    }
					                  , 'application/json; charset=utf-8'
					                  , function(r){
					                   		window.close();
					                    }
					                  );
			         }
			,error : function(r){
				alert(r);
			}
		});
	});
	
</script>
</head>
<body>
	<div class="container clearfix">
		<div class="one-whole boxed">
			<section class="" id="noteDetailSection">
				<div class="responsive-row">
					<div class="item-name">제목</div>
					<div class="item-value">${userNoteByUser.c_title}</div>
				</div>
				<div class="responsive-row">
					<div class="item-name">내용</div>
					<div class="item-value" id="noteContent" style="white-space:normal;">
						${userNoteByUser.content}
					</div>
				</div>
				<div class="responsive-row">
					<div class="item-name">첨부파일</div>
					<div class="item-value">
						<c:forEach var="item" items="${userNoteByUser.userNoteAttachFileList}">
							<span><a href="${pageContext.request.contextPath}/user/note/downloadNoteFile.do?fileName=${item.c_id}" target="_self">${item.c_title}</a></span>
						</c:forEach>			
					</div>
				</div>
				<div class="responsive-row button-area">
					<button id="rtnNote" type="button">답장하기</button>
				</div>
			</section>
			<section class="" id="noteSendSection">
				<form id="sendNoteForm" action="${pageContext.request.contextPath}/user/note/uploadNoteFile.do" method="post" enctype="multipart/form-data">
					<div class="responsive-row">
						<div class="item-name">수신자</div>
						<div class="item-value">
							<p id="userNm" name="userNm">${userNoteByUser.userNm}</p>
						</div>
					</div>
					<div class="responsive-row">
						<div class="item-name">제목</div>
						<div class="item-value">
							<input id="c_title" name="c_title" type="text">
						</div>
					</div>
					<div class="responsive-row">
						<div class="item-name">내용</div>
						<div class="item-value">
							<textarea id="content" name="content"></textarea>
						</div>
					</div>
					<div class="responsive-row">
						<div class="item-name">첨부파일</div>
						<div class="item-value">
							<input id="attachFile" class="reset-btn" type="file" name="attachFile" value="추가">
						</div>		
					</div>
					<div class="responsive-row button-area">
						<button id="sendBtn" type="submit">보내기</button>
					</div>
				</form>
				<input type="hidden" id="c_id" name="c_id" value="${userNoteByUser.userId}"/>
			</section>
		</div>
	</div>
</body>
</html>