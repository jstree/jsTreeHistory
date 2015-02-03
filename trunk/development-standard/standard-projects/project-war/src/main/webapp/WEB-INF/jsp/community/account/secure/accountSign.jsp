<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head></head>
	<body>
		<section class="clearfix" >
			<div class="container bm-medium">
				<nav>
					<div class="container bm-medium">
						<div class="one-whole">
							<div class="no-display">customers/Secure Sign in</div>
							<div class="text-center">
								<h1 class="bm-remove">
									<span id="customer-login-breadcrumb-header">Sign in or create new account</span>
									<span id="customer-recover-breadcrumb-header" class="no-display">Recover Password</span>
								</h1>
								<p class="bm-remove">
									<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
									&nbsp;/&nbsp;
									Account
									&nbsp;/&nbsp;
									Sign in or Sign Up
									<span id="customer-recover-breadcrumb" class="no-display">Recovery</span>
								</p>								
							</div>
						</div>
					</div>
				</nav>
				<div class="container bm-medium" id="account-sign">
					<div class=" p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="one-half-percent desktop-tablet alpha boxed bm-remove">
							<h1 class="bm-small text-center">Sign In</h1>
							<div id="customer-login-form">
								<form accept-charset="UTF-8" action="${pageContext.request.contextPath}/egovframework/com/etc/jstree/support/manager/security/loginProcess.do" id="loginForm" name="loginForm" method="post">
									<input name="_spring_security_remember_me" type="hidden" value="true" />
									<input name="form_type" type="hidden" value="loginForm" /><input name="utf8" type="hidden" value="✓" />
									<script>
										$(document).ready(function() {
											$('#loginForm').attr('novalidate', '');
										});
									</script>
									<input type="text" id="j_username" name="j_username" class="w-full" placeholder="ID or Email" value="" />
									<input type="text" class="w-full fake-password" placeholder="Password" />
									<input type="password" id="j_password" name="j_password" class="w-full true-password no-display" />
									<!-- 
									<div class="text-left">
										<a href="#" target="_self" id="recover-show">Forgot your password?</a>
									</div>
									 -->
									<div class="text-right">
										<button type="submit" class="inline-block bm-remove">Sign in</button>
									</div>
								</form>
							</div>
							<div id="customer-recover-form" class="no-display">
								<form accept-charset="UTF-8" action="${pageContext.request.contextPath}/account/recover" method="post">
									<input name="form_type" type="hidden" value="recover_customer_password" /><input name="utf8" type="hidden" value="✓" />
									<script>
										$(document).ready(function() {
											$('#customer-recover-password-form form').attr('novalidate', '');
										});
									</script>
									<input type="email" name="email" id="recover-email" class="w-full" placeholder="Email Address" value="" />
									<div class="text-right">
										<button type="submit" class="bm-remove">Recover</button>
									</div>
								</form>
							</div>
						</div>
						<div class="one-half-percent desktop-tablet alpha bm-remove boxed last">
							<h1 class="bm-small text-center">Sign Up</h1>
							<form accept-charset="UTF-8" action="https://cloudeight-nero.myshopify.com/account" id="create_customer" method="post">
								<input name="form_type" type="hidden" value="create_customer" /><input name="utf8" type="hidden" value="✓" />
								<script>
									$(document).ready(function() {
										$('#create_customer').attr('novalidate', '');
									});
								</script>
								<input type="email" name="customer[email]" id="register-email" class="w-full" placeholder="ID or Email" value="" />
								<input type="text" class="w-full fake-password" placeholder="Password" />
								<input type="password" name="customer[password]" id="register-password" class="w-full true-password no-display" />
								<input type="text" class="w-full fake-password" placeholder="Re Enter Password" />
								<input type="password" name="customer[reenter-password]" id="register-reenter-password" class="w-full true-password no-display" />
								<div class="text-right">
									<button type="submit" class="bm-remove">Sign Up</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>