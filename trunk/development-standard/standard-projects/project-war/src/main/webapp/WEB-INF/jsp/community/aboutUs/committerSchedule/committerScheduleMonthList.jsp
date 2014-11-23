<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- Core : 변수, 흐름제어, url처리 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><!-- 함수 : collection, String 처리  -->
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head>
		<title>커미터 일정관리</title>
		<style type="text/css">
			html {
			margin-top: 40px;
			}
			body {
			position: relative;
			}
			
			/* 테이블 */
			.calendar table {width:100%; border-top:3px solid #ccc; border-collapse:collapse}
			.calendar caption {margin:1% 0 0.5%}
			.calendar th, td {border:1px solid #ccc}
			.calendar th {padding:1% 0.5%; background:#fafafa; font-weight:bold}
			.calendar td {padding:0.5% 2%;}
			
			/* 달력 */
			/*.calendar {margin-top:3px;}*/
			.calendar h3 {margin-bottom:10px; font-size:15px; color:#222; font-weight:bold}
			.calendar_select {padding:16px 14px 12px; border:2px solid #ccc; *zoom:1}
			.calendar_select:after {display:block; content:""; clear:both}
			.calendar_select select {float:left; width:auto; height:auto; margin:0 20px 0 0}
			.calendar_select p {float:left; margin:4px 5px 0 0}
			.calendar_select p span {position:relative; top:-6px; padding:0 8px; font-size:14px}
			.calendar table {border:none;table-layout:fixed}
			.calendar caption {height:1px; text-indent:-9999em}
			.calendar th {background:#cecece; border:1px solid #fff}
			.calendar th:first-child {border-left:1px solid #d7d7d7}
			.calendar th:last-child {border-right:1px solid #d7d7d7}
			.calendar td {height:100px; padding:0 1% 1%; vertical-align:top; border:1px solid #d7d7d7;text-overflow:ellipsis; overflow:hidden }
			.calendar td i {display:block; color:#000; font-style:normal;}
			.calendar td div {color:#666}
			.calendar .sun, .calendar .sun i {color:#ff0000}
			.calendar .sat, .calendar .sat i {color:#529dbc}
			.calendar .wek{color:#000000}
			
			/*달력 내용 링크*/
			.cal_cont a {
			             overflow:hidden; 
			             display:block; 
			             height:23px; 
			             padding-right:9px; 
			             color:#666; 
			             /*background:url('${pageContext.request.contextPath}/assets/images/ell.gif') no-repeat right center;*/
			             white-space:nowrap;
					     text-overflow:ellipsis;     /* IE, Safari */
					     /*-o-text-overflow:ellipsis;   Opera under 10.7 */
					     overflow:hidden;            /* "overflow" value must be different from "visible" */
					     /*-moz-binding: url('ellipsis.xml#ellipsis');*/
			            }
			.cal_cont a:hover {color:#f45b4f}
		</style>
		<script type="text/javascript">
			$(function(){
				//스케쥴 조회 조건 콤보박스 변경
				$("#schdulSe").change(function (event){
					var sYear = $("#calYear").text();
					var sMonth = $("#calMonth").text();
					var nYear = parseInt(sYear.replace("년", ""), 10);
					var nMonth = parseInt(sMonth.replace("월", ""), 10);
					
					fnBaroIndvdlSchdulManageMonthList(nYear, nMonth, "SCHDUL", $(this).val());
				});
				
				$("#previousYear").mouseup(function(event){
					var sYear = $("#calYear").text();
					var sMonth = $("#calMonth").text();
					var nYear = parseInt(sYear.replace("년", ""), 10) - 1;
					var nMonth = sMonth.replace("월", "");
					
					if(nYear < 1900){
						nYear = 1900;	
					}
					
					fnBaroIndvdlSchdulManageMonthList(nYear, nMonth, "SCHDUL", $("#schdulSe option:selected").val());
				});
				
				$("#previousMonth").mouseup(function(event){
					var sYear = $("#calYear").text();
					var sMonth = $("#calMonth").text();
					var nYear = sYear.replace("년", "");
					var nMonth = parseInt(sMonth.replace("월", ""), 10) - 1;
					
					if(nMonth < 1){
						nYear--;
						nMonth = 12;	
					}
					
					fnBaroIndvdlSchdulManageMonthList(nYear, nMonth, "SCHDUL", $("#schdulSe option:selected").val());
				});
				
				$("#nextYear").mouseup(function(event){
					var sYear = $("#calYear").text();
					var sMonth = $("#calMonth").text();
					var nYear = parseInt(sYear.replace("년", ""), 10) + 1;
					var nMonth = sMonth.replace("월", "");
					
					if(nYear > 9999){
						nYear = 9999;
					}
					
					fnBaroIndvdlSchdulManageMonthList(nYear,nMonth);
				});
				
				$("#nextMonth").mouseup(function(event){
					var sYear = $("#calYear").text();
					var sMonth = $("#calMonth").text();
					var nYear = sYear.replace("년", "");
					var nMonth = parseInt(sMonth.replace("월", ""), 10) + 1;
					
					if(nMonth > 12){
						nYear++;
						nMonth = 1;	
					}
					
					fnBaroIndvdlSchdulManageMonthList(nYear, nMonth, "SCHDUL", $("#schdulSe option:selected").val());
				});
			});
			
			function fnBaroIndvdlSchdulManageMonthList(year, month, searchCondition, searchKeyword){
				$.ajax({
					 async : false
					,type: 'GET'
					,url: "${pageContext.request.contextPath}/sub/committerScheduleMonthList.do"
					,data : {
								 year  : year
								,month : month
								,searchKeyword   : searchKeyword
								,searchCondition : searchCondition
						    }
					,success : function (page) {
						$("#calYear").text(year+"년");
						$("#calMonth").text(month+"월");
						$("#contentsBody").html(page);
					}
					,error : function(e){
						$("#calYear").text(year + "년");
						$("#calMonth").text(month + "월");
						alert(e);
					}
				});
			}
			
			function fnSchdulManageDetail(schdulId){
				var sYear = $("#calYear").text();
				var sMonth = $("#calMonth").text();
				var nYear = parseInt(sYear.replace("년", ""), 10);
				var nMonth = parseInt(sMonth.replace("월", ""), 10);
				
				$.ajax({
					 async : false
					,type: 'GET'
					,url: "${pageContext.request.contextPath}/sub/committerSchedulelManageDetail.do"
					,data : {
								 schdulId : schdulId
								,year  	  : nYear
								,month    : nMonth
								,searchKeyword   : "SCHDUL"
								,searchCondition : $("#scheduleSe option:selected").val()
						    }
					,success : function (page) {
						$("#contentsBody").html(page);
					}
					,error : function(e){
						alert(e);
					}
				});
			}
		</script>
	</head>
	<body>
		<h5>일별관리 월별 목록조회</h5>
		<div class="calendar_select">
			<select name="scheduleSe" title="검색조건" class="select" id="schdulSe">
	        	<option selected value=''>-- 전체 --</option>
	            	<c:forEach var="result" items="${schdulSe}" varStatus="status">
	                	<option value='${result.code}' <c:if test="${searchKeyword == result.code}">selected</c:if>>${result.codeNm}</option>
	            	</c:forEach>                                                   
	        </select>  
			<p>
				<a id="previousYear" href="#"><img src="${pageContext.request.contextPath}/assets/images/btn_prev.gif" alt="이전년도" /></a>
				<span id="calYear" >${nYear}년</span>
				<a id="nextYear" href="#"><img src="${pageContext.request.contextPath}/assets/images/btn_next.gif" alt="다음년도" /></a>
			</p>
			<p>
				<a id="previousMonth" href="#"><img src="${pageContext.request.contextPath}/assets/images/btn_prev.gif" alt="이전달" /></a>
				<span id="calMonth">${nMonth+1}월</span>
				<a id="nextMonth" href="#"><img src="${pageContext.request.contextPath}/assets/images/btn_next.gif" alt="다음달" /></a>
			</p>
		</div>
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
										<c:set var="color" value="wek"/>
										<c:choose>
											<c:when test="${j == 1}">
												<c:set var="color"  value="sun"/>	
											</c:when>
											<c:when test="${j == 7}">
												<c:set var="color"  value="sat"/>	
											</c:when>
										</c:choose>
										<td class="${color}" bgcolor="#EFEFEF" >${startDay}
											<div class="cal_cont">
												<c:forEach var="item" items="${resultList}">
													<c:set var="iBeginDate" value="${fn:substring(item.schdulBgnde, 6, 8)}"/>
													<c:set var="iBeginEnd" value="${fn:substring(item.schdulEndde, 6, 8)}"/>
													<c:if test="${startDay >= iBeginDate && startDay <= iBeginEnd}">
														<a class="ellipsis" href="#" onclick="fnSchdulManageDetail('${item.schdulId}');" target="_self">${item.schdulNm}</a>
													</c:if>																            
											</c:forEach>
											</div>										
										</td>
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