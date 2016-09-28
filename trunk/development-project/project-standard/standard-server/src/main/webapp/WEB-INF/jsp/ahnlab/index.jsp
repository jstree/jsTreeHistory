<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="egovframework.com.cmm.service.EgovProperties"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ImgUrl" value="/images/egovframework/com/cop/bbs/" />
<%
	/**
	 * @Class Name : EgovNoticeList.jsp
	 * @Description : 게시물 목록화면
	 * @Modification Information
	 * @
	 * @  수정일      수정자            수정내용
	 * @ -------        --------    ---------------------------
	 * @ 2009.03.19   이삼섭          최초 생성
	 * @ 2011.11.11   이기하          익명게시판 검색시 작성자 제거
	 * @ 2015.05.08   조정국          표시정보 클릭시 이동링크 제한 : bbsId가 없는 요청은 처리제한.
	 *
	 *  @author 공통서비스 개발팀 이삼섭
	 *  @since 2009.03.19
	 *  @version 1.0
	 *  @see
	 *
	 */
%>
<html lang="ko">
<head>
<meta name="viewport" content="width=1280" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<!-- SEO -->
<meta name="Keywords"
	content="안랩,안철수연구소, AhnLab, 바이러스, 악성코드, 보안, 모바일 백신, 모바일 보안, 시큐리티, 긴급경보, 긴급대응, 보안정보, 보안뉴스, 보안이슈, V3, V3 Lite, V3 365 클리닉, 안랩몰, 엔진업데이트, 다차원 분석, 콘텐츠 분석, 전용백신, 보안용어, 보안통계, 개인정보보호, 패치 관리, PC 취약점, 안티익스플로잇, 안티익스플로이트, 해킹 방어, 타깃 공격, 타겟 공격, 지능형 지속 위협, 지능형 공격, 사이버 공격, DDoS, 차세대 방화벽, 네트워크 보안, 보안 관제, 보안 컨설팅, 포렌식, 디지털 포렌식, 포렌직, CERT, 악성코드 분석가, 멀웨어, malware, 보안 에코 시스템, 시큐리티 에코 시스템, 시큐리티 라이프사이클, DDoS 대응, APT 대응, 랜섬웨어, " />
<meta name="Description" content="안랩 공식 웹사이트- 통합 보안 기업 안랩(AhnLab)의 다양한 보안 솔루션 및 최신 보안 동향 정보를 제공합니다." />
<!-- 페이스북 -->
<meta property="og:title" content="안전해서 더욱 자유로운 세상 | AhnLab" />
<meta property="og:description" content="안랩 공식 웹사이트- 통합 보안 기업 안랩(AhnLab)의 다양한 보안 솔루션 및 최신 보안 동향 정보를 제공합니다." />

<!-- 트위터 -->
<meta name="twitter:title" content="안전해서 더욱 자유로운 세상 | AhnLab">
<meta name="twitter:description" content="안랩 공식 웹사이트- 통합 보안 기업 안랩(AhnLab)의 다양한 보안 솔루션 및 최신 보안 동향 정보를 제공합니다.">

<!-- SEO -->
<title>안전해서 더욱 자유로운 세상 | AhnLab</title>

<link href="/css/ahnlab/ahnlab.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="/js/ahnlab/jquery-1.11.1.js"></script>
<script type="text/javascript" src="/js/ahnlab/jquery.ui.js"></script>
<script type="text/javascript" src="/js/ahnlab/common.js"></script>
<script type="text/javascript" src="/js/ahnlab/jquery.js"></script>
<script type="text/javascript" src="/js/ahnlab/site.js"></script>
<script type="text/javascript" src="/js/ahnlab/jquery.placeholder.js"></script>
<script type="text/javascript">
<!--
  $(document)
          .ready(
                  function() {

                    //Placeholder
                    $("input, textarea").placeholder();

                    //a링크 #처리
                    $('a[href = "#"]').click(function() {
                      return false;
                    });

                    //이미지 에러처리
                    $("img").each(
                            function() {
                              var instance = $(this);
                              var w = $(this).parent().width();
                              var h = $(this).parent().height();
                              var img = new Image();
                              $(img)
                                      .error(
                                              function() {
                                                instance.attr("src",
                                                        "//image.ahnlab.com/img_upload/kr/site/images2/common/img_no_"
                                                                + w + "_" + h
                                                                + ".gif");
                                              }).attr("src",
                                              instance.attr("src"));
                            });

                    //로그아웃
                    $(".logoutBtn")
                            .click(
                                    function() {
                                      $
                                              .ajax({
                                                url: 'https://www.ahnlab.com/kr/site/login/userLogout.do',
                                                dataType: 'json',
                                                type: 'post',
                                                data: $("#loginForm")
                                                        .serialize(),
                                                success: function(json) {
                                                  if (json.isSuccess) {
                                                    location.reload();
                                                  } else {
                                                    alert(json.resultMessage);
                                                  }
                                                },
                                                error: function(x, o, e) {
                                                  alert("Network Error!");
                                                }
                                              });
                                    });

                    //닫기 버튼
                    $(".btnClose").click(function() {
                      self.close();
                    });

                    //시큐리티맵 팝업
                    $(".clickSecurityMapGnb")
                            .click(
                                    function() {
                                      POPUP
                                              .open(
                                                      'http://www.ahnlab.com/kr/site/product/securityMap.do',
                                                      'securityMap', {
                                                        width: 1000,
                                                        height: 750,
                                                        scroll: true
                                                      });

                                    });

                    //보안 통계 팝업
                    $(".securityStaticsPopup")
                            .click(
                                    function() {
                                      POPUP
                                              .open(
                                                      'http://www.ahnlab.com/kr/site/securityinfo/statistics/security1.do',
                                                      'statisticsPopup', {
                                                        width: 1000,
                                                        height: 760,
                                                        scroll: true
                                                      });
                                    });

                    //input box에 숫자만 허용 - ex: numberonly="true" 속성을 붙임
                    $(document).on(
                            "keyup",
                            "input:text[numberOnly]",
                            function() {
                              $(this)
                                      .val(
                                              $(this).val().replace(/[^0-9]/gi,
                                                      ""));
                            });
                  });

  //로그인
  function fnLoginCheck(url) {
    if ("" != "Y") {
      if (confirm("로그인 후 서비스 이용이 가능한 페이지입니다.\n로그인 페이지로 이동하시겠습니까?")) {
        Common.login('https://www.ahnlab.com', url);
        return;
      } else {
        return;
      }
    }
    location.href = url;
  }
  -->
</script>

<!-- Facebook Pixel Code -->
<script>
  !function(f, b, e, v, n, t, s) {
    if (f.fbq) return;
    n = f.fbq = function() {
      n.callMethod ? n.callMethod.apply(n, arguments) : n.queue.push(arguments)
    };
    if (!f._fbq) f._fbq = n;
    n.push = n;
    n.loaded = !0;
    n.version = '2.0';
    n.queue = [];
    t = b.createElement(e);
    t.async = !0;
    t.src = v;
    s = b.getElementsByTagName(e)[0];
    s.parentNode.insertBefore(t, s)
  }(window, document, 'script',
          'https://connect.facebook.net/en_US/fbevents.js');

  fbq('init', '989681144413577');
  fbq('track', "PageView");
</script>
<noscript>
	<img height="1" width="1" style="display: none" src="https://www.facebook.com/tr?id=989681144413577&ev=PageView&noscript=1" />
</noscript>
<!-- End Facebook Pixel Code -->

<!-- egovframework -->
<link href="<c:url value='/css/egovframework/com/com.css' />" rel="stylesheet" type="text/css">
<link href="<c:url value='/css/egovframework/com/button.css' />" rel="stylesheet" type="text/css">
<link href="<c:url value='${brdMstrVO.tmplatCours}' />" rel="stylesheet" type="text/css">
<c:if test="${anonymous == 'true'}">
	<c:set var="prefix" value="/anonymous" />
</c:if>
<script type="text/javascript" src="<c:url value='/js/egovframework/com/cop/bbs/EgovBBSMng.js' />"></script>
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
        if (event.keyCode == 13) {
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
        if (bbsId == "") return false; //20150508
        document.submitParam.nttId.value = nttId;
        document.submitParam.bbsId.value = bbsId;
        document.submitParam.action = "<c:url value='/ahnlab/selectBoardArticleDetail.do'/>";
        document.submitParam.submit();
      }
    //-->
    </script>
	</c:otherwise>
</c:choose>
<title><c:out value="${brdMstrVO.bbsNm}" /></title>

<style type="text/css">
h1 {
	font-size: 12px;
}

caption {
	visibility: hidden;
	font-size: 0;
	height: 0;
	margin: 0;
	padding: 0;
	line-height: 0;
}
</style>

</head>
<body>
	<div class="wrap">
		<nav id="skipNavi">skip navigation
		<ul>
			<li>
				<a href="#naviMenu">메뉴</a>
			</li>
			<li>
				<a href="#naviUtill">회원메뉴</a>
			</li>
			<li>
				<a href="#container">본문</a>
			</li>
			<li>
				<a href="#footer">하단 정보(링크)</a>
			</li>
		</ul>
		</nav>
		<!-- gnb -->
		<header class="htop">
		<div class="htopWrap">
			<!-- logo -->
			<p class="logo">
				<a href="/">
					<img src="/css/ahnlab/img_logo.gif" alt="AhnLab">
				</a>
			</p>
			<!-- logo -->

			<!-- etc menu -->
			<nav id="naviUtill">
			<ul>
				<li class="locSite">
					<a href="http://www.ahnlab.com" class="link" title="ahnlab.com 바로가기">
						<span class="bl"></span>
						회사소개
					</a>
				</li>
				<li>
					<a href="https://www.ahnlab.com/kr/site/login/loginForm.do" class="link">로그인</a>
				</li>

				<li>
					<a href="mailto:opensource@ahnlab.com">Contact US</a> 
				</li>
				<li class="familySite">
					<a href="#" class="link comboLink" title="패밀리 사이트 목록 보기">
						패밀리 사이트
						<span class="bl"></span>
					</a>
					<!-- layer -->
					<div class="lyUtill">
						<div class="lyWrap">
							<p>
								<a href="http://v3clinic.ahnlab.com/v3clinic/site/main/main.do" target="_blank" rel="nofollow"
									title="새창. V3 365 클리닉 사이트로 바로가기">V3 365 클리닉</a>
							</p>
							<p>
								<a href="http://shop.ahnlab.com/jump/jsp/fp/main.jsp" target="_blank" rel="nofollow" title="새창. AhnLab mall 사이트로 바로가기">AhnLab
									mall</a>
							</p>
							<p>
								<a href="http://v3mss.ahnlab.com/front/mss_main.do" target="_blank" rel="nofollow" title="새창. V3 MSS 사이트로 바로가기">V3 MSS</a>
							</p>
							<p>
								<a href="http://www.ahnlab.com/kr/site/product/purchase/eLicense.do" rel="nofollow" title="E-License Service 사이트로 바로가기">E-License
									Service</a>
							</p>
							<!-- <p><a href="http://www.ahnlab.com/kr/site/privacylab/main.do" target="_blank" rel="nofollow" title="새창. Privacy Lab 사이트로 바로가기">Privacy Lab</a></p> -->
						</div>
					</div>
					<!-- //layer -->
				</li>
			</ul>
			</nav>
			<!-- //etc menu -->

		</div>
		</header>
		<script type="text/javascript">
      $(".removeSearchTerm").click(function() {
        $("#topSearchTerm").val("");
        $(".removeSearchTerm").hide();
      });
      $("#topSearchTerm").addClass("fcGray");
      $("#topSearchTerm").focus(function() {
        if ($(this).val() == "견적문의") {
          $(this).val("").removeClass("fcGray");
        }
      });

      function dqTopSearch2() {
        $("#colTargetTop").val("TOTAL");
        $("#dqTopSearch").attr("target", "");

        if ($("#topSearchTerm").val() != "") {
          $("#dqTopSearch").attr("action",
                  "http://www.ahnlab.com/kr/site/search/totalSearch.do");
          $("#dqTopSearch").submit();
        } else {
          alert("검색어를 입력하세요");
          $("#topSearchTerm").focus();
          return;
        }
      }
    </script>
		<!-- //gnb -->
		<div id="container">

			<script language="javascript" type="text/javascript" src="http://download.ahnlab.com/engver_script/main_engver.js"></script>

			<div class="mnt">
				<div id="d-main-visual" class="vis">
					<!-- <button type="button" class="anim play"><span class="hide">안랩 홍보 롤링 배너 자동 업데이트 정지</span></button> -->
					<button type="button" class="anim stop" data-play-text="안랩 홍보 롤링 배너 자동 업데이트 시작" data-stop-text="안랩 홍보 롤링 배너 자동 업데이트 정지">
						<span class="hide">안랩 홍보 롤링 배너 자동 업데이트 정지</span>
					</button>

					<div class="visWrap">
						<button type="button" class="cir">
							<span class="hide">안랩 Opensource 공개 시스템</span>
						</button>
						<!-- onmouseover 가 되면 button 클래스에 over 클래스 추가 ex)<button type="button" class="cir on"> -->
						<div class="pic"
							style="left: 100%; background-color: #2e3b43; background-image: url('/css/ahnlab/banner_498.jpg');">&nbsp;</div>
						<div class="txtWrap" style="left: 100%;">
							<div class="txt">

								안랩 Opensource 공개 시스템 ( 이미지 추가 부분 )
								<!-- <a href="/kr/site/securityinfo/ransomware/index.do" target="_self">
									<img src="/css/ahnlab/text_banner_471.png" alt="안랩 랜섬웨어 보안센터" />
								</a> -->
							</div>
						</div>
					</div>

					<div class="visWrap">
						<button type="button" class="cir">
							<span class="hide">안랩 랜섬웨어 보안센터보기</span>
						</button>
						<!-- onmouseover 가 되면 button 클래스에 over 클래스 추가 ex)<button type="button" class="cir on"> -->
						<div class="pic"
							style="left: 200%; background-color: #091a2c; background-image: url('/css/ahnlab/banner_471.jpg');">&nbsp;</div>
						<div class="txtWrap" style="left: 200%;">
							<div class="txt">

								안랩 Opensource 공개 시스템 ( 이미지 추가 부분 )
							</div>
						</div>
					</div>

					<div class="visWrap">
						<button type="button" class="cir">
							<span class="hide">안전해서 더욱 자유로운 세상보기</span>
						</button>
						<!-- onmouseover 가 되면 button 클래스에 over 클래스 추가 ex)<button type="button" class="cir on"> -->
						<div class="pic"
							style="left: 400%; background-color: #423d39; background-image: url('/css/ahnlab/banner_468.jpg');">&nbsp;</div>
						<div class="txtWrap" style="left: 400%;">
							<div class="txt">
								안랩 Opensource 공개 시스템 ( 이미지 추가 부분 )
							</div>
						</div>
					</div>
				</div>
			</div>

			<br/>
			<div class="contents">
				<form name="frm" action="<c:url value='/cop/bbs${prefix}/selectBoardList.do'/>" method="post">
					<input type="hidden" name="bbsId" value="<c:out value='${boardVO.bbsId}'/>" />
					<input type="hidden" name="nttId" value="0" />
					<input type="hidden" name="bbsTyCode" value="<c:out value='${brdMstrVO.bbsTyCode}'/>" />
					<input type="hidden" name="bbsAttrbCode" value="<c:out value='${brdMstrVO.bbsAttrbCode}'/>" />
					<input type="hidden" name="authFlag" value="<c:out value='${brdMstrVO.authFlag}'/>" />
					<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>" />
					<table width="100%" cellpadding="8" class="table-search" border="0">
						<tr>
							<td width="40%" class="title_left">
								<h1></h1>
							</td>
							<td width="10%" class="title_left"></td>
							<td width="35%"></td>
							<th width="10%"></th>
						</tr>
					</table>
				</form>
				<div class="bbsList">
					<table>
						<caption>
							<span>공지사항 목록 내역</span>
						</caption>
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 30%;">
							<col style="width: 40%;">
							<col style="width: 10%;">
							<col style="width: 10%;">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">번호</th>
								<th scope="col">제품명</th>
								<th scope="col">설명</th>
								<th scope="col">라이선스</th>
								<th scope="col">공개소스</th>
							</tr>
						</thead>
						<tbody>
							<form name="submitParam" method="post">
								<input type="hidden" name="bbsId" />
								<input type="hidden" name="nttId" />
							</form>
							<c:forEach var="result" items="${resultList}" varStatus="status">
								<tr>
									<td class="numb">
										<c:out value="${(searchVO.pageIndex-1) * searchVO.pageSize + status.count}" />
									</td>
									<td>
										<c:choose>
											<c:when test="${result.isExpired=='Y' || result.useAt == 'N'}">
												<c:if test="${result.replyLc!=0}">
													<c:forEach begin="0" end="${result.replyLc}" step="1">
			    			&nbsp;
			    		</c:forEach>
													<img src="<c:url value='/images/egovframework/com/cmm/icon/reply_arrow.gif'/>" alt="reply arrow">
												</c:if>
												<c:out value="${result.nttSj}" />
											</c:when>
											<c:otherwise>
												<form name="subForm" method="post" action="<c:url value='/cop/bbs${prefix}/selectBoardArticle.do'/>">
													<input type="hidden" name="bbsTyCode" value="<c:out value='${brdMstrVO.bbsTyCode}'/>" />
													<input type="hidden" name="bbsAttrbCode" value="<c:out value='${brdMstrVO.bbsAttrbCode}'/>" />
													<input type="hidden" name="authFlag" value="<c:out value='${brdMstrVO.authFlag}'/>" />
													<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>" />
													<c:if test="${result.replyLc!=0}">
														<c:forEach begin="0" end="${result.replyLc}" step="1">
				    			&nbsp;
				    		</c:forEach>
														<img src="<c:url value='/images/egovframework/com/cmm/icon/reply_arrow.gif'/>" alt="reply arrow">
													</c:if>
													<span class="link">
														<a href="#" onclick="fn_egov_inqire_notice('${result.nttId}', '${result.bbsId }');">
															<c:out value="${result.nttSj}" />
														</a>
													</span>
												</form>
											</c:otherwise>
										</c:choose>
									</td>
									<td class="tLeft">
										<c:import url="/ahnlab/selectBoardArticle.do" charEncoding="utf-8">
											<c:param name="param_bbsId" value="${result.bbsId}" />
											<c:param name="param_nttId" value="${result.nttId}" />
										</c:import>
									</td>
									<c:if test="${brdMstrVO.bbsAttrbCode == 'BBSA01'}">
										<td>
											<c:out value="${result.ntceBgnde}" />
										</td>
										<td>
											<c:out value="${result.ntceEndde}" />
										</td>
									</c:if>
									<c:if test="${anonymous != 'true'}">
										<td>
											<c:out value="${result.frstRegisterNm}" />
										</td>
									</c:if>

									<c:import url="/ahnlab/selectFileInfs.do" charEncoding="utf-8">
										<c:param name="param_atchFileId" value="${result.atchFileId}" />
									</c:import>
								</tr>
							</c:forEach>
							<c:if test="${fn:length(resultList) == 0}">
								<tr>
									<c:choose>
										<c:when test="${brdMstrVO.bbsAttrbCode == 'BBSA01'}">
											<td class="listCenter" colspan="7">
												<spring:message code="common.nodata.msg" />
											</td>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${anonymous == 'true'}">
													<td class="listCenter" colspan="4">
														<spring:message code="common.nodata.msg" />
													</td>
												</c:when>
												<c:otherwise>
													<td class="listCenter" colspan="5">
														<spring:message code="common.nodata.msg" />
													</td>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:if>
						</tbody>
					</table>
				</div>
				<div class="paging">
					<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_noticeList" />
				</div>
			</div>
			<br/>



			<script type="text/javascript" src="/js/ahnlab/jquery.easing.1.3.js"></script>
			<script type="text/javascript" src="/js/ahnlab/jquery.mainslider.js"></script>
			<script type="text/javascript" src="/js/ahnlab/jquery.bannerslider.js"></script>
			<script type="text/javascript">
        $(function() {
          $("#container").addClass("main");

          $('#d-main-visual').mainslider();

          $('#d-image-banner').bannerslider({
            targetSelector: 'img.bann'
          });

          $('#d-text-banner1, #d-text-banner2, #d-text-banner3').bannerslider({
            autoSelector: 'button',
            moveHorizontal: false,
            moveSync: 'd-text-banner'
          });
          goNotice();
          var tvalue = $("#titHeight").height();

          //var hvalue = 306 - ($("#titHeight").height() + 33);
          if (tvalue <= 42) {
            $("#focusHeight").removeClass("row2 row3");
          } else if (tvalue >= 43 && tvalue <= 84) {
            $("#focusHeight").removeClass("row2 row3");
            $("#focusHeight").addClass("row2");
          } else if (tvalue >= 85) {
            $("#focusHeight").removeClass("row2 row3");
            $("#focusHeight").addClass("row3");
          }
          $("a.noticeCss").focus(function() {
            goNotice();
          });
          $("a.pressCss").focus(function() {
            goPress();
          });

        });

        function focusMove() {
          $('#blogLayerId').hide();
          $('#footerfocus').focus();
        }

        function goNotice() {
          $("#noticeDiv").removeClass("on");
          $("#noticeDiv").addClass("on");
          $("#noticeListDiv").show();
          $("#pressDiv").removeClass("on");
          $("#pressListDiv").hide();
        }
        function goPress() {
          $("#pressDiv").removeClass("on");
          $("#pressDiv").addClass("on");
          $("#pressListDiv").show();
          $("#noticeDiv").removeClass("on");
          $("#noticeListDiv").hide();

        }
        function goSecuNews(seq, menu_dist) {
          $("#seq").val(seq);
          $("#menu_dist").val(menu_dist);
          $("#secuNewsForm")
                  .attr("action",
                          "http://www.ahnlab.com/kr/site/securityinfo/secunews/secuNewsView.do");
          $("#secuNewsForm").attr("target", "_self");
          $("#secuNewsForm").submit();
        }
        function openPop() {
          POPUP
                  .open(
                          'http://www.ahnlab.com/kr/site/securityinfo/asec/popAsecWarning.do',
                          '_popAsecWarning', {
                            width: 618,
                            height: 620,
                            scroll: true
                          });
        }
        function fn_winOpen() {
          var v_url = "http://www.ahnlab.com/kr/site/errorPopMain.do";
          var v_width = "770";
          var v_height = "600";

          window.open(v_url, 'btnPop', 'width=' + v_width + ',height='
                  + v_height + ',scrollbars=yes');
        }
      </script>

		</div>
		<!-- footer -->


		<script type="text/javascript">
      var domain = location.href;
      $(document)
              .ready(
                      function() {
                        if (checkMobileDevice() == false) {
                          $("#mobile").hide();
                        }
                        var url = "https://www.ahnlab.com/kr/site/product/purchase/freeTrRegForm.do|http://www.ahnlab.com/kr/site/product/purchase/freeTrRegForm.do|http://www.ahnlab.com/kr/site/securityinfo/upgradenow.do|http://www.ahnlab.com/kr/site/securityinfo/healthcare.do|http://www.ahnlab.com/kr/site/securityinfo/ransomware/index.do|https://www.ahnlab.com/kr/site/customer/userEntryCertify.do|http://www.ahnlab.com/kr/site/customer/userEntryArticle.do?type=U|https://www.ahnlab.com/kr/site/customer/userEntryArticle.do?type=U|http://www.ahnlab.com/kr/site/event/notice/noticeList.do|http://www.ahnlab.com/kr/site/product/purchase/purchaseInfoNetwork.do|http://www.ahnlab.com/kr/site/support/virus/virus.do|http://www.ahnlab.com/kr/site/product/controlType5.do|http://www.ahnlab.com/kr/site/product/controlType4.do|http://www.ahnlab.com/kr/site/product/controlType3.do|http://www.ahnlab.com/kr/site/product/controlType2.do|http://www.ahnlab.com/kr/site/product/controlType1.do|http://www.ahnlab.com/kr/site/product/consultType11.do|http://www.ahnlab.com/kr/site/product/consultType10.do|http://www.ahnlab.com/kr/site/product/consultType9.do|http://www.ahnlab.com/kr/site/product/consultType8.do|http://www.ahnlab.com/kr/site/product/consultType7.do|http://www.ahnlab.com/kr/site/product/consultType6.do|http://www.ahnlab.com/kr/site/product/consultType5.do|http://www.ahnlab.com/kr/site/product/consultType4.do|http://www.ahnlab.com/kr/site/product/consultType3.do|http://www.ahnlab.com/kr/site/product/consultType2.do|http://www.ahnlab.com/kr/site/product/consultType1.do|http://www.ahnlab.com/kr/site/product/checklist/checkList.do|http://www.ahnlab.com/kr/site/product/careType1.do|http://www.ahnlab.com/kr/site/product/careType2.do|http://www.ahnlab.com/kr/site/product/careType3.do|http://www.ahnlab.com/kr/site/product/careType4.do|http://www.ahnlab.com/kr/site/product/careType5.do|http://www.ahnlab.com/kr/site/product/purchase/purchaseLicenseType.do|http://www.ahnlab.com/kr/site/product/purchase/purchaseLicenseGuarantee.do|http://www.ahnlab.com/kr/site/product/purchase/purchaseLicenseService.do|http://www.ahnlab.com/kr/site/product/purchase/purchasePartner2.do|http://www.ahnlab.com/kr/site/support/customer/exchangeCorp.do|https://www.ahnlab.com/kr/site/download/product/productInstallList.do|http://www.ahnlab.com/kr/site/download/product/productInstallList.do|http://www.ahnlab.com/kr/site/download/product/productInstallList.do|https://www.ahnlab.com/kr/site/download/product/productEngineList.do|http://www.ahnlab.com/kr/site/download/product/productEngineList.do|https://www.ahnlab.com/kr/site/download/product/productPatchList.do|http://www.ahnlab.com/kr/site/download/product/productPatchList.do|https://www.ahnlab.com/kr/site/download/product/productManualList.do|http://www.ahnlab.com/kr/site/download/product/productManualList.do|https://www.ahnlab.com/kr/site/download/product/productVaccineList.do|http://www.ahnlab.com/kr/site/download/product/productVaccineList.do|https://www.ahnlab.com/kr/site/download/product/productFreeList.do|http://www.ahnlab.com/kr/site/download/product/productFreeList.do|https://www.ahnlab.com/kr/site/download/product/productAllList.do|http://www.ahnlab.com/kr/site/download/product/productAllList.do|https://www.ahnlab.com/kr/site/download/product/productMyList.do|http://www.ahnlab.com/kr/site/download/product/productMyList.do|http://www.ahnlab.com/kr/site/support/virus/virusUse.do#virusInfoTitle|http://www.ahnlab.com/kr/site/support/virus/virusUse.do#ahnReportArea|https://www.ahnlab.com/kr/site/support/virus/reportForm.do?tab=2|http://www.ahnlab.com/kr/site/support/virus/reportForm.do?tab=2|https://www.ahnlab.com/kr/site/support/virus/reportCenterForm.do?tab=error|http://www.ahnlab.com/kr/site/support/virus/reportCenterForm.do?tab=error|http://www.ahnlab.com/kr/site/event/event/eventList.do|http://www.ahnlab.com/kr/site/support/closed/product.do|http://www.ahnlab.com/kr/site/download/info/windows.do|http://www.ahnlab.com/kr/tv/index.do|https://www.ahnlab.com/kr/site/mypage/mypageMain.do|http://www.ahnlab.com/kr/site/mypage/mypageMain.do|https://www.ahnlab.com/kr/site/mypage/customer/chkPassForm.do|http://www.ahnlab.com/kr/site/mypage/customer/chkPassForm.do|https://www.ahnlab.com/kr/site/mypage/customer/idManage.do|https://www.ahnlab.com/kr/site/mypage/customer/updPasswordForm.do|http://www.ahnlab.com/kr/site/mypage/customer/updPasswordForm.do|https://www.ahnlab.com/kr/site/mypage/customer/unSubScribePassForm.do|http://www.ahnlab.com/kr/site/mypage/customer/unSubScribePassForm.do|https://www.ahnlab.com/kr/site/mypage/product/prodListBiz.do|http://www.ahnlab.com/kr/site/mypage/product/prodListBiz.do|https://www.ahnlab.com/kr/site/mypage/product/prodInsBizForm.do|http://www.ahnlab.com/kr/site/mypage/product/prodInsBizForm.do|https://www.ahnlab.com/kr/site/mypage/buy/myBuyList.do|http://www.ahnlab.com/kr/site/mypage/buy/myBuyList.do|http://www.ahnlab.com/kr/site/product/partnerMain.do|https://www.ahnlab.com/kr/site/customer/userEntry.do|http://www.ahnlab.com/kr/site/customer/userEntry.do|https://www.ahnlab.com/kr/site/login/findIdForm.do|http://www.ahnlab.com/kr/site/login/findIdForm.do|https://www.ahnlab.com/kr/site/login/findIdBizForm.do|http://www.ahnlab.com/kr/site/login/findIdBizForm.do|https://www.ahnlab.com/kr/site/login/findPwForm.do|http://www.ahnlab.com/kr/site/login/findPwForm.do|https://www.ahnlab.com/kr/site/login/findPwBizForm.do|http://www.ahnlab.com/kr/site/login/findPwBizForm.do|http://www.ahnlab.com/kr/site/etc/rss.do|http://www.ahnlab.com/kr/site/etc/sitemap.do|http://www.ahnlab.com/kr/site/support/customer/remote.do|http://www.ahnlab.com/kr/site/product/controlPartner1.do|http://www.ahnlab.com/kr/site/product/controlPartner2.do|http://www.ahnlab.com/kr/site/product/controlPartner3.do|http://www.ahnlab.com/kr/site/product/controlPartner4.do|http://www.ahnlab.com/kr/site/securityinfo/newsletter/magazine.do|";
                        var domainUrl = url.split("|");

                        for (var j = 0; j < domainUrl.length - 1; j++) {
                          if (domain == domainUrl[j]) {
                            $("#mobile").hide();
                          }
                        }
                      });

      function checkMobileDevice() {
        var mobileKeyWords = new Array('Android', 'iPhone', 'iPod',
                'BlackBerry', 'Windows CE', 'SAMSUNG', 'LG', 'MOT',
                'SonyEricsson');
        for ( var info in mobileKeyWords) {
          if (navigator.userAgent.match(mobileKeyWords[info]) != null) { return true;

          }
        }
        return false;
      }

      function mobileGo() {
        domain = domain.replace("www.ahnlab.com", "m.ahnlab.com");

        $("#mobileFrm").attr("action", domain);
        $("#mobileFrm").submit();
      }

      function checkMobileDevice() {
        var mobileKeyWords = new Array('Android', 'iPhone', 'iPod',
                'BlackBerry', 'Windows CE', 'SAMSUNG', 'LG', 'MOT',
                'SonyEricsson');
        for ( var info in mobileKeyWords) {
          if (navigator.userAgent.match(mobileKeyWords[info]) != null) { return true;

          }
        }
        return false;
      }
    </script>
		<footer id="footer">
		<div class="footerWrap">
			<p class="copyright">&copy; AhnLab, Inc. All rights reserved.</p>
		</div>
		</footer>

		<form id="mobileFrm" name="mobileFrm" method="post">
			<input type="hidden" id="mobileParam" name="mobileParam" value="1" />
		</form>
		<script type="text/javascript">
      function getCookie(cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
          var c = ca[i];
          while (c.charAt(0) == ' ')
            c = c.substring(1);
          if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
        }
        return "";
      }
      function closeWin(winName, expiredays) {
        if ($("input:checkbox[id='chkToday']").is(":checked") == true) {
          setCookie(winName, "done", expiredays);
        }
        $("#mainLayer").hide();
      }

      function setCookie(name, value, expiredays) {
        var todayDate = new Date();
        todayDate.setDate(todayDate.getDate() + expiredays);
        document.cookie = name + "=" + escape(value) + "; path=/; expires="
                + todayDate.toGMTString() + ";";
      }

      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-17204763-3']);
      _gaq.push(['_trackPageview']);

      (function() {
        var ga = document.createElement('script');
        ga.type = 'text/javascript';
        ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl'
                : 'http://www')
                + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(ga, s);
      })();
    </script>

		<!-- This script is for AceCounter START -->
		<script type="text/javascript">
      var _mk = '';
      var _od = 0;
      var _gd = '';
      var _ud1 = '';
      var _skey = '';

      var cur_url = location.href;
      var url_index = cur_url.indexOf("event");

      if (url_index > -1) {
        _skey = cur_url;
      }
    </script>
		<!-- AceCounter END -->

		<!-- AceCounter Log Gathering Script V.71.2010011401 -->
		<script type="text/javascript">
      if (typeof _GUL == 'undefined') {
        var _GUL = 'acounter.ahnlab.com';
        var _GPT = '80';
        var _SGPT = '443';
        var _AIMG = new Image();
        var _bn = navigator.appName;
        var _PR = location.protocol == "https:" ? "https://" + _GUL + ":"
                + _SGPT : "http://" + _GUL + ":" + _GPT;
        if (_bn.indexOf("Netscape") > -1 || _bn == "Mozilla") {
          setTimeout("_AIMG.src = _PR+'/?cookie';", 1);
        } else {
          _AIMG.src = _PR + '/?cookie';
        }
        ;
        document
                .writeln("<scr"+"ipt language='javascript' src='/js/ahnlab/acecounter_V70.js'></scr"+"ipt>");
      }
    </script>
		<noscript>
			<img src='http://acounter.ahnlab.com:80/?uid=2&je=n&' border=0 width=0 height=0 alt="" />
		</noscript>
		<!-- AceCounter Log Gathering Script End -->
		<!-- //footer -->
	</div>

</body>
</html>
