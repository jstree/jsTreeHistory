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
										<form id="email-list-form" action="/newsletter/addEmail.do" method="post">
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
											<li><a href="#" target="_self"><i class="fa fa-map-marker fw"></i><span>서울시 용산구 동부이촌동 퀸즈빌 7층</span></a></li> -->
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
											<span class="tip-t-fade" data-tooltip="Facebook"><a	href="https://www.facebook.com/groups/313devgroup/" target="_blank"><i class="fa fa-facebook fa-fw"></i></a></span>
											<span class="tip-t-fade" data-tooltip="Twitter"><a href="https://twitter.com/313DevGroup" target="_blank"><i	class="fa fa-twitter fa-fw"></i></a></span>
											<span class="tip-t-fade" data-tooltip="Google+"><a href="https://plus.google.com/communities/116550874214546756994" target="_blank"><i class="fa fa-google-plus fa-fw"></i></a></span>
											<span class="tip-t-fade" data-tooltip="Google+"><a href="https://plus.google.com/communities/116550874214546756994" target="_blank"><%= com.jcabi.manifests.Manifests.read("Manifest-Version") %></a></span>
											<span class="tip-t-fade" data-tooltip="Google+"><a href="https://plus.google.com/communities/116550874214546756994" target="_blank"><%= com.jcabi.manifests.Manifests.read("Build-ETC") %></a></span>
											<span class="tip-t-fade" data-tooltip="Google+"><a href="https://plus.google.com/communities/116550874214546756994" target="_blank"><%= com.jcabi.manifests.Manifests.read("Build-Label") %></a></span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="copyright" class="one-half-percent desktop-tablet bm-remove">
						Copyright &copy; 2013-2015, 313 Developer Group
					</div>
					<div id="validation" class="one-half-percent desktop-tablet bm-remove last">
						<span>
							<img src="${pageContext.request.contextPath}/assets/images/valid-html5.png">
							<img src="${pageContext.request.contextPath}/assets/images/valid-css.png">
							<img src="${pageContext.request.contextPath}/assets/images/rss-btn.png"> 
						</span>
					</div>
				</div>
			</div>
		</footer>
		<script>
		$(document).ready(function() {
		  
		    $('#email-list-submit').click(function() {
		      	
		        var formId = 'email-list-form';
	            var $form = $('#email-list-form');
		        
		        callAjax(formId, $form.prop('action'), null, $form.prop('method'), "json", null, null, callback);
		        
		        function callback(r) {
                    $("#email-list-input").val("");
                    alert("메일링 리스트에 가입되었습니다.");
		        }
		        
		        return false;
		    });
		});
		</script>
	</body>
</html>