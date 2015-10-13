<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	display: inline !important;
}
input[type="text"] {
	width: 192px !important;
    height: 30px !important;
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
#divPagination {
	text-align: center;
	margin-top: 10px;
	font-size: 1.1em;
}
.currentPage {
	font-weight: bold !important;
}
</style>

<script type="text/javascript">
    
    var editUrl = "<c:url value='/board/manager/boardmanagement/edit.do' />";
    var listUrl = "<c:url value='/board/manager/boardmanagement/list.do' />";
    
	$(document).ready(function() {
	    
		
	});
	
	// 테이블 생성
	$(document).on("click", "#createTable", function(){
		
		location.href = editUrl;
	// 검색
	}).on("click", "#btnSearch", function(){
		
		$("#searchForm").attr("action", listUrl);
		$("#searchForm").attr("method", "post");
		$("#searchForm").submit();
	// 상세화면
	}).on("click", "tr", function(){
		
		if( $(this).attr("id") != null && $(this).attr("id") != "" ){
			
			$("#searchForm").attr("action", editUrl + "?c_id=" + $(this).attr("id"));
	        $("#searchForm").attr("method", "post");
	        $("#searchForm").submit();
		}
	});
</script>

<section>
	<div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
	    <div id="samDiv" class="tablet-mobile alpha bm-remove last">
			<div id="search" class="one-whole boxed p-twenty">
				<form id="searchForm">
					<div class="responsive-row">
						<label for="boardTableName">게시판명</label>
						<input id="boardTableName" name="boardTableName" type="text" style="width: 90px !important" />
						<label for="useAnonymFl">비밀글 적용 여부</label>
						<select id="useAnonymFl" name="useAnonymFl" style="width: 70px !important">
                            <option value="" selected="selected">전체</option>
                            <option value="1">적용</option>
                            <option value="0">미적용</option>
                        </select>
						<button id="btnSearch" type="button" class="compact" align="right">검색</button>
					</div>
				</form>
			</div>
	    
	    	<div id="divBtns">
	            <button id="createTable" type="button" class="compact">게시판 생성</button>
	        </div>
	    	
	        <div class="dataTables_wrapper no-footer">
                <table id="tblUserList" class="display no-footer dataTable">
		            <thead>
		                <tr>
		                   <th>No</th>
		                   <th>게시판ID</th>
		                   <th>게시판명</th>
		                   <th>비밀글 적용 여부</th>
		                   <th>생성일</th>
		                </tr>
		            </thead>
	                <tbody>
	<c:choose>
	    <c:when test="${fn:length(list) == 0}">
	                <tr>
	                    <td colspan="5" align="center">데이터가 없습니다.</td>
	                </tr>
	    </c:when>
	    <c:otherwise>
	        <c:set var="no" value="1" />
	            <c:forEach items="${list}" var="board">
	                <fmt:parseDate value="${board.regDt}" pattern="yyyyMMddHHmmss" var="regDate" />
	                <tr id="${board.c_id}">
	                    <td>${no}</td>
	                    <td>${board.boardTableName}</td>
	                    <td>${board.c_title}</td>
	                    <td>${board.useAnonymFl == 1 ? '적용' : '미적용'}</td>
	                    <td><fmt:formatDate value="${regDate}" pattern="yyyy-MM-dd" /></td>
	                </tr>
	                <c:set var="no" value="${no+1}" />
	            </c:forEach>
	    </c:otherwise>
	</c:choose>                
		            </tbody>
		        </table>
		    </div>
	        <div id="divPagination"></div>
	        
	        <div id="divPopup"></div>
	    </div>
	</div>
</section>