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
								Continuous Integration
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
								<h4>CI(Continuous Integration) 란?</h4>
								<p>개발자가 각각 개발한 소스코드를 모아서 한꺼번에 빌드하는 통합 빌드의 과정을 특정 시점이 아니라 매일이나 매주와 같이 아주 잦은 주기로 수행함으로써 통합에서 발생하는 오류와 시간을 줄이기 위한 기법이다.</p>
								<p>Extreme Programming Community (XP)에서 애자일 방법론의 일부로 Kent Beck에 의해서 고안된 방법으로 다음과 같은 특징을 가지고 있다.</p>
								
								<h4>(1) 소스코드 일관성 유지</h4>
								<p>313은 Subversion사용한다. </p>
								<ol>
								    <li>CI툴을 설정하기 위해서는 기본적으로 소스 관리 시스템이 필요하다.</li>
								    <li>대표적인 소스 관리 시스템은 Subversion,CVS,Perforce등이 있다.</li>
								    <li>CI툴은 이 소스 관리 시스템으로부터 프로젝트 소스의 메인 브랜치(trunk 라고도 한다.) 코드를 Check out 받아서 빌드를 수행한다.</li>
								</ol>
								<h4>(2) 자동 빌드</h4>
								<p>소스 코드에 대한 빌드는 CI툴에 의해서 자동적으로 이루어 져야 한다.  </p>
								<p>빌드가 이루어지는 시점을 정하는 방법이 두가지가 있는데 다음과 같다. </p>
								<p>1) 커밋에 따른 자동 빌드 </p>
								<ol>
								    <li>다른 방법으로는 소스코드가 소스 관리 시스템에 커밋이 되었을 때 마다 CI툴이 이를 감지 하고 자동으로 빌드를 수행하도록 설정할 수 있다.</li>
								    <li>이렇게 설정할 경우 소스 코드의 변경이 있을 때 마다 빌드 작업을 수행하기 때문에 소스 관리 시스템에 저장된 소스 코드에 대한 무결성을 보장하기는 매우 좋지만, 빌드 시간이 길 경우 빌드가 적체 되는 현상이 발생할 수 있다.</li>
								    <li>(일반적으로 대규모 애플리케이션의 FULL 빌드는 길게는 2~3시간 까지 소요될 수 있다.) 그래서 이 방법은 빌드 시간이 오래 걸리는 경우나 커밋이 자주 발생하는 경우에는 적절하지 않다.</li>
								</ol>
								<p>2) 시간 간격에 의한 빌드 </p>
								<ol>
									<li>일정 시간 간격을 정해서 빌드를 하는 방법이다. 매일 5시에 빌드를 한다. 또는 매주 금요일 저녁 5시에 빌드를 한다는 것과 같이 주기를 정할 수 있다. </li>
									<li>빌드 스케쥴이 미리 정해져있기 때문에 개발자들이 커밋에 대한 스케쥴을 관리할 수 있고 빌드 시간이 오래걸리는 대규모 빌드에도 적정하다.</li>
									<li>빌드가 깨진 경우는 컴파일이 실패하였거나 테스트가 통과하지 못하였을 경우인데 이때 소스 관리 시스템에 저장된 코드는 문제가 있는 코드이다.</li>
									<li>CI툴에서는 소스 관리 시스템으로부터 소스를 체크아웃 또는 업데이트 받을 때 Silent Period라는 옵션을 제공한다.</li>
									<li>개발자가 소스를 커밋하고 있을 때 커밋이 완료되지 않은 상태에서 CI툴이 소스를 체크아웃하게 되면 불완전한 코드가 내려와서 빌드가 망가질 수 있다.</li>
									<li>이를 방지하는 옵션이 Silent Period인데, 커밋이 있은후 일정 시간동안 소스 관리 시스템에 변화가 없을 때 CI툴이 체크아웃을 받아서 불완전한 코드를 내려 받을 수 있는 가능성을 최소화 하는 것이다.</li>
									<li>이렇게 자동 빌드를 하면서 얻을 수 있는 이점은, 주기적인 빌드를 통해서 소스코드의 무결성 관리와 빅뱅방식의 통합에서 올 수 있는 리스크를 개발과정 전반으로 분산할 수 있다.</li>
								</ol>									
								<h4>(3) 자동 테스팅</h4>
								<p>빌드 과정에서 테스트를 포함할 수 있는데, 주기적인 빌드 과정에 테스트를 포함해서 자동 빌드를 통한 Syntax에 대한 검증과 더불어 테스팅을 통한 기능과 비기능적(성능등)에 대한 요건을 매번 검증함으로써 코드의 품질에 대한 무결성을 함께 유지한다.</p>
																	
								<h4>CI 프로세스</h4>
								<div class="div_center">
									<a href="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/dev/img/continuous-integration-img.jpg" data-lightbox="image-1">
										<img src="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/dev/img/continuous-integration-img.jpg" alt="Continuous Integration" />
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</body>
</html>
