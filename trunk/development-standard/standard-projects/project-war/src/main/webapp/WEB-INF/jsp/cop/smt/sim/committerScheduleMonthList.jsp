<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 달력 -->
	<div class="calendar">
		<h3>일별관리 월별 목록조회</h3>
		<div class="calendar_select">
			<select name="schdulSe" title="검색조건" class="select" id="schdulSe" onChange="fnEgovSchdulSe(this.form.schdulSe.options[this.form.schdulSe.selectedIndex].value);">
	        	<option selected value=''>-- 전체 --</option>
	            	<c:forEach var="result" items="${schdulSe}" varStatus="status">
	                	<option value='${result.code}' <c:if test="${searchKeyword == result.code}">selected</c:if>>${result.codeNm}</option>
	            	</c:forEach>                                                   
	        </select>  
			<p>
				<a href="#"><img src="${pageContext.request.contextPath}/assets/btn_prev.gif" alt="이전년도" /></a>
				<span>${nYear}년</span>
				<a href="#"><img src="${pageContext.request.contextPath}/assets/btn_next.gif" alt="다음년도" /></a>
			</p>
			<p>
				<a href="#"><img src="${pageContext.request.contextPath}/assets/btn_prev.gif" alt="이전달" /></a>
				<span>${nMonth+1}월</span>
				<a href="#"><img src="${pageContext.request.contextPath}/assets/btn_next.gif" alt="다음달" /></a>
			</p>
		</div>
		<table>
			<caption>일정달력</caption>
			<colgroup>
				<col style="width:14.2%" />
				<col style="width:14.2%" />
				<col style="width:14.2%" />
				<col style="width:14.2%" />
				<col style="width:14.2%" />
				<col style="width:14.2%" />
				<col style="*" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col" class="sun">일</th>
					<th scope="col">월</th>
					<th scope="col">화</th>
					<th scope="col">수</th>
					<th scope="col">목</th>
					<th scope="col">금</th>
					<th scope="col" class="sat">토</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="blankDay" value="1"/>
				<c:forEach var="i" begin="1" end="5">
					<tr>
						<c:forEach var="j" begin="1" end="7">
							<c:choose>
								<c:when test="${blankDay < start }">
									<c:set var="blankDay" value="${blankDay + 1}"/>
									<td>&nbsp;</td>
								</c:when>
								<c:when test="${startDay <= endDay }">
									<c:set var="color"  value=""/>
									<c:choose>
										<c:when test="${j == 1}">
											<c:set var="color"  value="sun"/>	
										</c:when>
										<c:when test="${j == 7}">
											<c:set var="color"  value="sat"/>	
										</c:when>
									</c:choose>
									<td class="${color}" bgcolor="#EFEFEF" >${startDay}</td>
									<c:set var="startDay" value="${startDay+1}"/>	
								</c:when>
								<c:otherwise>
									<td>&nbsp;</td>
								</c:otherwise>
							</c:choose>								
						</c:forEach>		
					</tr>
				</c:forEach>				
			</tbody>
		</table>
	</div>
	<!-- // 달력 -->
</body>
</html>