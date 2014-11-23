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
					</div>
				</div>
			</div>
			<div class="clearfix">
				<div class="container bm-medium">
					<div id="page-contact" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<iframe width="600" height="450" style="border:0" src="https://www.google.com/maps/embed/v1/place?q=37.400157%2C%20127.110075&key=AIzaSyAyN6J1IpsY7fxxVZI12EsxwzPsjd1jLR8"></iframe>
						<div class="one-half-percent tablet-mobile omega">
							<div id="page-contact-content" class="rte">
								<h1>Lorem Ipsum</h1>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean ac egestas odio. Quisque nec sem eu nisl ornare interdum. Praesent eget scelerisque lorem. Sed vel nisi aliquet nisl iaculis porttitor ac at massa. Cras tempor, enim sed aliquet posuere, libero sapien adipiscing tortor, id pretium diam mi in nulla. In hac habitasse platea dictumst. Ut dictum nunc ipsum, vel aliquet neque placerat sit amet.</p>
								<p>Ut dignissim, nisi et adipiscing eleifend, diam orci gravida felis, eu auctor nisi urna vel sem. Maecenas quis cursus turpis, id egestas nulla. Vestibulum facilisis sapien ac turpis consequat, et mattis neque dapibus. Vivamus eleifend ultrices scelerisque.</p>
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
