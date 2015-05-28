<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags" %>
<!DOCTYPE html>
<html lang="ko" class="js">
<head>
<title>${boardName} - 글쓰기</title>
<!-- !!!  FOR THIS PAGE ONLY !!! -->
<script>
</script>
</head>
<body>
	<section class="clearfix">
		<nav>
			<div class="container bm-medium">
				<div class="one-whole">
					<div class="no-display">article</div>
					<div class="text-center">
						<h1 class="bm-remove">${boardName}</h1>
						<p class="bm-remove">
							<a href="/" target="_self">Home</a> &nbsp;/&nbsp; BOARD &nbsp;/&nbsp; ${boardName}
						</p>
					</div>
				</div>
			</div>
		</nav>
		<article>
			<div class="clearfix">
				<div class="container bm-remove">
					<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
						<div class="article-body rte" itemprop="articleBody">
							<div class="tablet-mobile alpha bm-remove last">
								<div id="titleDiv">
									<span>
										<label>제목</label>
									</span>
									<span>
										<input id="articleTitle" type="text" />
									</span>
									<!-- TODO : Admin일경우 공지선택가능 -->
									<span id="announceSpan">
										<input type="checkbox" id="isAnnounce" name="announce" />
										<label for="isAnnounce">공지</label>
									</span>										
								</div>
								<div>
									<form>
										<textarea name="editor1" id="editor1" rows="10" cols="80"></textarea>
										<script>
											// Replace the <textarea id="editor1"> with a CKEditor
											// instance, using default configuration.
											CKEDITOR.replace('editor1');
										</script>
									</form>
								</div>
								<div id="additionalInputs">
									<div class="additional-input-div">
										<span>
											<input type="checkbox" id="allowCommentChk" name="allowComment"/>
											<label for="allowCommentChk">댓글 허용</label>
										</span>
										<span>
											<input type="checkbox" id="allowTrackBackChk" name="allowTrackBack"/>
											<label for="allowTrackBackChk">엮인글 허용</label>
										</span>
										<span>
											<input type="checkbox" id="notifyChk" name="notify"/>
											<label for="notifyChk">알림</label>
										</span>
										<span>
											<input type="checkbox" id="isPublicChk" name="isPublic"/>
											<label for="isPublicChk">공개</label>
										</span>
									</div>
									<div class="additional-input-div">
										<div>
											파일 첨부
											<select id="fileAttachSelect"multiple="multiple" size=3>
												<option>test1.html</option>
												<option>test2.css</option>
												<option>test3.css</option>
												<option>test4.css</option>
												<option>test5.css</option>
											</select>
										</div>
										<div>
											<button class="file-btn">추가</button>
											<button class="file-btn">삭제</button>
										</div>
									</div>
									<div class="action-btn-div">
										<button>등록</button>
										<button>목록보기</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>
	</section>
</body>
</html>