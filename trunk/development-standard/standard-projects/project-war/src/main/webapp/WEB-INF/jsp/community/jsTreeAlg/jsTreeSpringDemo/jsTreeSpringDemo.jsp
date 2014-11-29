<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" autoFlush="true"%>

<!DOCTYPE html> 
<html lang="ko">
<head>
<meta http-equiv="Content-Language" content="ko" >
<!-- JSTREE -->
<script src="${pageContext.request.contextPath}/js/community/jsTreeAlg/jstreeDemo/jstree-v.pre1.0/jquery.jstree.js?20" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/community/jsTreeAlg/jstreeDemo/jstree-v.pre1.0/_lib/jquery.cookie.js?20" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/community/jsTreeAlg/jstreeDemo/jstree-v.pre1.0/_lib/jquery.hotkeys.js?20" type="text/javascript"></script>


<!-- JQGRID -->
<script src="${pageContext.request.contextPath}/js/community/jsTreeAlg/jstreeDemo/jquery.jqGrid-4.4.3/src/i18n/grid.locale-en.js?20" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/community/jsTreeAlg/jstreeDemo/jquery.jqGrid-4.4.3/js/jquery.jqGrid.min.js?20" type="text/javascript"></script>

<!-- Style Setting -->
<style type="text/css">
.textInputVerticalCenter{
	margin-top: 3px !important;
	padding-top: 3px !important;
	display: inline;
}

#demo {
	overflow: scroll;
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
</style>

<script type="text/javascript">
	
    function getGrid() {
    	
    	$("#jqTable").jqGrid("GridUnload");
    	
        var jqDataUrl = '${pageContext.request.contextPath}/egovframework/com/etc/jstree/springiBatis/monitor/list.do';
        
        // Set up the jquery grid
        $("#jqTable").jqGrid({
            // Ajax related configurations
            url        : jqDataUrl,
            datatype   : "json",
            mtype: "POST",
            gridModel  : "gridModel",
            // Specify the column names
            colNames   : ["c_id", "c_parentid", "c_position", "c_left", "c_right", "c_level", "c_title", "c_type"],
            prmNames: {page:"_page",rows:"_rows", sort: "sidx",order: "sord", search:"_search", nd:"nd", id:"id",oper:"oper",editoper:"edit",addoper:"add",deloper:"del", subgridid:"id", npage: null, totalrows:"totalrows"},
            // Configure the columns
            colModel   : [
                { name: "c_id", index: "c_id", width: 100, align: "left" },
                { name: "c_parentid", index: "c_parentid", width: 100, align: "left" },
                { name: "c_position", index: "c_position", width: 100, align: "left" },
                { name: "c_left", index: "c_left", width: 100, align: "left" },
                { name: "c_right", index: "c_right", width: 100, align: "left" },
                { name: "c_level", index: "c_level", width: 100, align: "left" },
                { name: "c_title", index: "c_title", width: 100, align: "left" },
                { name: "c_type", index: "c_type", width: 100, align: "left" }
                
            ],
            // Grid total width and height
            width      : 600,
            height     : 400,
            // Paging
            toppager   : false,
            rowNum     : 100,
            rowList    : [100, 200, 300],
            viewrecords: true, // Specify if "total number of records" is displayed
            // Default sorting
            sortname   : "Id",
            sortorder  : "asc",
            
            onSelectRow: function(ids) {
            	alert(ids);
            },
            
            // Grid caption
            caption    : "JstreeMonitor - T_COMPREHENSIVETREE_Viewer"
        }).navGrid("#jqTablePager",
                { refresh: true, add: false, edit: false, del: false },
                {}, // settings for edit
                {}, // settings for add
                {}, // settings for delete
                {sopt: ["cn"]} // Search options. Some options can be set on column level
        );
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
				JAVA &amp; Oracle ( Spring + Ibatis ) demo + event order
			</h1>
			<p class="bm-remove">
				<a href="${pageContext.request.contextPath}/" target="_self">Home</a>
				&nbsp;/&nbsp;
				<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeOverView.do" target="_self">Overview</a>
				&nbsp;/&nbsp;
				<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeApply.do" target="_self">Apply</a>
				&nbsp;/&nbsp;
				<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeConcept.do" target="_self">Concept</a>
				&nbsp;/&nbsp;
				<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeSupport.do" target="_self">Support</a>
				&nbsp;/&nbsp;
				<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeResult.do" target="_self">Result</a>
				&nbsp;/&nbsp;
				<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeIntegration.do" target="_self">Integration</a>
				&nbsp;/&nbsp;
				<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeImprovement.do" target="_self">Improvement</a>
				&nbsp;/&nbsp;
				<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeLicense.do" target="_self">License</a>
				&nbsp;/&nbsp;
				<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeSpringDemo.do" target="_self">Spring Demo</a>
				&nbsp;/&nbsp;
				<a href="${pageContext.request.contextPath}/jsTreeAlg/jsTreeStrutsDemo.do" target="_self">Struts Demo</a>
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
				<div class="one-half-percent desktop-tablet alpha boxed bm-remove">
						<input type="button" id="add_folder" value="add folder" />
						<input type="button" id="add_default" value="add file" />
						<input type="button" id="rename" value="rename" />
						<input type="button" id="remove" value="remove" />
						<input type="button" id="cut" value="cut" />
						<input type="button" id="copy" value="copy" />
						<input type="button" id="paste" value="paste" />
				</div>		
				<div class="one-half-percent desktop-tablet alpha bm-remove boxed last">
						<input type="button" id="search" value="search"/>
						<input type="button" id="clear_search" value="clear"/>
						<div class="textInputVerticalCenter">
							<input type="text" id="text" value="찾을 노드 이름 입력" class="inline-block w-small bm-remove tip-r-fade" data-tooltip="Press Enter To Node To Search"/>
						</div>
				</div>
				</form>
				</div>
				
				<div class="clearfix">
				<!-- the tree container (notice NOT an UL node) -->
				<div id="demo" class="demo" style="height:500px;width:300px;float: left">
				</div>
				<div style="float: left; padding-left: 10px">
					<table id="jqTable" class="scroll"></table>
				    <div id="jqTablePager"></div>
				</div>
				</div>
				<div class="clearfix">
					<input type="button" value="reconstruct" onclick="javascript:alert('not supprt')" />
					<input type="button" id="analyze" value="analyze" onclick="javascript:getGrid();" />
					<input type="button" value="refresh" onclick="$('#demo').jstree('refresh',-1);" />
				</div>
				<div id='alog' style="float:left; border:1px solid gray; padding:5px; height:150px; margin-top:15px; overflow:auto; width: 100%"></div>
				<!-- JavaScript neccessary for the tree -->
				<script type="text/javascript">
				$(function () {
					$(window).load(function(){
						getGrid();
					});
					
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
								"url" : "${pageContext.request.contextPath}/egovframework/com/etc/jstree/springiBatis/core/getChildNode.do",
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
								"url" : "${pageContext.request.contextPath}/egovframework/com/etc/jstree/springiBatis/core/searchNode.do",
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
							"${pageContext.request.contextPath}/egovframework/com/etc/jstree/springiBatis/core/addNode.do", 
							{ 
								"ref" : data.rslt.parent.attr("id").replace("node_","").replace("copy_",""), 
								"c_position" : data.rslt.position,
								"c_title" : data.rslt.name,
								"c_type" : data.rslt.obj.attr("rel")
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
								url: "${pageContext.request.contextPath}/egovframework/com/etc/jstree/springiBatis/core/removeNode.do",
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
								"${pageContext.request.contextPath}/egovframework/com/etc/jstree/springiBatis/core/alterNode.do", 
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
								"${pageContext.request.contextPath}/egovframework/com/etc/jstree/core/springiBatis/alterNodeType.do", 
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
								url: "${pageContext.request.contextPath}/egovframework/com/etc/jstree/springiBatis/core/moveNode.do",
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
					$("#mmenu input").click(function () {
						switch(this.id) {
							case "add_default":
							case "add_folder":
								$("#demo").jstree("create", null, "last", { "attr" : { "rel" : this.id.toString().replace("add_", "") } });
								break;
							case "search":
								$("#demo").jstree("search", document.getElementById("text").value);
								break;
							case "text": break;
							default:
								$("#demo").jstree(this.id);
								break;
						}
					});
				});
				</script>
				</div>
			</div>
		</div>
	</div>
</div>
</article>


<!-- ANALYTICS START -->
<!-- https://www.google.com/analytics/settings/home?scid=18527803 web log Analyzer  -->
<script type="text/javascript">
//<![CDATA[
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-18527803-1']);
_gaq.push(['_trackPageview']);
_gaq.push(['_trackPageLoadTime']);
(function() {
var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
})();
//]]>
</script>
<!-- ANALYTICS END -->
</section>
</body>
</html> 