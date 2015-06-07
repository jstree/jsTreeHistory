<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<style type="text/css">
@media only screen and (min-width: 981px) and (max-width: 1199px) { /*981이상 ~ 1199까지*/
    textarea {
        max-width: 400px;
        width: 400px;
    }
}
@media only screen and (min-width: 1200px) { /*1200이상*/
    textarea {
        max-width: 540px;
        width: 540px;
    }
}
.responsive-row {
    width: 100%;
    overflow: auto;
}
.right {
    text-align: right;
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
var basicContents = {
     
    handleEvent : function() {
        
        var form = 'frmBasicContents';
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
    basicContents.init();
});
</script>

<section>
    <form id="frmBasicContents" action="save.do" method="post">
        <div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
            <div class="tablet-mobile alpha bm-remove last">
                <div>
                    <div class="one-quarter">
                       <label for="txtCompanyIntr">회사소개 내용 설정</label>
                    </div>
                    <div class="one-quarter">
                        <textarea id="txtCompanyIntr" name="companyIntr">${basicContents.companyIntr}</textarea>
                    </div>
                </div>
                <div>
                    <div class="one-quarter">
                       <label for="txtTermsOfUse">서비스 이용약관 내용 설정</label>
                    </div>
                    <div class="one-quarter">
                        <textarea id="txtTermsOfUse" name="termsOfUse">${basicContents.termsOfUse}</textarea>
                    </div>
                </div>
                <div>
                    <div class="one-quarter">
                       <label for="txtPrivacyPolicy">개인정보처리방침 내용 설정</label>
                    </div>
                    <div class="one-quarter">
                        <textarea id="txtPrivacyPolicy" name="privacyPolicy">${basicContents.privacyPolicy}</textarea>
                    </div>
                </div>
                <div id="divBottom" class="responsive-row">
                    <button id="btnSave" type="submit">저장하기</button>
                </div>
            </div>
        </div>
    </form>
</section>