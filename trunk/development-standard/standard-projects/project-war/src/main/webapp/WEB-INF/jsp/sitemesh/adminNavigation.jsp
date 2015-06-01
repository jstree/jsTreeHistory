<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<head></head>
<body>
	<nav>
		<div id="navigation" class="clearfix one-quarter">
			<!-- For Mobile Menu -->
			<div id="touch-nav">
				<div class="slide-menu">
					<ul class="nav unstyled bm-remove clearfix">
						<li class="nav-item  first active">
							<a href="#" target="_self" class="parent-link"> 대쉬보드</a>
						</li>
						<hr class="bm-smaller">
						<li class="nav-item  has-dropdown">
							<a href="#" target="_self" class="parent-link">
								샘플
								<span class="has-dropdown-icon float-right">+</span>
							</a>
							<ul class="sub-nav unstyled bm-remove">
								<li class="sub-nav-item">
									<a href="./divSample.html" target="_self" class="">» &nbsp;DIV</a>
								</li>
								<hr class="bm-smaller">
								<li class="sub-nav-item">
									<a href="./jstreeSample.html" target="_self" class="">» &nbsp;JsTree</a>
								</li>
								<hr class="bm-smaller">
								<li class="sub-nav-item">
									<a href="./tableSample.html" target="_self" class="">» &nbsp;Table</a>
								</li>
								<hr class="bm-smaller">
							</ul>
						</li>
						<hr class="bm-smaller">
						<li class="nav-item  has-dropdown">
							<a href="#" target="_self" class="parent-link">
								설정
								<span class="has-dropdown-icon float-right">+</span>
							</a>
							<ul class="sub-nav unstyled bm-remove">
								<li class="sub-nav-item first active has-dropdown">
									<a href="#" target="_self" class=" first active parent-link">
										» &nbsp;일반
										<span class="has-dropdown-icon float-right">+</span>
									</a>
									<ul class="sub-nav unstyled bm-remove">
										<li class="sub-nav-item first active">
											<a href="#" class=" first active">» &nbsp;기본설정</a>
										</li>
										<li class="sub-nav-item">
											<a href="#" class="">» &nbsp;포인트 설정</a>
										</li>
										<li class="sub-nav-item">
											<a href="#" class="">» &nbsp;팝업 설정</a>
										</li>
										<li class="sub-nav-item">
											<a href="#" class="">» &nbsp;메일링 설정</a>
										</li>
										<li class="sub-nav-item">
											<a href="#" class="">» &nbsp;SMS 설정</a>
										</li>
										<li class="sub-nav-item">
											<a href="#" class="">» &nbsp;SNS 설정</a>
										</li>
									</ul>
								</li>
								<hr class="bm-smaller">
								<li class="sub-nav-item has-dropdown">
									<a href="#" target="_self" class="parent-link">
										» &nbsp;고급
										<span class="has-dropdown-icon float-right">+</span>
									</a>
									<ul class="sub-nav unstyled bm-remove">
										<li class="sub-nav-item first active">
											<a href="${pageContext.request.contextPath}/core/manage/setting/server/index.do" class=" first active">» &nbsp;서버 설정</a>
										</li>
										<li class="sub-nav-item">
											<a href="${pageContext.request.contextPath}/core/manage/setting/ftp/index.do" class="">» &nbsp;FTP 설정</a>
										</li>
										<li class="sub-nav-item">
											<a href="${pageContext.request.contextPath}/core/manage/setting/upload/index.do" class="">» &nbsp;파일업로드 설정</a>
										</li>
										<li class="sub-nav-item has-dropdown">
											<a href="#" class="parent-link">
												» &nbsp;설치 프로그램 관리
												<span class="has-dropdown-icon float-right">+</span>
											</a>
											<ul class="sub-nav unstyled bm-remove">
												<li class="sub-nav-item first active">
													<a href="#" class=" first active">» &nbsp;Component</a>
												</li>
												<li class="sub-nav-item">
													<a href="#" class="">» &nbsp;LayOut</a>
												</li>
												<li class="sub-nav-item">
													<a href="#" class="">» &nbsp;Widget</a>
												</li>
											</ul>
										</li>
									</ul>
								</li>
								<hr class="bm-smaller">
								<li class="sub-nav-item">
									<a href="#" target="_self" class="">» &nbsp;메뉴</a>
								</li>
							</ul>
						</li>
						<hr class="bm-smaller">
						<li class="nav-item">
							<a href="#" target="_self" class="">페이지</a>
						</li>
						<hr class="bm-smaller">
						<li class="nav-item  has-dropdown">
							<a href="#" target="_self" class="parent-link">
								회원관리
								<span class="has-dropdown-icon float-right">+</span>
							</a>
							<ul class="sub-nav unstyled bm-remove">
								<li class="sub-nav-item first active">
									<a href="#" target="_self" class=" first active">» &nbsp;기본설정</a>
								</li>
								<hr class="bm-smaller">
								<li class="sub-nav-item">
									<a href="#" target="_self" class="">» &nbsp;회원목록 </a>
								</li>
								<hr class="bm-smaller">
								<li class="sub-nav-item">
									<a href="#" target="_self" class="">» &nbsp;회원등급</a>
								</li>
								<hr class="bm-smaller">
								<li class="sub-nav-item has-dropdown">
									<a href="#" class="parent-link">
										» &nbsp;포인트
										<span class="has-dropdown-icon float-right">+</span>
									</a>
									<ul class="sub-nav unstyled bm-remove">
										<li class="sub-nav-item first active">
											<a href="#" class=" first active">» &nbsp;일반설정</a>
										</li>
										<li class="sub-nav-item">
											<a href="#" class="">» &nbsp;회원 별 포인트 관리</a>
										</li>
									</ul>
								</li>
							</ul>
						</li>
						<hr class="bm-smaller">
						<li class="nav-item  has-dropdown">
							<a href="#" target="_self" class="parent-link">
								게시판
								<span class="has-dropdown-icon float-right">+</span>
							</a>
							<ul class="sub-nav unstyled bm-remove">
								<li class="sub-nav-item first active">
									<a href="#" target="_self" class=" first active">» &nbsp;게시판</a>
								</li>
								<li class="sub-nav-item">
									<a href="#" target="_self" class="">» &nbsp;게시판 관리</a>
								</li>
								<li class="sub-nav-item">
									<a href="#" target="_self" class="">» &nbsp;게시글 관리</a>
								</li>
								<li class="sub-nav-item">
									<a href="#" target="_self" class="">» &nbsp;댓글 관리</a>
								</li>
								<li class="sub-nav-item">
									<a href="#" target="_self" class="">» &nbsp;파일 관리</a>
								</li>
								<li class="sub-nav-item">
									<a href="#" target="_self" class="">» &nbsp;설문 관리</a>
								</li>
								<li class="sub-nav-item">
									<a href="#" target="_self" class="">» &nbsp;RSS</a>
								</li>
								<li class="sub-nav-item">
									<a href="#" target="_self" class="">» &nbsp;휴지통 관리</a>
								</li>
								<li class="sub-nav-item">
									<a href="#" target="_self" class="">» &nbsp;문의 게시판 설정</a>
								</li>
								<li class="sub-nav-item ">
									<a href="#" target="_self" class="">» &nbsp;기본 Contents 설정</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
</body>
</html>
