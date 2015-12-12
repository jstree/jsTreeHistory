<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head>
		<style type="text/css">
			p strong {
				font-size: 11pt;
			}			
		</style>
 
	</head>
	<body>
	<main id="template-index-liquid" class="clearfix" role="main">
	
	<div class="container">
		<div class="one-whole bm-larger">
				<div id="index-image-slider-container" class="clearfix">
					<div id="index-image-slider" class="owl-carousel owl-theme">
						<%-- 
						<div class="item">
							<img
								src="http://www.313.co.kr:5002/Component/jsp/community/index/slideImage/first.jpg"
								alt="Slide One" />
						</div>
						 --%>
						<div class="item">
							<img
								src="http://www.313.co.kr:5002/Component/jsp/community/index/slideImage/sec.jpg"
								alt="Slide Two" />
						</div>
						<div class="item">
							<img
								src="http://www.313.co.kr:5002/Component/jsp/community/index/slideImage/three.jpg"
								alt="Slide Three" />
						</div>
						<div class="item">
							<img
								src="http://www.313.co.kr:5002/Component/jsp/community/index/slideImage/four.jpg"
								alt="Slide Four" />
						</div>
						<div class="item">
							<img
								src="http://www.313.co.kr:5002/Component/jsp/community/index/slideImage/five.jpg"
								alt="Slide Five" />
						</div>
					</div>
					
					<div class="prev tip-t-fade" data-tooltip="Previous"></div>
					<div class="next tip-t-fade" data-tooltip="Next"></div>
				
				</div>
			</div>

			</div>
			<div class="container">
				<div class="one-whole clearfix" data-anim-type="fade-in" data-anim-delay="fade-in">
					
					<div class="one-whole boxed p-twenty">
						
							<h1 class="bm-small text-center">우리의 사명</h1>

							<div class="rte">
							<p style="text-align: center;">
								일관되고, 정형화된 JsTree: Service Framework Engine을 제공하여 개발 방식을 단순하게 유지할 수 있게 돕습니다. <br>
								또한, 비기능적 요구사항과 기능적 요구사항을 하나의 포인트에서 구현할 수 있게 확장 포인트를 제공하여 <br>
								보다 일관되고, 유지보수성을 줄이고, Safety 와 Performance를 제공하여 빠르게 개발을 이어갈 수 있는 방법을 제시합니다.<br>
								프로젝트의 표준을 제시하고, 전자정부 프레임워크와 AnyFramework를 포괄하는 아키텍쳐에 <br>
								Struts, Spring, iBatis, Hibernate 등의 레거시부터 최신화된 기술을 탑재하여 지속적으로 확장하는 Core Engine을 제공합니다.<br> 
							</p>
								
							</div>
						
					</div>
				</div>
			</div> 
		<!-- 2015-07-08 : 수정 -->
		<section class="clearfix" >
			<div class="container">
				<div class="one-whole">
					<div class="part-4">
						<div class="one-quarter product-item boxed p-ten text-center odd loop-first animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
							<div class="image-and-overlay-container bm-small">
								<div class="image">
									<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self">
									<img src="http://dummyimage.com/400/ffffff/f45a4f.png&text= We" alt=""  />
									</a>
								</div>
								<a href="${pageContext.request.contextPath}/aboutUs/committer.do" target="_self" class="overlay"></a>
								<span class="quick-look-icon cursor-pointer tip-t-fade" data-tooltip="Quick Look"><a href="#" target="_self" class="quick-look" data-quick-look-handle="cropped-brown-leather-jacket"><i class="fa fa-search fa-fw"></i></a></span>
							</div>
							<p class="bm-remove">
								<a href="${pageContext.request.contextPath}/aboutUs/committer.do" target="_self"><strong>Member</strong></a><br />
								2010년, 더 좋은 개발자가 되고싶은 사람들이 Java 스터디에 모였습니다. 그리고 생각을 나누며 같은 꿈을 꾸기 시작하였습니다.
							</p>
						</div>
					</div>
					<div class="part-4">
						<div class="one-quarter product-item boxed p-ten text-center even loop-first animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
							<div class="image-and-overlay-container bm-small">
								<div class="image">
									<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self">
									<img src="http://dummyimage.com/500/ffffff/f45a4f.png&text=Develop" alt=""  />
									</a>
								</div>
								<a href="${pageContext.request.contextPath}/devTool/313DevALMCI.do" target="_self" class="overlay"></a>
								<span class="quick-look-icon cursor-pointer tip-t-fade" data-tooltip="Quick Look"><a href="#" target="_self" class="quick-look" data-quick-look-handle="cropped-brown-leather-jacket"><i class="fa fa-search fa-fw"></i></a></span>
							</div>
							<p class="bm-remove">
								<a href="${pageContext.request.contextPath}/devTool/313DevALMCI.do" target="_self"><strong>Environment</strong></a><br />
								우리는 ALM, CI에 대한 고민을 지속적으로 해왔습니다. 최적의 프로세스와 자동화된 산출물, 개발환경 ~ 빌드에서 배포까지의 시스템을 구축하였습니다.
							</p>
						</div>
					</div>
					<div class="part-4">
						<div class="one-quarter product-item boxed p-ten text-center odd loop-first  animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
							<div class="image-and-overlay-container bm-small">
								<div class="image">
									<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeOverView.do" target="_self">
									<img src="http://dummyimage.com/500/ffffff/f45a4f.png&text= New" alt=""  />
									</a>
								</div>
								<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self" class="overlay"></a>
								<span class="quick-look-icon cursor-pointer tip-t-fade" data-tooltip="Quick Look"><a href="#" target="_self" class="quick-look" data-quick-look-handle="cropped-brown-leather-jacket"><i class="fa fa-search fa-fw"></i></a></span>
							</div>
							<p class="bm-remove">
								<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeOverView.do" target="_self"><strong>JsTree</strong></a><br />
								JsTree: Service Framework Engine '단일 아키텍쳐 프레임워크 엔진이 제공하는 누적되는 기능, 비기능 Function의 확장, 단시간에 개발이 가능한 방법'
							</p>
						</div>
					</div>
					<div class="part-4">
						<div class="one-quarter product-item boxed p-ten text-center even last loop-first animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
							<div class="image-and-overlay-container bm-small">
								<div class="image">
									<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self">
									<img src="http://dummyimage.com/500/ffffff/f45a4f.png&text=Think" alt=""  />
									</a>
								</div>
								<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self" class="overlay"></a>
								<span class="quick-look-icon cursor-pointer tip-t-fade" data-tooltip="Quick Look"><a href="#" target="_self" class="quick-look" data-quick-look-handle="cropped-brown-leather-jacket"><i class="fa fa-search fa-fw"></i></a></span>
							</div>
							<p class="bm-remove">
								<a href="${pageContext.request.contextPath}/baroBoard/baroBoardOverView.do" target="_self"><strong>BaroBoard</strong></a><br />
								이제 우리는 모든 준비를 마치고 Service Framework Engine을 통해 이세상의 유일한 OpenSource Java Version 설치형 게시판을 배포합니다.
							</p>
						</div>
					</div>
				</div>
			</div>
		</section>
		</main>
			
		<script>
			$(document).ready(
					function() {
						var $indexSlider = $('#index-image-slider');
						$indexSlider.owlCarousel({
							transitionStyle : 'fadeUp',
							autoPlay : 5000,
							paginationSpeed : 500,
							singleItem : true,
							stopOnHover : true
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
		
	</body>
</html>
