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
var join = {
    
    nicknameDuplicaionChecked : false,
    uniqueNickname : false,
    
    init : function() {
        join.handleEvent();
    },
    
    handleEvent : function() {
        
        (function onChangeNickname() {
            
            var $form = $('#frmJoin');
            
            var $nickname = $form.find('input[name="nickname"]');
            
            $nickname.on('change paste keyup', function(e) {
                
                join.nicknameDuplicaionChecked = false;
                join.uniqueNickname = false;
            });
            
        })();
        
        (function onClickNicknameDuplicationCheckButton() {
            
            $('#btnNicknameDuplicationCheck').on('click', function() {
                
                var $nickname = $('#frmJoin input[name="nickname"]');
                
                var nickname = $nickname.val();
                
                if (!join.validateNicknameFormField(nickname)) {
                    $nickname.focus();
                    return false;
                }
                
                
            });
            
            
            
        })();
        
        (function onSubmitOfJoinForm() {
            
            var $form = $('#frmJoin');
            
            $form.on('submit', function() {
                
                if (!confirm('저장하시겠습니까?')) {
                    return false;
                }
                
                if (!join.validateFormFields()) {
                    return false;
                }
                
                return false;
                
                callAjax($form
                       , $form.prop('action')
                       , null
                       , $form.prop('method')
                       , 'json'
                       , null
                       , null
                       , callback);
                
                function callback(r) {
                    console.log(r);
                }
                
                return false;
            });
        })();
    },
    
    validateNicknameFormField : function(nickname) {
      
        var valid = true;
        
        if (!nickname) {
            alert('닉네임을 입력해주세요.');
            valid = false;
        }
        
        return valid;
    },
    
    validateFormFields : function() {
        
        var $form = $('#frmJoin');
        
        var $emailAccount = $form.find('input[name="emailAccount"]');
        var emailAccount = $emailAccount.val();
        
        if (!emailAccount) {
            alert('이메일 주소를 입력해주세요.');
            $emailAccount.focus();
            return false;
        }
        
        var emailAccountRegExp = /^([\w\.-]+)$/;
        if ( ! emailAccountRegExp.test(emailAccount) ) {
            alert('이메일 주소가 올바르지 않습니다.');
            $emailAccount.focus();
            return false;
        }
        
        var $emailHost = $form.find('input[name="emailHost"]');
        var emailHost = $emailHost.val();
        
        if (!emailHost) {
            alert('이메일 주소를 입력해주세요.');
            $emailHost.focus();
            return false;
        }
        
        var emailHostRegExp = /^([a-z\d\.-]+)\.([a-z\.]{2,6})$/;
        if ( ! emailHostRegExp.test(emailHost) ) {
            alert('이메일 주소가 올바르지 않습니다.');
            $emailHost.focus();
            return false;
        }
        
        var $password = $form.find('input[name="password"]');
        var password = $password.val();
        
        if (!password) {
            alert('비밀번호를 입력해주세요.');
            $password.focus();
            return false;
        }
        
        var passwordRegExp = /^[a-z0-9]{8,256}$/;
        if ( ! passwordRegExp.test(password) ) {
            alert('비밀번호가 올바르지 않습니다.');
            $password.focus();
            return false;
        }
        
        var $passwordConfirm = $form.find('input[name="passwordConfirm"]');
        var passwordConfirm = $passwordConfirm.val();
        
        if (!passwordConfirm || password != passwordConfirm) {
            alert('비밀번호를 동일하게 한 번 더 입력해주세요.');
            $passwordConfirm.focus();
            return false;
        }
        
        var passwordRegExp = /^[a-z0-9]{8,256}$/;
        if ( ! passwordRegExp.test(passwordConfirm) ) {
            alert('비밀번호가 올바르지 않습니다.');
            $passwordConfirm.focus();
            return false;
        }
        
        var $nickname = $form.find('input[name="nickname"]');
        var nickname = $nickname.val();
        
        if (!join.validateNicknameFormField()) {
            $nickname.focus();
            return false;
        }
        
        if (!join.nicknameDuplicaionChecked) {
            alert('닉네임 중복체크 버튼을 눌러 중복된 닉네임인지 확인해주세요.');
            return false;
        }
        if (!join.uniqueNickname) {
            alert('닉네임 중복체크 버튼을 눌러 중복된 닉네임인지 확인해주세요.');
            $nickname.focus();
            return false;
        }
        
        
        
        
        // 비밀번호찾기질문
        // 비밀번호찾기답변
        
        // 홈페이지
        // 블로그
        // 서명
        // 프로필사진
        // 사용자아이콘
        
        
        var reUrl = /^(https?:\/\/)?([a-z\d\.-]+)\.([a-z\.]{2,6})([\/\w\.-]*)*\/?$/; // URL 검사식
        
        return false;
    }
    
};

$(document).ready(function() {
    join.init();
});
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
                <form id="frmJoin" action="join.do" method="post">
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
                            <input name="password" type="password" placeholder="영문 소문자, 숫자를 포함한 8~256자" style="width:240px" />
                        </label>
                    </div>
                    <div>
                        <label>
                            비밀번호 확인<span class="essential">*</span>
                            <input name="passwordConfirm" type="password" placeholder="영문 소문자, 숫자를 포함한 8~256자" style="width:240px" />
                        </label>
                    </div>
                    <div>
                        <label>
                            닉네임<span class="essential">*</span>
                            <input name="nickname" type="text" style="width:200px" />
                        </label>
                        <button id="btnNicknameDuplicationCheck" type="button" class="compact">중복체크</button>
                    </div>
                    <div>
                        <label>
                            메일링 서비스 설정
                            <label><input name="mailingServiceUseFl" type="radio" checked="checked" />예</label>
                            <label><input name="mailingServiceUseFl" type="radio" />아니오</label>
                        </label>
                    </div>
                    <div>
                        <label>
                            정보공개 설정
                            <label><input name="indiInfoOpenFl" type="radio" checked="checked" />전체공개</label>
                            <label><input name="indiInfoOpenFl" type="radio" />거부</label>
                        </label>
                    </div>
                    <div class="divButtons">
                        <button type="submit" class="compact">가입하기</button>
                    </div>
                </form>
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