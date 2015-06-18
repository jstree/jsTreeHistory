<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" autoFlush="true"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>
<!DOCTYPE html>
<html lang="ko" class="no-js">
	<head data-placeholder-focus="false" data-placeholder-live="false">
		<script type="text/javascript">
			var console = window.console || { log : function() {} };
			
			function getContextPath() {
			  return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
			}
		</script>
		<customTags:assetsJsExtendNas theRestOfFileName="/js/jquery-1.11.2.min.js"></customTags:assetsJsExtendNas>
		<customTags:assetsJsExtendNas theRestOfFileName="/js/jquery-migrate-1.2.1.js"></customTags:assetsJsExtendNas>
		<customTags:assetsJsExtendNas theRestOfFileName="/js/jquery-ui-1.11.2/jquery-ui.min.js"></customTags:assetsJsExtendNas>
		<script>
			window.jQuery || document.write('<script src="${pageContext.request.contextPath}/assets/js/cdn-fallback-jquery.min.js?20"><\/script>');
		</script>
		<script>
			window.jQuery.ui || document.write('<script src="${pageContext.request.contextPath}/assets/js/cdn-fallback-jquery-ui.min.js?20"><\/script>');
		</script>
		<!--[if lt IE 9]>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.2/html5shiv.min.js" type="text/javascript"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js" type="text/javascript"></script>
		<script>window.html5 || document.write('<script src="${pageContext.request.contextPath}/assets/js/cdn-fallback-html5-shiv.min.js?20"><\/script>');</script>
		<script>window.respond || document.write('<script src="${pageContext.request.contextPath}/assets/js/cdn-fallback-respond.min.js?20"><\/script>');</script>
		<![endif]-->
		<script src="${pageContext.request.contextPath}/assets/js/smoothscroll.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/placeholders.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/images-loaded.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/edge-alerts.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/fitvids.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/tipsy.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/pop-growl.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/appear.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/animations.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/pro-bars.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/responsive-tabs.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/responsive-accordion.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/responsive-toggle.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/elevate-zoom.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/owl-carousel.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/litebox.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/shopify-quick-look.min.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/backbone.js?20" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/option_selection.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/api.jquery.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jNotify.jquery.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/dataTables.responsive.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery-ui.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/ajax.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/common.js" type="text/javascript"></script>
		<style type="text/css">
			html {
			margin-top: 40px;
			}
			body {
			position: relative;
			}
		</style>
		<!-- 시간이 없어서 우선 붙이고 차후 찾아서 올리던지 아니면 별도로 JS파일로 대체예정 -->
		<script type="text/javascript">
			$(document).ready(function() {
				var _openedMenu=""
				//responsive menu icon click//
				$("#responsive-menu").click(function(){
					$("#responsive-admin-menu #menu").slideToggle()
				})
				//responsive menu icon click//
				
				//responsive remove style
				$(window).resize(function(){
					$("#responsive-admin-menu #menu").removeAttr("style")
				})
				//responsive remove style
				
				
				//sub menu open / close	
				$("#menu a.submenu").click(function(){
					if(_openedMenu!=""){	$("#" + _openedMenu).prev("a").removeClass("downarrow");	$("#" + _openedMenu).slideUp("fast");}
					if(_openedMenu==$(this).attr("name")){
						$("#" + $(this).attr("name")).slideUp("fast")
				        $(this).removeClass("downarrow")
				        _openedMenu=""
					}else{		
						$("#" + $(this).attr("name")).slideDown("fast")
						_openedMenu=$(this).attr("name")
				        $(this).addClass("downarrow")
					}
					return false;
				})
				//sub menu open / close

				// window 로드, 리사이징시 margin left 조절
				var quickMenu = $("#responsive-admin-menu");
				$(window).on('resize load', function() {
					var quickWidth = quickMenu.outerWidth();
					( $(this).width() < 980 )
						? $(".page-border").css('marginLeft', '0')
					    : $(".page-border").css('marginLeft', quickWidth);
				});
			});
		</script>
	</head>
	<body></body>
</html>
