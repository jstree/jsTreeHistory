<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
<head>
<title>회원정보 수정</title>
<style type="text/css" id="style">
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
select {
    height: 100%;
}
select {
    display: inline !important;
}

.essential {
    color : red;
}
.compact {
    min-width : 71px;
    min-height : 37px;
}
.hidden {
    display : none;
}
.divButtons {
    text-align : right;
}
</style>
<script type="text/javascript" id="script">
var userInfo = {
    
    nickname : '${user.c_title}',
    
    passwordSecurityLevelCd : '${generalSetting.passwordSecurityLevelCd}',
    nicknameDuplicaionChecked : false,
    uniqueNickname : false,
    
    init : function() {
        userInfo.handleEvent();
    },
    
    handleEvent : function() {
        
        (function onChangeNickname() {
            
            var $nickname = $('#frmUserInfo input[name="c_title"]');
            
            $nickname.on('change paste keyup', function(e) {
                
                userInfo.nicknameDuplicaionChecked = false;
                userInfo.uniqueNickname = false;
            });
        })();
        
        (function onClickNicknameDuplicationCheckButton() {
            
            $('#btnNicknameDuplicationCheck').on('click', function() {
                
                var $nickname = $('#frmUserInfo input[name="c_title"]');
                
                var nickname = $nickname.val();
                
                if (!userInfo.validateNicknameFormField(nickname)) {
                    $nickname.focus();
                    return false;
                }
                
                var param = {
                    c_title : nickname
                };
                
                callAjax(null
                       , '${pageContext.request.contextPath}/user/info/isAvailableNickname.do'
                       , null
                       , 'post'
                       , 'json'
                       , param
                       , 'application/json'
                       , callback);
                 
                function callback(r) {
                    
                    if (r.status) {
                        userInfo.nicknameDuplicaionChecked = true;
                        userInfo.uniqueNickname = true;
                    } else {
                        userInfo.nicknameDuplicaionChecked = false;
                        userInfo.uniqueNickname = false;
                    }
                    
                    alert(r.ajaxMessage);
                }
            });
        })();
        
        (function onChangeNickname() {
            
            $('#frmUserInfo input[name="c_title"]').on('input propertychange paste', function() {
                
                if (this.value == userInfo.nickname) {
                    $('#btnNicknameDuplicationCheck').addClass('hidden');
                }
                else {
                    $('#btnNicknameDuplicationCheck').removeClass('hidden');
                }
            });
        })();
        
        (function onSubmitOfJoinForm() {
            
            var $form = $('#frmUserInfo');
            
            $form.on('submit', function() {
                
                if (!userInfo.validateFormFields()) {
                    return false;
                }
                
                if (!confirm('회원정보를 수정 하시겠습니까?')) {
                    return false;
                }
                
                callAjax($form
                       , $form.prop('action')
                       , null
                       , $form.prop('method')
                       , 'json'
                       , null
                       , null
                       , callback);
                
                function callback(r) {
                    
                    if (r.status) {
                        alert('수정되었습니다.');
                    }
                }
                
                return false;
            });
        })();
    },
    
    validatePasswordFormField : function($password) {
        
        var password = $password.val();
        
        if ($password.prop('name') == 'currentPassword') {
            
            if (! $.trim(password) ) {
                alert('비밀번호를 입력해주세요.');
                $password.focus();
                return false;
            }
        }
        
        if (password.length > 0) {
            
            if (userInfo.passwordSecurityLevelCd == 3) {
                if (password.length < 4) {
                    alert('비밀번호를 4자 이상 입력해주세요.');
                    $password.focus();
                    return false;
                }
            }
            else if (userInfo.passwordSecurityLevelCd == 4) {
                if ( ! /^(?=\w{6,}$)(?=.*\d)(?=.*[a-zA-Z]).*/.test(password) ) {
                    alert('비밀번호를 6자 이상, 영문자/숫자 조합하여 입력해주세요.');
                    $password.focus();
                    return false;
                }
            }
            else if (userInfo.passwordSecurityLevelCd == 5) {
                if ( ! /^(?=^.{8,}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[\`\~\!\@\#\$\%\^\&\*\(\)\-\_\=\+\[\{\]\}\\\|\;\:\'\"\,\<\.\>\/\?]).*$/.test(password) ) {
                    alert('비밀번호를 8자 이상, 영문자/숫자/특수문자를 조합하여 입력해주세요.');
                    $password.focus();
                    return false;
                }
            }
        }
        
        return true;
    },
    
    validateNicknameFormField : function(nickname) {
      
        var valid = true;
        
        if (! $.trim(nickname) ) {
            alert('닉네임을 입력해주세요.');
            valid = false;
        }
        
        return valid;
    },
    
    validateFormFields : function() {
        
        var $form = $('#frmUserInfo');
        
        var $currentPassword = $form.find('input[name="currentPassword"]');
        
        if (! userInfo.validatePasswordFormField($currentPassword) ) {
            return false;
        }
        
        var $password = $form.find('input[name="password"]');
        var password = $password.val();
        
        if (! userInfo.validatePasswordFormField($password) ) {
            return false;
        }
        
        var $passwordConfirm = $form.find('input[name="passwordConfirm"]');
        var passwordConfirm = $passwordConfirm.val();
        
        if (passwordConfirm != password) {
            alert('비밀번호를 동일하게 한 번 더 입력해주세요.');
            $passwordConfirm.focus();
            return false;
        }
        
        var $passwordFindAnswer = $form.find('input[name="pwdFindAnswer"]');
        var passwordFindAnswer = $passwordFindAnswer.val();
        
        if (! $.trim(passwordFindAnswer) ) {
            alert('비밀번호 찾기 답변을 입력해주세요.');
            $passwordFindAnswer.focus();
            return false;
        }
        
        var $nickname = $form.find('input[name="c_title"]');
        var nickname = $nickname.val();
        
        if ( !userInfo.validateNicknameFormField(nickname) ) {
            $nickname.focus();
            return false;
        }
        
        if (userInfo.nickname != nickname) {
            
            if (!userInfo.nicknameDuplicaionChecked) {
                alert('닉네임 중복체크 버튼을 눌러 중복된 닉네임인지 확인해주세요.');
                return false;
            }
            else if (!userInfo.uniqueNickname) {
                alert('닉네임 중복체크 버튼을 눌러 중복된 닉네임인지 확인해주세요.');
                return false;
            }
        }
        
        // 홈페이지
        // 블로그
        // 서명
        // 프로필사진
        // 사용자아이콘
        //var reUrl = /^(https?:\/\/)?([a-z\d\.-]+)\.([a-z\.]{2,6})([\/\w\.-]*)*\/?$/; // URL 검사식
        
        return true;
    }
};

$(document).ready(function() {
    $('#tabs').tabs();
    
    userInfo.init();
});
</script>
</head>
<body>
<section class="clearfix">
    <nav>
        <div class="container bm-medium">
            <div class="one-whole">
                <div class="no-display">회원정보 수정</div>
            </div>
        </div>
    </nav>
    <article>
        <div class="clearfix">
            <div class="container bm-remove">
                <div id="tabs">
			        <ul>
			            <li><a href="#tabUserInfo">회원정보 수정</a></li>
			            <li><a href="#tabWHAT">쪽지함</a></li>
			            <li><a href="#tabWHAT">포인트</a></li>
			        </ul>
			        <div id="tabUserInfo">
						<form id="frmUserInfo" action="${pageContext.request.contextPath}/user/info/modify.do" method="post">
						    <div>
						        <label>
						                      이메일 주소<span class="essential">*</span>
						            <input name="emailAccount" type="text" value="${user.emailAccount}" readonly="readonly" style="width:210px" />@
						            <input name="emailHost" type="text" value="${user.emailHost}" readonly="readonly" style="width:220px" />
						        </label>
						    </div>
						    <div>
						        <label>
						                      현재 비밀번호<span class="essential">*</span>
						            <input name="currentPassword" type="password" placeholder="${generalSetting.passwordSecurityLevel}" style="width:335px" />
						        </label>
						    </div>
						    <div>
						        <label>
						                      새 비밀번호
						            <input name="password" type="password" placeholder="${generalSetting.passwordSecurityLevel}" style="width:335px" />
						        </label>
						    </div>
						    <div>
						        <label>
						                      새 비밀번호 확인
						            <input name="passwordConfirm" type="password" placeholder="${generalSetting.passwordSecurityLevel}" style="width:335px" />
						        </label>
						    </div>
						    <div>
						        <label>
						                      비밀번호 찾기 질문<span class="essential">*</span>
					                <select name="pwdFindQuestionCd">
						            <c:forEach var="passwordFindQuestion" items="${passwordFindQuestions}" varStatus="status">
						                <option value="${passwordFindQuestion.c_id}" <c:if test="${passwordFindQuestion.c_id == user.pwdFindQuestionCd}">selected="selected"</c:if>>${passwordFindQuestion.c_title}</option>
						            </c:forEach>
						            </select>
						        </label>
						    </div>
						    <div>
						        <labe>
						                      비밀번호 찾기 답변<span class="essential">*</span>
						            <input name="pwdFindAnswer" type="text" value="${user.pwdFindAnswer}" style="width:240px" />
						        </labe>
						    </div>
						    <div>
						        <label>
						                      닉네임<span class="essential">*</span>
						            <input name="c_title" type="text" value="${user.c_title}" style="width:200px" />
						        </label>
						        <button id="btnNicknameDuplicationCheck" type="button" class="compact hidden">중복체크</button>
						    </div>
						    <div>
						        <label>
						                      메일링 서비스 설정
						            <label><input name="mailingServiceUseFl" type="radio" value="1" <c:if test="${user.mailingServiceUseFl == 1}">checked="checked"</c:if> />예</label>
						            <label><input name="mailingServiceUseFl" type="radio" value="0" <c:if test="${user.mailingServiceUseFl == 0}">checked="checked"</c:if> />아니오</label>
						        </label>
						    </div>
						    <div>
						        <label>
						                      정보공개 설정
						            <label><input name="indiInfoOpenFl" type="radio" value="1" <c:if test="${user.indiInfoOpenFl == 1}">checked="checked"</c:if> />전체공개</label>
						            <label><input name="indiInfoOpenFl" type="radio" value="0" <c:if test="${user.indiInfoOpenFl == 0}">checked="checked"</c:if> />거부</label>
						        </label>
						    </div>
						    <div class="divButtons">
						        <button type="submit" class="compact">수정하기</button>
						    </div>
						    <input name="c_id" type="hidden" value="${user.c_id}" />
						</form>
			        </div>
			        <div id="tabWHAT">
			            
			        </div>
			        <div id="tabWHAT">
			            
			        </div>
			    </div>
            </div>
        </div>
    </article>
</section>
</body>
</html>