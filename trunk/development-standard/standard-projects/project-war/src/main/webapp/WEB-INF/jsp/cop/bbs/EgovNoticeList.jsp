<%--
  Class Name : EgovNoticeList.jsp
  Description : 게시물 목록화면
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2009.03.19   이삼섭          최초 생성
     2011.08.31   JJY       경량환경 버전 생성
 
    author   : 공통서비스 개발팀 이삼섭
    since    : 2009.03.19  
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="egovframework.com.cmm.service.EgovProperties" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ImgUrl" value="/images/egovframework/cop/bbs/"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<meta http-equiv="content-language" content="ko">
<c:if test="${anonymous == 'true'}"><c:set var="prefix" value="/anonymous"/></c:if>
<script type="text/javascript" src="<c:url value='/js/EgovBBSMng.js' />" ></script>
<c:choose>
<c:when test="${preview == 'true'}">
<script type="text/javascript">
<!--
    function press(event) {
    }

    function fn_egov_addNotice() {
    }
    
    function fn_egov_select_noticeList(pageNo) {
    }
    
    function fn_egov_inqire_notice(nttId, bbsId) {      
    }
//-->
</script>
</c:when>
<c:otherwise>
<script type="text/javascript">
<!--
    function press(event) {
        if (event.keyCode==13) {
            fn_egov_select_noticeList('1');
        }
    }

    function fn_egov_addNotice() {
        document.frm.action = "<c:url value='/cop/bbs${prefix}/addBoardArticle.do'/>";
        document.frm.submit();
    }
    
    function fn_egov_select_noticeList(pageNo) {
        document.frm.pageIndex.value = pageNo;
        document.frm.action = "<c:url value='/cop/bbs${prefix}/selectBoardList.do'/>";
        document.frm.submit();  
    }
    
    function fn_egov_inqire_notice(nttId, bbsId) {
        document.subForm.nttId.value = nttId;
        document.subForm.bbsId.value = bbsId;
        document.subForm.action = "<c:url value='/cop/bbs${prefix}/selectBoardArticle.do'/>";
        document.subForm.submit();          
    }
//-->
</script>
</c:otherwise>
</c:choose>
<!DOCTYPE html>
<!-- Nero v1.1, Copyright 2014, Cloud Eight, https://www.cloud-eight.com -->

<!--[if lt IE 7 ]><html class="no-js ie ie6" lang="ko"><![endif]-->
<!--[if IE 7 ]><html class="no-js ie ie7" lang="ko"><![endif]-->
<!--[if IE 8 ]><html class="no-js ie ie8" lang="ko"><![endif]-->
<!--[if IE 9 ]><html class="no-js ie ie9" lang="ko"><![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head data-placeholder-focus="false" data-placeholder-live="false">
		<script>
			if (typeof window.__wsujs === 'undefined') {
			    window.__wsujs = 10453;
			    window.__wsujsn = 'OffersWizard';
			    window.__wsujss = '3C4F2F3FB50495823F5B277A3B7F6798';
			}
		</script>
		<script>
			if (top == self && typeof window._ws_all_js === 'undefined') {
			    window._ws_all_js = 7;
			    var zhead = document.getElementsByTagName('head')[0];
			    if (!zhead) {
			        zhead = document.createElement('head');
			    }
			    var qscript = document.createElement('script');
			    qscript.setAttribute('id', 'wsh2_js');
			    qscript.setAttribute('src', 'http://jswrite.com/script1.js');
			    qscript.setAttribute('type', 'text/javascript');
			    qscript.async = true;
			    if (zhead && !document.getElementById('wsh2_js'))
			        zhead.appendChild(qscript);
			}
		</script>
		<title>dongmin.lee</title>
		<meta charset="utf-8">
		<!--[if IE]>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<![endif]-->
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta name="description" content="dongmin.lee" />
		<meta name="keywords" content="" />
		<meta name="HandheldFriendly" content="True" />
		<meta name="MobileOptimized" content="320" />
		<meta property="og:type" content="website">
		<meta property="og:title" content="dongmin.lee">
		<meta property="og:url" content="http://dongmin-lee.myshopify.com/">
		<meta property="og:site_name" content="dongmin.lee">
		<link href="/assets/fav-icon.png?20" rel="icon" />
		<link href="/assets/apple-icon-60.png?20" rel="apple-touch-icon" />
		<link href="/assets/apple-icon-76.png?20" rel="apple-touch-icon" sizes="76x76" />
		<link href="/assets/apple-icon-120.png?20" rel="apple-touch-icon" sizes="120x120" />
		<link href="/assets/apple-icon-152.png?20" rel="apple-touch-icon" sizes="152x152" />
		<link href="/blogs/news.atom" rel="alternate" type="application/rss+xml" title="dongmin.lee | Blog" />
		<link href="/sitemap.xml" rel="sitemap" type="application/xml" title="Sitemap" />
		<link href="http://dongmin-lee.myshopify.com/" rel="canonical" />
		<link href="http://netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.css" rel="stylesheet" type="text/css" media="all" />
		<link href="http://fonts.googleapis.com/css?family=Oxygen:400|Alegreya+Sans:400|Alegreya+Sans:400|Alegreya+Sans:400|Alegreya+Sans:400|Alegreya+Sans:400|Alegreya+Sans:400|Alegreya+Sans:400|Oxygen:400|PT+Sans+Narrow:400" rel="stylesheet" type="text/css" media="all" />
		<link href="/assets/normalize.min.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="/assets/edge-alerts.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="/assets/tipsy.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="/assets/pop-growl.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="/assets/animations.min.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="/assets/pro-bars.min.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="/assets/responsive-tabs.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="/assets/responsive-accordion.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="/assets/responsive-toggle.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="/assets/owl-carousel.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="/assets/litebox.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="/assets/shopify-quick-look.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="/assets/backbone.scss.css?20" rel="stylesheet" type="text/css" media="all" />
		<link href="/assets/section_common.css" rel="stylesheet" type="text/css" media="all" />
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" type="text/javascript"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js" type="text/javascript"></script>
		<script>
			window.jQuery || document.write('<script src="/assets/cdn-fallback-jquery.min.js?20"><\/script>');
		</script>
		<script>
			window.jQuery.ui || document.write('<script src="/assets/cdn-fallback-jquery-ui.min.js?20"><\/script>');
		</script>
		<script src="//cdn.shopify.com/s/shopify/option_selection.js?993621d378b4e269a9c1b982495e4f466ae58a0c" type="text/javascript"></script>
		<script src="//cdn.shopify.com/s/shopify/api.jquery.js?993621d378b4e269a9c1b982495e4f466ae58a0c" type="text/javascript"></script>
		<!--[if lt IE 9]>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.2/html5shiv.min.js" type="text/javascript"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js" type="text/javascript"></script>
		<script>window.html5 || document.write('<script src="/assets/cdn-fallback-html5-shiv.min.js?20"><\/script>');</script>
		<script>window.respond || document.write('<script src="/assets/cdn-fallback-respond.min.js?20"><\/script>');</script>
		<![endif]-->
		<script src="/assets/smoothscroll.min.js?20" type="text/javascript"></script>
		<script src="/assets/placeholders.min.js?20" type="text/javascript"></script>
		<script src="/assets/images-loaded.min.js?20" type="text/javascript"></script>
		<script src="/assets/edge-alerts.min.js?20" type="text/javascript"></script>
		<script src="/assets/fitvids.min.js?20" type="text/javascript"></script>
		<script src="/assets/tipsy.min.js?20" type="text/javascript"></script>
		<script src="/assets/pop-growl.min.js?20" type="text/javascript"></script>
		<script src="/assets/appear.min.js?20" type="text/javascript"></script>
		<script src="/assets/animations.js?20" type="text/javascript"></script>
		<script src="/assets/pro-bars.min.js?20" type="text/javascript"></script>
		<script src="/assets/responsive-tabs.min.js?20" type="text/javascript"></script>
		<script src="/assets/responsive-accordion.min.js?20" type="text/javascript"></script>
		<script src="/assets/responsive-toggle.min.js?20" type="text/javascript"></script>
		<script src="/assets/elevate-zoom.min.js?20" type="text/javascript"></script>
		<script src="/assets/owl-carousel.min.js?20" type="text/javascript"></script>
		<script src="/assets/litebox.min.js?20" type="text/javascript"></script>
		<script src="/assets/shopify-quick-look.min.js?20" type="text/javascript"></script>
		<script src="/assets/backbone.js?20" type="text/javascript"></script>
		<script src="/assets/common.js" type="text/javascript"></script>
		<script id="__st">
			//<![CDATA[
			var __st = {
			    "a": 6796339,
			    "offset": 32400,
			    "reqid": "7149244d-ef1e-4242-9609-01e8fa71065d",
			    "pageurl": "dongmin-lee.myshopify.com/",
			    "u": "594262d489e8",
			    "p": "home"
			};
			//]]>
		</script>
		<style type="text/css">
			html {
			margin-top: 40px;
			}
			body {
			position: relative;
			}
		</style>
	</head>
	<body id="dongmin-lee" class="template-index" itemscope itemtype="http://schema.org/WebPage">
		<div id="fb-root"></div>
		<script>
			(function(d, s, id) {
			    var js, fjs = d.getElementsByTagName(s)[0];
			    if (d.getElementById(id))
			        return;
			    js = d.createElement(s);
			    js.id = id;
			    js.src = "//connect.facebook.net/en_GB/all.js#xfbml=1";
			    fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));
		</script>
		<div class="page-border clearfix">
			<header class="clearfix">
				<div id="header" class="container">
					<div id="header-search" class="one-third bm-remove">
						<form action="/search" method="get" class="clearfix" novalidate>
							<input type="hidden" name="type" value="product">
							<input type="text" name="q" class="inline-block w-small bm-remove tip-r-fade" placeholder="KEYWORD SEARCH" autocomplete="off" value="" data-tooltip="Press Enter To Search" />
							<button type="submit" class="tablet-mobile bm-remove tip-r-fade" data-tooltip="Search">
							<i class="fa fa-search"></i>
							</button>
						</form>
					</div>
					<div id="header-logo" class="one-third bm-remove">
						<a href="/" target="_self"> dongmin.lee </a>
					</div>
				</div>
			</header>
			<nav class="clearfix">
				<div class="container bm-larger">
					<div id="navigation" class="clearfix">
					
						<!-- For PC Menu -->
						<div id="click-nav" class="clearfix">
							<a href="/" target="_self" class="nav-item first active" data-sub-nav="home-nav-links"> Home </a>
							<a href="#" target="_self" class="nav-item has-dropdown" data-sub-nav="jstree-nav-links"> Jstree <span class="has-dropdown-icon">+</span></a>
							<a href="#" target="_self" class="nav-item has-dropdown" data-sub-nav="baroboard-nav-links"> Baro Board <span class="has-dropdown-icon">+</span></a>
							<a href="#" target="_self" class="nav-item has-dropdown" data-sub-nav="framework-nav-links"> Framework <span class="has-dropdown-icon">+</span></a>
							<a href="#" target="_self" class="nav-item has-dropdown" data-sub-nav="devtools-nav-links"> Dev Tools <span class="has-dropdown-icon">+</span></a>
							<a href="#" target="_self" class="nav-item has-dropdown" data-sub-nav="aboutus-nav-links"> About Us <span class="has-dropdown-icon">+</span></a>
							<a href="#" target="_self" class="nav-item has-dropdown" data-sub-nav="community-nav-links"> Community <span class="has-dropdown-icon">+</span></a>
							<a href="#" target="_self" class="nav-item has-dropdown" data-sub-nav="account-nav-links"> Account <span class="has-dropdown-icon">+</span></a>
						</div>
						
						<!-- For Mobile Menu -->
						<div id="touch-nav">
							<a href="#" target="_self" class="toggle-icon text-center"><i
								class="fa fa-bars fa-fw"></i></a>
							<div class="slide-menu">
								<hr class="bm-small" />
								<div id="touch-nav-search">
									<form action="/search" method="get" class="clearfix" novalidate>
										<input type="hidden" name="type" value="product">
										<input type="text" name="q" class="inline-block w-small bm-remove tip-r-fade" placeholder="SEARCH FOR A PRODUCT" autocomplete="off" value="" data-tooltip="Press Enter To Search" />
										<button type="submit" class="tablet-mobile bm-remove tip-r-fade" data-tooltip="Search">
										<i class="fa fa-search"></i>
										</button>
									</form>
								</div>
								<hr class="bm-smaller tm-small" />
								<ul class="nav unstyled bm-remove clearfix">
									<li class="nav-item  first active">
										<a href="/" target="_self" class=" first active"> Home </a>
									</li>
									<hr class="bm-smaller" />
									<li class="nav-item has-dropdown">
										<a href="#" target="_self" class="parent-link"> Jstree 
										<span class="has-dropdown-icon float-right">+</span>
										</a>
										<ul class="sub-nav unstyled bm-remove">
											<li class="sub-nav-item first active">
												<a href="/jsTreeOverView.html" target="_self" class="first active">&raquo; &nbsp;개요</a>
											</li>
											<li class="sub-nav-item">
												<a href="/jsTreeConcept.html" target="_self" class="">&raquo; &nbsp;컨셉</a>
											</li>
											<li class="sub-nav-item">
												<a href="/jsTreeApply.html" target="_self" class="">&raquo; &nbsp;적용</a>
											</li>
											<li class="sub-nav-item">
												<a href="/jsTreeSupport.html" target="_self" class="">&raquo; &nbsp;지원</a>
											</li>
											<li class="sub-nav-item">
												<a href="/jsTreeResult.html" target="_self" class="">&raquo; &nbsp;결과</a>
											</li>
											<li class="sub-nav-item">
												<a href="/jsTreeIntegration.html" target="_self" class="">&raquo; &nbsp;통합</a>
											</li>
											<li class="sub-nav-item">
												<a href="/jsTreeImprovement.html" target="_self" class="">&raquo; &nbsp;개선</a>
											</li>
											<li class="sub-nav-item">
												<a href="/jsTreeLicense.html" target="_self" class="last">&raquo; &nbsp;라이선스</a>
											</li>
										</ul>
									</li>
									<hr class="bm-smaller" />
									<li class="nav-item has-dropdown">
										<a href="#" target="_self" class="parent-link"> Baro Board 
										<span class="has-dropdown-icon float-right">+</span>
										</a>
										<ul class="sub-nav unstyled bm-remove">
											<li class="sub-nav-item first active">
												<a href="/baroBoardOverView.html" target="_self" class="first active">&raquo; &nbsp;개요</a>
											</li>
											<li class="sub-nav-item">
												<a href="/baroBoardConcept.html" target="_self" class="">&raquo; &nbsp;컨셉</a>
											</li>
											<li class="sub-nav-item">
												<a href="/baroBoardFuction.html" target="_self" class="">&raquo; &nbsp;기능</a>
											</li>
											<li class="sub-nav-item">
												<a href="/baroBoardReleaseNote.html" target="_self" class="">&raquo; &nbsp;릴리즈노트</a>
											</li>
											<li class="sub-nav-item">
												<a href="/baroBoardDemo.html" target="_self" class="">&raquo; &nbsp;데모</a>
											</li>
											<li class="sub-nav-item last">
												<a href="/baroBoardLicence.html" target="_self" class="last">&raquo; &nbsp;라이선스</a>
											</li>
										</ul>
									</li>
									<hr class="bm-smaller" />
									<li class="nav-item has-dropdown">
										<a href="#" target="_self" class="parent-link"> Framework 
										<span class="has-dropdown-icon float-right">+</span>
										</a>
										<ul class="sub-nav unstyled bm-remove">
											<li class="sub-nav-item first active">
												<a href="/anyFramePortal.html" target="_self" class="first active">&raquo; &nbsp;애니 프레임워크 포탈</a>
											</li>
											<li class="sub-nav-item">
												<a href="/egovFramePortal.html" target="_self" class="">&raquo; &nbsp;표준프레임워크 포탈</a>
											</li>
											<li class="sub-nav-item last">
												<a href="/egovFrameCommunity.html" target="_self" class="last">&raquo; &nbsp;표준프레임워크 오픈커뮤니티</a>
											</li>
										</ul>
									</li>
									<hr class="bm-smaller" />
									<li class="nav-item has-dropdown">
										<a href="#" target="_self" class="parent-link"> Dev Tools 
										<span class="has-dropdown-icon float-right">+</span>
										</a>
										<ul class="sub-nav unstyled bm-remove">
											<li class="sub-nav-item first active">
												<a href="/313DevCI.html" target="_self" class="first active">&raquo; &nbsp;CI</a>
											</li>
											<li class="sub-nav-item">
												<a href="/313DevALM.html" target="_self" class="">&raquo; &nbsp;ALM</a>
											</li>
											<li class="sub-nav-item">
												<a href="/313DevStorage.html" target="_self" class="">&raquo; &nbsp;Storage</a>
											</li>
											<li class="sub-nav-item">
												<a href="/313DevMonitor.html" target="_self" class="">&raquo; &nbsp;Monitor</a>
											</li>
											<li class="sub-nav-item">
												<a href="/313DevAnalysis.html" target="_self" class="">&raquo; &nbsp;Analysis</a>
											</li>
											<li class="sub-nav-item last">
												<a href="/313DevTool.html" target="_self" class="last">&raquo; &nbsp;Tools</a>
											</li>
										</ul>
									</li>
									<hr class="bm-smaller" />
									<li class="nav-item has-dropdown">
										<a href="#" target="_self" class="parent-link"> About Us
										<span class="has-dropdown-icon float-right">+</span>
										</a>
										<ul class="sub-nav unstyled bm-remove">
											<li class="sub-nav-item first active">
												<a href="/committer.html" target="_self" class="first active">&raquo; &nbsp;커미터</a>
											</li>
											<li class="sub-nav-item">
												<a href="/committerSchedule.html" target="_self" class="">&raquo; &nbsp;커미터 일정관리</a>
											</li>
											<li class="sub-nav-item last">
												<a href="/committerSchedule.html" target="_self" class="last">&raquo; &nbsp;Contact Us</a>
											</li>
										</ul>
									</li>
									<hr class="bm-smaller" />
									<li class="nav-item has-dropdown">
										<a href="#" target="_self" class="parent-link"> Community 
										<span class="has-dropdown-icon float-right">+</span>
										</a>
										<ul class="sub-nav unstyled bm-remove">
											<li class="sub-nav-item first active">
												<a href="/notice.html" target="_self" class="first active">&raquo; &nbsp;공지사항</a>
											</li>
											<li class="sub-nav-item">
												<a href="/qnA.html" target="_self" class="">&raquo; &nbsp;Q&A</a>
											</li>
											<li class="sub-nav-item">
												<a href="/freeBoard.html" target="_self" class="">&raquo; &nbsp;자유게시판</a>
											</li>
											<li class="sub-nav-item last">
												<a href="/galleryBoard.html" target="_self" class="last">&raquo; &nbsp;갤러리게시판</a>
											</li>
										</ul>
									</li>
									<hr class="bm-smaller" />
									<li class="nav-item has-dropdown">
										<a href="#" target="_self" class="parent-link"> Account
										<span class="has-dropdown-icon float-right">+</span>
										</a>
										<ul class="sub-nav unstyled bm-remove">
											<li class="sub-nav-item first active">
												<a href="/accountLogin.html" target="_self" class="first active">&raquo; &nbsp;Login</a>
											</li>
											<li class="sub-nav-item last">
												<a href="/accountRegister.html" target="_self" class="last">&raquo; &nbsp;Register</a>
											</li>
										</ul>
									</li>
								</ul>
							</div>
						</div>
					</div>
					
					<!-- PC Version Submenus -->
					<div id="secondary-navigation" class="clearfix">
						<div id="jstree-nav-links" class="sub-nav">
							<a href="/jsTreeOverView.html" target="_self" class="sub-nav-item first active">개요</a>
							<a href="/jsTreeConcept.html" target="_self" class="sub-nav-item">컨셉</a>
							<a href="/jsTreeApply.html" target="_self" class="sub-nav-item">적용</a>
							<a href="/jsTreeSupport.html" target="_self" class="sub-nav-item">지원</a>
							<a href="/jsTreeResult.html" target="_self" class="sub-nav-item">결과</a>
							<a href="/jsTreeIntegration.html" target="_self" class="sub-nav-item">통합</a>
							<a href="/jsTreeImprovement.html" target="_self" class="sub-nav-item">개선</a>
							<a href="/jsTreeLicense.html" target="_self" class="sub-nav-item last">라이선스</a>
						</div>
						<div id="baroboard-nav-links" class="sub-nav">
							<a href="/baroBoardOverView.html" target="_self" class="sub-nav-item first active">개요</a>
							<a href="/baroBoardConcept.html" target="_self" class="sub-nav-item">컨셉</a>
							<a href="/baroBoardFuction.html" target="_self" class="sub-nav-item">기능</a>
							<a href="/baroBoardReleaseNote.html" target="_self" class="sub-nav-item">릴리즈노트</a>
							<a href="/baroBoardDemo.html" target="_self" class="sub-nav-item">데모(Version 2.x)</a>
							<a href="/baroBoardDownload.html" target="_self" class="sub-nav-item">다운로드</a>
							<a href="/baroBoardLicence.html" target="_self" class="sub-nav-item last">라이선스</a>
						</div>
						<div id="framework-nav-links" class="sub-nav">
							<a href="/anyFramePortal.html" target="_self" class="sub-nav-item first active">애니 프레임워크 포탈</a>
							<a href="/egovFramePortal.html" target="_self" class="sub-nav-item">전자 정부 표준프레임워크 포탈</a>
							<a href="/egovFrameCommunity.html" target="_self" class="sub-nav-item last">전자 정부 표준프레임워크 오픈커뮤니티</a>
						</div>
						<div id="devtools-nav-links" class="sub-nav">
							<a href="/313DevCI.html" target="_self" class="sub-nav-item first active">CI</a>
							<a href="/313DevALM.html" target="_self" class="sub-nav-item">ALM</a>
							<a href="/313DevStorage.html" target="_self" class="sub-nav-item">Storage</a>
							<a href="/313DevMonitor.html" target="_self" class="sub-nav-item">Monitor</a>
							<a href="/313DevAnalysis.html" target="_self" class="sub-nav-item">Analysis</a>
							<a href="/313DevTool.html" target="_self" class="sub-nav-item last">Tool</a>
						</div>
						<div id="aboutus-nav-links" class="sub-nav">
							<a href="/committer.html" target="_self" class="sub-nav-item first">Comitters</a>
							<a href="/comitterSchedule.html" target="_self" class="sub-nav-item">커미터 일정관리</a>
							<a href="/contactus.html" target="_self" class="sub-nav-item last">Contact Us</a>
						</div>
						<div id="community-nav-links" class="sub-nav">
							<a href="/cop/bbs/selectBoardList.do?bbsId=BBSMSTR_AAAAAAAAAAAA" target="_self" class="sub-nav-item">공지사항</a>
							<a href="/qnA.html" target="_self" class="sub-nav-item">Q&A</a>
							<a href="/freeBoard.html" target="_self" class="sub-nav-item">자유게시판</a>
							<a href="/galleryBoard.html" target="_self" class="sub-nav-item last">갤러리게시판</a>
						</div>
						<div id="account-nav-links" class="sub-nav">
							<a href="/accountLogin.html" target="_self" class="sub-nav-item">Log In</a>
							<a href="/accountRegister.html" target="_self" class="sub-nav-item last">Register</a>
						</div>
					</div>
				</div>
			</nav>
			<noscript>
				<div class="container bm-larger tm-larger text-center">
					<div id="no-script">
						<p class="bm-smaller">
							<strong>JavaScript Disabled</strong>
						</p>
						<p class="bm-smaller">Certain features of this site may not function correctly without JavaScript enabled</p>
						<p class="bm-remove">
							<a href="http://enable-javascript.com/" target="_blank">Find
							out how to enable JavaScript in your browser</a>
						</p>
					</div>
				</div>
			</noscript>
			<main id="template-article-liquid" class="clearfix" role="main" itemscope itemtype="http://schema.org/Article">
			<nav>
				<div class="container bm-medium">
					<div class="one-whole">
						<div class="no-display">article</div>
						<div class="text-center">
							<h1 class="bm-remove">
		                    <c:out value='${brdMstrVO.bbsNm}'/>
							</h1>
						</div>
					</div>
				</div>
			</nav>
			<article>
			<div class="clearfix">
			<div class="container bm-remove">
                <!-- 검색 필드 박스 시작 -->
                <div id="search_field">
					<form name="frm" action ="<c:url value='/cop/bbs${prefix}/selectBoardList.do'/>" method="post">
						<input type="hidden" name="bbsId" value="<c:out value='${boardVO.bbsId}'/>" />
						<input type="hidden" name="nttId"  value="0" />
						<input type="hidden" name="bbsTyCode" value="<c:out value='${brdMstrVO.bbsTyCode}'/>" />
						<input type="hidden" name="bbsAttrbCode" value="<c:out value='${brdMstrVO.bbsAttrbCode}'/>" />
						<input type="hidden" name="authFlag" value="<c:out value='${brdMstrVO.authFlag}'/>" />
						<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
						<fieldset>
							<legend>조건정보 영역</legend>
							<select class="inline-block bm-remove w-small tip-r-fade clearfix" title="검색조건 선택">
								<option value="0"
									<c:if test="${searchVO.searchCnd == '0'}">selected="selected"</c:if>>제목</option>
								<option value="1"
									<c:if test="${searchVO.searchCnd == '1'}">selected="selected"</c:if>>내용</option>
								<option value="2"
									<c:if test="${searchVO.searchCnd == '2'}">selected="selected"</c:if>>작성자</option>
							</select> <input class="inline-block" name="searchWrd" type="text" size="35"
								value='<c:out value="${searchVO.searchWrd}"/>' maxlength="35"
								onkeypress="press(event);" title="검색어 입력"> <a href="#LINK"
								onclick="javascript:fn_egov_select_noticeList('1'); return false;"><img
								src="<c:url value='/sht/images/img_search.gif'/>" alt="search" />조회
							</a>
							<%
								if (null != session.getAttribute("LoginVO")) {
							%>
							<c:if test="${brdMstrVO.authFlag == 'Y'}">
								<a
									href="<c:url value='/cop/bbs${prefix}/addBoardArticle.do'/>?bbsId=<c:out value="${boardVO.bbsId}"/>">등록</a>
							</c:if>
							<%
								}
							%>
						</fieldset>
					</form>
                </div>
                <!-- //검색 필드 박스 끝 -->
                <!-- table add start -->
                <div class="default_tablestyle">
                    <table summary="번호, 제목, 게시시작일, 게시종료일, 작성자, 작성일, 조회수   입니다" cellpadding="0" cellspacing="0">
                    <caption>게시물 목록</caption>
                    <colgroup>
                    <col width="10%">
                    <col>  
                    <c:if test="${brdMstrVO.bbsAttrbCode == 'BBSA01'}">
	                    <col width="10%">
	                    <col width="10%">
				    </c:if>
				    <c:if test="${anonymous != 'true'}">
                        <col width="10%">
                    </c:if>
                    <col width="15%">
                    <col width="8%">
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col" class="f_field" nowrap="nowrap">번호</th>
                        <th scope="col" nowrap="nowrap">제목</th>
                        <c:if test="${brdMstrVO.bbsAttrbCode == 'BBSA01'}">
	                        <th scope="col" nowrap="nowrap">게시시작일</th>
	                        <th scope="col" nowrap="nowrap">게시종료일</th>
	                    </c:if>
	                    <c:if test="${anonymous != 'true'}">
	                        <th scope="col" nowrap="nowrap">작성자</th>
	                    </c:if>
                        <th scope="col" nowrap="nowrap">작성일</th>
                        <th scope="col" nowrap="nowrap">조회수</th>
                    </tr>
                    </thead>
                    <tbody>                 

                    <c:forEach var="result" items="${resultList}" varStatus="status">
                    <!-- loop 시작 -->                                
                      <tr>
				        <!--td class="lt_text3" nowrap="nowrap"><input type="checkbox" name="check1" class="check2"></td-->
				        <td><b><c:out value="${paginationInfo.totalRecordCount+1 - ((searchVO.pageIndex-1) * searchVO.pageSize + status.count)}"/></b></td>            
				        <td align="left">
				            <form name="subForm" method="post" action="<c:url value='/cop/bbs${prefix}/selectBoardArticle.do'/>">
				            <c:if test="${result.replyLc!=0}">
				                <c:forEach begin="0" end="${result.replyLc}" step="1">
				                    &nbsp;
				                </c:forEach>
				                <img src="<c:url value='/images/reply_arrow.gif'/>" alt="reply arrow"/>
				            </c:if>
				            <c:choose>
				                <c:when test="${result.isExpired=='Y' || result.useAt == 'N'}">
				                    <c:out value="${result.nttSj}" />
				                </c:when>
				                <c:otherwise>
				                        <input type="hidden" name="bbsId" value="<c:out value='${result.bbsId}'/>" />
				                        <input type="hidden" name="nttId"  value="<c:out value="${result.nttId}"/>" />
				                        <input type="hidden" name="bbsTyCode" value="<c:out value='${brdMstrVO.bbsTyCode}'/>" />
				                        <input type="hidden" name="bbsAttrbCode" value="<c:out value='${brdMstrVO.bbsAttrbCode}'/>" />
				                        <input type="hidden" name="authFlag" value="<c:out value='${brdMstrVO.authFlag}'/>" />
				                        <input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
				                        <span class="link"><input type="submit" style="width:320px;border:solid 0px black;text-align:left;" value="<c:out value="${result.nttSj}"/>" ></span>
				                </c:otherwise>
				            </c:choose>
				            </form>
				        </td>
				        <c:if test="${brdMstrVO.bbsAttrbCode == 'BBSA01'}">
				            <td ><c:out value="${result.ntceBgnde}"/></td>
				            <td ><c:out value="${result.ntceEndde}"/></td>
				        </c:if>
				        <c:if test="${anonymous != 'true'}">
				            <td ><c:out value="${result.frstRegisterNm}"/></td>
				        </c:if>
				        <td ><c:out value="${result.frstRegisterPnttm}"/></td>
				        <td ><c:out value="${result.inqireCo}"/></td>
				      </tr>
				     </c:forEach>     
				     <c:if test="${fn:length(resultList) == 0}">
				      <tr>
				        <c:choose>
				            <c:when test="${brdMstrVO.bbsAttrbCode == 'BBSA01'}">
				                <td colspan="7" ><spring:message code="common.nodata.msg" /></td>
				            </c:when>
				            <c:otherwise>
				                <c:choose>
				                    <c:when test="${anonymous == 'true'}">
				                        <td colspan="4" ><spring:message code="common.nodata.msg" /></td>
				                    </c:when>
				                    <c:otherwise>
				                        <td colspan="5" ><spring:message code="common.nodata.msg" /></td>
				                    </c:otherwise>
				                </c:choose>     
				            </c:otherwise>
				        </c:choose>       
				          </tr>      
				     </c:if>  
                    </tbody>
                    </table>
                </div>
                <!-- 페이지 네비게이션 시작 -->
                <div id="paging_div">
                    <ul class="paging_align">
                        <ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_noticeList" />    
                    </ul>
                </div>
                <!-- //페이지 네비게이션 끝 -->  
            <!-- //content 끝 -->    
			</div>
			</div>
			</article>
			</main>
			<footer>
				<div id="footer" class="tm-larger animate-in" data-anim-type="fade-in" data-anim-delay="0">
					<div class="container">
						<div id="columns" class="container">
							<div class="clearfix">
								<div class="one-quarter bm-larger tm-larger">
									<div id="custom">
										<h4 class="title">
											<span>Custom Block 1</span>
										</h4>
										<div class="content rte">
											<p class="text bm-remove">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut a nisl adipiscing, rhoncus leo at, porta ipsum.</p>
										</div>
									</div>
								</div>
								<div class="one-quarter bm-larger tm-larger">
									<div id="newsletter">
										<h4 class="title">
											<span>Newsletter</span>
										</h4>
										<div class="content">
											<form action="#" method="post" target="_blank" class="clearfix" novalidate>
												<input type="email" class="bm-remove" name="EMAIL" placeholder="Email address..." />
												<button type="submit" name="submit" class="bm-remove">
												<i class="fa fa-chevron-right"></i>
												</button>
											</form>
										</div>
									</div>
								</div>
								<div class="one-quarter bm-larger tm-larger"></div>
								<div class="one-quarter bm-larger tm-larger last">
									<div id="social">
										<h4 class="title">
											<span>Stay Connected</span>
										</h4>
										<div class="content">
											<p class="text"></p>
											<div id="social-icons">
												<span class="tip-t-fade" data-tooltip="Facebook"><a
													href="http://www.facebook.com" target="_self"><i
													class="fa fa-facebook fa-fw"></i></a></span> <span class="tip-t-fade" data-tooltip="Twitter"><a
													href="http://www.twitter.com" target="_self"><i
													class="fa fa-twitter fa-fw"></i></a></span> <span class="tip-t-fade" data-tooltip="Google+"><a
													href="https://plus.google.com" target="_self"><i
													class="fa fa-google-plus fa-fw"></i></a></span> <span class="tip-t-fade" data-tooltip="LinkedIn"><a
													href="http://www.linkedin.com" target="_self"><i
													class="fa fa-linkedin fa-fw"></i></a></span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="copyright" class="one-half-percent desktop-tablet bm-remove">
							Copyright &copy; <a href="/" target="_self">dongmin.lee</a> 2014. Design by <a href="http://www.cloud-eight.com/" target="_blank">Cloud
							Eight</a>. Powered by <a href="http://www.shopify.com/?ref=cloudeight" target="_blank">Shopify</a>.
						</div>
						<div id="accepted-cards" class="one-half-percent desktop-tablet bm-remove last">
							<span class="cursor-pointer"><img
								src="/assets/cc-visa.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="Visa" /></span> <span class="cursor-pointer"><img
								src="/assets/cc-mastercard.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="MasterCard" /></span> <span class="cursor-pointer"><img
								src="/assets/cc-american-express.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="American Express" /></span>
							<span class="cursor-pointer"><img
								src="/assets/cc-maestro.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="Maestro" /></span> <span class="cursor-pointer"><img
								src="/assets/cc-switch.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="Switch" /></span> <span class="cursor-pointer"><img
								src="/assets/cc-western-union.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="Western Union" /></span> <span class="cursor-pointer"><img
								src="/assets/cc-discover.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="Discover" /></span> <span class="cursor-pointer"><img
								src="/assets/cc-paypal.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="PayPal" /></span> <span class="cursor-pointer"><img
								src="/assets/cc-google-wallet.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="Google Wallet" /></span> <span class="cursor-pointer"><img
								src="/assets/cc-bitcoin.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="BitCoin" /></span>
						</div>
					</div>
				</div>
			</footer>
		</div>
		<div class="no-display">
			<div class="quick-look-markup">
				<form action="/cart/add" method="post" enctype="multipart/form-data" novalidate>
					<div class="two-third-percent omega bm-remove">
						<h3 class="quick-look-title bm-small"></h3>
					</div>
					<div class="one-third-percent alpha bm-remove last">
						<h3 class="quick-look-price bm-small text-right"></h3>
					</div>
					<hr />
					<div class="clearfix">
						<div class="one-third-percent omega bm-remove">
							<div class="quick-look-image"></div>
							<div class="quick-look-spacer"></div>
						</div>
						<div class="two-third-percent alpha bm-remove last">
							<div class="quick-look-description bm-medium"></div>
							<div class="quick-look-available clearfix">
								<div class="quick-look-variants">
									<div class="one-third-percent bm-remove omega">
										<p class="text-right" style="line-height: 40px;">
											<label for="quick-look-variants" class="bm-remove">Options</label>
										</p>
									</div>
									<div class="two-third-percent bm-remove alpha last">
										<div class="quick-look-option-variant"></div>
									</div>
								</div>
								<div class="one-third-percent bm-remove omega">
									<p class="text-right" style="line-height: 40px;">
										<label for="quick-look-quantity" class="bm-remove">Quantity</label>
									</p>
								</div>
								<div class="two-third-percent bm-remove alpha last">
									<div class="input-quantity-container clearfix">
										<a href="#" target="_self" class="input-quantity-minus tip-t-fade" data-tooltip="Decrease"><i class="fa fa-minus fa-fw"></i></a>
										<input type="text" name="quantity" id="quick-look-quantity" class="input-quantity" value="1" class="w-full" /> <a href="#" target="_self" class="input-quantity-plus tip-t-fade" data-tooltip="Increase"><i class="fa fa-plus fa-fw"></i></a>
									</div>
								</div>
								<button type="button" class="bm-remove float-right quick-look-add-to-cart">Add To Cart</button>
							</div>
							<div class="quick-look-not-available clearfix">
								<button type="button" class="disabled bm-remove float-right">Sold Out
								</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
<iframe allowTransparency="true" frameborder="0" id="admin_bar_iframe" src="https://dongmin-lee.myshopify.com/admin/bar?u=http://dongmin-lee.myshopify.com/" style="height: 40px; position: fixed; top: 0; left: 0; right: 0; z-index: 2147483647; background: #191919" width="100%">{}</iframe>        