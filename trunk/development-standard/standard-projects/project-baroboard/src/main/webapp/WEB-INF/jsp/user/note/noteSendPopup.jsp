<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쪽지 보내기</title>
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

	var USER_LIST = []; //쪽지 수신인 유저 리스트
	
	$(function () {
		$("input:text").bind('keydown',function(e) {	        
			if (e.keyCode == 13){
	            return false;
	        }
	    });
		
		$("#sendForm").submit(function() {			
			return false;
	    });
		
		$('#userNm').bind('keydown', function(e){
			if(e.keyCode == 13){
				callAjax(  null
		                   , '${pageContext.request.contextPath}/user/note/inquiryUserNickname.do'
		                   , null
		                   , 'post'
		                   , 'json'
		                   , {
								'userNm' : $('#userNm').val()
							 }
		                   ,'application/json'
		                   , function(r){
		                	   if(r.c_id > 0){
		                		   var inVal = false;
			                	   $(USER_LIST).each(function(index, value){			                		   
			                		   if(r.c_id == value.userId){
			                			   inVal = true;
			                			   return false;
			                		   }  
			                	   });
			                	   
			                	   if(inVal){
			                		   alert('기 추가된 사용자');
			                	   }else{
			                		   USER_LIST.push({'userId' : r.c_id, 'noteTypeCode' : 3});
			                		   $('#userList').append('<span>' + r.c_title + '</span>');
			                	   }
		                		   $('#userNm').val('');
		                		   
		                	   }else{
		                		   alert('존재하지 않는 사용자');
		                	   }
		                     }
						);
				
				return false;
			}
		});
		
		$('#sendNoteForm').ajaxForm({	
			 type : 'post'			
			,contentType : 'multipart/form-data'			
			,beforeSubmit: function(formArray, jqForm, options){
				var userId = $('#receUserId').val();
				
				if(userId != null && userId != ''){
					USER_LIST.push({'userId' : userId, 'noteTypeCode' : 3});
					
				}else if(USER_LIST.length == 0){
					$('#userNm').focus();
					alert("수신인이 존재하지 않습니다.");
					return false;
				}
				
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
					                  		,'userNoteByUserList'     : USER_LIST
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
			<section class="">
				<form id="sendNoteForm" action="${pageContext.request.contextPath}/user/note/uploadNoteFile.do" method="post" enctype="multipart/form-data">
				<div class="responsive-row">
					<div class="item-name">수신자</div>
					<c:choose>
						<c:when test="${empty userInfo}">
							<div class="item-value">
								<input id="userNm" name="userNm" type="text">
							</div>
							<div id="userList">
							</div>
						</c:when>
						<c:otherwise>
							<div class="item-value">
								<p id="userNm" name="userNm">${userInfo.c_title}</p>
								<input type="hidden" id="receUserId" name="receUserId" value="${userInfo.c_id}"/>
							</div>					
						</c:otherwise>
					</c:choose>
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
			</section>
		</div>
	</div>
</body>
</html>