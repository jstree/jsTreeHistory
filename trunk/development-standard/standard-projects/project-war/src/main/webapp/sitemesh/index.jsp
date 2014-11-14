<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<!-- Nero v1.1, Copyright 2014, Cloud Eight, https://www.cloud-eight.com -->

<!--[if lt IE 7 ]><html class="no-js ie ie6" lang="ko"><![endif]-->
<!--[if IE 7 ]><html class="no-js ie ie7" lang="ko"><![endif]-->
<!--[if IE 8 ]><html class="no-js ie ie8" lang="ko"><![endif]-->
<!--[if IE 9 ]><html class="no-js ie ie9" lang="ko"><![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head data-placeholder-focus="false" data-placeholder-live="false"></head>
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
						<a href="/" target="_self">
							<img src="${pageContext.request.contextPath}/assets/logo.jpg" alt="313 developer group logo">
						</a>
					</div>
					<div id="header-cart" class="one-third bm-remove last">
						<a href="/cart" target="_self"><i class="fa fa-shopping-cart fa-fw"></i> Login (<span id="ajax-header-cart-item-count">0</span> <span id="ajax-header-cart-item-text">items</span> - <span id="ajax-header-cart-total-price">£0.00</span>)</a>
					</div>
				</div>
			</header>
			<nav class="clearfix">
				<div class="container bm-larger">
					<div id="navigation" class="clearfix">
					
						<!-- For PC Menu -->
						<div id="click-nav" class="clearfix">
							<a href="${pageContext.request.contextPath}/" target="_self" class="nav-item first active" data-sub-nav="home-nav-links"> Home </a>
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
										<a href="${pageContext.request.contextPath}/" target="_self" class=" first active"> Home </a>
									</li>
									<hr class="bm-smaller" />
									<li class="nav-item has-dropdown">
										<a href="#" target="_self" class="parent-link"> Jstree 
										<span class="has-dropdown-icon float-right">+</span>
										</a>
										<ul class="sub-nav unstyled bm-remove">
											<li class="sub-nav-item first active">
												<a href="${pageContext.request.contextPath}/jsTreeOverView.html" target="_self" class="first active">&raquo; &nbsp;개요</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/jsTreeConcept.html" target="_self" class="">&raquo; &nbsp;컨셉</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/jsTreeApply.html" target="_self" class="">&raquo; &nbsp;적용</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/jsTreeSupport.html" target="_self" class="">&raquo; &nbsp;지원</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/jsTreeResult.html" target="_self" class="">&raquo; &nbsp;결과</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/jsTreeIntegration.html" target="_self" class="">&raquo; &nbsp;통합</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/jsTreeImprovement.html" target="_self" class="">&raquo; &nbsp;개선</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/jsTreeLicense.html" target="_self" class="last">&raquo; &nbsp;라이선스</a>
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
												<a href="${pageContext.request.contextPath}/baroBoardOverView.html" target="_self" class="first active">&raquo; &nbsp;개요</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/baroBoardConcept.html" target="_self" class="">&raquo; &nbsp;컨셉</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/baroBoardFuction.html" target="_self" class="">&raquo; &nbsp;기능</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/baroBoardReleaseNote.html" target="_self" class="">&raquo; &nbsp;릴리즈노트</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/baroBoardDemo.html" target="_self" class="">&raquo; &nbsp;데모</a>
											</li>
											<li class="sub-nav-item last">
												<a href="${pageContext.request.contextPath}/baroBoardLicence.html" target="_self" class="last">&raquo; &nbsp;라이선스</a>
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
												<a href="${pageContext.request.contextPath}/anyFramePortal.html" target="_self" class="first active">&raquo; &nbsp;애니 프레임워크 포탈</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/egovFramePortal.html" target="_self" class="">&raquo; &nbsp;표준프레임워크 포탈</a>
											</li>
											<li class="sub-nav-item last">
												<a href="${pageContext.request.contextPath}/egovFrameCommunity.html" target="_self" class="last">&raquo; &nbsp;표준프레임워크 오픈커뮤니티</a>
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
												<a href="${pageContext.request.contextPath}/313DevCI.html" target="_self" class="first active">&raquo; &nbsp;CI</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/313DevALM.html" target="_self" class="">&raquo; &nbsp;ALM</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/313DevStorage.html" target="_self" class="">&raquo; &nbsp;Storage</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/313DevMonitor.html" target="_self" class="">&raquo; &nbsp;Monitor</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/313DevAnalysis.html" target="_self" class="">&raquo; &nbsp;Analysis</a>
											</li>
											<li class="sub-nav-item last">
												<a href="${pageContext.request.contextPath}/313DevTool.html" target="_self" class="last">&raquo; &nbsp;Tools</a>
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
												<a href="${pageContext.request.contextPath}/committer.html" target="_self" class="first active">&raquo; &nbsp;커미터</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/committerSchedule.html" target="_self" class="">&raquo; &nbsp;커미터 일정관리</a>
											</li>
											<li class="sub-nav-item last">
												<a href="${pageContext.request.contextPath}/committerSchedule.html" target="_self" class="last">&raquo; &nbsp;Contact Us</a>
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
												<a href="${pageContext.request.contextPath}/notice.html" target="_self" class="first active">&raquo; &nbsp;공지사항</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/qnA.html" target="_self" class="">&raquo; &nbsp;Q&A</a>
											</li>
											<li class="sub-nav-item">
												<a href="${pageContext.request.contextPath}/freeBoard.html" target="_self" class="">&raquo; &nbsp;자유게시판</a>
											</li>
											<li class="sub-nav-item last">
												<a href="${pageContext.request.contextPath}/galleryBoard.html" target="_self" class="last">&raquo; &nbsp;갤러리게시판</a>
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
												<a href="${pageContext.request.contextPath}/accountLogin.html" target="_self" class="first active">&raquo; &nbsp;Login</a>
											</li>
											<li class="sub-nav-item last">
												<a href="${pageContext.request.contextPath}/accountRegister.html" target="_self" class="last">&raquo; &nbsp;Register</a>
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
							<a href="${pageContext.request.contextPath}/jsTreeOverView.html" target="_self" class="sub-nav-item first active">개요</a>
							<a href="${pageContext.request.contextPath}/jsTreeConcept.html" target="_self" class="sub-nav-item">컨셉</a>
							<a href="${pageContext.request.contextPath}/jsTreeApply.html" target="_self" class="sub-nav-item">적용</a>
							<a href="${pageContext.request.contextPath}/jsTreeSupport.html" target="_self" class="sub-nav-item">지원</a>
							<a href="${pageContext.request.contextPath}/jsTreeResult.html" target="_self" class="sub-nav-item">결과</a>
							<a href="${pageContext.request.contextPath}/jsTreeIntegration.html" target="_self" class="sub-nav-item">통합</a>
							<a href="${pageContext.request.contextPath}/jsTreeImprovement.html" target="_self" class="sub-nav-item">개선</a>
							<a href="${pageContext.request.contextPath}/jsTreeLicense.html" target="_self" class="sub-nav-item last">라이선스</a>
						</div>
						<div id="baroboard-nav-links" class="sub-nav">
							<a href="${pageContext.request.contextPath}/baroBoardOverView.html" target="_self" class="sub-nav-item first active">개요</a>
							<a href="${pageContext.request.contextPath}/baroBoardConcept.html" target="_self" class="sub-nav-item">컨셉</a>
							<a href="${pageContext.request.contextPath}/baroBoardFuction.html" target="_self" class="sub-nav-item">기능</a>
							<a href="${pageContext.request.contextPath}/baroBoardReleaseNote.html" target="_self" class="sub-nav-item">릴리즈노트</a>
							<a href="${pageContext.request.contextPath}/baroBoardDemo.html" target="_self" class="sub-nav-item">데모(Version 2.x)</a>
							<a href="${pageContext.request.contextPath}/baroBoardDownload.html" target="_self" class="sub-nav-item">다운로드</a>
							<a href="${pageContext.request.contextPath}/baroBoardLicence.html" target="_self" class="sub-nav-item last">라이선스</a>
						</div>
						<div id="framework-nav-links" class="sub-nav">
							<a href="${pageContext.request.contextPath}/anyFramePortal.html" target="_self" class="sub-nav-item first active">애니 프레임워크 포탈</a>
							<a href="${pageContext.request.contextPath}/egovFramePortal.html" target="_self" class="sub-nav-item">전자 정부 표준프레임워크 포탈</a>
							<a href="${pageContext.request.contextPath}/egovFrameCommunity.html" target="_self" class="sub-nav-item last">전자 정부 표준프레임워크 오픈커뮤니티</a>
						</div>
						<div id="devtools-nav-links" class="sub-nav">
							<a href="${pageContext.request.contextPath}/313DevCI.html" target="_self" class="sub-nav-item first active">CI</a>
							<a href="${pageContext.request.contextPath}/313DevALM.html" target="_self" class="sub-nav-item">ALM</a>
							<a href="${pageContext.request.contextPath}/313DevStorage.html" target="_self" class="sub-nav-item">Storage</a>
							<a href="${pageContext.request.contextPath}/313DevMonitor.html" target="_self" class="sub-nav-item">Monitor</a>
							<a href="${pageContext.request.contextPath}/313DevAnalysis.html" target="_self" class="sub-nav-item">Analysis</a>
							<a href="${pageContext.request.contextPath}/313DevTool.html" target="_self" class="sub-nav-item last">Tool</a>
						</div>
						<div id="aboutus-nav-links" class="sub-nav">
							<a href="${pageContext.request.contextPath}/committer.html" target="_self" class="sub-nav-item first">Comitters</a>
							<a href="${pageContext.request.contextPath}/comitterSchedule.html" target="_self" class="sub-nav-item">커미터 일정관리</a>
							<a href="${pageContext.request.contextPath}/contactus.html" target="_self" class="sub-nav-item last">Contact Us</a>
						</div>
						<div id="community-nav-links" class="sub-nav">
							<a href="${pageContext.request.contextPath}/notice.html" target="_self" class="sub-nav-item">공지사항</a>
							<a href="${pageContext.request.contextPath}/qnA.html" target="_self" class="sub-nav-item">Q&A</a>
							<a href="${pageContext.request.contextPath}/freeBoard.html" target="_self" class="sub-nav-item">자유게시판</a>
							<a href="${pageContext.request.contextPath}/galleryBoard.html" target="_self" class="sub-nav-item last">갤러리게시판</a>
						</div>
						<div id="account-nav-links" class="sub-nav">
							<a href="${pageContext.request.contextPath}/accountLogin.html" target="_self" class="sub-nav-item">Log In</a>
							<a href="${pageContext.request.contextPath}/accountRegister.html" target="_self" class="sub-nav-item last">Register</a>
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
			<main id="template-index-liquid" class="clearfix" role="main">
				<div class="container">
					<div class="one-whole bm-larger">
						<div id="index-image-slider-container" class="clearfix">
							<div id="index-image-slider" class="owl-carousel owl-theme">
								<div class="item">
									<img src="${pageContext.request.contextPath}/assets/slide-1.jpg?20" alt="Slide One" />
								</div>
								<div class="item">
									<img src="${pageContext.request.contextPath}/assets/slide-2.jpg?20" alt="Slide Two" />
								</div>
								<div class="item">
									<img src="${pageContext.request.contextPath}/assets/slide-3.jpg?20" alt="Slide Three" />
								</div>
								<div class="item">
									<img src="${pageContext.request.contextPath}/assets/slide-4.jpg?20" alt="Slide Four" />
								</div>
								<div class="item">
									<img src="${pageContext.request.contextPath}/assets/slide-5.jpg?20" alt="Slide Five" />
								</div>
							</div>
							<div class="prev tip-t-fade" data-tooltip="Previous"></div>
							<div class="next tip-t-fade" data-tooltip="Next"></div>
						</div>
					</div>
				</div>
				<script>
					$(document).ready(
					    function() {
					        var $indexSlider = $('#index-image-slider');
					
					        $indexSlider.owlCarousel({
					
					            transitionStyle: 'fadeUp',
					
					            autoPlay: 5000,
					            paginationSpeed: 500,
					            singleItem: true,
					            stopOnHover: true
					        });
					
					        $('#index-image-slider-container .prev').on('click',
					            function() {
					                $indexSlider.trigger('owl.prev');
					            });
					
					        $('#index-image-slider-container .next').on('click',
					            function() {
					                $indexSlider.trigger('owl.next');
					            });
					    });
				</script>
				<div class="container">
					<div class="one-whole  animate-in" data-anim-type="fade-in" data-anim-delay="fade-in">
						<div class="one-whole boxed p-twenty">
							<p class="bm-larger tm-larger text-center">No Content Page Selected
							</p>
						</div>
					</div>
				</div>
				<div class="container">
					<div class="one-whole">
						<p class="special-header animate-in" data-anim-type="fade-in" data-anim-delay="0">Featured Products</p>
						<div class="one-quarter product-item boxed p-ten text-center odd loop-first  sold-out  animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
							<div class="image-and-overlay-container bm-small">
								<div class="image">
									<a href="${pageContext.request.contextPath}/baroBoardOverView.html" target="_self">
									<img src="${pageContext.request.contextPath}/images/test_img.jpg" alt="Cropped Brown Leather Jacket" class="block" />
									</a>
								</div>
								<a href="${pageContext.request.contextPath}/baroBoardOverView.html" target="_self" class="overlay"></a>
								<span class="quick-look-icon cursor-pointer tip-t-fade" data-tooltip="Quick Look"><a href="#" target="_self" class="quick-look" data-quick-look-handle="cropped-brown-leather-jacket"><i class="fa fa-search fa-fw"></i></a></span>
							</div>
							<p class="bm-remove no-text-overflow">
								<a href="${pageContext.request.contextPath}/baroBoardOverView.html" target="_self"><strong>바로보드 개발중<br />으아아아아악</strong></a>
							</p>
						</div>
						<div class="one-whole bm-larger boxed p-twenty animate-in" data-anim-type="fade-in" data-anim-delay="0">
							<p class="bm-larger tm-larger text-center">No Products Selected</p>
						</div>
					</div>
				</div>
				<div class="container">
					<div class="one-whole">
						<p class="special-header animate-in" data-anim-type="fade-in" data-anim-delay="0">Latest News</p>
						<div class="one-whole bm-larger boxed p-twenty animate-in" data-anim-type="fade-in" data-anim-delay="0">
							<p class="bm-larger tm-larger text-center">No Blog Selected</p>
						</div>
					</div>
				</div>
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
								src="${pageContext.request.contextPath}/assets/cc-visa.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="Visa" /></span> <span class="cursor-pointer"><img
								src="${pageContext.request.contextPath}/assets/cc-mastercard.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="MasterCard" /></span> <span class="cursor-pointer"><img
								src="${pageContext.request.contextPath}/assets/cc-american-express.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="American Express" /></span>
							<span class="cursor-pointer"><img
								src="${pageContext.request.contextPath}/assets/cc-maestro.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="Maestro" /></span> <span class="cursor-pointer"><img
								src="${pageContext.request.contextPath}/assets/cc-switch.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="Switch" /></span> <span class="cursor-pointer"><img
								src="${pageContext.request.contextPath}/assets/cc-western-union.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="Western Union" /></span> <span class="cursor-pointer"><img
								src="${pageContext.request.contextPath}/assets/cc-discover.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="Discover" /></span> <span class="cursor-pointer"><img
								src="${pageContext.request.contextPath}/assets/cc-paypal.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="PayPal" /></span> <span class="cursor-pointer"><img
								src="${pageContext.request.contextPath}/assets/cc-google-wallet.png?20"
								alt="Visa" class="tip-t-fade" data-tooltip="Google Wallet" /></span> <span class="cursor-pointer"><img
								src="${pageContext.request.contextPath}/assets/cc-bitcoin.png?20"
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