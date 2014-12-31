<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<script type="text/javascript" src="<c:url value='/js/encryption/md5.js'/>" ></script>  
<script type="text/javascript" src="<c:url value='/js/encryption/sha1.js'/>" ></script>
<script type="text/javascript" src="<c:url value='/js/encryption/sha256.js'/>" ></script>  
<script type="text/javascript" src="<c:url value='/js/encryption/sha512.js'/>" ></script>
<title>암호화 스크립트 페이지</title>
</head>
<body>
	<div>
		<table width="100%" style="text-align:center">
			<tr align="center">
				<th>Input</th>
				<td align="center">
			     	<input type="text" id="input" value="" >
			    </td>
			</tr>
			<tr>
				<th>Method</th>
				<td style="text-align:center">
					<input type="button" onclick="document.getElementById('output').value = hex_md5(document.getElementById('input').value)" value="MD5">
					<input type="button" onclick="document.getElementById('output').value = hex_sha1(document.getElementById('input').value)" value="SHA-1">
					<input type="button" onclick="document.getElementById('output').value = hex_sha256(document.getElementById('input').value)" value="SHA-256">
					<input type="button" onclick="document.getElementById('output').value = hex_sha512(document.getElementById('input').value)" value="SHA-512">
				</td>
			</tr>
			<tr align="center">
				<th>Result</th>
				<td>
			    	<input type="text" id="output" value="" readonly>
			   </td>
			</tr>
		</table>
	</div>
</body>
</html>

