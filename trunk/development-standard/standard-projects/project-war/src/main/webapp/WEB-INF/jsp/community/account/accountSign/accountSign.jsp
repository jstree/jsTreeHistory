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
							<div class="no-display">customers/Sign in</div>
							<div class="text-center">
								<h1 class="bm-remove">
									<span id="customer-login-breadcrumb-header">Account</span>
									<span id="customer-recover-breadcrumb-header" class="no-display">Recover Password</span>
								</h1>
								<p class="bm-remove">
									<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
									&nbsp;/&nbsp;
									<a href="${pageContext.request.contextPath}/account/accountSign.do" target="_self">Account</a>
									&nbsp;/&nbsp;
									<span id="customer-login-breadcrumb">Sign in</span>
									<span id="customer-recover-breadcrumb" class="no-display">Recovery</span>
								</p>
							</div>
						</div>
					</div>
				</nav>
				<div class="container bm-medium" id="account-sign">
					<div class=" p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="one-half-percent desktop-tablet alpha boxed bm-remove">
							<h1 class="bm-small text-center">Sign in</h1>
							<div id="customer-login-form">
								<form accept-charset="UTF-8" action="${pageContext.request.contextPath}/uat/uia/actionLogin.do" id="customer_login" method="post">
									<input type="hidden" name="userSe"  value="USR"/>
									<input name="form_type" type="hidden" value="customer_login" /><input name="utf8" type="hidden" value="✓" />
									<script>
										$(document).ready(function() {
											$('#customer_login').attr('novalidate', '');
										});
									</script>
									<input type="text" name="id" id="id" class="w-full" placeholder="Email Address" value="" />
									<input type="text" class="w-full fake-password" placeholder="Password" />
									<input type="password" name="password" id="password" class="w-full true-password no-display" />
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
								<input type="email" name="customer[email]" id="register-email" class="w-full" placeholder="Email Address" value="" />
								<input type="text" class="w-full fake-password" placeholder="Password" />
								<input type="password" name="customer[password]" id="register-password" class="w-full true-password no-display" />
								<input type="text" class="w-full fake-password" placeholder="Re Enter Password" />
								<input type="password" name="customer[reenter-password]" id="register-reenter-password" class="w-full true-password no-display" />
								<div class="text-right">
									<button type="submit" class="bm-remove">Create</button>
								</div>
							</form>
						</div>
					</div>
				</div>
		</section>
	</body>
</html>
