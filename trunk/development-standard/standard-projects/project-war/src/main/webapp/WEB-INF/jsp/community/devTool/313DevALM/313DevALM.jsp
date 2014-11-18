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
								Application Lifecycle Management 
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
								<h4>ALM(Application Lifecycle Management ) 이란?</h4>
								<p>애플리케이션 소프트웨어를 개발 운용하는데 있어서, 라이프사이클 전체를 종합적으로 관리하는 것으로 소프트웨어의 품질, 개발생산성, 변화의 대응력 등을 향상시키기 위한 것, 혹은 그를 위한 소프트웨어 플랫폼 툴을 말한다. </p>
								<p>기존의 애플리케이션 개발은 기술적인 관점에서 많이 접근이 되어 왔으나, 비즈니스 요건 관리 부분과 실제 소프트웨어 개발 프로세스를 융합하고 이에 대한 관리를 자동화된 툴을 이용하도록 하는 것이 ALM의 개념이며, 이 부분에는 요구 사항 관리, 아키텍쳐, 코딩, 테스팅, 그리고 이슈 추적과 릴리즈 관리등을 포함한다. </p>
								
								<h4>ALM 도입 배경</h4>
								<p>기존에 소프트웨어 개발 프로세스는 요구 사항 관리에 대한 문서나 시스템, 아키텍쳐나 디자인에 대한 Case tool과 산출물, 코드 관리, 일정 관리 등등이 각기 다른 제품과 다른 프로세스 다른 템플릿으로 구현이 되어 왔고 이로 인해서 소프트웨어 개발 과정에 대한 개념이 실제로 구현되었을때는 단계별로 추적성과 실용성이 떨어졌다.</p>
								<p>ALM의 의미는 이런 현실과 괴리된 부분을 좀더 통합되고 현실적으로 전문화된 도구를 이용하여 현실화 시키고 궁극적으로 소프트웨어 개발 프로세스를 개선하는데 목적을 두고 있다고 말할 수 있다.</p>
								<p>ALM이 실제 커버하는 범위를 보면 아래 그림과 같이 요구사항 관리에서부터 프로젝트 관리, 릴리즈 관리까지 소프트웨어 개발의 거의 전 영역을 커버하는 것을 볼 수 있다.</p>
								<div class="div_center">
									<a href="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/dev/img/Diagram_JPP.jpg" data-lightbox="image-1">
										<img src="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/dev/img/Diagram_JPP.jpg" alt="Application Lifecycle Management" />
									</a>
								</div>
								
								<h4>ALM이 가져야 할 최소한의 요건</h4>
								<p>요구 사항 관리, 프로젝트 스케쥴 관리를 위한 Task 관리, 빌드 환경 자동화 및 형상 관리, 테스트 자동화 부분이 핵심이다.</p>
								<p>그외에 Deployment의 경우 주로 운영 (SM : System Management) 조직이 담당하며, Design이나 아키텍쳐링의 경우 ALM 사상내에 포함되는 것이 이론적으로는 맞지만, 사실 Design의 경우 프로세스를 정형화 시키기 어려울뿐더러, 실제 프로젝트에서는 Design이 프로젝트가 진행되어감에 따라 변화하고 완성되어 가기 때문에,  Design을 포함시키는 것은 쉽지 않다. </p>
								<h4>문제점</h4>
								<p>ALM의 사상적인 출발은 툴을 이용한 소프트웨어 개발 사이클의 현실화인데, 시장에 있는 툴의 경우 그 성숙도가 매우 높아서 프로젝트에 적용하는데 상당한 경험과 지식을 필요로 한다. 실용적인면에서 생각했을 때 ALM의 적용 범위는 일반 말단 개발자 수준에 까지 적용이 되어야 하기 때문에 난이도가 높을때는 실제 프로젝트에 적용하기가 어려운 점이 많다.</p>
								<p>또한 ALM Company를 자칭 하는 많은 회사들이 ALM에 대한 Full set을 가지고 있지 않은 상태에서 마케팅적인 메시지로 Drive 하는 경우가 많아서 사용자의 혼란을 초래하고 있다.</p>
																	
								<h4>실용주의 ALM</h4>
								<p>실용주의 ALM은 이런 문제점을 바탕으로 좀더 실용적이고 실무적인 ALM을 개발하여 실무에 사용하고자 하는데 목적을 두고 있으며 아래와 같은 특징을 갖는다.</p>
								<ol>
									<li>주로 오픈소스나 저비용의 제품을 조합하여 ALM의 핵심 범위를 커버한다.</li>
									<li> Agile과 Kent Beck, Erich Gamma, Joel Spolsky 등에 의해서 주장되고 있는 실용주의 방법론 (Practical methodology)를 바탕으로 하여, 튼튼한 이론적인 바탕을 가지고 현실에 맞는 실용적인 프로세스를 구축한다.</li>
									<li>구현팀을 위주로 프로세스를 정의한다.</li>
									<li>품질 향상</li>
								</ol>
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</body>
</html>
