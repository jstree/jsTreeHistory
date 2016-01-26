<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" autoFlush="true"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<!DOCTYPE html>
<html lang="ko-KR">
<head>
<customTags:assetsJsExtendNas theRestOfFileName="/js/ckeditor_3.6.6.1/ckeditor.js"></customTags:assetsJsExtendNas>
<script type="text/javascript">
	// <![CDATA[
	$(document).ready(function($) {
		if (CKEDITOR.instances['content']) { 
			delete CKEDITOR.instances['content'] 
		};
		
		CKEDITOR.replace('content');
	});
	// ]]>
</script>
<style>
<!--
	.bottom_btn{
		padding-top: 10px;
	}
-->
</style>
</head>

<body id="demo_body">
	<div class="spr-container">
		<div class="spr-header">
			<h2 class="spr-header-title">글 쓰기</h2>
		</div>

		<div class="spr-content">
			<div class="spr-form">
				<form method="post" action="" id="" class="new-review-form">

					<fieldset class="spr-form-review">
						<div class="spr-form-review-title">
							<input class="spr-form-input spr-form-input-text" id="title" type="text" name="title" placeholder="제목을 입력 해주세요.">
						</div>
						<div>
							<textarea id="content" name="content"></textarea>
						</div>
						<div class="bottom_btn float-right">
							<input type="submit"value="저장">
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
