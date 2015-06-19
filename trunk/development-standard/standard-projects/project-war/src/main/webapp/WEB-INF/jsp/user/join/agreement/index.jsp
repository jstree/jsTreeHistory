<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags" %>

<!DOCTYPE html>
<html lang="ko" class="js">
<head>
<title>${pageName}</title>
<!-- !!!  FOR THIS PAGE ONLY !!! -->
<script src="${pageContext.request.contextPath}/assets/js/ajax.js" type="text/javascript"></script>
<script type="text/javascript">
var Agreement = {
	     
	    handleEvent : function() {
	        
	        var form = 'frmAgreement';
	        var $form = $('#' + form);
	        
	        $form.on('submit', function() {
	        	if($("input:checkbox[id='agreement']").is(":checked") == false){
	            	alert('약관 동의 버튼에 체크해주세요');
	            	return false;
	            }
	            if (!confirm('약관의 동의하시겠습니까?')) {
	                return false;
	            }
	        });
	    },
	        
	    init : function() {
	        this.handleEvent();
	    }
	};

	$(document).ready(function() {
		Agreement.init();
	});
 
</script>
<style>
#thead{
	outline-width: 0px;
}
#boardTable {
	width: 100%;
}

.font-bold {
	font-weight: bold;
	font-size: 25px;
}
	
</style>
</head>
<body>
	<section class="clearfix">
		<nav>
			<div class="container bm-medium">
				<div class="one-whole">
					<div class="no-display">agreement</div>
					<!-- 
					<div class="text-center">
						<h1 class="bm-remove">자유게시판</h1>
						<p class="bm-remove">
							<a href="/" target="_self">Home</a> &nbsp;/&nbsp; BOARD &nbsp;/&nbsp; ${boardName}
						</p>
					</div>
					 -->
				</div>
			</div>
		</nav>
		<article>
			<div class="clearfix">
				<div class="container bm-remove">
					<form id="frmAgreement" action="next.do" method="post">
						<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
							<div class="tablet-mobile alpha bm-remove last">
								<div>
									<table id="boardTable" class="board-table display">
										<thead>
											<tr>
												<td colspan="3" align="center" class="font-bold">회원가입</td>
											</tr>
											<tr>
												<td colspan="3" height="20px"></td>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="dt-center" width="45%">서비스 이용약관</td>
												<td class="dt-center" width="10"></td>
												<td class="dt-center" width="45%">개인정보처리방침</td>
											</tr>
											<tr>
												<td class="dt-center" width="49%">
													<textarea id="txtTermsOfUse" name="termsOfUse" class="w-large" readonly>${basicContents.termsOfUse}</textarea>
												</td>
												<td class="dt-center" width="2%"></td>
												<td class="dt-center" width="49%">
													<textarea id="txtPrivacyPolicy" name="privacyPolicy" class="w-large" readonly>${basicContents.privacyPolicy}</textarea>
												</td>
											</tr>
											<tr>
												<td align="left" width="10%" colspan="3">
													&nbsp;&nbsp;<input type="checkbox" id="agreement" name="agreement" >
													&nbsp;&nbsp;위 두가지를 모두 읽었으며 내용에 모두 동의합니다.
												</td>
											</tr>
											<tr>
												<td align="right" width="10%" colspan="3">
													<button id="btnNext" type="submit">다음</button>
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
</body>
</html>