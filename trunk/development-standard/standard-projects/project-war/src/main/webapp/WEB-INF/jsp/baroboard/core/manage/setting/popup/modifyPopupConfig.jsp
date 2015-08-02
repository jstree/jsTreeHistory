<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
.center {
    text-align: center;
}
.right {
    text-align: right;
}
.chk {
    height: 13px !important;
}
select {
	height: 100%;
}
input[type="text"] {
	width: 192px !important;
    height: 30px !important;
    display: inline !important;
}
select {
	display: inline !important;
}
#divBtns {
    text-align: right;
    margin-top: 10px;
}
.compact {
	min-width: 71px;
    min-height: 37px;
}
/*
.responsive-row {
	width: 100%;
	height: auto;
	margin-bottom: 10px;
	overflow: auto;
	text-align: center;
	overflow: auto;
}
.responsive-row > div {
	float: left;
}
.item-name-left {
	width: 20%;
}
.item-value-left {
	width: 25%;
}
.item-name-right {
	width: 20%;
}
.item-value-right {
	width: 25%;
}
*/
</style>
<head>
<script type="text/javascript" id="script">
$(document).ready(function() {
	(function date() {
		console.log("Hello Date");
		var date = new Date();
		
		var yyyy = date.getFullYear();
		var mm = date.getMonth() + 1;
		var dd = date.getDate();
		
		mm = (mm < 10) ? '0' + mm : mm;
		dd = (dd < 10) ? '0' + dd : dd;
		
		var today = yyyy + '-' + mm + '-' + dd;
		
		var datepickerOptions = {
			showOn: "button",
			buttonImage: "${pageContext.request.contextPath}/assets/images/calendar.png",
			buttonImageOnly: true,
			buttonText: "Select date",
			defaultDate: "-1w",
			dateFormat: "yy-mm-dd",
			changeMonth: true,
			changeYear: true,
			numberOfMonths: 1,
			minDate:today
		};
		
		var $expiryDe = $('#expiryDe');
		$expiryDe.datepicker(datepickerOptions);

	})();
	
	(function onPopupSubmit(){
		var $form = $('#popupInfo');
		$form.on('submit',function(){
			var params = $form.serializeObject();	            
            if (!confirm('저장하시겠습니까?')) {
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
                	if(r.status=='500'){
                    //alert(r.status + '수정되지 않았습니다. .');
                	}else{
	                    alert(r.status + '수정되었습니다.');
                	}
                }
            }
            return false;
		});
	})();
});
</script>
</head>
<body>
<section>
<div class="three-quarter last boxed p-twenty clearfix"	data-anim-type="fade-in" data-anim-delay="0">
	<div id="samDiv" class="tablet-mobile alpha bm-remove last">
		<form name="popupInfo" id="popupInfo" method="post" action="${pageContext.request.contextPath}/core/manage/setting/popup/alterPopupConfig.do">
			<input type="hidden" name="c_id" id="c_id" value="${popup.c_id}"/>
			<input type="hidden" name="writngDe" id="writngDe"  value="${popup.writngDe}"/>
			<div class="responsive-row">
				<div class="one-quarter">팝업 제목 설정</div>
				<div class="one-quarter">
					<input name="c_title" id="c_title" type="text" value="${popup.c_title}">
				</div>
			</div>
			<div class="responsive-row">
				<div class="one-quarter">팝업 내용 설정</div>
				<div class="one-quarter">
					<textarea id="popupContent" name="popupContent" class="w-large" placeholder="">${popup.popupContent}</textarea>
				</div>
			</div>
			<div class="responsive-row">
				<div class="one-quarter">팝업 유효기간 설정</div>
				<div class="one-quarter">
					<input name="expiryDe" id="expiryDe" type="text" value="${popup.expiryDe}"/>
				</div>
			</div>
			<div class="responsive-row ">
				<div class="one-quarter">팝업 다시보지 않기 시간 설정</div>
				<div class="one-quarter">
					<input name="rePopupTerm" id="rePopupTerm" type="text" value="${popup.rePopupTerm}"/>
				</div>
			</div>
			<div class="responsive-row ">
				<div class="one-quarter">팝업 레이어 좌측 위치 설정</div>
				<div class="one-quarter">
					<input name="layerLeft" id="layerLeft" type="text" value="${popup.layerLeft}"/>
				</div>
			</div>
			<div class="responsive-row ">
				<div class="one-quarter">팝업 레이어 상단 위치 설정</div>
				<div class="one-quarter">
					<input name="layerTop" id="layerTop" type="text" value="${popup.layerTop}"/>
				</div>
			</div>
			<div class="responsive-row ">
				<div class="one-quarter">팝업 레이어 가로길이 설정</div>
				<div class="one-quarter">
					<input name="layerWidth" id="layerWidth" type="text" value="${popup.layerWidth}"/>
				</div>
			</div>
			<div class="responsive-row ">
				<div class="one-quarter">팝업 레이어 세로길이 설정</div>
				<div class="one-quarter">
					<input name="layerHeight" id="layerHeight" type="text" value="${popup.layerHeight}"/>									
				</div>
			</div>
			<div id="divBottom" class="responsive-row">
				<button type="submit">저장</button>
			</div>
		</form>
	</div>
</section>
</body>