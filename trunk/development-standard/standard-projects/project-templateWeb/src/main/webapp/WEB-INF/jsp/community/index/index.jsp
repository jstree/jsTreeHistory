<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="http://nas.313.co.kr:5002/Component/jsp/community/index/reset.css">
<link rel="stylesheet" type="text/css" href="http://nas.313.co.kr:5002/Component/jsp/community/index/index.css">
<style type="text/css">
</style>
<!-- jQuery -->
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/index/jquery-1.11.1.js"></script>
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/index/debug.js"></script>
<!-- JSTREE -->
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/jstree-v.pre1.0/_lib/jquery.cookie.js"></script>
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/jstree-v.pre1.0/_lib/jquery.hotkeys.js"></script>
<script type="text/javascript" src="http://nas.313.co.kr:5002/Component/jsp/community/jstree-v.pre1.0/jquery.jstree.js"></script>
<!-- JavaScript -->
<script language='javascript'>
	function fn_ClassChange()
	{
		$(".asideSectionHeight").attr('class','asideSectionHeightTest');
	}
	function fn_ClassOriginal()
	{
		$(".asideSectionHeightTest").attr('class','asideSectionHeight');
	}
</script>
</head>

<body>
	<table class="layout">
    	<tr>
        	<td class="logoBackColor"></td>
			<td class="logoAsideWidth logoBackColor"></td>
			<td class="gapWidth logoRightGapImg"></td>
			<td class="sectionWidth gnbAsideBackColor"></td>
			<td class="gapWidth gnbAsideBackColor"></td>
		<td class="gnbAsideBackColor"></td>
	</tr>
	<tr> <!-- 탑 영역 -->
        	<td class="logoGnbHeight">
        		<div class="logoBackColor logoGnbHeight">
			</div>
        	</td>
			<td class="logoAsideWidth logoGnbHeight">
	           	<div class="logoBackColor logoGnbHeight">
	           		<img src="http://nas.313.co.kr:5002/Component/jsp/community/index/image/logo3.jpg"/>
				</div>
			</td>
			<td class="gapWidth logoGnbHeight">
	           	<div class="logoGnbHeight logoRightGapImg">
				</div>
			</td>
			<td class="sectionWidth logoGnbHeight">
				<div class="gnbAsideBackColor logoGnbHeight">
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;BaroBoard
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;DevTools
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Committers
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Knowledge
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
	<tr> <!-- 중간 디자인-->
        	<td class="gapHeight">
        		<div class="gapHeight logoBottomGapImg">
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
	            	<div id="demo" class="asideSectionHeight gnbAsideBackColor">
					
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
	<tr> <!-- 하단 디자인-->
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
<!-- JavaScript neccessary for the tree -->
<script type="text/javascript">
$(function () {

$("#demo")
	.bind("before.jstree", function (e, data) {
		//$("#section").append(data.func + "<br />");
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
				"url" : "/templateWeb/egovframework/com/ext/jstree/strutsiBatis/getChildNode.action",
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
				"url" : "/templateWeb/egovframework/com/ext/jstree/strutsiBatis/searchNode.action",
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
						"image" : "http://nas.313.co.kr:5002/Component/jsp/community/jstree-v.pre1.0/db.png"
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
	.bind("create.jstree", function (e, data) {
		$.post(
			"/templateWeb/egovframework/com/ext/jstree/strutsiBatis/addNode.action", 
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
				url: "/templateWeb/egovframework/com/ext/jstree/strutsiBatis/removeNode.action",
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
				"/templateWeb/egovframework/com/ext/jstree/strutsiBatis/alterNode.action", 
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
				"/templateWeb/egovframework/com/ext/jstree/strutsiBatis/alterNodeType.action", 
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
				url: "/templateWeb/egovframework/com/ext/jstree/strutsiBatis/moveNode.action",
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
</body>
</html>
