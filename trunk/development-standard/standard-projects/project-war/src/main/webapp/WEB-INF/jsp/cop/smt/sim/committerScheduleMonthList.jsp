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
				<a href="#"><img src="http://localhost/ROOT/assets/btn_prev.gif" alt="이전년도" /></a>
				<span>${nYear}년</span>
				<a href="#"><img src="http://localhost/ROOT/assets/btn_next.gif" alt="다음년도" /></a>
			</p>
			<p>
				<a href="#"><img src="http://localhost/ROOT/assets/btn_prev.gif" alt="이전달" /></a>
				<span>${nMonth+1}월</span>
				<a href="#"><img src="http://localhost/ROOT/assets/btn_next.gif" alt="다음달" /></a>
			</p>
		</div>
		<table>
			<caption>달력</caption>
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
				<tr>
					<td class="sun"></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>
						<i>1</i>
						<div>
							내용
						</div>
					</td>
					<td class="sat">
						<i>2</i>
					</td>
				</tr>
				<tr>
					<td class="sun">
						<i>3</i>
						<div>
							내용
						</div>
					</td>
					<td>
						<i>4</i>
					</td>
					<td>
						<i>5</i>
					</td>
					<td>
						<i>6</i>
					</td>
					<td>
						<i>7</i>
					</td>
					<td>
						<i>8</i>
					</td>
					<td class="sat">
						<i>9</i>
					</td>
				</tr>
				<tr>
					<td class="sun">
						<i>10</i>
					</td>
					<td>
						<i>11</i>
					</td>
					<td>
						<i>12</i>
					</td>
					<td>
						<i>13</i>
					</td>
					<td>
						<i>14</i>
					</td>
					<td>
						<i>15</i>
					</td>
					<td class="sat">
						<i>16</i>
					</td>
				</tr>
				<tr>
					<td class="sun">
						<i>17</i>
						<div>
							내용
						</div>
					</td>
					<td>
						<i>18</i>
					</td>
					<td>
						<i>19</i>
					</td>
					<td>
						<i>20</i>
					</td>
					<td>
						<i>21</i>
					</td>
					<td>
						<i>22</i>
					</td>
					<td class="sat">
						<i>23</i>
					</td>
				</tr>
				<tr>
					<td class="sun">
						<i>24</i>
						<div>
							내용
						</div>
					</td>
					<td>
						<i>25</i>
					</td>
					<td>
						<i>26</i>
					</td>
					<td>
						<i>27</i>
					</td>
					<td>
						<i>28</i>
					</td>
					<td>
						<i>29</i>
					</td>
					<td class="sat">
						<i>30</i>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- // 달력 -->
</body>
</html>