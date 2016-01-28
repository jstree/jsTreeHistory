<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" autoFlush="true"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<!DOCTYPE html> 
<html lang="ko-KR">
<head>
<!-- dataTable -->
<customTags:assetsCssExtendNas theRestOfFileName="/js/DataTables-1.10.10/media/css/jquery.dataTables.css"></customTags:assetsCssExtendNas>
<customTags:assetsCssExtendNas theRestOfFileName="/js/DataTables-1.10.10/extensions/Responsive/css/responsive.dataTables.css"></customTags:assetsCssExtendNas>

<customTags:assetsJsExtendNas theRestOfFileName="/js/DataTables-1.10.10/media/js/jquery.dataTables.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/DataTables-1.10.10/extensions/Responsive/js/dataTables.responsive.js"></customTags:assetsJsExtendNas>

<!-- Add mousewheel plugin (this is optional) -->
<customTags:assetsJsExtendNas theRestOfFileName="/js/fancyBox-2.1.5/lib/jquery.mousewheel-3.0.6.pack.js"></customTags:assetsJsExtendNas>

<!-- Add fancyBox main JS and CSS files -->
<customTags:assetsJsExtendNas theRestOfFileName="/js/fancyBox-2.1.5/source/jquery.fancybox.js?v=2.1.5"></customTags:assetsJsExtendNas>
<customTags:assetsCssExtendNas theRestOfFileName="/js/fancyBox-2.1.5/source/jquery.fancybox.css?v=2.1.5"></customTags:assetsCssExtendNas>

<!-- Add Button helper (this is optional) -->
<customTags:assetsCssExtendNas theRestOfFileName="/js/fancyBox-2.1.5/source/helpers/jquery.fancybox-buttons.css?v=1.0.5"></customTags:assetsCssExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/fancyBox-2.1.5/source/helpers/jquery.fancybox-buttons.js?v=1.0.5"></customTags:assetsJsExtendNas>

<!-- Add Thumbnail helper (this is optional) -->
<customTags:assetsCssExtendNas theRestOfFileName="/js/fancyBox-2.1.5/source/helpers/jquery.fancybox-thumbs.css?v=1.0.7"></customTags:assetsCssExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/fancyBox-2.1.5/source/helpers/jquery.fancybox-thumbs.js?v=1.0.7"></customTags:assetsJsExtendNas>

<!-- Add Media helper (this is optional) -->
<customTags:assetsJsExtendNas theRestOfFileName="/js/fancyBox-2.1.5/source/helpers/jquery.fancybox-media.js?v=1.0.6"></customTags:assetsJsExtendNas>
<!-- Style Setting --> 
<style type="text/css">
	input[type="button"] {
		display: inline-block;
		min-width: 100px;
		min-height: 30px;
		margin: 5px 0 5px 5px;
		outline: none;
		border: 1px solid #f45b4f;
		border-top-width: 0px;
		border-right-width: 0px;
		border-bottom-width: 0px;
		border-left-width: 0px;
		-webkit-border-top-left-radius: 0px;
		-webkit-border-top-right-radius: 0px;
		-webkit-border-bottom-right-radius: 0px;
		-webkit-border-bottom-left-radius: 0px;
		-moz-border-top-left-radius: 0px;
		-moz-border-top-right-radius: 0px;
		-moz-border-bottom-right-radius: 0px;
		-moz-border-bottom-left-radius: 0px;
		border-top-left-radius: 0px;
		border-top-right-radius: 0px;
		border-bottom-right-radius: 0px;
		border-bottom-left-radius: 0px;
		padding: 10px;
		background: #f45b4f;
		color: #fff;
		font-size: 1em;
		font-weight: 400;
		font-variant: normal;
		text-align: center;
		letter-spacing: 0em;
		line-height: normal;
		-webkit-transition: all 0.2s ease-in-out;
		-moz-transition: all 0.2s ease-in-out;
		-o-transition: all 0.2s ease-in-out;
		-ms-transition: all 0.2s ease-in-out;
		transition: all 0.2s ease-in-out;
	}
	.btn_wrap01{overflow:hidden;width:50%;float:left;} 
	.btn_wrap01 button{display;block;float:left;margin:0;padding:0;width:14%;min-width:0;border-left:1px solid #fff;}
	.btn_wrap01 button:first-child{border-left:0;}
	.btn_wrap02{width:50%;float:right;}
	.btn_wrap02 .textInputVerticalCenter{width:69%;float:left;}
	.btn_wrap02 button{display;block;float:left;margin:0;padding:0;;min-width:0;width:15%;border-left:1px solid #fff;}
	.btn_wrap02 input[type="text"]{width:100%}

	.demo_con{width:100%;float:right;margin:10px 0;} 
	.demo_con table tbody tr td{text-align:center;}
	.demo_con table tbody tr.child td{text-align:left;}
	.dataTables_filter, .dataTables_length{display:none}


	@media only screen and (max-width: 768px){ 
		.btn_wrap01{width:100%}
		.btn_wrap01 button{border-bottom:1px solid #fff;}
		.btn_wrap01 button:first-child{width:100%;}
		.btn_wrap02{width:100%;margin-top:10px}
		.demo_side{width:100%;}
		.demo_con{width:100%;}
	}
	@media only screen and (min-width:481px) and (max-width: 768px){
		.btn_wrap01 button{width:33.33%;}
		.btn_wrap01 button:nth-child(3n-1){border-left:0;}
	}
	@media only screen and (max-width: 480px) {
		.btn_wrap01 button{width:50%;}
		.btn_wrap01 button:nth-child(2n){border-left:0;}
		
	}
	
	#dataTableTitle{
		color: black !important;
	}
	
</style>

<!-- JavaScript neccessary for the tree -->
<script type="text/javascript">

	$(document).ready(function () {
		dataTableSetup();
		$('.fancybox').fancybox({
			'width':900,
            'height':900,
            'autoSize' : false
            });
		
		$("#add_default").click(function() {
			$.fancybox.open({
				href : 'addArticlePopup.do',
				type : 'ajax',
				padding : 5
			});
		});
		
		$(window).load(function() {
			
	    });
		
	});
	
	function dataTableSetup() {
		
		jstreeDataTableModule = $('#jstreeTable').DataTable( {
			"ajax": {
				"url": "${pageContext.request.contextPath}/assets/json/community/board/list.json",
				"dataSrc": "OUTPUT.rows"
			},
			"processing": true,
			"responsive": true,
			"pagingType": "full_numbers",
			"columnDefs": [ 
			                	{ 	
			                		"targets": 1,
			                		"width": "70%", 
			                        'searchable': true,
			                        'orderable': false,
			                        'className': 'dt-body-center',
			                        'render': function (data, type, row){
			                        	return '<a href="viewPopup.do?actionTarget=' + row.articleNum + '" id="dataTableTitle" class="fancybox fancybox.ajax">' + data + '</a>';
			                        }
			                	}
			                ],
               "createdRow": function ( row, data, index ) {
                       $('td', row).eq(1).addClass('quick-look');
               },
				"columns": [
					{ "data": "articleNum" },
					{ "data": "articleTitle" },
					{ "data": "articleRead" },
					{ "data": "articleWriter" }
				]
		});
		
		
		$('#jstreeTable tbody').on('click', 'tr', function () {
			
	    } );
		
	}
</script>
</head> 

<body id="demo_body">
	<section class="clearfix" >
		<div id="jsTreeContainer">

			<nav>
				<div class="container bm-medium">
					<div class="one-whole">
						<div class="no-display">article</div>
						<div class="text-center">
							<h1 class="bm-remove">
								jsTree Service Framework Engine Free Board
							</h1>
							<p class="bm-remove">
								<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
								&nbsp;/&nbsp;
								Free Board
								&nbsp;/&nbsp;
								List
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
								<div id="description">
									<div class="clearfix">
									
										<div id="mmenu" style="clear:both;" class="clearfix">
												<div class="desktop-tablet alpha boxed bm-remove btn_wrap01">
														<button type="button" id="blank"><i class="fa fa-list-ol"></i> Show</button>
														<select name="jstreeTable_length" aria-controls="jstreeTable" id="jstreeTable_length" class="inline-block bm-remove w-small tip-r-fade clearfix" data-tooltip="Sort By" data-anim-type="fade-in" data-anim-delay="0" original-title="">
															<option value="10">10</option>
															<option value="25">25</option>
															<option value="50">50</option>
															<option value="100">100</option>
														</select>
														
												</div>
												<div class="desktop-tablet alpha bm-remove boxed last btn_wrap02">
													<div class="textInputVerticalCenter">
														<input type="text" id="text" placeholder="찾을 노드 이름 입력" class="inline-block bm-remove tip-r-fade" data-tooltip="Press Enter To Node To Search">
													</div>
													<button type="button" id="search" title="Search"><i class="fa fa-search"></i></button>
													<button type="button" id="add_default"><i class="fa fa-plus"></i> 글 쓰기</button>
												</div>
										</div>
										
										<div class="demo_con">
											<table id="jstreeTable" class="display responsive no-wrap" cellspacing="0" width="100%">
												<thead>
													<tr>
											            <th rowspan="2">글 번호</th>
											            <th colspan="2">자유 게시판 ( 비회원 게시판 )</th>
											            <th rowspan="2">글 쓴이</th>
											        </tr>
													<tr>
														<th>제 목</th>
														<th>글 조회</th>
													</tr>
												</thead>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</article>
		</div>
	</section>
</body>
</html> 