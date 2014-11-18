<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko" class="no-js">
<!--<![endif]-->
	<head>
		<style type="text/css">
			#egovNotice .invisible{
				display:none;
			}
			#egovNotice textarea{
				max-width:100%;
			}
			#egovNotice input[type="text"], input[type="password"], input[type="email"], input[type="search"], input[type="tel"], input[type="url"], input[type="number"], input[type="file"], select, textarea{
				margin:5px;
			} 
			#egovNotice #search_field_loc,caption{
				display:none;
			}
			table {
				width : 100%
			}
			table thead tr {
			    border: 1px solid #e8e8e8;
			    border-right: 0;
			    border-left: 0;
			    background: #f7f7f7;
			    
			}
			table thead tr th {
				padding: 0 10px;
			    color: #474747;
			    line-height: 50px;
			    font-weight: inherit;
			}
			table tbody tr {
			    border: 1px solid #e8e8e8;
			    border-right: 0;
			    border-left: 0;
			    line-height: 50px;
			}
			table tbody tr td {
				padding: 0 10px;
			    color: #474747;
			    line-height: 50px;
			    font-weight: inherit;
			    text-align:center;
			    vertical-align:middle;
			}
			table tbody tr td input[type="submit"]{
				width:320px;
				border:solid 0px black;  !important;
				color: #000; !important;
				background: #fff; !important; 
				text-align:left;
			}
			table tbody tr td input[type="submit"]:hover {
				width:320px;
				border:solid 0px black;  !important;
				color: #000; !important;
				background: #fff; !important; 
				text-align:left;
			}
		</style>
		
		<script type="text/javascript">
		function a(){
			fn_egov_moveUpdt_notice = function(){
		 	    $.ajax({ 
		 	        data: $("form[name='frm']").serialize(),
		 	        type: $("form[name='frm']").attr('method'),
		 	        url: "cop/bbs/forUpdateBoardArticle.do",
		 	        success: function(response) {
		 	            console.log("fn_egov_moveUpdt_notice--> ajax! success");
		 	           $("#article>div").html($(response).find("div#egovNotice"));
		 	           /*
		 	           fn_egov_regist_notice = function(){
			 	         $.ajax({ 
					 	        data: $("form[name='board']").serialize(),
					 	        type: $("form[name='board']").attr('method'),
					 	        url: "cop/bbs/updateBoardArticle.do",
					 	       	contentType: false,
					            processData: false,
					 	        success: function(response) {
					 	            console.log("fn_egov_regist_notice--> ajax! success");
					 	           $("#article>div").html($(response).find("div#egovNotice"));
					 	        }
					 	  });
		 	           }
		 	           */
		 	          }
		 	    });
		 	    return false; 
		 	}
		}
		function bindSumitNoticeList(){
			fn_egov_select_noticeList = function(pageNo){
	        	  	document.frm.pageIndex.value=pageNo;
		 	    $.ajax({ 
		 	        data: $("form[name='frm']").serialize(),
		 	        type: $("form[name='frm']").attr('method'),
		 	        url: $("form[name='frm']").attr('action'),
		 	       	success: function(response) {
		 	            console.log("fn_egov_select_noticeList--> ajax! success");
		 	           $("#article>div").html($(response).find("div#egovNotice"));
		 	          bindSumitSelectArticle();
		 	        }
		 	    });
		 	    return false; 
		 	}
		}
		function bindSumitSelectArticle(){
			$("#article>div").find("form[name='subForm']").submit(function() { 
		 	    $.ajax({ 
		 	        data: $(this).serialize(),
		 	        type: $(this).attr('method'),
		 	        url: $(this).attr('action'),
		 	        success: function(response) {
		 	            console.log("ajax Success!");
		 	            $("#article>div").html($(response).find("div#egovNotice"));
		 	           bindSumitNoticeList();
		 	        }
		 	    });
		 	    return false; 
		 	});
		}
		/*
		 * notice.html 을 최초 호출시 공지사항을 Load 해온다.
		 */
		$(document).ready(function() {
		 	$("#article>div").load("/cop/bbs/selectBoardList.do?bbsId=BBSMSTR_AAAAAAAAAAAA #egovNotice",function(){
		 		bindSumitSelectArticle();
		 	});
		});
		</script>	
	</head>
	<body>
		<section class="clearfix" >
			<nav>
				<div class="container bm-medium">
					<div class="one-whole">
						<div class="no-display">article</div>
						<div class="text-center">
							<h1 class="bm-remove">
								공지사항
							</h1>
						</div>
					</div>
				</div>
			</nav>
			<article>
				<div class="clearfix">
					<div class="container bm-remove">
						<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
							<div class="article-body rte" itemprop="articleBody">
								
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</body>
</html>
