<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head></head>
	<body>
		<section class="clearfix" >
			<div class="container bm-medium">
				<div class="one-whole">
					<div class="no-display">page.contact</div>
					<div class="text-center">
						<h1 class="bm-remove">
							Contact Us
						</h1>
						<p class="bm-remove">
							<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
							&nbsp;/&nbsp;
							About Us
							&nbsp;/&nbsp;
							Contact Us
						</p>
					</div>
				</div>
			</div>
			<div class="clearfix">
				<div class="container bm-medium">
					<div id="page-contact" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<iframe width="600" height="450" style="border:0" src="https://www.google.com/maps/embed/v1/place?q=37.400157%2C%20127.110075&key=AIzaSyAyN6J1IpsY7fxxVZI12EsxwzPsjd1jLR8"></iframe>
						<div class="one-half-percent tablet-mobile omega">
							<div id="page-contact-content" class="rte">
								<h1>313 Developer Group은</h1>
								<p>언제나 모든 분들의 소중한 의견을 기다리고 있습니다.</p>
								<p>저희 제품이나 기타 궁금한 사항이 있으신 경우, 아래의 연락처 또는 옆의 홈페이지 문의 기능을 사용하여 전달해 주시면 작은 의견이라도 놓치지 않고 귀담아 듣도록 하겠습니다.</p>
								<p>TEL : <a href="tel:010-2531-0470" target="_self"><i class="fa fa-phone fw"></i><span>010-2531-0470</span></a></p>
								<p>Email : <a href="mailto:313@313.co.kr" target="_self"><i class="fa fa-envelope-o fw"></i><span>313@313.co.kr</span></a></p>
								<p>GNU 정신을 잊지 않고 함께 나아가는 313 Developer Group에 많은 관심을 부탁드립니다</p>
							</div>
						</div>
						<div id="contact-post" class="one-half-percent tablet-mobile alpha last bm-remove">
							<form accept-charset="UTF-8" action="${pageContext.request.contextPath}/contact" class="contact-form" method="post">
								<input name="form_type" type="hidden" value="contact" /><input name="utf8" type="hidden" value="✓" />
								<script>
									$(document).ready(function() {
										$('.contact-form').attr('novalidate', '');
									});
								</script>
								<input type="text" name="contact[name]" id="contactFormName" class="w-full" placeholder="Name" value="" />
								<input type="email" name="contact[email]" id="contactFormEmail" class="w-full" placeholder="Email Address" value="" />
								<input type="tel" name="contact[phone]" id="contactFormTelephone" class="w-full" placeholder="Telephone Number" value="" />
								<textarea name="contact[body]" id="contactFormMessage" class="w-full" placeholder="Your Message..."></textarea>
								<div class="clearfix">
									<button type="submit" id="contactFormSubmit" class="bm-remove float-right">Send</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>
