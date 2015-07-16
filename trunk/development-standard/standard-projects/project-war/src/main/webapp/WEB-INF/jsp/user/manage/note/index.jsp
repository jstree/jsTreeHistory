<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags" %>


<style type="text/css">
label{
	display: inline;
}
input[type="text"]{
	display: inline;
	width:150px !important;
	height: 30px !important;
	margin: 0 0 0px !important;
}
select{
	display: inline !important;
}
#inqStartYmd{
	width: 95px !important;
}
#inqEndYmd{
	width: 95px !important;
}
.ui-datepicker .ui-datepicker-title select {
  margin: 5px 5px 5px 0px !important;
}
.search-area:after {display:block; content:''; clear:both}
.search-area .responsive-row {float:left; width:50%; margin-bottom:10px}
.search-area .responsive-row div {display:inline-block; float:left}
.search-area .responsive-row .item-name {position:relative; top:6px; width:48px; margin-right:10px;}
.search-area .responsive-row.button-area, .button-area {width:100%; text-align:right}
.search-area .button-area button {margin-bottom:0}
.display.responsive.nowrap th, .display.responsive.nowrap td {border:1px solid #e8e8e8}
.display.responsive.nowrap td {text-align:center;}
.display.responsive.nowrap td:nth-child(4) {padding:0 0.5%; text-align:left}
.table-area {height:275px}
</style>

<script type="text/javascript">
	$(function () {		
		$('#inqStartYmd').datepicker({
			 showOn: 'button'
			,buttonImage: '${pageContext.request.contextPath}/assets/images/calendar.png'
			,buttonImageOnly: true
			,buttonText: 'Select date'
			,defaultDate: '+1w'
			,dateFormat: 'yymmdd'
			,changeMonth: true
			,changeYear: true
			,numberOfMonths: 1
			,onClose: function( selectedDate ) {
				$( '#inqEndYmd' ).datepicker(  'option','minDate', selectedDate );
			}
		});
		$('#inqEndYmd').datepicker({
			 showOn: 'button'
			,buttonImage: '${pageContext.request.contextPath}/assets/images/calendar.png'
			,buttonImageOnly: true
			,buttonText: 'Select date'
			,defaultDate: '+1w'
			,dateFormat: 'yymmdd'
			,changeMonth: true
			,changeYear: true
			,numberOfMonths: 1
			,onClose: function( selectedDate ) {
				$('#inqStartYmd').datepicker( 'option','maxDate', selectedDate );
			}
		});
		
		$('#searchBtn').bind('click', function(e){
			
			/*callAjax(  'noteForm'
	                   , $('#noteForm').prop('action')
	                   , '#resultSection'
	                   , $('#noteForm').prop('method')
	                   , 'text'
	                   , null
	                   , null
	                   , function(r){
				
			             }
			);*/
			callAjax('noteForm'
                    , $('#noteForm').prop('action')
                    , null
                    , $('#noteForm').prop('method')
                    , 'json'
                    , null
                    , null//'application/json'
                    , function(r){
                    	$('#resultTblBody').children('tr').remove();
                    	
						$(r).each(function(i){							  
							if(null != this.noteDetailId && '' != this.noteDetailId){
								var tr = '';
								tr += '<tr>';
								tr += '<td><input name="grdCheckbox" type="checkbox"/></td>';				
								tr += '<td>' + this.userNm + '</td>';
								tr += '<td>' + this.receDispDt + '</td>';
								tr += '<td><a target="_self" onclick="fnNoteDetailPop(' + this.noteDetailId + ')">' + this.c_title + '</a></td>';
								tr += '<td>Delete</td>';
								tr += '</tr>';
								
								$('#resultTblBody').append(tr);
							}
						});
			        });
			return false;
		});
		
		$('#noteSendBtn').bind('click', function(e){
			window.open('${pageContext.request.contextPath}/user/manage/note/noteSendPopup.do'
					, '쪽지 보내기'
					, 'width=600, height=550, resizable=no, scrollbars=no, status=no, menubar=no');
		});
		
		$('#searchBtn').trigger('click');
	});
	
	function fnNoteDetailPop(noteDetailId){
		window.open('${pageContext.request.contextPath}/user/manage/note/noteDetailPopup.do?noteDetailId=' + noteDetailId
				, '상세보기'
				, 'width=600, height=550, resizable=no, scrollbars=no, status=no, menubar=no');
	}
</script>

<section>
	<div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
		<!-- 검색 부분 -->
		<div id="search" class="one-whole boxed p-twenty search-area">
			<form id="noteForm" action="${pageContext.request.contextPath}/user/manage/note/inquiryNoteList.do" method="post">
				<div class="responsive-row">
					<div class="item-name">발신자</div>
					<div class="item-value">
						<input id="userNm" name="userNm" type="text">
					</div>
				</div>
				<div class="responsive-row">
					<div class="item-name">제목</div>
					<div class="item-value">
						<input id="c_title" name="c_title" type="text">
					</div>
				</div>
				<div class="responsive-row has-two-value">
					<div class="item-name">발신일자</div>
					<div class="item-value">
						<label for="inqStartYmd"></label>
						<input placeholder="${inqStartYmd}" type="text" id="inqStartYmd" name="inqStartYmd">
						<label for="inqEndYmd">~</label>
						<input placeholder="${inqEndYmd}" type="text" id="inqEndYmd" name="inqEndYmd">
					</div>
				</div>
				<div class="responsive-row">
					<div class="item-name">내용</div>
					<div class="item-value">
						<input id="content" name="content" type="text">
					</div>
				</div>
				<div class="responsive-row button-area">
					<button id="searchBtn" type="submit">검색</button>
				</div>
			</form>
		</div>
		<!-- 검색 부분 끝 -->
		
		<div>
			<div id="resultSection" class="dataTables_wrapper no-footer">
			<div class="responsive-row button-area">
				<button id="noteSendBtn">쪽지 보내기</button>
				<button id="deleteBatchBtn">일괄삭제</button>
			</div>
				<table id="resultTblHead" class="display responsive nowrap" cellspacing="0" width="100%">
					<colgroup>
						<col width="10%" />
						<col width="15%" />
						<col width="20%" />
						<col width="*" />
						<col width="15%" />
					</colgroup>
					<thead>
						<tr>
							<th>
								<input id="batCheckbox" name="batCheckbox" type="checkbox"/>
							</th>
							<th>발신자</th>
							<th class="not-mobile">발신일자</th>
							<th class="not-tablet">제목</th>
							<th></th>
						</tr>
					</thead>
					<tbody id="resultTblBody">						
					</tbody>
				</table>
			</div>
		</div>	
	</div>
</section>