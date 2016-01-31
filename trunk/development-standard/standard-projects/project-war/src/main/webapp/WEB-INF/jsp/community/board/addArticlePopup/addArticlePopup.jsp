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
	});
	// ]]>
</script>
<style>
<!--
	textarea{
		margin: 0;
		width: 100%;
		max-width: 100%;
	}
	
	input[type="text"],
	input[type="email"],
	input[type="password"],
	input[type="file"]{
		margin: 0;
	}

	.bottom_btn{
		
		text-align: center;
	}
	
	.write th{
			border: 1px solid #d8d8d8;
			border-left:0;
			background: #eaeaea;
			text-align: left;
			padding: 10px;
	}
	
	.write td{
			border-top: 1px solid #d8d8d8;
			border-bottom: 1px solid #d8d8d8;
			background: white;
			padding: 10px;
	}
	
	.write {
		width: 100%;
	}
	
	.form_wrap{
		padding: 10px;
	}
-->
</style>
</head>

<body id="demo_body">
	<div>
		<h2>글 쓰기</h2>
	</div>
	
	<hr>
	
	<div class="form_wrap">
		<form method="post" action="">
			<table class="write">
				<tbody>
					<tr>
						<th scope="row">
							이름
						</th>
						<td>
							<input type="text" title="이름">
						</td>
					</tr>
					<tr>
						<th scope="row">
							비밀번호
						</th>
						<td>
							<input type="password" title="비밀번호">
						</td>
					</tr>
					<tr>
						<th scope="row">
							이메일
						</th>
						<td>
							<input type="email" title="이메일">
						</td>
					</tr>
					<tr>
						<th scope="row">
							제목
						</th>
						<td>
							<input type="text" title="제목">
						</td>
					</tr>
					<tr>
						<th scope="row">
							내용
						</th>
						<td>
							<textarea>
							</textarea>
						</td>
					</tr>
					<tr>
						<th scope="row">
							파일1
						</th>
						<td>
							<input type="file" title="파일1">
						</td>
					</tr>
					<tr>
						<th scope="row">
							파일2
						</th>
						<td>
							<input type="file" title="파일2">
						</td>
					</tr>
					<tr>
						<th scope="row">
							자동등록방지
						</th>
						<td>
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="bottom_btn">
				<input type="button" title="작성완료" value="작성완료">
				<input type="button" title="취소" value="취소">
			</div>
		</form>
	</div>
</body>
</html>
