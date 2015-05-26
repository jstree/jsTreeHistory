<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>어드민 사이트매시 테스트</title>
</head>
<body>
	<section>
		<div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
			<div id="samDiv" class="tablet-mobile alpha bm-remove last">
				<div class="responsive_row">
					<div class="item_Lname">게시판제목</div>
					<div class="item_Lvalue">
						<input id="titleInput" type="text">
					</div>
					<div class="item_Rname">글쓰기 권한</div>
					<div class="item_Rvalue">
						<select>
							<option value="모두">모두</option>
							<option value="정회원">정회원</option>
						</select>
					</div>
				</div>
				<div class="responsive_row">
					<div class="item_Lname">게시판 유형</div>
					<div class="item_Lvalue">
						<select>
							<option value="글">글</option>
							<option value="사진">사진</option>
							<option value="방명록">방명록</option>
						</select>
					</div>
					<div class="item_Rname">댓글 쓰기 권한</div>
					<div class="item_Rvalue">
						<select>
							<option value="모두">모두</option>
							<option value="정회원">정회원</option>
						</select>
					</div>
				</div>
				<div class="responsive_row">
					<div class="item_Lname">페이지 당 목록 수</div>
					<div class="item_Lvalue">
						<input type="text">
					</div>
					<div class="item_Rname">링크 권한</div>
					<div class="item_Rvalue">
						<select>
							<option value="모두">모두</option>
							<option value="정회원">정회원</option>
						</select>
					</div>
				</div>
				<div class="responsive_row ">
					<div class="item_Lname">목록 보기 권한</div>
					<div class="item_Lvalue">
						<select>
							<option value="모두">모두</option>
							<option value="정회원">정회원</option>
						</select>
					</div>
					<div class="item_Rname">업로드 권한</div>
					<div class="item_Rvalue">
						<select>
							<option value="모두">모두</option>
							<option value="정회원">정회원</option>
						</select>
					</div>
				</div>
				<div class="responsive_row">
					<div class="item_Lname">글 읽기 권한</div>
					<div class="item_Lvalue">
						<select>
							<option value="모두">모두</option>
							<option value="정회원">정회원</option>
						</select>
					</div>
					<div class="item_Rname">다운로 권한</div>
					<div class="item_Rvalue">
						<select>
							<option value="모두">모두</option>
							<option value="정회원">정회원</option>
						</select>
					</div>
				</div>
				<div class="responsive_row">
					<button id="saveBtn">저장</button>
				</div>
			</div>
	</section>
</body>
</html>