<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" autoFlush="true"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>
<html>
<head>
<!-- JSTREE -->
<customTags:assetsJsExtendNas theRestOfFileName="/js/jstree-v.pre1.0/_lib/jquery.cookie.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/jstree-v.pre1.0/_lib/jquery.hotkeys.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/jstree-v.pre1.0/jquery.jstree.js"></customTags:assetsJsExtendNas>

<!-- dataTable -->
<customTags:assetsCssExtendNas theRestOfFileName="/js/DataTables-1.10.10/media/css/jquery.dataTables.css"></customTags:assetsCssExtendNas>
<customTags:assetsCssExtendNas theRestOfFileName="/js/DataTables-1.10.10/extensions/Responsive/css/responsive.dataTables.css"></customTags:assetsCssExtendNas>

<customTags:assetsJsExtendNas theRestOfFileName="/js/DataTables-1.10.10/media/js/jquery.dataTables.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/DataTables-1.10.10/extensions/Responsive/js/dataTables.responsive.js"></customTags:assetsJsExtendNas>

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
<body>

<article>
	<div class="clearfix">
		<div class="container bm-remove">
			<div id="article" class="one-whole boxed p-twenty animate-in clearfix" data-anim-type="fade-in" data-anim-delay="0">
				<div class="article-body rte" itemprop="articleBody">
					<div class="clearfix">
						<div id="content2" style="width:100%;height:100%;">
							<div id="search_field">
								<div id="search_field_loc"><h2><strong>메뉴관리</strong></h2></div>
							</div>
				            <div id="demo">
					        </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</article>			
<div id="wrap">
	<div id="nodeForm" style="display:none;">
    	<ul>
    		<li>노드명 : <input type="text" id="nodeTitle"   /></li>
    		<li>URL   : <input type="text" id="nodeLinkUrl" /></li>
    	</ul>
    </div>
    <div id="nodeConfirm" title="확인"></div>	
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
						"image" : "${pageContext.request.contextPath}/assets/js/jstree-v.pre1.0/themes/attibutes.png"
					}
				},
				// The `folder` type
				"folder" : {
					// can have files and other folders inside of it, but NOT `drive` nodes
					"valid_children" : [ "default", "folder" ],
					"icon" : {
						"image" : "${pageContext.request.contextPath}/assets/js/jstree-v.pre1.0/themes/ic_explorer.png"
						//Design/icon/miniCon/313/toolbar_open.png
					}
				},
				// The `drive` nodes 
				"drive" : {
					// can have files and folders inside, but NOT other `drive` nodes
					"valid_children" : [ "default", "folder" ],
					"icon" : {
						"image" : "${pageContext.request.contextPath}/assets/js/jstree-v.pre1.0/themes/home.png"
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


