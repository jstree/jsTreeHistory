<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- saved from url=(0044)http://localhost:8080/devTool/313DevALMCI.do -->
<html lang="ko" class="js">
<head data-placeholder-focus="false" data-placeholder-live="false">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<!--[if lt IE 9]>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.2/html5shiv.min.js" type="text/javascript"></script>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js" type="text/javascript"></script>
      <script>window.html5 || document.write('<script src="/assets/js/cdn-fallback-html5-shiv.min.js?20"><\/script>');</script>
      <script>window.respond || document.write('<script src="/assets/js/cdn-fallback-respond.min.js?20"><\/script>');</script>
      <![endif]-->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>JsTree 아키텍쳐, 바로보드 Java 설치형 게시판 솔루션, 오픈소스 313 자바 개발자 그룹
	커뮤니티</title>
<!-- Framework & Plugins -->
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/font-awesome.css" rel="stylesheet" type="text/css"
	media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/normalize.min.css" rel="stylesheet" type="text/css"
	media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/edge-alerts.css" rel="stylesheet" type="text/css"
	media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/tipsy.css" rel="stylesheet" type="text/css"
	media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/pop-growl.css" rel="stylesheet" type="text/css"
	media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/animations.min.css" rel="stylesheet" type="text/css"
	media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/pro-bars.min.css" rel="stylesheet" type="text/css"
	media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/responsive-tabs.css" rel="stylesheet" type="text/css"
	media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/responsive-accordion.css" rel="stylesheet"
	type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/responsive-toggle.css" rel="stylesheet"
	type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/owl-carousel.css" rel="stylesheet" type="text/css"
	media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/litebox.css" rel="stylesheet" type="text/css"
	media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/shopify-quick-look.css" rel="stylesheet"
	type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/backbone.scss.css" rel="stylesheet" type="text/css"
	media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/section_common.css" rel="stylesheet" type="text/css"
	media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/common-font.css" rel="stylesheet" type="text/css"
	media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/common-font.css" rel="stylesheet" type="text/css"
	media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/lib/jNotify.jquery.css" rel="stylesheet" type="text/css"
	media="all">
<style type="text/css">
table a span {
	display: inline-block;
	width: 100%;
}

input[type="text"] {
	display: inline;
	width: 150px !important;
	height: 30px !important;
	margin: 0 0 0px !important;
}

input[type="checkbox"] {
	display: inline;
	width: 20px !important;
	height: 20px !important;
	margin: 0 0 0px !important;
}
</style>
<!-- !!!  FOR THIS PAGE ONLY !!! -->
<link href="http://www.313.co.kr:5002/Component/jsp/admin/board/divSample.css" rel="stylesheet" type="text/css" media="all">
<!-- 313 ajax.js -->
<script src="${pageContext.request.contextPath}/assets/js/ajax.js" type="text/javascript"></script>
<script type="text/javascript">
var inputForm = {
		submit : function(target){
			form = target.id;
			$form = $('#' + target.id);
	            
            if (!confirm('저장하시겠습니까?')) {
                return false;
            }
            
            var ajaxResult = callAjax(form
                   , $form.prop('action')
                   , null
                   , $form.prop('method')
                   , 'json'
                   , null
                   , null);
            
		}
}
</script>
</head>
<body class="template-index" gtools_scp_screen_capture_injected="true">
	<section>
		<div class="three-quarter last boxed p-twenty clearfix"	data-anim-type="fade-in" data-anim-delay="0">
			<form name="ftpForm" id="ftpForm" method="post" action="${pageContext.request.contextPath}/core/manage/setting/ftp/save.do">
				<input type="hidden" name="c_id" id="c_id" value="${ftp.c_id}"/>
				<div id="samDiv" class="tablet-mobile alpha bm-remove last">
					<div class="responsive_row">
						<div class="item_Lname">FTP 서버 주소 </div>
						<div class="item_Lvalue">
							<input name="ftpUrl" id="ftpUrl" type="text" value="${ftp.ftpUrl}">
						</div>
					</div>
					<div class="responsive_row">
						<div class="item_Lname">FTP 서버 Port</div>
						<div class="item_Lvalue">
							<input name="ftpPort" id="ftpPort" type="text" value="${ftp.ftpPort}">
						</div>
					</div>
					<div class="responsive_row">
						<div class="item_Lname">아이디 / 패스워드 </div>
						<div class="item_Lvalue">
							<input name="ftpId" id="ftpId" type="text" value="${ftp.ftpId}">
						</div>
						<div class="item_Rname"> / </div>
						<div class="item_Rvalue">
							<input name="ftpPassword" id="ftpPassword" type="text" value="${ftp.ftpPassword}">
						</div>
					</div>
					<div class="responsive_row ">
						<div class="item_Lname">Passive 모드 사용 설정</div>
						<div class="item_Lvalue">
							<input type="checkbox" name="passiveFl" id="passiveFl" value="1" <c:if test="${'1' == ftp.passiveFl}">checked</c:if>/>
						</div>
					</div>
					<div class="responsive_row">
						<div class="item_Lname">SFTP 사용 설정</div>
						<div class="item_Lvalue">
							<input type="checkbox" name="sftpFl" id="sftpFl" value="1" <c:if test="${'1' == ftp.sftpFl}">checked</c:if>/>
						</div>
					</div>
					<div class="responsive_row">
						<button id="saveBtn" onclick="inputForm.submit(this.form);return false;">저장</button>
					</div>
				</div>
			</form>	
	</section>
</body>
</html>