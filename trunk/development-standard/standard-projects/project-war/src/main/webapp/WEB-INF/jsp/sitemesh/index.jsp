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
	</body>
</html>