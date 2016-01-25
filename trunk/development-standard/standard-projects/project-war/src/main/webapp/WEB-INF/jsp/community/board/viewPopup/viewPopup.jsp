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
	.title_info{
		padding-right: 10px;
	}
	
	.content_info{
		padding-right: 20px;
	}
</style>

<!-- JavaScript neccessary for the tree -->
<script type="text/javascript">
	// <![CDATA[
	$(document).ready(function($) {
		var next = 0;
		var prev = 0;
		
		
		function getArticleDetail(articleNum,msg){
			var EMPTY_ARTICLE_DETAIL = -1;
			
			if(articleNum !== EMPTY_ARTICLE_DETAIL){
				$.ajax({dataType : 'json',
						url : '${pageContext.request.contextPath}/assets/json/community/board/articleDetail/'+articleNum+'.json'
				}).done(function(serverData) {
					var data = serverData.OUTPUT;
					console.log(data);
					$("#title").html(data.articleTitle);
					$("#writer").html(data.articleWriter);
					$("#writeDate").html(data.articleWriteDate);
					$("#read").html(data.articleRead);
					$("#content").html(data.articleContent);
					$("#articleNum").val(data.articleNum);
					
					next = data.articleNext;
					prev = data.articlePrev;
					
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
	<div class="quick-look-markup">
		<div class="two-third-percent omega bm-remove">
			<h3 class="quick-look-title bm-small" id="title">
			</h3>
		</div>
		<hr>

		<div class="clearfix">
			<div class="two-third-percent alpha bm-remove last">
				<div class="quick-look-description bm-medium">
					<strong class="title_info">글 쓴이</strong>
					<span id="writer" class="content_info"></span>
					<strong class="title_info">작성시간</strong>
					<span id="writeDate" class="content_info"></span>
					<strong class="title_info">글 조회</strong>
					<span id="read" class="content_info"></span>
				</div>
				<div id="content">
				
				</div>

				<div class="quick-look-available clearfix last">

					<div class="two-third-percent bm-remove alpha last">
						<div class="input-quantity-container clearfix">
							<a href="#" id="prev" target="_self" class="input-quantity-minus tip-t-fade" data-tooltip="prev">
								<i class="fa fa-minus fa-fw"></i>
							</a>
							<input type="text" id="articleNum" class="input-quantity"> 
							<a href="#" id="next" target="_self" class="input-quantity-plus tip-t-fade" data-tooltip="next">
								<i class="fa fa-plus fa-fw"></i>
							</a>
						</div>
					</div>

					<button type="button" class="bm-remove float-right">
						닫기
					</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
