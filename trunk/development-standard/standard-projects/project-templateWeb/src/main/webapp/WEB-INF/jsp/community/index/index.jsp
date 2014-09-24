<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head> 
<link rel="stylesheet" type="text/css" href="http://nas.313.co.kr:5002/Component/jsp/community/index/reset.css">
<link rel="stylesheet" type="text/css" href="http://nas.313.co.kr:5002/Component/jsp/community/index/index.css">
<style type="text/css">
</style>
<!-- jQuery -->
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/index/jquery-1.11.1.js"></script>
<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
<!--[if lt IE 9]>
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/index/debug.js"></script>
<![endif]-->
<!-- JSTREE -->
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/jstree-v.pre1.0/_lib/jquery.cookie.js"></script>
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/jstree-v.pre1.0/_lib/jquery.hotkeys.js"></script>
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/jstree-v.pre1.0/jquery.jstree.js"></script>
<!-- JavaScript -->
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/Script/ajax/ajax.js" charset="UTF-8"></script>
<script language='javascript'>
	function fn_ClassChange()
	{
		$(".asideSectionHeight").height("300px");
	}
	function fn_ClassOriginal()
	{
		$(".asideSectionHeight").height("700px");
	}
</script>
</head>

<body>
	<table class="layout"> 
    	<tr>
        	<td class="logoBackColor"></td>
			<td class="logoAsideWidth logoBackColor"></td>
			<td class="gapWidth logoRightGapImgOver"></td>
			<td class="sectionWidth gnbAsideBackColor"></td>
			<td class="gapWidth gnbAsideBackColor"></td>
		<td class="gnbAsideBackColor"></td>
	</tr>
	<tr> <!-- í ìì­ -->
        	<td class="logoGnbHeight">
        		<div class="logoBackColor logoGnbHeight">
			</div>
        	</td>
			<td class="logoAsideWidth logoGnbHeight">
	           	<div class="logoBackColor logoGnbHeight">
	           		<img src="http://nas.313.co.kr:5002/Component/jsp/community/index/image/logo7.jpg"/>
				</div>
			</td>
			<td class="gapWidth logoGnbHeight">
	           	<div class="logoGnbHeight logoRightGapImg">
				</div>
			</td>
			<td class="sectionWidth logoGnbHeight">
				<div class="gnbAsideBackColor logoGnbHeight">
				</div>
			</td>
			<td class="gapWidth logoGnbHeight">
	           	<div class="gnbAsideBackColor logoGnbHeight">
				</div>
			</td>
		<td class="logoGnbHeight">	
	           <div class="gnbAsideBackColor logoGnbHeight">
	            </div>
		</td>
	</tr>
	<tr> <!-- ì¤ê° ëìì¸-->
        	<td class="gapHeight">
        		<div class="gapHeight logoBottomGapImgOver">
			</div>
        	</td>
			<td class="logoAsideWidth gapHeight">
	           	<div class="gapHeight logoBottomGapImg">
				</div>
			</td>
			<td class="gapWidth gapHeight">
	           	<div class="gapHeight logoCrossGapImg">
				</div>
			</td>
			<td class="sectionWidth gapHeight">
				<div class="gapHeight gnbBottomGapImg">
				</div>
			</td>
			<td class="gapWidth gapHeight">
	           	<div class="gapHeight gnbCrossGapImg">
				</div>
			</td>
		<td class="gapHeight">
	           <div class="gapHeight gnbOuterBottomGapImg">
	            </div>
		</td>
	</tr>
	
	<tr>
        	<td class="asideSectionHeight">
            	<div class="asideSectionHeight gnbAsideBackColor">
            	</div>
        	</td>
			<td class="logoAsideWidth asideSectionHeight">
				<div id="jstreeSearch" class="asideSectionSearchHeight gnbAsideBackColor">
					<table class="logoAsideWidth asideSectionSearchHeight ">
						<tr>
							<td class="jstreeSearchLeft"></td>
							<td class="jstreeSearchMiddle"></td>
							<td class="jstreeSearchRight"></td>
						</tr>
					</table>
				</div>
	            <div id="demo" class="asideSectionMenuHeight gnbAsideBackColor">	
	            </div>
			</td>
			<td class="gapWidth asideSectionHeight">
	            <div class="asideSectionHeight asideRightGapImg">
	            </div>
			</td>
			<td class="sectionWidth asideSectionHeight">
            		<div id="section" class="asideSectionHeight" style="background-color:#fffff">
					<input type="button" value="change" onClick="fn_ClassChange();" />
					<input type="button" value="origin" onClick="fn_ClassOriginal();" />
					&copy; 2013-2014 Developer Group 313, Inc. All rights reserved.
            		</div>
			</td>
			<td class="gapWidth asideSectionHeight">
	            	<div class="asideSectionHeight sectionRightGapImg">
	            	</div>
			</td>
		<td class="asideSectionHeight">	
	            <div class="asideSectionHeight sectionOuterBackColor">
	            </div>
		</td>
	</tr>
	<tr> <!-- íë¨ ëìì¸-->
        	<td height="20px">
        		<div class="gnbAsideBackColor gapHeight">
			</div>
        	</td>
			<td class="logoAsideWidth gapHeight">
	           	<div class="gnbAsideBackColor gapHeight">
				</div>
			</td>
			<td class="gapWidth gapHeight">
	           	<div class="gapHeight asideCrossGapImg">
				</div>
			</td>
			<td class="sectionWidth gapHeight">
				<div class="gapHeight sectionBottomGapImg">
				</div>
			</td>
			<td class="gapWidth gapHeight">
	           	<div class="gapHeight sectionCrossGapImg">
				</div>
			</td>
		<td class="gapHeight">
	           <div class="gapHeight sectionOuterBackColor">
	            </div>
		</td>
	</tr>
	<tr>
        	<td class="gnbAsideBackColor"></td>
			<td class="logoAsideWidth gnbAsideBackColor"></td>
			<td class="gapWidth asideOuterRightGapImg"></td>
			<td class="sectionWidth sectionOuterBackColor"></td>
			<td class="gapWidth sectionOuterBackColor"></td>
		<td class="sectionOuterBackColor"></td>
	</tr>
    </table>
    
    <div id="nodeForm" style="display:none;">
    	<ul>
    		<li>노드명 : <input type="text" id="nodeTitle"   /></li>
    		<li>URL   : <input type="text" id="nodeLinkUrl" /></li>
    	</ul>
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
		$("li:not([rel='drive']).jstree-open > a > .jstree-icon").css('background-image','url(http://nas.313.co.kr:5002/Design/icon/miniCon/313/toolbar_open.png)');
		$("li:not([rel='drive']).jstree-closed > a > .jstree-icon").css('background-image','url(http://nas.313.co.kr:5002/Design/icon/miniCon/313/ic_explorer.png)');
	})
	// listen for event
  	.bind('select_node.jstree', function(e) {
	    // gather ids of selected nodes
	    var selected_ids = [];
	    $("#demo").jstree('get_selected').each(function () { 
	    	if(typeof($(this).attr('href')) === "undefined"){
		        selected_ids.push(this.id + ", href empty"); 
	    	}else{
	    		selected_ids.push(this.id + ', ' + $(this).attr('href')); 
	    	}
	    }); 
	    // do summit with them
	    // alert(selected_ids);
	    
	    // TODO ë¤ì¤ ì íì ë§ìì¼ í¨!
		
	    
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
							"label" : "File",                         
							action : function (obj) 
							{
								console.log(obj);
								console.log( "ref c_id   : " + $(obj).attr("id").replace("node_","").replace("copy_","") );
								console.log( "c_position : " + $(obj).children().filter("ul").children().length );
								
								// 파일인 경우에 실행하지 않는다
								if( $(obj).attr("rel") != 'default' ){
									
									$("#nodeForm").dialog({
										title  : "새 노드 추가"
									  ,	buttons: {
									        Ok    : function() {
									        	excuteAddNode( obj, "default" );
									        },
									        Cancel: function() {
									            $( "#nodeForm" ).dialog( "close" );
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
									
									$("#nodeForm").dialog({
										title  : "새 노드 추가"
									  ,	buttons: {
									        Ok    : function() {
									        	excuteAddNode( obj, "folder" );
									        },
									        Cancel: function() {
									            $( "#nodeForm" ).dialog( "close" );
									        }
									    }
									});
									$("#nodeForm").dialog("open");
								}
								// this.create(obj, "last", {"attr" : { "rel" : "folder"}});                         
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
				/* "url" : "/templateWeb/egovframework/com/ext/jstree/strutsiBatis/getChildNode.action", */
				"url" : "${pageContext.request.contextPath}/none/json/community/largeMenu/middleMenu/smallMenu/menu/invokeSelect.do",
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
				/* "url" : "/templateWeb/egovframework/com/ext/jstree/strutsiBatis/searchNode.action", */
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
	.bind("loaded.jstree", function (e, data) {
		
		$(document).on('click', '#demo a', function(e) {
			
			var url = $(this).parent().attr('href');
			
			if (typeof(href) === 'undefined') { alert('href ê°ì´ ì ìëì§ ìììµëë¤.'); }
			
			callAjax(null, url, '#section', 'GET', 'html');
			
			return false;
		});
	})
	.bind("remove.jstree", function (e, data) {
		//$.jstree.rollback(data.rlbk);
		if(confirm("ì­ì íìê² ìµëê¹?")){
			data.rslt.obj.each(function () {
				$.ajax({
					 async : false
					,type: 'POST'
					//,url: "/templateWeb/egovframework/com/ext/jstree/strutsiBatis/removeNode.action"
					,url: "${pageContext.request.contextPath}/none/json/community/largeMenu/middleMenu/smallMenu/menu/removeNode.do"
					,data : { 
						 "c_id"       : this.id.replace("node_","").replace("copy_","")
						,"c_type"     : data.rslt.obj.attr("rel")						
						/*,"c_parentid" : data.rslt.parentid
						,"c_position" : data.rslt.position
						,"c_left"     : data.rslt.left
					    ,"c_right"    : data.rslt.right*/
					}
					,success : function (r) {
						$("#analyze").click();
						$("span.ui-icon-refresh").click();
					}
				});
			});
		}else{
			$.jstree.rollback(data.rlbk);
		}
	})
	.bind("rename.jstree", function (e, data) {
		$.post(
				/* "/templateWeb/egovframework/com/ext/jstree/strutsiBatis/alterNode.action", */
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
				$("span.ui-icon-refresh").click();
			}
		);
	})
	.bind("set_type.jstree", function (e, data) {
		$.post(
				/* "/templateWeb/egovframework/com/ext/jstree/strutsiBatis/alterNodeType.action", */
				"${pageContext.request.contextPath}/egovframework/com/etc/jstree/core/springiBatis/alterNodeType.do",
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
				/* url: "/templateWeb/egovframework/com/ext/jstree/strutsiBatis/moveNode.action", */
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
					$("span.ui-icon-refresh").click();
				}
			});
		});
	});

});

	function excuteAddNode( obj, type ){
		$.post(
			"${pageContext.request.contextPath}/none/json/community/largeMenu/middleMenu/smallMenu/menu/addNode.do",
			{ 
				"ref" : $(obj).attr("id").replace("node_","").replace("copy_",""), 
				"c_position" : $(obj).children().filter("ul").children().length,
				"c_title" : $("#nodeTitle").val(),
				"c_type" : type,
				"url" : $("#nodeLinkUrl").val()
			}, 
			function (r) {
				console.log(r);
				$("#nodeTitle").val("");
				$("#nodeLinkUrl").val("");
				$("#nodeForm").dialog("close");
 				$("span.ui-icon-refresh").click();
			}
		);
	}
</script>
</body>
</html>