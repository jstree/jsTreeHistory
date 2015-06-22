<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags" %>

<!DOCTYPE html>
<html lang="ko" class="js">
<head>
<title>${pageName}</title>
<!-- !!!  FOR THIS PAGE ONLY !!! -->

<style>
/* #thead{
	outline-width: 0px;
}
#boardTable {
	width: 100%;
}

.font-bold {
	font-weight: bold;
	font-size: 25px;
} */

label {
	margin-bottom : 0 !important;
}
input[type="text"], input[type="password"] {
	/* width: 192px !important; */
    height: 30px !important;
    display: inline !important;
}
input[type="radio"] {
    /* width: 13px !important;
    height: 13px !important; */
}

.essential {
	color : red;
}
.compact {
	min-width : 71px;
    min-height : 37px;
}
.divButtons {
	float : right;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	
});
//<![CDATA[
jQuery( function($) { 
	var rePw = /^[a-z0-9_-]{6,18}$/; // 비밀번호 검사식
	var reMail = /^([\w\.-]+)@([a-z\d\.-]+)\.([a-z\.]{2,6})$/; // 이메일 검사식
	var reUrl = /^(https?:\/\/)?([a-z\d\.-]+)\.([a-z\.]{2,6})([\/\w\.-]*)*\/?$/; // URL 검사식
	
	var 
		form = $('#frmUserRegister'), 
		pwd = $('#password');
		//url = $('#url');
		
	 form.submit( function() {
		result=true;
		result = FieldCheck() == true ? true : false;
		if(result == true){
			result = availability() == true ? true : false;
		}
		return result;
	});	
	
	function availability(){
		mail = $('#mailId').val() + "@" + $('#mailUrl').val();
		result = true;
		if(rePw.test(pwd.val()) != true) { // 비밀번호 검사
			alert('유효한 암호를 입력해 주세요.');
			$('#password').focus();
			result = false;
			return result;
		} 
		if(reMail.test(mail) != true) { // 이메일 검사
			alert('유효한 이메일 주소를 입력해 주세요.');
			$('#mailId').focus();
			result = false;
			return result;
		} 
		return result;
	}
	
	$('#password').keyup(function(){
	    $('#passwordCheckResult').text('');//제거
	});
	
	//암호 확인 기능 구현
	$('#passwordComfirm').keyup(function(){
	    if($('#password').val() != $('#passwordComfirm').val()){
			$('#passwordCheckResult').val('');
			$('#passwordCheckResult').val('비밀 번호가 일치 하지 않습니다.');
		}else{
			$('#passwordCheckResult').val('');
			$('#passwordCheckResult').val('비밀 번호가 일치 합니다.');
		}
	});
	
	function FieldCheck(){
		// form안의 모든 text type 조회
		
		var txtEle = $('#frmUserRegister input[type=text]');
		for(var i = 0; i < txtEle.length; i ++){
		// console.log($(txtEle[i]).val());
			if('' == $(txtEle[i]).val() || null == $(txtEle[i]).val()){
				var eleName = $(txtEle[i]).attr('name');
				showAlert(eleName);
				result = false;
				return result;
			}
		}
		
		var pwdEle = $('#frmUserRegister input[type=password]');
		for(var i = 0; i < pwdEle.length; i ++){
			if('' == $(pwdEle[i]).val() || null == $(pwdEle[i]).val()){
				var pwdEle = $(pwdEle[i]).attr('name');
				showAlert(pwdEle);
				result = false;
				return result;
			}
		}
		
		if($(pwdEle[0]).val() != $(pwdEle[1]).val()){
			eleName = $(pwdEle[i]).attr('name');
			alert('패스워드 값이 일치하지 않습니다.');
			result = false;
		}
		
		return result;
	}
	
	function showAlert(eleName){
		alert(eleName + ' 값은 필수 입력 입니다 입력을 해주세요.');
		// 해당 id에 focus.
		$('#' + eleName).focus();
	}
});
//]]>
</script>
</head>
<body>
	<section class="clearfix">
		<nav>
			<div class="container bm-medium">
				<div class="one-whole">
					<div class="no-display">agreement</div>
				</div>
			</div>
		</nav>
		<article>
			<div class="clearfix">
				<div class="container bm-remove">
					<div>
						<label>
							이메일 주소<span class="essential">*</span>
							<input name="emailAccount" type="text" placeholder="64자리 이하의 이메일 형식 문자" style="width:210px" />@
							<input name="emailHost" type="text" placeholder="255자리 이하의 이메일 형식 문자" style="width:220px" />
						</label>
					</div>
					<div>
						<label>
							비밀번호<span class="essential">*</span>
							<input name="password" type="password" style="width:200px" />
						</label>
					</div>
					<div>
						<label>
							비밀번호 확인<span class="essential">*</span>
							<input name="passwordConfirm" type="password" style="width:200px" />
						</label>
					</div>
					<div>
						<label>
							닉네임<span class="essential">*</span>
							<input name="nickname" type="text" style="width:200px" />
						</label>
						<button id="btnDuplicateNicknameCheck" type="button" class="compact">중복체크</button>
					</div>
					<div>
						<label>
							본인 인증<span class="essential">*</span>
							<button id="btnMobileAuthentication" type="button" class="compact">휴대폰 인증</button>
						</label>
						<p style="display:inline">휴대폰 인증을 눌러 본인 인증을 해주세요.</p>
					</div>
					<div>
						<label>
							메일링 서비스 설정
							<label><input name="mailingServiceUseFl" type="radio" />예</label>
							<label><input name="mailingServiceUseFl" type="radio" />아니오</label>
						</label>
					</div>
					<div>
						<label>
							정보공개 설정
							<label><input name="indiInfoOpenFl" type="radio" />전체공개</label>
							<label><input name="indiInfoOpenFl" type="radio" />거부</label>
						</label>
					</div>
					<div class="divButtons">
	                    <button id="btnJoin" type="submit" class="compact">가입하기</button>
	                </div>
				</div>
			</div>
		</article>
	</section>
<!-- 
	<section class="clearfix">
		<nav>
			<div class="container bm-medium">
				<div class="one-whole">
					<div class="no-display">agreement</div>
				</div>
			</div>
		</nav>
		<article>
			<div class="clearfix">
				<div class="container bm-remove">
					<form id="frmUserRegister" action="${pageContext.request.contextPath}/user/join/register/save.do" method="post">
						<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
							<div class="tablet-mobile alpha bm-remove last">
								<div>
									<table id="boardTable" class="board-table display">
										<tbody>
											<tr>
												<td class="dt-center" width="30%">이메일 주소*</td>
												<td class="dt-center" width="10%"></td>
												<td class="dt-center" width="10%">
													<input name="메일아이디" id="mailId" type="text">
												</td>
												<td class="dt-center" width="5%">
													@
												</td>
												<td class="dt-center" width="10%">
													<input name="메일주소" id="mailUrl" type="text">
												</td>
												<td class="dt-center" width="35%" colspan="3"></td>
											</tr>
											<tr>
												<td class="dt-center" width="30%">비밀번호*</td>
												<td class="dt-center" width="10%"></td>
												<td class="dt-center" width="25%" colspan="3">
													<input name="패스워드" id="password" type="password">
												</td>
												<td class="dt-center" width="35%" colspan="3"></td>
											</tr>
											<tr>
												<td class="dt-center" width="30%">비밀번호확인*</td>
												<td class="dt-center" width="10%"></td>
												<td class="dt-center" width="25%" colspan="3">
													<input name="패스워드 확인" id="passwordComfirm" type="password">
												</td>
												<td class="dt-center" width="35%" colspan="3">
													<input id="passwordCheckResult" type="text"  style="border: 0px;" value="패스워드를 입력하세요" readonly>
												</td>
											</tr>
											<tr>
												<td class="dt-center" width="30%">닉네임*</td>
												<td class="dt-center" width="10%"></td>
												<td class="dt-center" width="25%" colspan="3">
													<input name="닉네임" id="nickName" type="text">
												</td>
												<td class="dt-center" width="5%"></td>
												<td class="dt-center" width="15%">
													<button id="repeatedNickName" type="submit">중복체크</button>
												</td>
												<td class="dt-center" width="15%">
													<input id="nickNameCheckResult" type="text"  style="border: 0px;" value="중복 체크 하세요" readonly>
												</td>
											</tr>
											<tr>
												<td class="dt-center" width="30%">본인 인증*</td>
												<td class="dt-center" width="10%"></td>
												<td class="dt-center" width="25%" colspan="3">
													<button id="moblieCertification" type="submit">휴대폰인증</button>
												</td>
												<td class="dt-center" width="35%" colspan="3">
													휴대폰 인증을 눌러 본인 인증을 해주세요
												</td>
											</tr>
											<tr>
												<td class="dt-center" width="30%">메일실 서비스 설정</td>
												<td class="dt-center" width="10%"></td>
												<td class="dt-center" width="60%" colspan="6">
													<input type="checkbox" id="mailingServiceFl" value="1"checked="checked">예
													<input type="checkbox" id="mailingServiceFl" value="0">아니오
												</td>
											</tr>
											<tr>
												<td class="dt-center" width="30%">정보공개 설정</td>
												<td class="dt-center" width="10%"></td>
												<td class="dt-center" width="60%" colspan="6">
													<input type="checkbox" id="indiInfoOpenFl" value="1"checked="checked">예
									   				<input type="checkbox" id="indiInfoOpenFl"  value="0">아니오
												</td>
											</tr>
											<tr>
												<td align="right" width="100%" colspan="8">
													<button id="btnNext" type="submit">저장하기</button>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</article>
	</section>
 -->
</body>
</html>