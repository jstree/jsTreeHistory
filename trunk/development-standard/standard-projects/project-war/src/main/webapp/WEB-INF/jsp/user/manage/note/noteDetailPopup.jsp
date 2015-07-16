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
.responsive-row {height:80px}
.responsive-row:after {display:block; content:''; clear:both}
.responsive-row .one-quarter {width:185px}
.one-quarter input[type=text] {display:inline-block; width:50%; text-align:right}
.responsive-row button {float:right}
</style>

<customTags:assetsJsExtendNas theRestOfFileName="/js/jquery-1.11.2.min.js"></customTags:assetsJsExtendNas>
<script type="text/javascript">	
	$(function () {		
		
	});
</script>
</head>
<body>
	<div class="container clearfix">
		<div class="one-whole boxed">
			<section class="">
				<div class="responsive-row">
					<div class="item-name">제목</div>
					<div class="item-value">
						<input id="c_title" name="c_title" type="text" value="${userNoteDetail.c_title}">
					</div>
				</div>
				<div class="responsive-row">
					<div class="item-name">내용</div>
					<div class="item-value">
						<textarea id="content" name="content">${userNoteDetail.content}</textarea>
					</div>
				</div>
				<div class="responsive-row">
					<div class="item-name">첨부파일</div>
					<div class="item-value">
						<c:forEach var="item" items="${userNoteDetail.userNoteAttachFileList}">
							<span><a href="${pageContext.request.contextPath}/user/manage/note/downloadNoteFile.do?fileName=${item.c_id}" target="_self">${item.c_title}</a></span>
						</c:forEach>			
					</div>
				</div>
				<div class="responsive-row button-area">
					<button id="searchBtn" type="submit">답장하기</button>
				</div>
			</section>
		</div>
	</div>
</body>
</html>

