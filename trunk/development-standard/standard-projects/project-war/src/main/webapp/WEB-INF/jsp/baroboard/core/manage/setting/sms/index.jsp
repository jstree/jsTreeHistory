<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags" %>

<style type="text/css">
.responsive-row {
    width: 100%;
    overflow: auto;
}
.right {
    text-align: right;
}
.chk {
    height: 13px !important;
}
.rdo {
    width: 13px !important;
    height: 13px !important;
}
input[type="text"] {
    height: 30px !important;
}
#divBottom {
    text-align: right;
    margin-top: 10px;
}
#divBottom button {
    min-width: 71px;
    min-height: 37px;
}
.displayNone{
	display:none;
}
</style>

<script type="text/javascript">
var inputForm = {
		submit : function(target){
			form = target.id;
			$form = $('#' + target.id);
	            
            if (!confirm('저장하시겠습니까?')) {
                return false;
            }
            
            var ajaxResult = callAjax(form
                   , $form.prop('action')
                   , null
                   , $form.prop('method')
                   , 'json'
                   , null
                   , null);
            
		}
}
$(document).ready(function() {
	$('#toggleSms').on('click', function() {
		$('#sendContent').toggle('displayNone');
	});
});
</script>
<section>
	<form name="smsForm" id="smsForm" method="post" action="${pageContext.request.contextPath}/core/manage/setting/sms/save.do">
		<div class="three-quarter last boxed p-twenty clearfix"	data-anim-type="fade-in" data-anim-delay="0">
			<input type="hidden" name="c_id" id="c_id" value="${sms.c_id}"/>
			<div id="samDiv" class="tablet-mobile alpha bm-remove last">
				<div class="responsive-row">
					<div class="one-quarter">SMS 연동 여부</div>
					<div class="one-quarter">
						<input type="checkbox" name="smsUseFl" id="smsUseFl" value="1" <c:if test="${'1' == sms.smsUseFl}">checked</c:if>/>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">SMS 서비스 아이디</div>
					<div class="one-quarter">
						<input name="smsId" id="smsId" type="text" value="${sms.smsId}">
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">SMS 서비스 비밀번호</div>
					<div class="one-quarter">
						<input name="smsPassword" id="smsPassword" type="text" value="${sms.smsPassword}">
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">SMS 서비스 가입 연결</div>
					<div class="one-quarter">
						<a href="" onclick="alert('impl not yet!');">http://www.sms.co.kr/register.do</a>
					</div>
				</div>
				<div id="toggleSms">
					<a href="#" target="_self">» 문자전송하기</a>
				</div>
				<hr/>
				<div id="sendContent" class="has-dropdown" style="display:none;">
					<div class="responsive-row">
						<div class="one-quarter">발송대상</div>
						<div class="one-quarter">
						</div>
					</div>
					<div class="responsive-row">
						<div class="one-quarter">제목</div>
						<div class="one-quarter">
							<input name="smsSubject" id="smsSubject" type="text" value="${sms.smsSubject}">
						</div>
					</div>
					<div class="responsive-row">
						<div class="one-quarter">내용</div>
						<div class="one-quarter">
							<textarea id="smsContent" name="smsContent" class="w-large" placeholder="">${sms.smsContent}</textarea>
						</div>
					</div>
					<div id="divBottom" class="">
					<button id="sendSms" onclick="alert('impl Not yet');return false;">전송</button>
					</div>
				</div>
				<div id="divBottom" class="responsive-row">
					<button id="saveBtn" onclick="inputForm.submit(this.form);return false;">저장</button>
				</div>
			</div>
		</form>	
</section>