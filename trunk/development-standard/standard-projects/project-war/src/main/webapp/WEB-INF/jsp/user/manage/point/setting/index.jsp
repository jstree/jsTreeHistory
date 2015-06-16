<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags" %>

<style type="text/css">
.responsive-row {height:80px}
.responsive-row:after {display:block; content:''; clear:both}
.responsive-row .one-quarter {width:185px}
.one-quarter input[type=text] {display:inline-block; width:50%; text-align:right}
.responsive-row button {float:right}
</style>


<script type="text/javascript">
	$(function () {		
		$('#saveBtn').bind('click', function(e){
			
			callAjax(  'userPointSettingForm'
	                   , '${pageContext.request.contextPath}/user/manage/point/setting/saveUserPointSettingInf.do'
	                   , null
	                   , 'post'
	                   , 'json'
	                   , null
	                   , null
	                   , function(r){
							//alert(r);
			    		 }
			);
			return false;
		});
		
		
		$('#downloadProhFl').bind('click', function(e){
			if($(this).is(':checked')){
				$('#areaDownloadDeduPoint').show();
				
			}else{
				$('#areaDownloadDeduPoint').hide();
				$('#downloadDeduPoint').val(0);
			}
		});
		
		$('#articleReadProhFl').bind('click', function(e){
			if($(this).is(':checked')){
				$('#areaArticleReadDeduPoint').show();
			}else{
				$('#areaArticleReadDeduPoint').hide();		
				$('#articleReadDeduPoint').val(0);
			}
		});
	});
</script>

<section>
	<div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
		<div class="tablet-mobile alpha bm-remove last">
			<form id="userPointSettingForm">
				<div class="clearfix">
					<div class="responsive-row">
	                   <div class="one-quarter">
	                       <label for="pointUseFl">포인트 사용 여부</label>
	                   </div>
	                   <div class="one-quarter">
	                        <input id="pointUseFl" name="pointUseFl" type="checkbox" value="1" ${userPointSetting.pointUseFl == 1 ? "checked" : "unchecked"}/>
	                   </div>
	                </div>
	                <div class="responsive-row">
	                    <div class="one-quarter">
	                       <label for="pointExpiryDate">포인트 유효 기간</label>
	                   </div>
	                    <div class="one-quarter">
	                        <input id="pointExpiryDate" name="pointExpiryDate" type="text" value="${userPointSetting.pointExpiryDate}"/> 일
	                    </div>
	                </div>
	                <div class="responsive-row">
	                    <div class="one-quarter">
	                       <label for="userJoinPoint ">회원 가입 시 부여 포인트</label>
	                   </div>
	                    <div class="one-quarter">
	                        <input id="userJoinPoint" name="userJoinPoint" type="text" value="${userPointSetting.userJoinPoint}" /> point
	                    </div>
	                </div>
	                <div class="responsive-row">
	                    <div class="one-quarter">
	                       <label for="loginPoint">로그인 시 부여 포인트</label>
	                   </div>
	                    <div class="one-quarter">
	                        <input id="loginPoint" name="loginPoint" type="text" value="${userPointSetting.loginPoint}" /> point
	                    </div>
	                </div>
	                <div class="responsive-row">
	                    <div class="one-quarter">
	                       <label for="writingPoint">글쓰기 시 부여 포인트</label>
	                   </div>
	                    <div class="one-quarter">
	                        <input id="writingPoint" name="writingPoint" type="text" value="${userPointSetting.writingPoint}" /> point
	                    </div>
	                </div>
	                <div class="responsive-row">
	                    <div class="one-quarter">
	                       <label for="answerPoint">댓글쓰기 시 부여 포인트</label>
	                   </div>
	                    <div class="one-quarter">
	                        <input id="answerPoint" name="answerPoint" type="text" value="${userPointSetting.answerPoint}" /> point
	                    </div>
	                </div>
	                <div class="responsive-row">
	                    <div class="one-quarter">
	                       <label for="uploadPoint">업로드 시 부여 포인트</label>
	                   </div>
	                    <div class="one-quarter">
	                        <input id="uploadPoint" name="uploadPoint" type="text" value="${userPointSetting.uploadPoint}" /> point
	                    </div>
	                </div>
	                <div class="responsive-row">
	                    <div class="one-quarter">
	                       <label for="downloadPoint">다운로드 시 부여 포인트</label>
	                   </div>
	                    <div class="one-quarter">
	                        <input id="downloadPoint" name="downloadPoint" type="text" value="${userPointSetting.downloadPoint}" /> point
	                    </div>
	                </div>
	                <div class="responsive-row">
	                    <div class="one-quarter">
	                       <label for="recmnderPoint">추천인 부여 포인트</label>
	                   </div>
	                    <div class="one-quarter">
	                        <input id="recmnderPoint" name="recmnderPoint" type="text" value="${userPointSetting.recmnderPoint}" /> point
	                    </div>
	                </div>
	                <div class="responsive-row">
	                    <div class="one-quarter">
	                       <label for="downloadProhFl">다운로드 금지 설정</label>
	                   </div>
	                    <div class="one-quarter">
	                        <input id="downloadProhFl" name="downloadProhFl" type="checkbox"  value="1" ${userPointSetting.downloadProhFl == 1 ? "checked" : "unchecked"}/>
	                    </div>
	                    <div id="areaDownloadDeduPoint" style="display:${userPointSetting.downloadProhFl == 1 ? 'block;' : 'none;'}">
		                    <div class="one-quarter">
		                       <label for="downloadDeduPoint">다운로드 시 차감 포인트</label>
		                    </div>
		                    <div class="one-quarter">
		                        <input id="downloadDeduPoint" name="downloadDeduPoint" type="text" value="${userPointSetting.downloadDeduPoint}" /> point
		                    </div>
	                    </div>
	                </div>
	                <div class="responsive-row">
	                    <div class="one-quarter">
	                       <label for="articleReadProhFl">글 열람 금지 설정</label>
	                   </div>
	                    <div class="one-quarter">
	                        <input id="articleReadProhFl" name="articleReadProhFl" type="checkbox" value="1" ${userPointSetting.articleReadProhFl == 1 ? "checked" : "unchecked"}/>
	                    </div>
	                    <div id="areaArticleReadDeduPoint" style="display:${userPointSetting.articleReadProhFl == 1 ? 'block;' : 'none;'}">
		                    <div class="one-quarter">
		                       <label for="articleReadDeduPoint">글 열람 시 차감 포인트</label>
		                    </div>
		                    <div class="one-quarter">
		                        <input id="articleReadDeduPoint" name="articleReadDeduPoint" type="text" value="${userPointSetting.articleReadDeduPoint}" /> point
		                    </div>
	                    </div>
	                </div>
	                <div class="responsive-row">
	                	<button id="saveBtn" type="submit">저장하기</button>
	                </div>					
				</div>
			</form>
		</div>
	</div>
</section>
