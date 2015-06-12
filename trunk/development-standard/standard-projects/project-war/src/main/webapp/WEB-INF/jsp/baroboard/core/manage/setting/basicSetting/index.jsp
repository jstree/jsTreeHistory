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
</script>
<section>
	<form name="basicSettingForm" id="basicSettingForm" method="post" action="${pageContext.request.contextPath}/core/manage/setting/basicSetting/save.do">
		<div class="three-quarter last boxed p-twenty clearfix"	data-anim-type="fade-in" data-anim-delay="0">
			<input type="hidden" name="c_id" id="c_id" value="${basicSetting.c_id}"/>
			<div id="samDiv" class="tablet-mobile alpha bm-remove last">
				<div class="responsive-row">
					<div class="one-quarter">사이트제목 </div>
					<div class="one-quarter">
						<input name="siteTitle" id="siteTitle" type="text" value="${basicSetting.siteTitle}">
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">기본언어</div>
					<div class="one-quarter">
						<select name="basicLanguageId" id="basicLanguageId">
						<c:forEach var="list" items="${basicLanguageList}" varStatus="status">
							<option value="<c:out value="${list.c_id}" />" 
								<c:if test="${list.c_id == basicSetting.basicLanguageId}">selected="selected"</c:if>>
								<c:out value="${list.c_title}" />
							</option>
						</c:forEach>
						</select>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">현지시간 및 포맷 설정</div>
					<div class="one-quarter">
						<select name="localTimeId" id="localTimeId">
						<c:forEach var="list" items="${localTimeList}" varStatus="status">
							<option value="<c:out value="${list.c_id}" />" 
								<c:if test="${list.c_id == basicSetting.localTimeId}">selected="selected"</c:if>>
								<c:out value="${list.c_title}" />
							</option>
						</c:forEach>
						</select>
						<select name="timeFormatId" id="timeFormatId">
							<c:forEach var="list" items="${timeFormatList}" varStatus="status">
								<option value="<c:out value="${list.c_id}" />" 
									<c:if test="${list.c_id == basicSetting.timeFormatId}">selected="selected"</c:if>>
									<c:out value="${list.c_title}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="responsive-row ">
					<div class="one-quarter">썸네일 생성방법</div>
					<div class="one-quarter">					
						<c:forEach var="list" items="${thumCreateMethodList}" varStatus="status">
							<input type="radio" name="thumCreatMethodId" value="<c:out value="${list.c_id}" /> " 
								<c:if test="${list.c_id == basicSetting.thumCreatMethodId}"> checked="checked"</c:if>>
								<c:out value="${list.c_title}" />
							</input>
						</c:forEach>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">파비콘 지정</div>
					<div class="one-quarter">
					<input type="checkbox" name="faviconUseFl" id="faviconUseFl" value="1" <c:if test="${'1' == basicSetting.faviconUseFl}">checked</c:if>/>적용여부
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">모바일 홈화면 아이콘</div>
					<div class="one-quarter">
					<input type="checkbox" name="mobileIconApplyFl" id="mobileIconApplyFl" value="1" <c:if test="${'1' == basicSetting.mobileIconApplyFl}">checked</c:if>/>적용여부
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">홈페이지 레이아웃 설정</div>
					<div class="one-quarter">
						<select name="layoutId" id="layoutId">
							<c:forEach var="list" items="${layoutList}" varStatus="status">
								<option value="<c:out value="${list.c_id}" />" 
									<c:if test="${list.c_id == basicSetting.layoutId}">selected="selected"</c:if>>
									<c:out value="${list.c_title}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">iframe, object/embed 허용 URL 설정</div>
					<div class="one-quarter">
						<textarea id="" name="" class="w-large" placeholder=""></textarea>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">접근허용 IP 설정</div>
					<div class="one-quarter">
						<textarea id="" name="" class="w-large" placeholder=""></textarea>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">접근 불 가능 시 보여지는 페이지 문구 설정</div>
					<div class="one-quarter">
						<textarea id="accesProhWords" name="accesProhWords" class="w-large" placeholder="">${basicSetting.accesProhWords}</textarea>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">회원가입 사용여부 설정</div>
					<div class="one-quarter">
						<input type="checkbox" name="userJoinUseFl" id="userJoinUseFl" value="1" <c:if test="${'1' == basicSetting.userJoinUseFl}">checked</c:if>/>
						회원관리 컴포넌트가 반드시 필요합니다
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">하단 스크립트 설정</div>
					<div class="one-quarter">
						<textarea id="footerScript" name="footerScript" class="w-large" placeholder="">${basicSetting.footerScript}</textarea>
					</div>
				</div>
				<div id="divBottom" class="responsive-row">
					<button id="saveBtn" onclick="inputForm.submit(this.form);return false;">저장</button>
				</div>
			</div>
		</form>	
</section>