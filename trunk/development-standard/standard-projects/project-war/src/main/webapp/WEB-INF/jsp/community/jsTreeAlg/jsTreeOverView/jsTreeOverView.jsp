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
							<h2 class="bm-remove">
								JsTree 개요
							</h2>
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
										<img src="http://placehold.it/599x599" alt="" />
									</div>
									<div class="space-20"></div>
									<h3>(연구필요성) 개발 생산성 vs 비즈니스 적시성</h3>
									<p><a href="http://jstree.com" target="_blank" title="새창">JsTree</a>는 해외에서 활발히 연구되고 있는 OpenSource 프로젝트입니다. 특히 UI쪽 연구가 빠르게 전개되고 있으며 ( jQuery Script 기반 ), BackEnd Logic은 PHP로 구성되 있습니다.<p>
									<p>우리 313 개발자 그룹은 이 BackEnd Logic 의 문제점을 확인했으며, ( 여러번의 move와 copy &amp; paste 후의 데이터 무결성 문제와 PHP의 코드 확장 문제, 그리고 재 활용성에 대한 ) 따라서 우리는 이를 java 언어로 converting 했으며, 이 문제들을 모두 해결했습니다.</p>
									<p>로직의 변경과 구조의 변경으로 인하여, 우린 jstree가 단순히 활용성이 있는 plugin 이 아니라 컴포넌트 모듈로 변모 그리고 인식되기 시작하였으며, 확장및 코드를 활용하다보니, <strong>하나의 스키마 안에서 데이터 집합간의 구조적 관계</strong>에 집중하기 시작했습니다. </p>
									<p>이는 우리의 Logic을 알고리즘으로 변경하게되는 중요한 계기가 되었고, 우리는 한번 더 코드를 변경하였습니다. 이제 우리는 알고 있습니다. jsTree 알고리즘 모듈을 사용하면, 매우 쉽게 코드를 생산할 수 있고, 매우 쉽게 집중된 성능 관리와, 향상된 개발 품질을 얻을 수 있다는것을 알게되었습니다. 일관된 설계 구조를 가질 수 있고, 확장에 편한 BackEnd를 구현해 낼 수 있었습니다.</p>
									<p>우리는 이 개발 생산성을 통하여, 비지니스의 적시성을 보장 할 수 있었습니다. 아주 짧은 시간에 ( 자동화된 개발 환경과, 자동화된 개발 코드 생산이 가능하였습니다 ) 비지니스 코드를 생산할 수 있는 기법을 연구하게 되었고, 우리는 이로 인하여, 시기 적절한 비지니스 시스템을 구축하여 배포할 수 있음을 증명하기 시작했습니다.</p>
									<p>우리는 가장 빠르게 그리고 효율적이며, 확장 가능한 시스템임을 증명하기 위하여, 현재 <strong>java version</strong>의 설치형 게시판을 개발하고 있습니다.</p>
									<p>우리는 우리의 JsTree가 아주 유연한 플랫폼 모듈임을 증명하기 위하여, 행정안전부의 egovFramework와 연계하고 있으며, spring version 3, 4 그리고 struts version 까지 구현하였습니다.</p>
									<p>우리의 열정과 알고리즘 모듈은 은 비지니스의 적시성을 요하는 global 산업 전체에서 사용가능합니다.</p>
									<!-- 
									<div class="space-40"></div>
									<h3>데이터 구성 항목</h3>
									<table summary="이벤트 명, 설명, 처리 클래스/뷰 로 구성된 데이터 구성 항목">
										<caption class="v-hidden">데이터 구성 항목</caption>
										<thead>
											<tr>
												<th>이벤트 명</th>
												<th>설명</th>
												<th>처리 클래스/뷰</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>클릭</td>
												<td>접속을 요청한다.</td>
												<td><a href="http://www.jstree.com" target="_blank" title="새창">http://www.jstree.com</a></td>
											</tr>
										</tbody>
									</table>
									 -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</body>
</html>
