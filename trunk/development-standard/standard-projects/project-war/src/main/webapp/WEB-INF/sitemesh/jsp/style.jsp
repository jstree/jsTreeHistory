<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
	<head data-placeholder-focus="false" data-placeholder-live="false">
		<link href="${pageContext.request.contextPath}/assets/images/fav-icon.png?20" relROOT="icon" />
		<link href="http://netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.css" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/normalize.min.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/edge-alerts.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/tipsy.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/pop-growl.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/animations.min.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/pro-bars.min.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/responsive-tabs.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/responsive-accordion.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/responsive-toggle.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/owl-carousel.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/litebox.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/shopify-quick-look.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/backbone.scss.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/section_common.css" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/common-font.css" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/jNotify.jquery.css" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/jquery.dataTables.css" rel="stylesheet" type="text/css" media="all">
        <link href="${pageContext.request.contextPath}/assets/css/dataTables.responsive.css" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.request.contextPath}/assets/css/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
		<!-- 시간이 없어서 우선 붙이고 차후 찾아서 올리던지 아니면 별도로 CSS파일로 대체예정 -->
		<!-- responsive-lnb -->
		<style type="text/css">
			#responsive-admin-menu {float:left;width:200px;background-color:#404040;height:100%;position:relative;overflow:hidden;left:0;min-height:500px}
			#content-wrapper{width:auto;margin-left:200px;background-color:#fff;height:1200px;padding:15px}
			#responsive-admin-menu #responsive-menu{height:50px;display:none;line-height:50px;cursor:pointer;color:#fff;text-indent:10px}
			#responsive-admin-menu #responsive-menu .menuicon{color:#fff;font-size:24px;position:absolute;right:10px;top:0}
			#responsive-admin-menu #logo{width:174px;height:40px;margin:10px}
			#responsive-admin-menu #menu{width:100%}
			#responsive-admin-menu #menu a{border-bottom:1px dotted #52535a;font-size:14px;text-decoration:none;display:block;padding:12px;color:#fff;position:relative;font-weight:400;overflow:hidden}
			#responsive-admin-menu #menu a:hover{color:#52535a;background-color:#fcfcfc}
			#responsive-admin-menu #menu i{width:16px;padding-right:4px}
			#responsive-admin-menu #menu div{display:none;width:100%;background-color:#5c5d64;overflow:hidden}
			#responsive-admin-menu #menu div a{color:silver}
			#responsive-admin-menu #menu div a:hover{color:#888}
			#responsive-admin-menu #menu a.submenu:before{font-family:FontAwesome;content:"\f054"}
			#responsive-admin-menu #menu a.downarrow:before{font-family:FontAwesome;content:"\f078"}
			#responsive-admin-menu #menu a.submenu:before{font-size:14px;position:absolute;right:15px;top:17px}
			@media screen and (max-width:960px){
			#responsive-admin-menu #responsive-menu{display:none}
			#responsive-admin-menu #menu a span{display:inline-block}}
			@media screen and (max-width:800px){
			#responsive-admin-menu #menu a span{display:none}
			#responsive-admin-menu{float:left;width:40px;position:relative}
			#responsive-admin-menu{height:100%}
			#content-wrapper{margin-left:40px}
			#responsive-admin-menu #menu a.submenu:before{font-size:6px;right:5px}
			#responsive-admin-menu #logo{width:29px;height:26px;margin:10px 10px 10px 5px}}
			@media screen and (max-width:480px){
			#responsive-admin-menu{min-height:50px;float:left;width:100%;background-color:#404040;height:auto;position:static;top:0}
			#responsive-admin-menu #logo{display:none}
			#responsive-admin-menu #menu a span{display:inline-block}
			#content-wrapper{margin-left:0;padding-top:60px}
			#responsive-admin-menu #responsive-menu{display:block}
			#responsive-admin-menu #menu{display:none}
			#responsive-admin-menu #menu a{color:#fff}
			#responsive-admin-menu #menu a.submenu:before{font-size:14px;right:15px}}

			/* custom */
			.page-border { width: 90%; /* min-width: 1227px; */ margin-left: 10%; }
			#responsive-lnb #responsive-admin-menu { position: fixed; top: 0 !important; z-index: 100; width: 10%; max-width: 200px; min-width: 135px; }
			#responsive-lnb #responsive-admin-menu #menu a { font-size : 13px; }
			#responsive-lnb #responsive-admin-menu #menu a.submenu:before { top: 13px; right: 11px; font-size: 13px; }
			@media (min-width: 1200px) and (max-width: 1600px) { 
				.container { width: 1000px; }
				.container .one-third { width: 318px; }
				#secondary-navigation { height: 100px; }
			}
			@media (min-width: 980px) and (max-width: 1200px) { 
				.page-border { width: auto; /*min-width: 980px;*/ }
				.container { width: 100%; padding: 0px 1px 0px 1px; }
				.container .one-third { float: left; width: 32%; }
				.container .one-third.last { float: right; width: 30%; }
				#secondary-navigation { height: 100px; }
			}
			@media only screen and (max-width: 980px) { 
				.page-border { min-width: 100%; margin-left: 0 !important; margin-top: 50px; }
				#responsive-lnb #responsive-admin-menu {float:left; width:100%; max-width: 100%; min-width: 100%; min-height:50px;background-color:#404040;height:auto; top:0}
				#responsive-admin-menu #logo {display:none}
				#responsive-admin-menu #menu a span {display:inline-block}
				#content-wrapper{margin-left:0;padding-top:60px}
				#responsive-admin-menu #responsive-menu {display:block}
				#responsive-admin-menu #menu {display:none}
				#responsive-admin-menu #menu a {color:#fff}
				#responsive-admin-menu #menu a.submenu:before {font-size:14px;right:15px }
			}
		</style>
		<!-- 2015-06-22 : 네비 스크롤 -->
		<style>
			#responsive-lnb{}
			#responsive-admin-menu{overflow-y:scroll}
		</style>
	</head>
	<body></body>
</html>