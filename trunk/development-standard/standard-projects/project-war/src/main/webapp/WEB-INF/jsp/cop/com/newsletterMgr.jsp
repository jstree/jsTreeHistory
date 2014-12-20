<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Language" content="ko" >
<meta http-equiv='cache-control' content='no-cache'>
<meta http-equiv='expires' content='0'>
<meta http-equiv='pragma' content='no-cache'>
<title>뉴스레터 관리</title>
<link rel="stylesheet" type="text/css" href="http://nas.313.co.kr:5002/Component/jsp/community/index/reset.css" />
<link rel="stylesheet" type="text/css" href="http://nas.313.co.kr:5002/Component/jsp/community/index/index.css" />
<style type="text/css">
</style>
<!-- jQuery -->
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/index/jquery-1.11.1.js"></script>
<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" href="http://nas.313.co.kr:5002/Source/Script/jQuery/jQueryPlugIns/jnotify_v2.1/jquery/jNotify.jquery.css" />
<!--[if lt IE 9]>
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/index/debug.js"></script>
<![endif]-->
<!-- JSTREE -->
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/jstree-v.pre1.0/_lib/jquery.cookie.js"></script>
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/jstree-v.pre1.0/_lib/jquery.hotkeys.js"></script>
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/jstree-v.pre1.0/jquery.jstree.js"></script>
<!-- JavaScript -->
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/Script/ajax/ajax.js" charset="UTF-8"></script>
<script type="text/javascript" src="http://nas.313.co.kr:5002/Source/Script/jQuery/jQueryPlugIns/jnotify_v2.1/jquery/jNotify.jquery.min.js" charset="UTF-8"></script>
<link href="<c:url value='/'/>css/common.css" rel="stylesheet" type="text/css" >
</head>
<body>
<!-- 전체 레이어 시작 -->
<div id="wrap">
	<!-- header 시작 -->
    <div id="header_mainsize"><c:import url="/EgovPageLink.do?link=/jsp/main/inc/EgovIncHeader" /></div>
    <div id="topnavi"><c:import url="/EgovPageLink.do?link=/jsp/main/inc/EgovIncTopnav" /></div>     
    <!-- //header 끝 -->
	<!-- container 시작 -->
	<div id="container">
		<!-- 좌측메뉴 시작 -->
		<div id="leftmenu"><c:import url="/EgovPageLink.do?link=/jsp/main/inc/EgovIncLeftmenu" /></div>
		<div id="content">
			<div id="cur_loc">
				<div id="cur_loc_align">
					<ul>
						<li>HOME</li>
						<li>&gt;</li>
						<li>사이트관리</li>
						<li>&gt;</li>
						<li><strong>뉴스레터 관리</strong></li>
					</ul>
				</div>
			</div>
            <DIV id="content2" style="width:100%;height:100%;">
				<div id="search_field">
					<div id="search_field_loc"><h2><strong>뉴스레터 관리</strong></h2></div>
				</div>
				<div id="jstreeSearch" class="asideSectionSearchHeight">
					<table class="logoAsideWidth asideSectionSearchHeight">
						<tr>
							<td class="jstreeSearchLeft"></td>
							<td class="jstreeSearchMiddle"></td>
							<td class="jstreeSearchRight"></td>
						</tr>
					</table>
				</div>
	            <div id="demo" class="asideSectionMenuHeight">
		        </div>
			</DIV>
		</div>
	</div>
	<div id="nodeForm" style="display:none;">
    	<ul>
    		<li>노드명 : <input type="text" id="nodeTitle"   /></li>
    		<li>Email : <input type="text" id="nodeEmail" /></li>
    	</ul>
    </div>
    <div id="nodeConfirm" title="확인"></div>	
	<!-- //container 끝 -->
	<!-- footer 시작 -->
    <div id="footer"><c:import url="/EgovPageLink.do?link=/jsp/main/inc/EgovIncFooter" /></div>
    <!-- //footer 끝 -->
</div>
<!-- JavaScript neccessary for the tree -->
<script type="text/javascript">
$(function () {
	
$("#demo")
	.bind("before.jstree", function (e, data) {
		$("li:not([rel='drive']).jstree-open > a > .jstree-icon").css('background-image','url(http://nas.313.co.kr:5002/Design/icon/miniCon/313/toolbar_open.png)');
		$("li:not([rel='drive']).jstree-closed > a > .jstree-icon").css('background-image','url(http://nas.313.co.kr:5002/Design/icon/miniCon/313/ic_explorer.png)');
	})
	.jstree({ 
		// List of active plugins
    	"plugins" : [ 
			"themes","json_data","ui","crrm","cookies","dnd","search","types","hotkeys","contextmenu"
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
							"label" : "Email",                         
							action : function (obj) 
							{
								this.create(obj, "last", {"attr" : {"rel" : "default"}});
							}                     
						},                     
						"create_folder" :  
						{                         
							"seperator_before" : false,                         
							"seperator_after" : false,                         
							"label" : "Category",                          
							action : function (obj)  
							{
								this.create(obj, "last", {"attr" : { "rel" : "folder"}});                         
							}                      
						}
						
					}             
				},
				"ccp" :  
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
									"label" : "toEmail",                         
									action : function (obj) 
									{   
										this.set_type("default");                     
									}                     
								},                     
								"toFolder" :  
								{                         
									"seperator_before" : false,                         
									"seperator_after" : false,                         
									"label" : "toCategory",                          
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
				"url" : "${pageContext.request.contextPath}/newsletter/getEmailList.do",
				// the `data` function is executed in the instance's scope
				// the parameter is the node being loaded 
				// (may be -1, 0, or undefined when loading the root nodes)
				"data" : function (n) { 
					// the result is fed to the AJAX request `data` option
					return { 
						"c_id" : n.attr ? n.attr("id").replace("node_","").replace("copy_","") : 1 ,
						"r" : getTimestamp()
					}; 
				}
			}
		},
// 		// Configuring the search plugin
// 		"search" : {
// 			// As this has been a common question - async search
// 			// Same as above - the `ajax` config option is actually jQuery's AJAX object
// 			"ajax" : {
// 				/* "url" : "/egovframework/com/ext/jstree/strutsiBatis/searchNode.action", */
// 				"url" : "${pageContext.request.contextPath}/none/json/community/largeMenu/middleMenu/smallMenu/menu/searchNode.do",
// 				// You get the search string as a parameter
// 				"data" : function (str) {
// 					return { 
// 						"r": getTimestamp(),
// 						"searchString" : str 
// 					}; 
// 				}
// 			}
// 		},
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
						"image" : "http://nas.313.co.kr:5002/Design/icon/FileIconPack/HTML.png"
					}
				},
				// The `folder` type
				"folder" : {
					// can have files and other folders inside of it, but NOT `drive` nodes
					"valid_children" : [ "default", "folder" ],
					"icon" : {
						"image" : "http://nas.313.co.kr:5002/Design/icon/miniCon/313/ic_explorer.png"
						//Design/icon/miniCon/313/toolbar_open.png
					}
				},
				// The `drive` nodes 
				"drive" : {
					// can have files and folders inside, but NOT other `drive` nodes
					"valid_children" : [ "default", "folder" ],
					"icon" : {
						"image" : "http://nas.313.co.kr:5002/Component/jsp/community/jstree-v.pre1.0/Database-Search.png"
						//Design/icon/IconSet/Aeon/PNG/Misc/Misc-Stuff.png
						//Component/jsp/community/jstree-v.pre1.0/db.png
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
			// this makes the node with ID node_3 selected onload
			"initially_select" : [ "node_3" ]
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
			"${pageContext.request.contextPath}/newsletter/addEmail.do", 
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
				$('#demo').jstree('refresh',-1);
			}
		);
	})
	.bind("remove.jstree", function (e, data) {
		data.rslt.obj.each(function () {
			$.ajax({
				async : false,
				type: 'POST',
				url: "${pageContext.request.contextPath}/newsletter/removeEmail.do", 
				data : { 
					"c_id" : this.id.replace("node_","").replace("copy_","")
				}, 
				success : function (r) {
					$('#demo').jstree('refresh',-1);
				}
			});
		});
	})
// 	.bind("rename.jstree", function (e, data) {
// 		$.post(
// 				"${pageContext.request.contextPath}/egovframework/com/etc/jstree/springiBatis/core/alterNode.do", 
// 			{ 
// 					"c_id" : data.rslt.obj.attr("id").replace("node_","").replace("copy_",""),
// 					"c_title" : data.rslt.new_name,
// 					"c_type" : data.rslt.obj.attr("rel")
// 			}, 
// 			function (r) {
// 				if(!r.status) {
// 					$.jstree.rollback(data.rlbk);
// 				}
// 				$('#demo').jstree('refresh',-1);
// 			}
// 		);
// 	})
// 	.bind("set_type.jstree", function (e, data) {
// 		$.post(
// 				"${pageContext.request.contextPath}/egovframework/com/etc/jstree/core/springiBatis/alterNodeType.do", 
// 			{ 
// 					"c_id" : data.rslt.obj.attr("id").replace("node_","").replace("copy_",""),
// 					"c_title" : data.rslt.new_name,
// 					"c_type" : data.rslt.obj.attr("rel")
// 			}, 
// 			function (r) {
// 				$('#demo').jstree('refresh',-1);
// 			}
// 		);
// 	})
// 	.bind("move_node.jstree", function (e, data) {
// 		data.rslt.o.each(function (i) {
// 			$.ajax({
// 				async : false,
// 				type: 'POST',
// 				url: "${pageContext.request.contextPath}/egovframework/com/etc/jstree/springiBatis/core/moveNode.do",
// 				data : { 
// 					"c_id" : $(this).attr("id").replace("node_","").replace("copy_",""), 
// 					"ref" : data.rslt.cr === -1 ? 1 : data.rslt.np.attr("id").replace("node_","").replace("copy_",""), 
// 					"c_position" : data.rslt.cp + i,
// 					"c_title" : data.rslt.name, 
// 					"copy" : data.rslt.cy ? 1 : 0,
// 					"multiCounter"	:	i
// 				},
// 				success : function (r) {
// 					if(r.status) {
// 						$.jstree.rollback(data.rlbk);
// 					}
// 					else {
// 						$(data.rslt.oc).attr("id", "node_" + r.id);
// 						if(data.rslt.cy && $(data.rslt.oc).children("UL").length) {
// 							data.inst.refresh(data.inst._get_parent(data.rslt.oc));
// 						}
// 					}
// 					$('#demo').jstree('refresh',-1);
// 				}
// 			});
// 		});
// 	});
});
		
function getTimestamp(){
	return Math.floor(new Date().getTime());
}
</script>
<!-- //전체 레이어 끝 -->
</body>
</html>

