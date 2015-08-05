<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js" style="height:100%">
<!--<![endif]--> 
	<head>
		<script src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/js/responsive.min.js"></script>
		<link rel="stylesheet" href="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/css/reset.css" type="text/css"  media="all" />
		<script src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/js/html5shiv.js"></script>
		
		<!--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<script src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/js/prototype.js"></script>
		<script src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/js/side-bar.js"></script>
		<script src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/js/effects.js"></script>-->
		<!--<script src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/js/vendor/jquery-1.10.2.min.js"></script>
		<script src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/js/vendor/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/js/main.js"></script>-->		

		
		 <script type="text/javascript">
			/*//퀵 링크
			$(document).ready(function() {
				//	퀵 메뉴의 top 속성값 얻어오기 
				var top = $(".quick_menu").css("top");
				top = parseInt(top);
				//	윈도우가 스크롤 되어질때 퀵메뉴의 top 속성값을 스크롤 되어진 top 의 위치로 바꾸기
				$(window).scroll(function() {	//	윈도우가 스크롤이 될때 ...
					//	현재 스크롤 되어진 top의 속성값 얻어오기 
					var scrollTop = $(window).scrollTop();
					//	이동할 top 의 위치 구하기 
					var moveTop = scrollTop + top;
					//	현재 진행중인 animate 가 있다면 멈춘다.
					$(".quick_menu").stop();
					//	퀵 메뉴의 top 속성을 1초간 바꾸기
					$(".quick_menu").animate({top:moveTop},1000);
				});						
			})*/

			$(function($){
				var btns = $('#side_gnb > .side_btn > a');
				$('#side_gnb').addClass('open');
				btns.on('click', function(){
					if ($(this).parent().parent().hasClass('open')) {
						$('#side_gnb').stop().animate({'right':'-65px'}, 500, function(){
							$('#side_gnb').removeClass('open');
							var open = btns.children('img').attr('src').replace('side_close.gif', 'side_open.gif');
							btns.children('img').attr('src', open);
						});
						$('#side_gnb .top').stop().animate({'width':'65px'}, 500);
					} else {
						$('#side_gnb').stop().animate({'right':'0'}, 500, function(){
							$('#side_gnb').addClass('open');
							var close = btns.children('img').attr('src').replace('side_open.gif', 'side_close.gif');
							btns.children('img').attr('src', close);
						});
						$('#side_gnb .top').stop().animate({'width':'100%'}, 500);
					}
					return false;
				});
				btns.click();
			});
		</script>

		<style type="text/css">
			/* content_area */
			@import url(http://fonts.googleapis.com/earlyaccess/nanumgothiccoding.css);
			/*.container.wrap {border:1px solid red}*/
			.container .wrapper {width:100%; letter-spacing: -0.03em}
			.container .content_l {position:relative; float:left; padding:0 3% 0 10%; width:70%; text-align:left; font-family:'Nanum Gothic Coding' !important}
			.container .content_l h4 {font-family:'Nanum Gothic Coding' !important; padding-bottom:15px; font-weight:bold; line-height:1.2em}
			.container .link_space {padding-left:10%; font-family:'Nanum Gothic Coding' !important}
			.container .link_space a {padding:2px 20px 2px 20px; font-size:0.9em; background:url(http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/ico3.gif) 0 4px no-repeat; background-size:15px}
			.container .link_space a:first-child {background:url(http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/ico2.gif) 0 4px no-repeat; padding-left:20px; background-size:15px}
			.container .content_l p.ico {position:absolute; top:0; left:0; display:inline-block; width:15%}
			.container .content_l p.ico img {width:50%}
			.container .content_r {float:right; width:30%; font-family:'Nanum Gothic Coding' !important}
			.container .content_r p.cap {text-align:center; font-size:0.9em}
			.container .content_r img {width:100%; margin-bottom:-10px}

			/* quicks link 1 */
			.quick_menu {width:50px; height:134px; position:fixed; top:170px !important; right:15px;}
			.quick_menu ul li.topmove {margin-top:5px;}

			/* side_bar */
			#side_gnb {z-index: 9999; position: fixed; height: 100%; border-left: 1px solid #cdcdcd; border-right: 1px solid #cdcdcd; background: #e4e4e4; right: 0; top:0 !important; width:120px}
			#side_gnb .side_btn {position: absolute; top: 50%; margin-left: -11px;}
			#side_gnb ul {margin-top:120px; }
			#side_gnb ul li {padding:10px 0 10px 10px; border-bottom:1px solid #cdcdcd;}
			#side_gnb ul li:first-child {border-top:1px solid #cdcdcd; }
			#side_gnb ul li a {text-decoration:none; display:block}
			#side_gnb ul li span {padding-left:10px; color:#515151; font-weight:bold;}
			#side_gnb ul li img {width:37px}
			#side_gnb .top {position: absolute; bottom: 0; width: 100%; background: #909090; text-align: center;}
			#side_gnb .top a {padding:7px 0; display:block}

			@media only screen and (max-width: 768px) {
				
				.container .content_l {
					float: none;
					width:100%;
				}
				
				.container .content_r {
					float: none;
					width:100%;
				}
				.container .content_r p.cap {
					margin:-4% 0 7% 0
				}
				.container .content_l p.ico img {
					width:40%
				}
				
				.quick_menu ul li a img {
					width:15px
				}
			}

			@media only screen and (max-width: 480px) {
				
				.container .content_l {
					float: none;
					width:100%
				}
				.clearfix .content_r {
					float: none;
					width:100%;
				}
				.container .content_r p.cap {
					margin:-4% 0 7% 0
				}
				.container .content_l p.ico img {
					width:40%
				}
				.quick_menu {
					display:none
				}
				#side_gnb {
					display:none
				}
				#columns {
					width:100%
				}
			}

			@media only screen and (min-width:769px) {
				.container .content_l p.ico img {
					width:65%
				}
			}
		</style>
	</head>
	<body>
		<section class="clearfix con_wrapper" >
			<nav>
				<div class="container wrap bm-medium">
					<div class="one-whole">
						<div class="no-display">article</div>
						<div class="text-center">
							<h2 class="bm-remove">
								JsTree 적용
							</h2>
							<p class="bm-remove">
								<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
								&nbsp;/&nbsp;
								JsTree
								&nbsp;/&nbsp;
								Apply
							</p>						
						</div>
					</div>
				</div>
			</nav>
			<article>
				<div class="clearfix">
					<div class="container wrap bm-remove con_wrapper">
						<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
							<div class="article-body rte" itemprop="articleBody">
								<div class="tablet-mobile alpha bm-remove last clearfix wrapper">
									<div class="one-half-percent tablet-mobile bm-remove omega content_l">
										<p class="one-half-percent tablet-mobile bm-remove omega ico"><img src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/coming.gif" alt="" /></p>
										<h4 class="title"><span>(연구범위) 데이터집합간의 연결</span></h4>
										<div class="content">
											<div id="link-list">
												<ul class="unstyled bm-remove">
													<!-- <li><a href="#"><span>데이터 집한 간의 연결</span></a></li> -->
													<li><i class="fa fa-caret-right fw"></i><span> 정규식 표현의 설계 ( 견고함 - 정규화 )</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 고정된 Model Bean 생성</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 정규화후 Model Bean에 의한 구조화 ( 이때부터 변경에 취약한 구조로 변화 )</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> Model 구조화 후 스키마 연계에 의거한 서비스 코드 작성.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 서비스 코드 작성 이후로 고객의 변경 사항에 취약함.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 메타 데이터의 데이터 집한간 연결을 고려했을 시 역시 서비스 코드의 고착화는 피할 수 없음 ( 서비스 코드의 태생적 한계이기 때문에 )</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 서비스 코드를 제외한 코드는 서비스 코드와 분리되어야 하고,</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 그 자체로 독립적인 메타 데이터간의 연결이 이루어진다면. </span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 유연한 인터페이스를 가진 형태를 가지게 됨. </span></li><br>
												
												</ul>
											</div>
										</div>
									</div>
									<div class="one-half-percent tablet-mobile bm-remove omega content_r">
										<p><img src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/kiki.gif" alt="" /></p>
										<p class="cap">[그림1 : 클래스 연관관계도]</p>
									</div>
								</div>
								<div class="link_space">
									<a href="">데이터집합간의 연결</a>
									<a href="">데이터 집합 안의 연결</a>
								</div>
							</div>
						</div>
						<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
							<div class="article-body rte" itemprop="articleBody">
								<div class="tablet-mobile alpha bm-remove last clearfix wrapper">
									<div class="one-half-percent tablet-mobile bm-remove omega content_l">
										<p class="one-half-percent tablet-mobile bm-remove omega ico"><img src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/coming.gif" alt="" /></p>
										<h4 class="title"><span>(연구범위) 데이터집합안의 연결</span></h4>
										<div class="content">
											<div id="link-list">
												<ul class="unstyled bm-remove">
													<!-- <li><a href="#"><span>데이터 집합 안의 연결</span></a></li> -->
													<li><i class="fa fa-caret-right fw"></i><span> 메타 데이터와 model 의 결합으로 인하여 어플리케이션간의 인터페이스 역할은 여러가지 장점이 있지만 명확한 장점은 아님.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 메타 데이터의 model 결합으로 인하여 기본적인 데이터 집합 내 구조적 특성을 제공함.</span></li>
													<li><i class="fa fa-caret-right fw"></i><span> 이 특성은 Model에 바인딩 되는 모든 데이터를 스키마 내의 집합 데이터안에서 고객의 Needs에 의한 구조적 특성을 가지게 되며, 메타 데이터 간의 스키마 연계는 일관된 형태를 유지하기 때문에 변경에 유리함. ( 모델의 특성에 얽메이지 않기 때문에 )</span></li>
												</ul>
											</div>
										</div>
										<p>고객의 Needs는 항상 변화하고, 프로젝트는 항상 그 변화에 추가 비용 및 시간에 감당하지 못하는게 사실 입니다. 이 변화는 대부분의 프로젝트에서 항상 발생하고, 프로젝트는 이 변화에 순응하다 비용을 감당하지 못하고 프로젝트가 실패하거나, 고객의 요구를 컨트롤 하지 못했다는 이유로 프로젝트를 올바르게 제어하지 못한체 마감되었다고 평가되곤 합니다. 혹은 개발자를 혹사시켜, 프로젝트의 마감 기한을 맞추는 악순환의 기로에 서게 됩니다.</p>
										<p>'매번 이런 현상이 발생하는 이유가 뭘까?' 를 생각해 봤습니다. '어떻게 해야 프로젝트를 성공적으로 이끌어 갈수 있을까?' 를 생각해 봤습니다. '어떻게 하면 프로젝트의 비용을 줄일 수 있을까?' 를 생각해 봤습니다.</p>
										<p>'고객의 Needs가 변화하더라도 설계를 유연하게 할 수 있는 방법은 없을까?' 를 고민한 끝에 JsTree 만이 이 문제를 해결할 수 있을것이라 결론지었습니다. 단일한 알고리즘과 데이터 모델의 메타 데이터를 고객의 Needs에 맞춰 변경및 변형을 통하여, 설계를 유연하게 변경하며, 단일 집합 내에서의 변경이 외부의 영향을 받는 서비스 코드만을 변경하면 되는 방법을 구현하였습니다.</p>
										<p>상호 유기적인 데이터 병합의 의미 도출 개발도 유지하며, 우리는 새롭게 단일 데이터 집합에서 또 다른 새로운 의미를 도출 할 수 있는 어플리케이션의 은탄환을 구현하였습니다.</p> 
										<p>상호관계의 표현을 위하여 수많은 연구가 수행되어, 정규화 및 데이터 모델에 관한 많은 연구가 수행되어 왔습니다. 하지만, 그 모든 기준의 새로운 시작은 단일 데이터 집합내의 구조적 관계 구성에 대하여 연구가 수행된다면, 새로운 페러다임을 찾을 수 있다는 것을 알았습니다. 즉, 이미 증명되었듯이, 데이터 스키마간의 상호 관계성은 변화에 취약 할 수 밖에 없는 필연적인 문제를 만듭니다.</p>
										<p>또한 고객은 내부 단일 데이터의 데이터 모델의 메타 데이터 제공을 통하여, 이런 변화에 혁신적인 알고리즘 모듈을 소개합니다.</p>
										<ul class="unstyled bm-remove">
											<li><a href=""><span>스크립트 기능 집중</span></a>
												<ul class="unstyled">
													<li><i class="fa fa-caret-right fw"></i><span> 장기적인 프로젝트</span></li>
													<li onclick="javascript:alert(getResult());"><i class="fa fa-caret-right fw"></i><span> Front-end 기능의 집중</span></li>
												</ul>
											</li>
										</ul>
									</div>
									<div class="one-half-percent tablet-mobile bm-remove omega content_r">
										<p><img src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/kiki.gif" alt="" /></p>
										<p class="cap">[그림1 : 클래스 연관관계도]</p>
									</div>
								</div>
								<div class="link_space">
									<a href="">데이터집합간의 연결</a>
									<a href="">데이터 집합 안의 연결</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				
			</article>
	
			
		</section>
		<!-- quick link1 -->
		<!--<div class="quick_menu">
			<ul class="one-half-percent tablet-mobile bm-remove omega">
				<li><a href="#" class="inline-block w-small bm-remove tip-l-fade" data-tooltip="검색하기" target="_blank"><img src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/quick_ico01.gif" /></a></li>
				<li><a href="#" href="#" class="inline-block w-small bm-remove tip-l-fade" data-tooltip="사진보기" target="_blank"><img src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/quick_ico02.gif" alt="" /></a></li>
				<li><a href="#" href="#" class="inline-block w-small bm-remove tip-l-fade" data-tooltip="게시판"><img src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/quick_ico03.gif" alt="" /></a></li>
				<li class="topmove"><a href="#" class="inline-block w-small bm-remove tip-l-fade" data-tooltip="Top"><img src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/top.gif" alt="" /></a></li>
			</ul>
		</div>
-->
		
		<!-- slice_bar -->
		<!--<div id="side_gnb">
			<div class="side_btn one-half-percent tablet-mobile bm-remove omega"><a href=""><img src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/side_close.gif"></a></div>
				<ul>
					<li><a href=""><img src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/naver.png" alt="" /><span>네이버</span></a></li>
					<li><a href=""><img src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/google.png" alt="" /><span>구글</span></a></li>
					<li><a href=""><img src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/daum.gif" alt="" /><span>다음</span></a></li>
				</ul>
			<div class="top"><a href="#"><img src="http://www.313.co.kr:5002/Component/jsp/community/jsTreeAlg/jsTreeApply/img/side_top.gif" alt="TOP"> </a></div>
		</div>
	-->
	</body>
</html>

