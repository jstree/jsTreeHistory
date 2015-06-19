<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags" %>

<style type="text/css">
.clearfix:after {display:block; content:""; clear:both}
.demo-grade {float:left; width:26%; padding:3% 1% 1%; border-top:1px solid #444}
.demo-grade-con {float:right; width:70%; padding:3% 1% 1%; border-top:1px solid #444}
.demo-grade-con .responsive_jsrow {width:100%;}
.demo-grade-con .responsive_jsrow:after {display:block; content:""; clear:both}
.demo-grade-con .responsive_jsrow .c_name {display:inline-block; flaot:left; width:26%}
.demo-grade-con .responsive_jsrow .c_value {float:right; width:70%}
.demo-grade-con .responsive_jsrow .c_value select {float:left; max-width:50%; height:50%; margin-right:1%}
.demo-grade-con .responsive_jsrow .c_value .g-point input {display:inline-block; width:20%; float:left}
.demo-grade-con .responsive_jsrow .c_value .g-point em {position:relative; top:8px; margin-left:5px; font-style:normal}
.demo-grade-con textarea {width:100%}
</style>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css" />

<customTags:assetsJsExtendNas theRestOfFileName="/js/jstree-v.pre1.0/_lib/jquery.cookie.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/jstree-v.pre1.0/_lib/jquery.hotkeys.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/jstree-v.pre1.0/jquery.jstree.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/jquery.form.js"></customTags:assetsJsExtendNas>


<script type="text/javascript">
	var NODE_OBJ = {};
	
	$(function () {
	
	$("#saveBtn").bind("click", function(e){
		
		var currentNode = $.jstree._focused().get_selected();
		var currentNodeId = currentNode.attr("id");
		//var parent_node = $.jstree._reference("#gradeTree")._get_parent();
		//var a_node = $.jstree._reference("#gradeTree")._get_node();
		var url = '${pageContext.request.contextPath}/user/manage/grade/inquiryUserGradeList.do';
		if(null != currentNodeId && "" != currentNodeId){
			url = '${pageContext.request.contextPath}/user/manage/grade/alterNode.do';
		}else{
			url = '${pageContext.request.contextPath}/user/manage/grade/addNode.do';
		}
		$('#gradeForm').attr('action', url);
		
		callAjax({
			 form          : 'gradeForm'
			,url           : url
			,type          : 'post'
			,contentType   : 'multipart/form-data'
			,returnType    : 'json'
			,callback      : function(r){
				             	alert(r);
              	                jQuery.jstree._reference("#gradeTree").load_node_json(-1,false,false);	
		                     }
		    ,async         : false
		});
		
		/*callAjax('gradeForm'
				, url
                , null
                , 'post'
                , 'json'
                , 'multipart/form-data'//'application/json'
                , function(r){
					alert(r);
                  	jQuery.jstree._reference("#gradeTree").load_node_json(-1,false,false); 
                  }
				, true
				, false
				, false);*/
	});
	
	$("#uploadImgFile").bind("change", function(e){		 
		if(this.files && this.files[0]){
			var file = this.files[0];
			
			var reader = new FileReader();
			reader.onload = function(e){
				$('#uploadImg').width('100');
				$('#uploadImg').height('100');
				$('#uploadImg').attr('src', e.target.result);
			};
			
			reader.readAsDataURL(file);
		}	
	});
	
	
	$("#gradeTree")
		.jstree({ 
			// List of active plugins
			"plugins" : [ 
				"themes"
				,"json_data"
				,"ui"
				,"crrm"
				//,"cookies"
				//,"dnd"
				//,"search"
				,"types"
				//,"hotkeys"
				,"contextmenu"
				//,"checkbox"
			],
			
			//contextmenu
			"contextmenu" : 
			{         
				items : 
				{ // Could be a function that should return an object like this one             
					"create" : 
					{                 
						 "separator_before"  : true                  
						,"separator_after"   : true                 
						,"label"             : "Create"                 
						,"action"            : function (obj){													
													this.create(obj, "last", {"attr" : {"rel" : "default"}});  													
											   }
				    }
				
				    ,"ccp" : false		
				}     
			}, 
	
			// I usually configure the plugin that handles the data first
			// This example uses JSON as it is most common
			"json_data" : { 
				// This tree is ajax enabled - as this is most common, and maybe a bit more complex
				// All the options are almost the same as jQuery's AJAX (read the docs)
				"ajax" : {
					// the URL to fetch the data
					"url" : "${pageContext.request.contextPath}/user/manage/grade/inquiryUserGradeList.do",
					// the `data` function is executed in the instance's scope
					// the parameter is the node being loaded 
					// (may be -1, 0, or undefined when loading the root nodes)
					"data" : function (n) {
						// the result is fed to the AJAX request `data` option
						return { 
							 "c_id" : n.attr ? n.attr("id").replace("node_","").replace("copy_","") : 1
						}; 
					},
					"success" : function (n) {
						NODE_OBJ[n[0].c_position]          = {};
						NODE_OBJ[n[0].c_position].id       = n[0].c_id;
						NODE_OBJ[n[0].c_position].ref      = n[0].c_parentid;
						NODE_OBJ[n[0].c_position].position = n[0].c_position;
						NODE_OBJ[n[0].c_position].title    = n[0].c_title;
						NODE_OBJ[n[0].c_position].type     = n[0].c_type;
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
			    ,"select_multiple_modifier" : false
			},
			// the core plugin - not many options here
			"core" : { 
				// just open those two nodes up
				// as this is an AJAX enabled tree, both will be downloaded from the server
				"initially_open" : [ "node_2" , "node_3" ] 
			}
		})
		.bind("create.jstree", function (e, data) {
			
			$(data.rslt.obj).attr("position", data.rslt.position);
			
			var newNodePosition = data.rslt.position;
			NODE_OBJ[newNodePosition]          = {};
			NODE_OBJ[newNodePosition].id       = null;
			NODE_OBJ[newNodePosition].ref      = data.rslt.parent.attr("id").replace("node_","").replace("copy_","");
			NODE_OBJ[newNodePosition].position = newNodePosition;
			NODE_OBJ[newNodePosition].title    = data.rslt.name;
			NODE_OBJ[newNodePosition].type     = data.rslt.obj.attr("rel");
						
			$(data.rslt.parent).find("li").each( function(idx, node) {
                $.jstree._focused().deselect_node(node);
            });			
			$.jstree._focused().deselect_node(data.rslt.parent);
			$.jstree._focused().select_node(data.rslt.obj);
			
			$('input[type=checkbox]').attr('checked',false);
			$('#gradeForm')[0].reset();			
			
		})
		.bind("remove.jstree", function (e, data) {
			if("default" != data.rslt.obj.attr("rel")){
				return false;
			}
			var selectNodeId = data.rslt.obj.attr("id");
			if(null != selectNodeId && "" != selectNodeId){
				selectNodeId = selectNodeId.replace("node_","").replace("copy_","");
				
							
				callAjax({
					 data          : { 'c_id' : selectNodeId}
					,url           : '${pageContext.request.contextPath}/user/manage/grade/removeNode.do'
					,type          : 'post'
					,contentType   : 'application/json'
					,callback      : function(r){
						             	$('input[type=checkbox]').attr('checked',false);
										$('#gradeForm')[0].reset();	
				                     }
				});
				/*
				callAjax({"c_id" : selectNodeId}
				, "${pageContext.request.contextPath}/user/manage/grade/removeNode.do"
            	, null
            	, "post"
            	, "json"
            	, "application/json"
            	, function(r){
					$('input[type=checkbox]').attr('checked',false);
					$('#gradeForm')[0].reset();	
              	  }
				,true
				,false
				,true);*/
			}else{
				return false;
			}
		})
		.bind("rename.jstree", function (e, data) {
			var currentPosition = data.rslt.obj.attr("position");
			$('#gradeName').text(data.rslt.new_name);
			$('#c_title').val(data.rslt.new_name);
			NODE_OBJ[currentPosition].title = data.rslt.new_name;
			
		})		
		.bind("select_node.jstree", function(e, data){
			if("default" != data.rslt.obj.attr("rel")){
				return false;
			}
			
			var selectNodeId = data.rslt.obj.attr("id");			
			if(null != selectNodeId && "" != selectNodeId){
				selectNodeId = selectNodeId.replace("node_","").replace("copy_","");
				
				callAjax({
					 data          : { 'c_id' : selectNodeId}
					,url           : '${pageContext.request.contextPath}/user/manage/grade/inquiryUserGradeDetailInf.do'
					,type          : 'post'
					,contentType   : 'application/json'
					,returnType    : 'json'
					,callback      : function(r){
										$('#c_id').val(r.c_id);
										$('#ref').val(r.c_parentid);
										$('#c_title').val(r.c_title);
										$('#gradeName').text(r.c_title);
										$('#c_type').val(r.c_type);
										$('#pointByGrade').val(r.pointByGrade);
										$('#pointByGradeUseFl').attr('checked', r.pointByGradeUseFl);
										
										NODE_OBJ[r.position]          = {};
										NODE_OBJ[r.position].id       = r.c_id;
										NODE_OBJ[r.position].ref      = r.c_parentid;
										NODE_OBJ[r.position].title    = r.c_title;
										NODE_OBJ[r.position].position = r.c_position;
										NODE_OBJ[r.position].type     = r.c_type;
				                     }
				});
				/*
				callAjax({"c_id" : selectNodeId}
					, "${pageContext.request.contextPath}/user/manage/grade/getNode.do"
                	, null
                	, "post"
                	, "json"
                	, "application/json"
                	, function(r){
						$('#c_id').val(r.c_id);
						$('#ref').val(r.c_parentid);
						$('#c_title').val(r.c_title);
						$('#gradeName').text(r.c_title);
						$('#c_type').val(r.c_type);
						$('#pointByGrade').val(r.pointByGrade);
						$('#pointByGradeUseFl').attr('checked', r.pointByGradeUseFl);
						
						NODE_OBJ[r.position]          = {};
						NODE_OBJ[r.position].id       = r.c_id;
						NODE_OBJ[r.position].ref      = r.c_parentid;
						NODE_OBJ[r.position].title    = r.c_title;
						NODE_OBJ[r.position].position = r.c_position;
						NODE_OBJ[r.position].type     = r.c_type;
                  	  }
					,true
					,false
					,true);*/
				
			}else{
				var currentPosition = data.rslt.obj.attr("position");
				
				$('#ref').val(NODE_OBJ[currentPosition].ref);
				$('#c_title').val(NODE_OBJ[currentPosition].title);
				$('#gradeName').text(NODE_OBJ[currentPosition].title);
				$('#c_type').val("default"); // NODE_OBJ[currentPosition].type
			}
		});
	
	});
</script>



<section>
	<div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
		<div class="tablet-mobile alpha bm-remove last">
			<div class="clearfix">
				<div class="demo-grade">		
					<div id="gradeTree" class="demo demo_side jstree jstree-0 jstree-focused jstree-default">
						
					</div>
				</div>
		
				<div class="demo-grade-con">			
					<div class="demo_con">
						<div id="jstreeTable_f_wrapper" class="dataTables_wrapper no-footer">
							<form id="gradeForm" method="post" enctype="multipart/form-data">
								<div class="responsive_jsrow">
									<div class="c_name">등급명</div>
									<div id="gradeName" class="c_value">
										
									</div>
								</div>
	 
								<div class="responsive_jsrow">
									<div class="c_name">메뉴ID</div>
									<div class="c_value">
										<select>
											<option value="1">MENU001</option>
											<option value="2">MENU002</option>
											<option value="3">MENU003</option>
										</select>
										<button id="Check">추가</button>
										<div>
											<textarea>MENU001</textarea>
										</div>
									</div>
								</div>
								<div class="responsive_jsrow">
									<div class="c_name">등급별 포인트 사용 여부</div>
									<div class="c_value">
										<input type="checkbox" id="pointByGradeUseFl" name="pointByGradeUseFl" value="1"/>
									</div>
								</div>
								<div class="responsive_jsrow">
									<div class="c_name">등급별 포인트 설정</div>
									<div class="c_value">
										<span class="g-point"><input type="text" id="pointByGrade" name="pointByGrade" value="0" /> <em>point</em></span>
									</div>
								</div>
								<div class="responsive_jsrow has-three-value">
									<div class="c_name">등급별 아이콘 설정</div>
									<div class="c_value">
										<div>
											<div>
												<img id="uploadImg" class="logo-img" src="" onerror="javascript:this.src='http://localhost/ROOT/assets/images/logo.jpg'">
											</div>
											<div class="wrapper">
												<input id="uploadImgFile" class="reset-btn" type="file" name="fileTest" value="추가">
											</div>
										</div>
									</div>
								</div>
								<div class="responsive_jsrow">								
									<button id="saveBtn" type="submit">저장하기</button>
								</div>
								<input type="hidden" id="c_id" name="c_id" value="0"/>
								<input type="hidden" id="ref" name="ref" value="0"/>
								<input type="hidden" id="c_title" name="c_title" />
								<input type="hidden" id="c_type" name="c_type" />
							</form>
						</div>						
					</div>
				</div>					
			</div>
		</div>
	</div>
</section>
