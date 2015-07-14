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
	});
	
	// 체크박스 체크 이벤트
	$(document).on("click", "input[type=checkbox]", function(){
		
		if( $(this).prop("checked") ){
			$(this).next().val("1");
		}
		else{
			$(this).next().val("0");
		}
	}).on("click", "#saveBtn", function(){
		
		if( confirm("저장하시겠습니까?") ){
			
			if( validForm() ){
				
				var sendUrl = "<c:url value='/board/manager/boardmanagement/save.do' />";
				
				if( $("#c_id").val() == '0' ){
					sendUrl = "<c:url value='/board/manager/boardmanagement/create.do' />";
					$("#c_id").val("2");
				}
				
				callAjax( "boardManagementForm"
		                , sendUrl
		                , null
		                , "POST"
		                , 'json'
		                , null
		                , null );
				alert("처리되었습니다.");
			}
		}		
	});
	 
	// 유효성 검사
	function validForm(){
		
		var result = true;
		
		$("input[type=text]").each(function(){
			
			if( $(this).val() == "" || $(this).val() == null ){
				result = false;
				alert( $(this).parent().prev().text() + " 값을 입력해 주세요." );
				$(this).focus();
			}
		});
		return result;
	}
</script>
<section>
	<form id="boardManagementForm">
	    <input type="hidden" id="c_id"   name="c_id"   value="<c:out value='${board.c_id}' default='0' />"/>
	    <input type="hidden" id="ref"    name="ref"    value="2"/>
	    <input type="hidden" id="c_type" name="c_type" value="default"/>
	    <input type="hidden" id="c_position" name="c_position" value="100"/>
		<div class="three-quarter last boxed p-twenty clearfix"	data-anim-type="fade-in" data-anim-delay="0">
			<div id="samDiv" class="tablet-mobile alpha bm-remove last">
				<div class="responsive-row">
					<div class="one-quarter">게시판명</div>
					<div class="one-quarter">
						<input type="text" id="c_title" name="c_title" value="${board.c_title}">
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">페이지당 목록 수</div>
					<div class="one-quarter">
						<input type="text" id="writingCntPerPage" name="writingCntPerPage" value="${board.writingCntPerPage}" style="width: 70px !important">
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">목록 보기 권한</div>
					<div class="one-quarter">
						<select id="useAnonymFl" name="useAnonymFl" style="width: 70px !important">
						    <option value="">모두</option>
				<c:forEach items="${userGrades}" var="grade">
                            <option value="${grade.c_id}">${grade.c_title}</option>
                </c:forEach>
                        </select>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">글 읽기 권한</div>
					<div class="one-quarter">
						<select id="levelForReadContent" name="levelForReadContent" style="width: 70px !important">
						    <option value="">모두</option>
				<c:forEach items="${userGrades}" var="grade">
                            <option value="${grade.c_id}">${grade.c_title}</option>
                </c:forEach>
                        </select>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">글 쓰기 권한</div>
					<div class="one-quarter">
						<select id="levelForWriting" name="levelForWriting" style="width: 70px !important">
						    <option value="">모두</option>
				<c:forEach items="${userGrades}" var="grade">
                            <option value="${grade.c_id}">${grade.c_title}</option>
                </c:forEach>
                        </select>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">글 답변 권한</div>
					<div class="one-quarter">
						<select id="levelForReply" name="levelForReply" style="width: 70px !important">
						    <option value="">모두</option>
				<c:forEach items="${userGrades}" var="grade">
                            <option value="${grade.c_id}">${grade.c_title}</option>
                </c:forEach>
                        </select>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">댓글쓰기 권한</div>
					<div class="one-quarter">
						<select id="levelForComment" name="levelForComment" style="width: 70px !important">
						    <option value="">모두</option>
				<c:forEach items="${userGrades}" var="grade">
                            <option value="${grade.c_id}">${grade.c_title}</option>
                </c:forEach>
                        </select>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">링크 권한</div>
					<div class="one-quarter">
						<select id="levelForClipping" name="levelForClipping" style="width: 70px !important">
						    <option value="">모두</option>
				<c:forEach items="${userGrades}" var="grade">
                            <option value="${grade.c_id}">${grade.c_title}</option>
                </c:forEach>
                        </select>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">업로드 권한</div>
					<div class="one-quarter">
						<select id="levelForFileUpload" name="levelForFileUpload" style="width: 70px !important">
						    <option value="">모두</option>
				<c:forEach items="${userGrades}" var="grade">
                            <option value="${grade.c_id}">${grade.c_title}</option>
                </c:forEach>
                        </select>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">다운로드 권한</div>
					<div class="one-quarter">
						<select id="levelForFileDownload" name="levelForFileDownload" style="width: 70px !important">
						    <option value="">모두</option>
				<c:forEach items="${userGrades}" var="grade">
                            <option value="${grade.c_id}">${grade.c_title}</option>
                </c:forEach>
                        </select>
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">원글 수정 불가 여부</div>
					<div class="one-quarter">댓글
						<input type="text" id="commentCntForBanDeletion" name="commentCntForBanDeletion" value="${board.commentCntForBanDeletion}">
						개 이상
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">원글 삭제 불가 여부</div>
					<div class="one-quarter">댓글
						<input type="text" id="commentCntForBanEditing" name="commentCntForBanEditing" value="${board.commentCntForBanEditing}">
						개 이상
					</div>
				</div>
				<div class="responsive-row">
					<div class="one-quarter">비밀글 적용 여부</div>
					<div class="one-quarter">
						<input id="useAnonymFl" type="checkbox">
						<input type="hidden" name="useAnonymFl" value="${board.useAnonymFl}">
					</div>
				</div>
				<div id="divBottom" class="responsive-row">
					<button id="saveBtn">저장</button>
				</div>
			</div>
		</form>	
</section>