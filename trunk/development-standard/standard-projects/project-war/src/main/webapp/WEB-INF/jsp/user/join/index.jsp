<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko" class="js">
<head>
<title>${pageName}</title>
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
.divButtons {
    float : right;
}
</style>
<script type="text/javascript" id="script">
var join = {
    
    emailDuplicaionChecked : false,
    uniqueEmail : false,
    passwordSecurityLevelCd : '${generalSetting.passwordSecurityLevelCd}',
    nicknameDuplicaionChecked : false,
    uniqueNickname : false,
    
    init : function() {
        join.handleEvent();
    },
    
    handleEvent : function() {
        
        (function onChangeEmail() {
            
            var $emails = $('#frmJoin').find('input[name="emailAccount"], input[name="emailHost"]');
            
            $emails.on('change paste keyup', function(e) {
                
                join.emailDuplicaionChecked = false;
                join.uniqueEmail = false;
            });
        })();
        
        (function onChangeNickname() {
            
            var $nickname = $('#frmJoin input[name="c_title"]');
            
            $nickname.on('change paste keyup', function(e) {
                
                join.nicknameDuplicaionChecked = false;
                join.uniqueNickname = false;
            });
        })();
        
        (function onClickEmailDuplicationCheckButton() {
            
            $('#btnEmailDuplicationCheck').on('click', function() {
                
                if ( !join.validateEmailFormFields() ) {
                    return false;
                }
                
                var $form = $('#frmJoin');
                var emailAccount = $form.find('input[name="emailAccount"]').val();
                var emailHost = $form.find('input[name="emailHost"]').val();
                
                var param = {
                    email : emailAccount + '@' + emailHost
                };
                
                callAjax(null
                       , '${pageContext.request.contextPath}/user/info/isDuplicateEmail.do'
                       , null
                       , 'post'
                       , 'json'
                       , param
                       , 'application/json'
                       , callback);
                 
                 function callback(r) {
                     
                     if (r.status) {
                         join.emailDuplicaionChecked = false;
                         join.uniqueEmail = false;
                         alert('중복된 이메일입니다. 다시 입력해주세요.');
                     } else {
                         join.emailDuplicaionChecked = true;
                         join.uniqueEmail = true;
                         alert('사용할 수 있는 이메일입니다.');
                     }
                 }
            });
        })();
        
        (function onClickNicknameDuplicationCheckButton() {
            
            $('#btnNicknameDuplicationCheck').on('click', function() {
                
                var $nickname = $('#frmJoin input[name="c_title"]');
                
                var nickname = $nickname.val();
                
                if (!join.validateNicknameFormField(nickname)) {
                    $nickname.focus();
                    return false;
                }
                
                var param = {
                    c_title : nickname
                };
                
                callAjax(null
                       , '${pageContext.request.contextPath}/user/info/isDuplicateNickname.do'
                       , null
                       , 'post'
                       , 'json'
                       , param
                       , 'application/json'
                       , callback);
                 
                 function callback(r) {
                     
                     if (r.status) {
                         join.nicknameDuplicaionChecked = false;
                         join.uniqueNickname = false;
                         alert('중복된 닉네임입니다. 다시 입력해주세요.');
                     } else {
                         join.nicknameDuplicaionChecked = true;
                         join.uniqueNickname = true;
                         alert('사용할 수 있는 닉네임입니다.');
                     }
                 }
            });
        })();
        
        (function onSubmitOfJoinForm() {
            
            var $form = $('#frmJoin');
            
            $form.on('submit', function() {
                
                if (!join.validateFormFields()) {
                    return false;
                }
                
                if (!confirm('전송하시겠습니까?')) {
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
                        alert('저장되었습니다.');
                        if (location.href.indexOf('/user/join') > -1) {
                            location.href = '<c:url value="/user/login/index.do" />';
                        }
                    }
                }
                
                return false;
            });
        })();
    },
    
    validateEmailFormFields : function() {
        
        var $form = $('#frmJoin');
        
        var $emailAccount = $form.find('input[name="emailAccount"]');
        var emailAccount = $emailAccount.val();
        
        if (! $.trim(emailAccount) ) {
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
        
        if (! $.trim(emailHost) ) {
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
        
        var $form = $('#frmJoin');
        
        if ( !join.validateEmailFormFields() ) {
            return false;
        }
        
        if (!join.emailDuplicaionChecked) {
            alert('이메일 중복체크 버튼을 눌러 중복된 이메일인지 확인해주세요.');
            return false;
        } 
        else if (!join.uniqueEmail) {
            alert('이메일 중복체크 버튼을 눌러 중복된 이메일인지 확인해주세요.');
            return false;
        }
        
        var $password = $form.find('input[name="password"]');
        var password = $password.val();
        
        if (! $.trim(password) ) {
            alert('비밀번호를 입력해주세요.');
            $password.focus();
            return false;
        }
        
        if (join.passwordSecurityLevelCd == 3) {
            if (password.length < 4) {
                alert('비밀번호를 4자 이상 입력해주세요.');
                $password.focus();
                return false;
            }
        }
        else if (join.passwordSecurityLevelCd == 4) {
            if ( ! /^(?=\w{6,}$)(?=.*\d)(?=.*[a-zA-Z]).*/.test(password) ) {
                alert('비밀번호를 6자 이상, 영문자/숫자 조합하여 입력해주세요.');
                $password.focus();
                return false;
            }
        }
        else if (join.passwordSecurityLevelCd == 5) {
            if ( ! /^(?=^.{8,}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[\`\~\!\@\#\$\%\^\&\*\(\)\-\_\=\+\[\{\]\}\\\|\;\:\'\"\,\<\.\>\/\?]).*$/.test(password) ) {
                alert('비밀번호를 8자 이상, 영문자/숫자/특수문자를 조합하여 입력해주세요.');
                $password.focus();
                return false;
            }
        }
        
        var $passwordConfirm = $form.find('input[name="passwordConfirm"]');
        var passwordConfirm = $passwordConfirm.val();
        
        if (! $.trim(passwordConfirm) || password != passwordConfirm) {
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
        
        if ( !join.validateNicknameFormField(nickname) ) {
            $nickname.focus();
            return false;
        }
        
        if (!join.nicknameDuplicaionChecked) {
            alert('닉네임 중복체크 버튼을 눌러 중복된 닉네임인지 확인해주세요.');
            return false;
        }
        else if (!join.uniqueNickname) {
            alert('닉네임 중복체크 버튼을 눌러 중복된 닉네임인지 확인해주세요.');
            return false;
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
                <form id="frmJoin" action="${pageContext.request.contextPath}/user/join/join.do" method="post">
                    <div>
                        <label>
                                                  이메일 주소<span class="essential">*</span>
                            <input name="emailAccount" type="text" placeholder="64자리 이하의 이메일 형식 문자" style="width:210px" />@
                            <input name="emailHost" type="text" placeholder="255자리 이하의 이메일 형식 문자" style="width:220px" />
                            <button id="btnEmailDuplicationCheck" type="button" class="compact">중복체크</button>
                        </label>
                    </div>
                    <div>
                        <label>
                                                  비밀번호<span class="essential">*</span>
                            <input name="password" type="password" placeholder="${generalSetting.passwordSecurityLevel}" style="width:335px" />
                        </label>
                    </div>
                    <div>
                        <label>
                                                  비밀번호 확인<span class="essential">*</span>
                            <input name="passwordConfirm" type="password" placeholder="${generalSetting.passwordSecurityLevel}" style="width:335px" />
                        </label>
                    </div>
                    <div>
                        <label>
                                                비밀번호 찾기 질문<span class="essential">*</span>
                           <select name="pwdFindQuestionCd">
	                       <c:forEach var="passwordFindQuestion" items="${passwordFindQuestions}" varStatus="status">
	                           <option value="${passwordFindQuestion.c_id}">${passwordFindQuestion.c_title}</option>
	                       </c:forEach>
	                       </select>
                        </label>
                    </div>
                    <div>
                        <labe>
                                                   비밀번호 찾기 답변<span class="essential">*</span>
                            <input name="pwdFindAnswer" type="text" style="width:240px" />
                        </labe>
                    </div>
                    <div>
                        <label>
                                                  닉네임<span class="essential">*</span>
                            <input name="c_title" type="text" style="width:200px" />
                        </label>
                        <button id="btnNicknameDuplicationCheck" type="button" class="compact">중복체크</button>
                    </div>
                    <div>
                        <label>
                                                  메일링 서비스 설정
                            <label><input name="mailingServiceUseFl" type="radio" value="1" checked="checked" />예</label>
                            <label><input name="mailingServiceUseFl" type="radio" value="0" />아니오</label>
                        </label>
                    </div>
                    <div>
                        <label>
                                                  정보공개 설정
                            <label><input name="indiInfoOpenFl" type="radio" value="1" checked="checked" />전체공개</label>
                            <label><input name="indiInfoOpenFl" type="radio" value="0" />거부</label>
                        </label>
                    </div>
                    <div class="divButtons">
                        <button id="btnJoin" type="submit" class="compact">가입하기</button>
                    </div>
                </form>
                </div>
            </div>
        </article>
    </section>
</body>
</html>