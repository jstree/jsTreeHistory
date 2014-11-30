<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head>
		<style type="text/css">
			html {
			margin-top: 40px;
			}
			body {
			position: relative;
			}
			
			table {width:100%; border-top:3px solid #ccc; border-collapse:collapse}
            caption {margin:1% 0 0.5%}
            th, td {border:1px solid #ccc}
            th {padding:1% 0.5%; background:#fafafa; font-weight:bold}
            td {padding:0.5% 2%;}
		</style>	
	</head>
	<body>
		<section class="clearfix" >
			<nav>
				<div class="container bm-medium">
					<div class="one-whole">
						<div class="no-display">article</div>
						<div class="text-center">
							<h1 class="bm-remove">
								바로보드란?
							</h1>
							<p class="bm-remove">
								<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
								&nbsp;/&nbsp;
								Jstree
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
								<h4>바로보드 개발배경 및 목적</h4>
								<p>인터넷을 통한 온라인 매매 시장이 오프라인의 그것을 대체하는 비중이 높아지게 되면서 게시판 기능을 바탕으로 한 온라인 상거래 쇼핑몰 구축의 필요성이 제시되었고, 이러한 쇼핑몰을 쉽고 빠르게 구축할 수 있는 솔루션에 대한 요구가 지속되어 왔습니다. 기존에는 제로보드, 그누보드 등 PHP를 기반으로 한 게시판 솔루션이 이러한 기능을 제공하였으나, 보안 및 확장성 등에 대한 문제점을 가지고 있어 이를 보완할 수 있는 차세대 솔루션의 필요가 대두되고 있습니다. 이에  우리는 전자정부 표준프레임워크를 기본 바탕으로 하는 Java 기반의 게시판 솔루션인 바로보드를 개발하여 기존 솔루션의 단점을 보완하고 뛰어난 확장성을 가지는 차세대 버전의 게시판 솔루션을 제공하고자 합니다.</p>
								<p>※ 바로보드는 전자정부 표준프레임워크를 기반으로 개발되기 때문에 바로보드 고유 기능 뿐만 아니라 엄선된 표준프레임워크의 기능도 제공됩니다.</p>
								
								<h4>바로보드 특징</h4>
								<p>본 솔루션은 아래 서비스를 제공한다.</p>
								<ol>
								    <li>설치 기반의 게시판 솔루션</li>
								    <li>기존 PHP 게시판 솔루션 기능 제공 (회원 관리, 게시판 관리, 부가기능 관리 등)</li>
								    <li>Spring Security 기반의 안정적인 보안기능 제공</li>
								    <li>Java 컴포넌트 기반의 플러그인 확장 기능 제공</li>
								</ol>
								
								<h4>바로보드 기능 요약</h4>
								<ol>
								    <li>회원 관리 : 회원, 회원 그룹, 회원 설정, 회원 포인트 등</li>
								    <li>메뉴 관리 : 사이트 맵, 사이트 레이아웃 등</li>
								    <li>게시판 관리 : 게시판, 게시판 그룹, 게시물 등</li>
								    <li>부가기능 관리 : 알림 시스템, 이미지 관리, 텍스트 에디터, i-PIN 인증, 플러그인, 통계 리포트 등</li>
								    <li>관리자 설정 : 기본환경 설정, 관리자 및 고급 설정 등</li>
								</ol>
								
								<h4>바로보드 개발 언어</h4>
								<ul>
								    <li>HTML + CSS : 웹 기반 주문 서비스 제공을 위한 GUI 및 서비스 화면 구성</li>
								    <li>JavaScript : RIA 형태의 고급 사용자 인터페이스 제공 및 인터렉션 처리</li>
								    <li>Java : 게시판 기본 기능 및 확장 기능 구현. 보안, 로깅 등 시스템 부가 기능 제공</li>
								</ul>
								
								<h4>바로보드 지원 DBMS</h4>
								<ul>
								    <li>Oracle</li>
								    <li>MySQL</li>
								    <li>Cubrid</li>
								    <li>Altibase</li>
								</ul>
								
								<h4>바로보드 적용 가능 시스템 조건</h4>
								<p>아래 세가지 조건을 모두 만족하는 경우 적용 가능</p>
								<ol>
								  <li>자바 기반의 웹 응용 시스템(WAS가 존재하는 경우)</li>
								  <li>JavaEE(J2EE) 7 혹은 JDK1.7 이상의 환경</li>
								  <li>신규 개발 시스템으로써, 기존 시스템과 물리적 혹은 논리적으로 구분되는 경우</li>
								</ol>
								<p>☞ 표준프레임워크 실행환경 내 모바일 표준프레임워크의 사용자 경험(UX) 지원 기능은 프레임워크와 개발 언어 종류에 상관없이 활용가능 (javascript 기반)</p>
								   
								<h4>전자정부 표준프레임워크 등장배경 및 목적</h4>
								<p>표준프레임워크는 정보시스템 개발을 위해 필요한 기능 및 아키텍처를 미리 만들어 제공함으로써 효율적인 어플리케이션 구축을 지원합니다. “전자정부 표준프레임워크”는 공공사업에 적용되는 개발프레임워크의 표준정립으로 응용 SW 표준화, 품질 및 재사용성 향상을 목표로 합니다. 이를 통해“전자정부 서비스의 품질향상”및“정보화 투자 효율성 향상”을 달성하고 대ㆍ중소기업이 동일한 개발기반 위에서 공정경쟁이 가능하게 됩니다.</p>
								<p>※ 표준프레임워크는 기존 다양한 플랫폼(.NET, php 등) 환경을 대체하기 위한 표준은 아니며, java 기반의 정보시스템 구축에 활용하실 수 있는 개발·운영 표준환경을 제공하기 위한 것입니다.</p>
								 
								<h4>전자정부 표준프레임워크 특징</h4>
								<ul>
									<li><strong>개방형 표준 준수 </strong><p>오픈소스 기반의 범용화되고 공개된 기술의 활용으로 특정 사업자에 대한 종속성 배제</p></li>
									<li><strong>상용 솔루션 연계 </strong><p>상용 솔루션과 연계가 가능한 표준을 제시하여 상호운용성 보장</p></li>
									<li><strong>국가적 표준화 지향 </strong><p>민.관.학계로 구성된 자문협의회를 통해 국가적 차원의 표준화 수행</p></li>
									<li><strong>변화 유연성 </strong><p>각 서비스의 모듈화로 교체가 용이하며 인터페이스 기반 연동으로 모듈간 변경영향 최소화</p></li>
									<li><strong>모바일 환경 지원 </strong><p>모바일 환경을 위한 모바일 웹(UX/UI) 및 하이브리드 앱 지원</p></li>
									<li><strong>편리하고 다양한 환경제공 </strong><p>Eclipse 기반의 모델링(UML,ERD), 에디팅, 컴파일링, 디버깅 환경 제공</p></li>
								</ul>
								
								<h4>전자정부 표준프레임워크 적용 효과</h4>
								<p>정보시스템을 개발하거나 운영할 때 필요한 기본 기능을 미리 구현한 것으로 이를 기반으로 추가 기능을 개발하여 조립함으로써 전체 정보시스템을 완성할 수 있습니다.</p>
								<div class="div_center">
									<a href="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/baro/img/module.jpg" data-lightbox="image-1">
										<img src="http://nas.313.co.kr:5002/Component/thymeleaf/community/introduce/baro/img/module.jpg" alt="건축/건분에서 골조에 해당되는 표준프레임워크 기반 위에 전등, 창문, 손잡이와 같은 표준화된 부분의 컴포넌트(예: 민원발급, 게시판, 공인인증 등)에 추가함으로써 행정민원시스템을 구축함" />
									</a>
									<p>※ 건설/건축분야에서 핵심자재를 모듈화하여 비용 및 공사기간을 단축하는 기법과 유사</p>
								</div>
								
								<table summary="표준프레임워크 적용 전과 표준프레임워크 적용 후의 비교표 입니다">
									<caption>『표준프레임워크 적용 전/후 비교표』</caption>
									<colgroup>
										<col style="width:50%"/>
										<col style="width:50%"/>
									</colgroup>
									<thead>
										<tr>
											<th>표준프레임워크 적용 전</th>
											<th>표준프레임워크 적용 후</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>정보화사업별 동일한 기능들의 중복 개발</td>
											<td>공통컴포넌트 재사용으로 중복 예산 절감</td>
										</tr>
										<tr>
											<td>기술 종속으로 인해 선행사업자 의존도 높음</td>
											<td>표준화된 개발기반으로 사업자 종속성 해소</td>
										</tr>
										<tr>
											<td>프레임워크 미 보유업체는 경쟁 불리</td>
											<td>프레임워크 무상제공으로 중소기업 경쟁력 향상</td>
										</tr>
										<tr>
											<td>정보시스템간 상호 연계 시 많은 기간과 인력이 소요</td>
											<td>표준화된 연계모듈 활용으로 상호운용성 향상</td>
										</tr>
										<tr>
											<td>개발표준 미흡으로 유지보수가 어려움</td>
											<td>개발표준에 의한 모듈화로 유지보수가 용이</td>
										</tr>
									</tbody>	
								</table>
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</body>
</html>
