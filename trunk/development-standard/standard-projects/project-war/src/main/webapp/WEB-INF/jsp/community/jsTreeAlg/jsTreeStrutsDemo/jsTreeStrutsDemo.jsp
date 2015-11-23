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
<style type="text/css">
	#demo{
		overflow:auto;
		max-height:469px;
		float: left;
		background:#fff;
	}
	
	.demo_side{width:30%;margin:30px 0;border-top:1px solid #000;}
	.dataTables_filter, .dataTables_length{display:none}
	.demo_con{width:68%;float:right;margin:30px 0;border-top:1px solid #000;} 
	.demo_con table tbody tr td{text-align:center;}
	.demo_con table tbody tr.child td{text-align:left;}
	@media only screen and (max-width: 768px){ 
		.demo_side{width:100%;}
		.demo_con{width:100%;}
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


								<div class="clearfix">
									<customTags:jstree 
										createId="demo"
										createClass="demo demo_side"
										target="#demo"
										dataTableReload="true"
										dataTable="jstreeTable"
										getChildNode="${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/getChildNode.action"
										searchNode="${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/searchNode.action"
										addNode="${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/addNode.action"
										removeNode="${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/removeNode.action"
										alterNode="${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/alterNode.action"
										alterNodeType="${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/alterNodeType.action"
										moveNode="${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/moveNode.action">
									</customTags:jstree>
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