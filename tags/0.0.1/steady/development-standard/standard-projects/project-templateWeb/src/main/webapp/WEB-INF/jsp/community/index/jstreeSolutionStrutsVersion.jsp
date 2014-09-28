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
<c:choose>
	<c:when test="${pageContext.request.serverName=='www.khld.co.kr'||pageContext.request.serverName=='khld.co.kr'}">
		<jsp:include page="/jsp/wwwkhldcokr/index/meta/script.inc.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="/jsp/www313cokr/index/meta/script.inc.jsp"></jsp:include>
	</c:otherwise>
</c:choose>


<!-- CSS Setting -->
<link rel="icon" href="./favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="./favicon.ico" type="image/x-icon" />

<!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery/plugIns/bootstrapVersion2.3.0/css/bootstrap.css" media="screen"/> -->

<customTags:nasCSS theRestOfFileName="/scriptPool/jQueryPlugIns/jquery-mega-drop-down-menu.1.3.3/css/skins/www313cokr.css"></customTags:nasCSS>
<customTags:nasCSS theRestOfFileName="/scriptPool/jQueryPlugIns/jQuery CN Plugins/Styles/Base.css"></customTags:nasCSS>
<customTags:nasCSS theRestOfFileName="/scriptPool/jQueryPlugIns/jQuery CN Plugins/Styles/BreadCrumb.css"></customTags:nasCSS>
<customTags:nasCSS theRestOfFileName="/scriptPool/jQueryPlugIns/jnotify_v2.1/jquery/jNotify.jquery.css"></customTags:nasCSS>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/design/css/common.css" media="screen"/>
<customTags:nasCSS theRestOfFileName="/scriptPool/jQuery/jquery-ui-1.9.2.custom/css/ui-lightness/jquery-ui-1.9.2.custom.css"></customTags:nasCSS>
<customTags:nasCSS theRestOfFileName="/scriptPool/jQueryPlugIns/jquery.jqGrid-4.4.3/css/ui.jqgrid.css"></customTags:nasCSS>
<customTags:nasCSS theRestOfFileName="/scriptPool/jQueryPlugIns/niceforms-master/niceforms-default.css"></customTags:nasCSS>

<!-- Default JQuery Setting -->
<customTags:nasScript theRestOfFileName="/scriptPool/jQuery/jquery.com/jquery-1.9.1.min.js"></customTags:nasScript>
<customTags:nasScript theRestOfFileName="/scriptPool/jQuery/jquery.com/jquery-migrate-1.1.0.min.js"></customTags:nasScript>
<customTags:nasScript theRestOfFileName="/scriptPool/jQuery/jquery-ui-1.9.2.custom/js/jquery-ui-1.9.2.custom.min.js"></customTags:nasScript>

<!--<customTags:nasScript theRestOfFileName="/scriptPool/Bootstrap/bootstrap2.3.2/js/bootstrap.min.js"></customTags:nasScript>-->
<!--<customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/css3-mediaqueries.js"></customTags:nasScript>-->

<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/plugIns/css_browser_selector/css_browser_selector.min.js" charset="utf-8"></script> 

<customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/jquery-mega-drop-down-menu.1.3.3/js/jquery.hoverIntent.minified.js"></customTags:nasScript>
<customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/jquery-mega-drop-down-menu.1.3.3/js/jquery.dcmegamenu.1.3.3.min.js"></customTags:nasScript>

<customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/jQuery CN Plugins/js/jquery.jBreadCrumb.1.1.js"></customTags:nasScript>

<customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/malsup.com/jquery/form/jquery.form.js"></customTags:nasScript>
<customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/jnotify_v2.1/jquery/jNotify.jquery.js"></customTags:nasScript>

<customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/masonry-site/jquery.masonry.js"></customTags:nasScript>
<!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<!--[if IE]><customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/excanvas_r3/excanvas.compiled.js"></customTags:nasScript>

<!-- JSTREE -->
<customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/jstree-v.pre1.0/_lib/jquery.cookie.js"></customTags:nasScript>
<customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/jstree-v.pre1.0/_lib/jquery.hotkeys.js"></customTags:nasScript>
<customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/jstree-v.pre1.0/jquery.jstree.js"></customTags:nasScript>

<!-- JQGRID -->
<customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/jquery.jqGrid-4.4.3/src/i18n/grid.locale-en.js"></customTags:nasScript>
<customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/jquery.jqGrid-4.4.3/js/jquery.jqGrid.min.js"></customTags:nasScript>


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
</style>


<script type="text/javascript">

    function getGrid() {
        var jqDataUrl = '/war/struts/www313cokr/index/menu/jstreeMonitor/getJstreeMonitor.action';
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
            toppager   : true,
            pager      : $("#jqTablePager"),
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

<body id="demo_body" onload="getGrid();">
<div id="jsTreeContainer">

<h2>JAVA &amp; Oracle ( struts2 + Spring2.5 + Ibatis ) demo + event order</h2>
<div id="description">
<div id="mmenu" style="height:50px; overflow:auto;">
<form class="niceform" style="overflow: hidden;">
	<fieldset style="float: left;">
		<input type="button" id="add_folder" value="add folder" />
		<input type="button" id="add_default" value="add file" />
		<input type="button" id="rename" value="rename" />
		<input type="button" id="remove" value="remove" />
		<input type="button" id="cut" value="cut" />
		<input type="button" id="copy" value="copy" />
		<input type="button" id="paste" value="paste" />
	</fieldset>
	<fieldset style="float: right;">
		<input type="button" id="search" value="search"/>
		<input type="button" id="clear_search" value="clear"/>
		<div class="textInputVerticalCenter">
			<input type="text" id="text" value="찾을 노드 이름 입력" />
		</div>
	</fieldset>
</form>
</div>

<!-- the tree container (notice NOT an UL node) -->
<div id="demo" class="demo" style="height:500px;width:300px;float: left"></div>
<div style="float: left; padding-left: 10px">
	<table id="jqTable" class="scroll"></table>
    <div id="jqTablePager"></div>
</div>
<div style="height:30px; text-align:center; float: left">
	<input type="button" style='width:170px; height:24px; margin:5px auto;' value="reconstruct" onclick="javascript:alert('not supprt')" />
	<input type="button" style='width:170px; height:24px; margin:5px auto;' id="analyze" value="analyze" onclick="$('#alog').load('/war/struts/www313cokr/index/menu/num3/analyzeNode.action');" />
	<input type="button" style='width:170px; height:24px; margin:5px auto;' value="refresh" onclick="$('#demo').jstree('refresh',-1);" />
</div>
<div id='alog' style="float:left; border:1px solid gray; padding:5px; height:150px; margin-top:15px; overflow:auto; width: 100%"></div>
<!-- JavaScript neccessary for the tree -->
<script type="text/javascript">
$(function () {

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
				"url" : "/war/struts/www313cokr/index/menu/num3/getChildNode.action",
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
				"url" : "/war/struts/www313cokr/index/menu/num3/searchNode.action",
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
			"/war/struts/www313cokr/index/menu/num3/addNode.action", 
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
				$("span.ui-icon-refresh").click();
			}
		);
	})
	.bind("remove.jstree", function (e, data) {
		data.rslt.obj.each(function () {
			$.ajax({
				async : false,
				type: 'POST',
				url: "/war/struts/www313cokr/index/menu/num3/removeNode.action",
				data : { 
					"c_id" : this.id.replace("node_","").replace("copy_","")
				}, 
				success : function (r) {
					$("#analyze").click();
					$("span.ui-icon-refresh").click();
				}
			});
		});
	})
	.bind("rename.jstree", function (e, data) {
		$.post(
				"/war/struts/www313cokr/index/menu/num3/alterNode.action", 
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
				$("span.ui-icon-refresh").click();
			}
		);
	})
	.bind("set_type.jstree", function (e, data) {
		$.post(
				"/war/struts/www313cokr/index/menu/num3/alterNodeType.action", 
			{ 
					"c_id" : data.rslt.obj.attr("id").replace("node_","").replace("copy_",""),
					"c_title" : data.rslt.new_name,
					"c_type" : data.rslt.obj.attr("rel")
			}, 
			function (r) {
				$("#analyze").click();
				$("span.ui-icon-refresh").click();
			}
		);
	})
	.bind("move_node.jstree", function (e, data) {
		data.rslt.o.each(function (i) {
			$.ajax({
				async : false,
				type: 'POST',
				url: "/war/struts/www313cokr/index/menu/num3/moveNode.action",
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
					$("span.ui-icon-refresh").click();
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
</body>
</html> 