<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
	.responsive-row 
	{
	    width: 100%;
	    overflow: auto;
	    line-height: 43px;
	}
	#customer-login-form
	{
		border-top: solid 1px #e8e8e8; 
		border-bottom: solid 1px #e8e8e8;
	}
</style>
<section>
	<div class="container bm-medium" id="account-sign">
		<div class=" p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
			<div class="element-center one-half-percent desktop-tablet alpha bm-remove last" id = "account-signin">
				<h1 class="bm-small text-left">로그인</h1>
				<form accept-charset="UTF-8" action="${pageContext.request.contextPath}/j_spring_security_check" id="loginForm" name="loginForm" method="post">
					<div id="customer-login-form" >
						<script>
							$(document).ready(function() {
								$('#loginForm').attr('novalidate', '');
							});
						</script>
						<div class="responsive-row tm-larger">
						 	<div class="one-quarter-percent inline-block ">
								<label for="j_username">이메일 주소</label>
							</div>
							 <div class="three-quarter-percent">
								<input type="text" id="j_username" name="j_username" class="w-full" placeholder="ID or Email" value="" />
							</div>
						</div>
						<div class="responsive-row inline-block ">
							<div class="one-quarter-percent">
								<label for="t_password">비밀번호</label>
							</div>
							<div class="three-quarter-percent">
								<input type="text" id="t_password" class="w-full fake-password" placeholder="Password" />
								<input type="password" id="j_password" name="j_password" class="w-full true-password no-display" />
							</div>
						</div>
					</div>
					<div class="text-right tm-small">
						<button type="submit" class="inline-block bm-remove">로그인</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>