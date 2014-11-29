<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
							<h2 class="bm-remove">
								JsTree 개요
							</h2>
							<p class="bm-remove">
								<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
								&nbsp;/&nbsp;
								Overview
								&nbsp;/&nbsp;
								<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeApply.do" target="_self">Apply</a>
								&nbsp;/&nbsp;
								<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeConcept.do" target="_self">Concept</a>
								&nbsp;/&nbsp;
								<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeSupport.do" target="_self">Support</a>
								&nbsp;/&nbsp;
								<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeResult.do" target="_self">Result</a>
								&nbsp;/&nbsp;
								<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeIntegration.do" target="_self">Integration</a>
								&nbsp;/&nbsp;
								<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeImprovement.do" target="_self">Improvement</a>
								&nbsp;/&nbsp;
								<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeLicense.do" target="_self">License</a>
								&nbsp;/&nbsp;
								<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeSpringDemo.do" target="_self">Spring Demo</a>
								&nbsp;/&nbsp;
								<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeStrutsDemo.do" target="_self">Struts Demo</a>
							</p>					
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
										<img src="/images/community/jsTreeAlg/jsTreeOverView/RJCO-Cost-Timeliness-Quality-1v12-500w.jpg" alt="" />
									</div>
									<div class="space-20"></div>
									<h4>(연구필요성) 개발 생산성 vs 비즈니스 적시성</h4>
									<p><a href="http://jstree.com" target="_blank" title="새창">JsTree</a>는 해외에서 활발히 연구되고 있는 OpenSource 프로젝트입니다. 특히 UI 연구가 빠르게 전개되고 있으며 ( jQuery Script 기반 ), BackEnd Logic은 PHP로 구성돼 있습니다.<p>
									<p>우리 313 개발자 그룹은 JsTree에 관하여 스터디를 진행하면서 BackEnd Logic 의 다음과 같은 문제점을 발견하였습니다.
										<ul>
											<li>수 회의 move와 copy &amp; paste 후의 데이터 무결성 위배</li>
											<li>PHP언어의 코드 확장 한계성</li>
											<li>재활용성(Reusability) 결여</li>
										</ul>
										따라서 우리는 이를 java 언어로 converting 했으며, 이 문제들을 모두 해결했습니다.
									</p>
									<p>로직 및 구조의 변경으로 인하여 우리는 JsTree가 단순히 활용성 있는 plugin 이 아닌 컴포넌트 모듈로 확장및 코드를 활용하다 보니, <strong>하나의 스키마 안에서 데이터 집합간의 구조적 관계</strong>에 집중하기 시작했습니다. </p>
									<p>이는 우리의 Logic을 알고리즘으로 변경하게되는 중요한 계기가 되었고, 우리는 한번 더 코드를 변경하였습니다. 이제 우리는 알고 있습니다. jsTree 알고리즘 모듈을 사용하면, 매우 쉽게 코드를 생산할 수 있고, 매우 쉽게 집중된 성능 관리와, 향상된 개발 품질을 얻을 수 있다는것을 알게되었습니다. 일관된 설계 구조를 가질 수 있고, 확장에 편한 BackEnd를 구현해 낼 수 있었습니다.</p>
									<p>우리는 이 개발 생산성을 통하여, 비지니스의 적시성을 보장 할 수 있었습니다. 아주 짧은 시간에 ( 자동화된 개발 환경과, 자동화된 개발 코드 생산이 가능하였습니다 ) 비지니스 코드를 생산할 수 있는 기법을 연구하게 되었고, 우리는 이로 인하여, 시기 적절한 비지니스 시스템을 구축하여 배포할 수 있음을 증명하기 시작했습니다.</p>
									<p>우리는 가장 빠르게 그리고 효율적이며, 확장 가능한 시스템임을 증명하기 위하여, 현재 <strong>java version</strong>의 설치형 게시판을 개발하고 있습니다.</p>
									<p>우리는 우리의 JsTree가 아주 유연한 플랫폼 모듈임을 증명하기 위하여, 행정안전부의 egovFramework와 연계하고 있으며, spring version 3, 4 그리고 struts version 까지 구현하였습니다.</p>
									<p>우리의 열정과 알고리즘 모듈은 은 비지니스의 적시성을 요하는 global 산업 전체에서 사용가능합니다.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</body>
</html>
