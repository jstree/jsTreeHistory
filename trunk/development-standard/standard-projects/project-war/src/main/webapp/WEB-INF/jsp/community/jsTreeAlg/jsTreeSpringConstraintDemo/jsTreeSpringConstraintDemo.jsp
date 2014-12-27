<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" autoFlush="true"%>

<!DOCTYPE html> 
<html lang="ko">
<head>
<meta http-equiv="Content-Language" content="ko" >
<!-- JSTREE -->
<script src="${pageContext.request.contextPath}/js/community/jsTreeAlg/jstreeDemo/jstree-v.pre1.0/jquery.jstree.js?20" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/community/jsTreeAlg/jstreeDemo/jstree-v.pre1.0/_lib/jquery.cookie.js?20" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/community/jsTreeAlg/jstreeDemo/jstree-v.pre1.0/_lib/jquery.hotkeys.js?20" type="text/javascript"></script>


<!-- dataTable -->
<link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.4/css/jquery.dataTables.css" />
<link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/responsive/1.0.3/css/dataTables.responsive.css" />
<script type="text/javascript" language="javascript" src="http://cdn.datatables.net/1.10.4/js/jquery.dataTables.js"></script>
<script type="text/javascript" language="javascript" src="http://cdn.datatables.net/responsive/1.0.3/js/dataTables.responsive.js"></script>

<!-- 메뉴관리 jquery ui dialog 임시로 추가 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css" />

<!-- Style Setting --> 
<style type="text/css">
	#demo {
		overflow:auto;
		max-height:469px;
		float: left;background:#fff;
	}
	
	#demo_f {
		overflow:auto;
		max-height:469px;
		float: left;background:#fff;
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
				JAVA &amp; Oracle ( Spring + Ibatis ) PK FK Constraint demo
			</h1>
			<p class="bm-remove">
				<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
				&nbsp;/&nbsp;
				JsTree
				&nbsp;/&nbsp;
				Spring PK FK Constraint Demo
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
									<th>f_c_id</th>
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

				<!-- JavaScript neccessary for the tree -->
				<script type="text/javascript">
				function jstreeDataTableReload() {
					var jstreeDataTable = $('#jstreeTable').dataTable( {
						"ajax": {
							"url": "${pageContext.request.contextPath}/constraint/monitor/primary/list.do",
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
							{ "data": "cell.7" },
							{ "data": "cell.8" }
						]
					} );
					jstreeDataTable.api().ajax.reload();
				}
				
				$(function () {
					
				$("#nodeForm").dialog({
					height   : 300
				  , width    : 400					
				  , modal    : true
				  , autoOpen : false
				});					

				var jstreeDataTable = $('#jstreeTable').dataTable( {
					"ajax": {
						"url": "${pageContext.request.contextPath}/constraint/monitor/primary/list.do",
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
						{ "data": "cell.7" },
						{ "data": "cell.8" }
					]
				} );

					
				$("#demo")
					.bind("before.jstree", function (e, data) {
						$("#alog").append(data.func + "<br />");
					})
					.jstree({ 
						// List of active plugins
						"plugins" : [ 
							"themes","json_data","ui","crrm","cookies","dnd","search","types","hotkeys","contextmenu","checkbox"
						],
						
						//contextmenu
						"contextmenu" : 
						{         
							items : 
							{ // Could be a function that should return an object like this one             
								"create" : 
								{                 
									"separator_before"  : true,                  
									"separator_after"   : true,                 
									"label"             : "Create",                 
									"action"            : false,                 
									"submenu" :
									{                     
										"create_file" :  
										{                         
											"seperator_before" : false,                         
											"seperator_after" : false,                         
											"label" : "File",                         
											action : function (obj) 
											{
												// 파일인 경우에 실행하지 않는다
												if( $(obj).attr("rel") != 'default' ){
													
													var _this = this;
													
													$.post(
															"${pageContext.request.contextPath}/constraint/foreign/getChildNode.do",
														{ 
															"c_id" : "3"
														}, 
														function (r) {
															
															var jsonArrLength = r.length;
															for (var i = 0; i < jsonArrLength; i++) {

																var c_title;
																var c_id;

																var jsonData = r[i];
																for (var key in jsonData) {
																	
																	if ("c_id" == key) {
																		c_id = $(jsonData).attr(key);
																	} else if ("c_title" == key) {
																		c_title = $(jsonData).attr(key);
																	} else {
																		continue;
																	}
																	
																}
																
																$("#authority").append(function(){
																	if (i == jsonArrLength - 1) {
																		return $("<option>", {value : c_id, text : c_title, selected : true});
																	} 
																	
																	return $("<option>", {value : c_id, text : c_title});
																});
																	
															}
															
// 															$("#authority").selectmenu();
														}
													);
													
													$("#nodeForm").dialog({
														title  : "권한 추가"
													  ,	buttons: {
													        Ok    : function() {
													        	_this.create(obj, "last", {"attr" : {"rel" : "default", "f_c_id" : $("#authority").val()}});
													        	$("#nodeForm").dialog("close");
													        	$("#authority > option").remove();
													        },
													        Cancel: function() {
													            $("#nodeForm").dialog("close");
													            $("#authority > option").remove();
													        }
													    }
													});
													$("#nodeForm").dialog("open");
												}												
												
											}                     
										},                     
										"create_folder" :  
										{                         
											"seperator_before" : false,                         
											"seperator_after" : false,                         
											"label" : "Folder",                          
											action : function (obj)  
											{
												// 파일인 경우에 실행하지 않는다
												if( $(obj).attr("rel") != 'default' ){
													var _this = this;
													
													$.post(
															"${pageContext.request.contextPath}/constraint/foreign/getChildNode.do",
														{ 
															"c_id" : "3"
														}, 
														function (r) {
															
															var jsonArrLength = r.length;
															for (var i = 0; i < jsonArrLength; i++) {

																var c_title;
																var c_id;

																var jsonData = r[i];
																for (var key in jsonData) {
																	
																	if ("c_id" == key) {
																		c_id = $(jsonData).attr(key);
																	} else if ("c_title" == key) {
																		c_title = $(jsonData).attr(key);
																	} else {
																		continue;
																	}
																	
																}
																
																$("#authority").append(function(){
																	if (i == jsonArrLength - 1) {
																		return $("<option>", {value : c_id, text : c_title, selected : true});
																	} 
																	
																	return $("<option>", {value : c_id, text : c_title});
																});
																	
															}
															
// 															$("#authority").selectmenu();
														}
													);
													
													$("#nodeForm").dialog({
														title  : "권한 추가"
													  ,	buttons: {
													        Ok    : function() {
																_this.create(obj, "last", {"attr" : { "rel" : "folder", "f_c_id" : $("#authority").val()}});
													        	$("#nodeForm").dialog("close");
													        	$("#authority > option").remove();
													        },
													        Cancel: function() {
													            $("#nodeForm").dialog("close");
													            $("#authority > option").remove();
													        }
													    }
													});
													$("#nodeForm").dialog("open");
												}
												
											}                      
										}
										
									}             
								}
							
								
								,"ccp" :  
								{                 
									"separator_before"  : false,                 
									"separator_after"   : true,                 
									"label"             : "Edit",                 
									"action"            : false,                 
									"submenu" :
									{                     
										"cut" :  
										{                         
											"seperator_before" : false,                         
											"seperator_after" : false,                         
											"label" : "Cut",                         
											action : function (obj) 
											{                             
												this.cut(obj, "last", {"attr" : {"rel" : "default"}});                         
											}                     
										},                     
										"paste" :  
										{                         
											"seperator_before" : false,                         
											"seperator_after" : false,                         
											"label" : "Paste",                          
											action : function (obj)  
											{                                                            
												this.paste(obj, "last", {"attr" : { "rel" : "folder"}});                         
											}                      
										},
										
										"changeType" :  
										{                         
											"seperator_before" : false,                         
											"seperator_after" : false,                         
											"label" : "Change Type",             
											"submenu" :
											{
												"toFile" :  
												{                         
													"seperator_before" : false,                         
													"seperator_after" : false,                         
													"label" : "toFile",                         
													action : function (obj) 
													{   
														this.set_type("default");                     
													}                     
												},                     
												"toFolder" :  
												{                         
													"seperator_before" : false,                         
													"seperator_after" : false,                         
													"label" : "toFolder",                          
													action : function (obj)  
													{                                                            
														this.set_type("folder");
													}                      
												}
											}                 
										}
										
									}             
								}				
				
							}     
						}, 
				
						// I usually configure the plugin that handles the data first
						// This example uses JSON as it is most common
						"json_data" : { 
							// This tree is ajax enabled - as this is most common, and maybe a bit more complex
							// All the options are almost the same as jQuery's AJAX (read the docs)
							"ajax" : {
								// the URL to fetch the data
								"url" : "${pageContext.request.contextPath}/constraint/primary/getChildNode.do",
								// the `data` function is executed in the instance's scope
								// the parameter is the node being loaded 
								// (may be -1, 0, or undefined when loading the root nodes)
								"data" : function (n) { 
									// the result is fed to the AJAX request `data` option
									return { 
										"c_id" : n.attr ? n.attr("id").replace("node_","").replace("copy_","") : 1 
									}; 
								}
							}
						},
						// Configuring the search plugin
						"search" : {
							// As this has been a common question - async search
							// Same as above - the `ajax` config option is actually jQuery's AJAX object
							"ajax" : {
								"url" : "${pageContext.request.contextPath}/constraint/primary/searchNode.do",
								// You get the search string as a parameter
								"data" : function (str) {
									return { 
										"searchString" : str 
									}; 
								}
							}
						},
						// Using types - most of the time this is an overkill
						// read the docs carefully to decide whether you need types
						"types" : {
							// I set both options to -2, as I do not need depth and children count checking
							// Those two checks may slow jstree a lot, so use only when needed
							"max_depth" : -2,
							"max_children" : -2,
							// I want only `drive` nodes to be root nodes 
							// This will prevent moving or creating any other type as a root node
							"valid_children" : [ "drive" ],
							"types" : {
								// The default type
								"default" : {
									// I want this type to have no children (so only leaf nodes)
									// In my case - those are files
									"valid_children" : "none",
									// If we specify an icon for the default type it WILL OVERRIDE the theme icons
									"icon" : {
										"image" : "http://www.313.co.kr/php/lh_7th/data/admin/pds/scriptPool/jQueryPlugIns/jstree-v.pre1.0/_demo/file.png"
									}
								},
								// The `folder` type
								"folder" : {
									// can have files and other folders inside of it, but NOT `drive` nodes
									"valid_children" : [ "default", "folder" ],
									"icon" : {
										"image" : "http://www.313.co.kr/php/lh_7th/data/admin/pds/scriptPool/jQueryPlugIns/jstree-v.pre1.0/_demo/folder.png"
									}
								},
								// The `drive` nodes 
								"drive" : {
									// can have files and folders inside, but NOT other `drive` nodes
									"valid_children" : [ "default", "folder" ],
									"icon" : {
										"image" : "http://www.313.co.kr/php/lh_7th/data/admin/pds/scriptPool/jQueryPlugIns/jstree-v.pre1.0/_demo/root.png"
									},
									// those prevent the functions with the same name to be used on `drive` nodes
									// internally the `before` event is used
									"start_drag" : false,
									"move_node" : false,
									"delete_node" : false,
									"remove" : false
								}
							}
						},
						// UI & core - the nodes to initially select and open will be overwritten by the cookie plugin
				
						// the UI plugin - it handles selecting/deselecting/hovering nodes
						"ui" : {
							// this makes the node with ID node_4 selected onload
							"initially_select" : [ "node_4" ]
						},
						// the core plugin - not many options here
						"core" : { 
							// just open those two nodes up
							// as this is an AJAX enabled tree, both will be downloaded from the server
							"initially_open" : [ "node_2" , "node_3" ] 
						}
					})
					.bind("create.jstree", function (e, data) {
						$.post(
							"${pageContext.request.contextPath}/constraint/primary/addNode.do", 
							{ 
								"ref" : data.rslt.parent.attr("id").replace("node_","").replace("copy_",""), 
								"c_position" : data.rslt.position,
								"c_title" : data.rslt.name,
								"c_type" : data.rslt.obj.attr("rel"),
								"f_c_id" : data.rslt.obj.attr("f_c_id")
							}, 
							function (r) {
								if(r.status) {
									$(data.rslt.obj).attr("id", "node_" + r.id);
								}
								else {
									$.jstree.rollback(data.rlbk);
								}
								$("#analyze").click();
								$('#demo').jstree('refresh',-1);
							}
						);
					})
					.bind("remove.jstree", function (e, data) {
						data.rslt.obj.each(function () {
							$.ajax({
								async : false,
								type: 'POST',
								url: "${pageContext.request.contextPath}/constraint/primary/removeNode.do",
								data : { 
									"c_id" : this.id.replace("node_","").replace("copy_","")
								}, 
								success : function (r) {
									$("#analyze").click();
									$('#demo').jstree('refresh',-1);
								}
							});
						});
					})
					.bind("rename.jstree", function (e, data) {
						$.post(
								"${pageContext.request.contextPath}/constraint/primary/alterNode.do", 
							{ 
									"c_id" : data.rslt.obj.attr("id").replace("node_","").replace("copy_",""),
									"c_title" : data.rslt.new_name,
									"c_type" : data.rslt.obj.attr("rel")
							}, 
							function (r) {
								if(!r.status) {
									$.jstree.rollback(data.rlbk);
								}
								$("#analyze").click();
								$('#demo').jstree('refresh',-1);
							}
						);
					})
					.bind("set_type.jstree", function (e, data) {
						$.post(
								"${pageContext.request.contextPath}/constraint/primary/alterNodeType.do", 
							{ 
									"c_id" : data.rslt.obj.attr("id").replace("node_","").replace("copy_",""),
									"c_title" : data.rslt.new_name,
									"c_type" : data.rslt.obj.attr("rel")
							}, 
							function (r) {
								$("#analyze").click();
								$('#demo').jstree('refresh',-1);
							}
						);
					})
					.bind("move_node.jstree", function (e, data) {
						data.rslt.o.each(function (i) {
							$.ajax({
								async : false,
								type: 'POST',
								url: "${pageContext.request.contextPath}/constraint/primary/moveNode.do",
								data : { 
									"c_id" : $(this).attr("id").replace("node_","").replace("copy_",""), 
									"ref" : data.rslt.cr === -1 ? 1 : data.rslt.np.attr("id").replace("node_","").replace("copy_",""), 
									"c_position" : data.rslt.cp + i,
									"c_title" : data.rslt.name, 
									"copy" : data.rslt.cy ? 1 : 0,
									"multiCounter"	:	i
								},
								success : function (r) {
									if(r.status) {
										$.jstree.rollback(data.rlbk);
									}
									else {
										$(data.rslt.oc).attr("id", "node_" + r.id);
										if(data.rslt.cy && $(data.rslt.oc).children("UL").length) {
											data.inst.refresh(data.inst._get_parent(data.rslt.oc));
										}
									}
									$("#analyze").click();
									$('#demo').jstree('refresh',-1);
								}
							});
						});
					});
				
				});
				</script>
				<script type="text/javascript">
				// Code for the menu buttons
				$(function () { 
					$("#mmenu input, #mmenu button").click(function () {
						switch(this.id) {
							case "add_default":
							case "add_folder":
								$("#demo").jstree("create", null, "last", { "attr" : { "rel" : this.id.toString().replace("add_", "") } });
								break;
							case "search":
								$("#demo").jstree("search", document.getElementById("text").value);
								$('#jstreeTable').DataTable().column(6).search(document.getElementById("text").value).draw();
								break;
							case "text": break;
							default:
								$("#demo").jstree(this.id);
								break;
						}
					});
				});
				</script>
				<div><br/><br/><br/><br/></div>
				<div id="mmenu_f" style="clear:both;" class="clearfix">
					<form class="niceform">
						<div class="desktop-tablet alpha boxed bm-remove btn_wrap01">
							<button type="button" id="f_add_folder"><i class="fa fa-plus"></i> add folder</button>
							<button type="button" id="f_add_default"><i class="fa fa-plus"></i> add file</button>
							<button type="button" id="f_rename"><i class="fa fa-eraser"></i> rename</button>
							<button type="button" id="f_remove"><i class="fa fa-minus"></i> remove</button>
							<button type="button" id="f_cut"><i class="fa fa-cut"></i> cut</button>
							<button type="button" id="f_copy"><i class="fa fa-copy"></i> copy</button>
							<button type="button" id="f_paste"><i class="fa fa-paste"></i> paste</button>
						</div>
						<div class="desktop-tablet alpha bm-remove boxed last btn_wrap02">
							<div class="textInputVerticalCenter">
								<input type="text" id="f_text" placeholder="찾을 노드 이름 입력" class="inline-block bm-remove tip-r-fade" data-tooltip="Press Enter To Node To Search"/>
							</div>
							<button type="button" id="f_search" title="Search"><i class="fa fa-search"></i></button>
							<button type="button" id="f_clear_search" title="Clear"><i class="fa fa-eraser"></i></button>
						</div>
					</form>
				</div>

				<div class="clearfix">
					<div id="demo_f" class="demo demo_side">
					</div>

					<div class="demo_con">
						<table id="jstreeTable_f" class="display responsive no-wrap" cellspacing="0" width="100%">
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
					<input type="button"  id="analyze_f" value="analyze" onclick="$('#alog_f').load('${pageContext.request.contextPath}/egovframework/com/ext/jstree/strutsiBatis/analyzeNode.action');" />
					<input type="button"  value="refresh" onclick="$('#demo_f').jstree('refresh',-1);" />
				</div>
				<div id='alog_f' style="float:left; border:1px solid gray; padding:5px; height:150px; margin-top:15px; overflow:auto; width: 100%;max-width:1180px;"></div>

				<!-- JavaScript neccessary for the tree -->
				<script type="text/javascript">
				function jstreeDataTableReload() {
					var jstreeDataTable = $('#jstreeTable_f').dataTable( {
						"ajax": {
							"url": "${pageContext.request.contextPath}/constraint/monitor/foreign/list.do",
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
					
					$("#radio").buttonset();					
					
					$("#nodeForm").dialog({
						height   : 300
					  , modal    : true
					  , autoOpen : false
					});					

				var jstreeDataTable = $('#jstreeTable_f').dataTable( {
					"ajax": {
						"url": "${pageContext.request.contextPath}/constraint/monitor/foreign/list.do",
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

					
				$("#demo_f")
					.bind("before.jstree", function (e, data) {
						$("#alog_f").append(data.func + "<br />");
					})
					.jstree({ 
						// List of active plugins
						"plugins" : [ 
							"themes","json_data","ui","crrm","cookies","dnd","search","types","hotkeys","contextmenu","checkbox"
						],
						
						//contextmenu
						"contextmenu" : 
						{         
							items : 
							{ // Could be a function that should return an object like this one             
								"create" : 
								{                 
									"separator_before"  : true,                  
									"separator_after"   : true,                 
									"label"             : "Create",                 
									"action"            : false,                 
									"submenu" :
									{                     
										"create_file" :  
										{                         
											"seperator_before" : false,                         
											"seperator_after" : false,                         
											"label" : "File",                         
											action : function (obj) 
											{
												
												this.create(obj, "last", {"attr" : {"rel" : "default"}});   
												
											}                     
										},                     
										"create_folder" :  
										{                         
											"seperator_before" : false,                         
											"seperator_after" : false,                         
											"label" : "Folder",                          
											action : function (obj)  
											{
												
												this.create(obj, "last", {"attr" : { "rel" : "folder"}});
												
												
											}                      
										}
										
									}             
								}
							
								
								,"ccp" :  
								{                 
									"separator_before"  : false,                 
									"separator_after"   : true,                 
									"label"             : "Edit",                 
									"action"            : false,                 
									"submenu" :
									{                     
										"cut" :  
										{                         
											"seperator_before" : false,                         
											"seperator_after" : false,                         
											"label" : "Cut",                         
											action : function (obj) 
											{                             
												this.cut(obj, "last", {"attr" : {"rel" : "default"}});                         
											}                     
										},                     
										"paste" :  
										{                         
											"seperator_before" : false,                         
											"seperator_after" : false,                         
											"label" : "Paste",                          
											action : function (obj)  
											{                                                            
												this.paste(obj, "last", {"attr" : { "rel" : "folder"}});                         
											}                      
										},
										
										"changeType" :  
										{                         
											"seperator_before" : false,                         
											"seperator_after" : false,                         
											"label" : "Change Type",             
											"submenu" :
											{
												"toFile" :  
												{                         
													"seperator_before" : false,                         
													"seperator_after" : false,                         
													"label" : "toFile",                         
													action : function (obj) 
													{   
														this.set_type("default");                     
													}                     
												},                     
												"toFolder" :  
												{                         
													"seperator_before" : false,                         
													"seperator_after" : false,                         
													"label" : "toFolder",                          
													action : function (obj)  
													{                                                            
														this.set_type("folder");
													}                      
												}
											}                 
										}
										
									}             
								}				
				
							}     
						}, 
				
						// I usually configure the plugin that handles the data first
						// This example uses JSON as it is most common
						"json_data" : { 
							// This tree is ajax enabled - as this is most common, and maybe a bit more complex
							// All the options are almost the same as jQuery's AJAX (read the docs)
							"ajax" : {
								// the URL to fetch the data
								"url" : "${pageContext.request.contextPath}/constraint/foreign/getChildNode.do",
								// the `data` function is executed in the instance's scope
								// the parameter is the node being loaded 
								// (may be -1, 0, or undefined when loading the root nodes)
								"data" : function (n) { 
									// the result is fed to the AJAX request `data` option
									return { 
										"c_id" : n.attr ? n.attr("id").replace("node_","").replace("copy_","") : 1 
									}; 
								}
							}
						},
						// Configuring the search plugin
						"search" : {
							// As this has been a common question - async search
							// Same as above - the `ajax` config option is actually jQuery's AJAX object
							"ajax" : {
								"url" : "${pageContext.request.contextPath}/constraint/foreign/searchNode.do",
								// You get the search string as a parameter
								"data" : function (str) {
									return { 
										"searchString" : str 
									}; 
								}
							}
						},
						// Using types - most of the time this is an overkill
						// read the docs carefully to decide whether you need types
						"types" : {
							// I set both options to -2, as I do not need depth and children count checking
							// Those two checks may slow jstree a lot, so use only when needed
							"max_depth" : -2,
							"max_children" : -2,
							// I want only `drive` nodes to be root nodes 
							// This will prevent moving or creating any other type as a root node
							"valid_children" : [ "drive" ],
							"types" : {
								// The default type
								"default" : {
									// I want this type to have no children (so only leaf nodes)
									// In my case - those are files
									"valid_children" : "none",
									// If we specify an icon for the default type it WILL OVERRIDE the theme icons
									"icon" : {
										"image" : "http://www.313.co.kr/php/lh_7th/data/admin/pds/scriptPool/jQueryPlugIns/jstree-v.pre1.0/_demo/file.png"
									}
								},
								// The `folder` type
								"folder" : {
									// can have files and other folders inside of it, but NOT `drive` nodes
									"valid_children" : [ "default", "folder" ],
									"icon" : {
										"image" : "http://www.313.co.kr/php/lh_7th/data/admin/pds/scriptPool/jQueryPlugIns/jstree-v.pre1.0/_demo/folder.png"
									}
								},
								// The `drive` nodes 
								"drive" : {
									// can have files and folders inside, but NOT other `drive` nodes
									"valid_children" : [ "default", "folder" ],
									"icon" : {
										"image" : "http://www.313.co.kr/php/lh_7th/data/admin/pds/scriptPool/jQueryPlugIns/jstree-v.pre1.0/_demo/root.png"
									},
									// those prevent the functions with the same name to be used on `drive` nodes
									// internally the `before` event is used
									"start_drag" : false,
									"move_node" : false,
									"delete_node" : false,
									"remove" : false
								}
							}
						},
						// UI & core - the nodes to initially select and open will be overwritten by the cookie plugin
				
						// the UI plugin - it handles selecting/deselecting/hovering nodes
						"ui" : {
							// this makes the node with ID node_4 selected onload
							"initially_select" : [ "node_4" ]
						},
						// the core plugin - not many options here
						"core" : { 
							// just open those two nodes up
							// as this is an AJAX enabled tree, both will be downloaded from the server
							"initially_open" : [ "node_2" , "node_3" ] 
						}
					})
					.bind("create.jstree", function (e, data) {
						$.post(
							"${pageContext.request.contextPath}/constraint/foreign/addNode.do", 
							{ 
								"ref" : data.rslt.parent.attr("id").replace("node_","").replace("copy_",""), 
								"c_position" : data.rslt.position,
								"c_title" : data.rslt.name,
								"c_type" : data.rslt.obj.attr("rel"),
								"f_c_id" : data.rslt.obj.attr("f_c_id")
							}, 
							function (r) {
								if(r.status) {
									$(data.rslt.obj).attr("id", "node_" + r.id);
								}
								else {
									$.jstree.rollback(data.rlbk);
								}
								$("#analyze_f").click();
								$('#demo_f').jstree('refresh',-1);
							}
						);
					})
					.bind("remove.jstree", function (e, data) {
						data.rslt.obj.each(function () {
							$.ajax({
								async : false,
								type: 'POST',
								url: "${pageContext.request.contextPath}/constraint/foreign/removeNode.do",
								data : { 
									"c_id" : this.id.replace("node_","").replace("copy_","")
								}, 
								success : function (r) {
									$("#analyze_f").click();
									$('#demo_f').jstree('refresh',-1);
								}
							});
						});
					})
					.bind("rename.jstree", function (e, data) {
						$.post(
								"${pageContext.request.contextPath}/constraint/foreign/alterNode.do", 
							{ 
									"c_id" : data.rslt.obj.attr("id").replace("node_","").replace("copy_",""),
									"c_title" : data.rslt.new_name,
									"c_type" : data.rslt.obj.attr("rel")
							}, 
							function (r) {
								if(!r.status) {
									$.jstree.rollback(data.rlbk);
								}
								$("#analyze_f").click();
								$('#demo_f').jstree('refresh',-1);
							}
						);
					})
					.bind("set_type.jstree", function (e, data) {
						$.post(
								"${pageContext.request.contextPath}/constraint/foreign/alterNodeType.do", 
							{ 
									"c_id" : data.rslt.obj.attr("id").replace("node_","").replace("copy_",""),
									"c_title" : data.rslt.new_name,
									"c_type" : data.rslt.obj.attr("rel")
							}, 
							function (r) {
								$("#analyze_f").click();
								$('#demo_f').jstree('refresh',-1);
							}
						);
					})
					.bind("move_node.jstree", function (e, data) {
						data.rslt.o.each(function (i) {
							$.ajax({
								async : false,
								type: 'POST',
								url: "${pageContext.request.contextPath}/constraint/foreign/moveNode.do",
								data : { 
									"c_id" : $(this).attr("id").replace("node_","").replace("copy_",""), 
									"ref" : data.rslt.cr === -1 ? 1 : data.rslt.np.attr("id").replace("node_","").replace("copy_",""), 
									"c_position" : data.rslt.cp + i,
									"c_title" : data.rslt.name, 
									"copy" : data.rslt.cy ? 1 : 0,
									"multiCounter"	:	i
								},
								success : function (r) {
									if(r.status) {
										$.jstree.rollback(data.rlbk);
									}
									else {
										$(data.rslt.oc).attr("id", "node_" + r.id);
										if(data.rslt.cy && $(data.rslt.oc).children("UL").length) {
											data.inst.refresh(data.inst._get_parent(data.rslt.oc));
										}
									}
									$("#analyze_f").click();
									$('#demo_f').jstree('refresh',-1);
								}
							});
						});
					});
				
				});
				</script>
				<script type="text/javascript">
				// Code for the menu buttons
				$(function () { 
					$("#mmenu_f input, #mmenu_f button").click(function () {
						switch(this.id) {
							case "f_add_default":
							case "f_add_folder":
								$("#demo_f").jstree("create", null, "last", { "attr" : { "rel" : this.id.toString().replace("f_add_", "") } });
								break;
							case "f_search":
								$("#demo_f").jstree("search", document.getElementById("f_text").value);
								$('#jstreeTable_f').DataTable().column(6).search(document.getElementById("f_text").value).draw();
								break;
							case "f_text": break;
							default:
								$("#demo_f").jstree((this.id.toString().replace("f_", "")));
								break;
						}
					});
				});
				</script>				
				</div>
				<div id="nodeForm" style="display:none;">
					<form action="#">
						<select	name="authority" id="authority">
						</select>
					</form>
			    </div>				
			</div>
		</div>
	</div>
</div>
</article>
</section>
</body>
</html> 