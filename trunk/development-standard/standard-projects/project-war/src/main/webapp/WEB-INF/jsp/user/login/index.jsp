<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
				<form accept-charset="UTF-8" action="${pageContext.request.contextPath}/user/login/loginProcess.do" id="loginForm" name="loginForm" method="post">
					<div id="customer-login-form" >
						<script>
							$(document).ready(function() {
								$('#loginForm').attr('novalidate', '');
							});
						</script>
						<div class="responsive-row tm-larger">
						 	<div class="one-quarter-percent inline-block ">
								<label for="email">이메일 주소</label>
							</div>
							 <div class="three-quarter-percent">
								<input type="text" id="email" name="email" class="w-full" value="VinDiesel@Gmail.com" />
							</div>
						</div>
						<div class="responsive-row inline-block ">
							<div class="one-quarter-percent">
								<label for="t_password">비밀번호</label>
							</div>
							<div class="three-quarter-percent">
								<input type="text" id="t_password" class="w-full fake-password" value="VinDiesel"/>
								<input type="password" id="password" name="password" class="w-full true-password no-display" value="VinDiesel"/>
							</div>
						</div>
						<c:if test="${not empty errorMsg}">
							<script type="text/javascript">
								alert('${errorMsg}');
							</script>
						</c:if>
					</div>
					<div class="text-right tm-small">
						<button type="button"  id="submitBtn" class="inline-block bm-remove">로그인</button>
						<button type="button"  id="searchBtn" class="inline-block bm-remove">비밀번호초기화</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<script>
	var secureLogin = 
	{
		handleEvent : function()
		{
			$('#submitBtn').on('click', function()
			{
				if( $('#email').val() === '' )
				{
					alert('<spring:message code="bb.com.error.014"/>');
					$('#email').focus();
					return;
				}
				
				if( $('#t_password').val() === '' )
				{
					alert('<spring:message code="bb.com.error.015"/>');
					$('#t_password').focus();
					return;
				}
				
				$('#loginForm').submit();
			});
			
			$('#searchBtn').on('click', function()
			{
				$(location).attr('href',"initPassword.do");
			});
		},
		init : function() 
		{
		    this.handleEvent();
		}
	}
	
	$(document).ready(function() 
	{
	    secureLogin.init();
	});
</script>
