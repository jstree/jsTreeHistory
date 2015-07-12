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
.responsive-row {height:80px}
.responsive-row:after {display:block; content:''; clear:both}
.responsive-row .one-quarter {width:185px}
.one-quarter input[type=text] {display:inline-block; width:50%; text-align:right}
.responsive-row button {float:right}
</style>

<customTags:assetsJsExtendNas theRestOfFileName="/js/jquery-1.11.2.min.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/ajax.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/jquery.form.js"></customTags:assetsJsExtendNas>

<script type="text/javascript">	
	var USER_LIST = [];
	
	$(function () {
		$('#userNm').bind('keydown', function(e){
			if(e.keyCode == 13){
				callAjax(  null
		                   , '${pageContext.request.contextPath}/user/manage/note/inquiryUserNickname.do'
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
			                		   USER_LIST[USER_LIST.length] = { 'userId' : r.c_id/*, 'noteTypeCode' : 3*/};
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
		
		$("#sendForm").submit(function() {
			/*var formData = new FormData();
			formData.append('c_title', $('#c_title').val());
			formData.append('content', $('#content').val());
			formData.append('userNoteByUserList', JSON.stringify(USER_LIST));*/
			///formData.append('file', $('#addAttachFile')[0].files[0]);
			
			/*var queryString = $("#sendForm").serialize();
			alert(queryString);*/
			
			var options = {
				url           : '${pageContext.request.contextPath}/user/manage/note/sendNote.do'
				,type          : 'post'
				//,contentType   : 'application/json'
				//,dataType : 'json'
				,data : {
					    'c_title' : $('#c_title').val()
						,'content' : $('#content').val()
						,'userNoteByUserList' : [{userId : 1}, {userId : 2}]//JSON.stringify(USER_LIST)
					}
			};
			$.ajax(options);
			return false; // cancel conventional submit
	    });
		
		/*$('#sendForm').ajaxForm({
			beforeSubmit : function(formData, jqForm, options){
				var queryString = JSON.stringify(USER_LIST);
				//alert(queryString);
				//$('#c_18').val(queryString);
				//var queryString = $.param(formData); 
				//alert('About to submit: \n\n' + queryString); 
				//$('#sendForm').append('<input name="userNoteByUserList" type="text" value="' + queryString + '">');
				
				//formData.push({userNoteByUserList : USER_LIST});
			}
		    ,dataType : 'json'
			,data : {
				 'c_id' : 181818
				//,'content' : '내용요요요요'
				//,'userNoteByUserList' : [{userId : 1}, {userId : 2}]//JSON.stringify(USER_LIST)
			}
			,success : function(r, stat){
				window.close();
			}
			,error : function(r){
				alert(r);
			}
		});
		
		/*$('#sendBtn').bind('click', function(e){
			var queryString = JSON.stringify(USER_LIST);
			alert(queryString);
			 $('#sendForm').append('<input name="userNoteByUserList" value="' + queryString + '">');
			
			 $.ajax({
				    url:'${pageContext.request.contextPath}/user/manage/note/sendNote.do',
				    data:$('#sendForm').serialize(),
				    cache:false,
				    processData:false,
				    contentType:false,
				    type:'POST',
				    success:function (data, status, req) {
				        
				    },
				    error:function (req, status, error) {
				       
				    }
				});
			*callAjax(    'sendForm'
	                   , '${pageContext.request.contextPath}/user/manage/note/sendNote.do'
	                   , null
	                   , 'post'
	                   , 'json'
	                   , null
	                   , 'multipart/form-data'//'application/json; charset=utf-8'
	                   , function(r){
	                	   window.close();
	                   }
			);*/
			
			/*callAjax({
				 form          : 'sendForm'
				,url           : '${pageContext.request.contextPath}/user/manage/note/sendNote.do'
				,type          : 'post'
				,contentType   : 'multipart/form-data'
				,returnType    : 'json'
				,callback      : function(r){
					             	alert(r);
			                     }
			    ,async         : false
			});*/
			
			//return false;
		//});*/		
	});
</script>
</head>
<body>
	<div class="container clearfix">
		<div class="one-whole boxed">
			<section class="">
				<form id="sendForm" action="${pageContext.request.contextPath}/user/manage/note/sendNote.do" method="post" enctype="multipart/form-data">
				<div class="responsive-row">
					<div class="item-name">수신자</div>
					<div class="item-value">
						<input id="userNm" name="userNm" type="text">
					</div>
					<div id="userList">
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
						<input id="addAttachFile" class="reset-btn" type="file" name="fileTest" value="추가">
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

