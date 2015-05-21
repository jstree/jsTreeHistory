/**
 * @license Copyright (c) 2003-2014, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */
CKEDITOR.editorConfig = function( config ) {
	 config.toolbar =[
	                  //['Source'],
	                  ['Bold','Italic','Underline'],
	                  ['Image','Link'],
	                  ['FontSize','TextColor','BGColor']
	              ];
	 /*config.font_names = '굴림; 돋움; 궁서; HY견고딕; HY견명조; 휴먼둥근헤드라인;' 
         + '휴먼매직체; 휴먼모음T; 휴먼아미체; 휴먼엑스포; 휴먼옛체; 휴먼편지체;' 
         +  CKEDITOR.config.font_names;*/
	 
	 config.language = "ko";  //나라 설정(한국)
	 config.height = '320px'; //에디터 높이 셋팅
	 config.maxSize = '1M';   //업로드 용량 1메가로 제한
	 config.allowedExtensions = 'gif,jpeg,jpg,png';
	 config.removePlugins = 'elementspath'; //바닥에 태그 표시 되는 부분 제거
	 
	 /*config.toolbar =[
	                  ['Source','-','Cut','Copy','Paste','PasteText','PasteFromWord','Undo','Redo','SelectAll','RemoveFormat'],
	                  '/',
	                  ['Bold','Italic','Underline','Strike', 'Subscript','Superscript'],
	                  ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
	                  ['NumberedList','BulletedList','Outdent','Indent','Blockquote','CreateDiv'],
	                  ['Image','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
	                  ['Styles','Format','Font','FontSize','TextColor','BGColor','Maximize', 'ShowBlocks']
	              ];*/
};
