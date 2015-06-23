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
	$(document).ready(function(){
		
		// 체크박스 초기 설정
		$("input[type=checkbox]").each(function(){
			
			if( $(this).next().val() == "1" ){
				$(this).click();
			}
		});
		
		// 스팸키워드 초기 설정
		if( '' != "<c:out value='${defaultSetting.spamKeywords}' default=''/>" ){
			
			var spamKeywords = "${defaultSetting.spamKeywords}".split(",");
			
			for( var i = 0; i < spamKeywords.length; i++ ){
				addSpamKeyword( spamKeywords[i] );
			}
		}
	});
	
	// 체크박스 체크 이벤트
	$(document).on("click", "input[type=checkbox]", function(){
		
		if( $(this).prop("checked") ){
			$(this).next().val("1");
		}
		else{
			$(this).next().val("0");
		}
	// 스팸키워드 추가
	}).on("click", "#addSpamKeyword", function(){
		
		addSpamKeyword( $(this).prev().val() );
		return false;
	// 저장
	}).on("click", "#saveBtn", function(){
		
		if( confirm("저장하시겠습니까?") ){
			
			validForm();
			
			callAjax( "basicSettingForm"
	                , "${pageContext.request.contextPath}/board/manager/defaultsetting/save.do"
	                , null
	                , "POST"
	                , 'json'
	                , null
	                , null );
			alert("수정되었습니다.");
		}		
	});
	
	// 유효성 검사
	function validForm(){
		
		var result = true;
		
		$("input[type=text]").each(function(){
			
			if( $(this).attr("id") != "spamKeywords" ){
				
				if( $(this).val() == "" || $(this).val() == null ){
					result = false;
					alert( $(this).parent().prev().text() + " 값을 입력해 주세요." );
					$(this).focus();
				}
			}
		});
		// 금지단어
		setSpamKeywordValueToForm();
		
		return result;
	}
	
	// 금지단어 추가
	function addSpamKeyword( spamKeyword ){
		
		var appendYn = true;
		
		$("#spamArea").children().filter("button").each(function(){
			if( $(this).attr("id") == spamKeyword || spamKeyword == '' ){
				appendYn = false;
			}
		});
		
		if( appendYn ){
			
			$("#spamArea").append("<span>&nbsp;</span><button id='" + spamKeyword 
			                    + "' onClick=\"javascript:deleteSpamKeyword('" + spamKeyword + "')\" >"
			                    + spamKeyword + "(X)</button>");
		}
	}
	
	// 금지단어 삭제
	function deleteSpamKeyword( spamKeyword ){
		
		if( confirm("정말 삭제하시겠습니까?") ){
			
			$("#spamArea").children().filter("#" + spamKeyword).prev().remove();
			$("#spamArea").children().filter("#" + spamKeyword).remove();
		}
	}
	
	// 금지단어값 hidden value 셋팅
	function setSpamKeywordValueToForm(){
	    if( $("#spamArea").children().filter("button").length > 0 ){
            
            var spamCount = 0;
            var spamKeywordSet = "";
            
            $("#spamArea").children().filter("button").each(function(){
                
                if( spamCount > 0 ){
                    spamKeywordSet += ",";
                }
                spamKeywordSet += $(this).attr("id");
                ++spamCount;
            });
            $("input[name='spamKeywords']").val( spamKeywordSet );
        }
	}
</script>
<section>
	<form id="basicSettingForm">
	    <input type="hidden" name="c_id" value="${defaultSetting.c_id}"/>
		<div class="three-quarter last boxed p-twenty clearfix"	data-anim-type="fade-in" data-anim-delay="0">
			<div id="samDiv" class="tablet-mobile alpha bm-remove last">
				<div class="responsive-row">
					<div class="one-quarter">글 추천 필드 사용 여부</div>
					<div class="one-quarter">
						<input id="useLikeFl" type="checkbox">
						<input type="hidden" name="useLikeFl" value="${defaultSetting.useLikeFl}">
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">목록에서 내용 사용 여부</div>
					<div class="one-quarter">
						<input id="viewContentInListFl" type="checkbox">
						<input type="hidden" name="viewContentInListFl" value="${defaultSetting.viewContentInListFl}">
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">목록에서 첨부파일 사용 여부</div>
					<div class="one-quarter">
						<input id="viewAttachInListFl" type="checkbox">
						<input type="hidden" name="viewAttachInListFl" value="${defaultSetting.viewAttachInListFl}">
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">익명 글쓰기 사용 여부</div>
					<div class="one-quarter">
						<input id="useWrittingAnonymFl" type="checkbox">
						<input type="hidden" name="useWrittingAnonymFl" value="${defaultSetting.useWrittingAnonymFl}">
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">제목 길이 제한</div>
					<div class="one-quarter">
						<input type="text" id="maxLengthInTitle" name="maxLengthInTitle" value="${defaultSetting.maxLengthInTitle}">
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">최소 글자수 제한</div>
					<div class="one-quarter">
					    <input type="text" id="minLengthInContent" name="minLengthInContent" value="${defaultSetting.minLengthInContent}">
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">최대 글자수 제한</div>
					<div class="one-quarter">
						<input type="text" id="maxLengthInContent" name="maxLengthInContent" value="${defaultSetting.maxLengthInContent}">
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">SNS 연동 사용 여부</div>
					<div class="one-quarter">
						<input id="useSnsLinkFl" type="checkbox">
						<input type="hidden" name="useSnsLinkFl" value="${defaultSetting.useSnsLinkFl}">
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">스팸 키워드 설정</div>
					<div class="one-quarter">
						<input id="spamKeywords" type="text"><button id="addSpamKeyword">추가</button>
						<input type="hidden" name="spamKeywords" value="${defaultSetting.spamKeywords}">
						<div id="spamArea"></div>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">자동 차단 설정</div>
					<div class="one-quarter">
						<input id="blockDoubtRequestFl" type="checkbox">
						<input type="hidden" name="blockDoubtRequestFl" value="${defaultSetting.blockDoubtRequestFl}">
					</div>
				</div>
				<div id="divBottom" class="responsive-row">
					<button id="saveBtn">저장</button>
				</div>
			</div>
		</form>	
</section>