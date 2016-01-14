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
								Baro Board
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
								<p>
								인터넷을 통한 온라인 매매 시장이 오프라인의 그것을 대체하는 비중이 높아지게 되면서	<br/>							
								게시판 기능을 바탕으로 한 온라인 상거래 쇼핑몰 구축의 필요성이 제시되었고,			<br/>					
								이러한 쇼핑몰을 쉽고 빠르게 구축할 수 있는 솔루션에 대한 요구가 지속되어 왔습니다.	<br/>
								기존에는 제로보드, 그누보드 등 PHP를 기반으로 한 게시판 솔루션이 이러한 기능을 제공하였으나, <br/>
								보안 및 확장성 등에 대한 문제점을 가지고 있어 이를 보완할 수 있는 차세대 솔루션의 필요성이 대두되고 있습니다. <br/>
								이에 우리는 전자정부 표준프레임워크를 기본 바탕으로 하는 Java 기반의 게시판 솔루션인 바로보드를 개발하여 <br/>
								기존 솔루션의 단점을 보완하고 뛰어난 확장성을 가지는 차세대 버전의 게시판 솔루션을 제공하고자 합니다. <br/>
								</p>
								<p>※ 바로보드는 전자정부 표준프레임워크를 기반으로 개발되기 때문에 자체 스펙 뿐만 아니라 엄선된 표준프레임워크의 기능도 제공됩니다.</p>
								
								<h4>바로보드 특징</h4>
								<p>본 솔루션은 아래 서비스를 제공한다.</p>
								<ol>
								    <li>게시판 솔루션 기능 제공 (회원 관리, 게시판 관리, 부가기능 관리 등)</li>
								    <li>설치 기반의 게시판 솔루션</li>
								    <li>Spring Security 기반의 안정적인 보안기능 제공</li>
								    <li>Java 컴포넌트 기반의 플러그인 확장 기능 제공</li>
								</ol>
								
								<h4>바로보드 적용 가능 시스템 조건</h4>
								<p>아래 네가지 조건을 모두 만족하는 경우 적용 가능</p>
								<ol>
								  <li>자바 기반의 웹 응용 시스템(WAS가 존재하는 경우)</li>
								  <li>JavaEE(J2EE) 7 혹은 JDK1.7 이상의 환경</li>
								  <li>서버 내 DBMS가 Oracle, MySQL, Cubrid, Altibase 중 1개 이상 설치된 환경</li>
								  <li>신규 개발 시스템으로써, 기존 시스템과 물리적 혹은 논리적으로 구분되는 경우</li>
								</ol>
								<p>☞ 표준프레임워크 실행환경 내 모바일 표준프레임워크의 사용자 경험(UX) 지원 기능은 프레임워크와 개발 언어 종류에 상관없이 활용가능 (javascript 기반)</p>
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</body>
</html>
