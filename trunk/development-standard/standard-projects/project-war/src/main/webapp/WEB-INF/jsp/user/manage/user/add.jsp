<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
</head>

<body>
<div id="divPopup"></div>

<script>
$(document).ready(function() {
	
	callAjax(null
           , '/user/join/agreement/next.do'
           , { target : '#divPopup', selector : 'section' }
//            , '#divPopup'
           , 'post'
           , 'html'
           , null
           , null
           , callback);
	
	function callback(r) {
	    	
    }
});
</script>
</body>
</html>