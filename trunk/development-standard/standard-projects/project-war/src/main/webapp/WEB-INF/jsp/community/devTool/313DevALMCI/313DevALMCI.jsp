<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head></head>
	<body>
		<section class="clearfix" >
			<nav>
				<div class="container bm-medium">
					<div class="one-whole">
						<div class="no-display">article</div>
						<div class="text-center">
							<h1 class="bm-remove">
								Application Lifecycle Management & Continueus Integration
							</h1>
						</div>
					</div>
				</div>
			</nav>
			<article>
				<div class="clearfix">
					<div class="container bm-remove">
						<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
							<div class="article-body rte" itemprop="articleBody">
								
								<div class="tablet-mobile alpha bm-remove last">
									<div class="one-half-percent tablet-mobile bm-remove omega alignleft">
										<a href="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/dev/img/Diagram_JPP.jpg" data-lightbox="image-1">
											<img src="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/dev/img/Diagram_JPP.jpg" alt="Application Lifecycle Management" />
										</a>
									</div>
									<div class="space-20"></div>
									<a href="#"><span>ALM(Application Lifecycle Management ) 이란?</span></a>
									<p>애플리케이션 소프트웨어를 개발 운용하는데 있어서, 라이프사이클 전체를 종합적으로 관리하는 것으로 소프트웨어의 품질, 개발생산성, 변화의 대응력 등을 향상시키기 위한 것이며, 혹은 그를 위한 소프트웨어 플랫폼 툴을 의미합니다.</p>
									<p>기존의 애플리케이션 개발은 기술적인 관점에서 많이 접근이 되어 왔으나, 비즈니스 요건 관리 부분과 실제 소프트웨어 개발 프로세스를 융합하고 이에 대한 관리를 자동화된 툴을 이용하도록 하는 것이 ALM의 개념이며, 이 부분에는 요구 사항 관리, 아키텍쳐, 코딩, 테스팅, 그리고 이슈 추적과 릴리즈 관리등 프로젝트의 모든 활동을 포함하게 됩니다.</p>
									<p>313 개발자 그룹의 커미터 전원은 해당 ALM(PMS)교육을 주기적으로 받고 있고, 필요에 따라서 지속적으로 확장하고 있습니다</p>
									<p>우리는 개발 자동화를 꿈꾸었고, 그 꿈의 인프라를 구축하여 현재 운용하고 있습니다. 다음은 그 희망의 증거입니다</p>
									
									<p>
										<a href="#"><span>(1) 산출물 관리 및 위키</span></a><a href="http://www.313.co.kr/confluence"><span> : Confluence</span></a><br/>
										<a href="#"><span>(2) 이슈 관리</span></a><a href="http://www.313.co.kr/jira"><span> : Jira</span></a><br/>		
										<a href="#"><span>(3) 리뷰</span></a><a href="http://www.313.co.kr/fecru"><span> : Fisheye & Cruclible</span></a><br/>
										<a href="#"><span>(4) 소스코드 일관성 유지</span></a><a href="http://www.313.co.kr/svnwebclient/"><span> : SvnWebClient</span></a><br/>
										<a href="#"><span>(5) 자동 빌드</span></a><a href="http://www.313.co.kr/php/www313cokr-maven-site/"><span> : Maven</span></a><br/>		
										<a href="#"><span>(6) 빌드</span></a><a href="http://www.313.co.kr/hudson"><span> : Hudson</span></a><a href="http://www.313.co.kr/jenkins"><span> : Jenkins</span></a><br/>
										<a href="#"><span>(7) 라이브러리 관리</span></a><a href="http://www.313.co.kr/nexus"><span> : Nexus</span></a><br/>				
										<a href="#"><span>(8) 빌드 통합 관리</span></a><a href="http://www.313.co.kr/bamboo"><span> : Bamboo</span></a><br/>
										<a href="#"><span>(9) 자동 테스팅</span></a><a href="http://www.313.co.kr/sonar/"><span> : Junit</span></a><br/>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</article>
			<article>
				<div class="clearfix">
					<div class="container bm-remove">
						<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
							<div class="article-body rte" itemprop="articleBody">
								
								<div class="tablet-mobile alpha bm-remove last">
									<div class="one-half-percent tablet-mobile bm-remove omega alignleft">
										<a href="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/dev/img/continuous-integration-img.jpg" data-lightbox="image-1">
											<img src="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/dev/img/continuous-integration-img.jpg" alt="Continuous Integration" />
										</a>
									</div>
									<div class="space-20"></div>
									<a href="#"><span>CI(Continuous Integration) 란?</span></a>
									<p>개발자가 각각 개발한 소스코드를 모아서 한꺼번에 빌드하는 통합 빌드의 과정을 특정 시점이 아니라 매일이나 매주와 같이 아주 잦은 주기로 수행함으로써 통합에서 발생하는 오류와 시간을 줄이기 위한 기법입니다.</p>
									<p>313 개발자 그룹은 표준 개발 방법론을 재정의 하며, Extreme Programming Community (XP)에서 애자일 방법론의 일부를 사용하고 있습니다. ( PMBOK, ISO-21500 준수 )</p>
									<p>또한 고객의 변화에 능동적으로 적응하기 위하여, 고객의 소리를 듣고자 자동 빌드, 자동 테스팅, 자동 배포까지 지원하고 있으며, 구축 구현하여 운영하고 있습니다.</p>
									<p>현재 보고 계시는 WebSite 역시 CI로 빌드된 결과물로 매일 새벽 3시에 재배포 되고 있습니다. ( 소스 코드 변조 원천 차단 )</p>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</body>
</html>
