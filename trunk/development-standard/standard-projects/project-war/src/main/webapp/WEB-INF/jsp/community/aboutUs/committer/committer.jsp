<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head>
		<!-- CSS for Committer Profile Section -->
		<style type="text/css">
			html {
			margin-top: 40px;
			}
			body {
			position: relative;
			}
			
			
			.profile-frame > p {
				color : black;
				font-size : 11pt;
			}
			.profile-frame > p > a{
				color : black;
				font-size : 12pt;
				font-weight: bold;
			}
			
			.p
			
			.profile-box {
				max-width : 258px;
				display : block;
			}
			
			.profile-box a {
				display: block;
				overflow: hidden;
				position: relative;
				text-decoration: none;
				max-width: 100%;
			}
			
			.profile-box a img {
				border-radius: 5px;
			}

			
			
			.profile-box .profile-box-title {
				-webkit-transition : all 0.5s;
				-moz-transition : all 0.5s;
				transition : all 0.5s;
				background : rgba(36, 27, 28, 0.9);
				height : 50px;
				bottom : 13%;
				color : #FFF;
				font-size : 18px;
				font-weight : 700;
				left : 0;
				padding : 9px 11px 9px;
				position : absolute;
				text-shadow : 1px 1px 1px rgba(0, 0, 0, 0.2);
				text-transform : uppercase;
				z-index : 1;
			}
			
			.profile-box .profile-box-title .profile-box-name {
				display : block;
			}
					
			.profile-box .profile-box-title .profile-box-role {
				background-color: #f45b4f;
				display : inline-block;
				float : left;
				font-size : 12px;
				font-weight : 400;
				border-radius : 2px;
				color : rgb(255,255,255);
				margin : 7px -2px -10px -2px;
				padding : 0px 9px;
				text-transform : none;
			}
			
			@media only screen and (max-width: 980px) and (min-width: 769px) {
				.profile-box .profile-box-title {
					bottom : 12%;
					height : 37px;
					padding : 3px 7px;
					
				}
				.profile-box .profile-box-title .profile-box-name {
					font-size : 13px;
				}
				.profile-box .profile-box-title .profile-box-role {
					margin : 0;
					font-size : 10px; 
				}
			}	
			
			.contact {
				margin-bottom: 8px;
			}
			.contact span {
				width : 36px;
				height : 36px;
				text-align : center;
				line-height : 36px;
				display : inline-block;
			}
			.contact span a {
				display: block;
				width: 100%;
				height: 100%;
				border: 1px solid #f45b4f;
				-webkit-border-radius: 100%;
				-moz-border-radius: 100%;
				border-radius: 100%;
				background: #fff;
				color: #f45b4f;
				font-size: 1.2em;
				-webkit-transition: all 0.2s ease-in-out;
				-moz-transition: all 0.2s ease-in-out;
				-o-transition: all 0.2s ease-in-out;
				-ms-transition: all 0.2s ease-in-out;
				transition: all 0.2s ease-in-out;
			}
			
			.contact span a:hover {
				background: #f45b4f;
			    color: #fff;
			}
			
		</style>	
	</head>
	<body>
		<section class="clearfix" >
			<div class="container">
				<div class="one-whole">
					<p class="special-header animate-in" data-anim-type="fade-in" data-anim-delay="0">Committer</p>
					<div class="one-whole bm-larger boxed p-twenty animate-in" data-anim-type="fade-in" data-anim-delay="0">
<!-- 						영상 업로더가 일베로 보여서 영상 교체 -->
<!-- 						<iframe width="560" height="315" src="//www.youtube.com/embed/yNhMfLvQYpA" allowfullscreen></iframe> -->
						<iframe width="560" height="315" src="//www.youtube.com/embed/bQdxCPSTIw4" frameborder="0" allowfullscreen></iframe>
						<p class="bm-larger tm-larger text-center">It's not over until we win.</p>
					</div>
					<!-- 요기부터 작업 ! -->
					<div class="one-quarter product-item boxed p-ten text-center odd loop-first animate-in clearfix profile-frame" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image profile-box">
								<a href="#" target="_self">
									<img src="/images/profile/ldm.jpeg" alt="이동민" class="block" />
									<span class="profile-box-title">
										<span class="profile-box-name">Dongmin Lee</span>
										<span class="profile-box-role">PM</span>
									</span>
								</a>
							</div>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="/baroBoard/baroBoardOverView.do" target="_self"><strong>이동민</strong></a>
							<br />
							AhnLab
						</p>
						<div>
							<div class="content">
								<p class="text"></p>
								<div class="contact">
									<span class="tip-t-fade" data-tooltip="Facebook">
										<a href="http://www.facebook.com" target="_blank">
											<i class="fa fa-facebook fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Twitter">
										<a href="http://www.twitter.com" target="_blank">
											<i class="fa fa-twitter fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Google+">
										<a href="https://plus.google.com" target="_blank">
											<i class="fa fa-google-plus fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="LinkedIn">
										<a href="http://www.linkedin.com" target="_blank">
											<i class="fa fa-linkedin fa-fw"></i>
										</a>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center even loop-first animate-in clearfix profile-frame" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image profile-box">
								<a href="/baroBoard/baroBoardOverView.do" target="_self">
									<img src="/images/profile/cms.jpeg" alt="최민석" class="block" />
									<span class="profile-box-title">
										<span class="profile-box-name">Minseok Choi</span>
										<span class="profile-box-role">PM</span>
									</span>
								</a>
							</div>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="/baroBoard/baroBoardOverView.do" target="_self"><strong>최민석</strong></a>
							<br />
							쓰리웨어
						</p>
						<div>
							<div class="content">
								<p class="text"></p>
								<div class="contact">
									<span class="tip-t-fade" data-tooltip="Facebook">
										<a href="http://www.facebook.com" target="_blank">
											<i class="fa fa-facebook fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Twitter">
										<a href="http://www.twitter.com" target="_blank">
											<i class="fa fa-twitter fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Google+">
										<a href="https://plus.google.com" target="_blank">
											<i class="fa fa-google-plus fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="LinkedIn">
										<a href="http://www.linkedin.com" target="_blank">
											<i class="fa fa-linkedin fa-fw"></i>
										</a>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center odd loop-first animate-in clearfix profile-frame" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image profile-box">
								<a href="/baroBoard/baroBoardOverView.do" target="_self">
									<img src="/images/profile/kbw.jpeg" alt="김병우" class="block" />
									<span class="profile-box-title">
										<span class="profile-box-name">Byungwoo Kim</span>
										<span class="profile-box-role">PM</span>
									</span>
								</a>
							</div>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="/baroBoard/baroBoardOverView.do" target="_self"><strong>김병우</strong></a>
							<br />
							삼성SDS
						</p>
						<div>
							<div class="content">
								<p class="text"></p>
								<div class="contact">
									<span class="tip-t-fade" data-tooltip="Facebook">
										<a href="http://www.facebook.com" target="_blank">
											<i class="fa fa-facebook fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Twitter">
										<a href="http://www.twitter.com" target="_blank">
											<i class="fa fa-twitter fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Google+">
										<a href="https://plus.google.com" target="_blank">
											<i class="fa fa-google-plus fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="LinkedIn">
										<a href="http://www.linkedin.com" target="_blank">
											<i class="fa fa-linkedin fa-fw"></i>
										</a>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center even last loop-first    animate-in clearfix profile-frame" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image profile-box">
								<a href="/baroBoard/baroBoardOverView.do" target="_self">
									<img src="/images/profile/kdg.jpeg" alt="김대근" class="block" />
									<span class="profile-box-title">
										<span class="profile-box-name">Daegeun Kim</span>
										<span class="profile-box-role">Developer</span>
									</span>
								</a>
							</div>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="/baroBoard/baroBoardOverView.do" target="_self"><strong>김대근</strong></a>
							<br />
							유진시스템즈
						</p>
						<div>
							<div class="content">
								<p class="text"></p>
								<div class="contact">
									<span class="tip-t-fade" data-tooltip="Facebook">
										<a href="http://www.facebook.com" target="_blank">
											<i class="fa fa-facebook fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Twitter">
										<a href="http://www.twitter.com" target="_blank">
											<i class="fa fa-twitter fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Google+">
										<a href="https://plus.google.com" target="_blank">
											<i class="fa fa-google-plus fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="LinkedIn">
										<a href="http://www.linkedin.com" target="_blank">
											<i class="fa fa-linkedin fa-fw"></i>
										</a>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>
					<div class="one-quarter product-item boxed p-ten text-center odd loop-first animate-in clearfix profile-frame" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image profile-box">
								<a href="#" target="_self">
									<img src="/images/profile/rgh.jpeg" alt="류강하" class="block" />
									<span class="profile-box-title">
										<span class="profile-box-name">Kangha Ryu</span>
										<span class="profile-box-role">Developer</span>
									</span>
								</a>
							</div>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="/baroBoard/baroBoardOverView.do" target="_self"><strong>류강하</strong></a>
							<br />
							아이지오
						</p>
						<div>
							<div class="content">
								<p class="text"></p>
								<div class="contact">
									<span class="tip-t-fade" data-tooltip="Facebook">
										<a href="http://www.facebook.com" target="_blank">
											<i class="fa fa-facebook fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Twitter">
										<a href="http://www.twitter.com" target="_blank">
											<i class="fa fa-twitter fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Google+">
										<a href="https://plus.google.com" target="_blank">
											<i class="fa fa-google-plus fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="LinkedIn">
										<a href="http://www.linkedin.com" target="_blank">
											<i class="fa fa-linkedin fa-fw"></i>
										</a>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center even loop-first animate-in clearfix profile-frame" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image profile-box">
								<a href="/baroBoard/baroBoardOverView.do" target="_self">
									<img src="/images/profile/ltk.jpeg" alt="이태경" class="block" />
									<span class="profile-box-title">
										<span class="profile-box-name">Taekyung Lee</span>
										<span class="profile-box-role">Developer</span>
									</span>
								</a>
							</div>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="/baroBoard/baroBoardOverView.do" target="_self"><strong>이태경</strong></a>
							<br />
							Solideos
						</p>
						<div>
							<div class="content">
								<p class="text"></p>
								<div class="contact">
									<span class="tip-t-fade" data-tooltip="Facebook">
										<a href="http://www.facebook.com" target="_blank">
											<i class="fa fa-facebook fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Twitter">
										<a href="http://www.twitter.com" target="_blank">
											<i class="fa fa-twitter fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Google+">
										<a href="https://plus.google.com" target="_blank">
											<i class="fa fa-google-plus fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="LinkedIn">
										<a href="http://www.linkedin.com" target="_blank">
											<i class="fa fa-linkedin fa-fw"></i>
										</a>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center odd loop-first animate-in clearfix profile-frame" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image profile-box">
								<a href="/baroBoard/baroBoardOverView.do" target="_self">
									<img src="/images/profile/shs.jpg" alt="손호성" class="block" />
									<span class="profile-box-title">
										<span class="profile-box-name">Hoseong Son</span>
										<span class="profile-box-role">Developer</span>
									</span>
								</a>
							</div>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="/baroBoard/baroBoardOverView.do" target="_self"><strong>손호성</strong></a>
							<br />
							-
						</p>
						<div>
							<div class="content">
								<p class="text"></p>
								<div class="contact">
									<span class="tip-t-fade" data-tooltip="Facebook">
										<a href="http://www.facebook.com" target="_blank">
											<i class="fa fa-facebook fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Twitter">
										<a href="http://www.twitter.com" target="_blank">
											<i class="fa fa-twitter fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Google+">
										<a href="https://plus.google.com" target="_blank">
											<i class="fa fa-google-plus fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="LinkedIn">
										<a href="http://www.linkedin.com" target="_blank">
											<i class="fa fa-linkedin fa-fw"></i>
										</a>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center even last loop-first    animate-in clearfix profile-frame" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image profile-box">
								<a href="/baroBoard/baroBoardOverView.do" target="_self">
									<img src="/images/profile/yjw.jpeg" alt="유정우" class="block" />
									<span class="profile-box-title">
										<span class="profile-box-name">Jungwoo Yu</span>
										<span class="profile-box-role">Developer</span>
									</span>
								</a>
							</div>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="/baroBoard/baroBoardOverView.do" target="_self"><strong>유정우</strong></a>
							<br />
							이젠
						</p>
						<div>
							<div class="content">
								<p class="text"></p>
								<div class="contact">
									<span class="tip-t-fade" data-tooltip="Facebook">
										<a href="http://www.facebook.com" target="_blank">
											<i class="fa fa-facebook fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Twitter">
										<a href="http://www.twitter.com" target="_blank">
											<i class="fa fa-twitter fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Google+">
										<a href="https://plus.google.com" target="_blank">
											<i class="fa fa-google-plus fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="LinkedIn">
										<a href="http://www.linkedin.com" target="_blank">
											<i class="fa fa-linkedin fa-fw"></i>
										</a>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>
					<div class="one-quarter product-item boxed p-ten text-center odd loop-first animate-in clearfix profile-frame" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image profile-box">
								<a href="#" target="_self">
									<img src="/images/profile/jwk.jpeg" alt="정원기" class="block" />
									<span class="profile-box-title">
										<span class="profile-box-name">Wonki Jung</span>
										<span class="profile-box-role">Developer</span>
									</span>
								</a>
							</div>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="/baroBoard/baroBoardOverView.do" target="_self"><strong>정원기</strong></a>
							<br />
							하나INS
						</p>
						<div>
							<div class="content">
								<p class="text"></p>
								<div class="contact">
									<span class="tip-t-fade" data-tooltip="Facebook">
										<a href="http://www.facebook.com" target="_blank">
											<i class="fa fa-facebook fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Twitter">
										<a href="http://www.twitter.com" target="_blank">
											<i class="fa fa-twitter fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Google+">
										<a href="https://plus.google.com" target="_blank">
											<i class="fa fa-google-plus fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="LinkedIn">
										<a href="http://www.linkedin.com" target="_blank">
											<i class="fa fa-linkedin fa-fw"></i>
										</a>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center even loop-first animate-in clearfix profile-frame" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image profile-box">
								<a href="/baroBoard/baroBoardOverView.do" target="_self">
									<img src="/images/profile/jkh.jpg" alt="전경훈" class="block" />
									<span class="profile-box-title">
										<span class="profile-box-name">Kyunghun Jeon</span>
										<span class="profile-box-role">Developer</span>
									</span>
								</a>
							</div>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="/baroBoard/baroBoardOverView.do" target="_self"><strong>전경훈</strong></a>
							<br />
							tsis
						</p>
						<div>
							<div class="content">
								<p class="text"></p>
								<div class="contact">
									<span class="tip-t-fade" data-tooltip="Facebook">
										<a href="https://www.facebook.com/kyunghun.jeon" target="_blank">
											<i class="fa fa-facebook fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="LinkedIn">
										<a href="http://lnkd.in/bA_DPnG" target="_blank">
											<i class="fa fa-linkedin fa-fw"></i>
										</a>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center odd loop-first animate-in clearfix profile-frame" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image profile-box">
								<a href="/baroBoard/baroBoardOverView.do" target="_self">
									<img src="/images/profile/ljr.jpeg" alt="이종렬" class="block" />
									<span class="profile-box-title">
										<span class="profile-box-name">Jongryul Lee</span>
										<span class="profile-box-role">Developer</span>
									</span>
								</a>
							</div>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="/baroBoard/baroBoardOverView.do" target="_self"><strong>이종렬</strong></a>
							<br />
							한국상조공제조합
						</p>
						<div>
							<div class="content">
								<p class="text"></p>
								<div class="contact">
									<span class="tip-t-fade" data-tooltip="Facebook">
										<a href="http://www.facebook.com" target="_blank">
											<i class="fa fa-facebook fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Twitter">
										<a href="http://www.twitter.com" target="_blank">
											<i class="fa fa-twitter fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Google+">
										<a href="https://plus.google.com" target="_blank">
											<i class="fa fa-google-plus fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="LinkedIn">
										<a href="http://www.linkedin.com" target="_blank">
											<i class="fa fa-linkedin fa-fw"></i>
										</a>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center even last loop-first    animate-in clearfix profile-frame" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image profile-box">
								<a href="/baroBoard/baroBoardOverView.do" target="_self">
									<img src="/images/profile/okw.jpeg" alt="오권우" class="block" />
									<span class="profile-box-title">
										<span class="profile-box-name">Gwonwoo Oh</span>
										<span class="profile-box-role">Developer</span>
									</span>
								</a>
							</div>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="/baroBoard/baroBoardOverView.do" target="_self"><strong>오권우</strong></a>
							<br />
							-
						</p>
						<div>
							<div class="content">
								<p class="text"></p>
								<div class="contact">
									<span class="tip-t-fade" data-tooltip="Facebook">
										<a href="http://www.facebook.com" target="_blank">
											<i class="fa fa-facebook fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Twitter">
										<a href="http://www.twitter.com" target="_blank">
											<i class="fa fa-twitter fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Google+">
										<a href="https://plus.google.com" target="_blank">
											<i class="fa fa-google-plus fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="LinkedIn">
										<a href="http://www.linkedin.com" target="_blank">
											<i class="fa fa-linkedin fa-fw"></i>
										</a>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>
					<div class="one-quarter product-item boxed p-ten text-center odd loop-first animate-in clearfix profile-frame" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image profile-box">
								<a href="/baroBoard/baroBoardOverView.do" target="_self">
									<img src="/images/test_img.jpg" alt="최대열" class="block" />
									<span class="profile-box-title">
										<span class="profile-box-name">Daeyeol Choi</span>
										<span class="profile-box-role">Developer</span>
									</span>
								</a>
							</div>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="/baroBoard/baroBoardOverView.do" target="_self"><strong>최대열</strong></a>
							<br />
							위메프
						</p>
						<div>
							<div class="content">
								<p class="text"></p>
								<div class="contact">
									<span class="tip-t-fade" data-tooltip="Facebook">
										<a href="http://www.facebook.com" target="_blank">
											<i class="fa fa-facebook fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Twitter">
										<a href="http://www.twitter.com" target="_blank">
											<i class="fa fa-twitter fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Google+">
										<a href="https://plus.google.com" target="_blank">
											<i class="fa fa-google-plus fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="LinkedIn">
										<a href="http://www.linkedin.com" target="_blank">
											<i class="fa fa-linkedin fa-fw"></i>
										</a>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="one-quarter product-item boxed p-ten text-center even loop-first animate-in clearfix profile-frame" data-anim-type="fade-in" data-anim-delay="0">
						<div class="image-and-overlay-container bm-small">
							<div class="image profile-box">
								<a href="/baroBoard/baroBoardOverView.do" target="_self">
									<img src="/images/profile/jkw.jpg" alt="조경원" class="block" />
									<span class="profile-box-title">
										<span class="profile-box-name">Kyungwon Cho</span>
										<span class="profile-box-role">Publisher</span>
									</span>
								</a>
							</div>
						</div>
						<p class="bm-remove no-text-overflow">
							<a href="/baroBoard/baroBoardOverView.do" target="_self"><strong>조경원</strong></a>
							<br />
							디지털웍스
						</p>
						<div>
							<div class="content">
								<p class="text"></p>
								<div class="contact">
									<span class="tip-t-fade" data-tooltip="Facebook">
										<a href="http://www.facebook.com" target="_blank">
											<i class="fa fa-facebook fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Twitter">
										<a href="http://www.twitter.com" target="_blank">
											<i class="fa fa-twitter fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="Google+">
										<a href="https://plus.google.com" target="_blank">
											<i class="fa fa-google-plus fa-fw"></i>
										</a>
									</span> 
									<span class="tip-t-fade" data-tooltip="LinkedIn">
										<a href="http://www.linkedin.com" target="_blank">
											<i class="fa fa-linkedin fa-fw"></i>
										</a>
									</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="one-whole clearfix" data-anim-type="fade-in" data-anim-delay="fade-in">
					<div class="one-whole boxed p-twenty">
						<h1 class="bm-small text-center">Past Members</h1>
						<div class="rte">
							<p style="text-align: center;">
								유창근 위메프 <br />
								민전기 <br />
								김경진 NC소프트<br />
								박상진 tsis<br />
								김윤희 <br />
								홍성남 <br />
								김대훈 학생 <br />
								이동규 학생 <br />
							</p>
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>