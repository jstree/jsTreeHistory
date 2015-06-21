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
		padding-top: 35px;
	}
	.tm-larger {
  		margin-top: 0px	!important;
	}
	.one-quarter-percent
	{
  		margin-bottom: 0px	!important;
	}
</style>
<section>
	<div class="container bm-medium" id="account-sign">
		<div class=" p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
			<div class="element-center one-half-percent desktop-tablet alpha bm-remove last" id = "account-signin">
				<h1 class="bm-small text-left">비밀번호 초기화</h1>
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
							<input type="text" id="email" name="email" class="w-full"/>
						</div>
					</div>
						<div class="responsive-row tm-larger" ">
						<div class="one-quarter-percent inline-block">
							<label>초기화 질문</label>
						</div>
						<div class="three-quarter-percent">
							<input type="text" id="question" name="question" class="w-full" readonly="readonly"/>
						</div>
					</div>
					<div class="responsive-row tm-larger">
					 	<div class="one-quarter-percent inline-block ">
							<label for="answer">초기화 답변</label>
						</div>
						 <div class="three-quarter-percent">
							<input type="text" id="answer" name="answer" class="w-full"/>
						</div>
					</div>
				</div>
				<div class="text-right tm-small">
					<button type="button"  id="questionBtn" class="inline-block bm-remove">질문 찾기</button>
					<button type="button"  id="initBtn" class="inline-block bm-remove" disabled="disabled">비밀번호 초기화</button>
					
				</div>
			</div>
		</div>
	</div>
</section>
<script>
	var initPassword = 
	{
		handleEvent : function()
		{
			$('#questionBtn').on('click', function()
			{
				if( $('#email').val() === '' )
				{
					alert('이메일을 입력 하세요');
					$('#email').focus();
					return;
				}
				
				$.ajax({
		    		  url: 'findPasswordQuestion.do',
		    		  method: 'GET',
		    		  data: { email: $('#email').val() },
		    		}).done(function(data)
		    		{
		    			if($.type(data) === 'object')
		    			{
			    			$('#question').val(data.passwordFindQuestion);
			    			$('#initBtn').prop('disabled',false);
		    			}
		    			else
	    				{
		    				$('#question').val('');
		    				$('#initBtn').prop('disabled',true);
		    				$('#email').focus();
		    				alert('잘못된 이메일 주소 입니다.');
	    				}
		    		}).fail(function(data){
		    			alert(data);
		    		});
			});
			
			$('#initBtn').on('click', function()
			{
				if( $('#email').val() === '' )
				{
					alert('이메일을 입력 하세요');
					$('#email').focus();
					return;
				}
				
				if( $('#question').val() === '' )
				{
					alert('비밀번호 초기화 질문을 조회 하세요');
					$('#email').focus();
					return;
				}
				
				if( $('#answer').val() === '' )
				{
					alert('답변을 입력 하세요');
					$('#answer').focus();
					return;
				}
				
				$.ajax({
		    		  url: 'checkPasswordAnswer.do',
		    		  method: 'POST',
		    		  contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		    		  data: { email: $('#email').val(), answer: $('#answer').val()},
		    		}).done(function(data)
		    		{
		    			if(data.joinState === '0')
	    				{
		    				alert('일치하지 않는 초기화 답변입니다.');
		    				$('#answer').focus();
	    				}
		    			else
		    			{
		    				alert('비밀번호가 이메일 주소로 초기화 되었습니다.');
		    			}
		    		}).fail(function(data)
		    		{
		    			alert(data);
		    		});
			});
		},
		init : function() 
		{
		    this.handleEvent();
		}
	}
	
	$(document).ready(function() 
	{
	    initPassword.init();
	});
</script>
