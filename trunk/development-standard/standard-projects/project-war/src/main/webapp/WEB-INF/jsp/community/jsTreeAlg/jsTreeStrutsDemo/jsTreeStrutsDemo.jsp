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
<!--[if lt IE 7 ]> <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie6 older"> <![endif]-->
<!--[if IE 7 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie7 older"> <![endif]-->
<!--[if IE 8 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie8"> <![endif]-->
<!--[if IE 9 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="ko-KR">
<!--<![endif]-->
<head>
<!-- JSTREE -->
<customTags:assetsJsExtendNas theRestOfFileName="/js/jstree-v.pre1.0/_lib/jquery.cookie.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/jstree-v.pre1.0/_lib/jquery.hotkeys.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/jstree-v.pre1.0/jquery.jstree.js"></customTags:assetsJsExtendNas>

<!-- dataTable -->
<customTags:assetsCssExtendNas theRestOfFileName="/js/DataTables-1.10.4/media/css/jquery.dataTables.css"></customTags:assetsCssExtendNas>
<customTags:assetsCssExtendNas theRestOfFileName="/js/DataTables-1.10.4/extensions/Responsive/css/dataTables.responsive.css"></customTags:assetsCssExtendNas>

<customTags:assetsJsExtendNas theRestOfFileName="/js/DataTables-1.10.4/media/js/jquery.dataTables.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/DataTables-1.10.4/extensions/Responsive/js/dataTables.responsive.js"></customTags:assetsJsExtendNas>

<!-- Style Setting --> 
<style type="text/css">
	#demo {
		overflow:auto;
		max-height:469px;
		float: left;
		background:#fff;
	}

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

	.demo_side{width:30%;margin:30px 0;border-top:1px solid #000;}
	.demo_con{width:68%;float:right;margin:30px 0;border-top:1px solid #000;} 
	.demo_con table tbody tr td{text-align:center;}
	.demo_con table tbody tr.child td{text-align:left;}
	.dataTables_filter, .dataTables_length{display:none}

	table.dataTable.dtr-inline.collapsed tbody td:first-child:before, table.dataTable.dtr-inline.collapsed tbody th:first-child:before {top:50%;margin-top:-10px;}

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
								JAVA &amp; Oracle ( struts2 + Ibatis ) demo + event order
							</h1>
							<p class="bm-remove">
								<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
								&nbsp;/&nbsp;
								JsTree
								&nbsp;/&nbsp;
								Struts Demo
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

								<div id="mmenu" style="clear:both;" class="clearfix">
									<form class="niceform">
										<div class="desktop-tablet alpha boxed bm-remove btn_wrap01">
											<button type="button" id="add_folder"><i class="fa fa-plus"></i> add folder</button>
											<button type="button" id="add_default"><i class="fa fa-plus"></i> add file</button>
											<button type="button" id="rename"><i class="fa fa-eraser"></i> rename</button>
											<button type="button" id="remove"><i class="fa fa-minus"></i> remove</button>
											<button type="button" id="cut"><i class="fa fa-cut"></i> cut</button>
											<button type="button" id="copy"><i class="fa fa-copy"></i> copy</button>
											<button type="button" id="paste"><i class="fa fa-paste"></i> paste</button>
										</div>
										<div class="desktop-tablet alpha bm-remove boxed last btn_wrap02">
											<div class="textInputVerticalCenter">
												<input type="text" id="text" placeholder="찾을 노드 이름 입력" class="inline-block bm-remove tip-r-fade" data-tooltip="Press Enter To Node To Search"/>
											</div>
											<button type="button" id="search" title="Search"><i class="fa fa-search"></i></button>
											<button type="button" id="clear_search" title="Clear"><i class="fa fa-eraser"></i></button>
										</div>
									</form>
								</div>

								<div class="clearfix">
									<div id="demo" class="demo demo_side">
									</div>

									<div class="demo_con">
										<table id="jstreeTable" class="display responsive no-wrap" cellspacing="0" width="100%">
											<thead>
												<tr>
													<th>c_id</th>
													<th>c_parentid</th>
													<th>c_position</th>
													<th>c_left</th>
													<th>c_right</th>
													<th>c_level</th>
													<th>c_title</th>
													<th>c_type</th>
												</tr>
											</thead>
										</table>
									</div>
								</div>

								<div class="clearfix">
									<input type="button" value="reconstruct" onclick="javascript:alert('not supprt')" />
									<input type="button"  id="analyze" value="analyze" onclick="$('#alog').load('${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/analyzeNode.action');" />
									<input type="button"  value="refresh" onclick="$('#demo').jstree('refresh',-1);" />
								</div>
								<div id='alog' style="float:left; border:1px solid gray; padding:5px; height:150px; margin-top:15px; overflow:auto; width: 100%;max-width:1180px;"></div>

								<customTags:jstree 
									target="#demo"
									getChildNode="${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/getChildNode.action"
									searchNode="${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/searchNode.action"
									addNode="${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/addNode.action"
									removeNode="${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/removeNode.action"
									alterNode="${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/alterNode.action"
									alterNodeType="${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/alterNodeType.action"
									moveNode="${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/moveNode.action">
								</customTags:jstree>
								<!-- JavaScript neccessary for the tree -->
								<script type="text/javascript">
								function jstreeDataTableReload() {
									var jstreeDataTable = $('#jstreeTable').dataTable( {
										"ajax": {
											"url": "${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/jstreeMonitor/getJstreeMonitor.action",
											"dataSrc": "rows"
										},
										"processing": true,
										"responsive": true,
										"columns": [
											{ "data": "cell.0" },
											{ "data": "cell.1" },
											{ "data": "cell.2" },
											{ "data": "cell.3" },
											{ "data": "cell.4" },
											{ "data": "cell.5" },
											{ "data": "cell.6" },
											{ "data": "cell.7" }
										]
									} );
									jstreeDataTable.api().ajax.reload();
								}

								$(function () {

								var jstreeDataTable = $('#jstreeTable').dataTable( {
									"ajax": {
										"url": "${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/jstreeMonitor/getJstreeMonitor.action",
										"dataSrc": "rows"
									},
									"processing": true,
									"responsive": true,
									"columns": [
										{ "data": "cell.0" },
										{ "data": "cell.1" },
										{ "data": "cell.2" },
										{ "data": "cell.3" },
										{ "data": "cell.4" },
										{ "data": "cell.5" },
										{ "data": "cell.6" },
										{ "data": "cell.7" }
									]
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