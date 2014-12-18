<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
	<head></head>
	<body>
		<footer>
			<div id="footer" class="tm-larger animate-in" data-anim-type="fade-in" data-anim-delay="0">
				<div class="container">
					<div id="columns" class="container">
						<div class="clearfix">
							<div class="one-quarter bm-larger tm-larger">
								<div id="custom">
									<h4 class="title">
										<span>313 Developer Group</span>
									</h4>
									<div class="content rte">
										<p class="text bm-remove">313 개발자 그룹은 2010년 자바스터디로 시작되었습니다. <br />
										그후 2013년 게시판 오픈소스 프로젝트를 구상하게 되었고, 바로보드라는 결실을 맺게 되었습니다. <br />
										더욱더 발전할 313 개발자 그룹을 지켜봐 주십시오.</p>
									</div>
								</div>
							</div>
							<div class="one-quarter bm-larger tm-larger">
								<div id="newsletter">
									<h4 class="title">
										<span>Newsletter</span>
									</h4>
									<div class="content">
										<p class="text bm-remove">
											메일링 리스트에 가입하면 313 개발자 그룹의 소식을 받아보실 수 있습니다.
										</p>
										<form id="email-list-form" accept-charset="UTF-8" method="post">
											<input id="email-list-input" type="email" class="bm-remove" name="c_title" placeholder="Email address..." />
											<button id="email-list-submit" type="submit" name="submit" class="bm-remove">
											<i class="fa fa-chevron-right"></i>
											</button>
										</form>
									</div>
								</div>
							</div>
							<div class="one-quarter bm-larger tm-larger">
								<div id="link-list">
									<h4 class="title"><span>Contact Us</span></h4>
									<div class="content">
										<ul class="unstyled bm-remove">
											<li><a href="mailto:313@313.co.kr" target="_self"><i class="fa fa-envelope-o fw"></i><span>Mail to Admin</span></a></li>
											<li><a href="tel:010-5093-7313" target="_self"><i class="fa fa-phone fw"></i><span>010-5093-7313</span></a></li>
											<!-- <li><a href="#" target="_self"><i class="fa fa-map-marker fw"></i><span>서울시 영등포구 문래동5가</span></a></li> -->
										</ul>
									</div>
								</div>
							</div>
							<div class="one-quarter bm-larger tm-larger last">
								<div id="social">
									<h4 class="title">
										<span>Follow Us</span>
									</h4>
									<div class="content">
										<p class="text"></p>
										<div id="social-icons">
											<span class="tip-t-fade" data-tooltip="Facebook"><a	href="https://www.facebook.com/313DevGroup" target="_blank"><i class="fa fa-facebook fa-fw"></i></a></span> 
											<span class="tip-t-fade" data-tooltip="Twitter"><a href="https://twitter.com/313DevGroup" target="_blank"><i	class="fa fa-twitter fa-fw"></i></a></span> 
											<span class="tip-t-fade" data-tooltip="Google+"><a href="https://plus.google.com/communities/116550874214546756994" target="_blank"><i class="fa fa-google-plus fa-fw"></i></a></span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="copyright" class="one-half-percent desktop-tablet bm-remove">
						Copyright &copy; 2013-2014, 313 Developer Group
					</div>
					<div id="validation" class="one-half-percent desktop-tablet bm-remove last">
						<span>
							<img id="html5certified" src="${pageContext.request.contextPath}/assets/images/W3C_HTML5_certified.jpg">
							<img id="csscertified" src="${pageContext.request.contextPath}/assets/images/W3C_CSS_certified.jpg">
						</span>
					</div>
				</div>
			</div>
		</footer>
		<script>
		$(document).ready(function() {
		  
		    $("#email-list-submit").click(function(e) {
		      
		        var $email = $("#email-list-input");
		        var email = $email.val();
		        
		        // TODO 예외처리 보강
		        if (email.length == 0) {
		          alert('이메일을 입력해주세요.'); // TODO 경고창 라이브러리로 대체
		          $email.focus();
		          return false;
		        }
		        
		        callAjax($("#newsletter form"), getContextPath() + '/newsletter/addEmail.do', null, 'post', 'json', null, function(obj) {
		          alert(obj);
		          console.log(obj);
		        });
		        
// 		    	$.post(
// 	    			"${pageContext.request.contextPath}/newsletter/addEmail.do",		
// 	    			{
// 	    				"email" : $("#email-list-input").val()
// 	    			},
// 	    			function(r) {
// 	    				if(r.status==0) {
// 	    					$("#email-list-input").val("");
// 	    					alert("Email 입력 성공");	
// 	    				} else {
// 	    					alert("Email 입력 실패\n 메일 주소 형식을 확인하세요");
// 	    				}
// 	    			}
// 		    	);
		        
		        
		        return false;
		    });
		});
		</script>
	</body>
</html>