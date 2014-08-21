<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="ko"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang="ko"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang="ko"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="ko"> <!--<![endif]-->
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
<title>DWR Ajax 샘플</title>
<meta name="description" content="DWR Ajax 샘플 페이지입니다." />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="author" content="류강하" />
<link rel="stylesheet" href="http://nas.313.co.kr:5002/Component/jsp/dwr/sample/ajax/index/css/normalize.css" media="screen" />
<link rel="stylesheet" href="http://nas.313.co.kr:5002/Component/jsp/dwr/sample/ajax/index/css/main.css" media="screen" />
</head>
<body>
<div class="pageWrap">
  <select id="list">
  </select>
</div>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>
<script src="${pageContext.request.contextPath}/dwr/interface/AjaxService.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
jQuery(document).ready(function($) {
	
	AjaxService.getOptions(populateList);
	
	function populateList(data) {
		// DWRUtil.addOptions('list', data);
	}
});
</script>
</body>
</html>