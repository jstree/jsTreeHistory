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
.demo-grade-con #myMenu {width:100%}
.logo-img {width:120px; height:120px}
</style>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css" />

<customTags:assetsJsExtendNas theRestOfFileName="/js/jstree-v.pre1.0/_lib/jquery.cookie.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/jstree-v.pre1.0/_lib/jquery.hotkeys.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/jstree-v.pre1.0/jquery.jstree.js"></customTags:assetsJsExtendNas>
<customTags:assetsJsExtendNas theRestOfFileName="/js/jquery.form.js"></customTags:assetsJsExtendNas>


<script type="text/javascript">
	var NODE_OBJ = {};
	
	function fnInitGradeForm(){
		$('#myMenuList option').remove();
		$('input[name="accessMenuList"]').remove();		
		$('#gradeName').text('');
		$('#iconFileNm').attr('src', '${pageContext.request.contextPath}/assets/images/logo.jpg');
		$('#gradeForm')[0].reset();	
		$('input[type=checkbox]').attr('checked',false);
	}
	
	$(function () {
	
		$('#gradeForm').submit(function() {
			return false;
	    });
		
		$("input:text").bind('keydown',function(e) {	        
			if (e.keyCode == 13){
	            return false;
	        }
	    });
		
		$('#saveBtn').bind('click', function(e){
			$('#myMenuList option').each(function(idx, value){
				$('#gradeForm').append('<input type="hidden" name="accessMenuList" value="' +  this.value + '"/>');
			});
			
			$('#gradeForm').ajaxSubmit({	
				 type : 'post'			
						,contentType : 'multipart/form-data'			
						,beforeSubmit: function(formArray, jqForm, options){
							var fileReg = /gif|jpg|jpeg|png/i;
							var saveFileNm = "";
							$(formArray).each( function(idx, value){
								if('uploadImgFile' == this.name && '' != this.value && null != this.value){
									saveFileNm = this.value;
									var fileExtension = this.value.substring(this.value.lastIndexOf(".") + 1);						
									if(!fileReg.test(fileExtension)){
										alert('등급별 아이콘은 이미지 파일만 설정 가능합니다.');
										return false;
									}
								}
							});
							if('' == saveFileNm || null == saveFileNm){
								options.contentType = 'application/x-www-form-urlencoded; charset=UTF-8';	
							}
						}
						,success : function(r, stat){
							$('input[name="accessMenuList"]').remove();
							NODE_OBJ = {};
							jQuery.jstree._reference('#gradeTree').load_node_json(-1,false,false);
							
							fnInitGradeForm();
						}
						,error : function(r){
							alert(r);
						}
					});
		});
		
		/*$('#gradeForm').ajaxForm({	
			 type : 'post'			
			,contentType : 'multipart/form-data'			
			,beforeSubmit: function(formArray, jqForm, options){
				var fileReg = /gif|jpg|jpeg|png/i;
				var saveFileNm = "";
				$(formArray).each( function(idx, value){
					if('uploadImgFile' == this.name && '' != this.value && null != this.value){
						saveFileNm = this.value;
						var fileExtension = this.value.substring(this.value.lastIndexOf(".") + 1);						
						if(!fileReg.test(fileExtension)){
							alert('등급별 아이콘은 이미지 파일만 설정 가능합니다.');
							return false;
						}
					}
				});
				if('' == saveFileNm || null == saveFileNm){
					options.contentType = 'application/x-www-form-urlencoded; charset=UTF-8';	
				}
				
				//$('#myMenuList option').each(function(idx, value){
					//$('#gradeForm').append('<input type="hidden" name="accessMenuList" value="' +  this.value + '"/>');
				//});
			}
			,success : function(r, stat){
				$('input[name="accessMenuList"]').remove();
				jQuery.jstree._reference('#gradeTree').load_node_json(0,false,false);
			}
			,error : function(r){
				alert(r);
			}
		});*/	
		
		$('#uploadImgFile').bind('change', function(e){		 
			//var currentNode = $.jstree._focused().get_selected();			
			//var currentNodePosition = currentNode.attr("position");
			
			if(this.files && this.files[0]){
				var file = this.files[0];
				
				var reader = new FileReader();
				reader.onload = function(e){
					$('#iconFileNm').attr('src', e.target.result);
					
					//if(currentNodePosition != null && currentNodePosition != ''){
						//NODE_OBJ[currentNodePosition].img = e.target.result; 		
					//}
				};
				
				reader.readAsDataURL(file);
			}	
		});
		
		$('#menuAddBtn').bind('click', function(e){
			var $selectOption = $('#menuList option:selected'); 
			var code = $selectOption.val();
			var codeName = $selectOption.text();
			
			if($('#myMenuList').find('option[value="'+(codeName+'|'+ code)+'"]')[0]){
				alert('존재하는 메뉴입니다.');
				return false;
			}
			
			$('#myMenuList').append('<option value="' + (codeName+'|'+ code) + '">' + codeName + '</option>');
			//$('#gradeForm').append('<input type="hidden" name="accessMenuList" value="' +  (codeName+'|'+ code) + '"/>');
			
			var currentNode = $.jstree._focused().get_selected();			
			var currentId = currentNode.attr('id');
			var currentPosition = currentNode.attr('position');
			var nodeObj = NODE_OBJ[currentPosition];
			
			if(currentId == null || currentId == ''){
				if(nodeObj != null && nodeObj.menuList != null){
					nodeObj.menuList[code] = codeName;
					
				}else if(nodeObj != null){
					nodeObj.menuList = {};
					nodeObj.menuList[code] = codeName;
					
				}else{
					nodeObj = {};
					nodeObj.menuList = {};
					nodeObj.menuList[code] = codeName;
					NODE_OBJ[currentPosition] = nodeObj;
				}				
			}
		});
		
		$('#menuDelBtn').bind('click', function(e){		
			var currentNode = $.jstree._focused().get_selected();			
			var currentId = currentNode.attr('id');
			var currentPosition = currentNode.attr('position');
			var nodeObj = NODE_OBJ[currentPosition];
			
			$('#myMenuList option:selected').each(function(){
				$(this).remove();
				//$('input:hidden[value="'+ this.value + '"]').remove();

				var propName = this.value.split('|')[1];
				
				if(currentId == null || currentId == ''){
					if(nodeObj != null && nodeObj.menuList != null){
						delete NODE_OBJ[currentPosition ].menuList[propName];
					}				
				}
			});
		});
		
		$('#gradeTree')
			.jstree({ 
				// List of active plugins
				'plugins' : [ 
					'themes'
					,'json_data'
					,'ui'
					,'crrm'
					//,'cookies'
					//,'dnd'
					//,'search'
					,'types'
					//,'hotkeys'
					,'contextmenu'
					//,'checkbox'
				],
				
				//contextmenu
				'contextmenu' : 
				{         
					items : 
					{ // Could be a function that should return an object like this one             
						'create' : 
						{                 
							 'separator_before'  : true                  
							,'separator_after'   : true                 
							,'label'             : 'Create'                 
							,'action'            : function (obj){													
														this.create(obj, 'last', {'attr' : {'rel' : 'default'}});  													
												   }
					    }
					
					    ,'ccp' : false		
					}     
				}, 
		
				// I usually configure the plugin that handles the data first
				// This example uses JSON as it is most common
				'json_data' : { 
					// This tree is ajax enabled - as this is most common, and maybe a bit more complex
					// All the options are almost the same as jQuery's AJAX (read the docs)
					'ajax' : {
						// the URL to fetch the data
						'url' : '${pageContext.request.contextPath}/user/manage/grade/inquiryUserGradeList.do',
						// the `data` function is executed in the instance's scope
						// the parameter is the node being loaded 
						// (may be -1, 0, or undefined when loading the root nodes)
						'data' : function (n) {
							// the result is fed to the AJAX request `data` option
							return { 
								 'c_id' : n.attr ? n.attr('id').replace('node_','').replace('copy_','') : 1
							}; 
						},
						'success' : function (n) {
							
						}
					}
				},
				// Using types - most of the time this is an overkill
				// read the docs carefully to decide whether you need types
				'types' : {
					// I set both options to -2, as I do not need depth and children count checking
					// Those two checks may slow jstree a lot, so use only when needed
					'max_depth' : -2,
					'max_children' : -2,
					// I want only `drive` nodes to be root nodes 
					// This will prevent moving or creating any other type as a root node
					'valid_children' : [ 'drive' ],
					'types' : {
						// The default type
						'default' : {
							// I want this type to have no children (so only leaf nodes)
							// In my case - those are files
							'valid_children' : 'none',
							// If we specify an icon for the default type it WILL OVERRIDE the theme icons
							'icon' : {
								'image' : 'http://www.313.co.kr/php/lh_7th/data/admin/pds/scriptPool/jQueryPlugIns/jstree-v.pre1.0/_demo/file.png'
							}
						},
						// The `folder` type
						'folder' : {
							// can have files and other folders inside of it, but NOT `drive` nodes
							'valid_children' : [ 'default', 'folder' ],
							'icon' : {
								'image' : 'http://www.313.co.kr/php/lh_7th/data/admin/pds/scriptPool/jQueryPlugIns/jstree-v.pre1.0/_demo/folder.png'
							}
						},
						// The `drive` nodes 
						'drive' : {
							// can have files and folders inside, but NOT other `drive` nodes
							'valid_children' : [ 'default', 'folder' ],
							'icon' : {
								'image' : 'http://www.313.co.kr/php/lh_7th/data/admin/pds/scriptPool/jQueryPlugIns/jstree-v.pre1.0/_demo/root.png'
							},
							// those prevent the functions with the same name to be used on `drive` nodes
							// internally the `before` event is used
							'start_drag' : false,
							'move_node' : false,
							'delete_node' : false,
							'remove' : false
						}
					}
				},
				// UI & core - the nodes to initially select and open will be overwritten by the cookie plugin
		
				// the UI plugin - it handles selecting/deselecting/hovering nodes
				'ui' : {
					// this makes the node with ID node_2 selected onload
					 'initially_select' : [ "node_3" ]
				    ,'select_multiple_modifier' : false
				},
				// the core plugin - not many options here
				'core' : { 
					// just open those two nodes up
					// as this is an AJAX enabled tree, both will be downloaded from the server
					'initially_open' : [ 'node_2' , 'node_3' ] 
				}
			})
			.bind('create.jstree', function (e, data) {
				
				$(data.rslt.obj).attr('position', data.rslt.position);
				
				var newNodePosition = data.rslt.position;
				NODE_OBJ[newNodePosition]          = {};
				NODE_OBJ[newNodePosition].id       = null;
				NODE_OBJ[newNodePosition].ref      = data.rslt.parent.attr('id').replace('node_','').replace('copy_','');
				NODE_OBJ[newNodePosition].position = newNodePosition;
				NODE_OBJ[newNodePosition].title    = data.rslt.name;
				NODE_OBJ[newNodePosition].type     = data.rslt.obj.attr('rel');
				NODE_OBJ[newNodePosition].menuList = {};
				
				$(data.rslt.parent).find('li').each( function(idx, node) {
	                $.jstree._focused().deselect_node(node);
	            });			
				$.jstree._focused().deselect_node(data.rslt.parent);
				$.jstree._focused().select_node(data.rslt.obj);
				
				//fnInitGradeForm();
			})
			.bind('remove.jstree', function (e, data) {
				if("default" != data.rslt.obj.attr('rel')){
					return false;
				}
				var selectNodeId = data.rslt.obj.attr('id');
				if(null != selectNodeId && '' != selectNodeId){
					selectNodeId = selectNodeId.replace('node_','').replace('copy_','');
					
					if(selectNodeId <= 6){
						alert('기본 제공 등급은 삭제할 수 없습니다.');
						return false;
					}
					
					callAjax(null
							, '${pageContext.request.contextPath}/user/manage/grade/removeNode.do'
			            	, null
			            	, 'post'
			            	, 'json'
			            	, { 'c_id' : selectNodeId}
			            	, 'application/json'
			            	, function(r){
								
			              	  }
							,null
							,null
							,true);					
								
				}else{
					return false;
				}
			})
			.bind('rename.jstree', function (e, data) {				
				$('#gradeName').text(data.rslt.new_name);
				$('#c_title').val(data.rslt.new_name);
				
				var currentPosition = data.rslt.obj.attr('position');
				var nodeObj = NODE_OBJ[currentPosition];
				
				if(nodeObj != null){
					nodeObj.title = data.rslt.new_name;	
				}else{
					nodeObj = {};
					nodeObj.title = data.rslt.new_name;
					NODE_OBJ[currentPosition] = nodeObj;
				}				
			})		
			.bind('select_node.jstree', function(e, data){
				if('default' != data.rslt.obj.attr('rel')){
					return false;
				}
				
				fnInitGradeForm();
				
				//input type file 초기화
				var $inputFile = $('#uploadImgFile'); 
				$inputFile.replaceWith($inputFile.val('').clone(true));
				
				var selectNodeId = data.rslt.obj.attr('id');
				var currentNodePosition = data.rslt.obj.attr('position');
				
				if(null != selectNodeId && '' != selectNodeId){
					selectNodeId = selectNodeId.replace('node_','').replace('copy_','');
					
					callAjax(null
					, '${pageContext.request.contextPath}/user/manage/grade/inquiryUserGradeDetailInf.do'
	            	, null
	            	, 'post'
	            	, 'json'
	            	, {'c_id' : selectNodeId}
	            	, 'application/json'
	            	, function(r){
						$('#iconFileNm').attr('src', '${pageContext.request.contextPath}' + '/' + r.storeFileNm);
						
						$(r.userMenuByGradeList).each(function(idx, value){
							$('#myMenuList').append('<option value="' + (this.c_title+'|'+ this.menuId) + '">' + this.c_title + '</option>');
						});
						
						var bakupObj = NODE_OBJ[currentNodePosition];
						if(bakupObj && bakupObj.title){
							$('#c_title').val(bakupObj.title);
							$('#gradeName').text(bakupObj.title);
						}else{
							$('#c_title').val(r.c_title);
							$('#gradeName').text(r.c_title);
							bakupObj = {};
							bakupObj.title = r.c_title;
							NODE_OBJ[currentNodePosition] = bakupObj;
						}
						
	            		$('#c_id').val(r.c_id);
						$('#pointByGrade').val(r.pointByGrade);
						$('#pointByGradeUseFl').attr('checked', r.pointByGradeUseFl);
	              	  }
					,null
					,null
					,true);				
					
				}else{
					$('#c_id').val(0);
					//$('#ref').val(NODE_OBJ[currentNodePosition].ref);
					$('#c_title').val(NODE_OBJ[currentNodePosition].title);
					$('#gradeName').text(NODE_OBJ[currentNodePosition].title);
					//$('#c_type').val("default");
					
					var menuObj = NODE_OBJ[currentNodePosition].menuList;
					for(var code in menuObj){
						$('#myMenuList').append('<option value="' + (menuObj[code]+'|'+ code) + '">' + menuObj[code] + '</option>');	
					}					
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
							<form id="gradeForm" name="gradeForm" action="${pageContext.request.contextPath}/user/manage/grade/saveUserGrade.do" method="post" enctype="multipart/form-data">
								<div class="responsive_jsrow">
									<div class="c_name">등급명</div>
									<div id="gradeName" class="c_value">
										
									</div>
								</div>
	 
								<div class="responsive_jsrow">
									<div class="c_name">메뉴ID</div>
									<div class="c_value">
										<select id="menuList">
											<c:forEach var="item" items="${menuList}">
												<option value="${item.c_id}">${item.c_title}</option>
											</c:forEach>
										</select>
										<button id="menuAddBtn" type="button">추가</button>
										<div>
											<select id="myMenuList" name="myMenuList" multiple="multiple" size="5">
												<c:forEach var="item" items="${userMenuByGradeList}">
													<option value="${item.c_id}">${item.c_title}</option>
												</c:forEach>
											</select>
											<button id="menuDelBtn" type="button">삭제</button>
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
												<img id="iconFileNm" class="logo-img" src="${pageContext.request.contextPath}/assets/images/logo.jpg" onerror="this.src='${pageContext.request.contextPath}/assets/images/logo.jpg'">
											</div>
											<div class="wrapper">
												<input id="uploadImgFile" class="reset-btn" type="file" name="uploadImgFile" value="추가">
											</div>
										</div>
									</div>
								</div>
								<div class="responsive_jsrow">								
									<button id="saveBtn" type="submit">저장하기</button>
								</div>
								<input type="hidden" id="c_id" name="c_id"/>
								<!-- <input type="hidden" id="ref" name="ref" value=""/> -->
								<input type="hidden" id="c_title" name="c_title"/>
								<!-- <input type="hidden" id="c_type" name="c_type"/> -->
							</form>
						</div>						
					</div>
				</div>					
			</div>
		</div>
	</div>
</section>
