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
								JsTree
								&nbsp;/&nbsp;
								Overview
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
										<img src="/assets/images/community/jsTreeAlg/jsTreeOverView/RJCO-Cost-Timeliness-Quality-1v12-500w.jpg" alt="" />
									</div>
									<div class="space-20"></div>
									<h4>(연구 필요성) 개발 생산성 vs 비즈니스 적시성</h4>
									<p>JsTree는 jQuery PlugIn 형태의 Library로 <br />
										상호 작용하는 트리 형태의 UI를 쉽게 구현할 수 있게 해주는 OpenSource 입니다.<p>
									<p>저희는 JsTree에 관하여 스터디를 진행하면서 다음과 같은 문제점을 발견하였습니다.
										<ul>
											<li>수 회의 Node 이동와 Copy & Paste 후의 데이터 무결성 위배</li>
											<li>PHP의 코드 확장(Extension) 및 재활용성(Reusability) 결여</li>
										</ul>
										그래서 저희는 PHP로 구현된 부분을 Java로 전환하는 작업을 진행 하였습니다.
									</p>
									<p>그리고 JsTree를 단순한 PlugIn 이 아닌 컴포넌트 모듈로 확장하기 위해,
										<strong>하나의 스키마 안에서 데이터 집합간의 구조적 관계</strong>에 집중하기 시작하였으며,
										이는 기존 로직을 알고리즘 형태로 변경하게되는 중요한 계기가 되었습니다.
									</p>
									<p>이로 인하여 매우 쉽게 코드를 생산할 수 있고, 집중된 성능 관리, 향상된 개발 품질 등
										다양한 장점을 추가로 얻을 수 있다는 것을 알게 되었습니다. 
									</p>
									<p>지금 저희는 이것을 직접 보여드리고자 기존과 다른 무언가에 도전하고 있습니다.</p>
									<p>JsTree가 앞으로 IT 시장에서 어떠한 변화를 가지고 오게 될지 많은 관심 부탁드립니다.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</body>
</html>
