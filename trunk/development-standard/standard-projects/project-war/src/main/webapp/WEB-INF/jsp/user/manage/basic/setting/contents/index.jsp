<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags" %>
<!DOCTYPE html>
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
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>JsTree 아키텍쳐, 바로보드 Java 설치형 게시판 솔루션, 오픈소스 313 자바 개발자 그룹 커뮤니티</title>
<!-- Framework & Plugins -->
<%-- // TODO 추후 사이트메쉬로 공통 처리할 것임. --%>
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/font-awesome.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/normalize.min.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/edge-alerts.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/tipsy.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/pop-growl.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/animations.min.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/pro-bars.min.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/responsive-tabs.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/responsive-accordion.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/responsive-toggle.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/owl-carousel.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/litebox.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/shopify-quick-look.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/backbone.scss.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/section_common.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/common-font.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/jNotify.jquery.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" defer="" async="" src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/piwik.js"></script>
<script type="text/javascript" async="" src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/ga.js"></script>
<script type="text/javascript" src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/jquery-1.11.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/jquery-migrate-1.2.1.js" charset="utf-8"></script>
<script type="text/javascript" src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/jquery-ui.min.js" charset="utf-8"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/smoothscroll.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/placeholders.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/images-loaded.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/edge-alerts.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/fitvids.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/tipsy.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/pop-growl.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/appear.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/animations.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/pro-bars.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/responsive-tabs.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/responsive-accordion.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/responsive-toggle.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/elevate-zoom.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/owl-carousel.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/litebox.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/shopify-quick-look.min.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/backbone.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/option_selection.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/api.jquery.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/jNotify.jquery.js" type="text/javascript"></script>
<!-- <script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/ajax.js" type="text/javascript"></script> -->
<script src="${pageContext.request.contextPath}/assets/js/ajax.js" type="text/javascript"></script>
<script src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/common.js" type="text/javascript"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/jquery.dataTables.css">
<!-- !!!  FOR THIS PAGE ONLY !!! -->
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/admin.css" rel="stylesheet" type="text/css" media="all">
<link href="http://www.313.co.kr:5002/Component/jsp/admin/bb/divSample.css" rel="stylesheet" type="text/css" media="all">
<style type="text/css">
#samDiv>div>div {
    height: 100% !important; <%-- divSample.css #samDiv>div>div height: 30px --%>
}

textarea {
    max-width: 100%; <%-- backbone.scss.css textarea max-width: 300px --%>
    width: 600px;
}

.right {
    text-align: right; <%-- 하단 버튼 영역에 대한 좌 중 우 위치에 대한 공통 CSS에 대한 적용 필요에 대한 문의 : 전경훈 --%>
                       <%-- 반응형 적용에 대한 문의 : 전경훈 --%>
}
</style>
<script>
function getContextPath() { <%-- 공통 js로 옮기는 것에 대한 문의 : 전경훈 --%>
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}

var basicContents = {
     
    handleEvent : function() {
        
        $('#frmBasicContents').on('submit', function() {
            
            var formId = 'frmBasicContents';
            var $form = $('#frmBasicContents');
            
            callAjax(formId
                   , $form.prop('action')
                   , null
                   , $form.prop('method')
                   , 'json'
                   , null
                   , callback);
            
            function callback(r) {
                alert('저장되었습니다.');
            }
            
            return false;
        });
    },
        
    init : function() {
        this.handleEvent();
    }
};

$(document).ready(function() {
    basicContents.init();
});
</script>
</head>
<body class="template-index" gtools_scp_screen_capture_injected="true">
    <div class="page-border clearfix">
        <header class="clearfix">
            <div id="header" class="container">
                <div id="header-logo" class="one-third bm-remove">
                    <a href="http://localhost:8080/" target="_self"> <img src="http://www.313.co.kr:5002/Component/jsp/admin/bb/lib/logo.jpg" alt="313 developer group logo">
                    </a>
                </div>
                <div id="header-admin" class="one-third bm-remove">
                    <li><a>BaroBoard Admin</a></li>
                    <li><a id="breadcrumb">Sample/DIV</a></li>
                </div>
                <div id="header-cart" class="one-third bm-remove last">
                    <a href="#" target="_self">BARO ADMIN</a> <a href="#" target="_self">LOGOUT</a>
                </div>
                <hr id="r">
            </div>
        </header>
        <div class="clearfix">
            <div class="container bm-remove">
                <nav>
                    <div id="navigation" class="clearfix one-quarter">
                        <!-- For Mobile Menu -->
                        <div id="touch-nav">
                            <div class="slide-menu">
                                <ul class="nav unstyled bm-remove clearfix">
                                    <li class="nav-item  first active"><a href="#" target="_self" class="parent-link"> 대쉬보드</a></li>
                                    <hr class="bm-smaller">
                                    <li class="nav-item  has-dropdown"><a href="#" target="_self" class="parent-link"> 샘플 <span class="has-dropdown-icon float-right">+</span>
                                    </a>
                                        <ul class="sub-nav unstyled bm-remove">
                                            <li class="sub-nav-item"><a href="./divSample.html" target="_self" class="">» &nbsp;DIV</a></li>
                                            <hr class="bm-smaller">
                                            <li class="sub-nav-item"><a href="./jstreeSample.html" target="_self" class="">» &nbsp;JsTree</a></li>
                                            <hr class="bm-smaller">
                                            <li class="sub-nav-item"><a href="./tableSample.html" target="_self" class="">» &nbsp;Table</a></li>
                                        </ul></li>
                                    <hr class="bm-smaller">
                                    <li class="nav-item  has-dropdown"><a href="#" target="_self" class="parent-link"> 설정 <span class="has-dropdown-icon float-right">+</span>
                                    </a>
                                        <ul class="sub-nav unstyled bm-remove">
                                            <li class="sub-nav-item first active has-dropdown"><a href="#" target="_self" class=" first active parent-link">» &nbsp;일반<span class="has-dropdown-icon float-right">+</span>
                                            </a>
                                                <ul class="sub-nav unstyled bm-remove">
                                                    <li class="sub-nav-item first active"><a href="#" class=" first active">» &nbsp;기본설정</a></li>
                                                    <li class="sub-nav-item"><a href="#" class="">» &nbsp;포인트 설정</a></li>
                                                    <li class="sub-nav-item"><a href="#" class="">» &nbsp;팝업 설정</a></li>
                                                    <li class="sub-nav-item"><a href="#" class="">» &nbsp;메일링 설정</a></li>
                                                    <li class="sub-nav-item"><a href="#" class="">» &nbsp;SMS 설정</a></li>
                                                    <li class="sub-nav-item"><a href="#" class="">» &nbsp;SNS 설정</a></li>
                                                </ul></li>
                                            <hr class="bm-smaller">
                                            <li class="sub-nav-item has-dropdown"><a href="#" target="_self" class="parent-link">» &nbsp;고급<span class="has-dropdown-icon float-right">+</span></a>
                                                <ul class="sub-nav unstyled bm-remove">
                                                    <li class="sub-nav-item first active"><a href="#" class=" first active">» &nbsp;서버 설정</a></li>
                                                    <li class="sub-nav-item"><a href="#" class="">» &nbsp;FTP 설정</a></li>
                                                    <li class="sub-nav-item"><a href="#" class="">» &nbsp;파일업로드 설정</a></li>
                                                    <li class="sub-nav-item has-dropdown"><a href="#" class="parent-link">» &nbsp;설치 프로그램 관리<span class="has-dropdown-icon float-right">+</span></a>
                                                        <ul class="sub-nav unstyled bm-remove">
                                                            <li class="sub-nav-item first active"><a href="#" class=" first active">» &nbsp;Component</a></li>
                                                            <li class="sub-nav-item"><a href="#" class="">» &nbsp;LayOut</a></li>
                                                            <li class="sub-nav-item"><a href="#" class="">» &nbsp;Widget</a></li>
                                                        </ul></li>
                                                </ul></li>
                                            <hr class="bm-smaller">
                                            <li class="sub-nav-item"><a href="#" target="_self" class="">» &nbsp;메뉴</a></li>
                                        </ul></li>
                                    <hr class="bm-smaller">
                                    <li class="nav-item"><a href="#" target="_self" class="">페이지</a></li>
                                    <hr class="bm-smaller">
                                    <li class="nav-item  has-dropdown"><a href="#" target="_self" class="parent-link">회원관리 <span class="has-dropdown-icon float-right">+</span>
                                    </a>
                                        <ul class="sub-nav unstyled bm-remove">
                                            <li class="sub-nav-item first active"><a href="#" target="_self" class=" first active">» &nbsp;기본설정</a></li>
                                            <hr class="bm-smaller">
                                            <li class="sub-nav-item"><a href="#" target="_self" class="">» &nbsp;회원목록 </a></li>
                                            <hr class="bm-smaller">
                                            <li class="sub-nav-item"><a href="#" target="_self" class="">» &nbsp;회원등급</a></li>
                                            <hr class="bm-smaller">
                                            <li class="sub-nav-item has-dropdown"><a href="#" class="parent-link">» &nbsp;포인트 <span class="has-dropdown-icon float-right">+</span></a>
                                                <ul class="sub-nav unstyled bm-remove">
                                                    <li class="sub-nav-item first active"><a href="#" class=" first active">» &nbsp;일반설정</a></li>
                                                    <li class="sub-nav-item"><a href="#" class="">» &nbsp;회원 별 포인트 관리</a></li>
                                                </ul></li>
                                        </ul></li>
                                    <hr class="bm-smaller">
                                    <li class="nav-item  has-dropdown"><a href="#" target="_self" class="parent-link"> 게시판<span class="has-dropdown-icon float-right">+</span>
                                    </a>
                                        <ul class="sub-nav unstyled bm-remove">
                                            <li class="sub-nav-item first active"><a href="#" target="_self" class=" first active">» &nbsp;게시판</a></li>
                                            <li class="sub-nav-item"><a href="#" target="_self" class="">» &nbsp;게시판 관리</a></li>
                                            <li class="sub-nav-item"><a href="#" target="_self" class="">» &nbsp;게시글 관리</a></li>
                                            <li class="sub-nav-item"><a href="#" target="_self" class="">» &nbsp;댓글 관리</a></li>
                                            <li class="sub-nav-item"><a href="#" target="_self" class="">» &nbsp;파일 관리</a></li>
                                            <li class="sub-nav-item"><a href="#" target="_self" class="">» &nbsp;설문 관리</a></li>
                                            <li class="sub-nav-item"><a href="#" target="_self" class="">» &nbsp;RSS</a></li>
                                            <li class="sub-nav-item"><a href="#" target="_self" class="">» &nbsp;휴지통 관리</a></li>
                                            <li class="sub-nav-item"><a href="#" target="_self" class="">» &nbsp;문의 게시판 설정</a></li>
                                            <li class="sub-nav-item "><a href="#" target="_self" class="">» &nbsp;기본 Contents 설정</a></li>
                                        </ul></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </nav>
                <section>
                    <form id="frmBasicContents" action="/baroboard/user/admin/basicContents/save.do" method="post">
	                    <div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
	                        <div id="samDiv" class="tablet-mobile alpha bm-remove last">
	                            
	                            <div class="responsive_row">
	                                <div class="item_Lname one-quarter">회사소개 내용 설정</div>
	                                <div class="item_Lvalue two-quarter">
	                                    <textarea id="txtCompanyIntr" name="companyIntr">${basicContents.companyIntr}</textarea>
	                                </div>
	                            </div>
	                            <div class="responsive_row">
	                                <div class="item_Lname one-quarter">서비스 이용약관 내용 설정</div>
	                                <div class="item_Lvalue two-quarter">
	                                    <textarea id="txtTermsOfUse" name="termsOfUse">${basicContents.termsOfUse}</textarea>
	                                </div>
	                            </div>
	                            <div class="responsive_row">
	                                <div class="item_Lname one-quarter">개인정보처리방침 내용 설정</div>
	                                <div class="item_Lvalue two-quarter">
	                                    <textarea id="txtPrivacyPolicy" name="privacyPolicy">${basicContents.privacyPolicy}</textarea>
	                                </div>
	                            </div>
	                            
	                            <div class="responsive_row right">
<!-- 	                                <button id="btnSave">저장</button> --> <%-- 웹표준, 디자인 문의 : 전경훈 --%>
	                                <input type="submit" value="저장" />
	                            </div>
	                        </div>
	                    </div>
                    </form>
                </section>
            </div>
        </div>
        <footer>
            <div id="footer" class="tm-larger" data-anim-type="fade-in" data-anim-delay="0">
                <div class="container">Copyright © Your Company All rights reserved.</div>
            </div>
        </footer>
    </div>
</body>
</html>