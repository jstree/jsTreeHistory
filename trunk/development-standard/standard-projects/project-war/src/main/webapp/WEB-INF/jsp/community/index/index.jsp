<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head></head>
	<body>
		<section class="clearfix" >
			<div class="container">
				<div class="one-whole bm-larger">
					<div id="index-image-slider-container" class="clearfix">
						<div id="index-image-slider" class="owl-carousel owl-theme">
							<div class="item">
								<img src="${pageContext.request.contextPath}/assets/images/slide-1.jpg?20" alt="Slide One" />
							</div>
							<div class="item">
								<img src="${pageContext.request.contextPath}/assets/images/slide-2.jpg?20" alt="Slide Two" />
							</div>
							<div class="item">
								<img src="${pageContext.request.contextPath}/assets/images/slide-3.jpg?20" alt="Slide Three" />
							</div>
							<div class="item">
								<img src="${pageContext.request.contextPath}/assets/images/slide-4.jpg?20" alt="Slide Four" />
							</div>
							<div class="item">
								<img src="${pageContext.request.contextPath}/assets/images/slide-5.jpg?20" alt="Slide Five" />
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
				<div class="one-whole">
					<p class="special-header animate-in" data-anim-type="fade-in" data-anim-delay="0">Why BaroBoard?</p>
					<div class="one-quarter product-item boxed p-ten text-center odd loop-first  sold-out  animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image">
								<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self">
								<img src="http://dummyimage.com/500/45e083/fff.jpg&text=500*500+Test+Image" alt="" class="block" />
								</a>
							</div>
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self" class="overlay"></a>
							<span class="quick-look-icon cursor-pointer tip-t-fade" data-tooltip="Quick Look"><a href="#" target="_self" class="quick-look" data-quick-look-handle="cropped-brown-leather-jacket"><i class="fa fa-search fa-fw"></i></a></span>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self"><strong>설치형 게시판 솔루션</strong></a>
						</p>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center even loop-first animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image">
								<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self">
								<img src="http://dummyimage.com/500/45e083/fff.jpg&text=500*500+Test+Image" alt="" class="block" />
								</a>
							</div>
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self" class="overlay"></a>
							<span class="quick-look-icon cursor-pointer tip-t-fade" data-tooltip="Quick Look"><a href="#" target="_self" class="quick-look" data-quick-look-handle="cropped-brown-leather-jacket"><i class="fa fa-search fa-fw"></i></a></span>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self"><strong>기존 PHP게시판 기능 제공</strong></a>
						</p>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center odd loop-first  animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image">
								<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self">
								<img src="http://dummyimage.com/500/45e083/fff.jpg&text=500*500+Test+Image" alt="" class="block" />
								</a>
							</div>
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self" class="overlay"></a>
							<span class="quick-look-icon cursor-pointer tip-t-fade" data-tooltip="Quick Look"><a href="#" target="_self" class="quick-look" data-quick-look-handle="cropped-brown-leather-jacket"><i class="fa fa-search fa-fw"></i></a></span>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self"><strong>Spring Security 기반의 보안기능</strong></a>
						</p>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center even last loop-first animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image">
								<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self">
								<img src="http://dummyimage.com/500/45e083/fff.jpg&text=500*500+Test+Image" alt="" class="block" />
								</a>
							</div>
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self" class="overlay"></a>
							<span class="quick-look-icon cursor-pointer tip-t-fade" data-tooltip="Quick Look"><a href="#" target="_self" class="quick-look" data-quick-look-handle="cropped-brown-leather-jacket"><i class="fa fa-search fa-fw"></i></a></span>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self"><strong>Java 컴포넌트 기반의 플러그인 제공</strong></a>
						</p>
					</div>
					<div class="one-whole bm-larger boxed p-twenty animate-in" data-anim-type="fade-in" data-anim-delay="0">
						<p class="bm-larger tm-larger text-center">
						바로보드는 강력한 Java기반 게시판 오픈소스 입니다. 기존 PHP보드들이 지원하는 기능을 제공하며, Spring Security 기반의 보안기능을 제공합니다. <br />
						쉽게 Java 프로젝트에 쉽게 Embed 할 수 있으며, 단독적으로 설치도 가능합니다.
						</p>
					</div>
				</div>
				
				<div class="one-whole">
					<p class="special-header animate-in" data-anim-type="fade-in" data-anim-delay="0">Getting Start BaroBoard</p>
					<div class="one-quarter product-item boxed p-ten text-center odd loop-first  sold-out  animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image">
								<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self">
								<img src="http://dummyimage.com/500/d5faef/000000&text=GettingStart" alt="" class="block" />
								</a>
							</div>
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self" class="overlay"></a>
							<span class="quick-look-icon cursor-pointer tip-t-fade" data-tooltip="Quick Look"><a href="#" target="_self" class="quick-look" data-quick-look-handle="cropped-brown-leather-jacket"><i class="fa fa-search fa-fw"></i></a></span>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self"><strong>Getting Start</strong></a>
						</p>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center even loop-first animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image">
								<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self">
								<img src="http://dummyimage.com/500/d5faef/000000&text=Download" alt="" class="block" />
								</a>
							</div>
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self" class="overlay"></a>
							<span class="quick-look-icon cursor-pointer tip-t-fade" data-tooltip="Quick Look"><a href="#" target="_self" class="quick-look" data-quick-look-handle="cropped-brown-leather-jacket"><i class="fa fa-search fa-fw"></i></a></span>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self"><strong>Download</strong></a>
						</p>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center odd loop-first  animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image">
								<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self">
								<img src="http://dummyimage.com/500/d5faef/000000&text=Api List" alt="" class="block" />
								</a>
							</div>
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self" class="overlay"></a>
							<span class="quick-look-icon cursor-pointer tip-t-fade" data-tooltip="Quick Look"><a href="#" target="_self" class="quick-look" data-quick-look-handle="cropped-brown-leather-jacket"><i class="fa fa-search fa-fw"></i></a></span>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self"><strong>Api</strong></a>
						</p>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center even last loop-first animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image">
								<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self">
								<img src="http://dummyimage.com/500/d5faef/000000&text=GitHub" alt="" class="block" />
								</a>
							</div>
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self" class="overlay"></a>
							<span class="quick-look-icon cursor-pointer tip-t-fade" data-tooltip="Quick Look"><a href="#" target="_self" class="quick-look" data-quick-look-handle="cropped-brown-leather-jacket"><i class="fa fa-search fa-fw"></i></a></span>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self"><strong>On GitHub</strong></a>
						</p>
					</div>
				</div>
			</div>
		</section>	
	</body>
</html>
