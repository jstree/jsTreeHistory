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

<!-- Style Setting --> 
<style type="text/css">
	.NFText{
		width: 200px;
	}

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
		font-family: Oxygen,sans-serif;
		font-size: 1em;
		font-weight: 400;
		font-variant: normal;
		text-align: center;
		text-transform: uppercase;
		letter-spacing: 0em;
		line-height: normal;
		-webkit-transition: all 0.2s ease-in-out;
		-moz-transition: all 0.2s ease-in-out;
		-o-transition: all 0.2s ease-in-out;
		-ms-transition: all 0.2s ease-in-out;
		transition: all 0.2s ease-in-out;
	}
	button{text-transform:capitalize;}
	.btn_wrap01{overflow:hidden;width:74%;float:left;} 
	.btn_wrap01 button{display;block;float:left;margin:0;padding:0;width:14%;min-width:0;border-left:1px solid #fff;}
	.btn_wrap01 button:first-child{border-left:0;}
	.btn_wrap02{width:26%;float:right;}
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
	</style>
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
										<div id="jstreeTable_length" class="desktop-tablet alpha boxed bm-remove btn_wrap01">
											<label>Show 
												<select name="jstreeTable_length" aria-controls="jstreeTable" id="jstreeTable_length" class="inline-block bm-remove w-small tip-r-fade clearfix" data-tooltip="Sort By" data-anim-type="fade-in" data-anim-delay="0" original-title="">
													<option value="10">10</option>
													<option value="25">25</option>
													<option value="50">50</option>
													<option value="100">100</option>
												</select>
											</label>
										</div>
										<div class="desktop-tablet alpha boxed bm-remove btn_wrap02">
											<input type="text" id="text" placeholder="검색" class="inline-block bm-remove tip-r-fade" data-tooltip="Press Enter To Node To Search" original-title="">
										</div>
										<div class="demo_con">
											<table id="jstreeTable" class="display responsive no-wrap" cellspacing="0" width="100%">
												<thead>
													<tr>
											            <th rowspan="2">글 번호</th>
											            <th colspan="2">글 정보</th>
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
			
									<!-- JavaScript neccessary for the tree -->
									<script type="text/javascript">
										function jstreeDataTableReload() {
											var jstreeDataTable = $('#jstreeTable').dataTable( {
												"ajax": {
													"url": "${pageContext.request.contextPath}/assets/json/community/board/list.json",
													"dataSrc": "OUTPUT.rows"
												},
												"processing": true,
												"responsive": true,
												"pagingType": "full_numbers",
												"lengthMenu": [[1, 10, 25, 50],[1, 10, 25, 50]],
												"columns": [
													{ "data": "articleNum" },
													{ "data": "articleTitle" },
													{ "data": "articleRead" },
													{ "data": "articleWriter" }
												]
											} );
											jstreeDataTable.api().ajax.reload();
										}
						
										$(function () {
											var jstreeDataTable = $('#jstreeTable').DataTable( {
												"ajax": {
													"url": "${pageContext.request.contextPath}/assets/json/community/board/list.json",
													"dataSrc": "OUTPUT.rows"
												},
												"processing": true,
												"responsive": true,
												"pagingType": "full_numbers",
												"columns": [
													{ "data": "articleNum" },
													{ "data": "articleTitle" },
													{ "data": "articleRead" },
													{ "data": "articleWriter" }
												]
											});
											
											$('#jstreeTable tbody').on('click', 'tr', function () {
										        var data = jstreeDataTable.row( this ).data();
										        alert( 'You clicked on '+data.articleNum+'\'s row' );
										    } );
										});
									</script>
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