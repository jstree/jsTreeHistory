<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Language" content="ko" >
<meta http-equiv='cache-control' content='no-cache'>
<meta http-equiv='expires' content='0'>
<meta http-equiv='pragma' content='no-cache'>
<title>메뉴관리</title>
<link rel="stylesheet" type="text/css" href="http://nas.313.co.kr:5002/Component/jsp/community/index/reset.css" />
<link rel="stylesheet" type="text/css" href="http://nas.313.co.kr:5002/Component/jsp/community/index/index.css" />
<style type="text/css">
</style>
<!-- jQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.11.1.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-ui.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jNotify.jquery.css" />
<!--[if lt IE 9]>
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/index/debug.js"></script>
<![endif]-->
<!-- JSTREE -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/community/jsTreeAlg/jstreeDemo/jstree-v.pre1.0/_lib/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/community/jsTreeAlg/jstreeDemo/jstree-v.pre1.0/_lib/jquery.hotkeys.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/community/jsTreeAlg/jstreeDemo/jstree-v.pre1.0/jquery.jstree.js"></script>
<!-- JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/ajax.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jNotify.jquery.js" charset="UTF-8"></script>
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
						<li><strong>메뉴관리</strong></li>
					</ul>
				</div>
			</div>
            <DIV id="content2" style="width:100%;height:100%;">
				<div id="search_field">
					<div id="search_field_loc"><h2><strong>메뉴관리</strong></h2></div>
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
    		<li>URL   : <input type="text" id="nodeLinkUrl" /></li>
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
	$("#nodeForm").dialog({
		height   : 200
	  , modal    : true
	  , autoOpen : false
	});
	
$("#demo")
	.bind("before.jstree", function (e, data) {
		//$("#section").append(data.func + "<br />");
	}).jstree({ 
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
							"label" : "File",                         
							action : function (obj) 
							{
								$("#nodeTitle").val("");
								$("#nodeLinkUrl").val("");
								var obj2 = this;
								$("#nodeForm").dialog({
									title  : "새 노드 추가"
								  ,	buttons: {
								        Ok    : function() {
								        	obj2.create(obj, "last", {"attr" : {"rel" : "default"},"data" : $("#nodeTitle").val()});
								        	$(obj).attr("href",$("#nodeLinkUrl").val());
								        	$( "#nodeForm" ).dialog( "close" );
								        },
								        Cancel: function() {
								            $( "#nodeForm" ).dialog( "close" );
								        }
								    }
								});
								$("#nodeForm").dialog("open");
							}                     
						},                     
						"create_folder" :  
						{                         
							"seperator_before" : false,                         
							"seperator_after" : false,                         
							"label" : "Folder",                          
							action : function (obj)  
							{
								$("#nodeTitle").val("");
								$("#nodeLinkUrl").val("");
								var obj2 = this;
								$("#nodeForm").dialog({
									title  : "새 폴더 추가"
								  ,	buttons: {
								        Ok    : function() {
								        	obj2.create(obj, "last", {"attr" : {"rel" : "folder"},"data" : $("#nodeTitle").val()});
								        	$(obj).attr("href",$("#nodeLinkUrl").val());
								        	$( "#nodeForm" ).dialog( "close" );
								        },
								        Cancel: function() {
								            $( "#nodeForm" ).dialog( "close" );
								        }
								    }
								});
								$("#nodeForm").dialog("open");
							}                      
						}
						
					}             
				}
				,"rename" :
				{
					"seperator_before" : false,                         
					"seperator_after" : false,                         
					"label" : "Rename",                         
					action : function (obj) 
					{
						$("#nodeTitle"  ).val( $(obj).find("a").clone().children().remove().end().text() );
						$("#nodeLinkUrl").val($(obj).attr("href"));
						var obj1 = obj;
						var obj2 = this;
						$("#nodeForm").dialog({
							title  : "노드 업데이트"
						  ,	buttons: {
						        Ok    : function() {
						        	$(obj).find("a").html('<ins class="jstree-icon">&nbsp;</ins>'+$("#nodeTitle").val());
						        	obj2.rename(obj2.data.ui.hovered || obj2.data.ui.last_selected);
						        	$( "#nodeForm" ).dialog( "close" );
						        },
						        Cancel: function() {
						            $( "#nodeForm" ).dialog( "close" );
						        }
						    }
						});
						$("#nodeForm").dialog("open");
					}                    
				}
				,"remove" :
				{
					"seperator_before" : false                         
					,"seperator_after" : false                         
					,"label" : "Remove"
					,action : function(obj){
						$("#nodeConfirm").html("삭제하시겠습니까?");
						$("#nodeConfirm").dialog({
							 resizable : false
							,height : 140
							,modal : true
							,close : function(){
						    	$("#nodeConfirm").dialog("close");
							}
							,buttons : {
								 "확인" : function(){
									 $.ajax({
										 async : false
										,type: 'POST'
										//,url: "/egovframework/com/ext/jstree/strutsiBatis/removeNode.action"
										,url: "${pageContext.request.contextPath}/none/json/community/largeMenu/middleMenu/smallMenu/menu/removeNode.do"
										,data : { 
											 "c_id"       : $(obj).attr("id").replace("node_","").replace("copy_","")
											,"c_type"     : $(obj).attr("rel")						
											,"c_position" : $(obj).attr("position")
											,"c_left"     : $(obj).attr("left")
										    ,"c_right"    : $(obj).attr("right")
										}
										,success : function (r) {
											$("#demo").jstree("remove",$(obj));
										}
										,complete : function(){
											$("#nodeConfirm").dialog("close");
										}
									});
								 }
							    ,"취소" : function(){
							    	$("#nodeConfirm").dialog("close");
							    }
							}
						});
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
				/* "url" : "/egovframework/com/ext/jstree/strutsiBatis/getChildNode.action", */
				"url" : "${pageContext.request.contextPath}/none/json/community/largeMenu/middleMenu/smallMenu/menu/invokeSelect.do",
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
		// Configuring the search plugin
		"search" : {
			// As this has been a common question - async search
			// Same as above - the `ajax` config option is actually jQuery's AJAX object
			"ajax" : {
				/* "url" : "/egovframework/com/ext/jstree/strutsiBatis/searchNode.action", */
				"url" : "${pageContext.request.contextPath}/none/json/community/largeMenu/middleMenu/smallMenu/menu/searchNode.do",
				// You get the search string as a parameter
				"data" : function (str) {
					return { 
						"r": getTimestamp(),
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
						"image" : "${pageContext.request.contextPath}/js/community/jsTreeAlg/jstreeDemo/jstree-v.pre1.0/_demo/file.png"
					}
				},
				// The `folder` type
				"folder" : {
					// can have files and other folders inside of it, but NOT `drive` nodes
					"valid_children" : [ "default", "folder" ],
					"icon" : {
						"image" : "${pageContext.request.contextPath}/js/community/jsTreeAlg/jstreeDemo/jstree-v.pre1.0/_demo/folder.png"
						//Design/icon/miniCon/313/toolbar_open.png
					}
				},
				// The `drive` nodes 
				"drive" : {
					// can have files and folders inside, but NOT other `drive` nodes
					"valid_children" : [ "default", "folder" ],
					"icon" : {
						"image" : "${pageContext.request.contextPath}/js/community/jsTreeAlg/jstreeDemo/jstree-v.pre1.0/_demo/root.png"
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
	.bind("set_type.jstree", function (e, data) {
		$.post(
				/* "/egovframework/com/ext/jstree/strutsiBatis/alterNodeType.action", */
				"${pageContext.request.contextPath}/none/json/community/largeMenu/middleMenu/smallMenu/menu/alterNodeType.do",
			{ 
					"c_id" : data.rslt.obj.attr("id").replace("node_","").replace("copy_",""),
					"c_title" : data.rslt.new_name,
					"c_type" : data.rslt.obj.attr("rel")
			}, 
			function (r) {
			}
		);
	})
	.bind("create.jstree", function (e, data) {
		console.log("create.tree : "+data.rslt.parent.attr("id").replace("node_","").replace("copy_",""));
		console.log("create.tree : "+data.rslt.position);
		console.log("create.tree : "+$("#nodeTitle").val());
		console.log("create.tree : "+data.rslt.obj.attr("rel"));
		console.log("create.tree : "+$("#nodeLinkUrl").val());
		$.post(
			"${pageContext.request.contextPath}/none/json/community/largeMenu/middleMenu/smallMenu/menu/addNode.do",
			{ 
				"ref" : data.rslt.parent.attr("id").replace("node_","").replace("copy_",""), 
				"c_position" : data.rslt.position,
				"c_title" : $("#nodeTitle").val(),
				"c_type" : data.rslt.obj.attr("rel"),
				"url" : $("#nodeLinkUrl").val()
			}, 
			function (r) {
				if(r.status) {
					$(data.rslt.obj).attr("id", "node_" + r.id);
					$(data.rslt.obj).attr("href", $("#nodeLinkUrl").val());
				}
				else {
					$.jstree.rollback(data.rlbk);
				}
			}
		);
	})
	.bind("rename.jstree", function (e, data) {
		$.post(
				"${pageContext.request.contextPath}/none/json/community/largeMenu/middleMenu/smallMenu/menu/alterNode.do",
			{ 
					"c_id" : data.rslt.obj.attr("id").replace("node_","").replace("copy_",""),
					"c_title" : $("#nodeTitle").val(),
					"url" : $("#nodeLinkUrl").val(),
					"c_type" : data.rslt.obj.attr("rel")
			}, 
			function (r) {
				if(!r.status) {
					$.jstree.rollback(data.rlbk);
				}else{
					data.rslt.obj.attr("href",$("#nodeLinkUrl").val());
				}
				$("#nodeForm").dialog("close");
			}
		);
	})
	.bind("move_node.jstree", function (e, data) {
		data.rslt.o.each(function (i) {
			$.ajax({
				async : false,
				type: 'POST',
				/* url: "/egovframework/com/ext/jstree/strutsiBatis/moveNode.action", */
				url: "${pageContext.request.contextPath}/none/json/community/largeMenu/middleMenu/smallMenu/menu/moveNode.do",
				data : { 
					"c_id" : $(this).attr("id").replace("node_","").replace("copy_",""), 
					"ref" : data.rslt.cr === -1 ? 1 : data.rslt.np.attr("id").replace("node_","").replace("copy_",""), 
					"c_position" : data.rslt.cp + i,
					"copy" : data.rslt.cy ? 1 : 0,
					"multiCounter"	:	i
				},
				success : function (r) {
					if(r.status) {
						$.jstree.rollback(data.rlbk);
					}else {
						$(data.rslt.oc).attr("id", "node_" + r.id);
						if(data.rslt.cy && $(data.rslt.oc).children("UL").length) {
							data.inst.refresh(data.inst._get_parent(data.rslt.oc));
						}
					}
				}
			});
		});
	});
});
	
	function getTimestamp(){
		return Math.floor(new Date().getTime());
	}
</script>
<!-- //전체 레이어 끝 -->
</body>
</html>


