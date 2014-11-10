<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>커미터 일정관리</title>
</head>
<body>
	<!-- 달력 -->
	<div class="calendar">
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
				<c:forEach var="i" begin="1" end="${lastWeek}">
					<!-- 행 생성 -->
					<tr>
						<!-- 열 생성 -->
						<c:forEach var="j" begin="1" end="7">
							<c:choose>
								<c:when test="${blankDay < start }">
									<td>&nbsp;</td>
									<c:set var="blankDay" value="${blankDay + 1}"/>
								</c:when>
								<c:when test="${startDay > endDay }">
									<td>&nbsp;</td>
								</c:when>
								<c:otherwise>
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
								</c:otherwise>
							</c:choose>								
						</c:forEach>
						<!-- // 열 생성 -->
					</tr>
					<!-- // 행 생성 -->	
				</c:forEach>				
			</tbody>
		</table>
	</div>
	<!-- // 달력 -->
</body>
</html>