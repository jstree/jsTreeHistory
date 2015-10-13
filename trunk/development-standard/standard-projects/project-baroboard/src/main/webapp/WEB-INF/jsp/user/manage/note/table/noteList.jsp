<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">

</style>

<script type="text/javascript">
	function fnPop(noteDetailId){
		window.open('${pageContext.request.contextPath}/user/manage/note/noteDetailPopup.do?noteDetailId=' + noteDetailId
				, '상세보기'
				, 'width=600, height=550, resizable=no, scrollbars=no, status=no, menubar=no');
	}
	
	$(function () {
		$('#noteSendBtn').bind('click', function(e){
			window.open('${pageContext.request.contextPath}/user/manage/note/noteSendPopup.do'
					, '쪽지 보내기'
					, 'width=600, height=550, resizable=no, scrollbars=no, status=no, menubar=no');
		});
	});
</script>

<div class="responsive-row button-area">
	<button id="noteSendBtn">쪽지 보내기</button>
	<button id="deleteBatchBtn">일괄삭제</button>
</div>
<div class="table-area">
	<table id="jstreeTable" class="display responsive nowrap" cellspacing="0" width="100%">
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
		<tbody>
			<c:forEach var="item" items="${userNoteByUserList}">
				<tr>
					<td><input name="grdCheckbox" type="checkbox"/></td>				
					<td>${item.userNm}</td>
					<td>${item.receDispDt}</td>
					<td><a target="_self" onclick="fnPop(${item.noteDetailId})">${item.c_title}</a></td>
					<td>Delete</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

