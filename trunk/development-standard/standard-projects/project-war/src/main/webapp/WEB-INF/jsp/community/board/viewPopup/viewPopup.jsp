<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" autoFlush="true"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<!DOCTYPE html>
<html lang="ko-KR">
<head>
<style>
	a{
		cursor: pointer;
	}

	.title_info{
		padding-right: 10px;
	}
	
	.content_info{
		padding-right: 20px;
	}
	
	.content{
		min-height: 200px;
	
	}
	
	.comment_area{
		border: 1px solid #d8d8d8;
		background: ##eaeaea;
		padding: 20px 20px 10px;
		margin-bottom: 10px;
	}
	
	.comment_div{
		border-top: 1px solid #d8d8d8;
		padding: 10px;
		margin-bottom: 10px;
	}
		.comment_div strong{
			margin-right: 5px;
		}
		
		.comment_div span{
			margin-right: 5px;
		}
		
		.comment_div ul{
			list-style: none;
			padding: 0;
			margin: 0;
		}
		
			.comment_div ul li{
				float: left;
				margin-right: 5px;
			}
		.comment_div .comment_footer{
			float: right;
		}
	
		.comment_div .comment_empty{
			text-align: center;
		}	
		
	.comment_write{
	
	}
	
	.comment_write table{
		width: 100%;
		margin-bottom: 10px;
	}
	
		.comment_write table th{
			border: 1px solid #d8d8d8;
			border-left:0;
			background: #eaeaea;
			text-align: left;
			padding: 10px;
		}
		
		.comment_write table td{
			border-top: 1px solid #d8d8d8;
			border-bottom: 1px solid #d8d8d8;
			background: white;
			padding: 10px;
		}
		
		.comment_write table input{
			margin: 0;
		}
		
		.comment_write table textarea{
			margin: 0;
			width: 100%;
			max-width: 100%;
		}
		
	.top_btn{
		min-height: 50px;
		margin-bottom: 10px;
	}
	
		.top_btn ul{
			list-style: none;
			padding: 0;
			margin: 0;
		}
			.top_btn ul li{
				float: left;
				margin-right: 5px;
			}
			
		.top_btn a{
			display: inline-block;
			padding: 7px;
			border: 1px solid #d8d8d8;
			background :#d8d8d8;
			vertical-align: middle;
		}
	
</style>

<!-- JavaScript neccessary for the tree -->
<script type="text/javascript">
	// <![CDATA[
	$(document).ready(function($) {
		var next = 0,
			prev = 0;
		
		
		var comment = {
				remove : function(div){
					$(div).children().not("h3").remove();
				},
				getTag : function(){
					return "<div class='comment_div'>"+
							 	"<div class='comment_info'>"+
						 		"<strong></strong>"+
						 		"<span>작성일</span>"+
						 		"<time class='comment_write_date'></time>"+
						 	"<div/>"+
						 	"<div class='comment'></div>"+
						 	"<div class='comment_footer'>"+
						 		"<ul>"+
							 		"<li class='inner_comment_write'><a>답변</a></li>"+
							 		"<li class='comment_delete'><a>삭제</a></li>"+
						 		"</ul>"+
						 	"</div>"+
						"<div/>";
				},
				depthMargin : function(div, depth){
					div.css("margin-left",(depth * 10)-10);
					div.find(".comment_info").prepend("┗ ");
				},
				deleteBtn : function(div){
					div.find(".comment_delete").remove();
				},
				isComment : function(data){
					return data.articleComment && data.articleComment.length > 0;
				}
				
		}
		function createComment(data){
			var id = "#comment";
			
			comment.remove(id);
			
			if(comment.isComment(data)){
				for(var i in data.articleComment){
					
					var commentDiv = $(comment.getTag());
					var commentData = data.articleComment[i];
					
					if(commentData.commentDepth > 1){
						comment.depthMargin(commentDiv, commentData.commentDepth);
					}
					
					if(commentData.commentChild){
						comment.deleteBtn(commentDiv);
					}
					
					commentDiv.find("strong").html(commentData.commentWriter);
					commentDiv.find(".comment_write_date").html(commentData.commentWriteDate);
					commentDiv.find(".comment").html(commentData.comment);
					commentDiv.on("click",".inner_comment_write > a",function(){
						$(this).parents(".comment_div").append($(".comment_write"));
					});
					
					$(id).append(commentDiv);
				}
			}else{
				$(id).append("<p class='comment_empty'>등록된 댓글이 없습니다.</p>");
			}
			
			
			
		}
		
		
		function getArticleDetail(articleNum,msg){
			var EMPTY_ARTICLE_DETAIL = -1;
			
			if(articleNum !== EMPTY_ARTICLE_DETAIL){
				
				var ajaxResult = callAjax(null,'${pageContext.request.contextPath}/assets/json/community/board/articleDetail/'+articleNum+'.json',null,'get','json');
				
				ajaxResult.done(function(serverData) {
					if(serverData){
						var data = serverData.OUTPUT;
						$("#title").html(data.articleTitle);
						$("#writer").html(data.articleWriter);
						$("#writeDate").html(data.articleWriteDate);
						$("#read").html(data.articleRead);
						$("#content").html(data.articleContent);
						$("#articleNum").val(data.articleNum);
						
						
						createComment(data);
						
						
						next = data.articleNext;
						prev = data.articlePrev;
					}else{
						alert("게시물이 없습니다.");
					}
				});
			}else{
				alert(msg);
			}
			
		}
		
		getArticleDetail("${actionTarget}");
		
		$("#prev").click(function(){
			getArticleDetail(prev,"이전 글은 없습니다.");
		});
		
		$("#next").click(function(){
			getArticleDetail(next,"다음 글은 없습니다.");
		});
		
	});
	// ]]>
</script>
</head>

<body id="demo_body">
	<div>
		<div>
			<h3 class="quick-look-title" id="title">
			</h3>
		</div>
		<div class="quick-look-description bm-medium">
			<strong class="title_info">글 쓴이</strong>
			<span id="writer" class="content_info"></span>
			<strong class="title_info">작성시간</strong>
			<span id="writeDate" class="content_info"></span>
			<strong class="title_info">글 조회</strong>
			<span id="read" class="content_info"></span>
		</div>

		<hr>

		<div>
			<div class="top_btn">
				<ul class="float-left">
					<li>
						<a id="prev">이전글</a>
					</li>
					<li>
						<a id="next">다음글</a>
					</li>
				</ul>
				
				<ul class="float-right">
					<li>
						<a>수정</a>
					</li>
					<li>
						<a>삭제</a>
					</li>
					<li>
						<a>목록</a>
					</li>
					<li>
						<a>답변</a>
					</li>
					<li>
						<a>글쓰기</a>
					</li>
					
				</ul>
			</div>
			<div class="content">
				<h2>내용</h2>
			
				<div id="content">
			
				</div>
			</div>
			<div class="comment_area" id="comment">
				<h3>댓글목록</h3>
			</div>
			
			<div class="comment_write">
				<form action="">
					<table>
						<tbody>
							<tr>
								<th scope="row">이름</th>
								<td>
									<input type="text">
								</td>
							</tr>
							<tr>
								<th scope="row">비밀번호</th>
								<td>
									<input type="text">
								</td>
							</tr>
							<tr>
								<th scope="row">비밀글사용</th>
								<td>
									<input type="checkbox">
								</td>
							</tr>
							<tr>
								<th scope="row">자동등록방지</th>
								<td>
								
								</td>
							</tr>
							<tr>
								<th scope="row">내용</th>
								<td>
									<textarea>
									</textarea>
								</td>
							</tr>
						</tbody>
					</table>
					<div>
						<button>
							댓글등록
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
