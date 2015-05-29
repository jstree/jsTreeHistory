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

<script>
var generalSetting = {
    
    handleEvent : function() {
        
        // TODO 류강하 : 공통 js로 옮겨야 함.
        $('input[type="checkbox"]').each(function() {
            
            this.checked = Number(this.value);
        });
        $('input[type="checkbox"]').on('click', function() {
            
            var $checkbox = $(this);
            
            $checkbox.val( $checkbox.prop('checked') ? 1 : 0 );
        });
        
        var form = 'frmGeneralSetting';
        var $form = $('#' + form);
        
        $form.on('submit', function() {
            
            if (!confirm('저장하시겠습니까?')) {
                return false;
            }
            
            callAjax(form
                   , $form.prop('action')
                   , null
                   , $form.prop('method')
                   , 'json'
                   , null
                   , callback);
            
            function callback(r) {
            }
            
            return false;
        });
    },
        
    init : function() {
        this.handleEvent();
    }
};

$(document).ready(function() {
    generalSetting.init();
});
</script>

<section>
    <form id="frmGeneralSetting" action="save.do" method="post">
        <div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
            <div class="tablet-mobile alpha bm-remove last">
                <div class="responsive-row">
                    <div class="one-quarter">
                       <label for="chkJoinApprovalFl">회원가입 승인여부</label>
                   </div>
                    <div class="one-quarter">
                        <input id="chkJoinApprovalFl" name="joinApprovalFl" type="checkbox" class="chk" value="${generalSetting.joinApprovalFl}" />
                    </div>
                </div>
                <div class="responsive-row">
                    <div class="one-quarter">
                       <label for="chkEmailAuthUseFl">메일인증 사용여부</label>
                   </div>
                    <div class="one-quarter">
                        <input id="chkEmailAuthUseFl" name="emailAuthUseFl" type="checkbox" class="chk" value="${generalSetting.emailAuthUseFl}" />
                    </div>
                </div>
                <div class="responsive-row">
                    <div class="one-quarter">
                       <label for="passwordSecurityLevelCd1">비밀번호 보안수준</label>
                   </div>
                    <div class="one-quarter">
                    <c:forEach var="passwordSecurityLevel" items="${passwordSecurityLevels}" varStatus="status">
                        <c:if test="${!status.first}"><br /></c:if>
                        <input id="passwordSecurityLevelCd${status.index + 1}" name="passwordSecurityLevelCd" type="radio" class="rdo" value="${passwordSecurityLevel.c_id}" <c:if test="${passwordSecurityLevel.c_id == generalSetting.passwordSecurityLevelCd}">checked="checked"</c:if> />
                        <label for="passwordSecurityLevelCd${status.index + 1}">${passwordSecurityLevel.c_title}</label>
                    </c:forEach>
                    </div>
                </div>
                <div class="responsive-row">
                    <div class="one-quarter">
                       <label for="inpPasswordChangeDcnt">비밀번호변경일수</label>
                   </div>
                    <div class="one-quarter">
                        <input id="inpPasswordChangeDcnt" name="passwordChangeDcnt" type="text" value="${generalSetting.passwordChangeDcnt}" placeholder="3자리 이하의 숫자" />일
                    </div>
                </div>
                <div class="responsive-row">
                    <div class="one-quarter">
                       <label for="inpWebMasterNm">웹마스터 이름</label>
                   </div>
                    <div class="one-quarter">
                        <input id="inpWebMasterNm" name="webMasterNm" type="text" value="${generalSetting.webMasterNm}" placeholder="10자리 이하의 문자" />
                    </div>
                </div>
                <div class="responsive-row">
                    <div class="one-quarter">
                       <label for="inpWebMasterEmailAccount">웹마스터 메일주소</label>
                   </div>
                    <div class="one-quarter">
                        <input id="inpWebMasterEmailAccount" name="webMasterEmailAccount" type="text" value="${generalSetting.webMasterEmailAccount}" placeholder="64자리 이하의 이메일 형식 문자" />@
                        <input id="inpWebMasterEmailHost" name="webMasterEmailHost" type="text" value="${generalSetting.webMasterEmailHost}" placeholder="255자리 이하의 이메일 형식 문자" />
                    </div>
                </div>
                <div class="responsive-row">
                    <div class="one-quarter">
                       <label for="inpLoginLimitDcnt">임시 제한일자</label>
                   </div>
                    <div class="one-quarter">
                        <input id="inpLoginLimitDcnt" name="loginLimitDcnt" type="text" value="${generalSetting.loginLimitDcnt}" placeholder="2자리 이하의 숫자" />일
                                                                설정 시 회원 가입 후 정해진 일자동안 인증을 제한합니다.
                    </div>
                </div>
                <div class="responsive-row">
                    <div class="one-quarter">
                       <label for="inpLoginFailureLimitCnt">로그인실패제한횟수</label>
                   </div>
                    <div class="one-quarter">
                        <input id="inpLoginFailureLimitCnt" name="loginFailureLimitCnt" type="text" value="${generalSetting.loginFailureLimitCnt}" placeholder="1자리 숫자" />회
                    </div>
                </div>
                <div class="responsive-row">
                    <div class="one-quarter">
                       <label for="txtNicknameProhibitionWords">금지 닉네임</label>
                    </div>
                    <div class="one-quarter">
                        <textarea id="txtNicknameProhibitionWords" name="nicknameProhibitionWords" placeholder="단어 사이를 개행으로 구분하여 입력"><c:forEach var="nicknameProhibitionWord" items="${nicknameProhibitionWords}" varStatus="status">${nicknameProhibitionWord.c_title}<c:if test="${!status.last}"><customTags:newLine /></c:if></c:forEach></textarea>
                    </div>
                </div>
                <div id="divBottom" class="responsive-row">
                    <button id="btnSave" type="submit">저장</button>
                </div>
            </div>
        </div>
    </form>
</section>