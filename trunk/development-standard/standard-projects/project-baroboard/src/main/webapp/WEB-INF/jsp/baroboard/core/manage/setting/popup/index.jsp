<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko" class="js">
<head>
<title>${pageName}</title>
<style type="text/css" id="style">
#popupManage .center {
    text-align: center;
}
#popupManage .right {
    text-align: right;
}
#popupManage .chk {
    height: 13px !important;
}
#popupManage select {
	height: 100%;
}
#popupManage input[type="text"] {
	width: 192px !important;
    height: 30px !important;
    display: inline !important;
}
#popupManage select {
	display: inline !important;
}
#popupManage #divBtns {
    text-align: right;
    margin-top: 10px;
}
#popupManage .compact {
	min-width: 71px;
    min-height: 37px;
}
/*
.responsive-row {
	width: 100%;
	height: auto;
	margin-bottom: 10px;
	overflow: auto;
	text-align: center;
	overflow: auto;
}
.responsive-row > div {
	float: left;
}
.item-name-left {
	width: 20%;
}
.item-value-left {
	width: 25%;
}
.item-name-right {
	width: 20%;
}
.item-value-right {
	width: 25%;
}
*/
</style>

<script type="text/javascript" id="script">
var popupList = {
	
	grid : null,
		
initScreen : function() {
		
		(function date() {
			
			var datepickerOptions = {
				showOn: "button",
				buttonImage: "${pageContext.request.contextPath}/assets/images/calendar.png",
				buttonImageOnly: true,
				buttonText: "Select date",
				defaultDate: "-1w",
				dateFormat: "yy-mm-dd",
				changeMonth: true,
				changeYear: true,
				numberOfMonths: 1,
			};
			
			var $inpWritngDeBegi = $('#inpWritngDeBegi');
			var $inpWritngDeEnd = $('#inpWritngDeEnd');
			
			datepickerOptions.onClose = function(selectedDate) {
				$inpWritngDeEnd.datepicker('option', 'minDate', selectedDate);
			};
			$inpWritngDeEnd.datepicker(datepickerOptions);
			
			datepickerOptions.onClose = function(selectedDate) {
				$inpWritngDeBegi.datepicker('option', 'maxDate', selectedDate);
			};
			$inpWritngDeBegi.datepicker(datepickerOptions);
			
			var $inpExpiryDeBegi = $('#inpExpiryDeBegi');
			var $inpExpiryDeEnd = $('#inpExpiryDeEnd');
			
			datepickerOptions.onClose = function(selectedDate) {
				$inpExpiryDeEnd.datepicker('option', 'minDate', selectedDate);
			};
			$inpExpiryDeEnd.datepicker(datepickerOptions);
			
			datepickerOptions.onClose = function(selectedDate) {
				$inpExpiryDeBegi.datepicker('option', 'maxDate', selectedDate);
			};
			$inpExpiryDeBegi.datepicker(datepickerOptions);
			
			
			var date = new Date();
			
			var yyyy = date.getFullYear();
			var mm = date.getMonth() + 1;
			var dd = date.getDate();
			
			mm = (mm < 10) ? '0' + mm : mm;
			dd = (dd < 10) ? '0' + dd : dd;
			
			var today = yyyy + '-' + mm + '-' + dd;
			
			$inpWritngDeEnd.val(today);
		})();
	},

    initGrid : function() {
        
        popupList.grid = $('#tblPopupList').dataTable({
            searching : false,
            lengthChange : false,
            ordering : false,
        });
    },
    
    handleEvent : function() {
        
    	$('#btnSearchingMail').on('click', function() {
    		
    		var $form = $('#frmSearchingPopup');
    		
    		var params = $form.serializeObject();
    		
			callAjax(null
		           , $form.prop('action')
		           , null
		           , $form.prop('method')
		           , 'json'
		           , params
		           , 'application/json'
		           , callback);
		    
		    function callback(data) {
		    	
		    	var rows = [];
		    	
		    	$(data).each(function(i, obj) {
		    		
		    		var row = [];
		    		row.push(obj.c_id);
		    		row.push(obj.c_title);
		    		row.push(obj.popupContent);
		    		row.push(obj.writngDe);
		    		row.push(obj.expiryDe);
		    		row.push(obj.applyFl);
		    		row.push(obj.joinState);
		    		row.push('<a href="javascript:void(0);" data-function="editUserInfo">Edit</a>&nbsp;<a href="javascript:void(0);" data-function="deleteUserInfo">Delete</a>');
		    		row.push('<input name="checkDelete" type="checkbox" />');
		    		
		    		rows.push(row);
		    	});
		    	
		    	popupList.grid.fnDestroy();
		    	
		    	popupList.grid = $('#tblPopupList').dataTable({
		            searching : false,
		            lengthChange : false,
		            ordering : false,
		            data : rows
		        });
		    	
		    	$('[name="checkDelete"]').parent().addClass('center');
		    }
    	});
        
		$('#btnAddPopup').on('click', function() {
			location.href = 'addPopupConfig.do';     	
        });
        
        $('#tblPopupList a').each(function() {
        	
        	var $a = $(this);
        	
        	$a.on('click', function() {
        		
        		var c_id = $a.parent().parent().data('c_id');
        		
        		var func = $a.data('function');
        		
        		if (func == 'editPopup') {
        			
        			var param = 'c_id=' + c_id;
        			popupList.editPopup(param);
        			
        		}
        		else if (func == 'deletePopup') {
            		
        			var params = [];
        			params.push({
        				c_id : c_id
        			});
        			
        			popupList.deletePopup(params);
            	}
    		});
        });
    },
	
    editPopup : function(params) {
    	callAjax(null
 	           , 'modifyPopupConfig.do'
 	           , { target : '#popupModification' , selector : 'section', $document : $(document) }
 	           , 'post'
 	           , 'html'
 	           , params
 	           , null
 	           , callback);
    	function callback(r){
    		$('#popupManage').hide();
            $('#popupModification').show();
            $('#popupModification').find('.container').removeClass('container');
            /*
            var $btnShowList = $('<button type="button" class="compact">목록보기</button>');
            
            $btnShowList.on('click', function() {
                $('#popupManage').show();
                $('#divUserInfoModification').hide();
                userList.getList(1);
            })
            */
            //$('#divUserInfoModification .divButtons').prepend($btnShowList);
    	}
    },
    deletePopup : function(params){
    	if (!confirm('삭제하시겠습니까?')) {
		    return false;
		}
    	
		callAjax(null
	           , 'delete.do'
	           , null
	           , 'post'
	           , 'json'
	           , params
	           , 'application/json'
	           , callback);
	    
	    function callback(r) {
	    	alert(r);
	    }
    },
    
    init : function() {
        this.initGrid();
        this.initScreen();
        this.handleEvent();
    }
};

$(document).ready(function() {
    popupList.init();
});
</script>
</head>
<body>
<section>
	<div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
	    <div id="popupManage" class="tablet-mobile alpha bm-remove last">
			<div id="search" class="one-whole boxed p-twenty">
				<form id="frmSearchingPopup" action="list.do" method="post">
					<div class="responsive-row">
						<label for="inpTitle">제목</label>
						<input id="inpTitle" name="inpTitle" type="text" />
					</div>
					<div class="responsive-row">
						<label for="inpManagerNm">작성자</label>
						<input id="inpManagerNm" name="inpManagerNm" type="text" />
					</div>
					<div class="responsive-row">
						<label for="inpApplyFl">적용여부</label>
						<select id="inpApplyFl" name="inpApplyFl" style="width: 100px !important">
							<option value="0">N</option>
							<option value="1">Y</option>
						</select>						
					</div>
					<div class="responsive-row">
						<label for="writngDe">작성일자</label>
						<input id="inpWritngDeBegi" name="inpWritngDeBegi" type="text" />&nbsp;~&nbsp;
						<input id="inpWritngDeEnd" name="inpWritngDeEnd" type="text" />
					</div>
					<div class="responsive-row">
						<label for="inpExpiryDe">유효기간</label>
						<input id="inpExpiryDeBegi" name="inpExpiryDeBegi" type="text" />&nbsp;~&nbsp;
						<input id="inpExpiryDeEnd" name="inpExpiryDeEnd" type="text" />
						<button id="btnSearchingPopup" type="button" class="compact">검색</button>
					</div>
				</form>
			</div>
	    
	    	<div id="divBtns">
	            <button id="btnAddPopup" type="button" class="compact">팝업 생성</button>
	        </div>
	    	
	        <table id="tblPopupList" class="display">
	            <thead>
	                <tr>
	                   <th>팝업ID</th>
	                   <th>제목</th>
	                   <th>작성자</th>
	                   <th>작성일자</th>
	                   <th>유효기간</th>
	                   <th>적용여부</th>
	                   <th></th>
	                </tr>
	            </thead>
	            <tbody>
	           	<c:forEach var="popup" items="${popupList}" varStatus="status">
	           		<tr data-c_id="${popup.c_id}">
	           			<td>${popup.c_title}</td>
	           			<td>${popup.popupContent}</td>
	           			<td>작성자<없음></td>
	           			<td>${popup.writngDe}</td>
	           			<td>${popup.expiryDe}</td>
	           			<td>
	           				<select name="applyFl" style="width:55px !important; height: 33px !important; margin-bottom: 0">
	           					<option value="1" <c:if test="${popup.applyFl == 1}">selected="selected"</c:if>>Y</option>
	           					<option value="0" <c:if test="${popup.applyFl == 0}">selected="selected"</c:if>>N</option>
	           				</select>
	           			</td>
	           			<td>
	           				<a href="javascript:void(0);" data-function="editPopup">Edit</a>
	           				<a href="javascript:void(0);" data-function="deletePopup">Delete</a>
	           			</td>
	           		</tr>
	            </c:forEach>
	            </tbody>
	        </table>
	    </div>
		<div id="popupModification"></div>
	</div>
</section>
</body>
</html>