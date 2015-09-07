<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko" class="js">
<head>
<title>${pageName}</title>
<style type="text/css" id="style">
#divUserManage .center {
    text-align: center;
}
#divUserManage .right {
    text-align: right;
}
#divUserManage .chk {
    height: 13px !important;
}
#divUserManage select {
	height: 100%;
}
#divUserManage input[type="text"] {
	width: 192px !important;
    height: 30px !important;
    display: inline !important;
}
#divUserManage select {
	display: inline !important;
}
#divUserManage #divBtns {
    text-align: right;
    margin-top: 10px;
}
#divUserManage .compact {
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
#divUserManage #divPagination {
	text-align: center;
	margin-top: 10px;
	font-size: 1.1em;
}
#divUserManage .currentPage {
	font-weight: bold !important;
}
</style>

<script type="text/javascript" id="script">
var userList = {
	
	currentPage : null,
		
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
			
			var $inpJoinDeBegi = $('#inpJoinDeBegi');
			var $inpJoinDeEnd = $('#inpJoinDeEnd');
			var $inpLoginDeBegi = $('#inpLoginDeBegi');
			var $inpLoginDeEnd = $('#inpLoginDeEnd');
			
			datepickerOptions.onClose = function(selectedDate) {
				$inpJoinDeEnd.datepicker('option', 'minDate', selectedDate);
			};
			
			$inpJoinDeBegi.datepicker(datepickerOptions);
			
			datepickerOptions.onClose = function(selectedDate) {
				$inpJoinDeBegi.datepicker('option', 'maxDate', selectedDate);
			};
			
			$inpJoinDeEnd.datepicker(datepickerOptions);
			
			datepickerOptions.onClose = function(selectedDate) {
				$inpLoginDeEnd.datepicker('option', 'minDate', selectedDate);
			};
			
			$inpLoginDeBegi.datepicker(datepickerOptions);
			
			datepickerOptions.onClose = function(selectedDate) {
				$inpLoginDeBegi.datepicker('option', 'maxDate', selectedDate);
			};
			
			$inpLoginDeEnd.datepicker(datepickerOptions);

			var date = new Date();
			
			var yyyy = date.getFullYear();
			var mm = date.getMonth() + 1;
			var dd = date.getDate();
			
			mm = (mm < 10) ? '0' + mm : mm;
			dd = (dd < 10) ? '0' + dd : dd;
			
			var today = yyyy + '-' + mm + '-' + dd;
			
			$inpJoinDeEnd.val(today);
		})();
	},
		
    initGrid : function() {
        
    	userList.grid = $('#tblUserList').dataTable(userList.getGridOptions());
    },
    
    getGridOptions : function() {
        return {
            searching : false,
            lengthChange : false,
            paging : false,
            ordering : false,
            info : false,
            columnDefs : [
                {targets : 2, className : 'center'},
                {targets : 3, className : 'center'},
                {targets : 5, className : 'center'},
                {targets : 7, className : 'center'}
            ]
        };
    },
    
    handleEvent : function() {
        
    	$('#btnSearchingUser').on('click', function() {
    		
    		userList.getList(1);
    	});
    	
        $('#btnDeleteUserInfo').on('click', function() {
			
        	var $checkboxesForDeleting = $('#tblUserList :checkbox[name="checkDelete"]:checked');
        	
        	if ( $checkboxesForDeleting.length == 0 ) {
        		alert('삭제할 회원 정보를 선택해주세요.');
        		return false;
        	}
        	
        	var params = [];
        	
        	$checkboxesForDeleting.each(function() {
        		
        		params.push({
    				c_id : $(this).data('param')
    			});
        	});

        	userList.deleteUserInfo(params)
        });
        
		$('#btnAddUserInfo').on('click', function() {
        	
			callAjax(null
                   , '${pageContext.request.contextPath}/user/join/index.do'
                   , { target : '#divUserAddition', selector : 'section', $document : $(document) }
                   , 'post'
                   , 'html'
                   , null
                   , null
                   , callback);
			
		    function callback(r) {
		    	
		        $('#divUserManage').hide();
		        $('#divUserAddition').show();
		        $('#divUserAddition').find('.container').removeClass('container');
		        $('#divUserAddition #btnJoin').text('저장하기');
		        
		        var $btnShowList = $('<button type="button" class="compact">목록보기</button>');
		        
		        $btnShowList.on('click', function() {
		            $('#divUserManage').show();
	                $('#divUserAddition').hide();
	                userList.getList(1);
		        })
		        
		        $('#divUserAddition .divButtons').prepend($btnShowList);
		    }
        });
        
        $('#checkAll').on('change', function() {
        	
        	var checkAll = this;
        	
       		$('#tblUserList :checkbox').not('#checkAll').each(function() {
       			
       			if (checkAll.checked) {
       				this.checked = true;
       			} else {
       				this.checked = false;
       			}
       		});
        });

        $(document).on('click', '#tblUserList a', function() {
        	
        	var $a = $(this);
        	
        	var func = $a.data('function');
    		var c_id = $a.data('param');
    		
    		if (func == 'editUserInfo') {
    			
    			var param = 'c_id=' + c_id;
    			
    			userList.editUserInfo(param);
    		}
    		else if (func == 'deleteUserInfo') {
        		
    			var params = [];
    			params.push({
    				c_id : c_id
    			});
    			
    			userList.deleteUserInfo(params);
        	}
        });
        
        $(document).on('change', '#tblUserList select[name="joinApprovalFl"]', function() {
            
            var $select = $(this);
            
            var param = {
                c_id : $select.data('param')
            };
            
            userList.approveJoining(param, function(r) {
                
                console.log(r);
                
                var $td = $select.parent();
                $td.empty();
                $td.text('Y');
            });
        });
    },
	
    editUserInfo : function(param) {
        
        callAjax(null
               , '${pageContext.request.contextPath}/user/info/index.do'
               , { target : '#divUserInfoModification', selector : 'section', $document : $(document) }
               , 'post'
               , 'html'
               , param
               , null
               , callback);
         
         function callback(r) {
             
             $('#divUserManage').hide();
             $('#divUserInfoModification').show();
             $('#divUserInfoModification').find('.container').removeClass('container');
             
             var $btnShowList = $('<button type="button" class="compact">목록보기</button>');
             
             $btnShowList.on('click', function() {
                 $('#divUserManage').show();
                 $('#divUserInfoModification').hide();
                 userList.getList(1);
             })
             
             $('#divUserInfoModification .divButtons').prepend($btnShowList);
         }
    },
    
    deleteUserInfo : function(params) {
    	
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
	    	
	    	userList.getList(userList.currentPage);
	    }
    },
    
    getList : function(pageNo) {
    	
    	var $form = $('#formSearchingUser');
		
		var params = $form.serializeObject();
		params.page = pageNo;
		params.jsFunction = 'userList.getList';
		
		callAjax(null
	           , $form.prop('action')
	           , null
	           , $form.prop('method')
	           , 'json'
	           , params
	           , 'application/json'
	           , callback);
	    
	    function callback(data) {
	    	
	    	(function renderGrid() {
		    	
	    		var rows = [];
		    	
		    	$(data.userList).each(function(i, user) {
		    		
		    		var row = [];
		    		row.push(user.email);
		    		row.push(user.c_title);
		    		row.push(user.userGrade);
		    		row.push(user.lastLoginDe || '');
		    		row.push(user.joinDe);
		    		if (user.joinStateCd == 4) {
		    		    row.push('Y');
		    		}
		    		else {
		    		    row.push('<select name="joinApprovalFl" data-param="' + user.c_id + '" style="width:55px !important; height: 33px !important; margin-bottom: 0">'
	                           + '    <option value="1">Y</option>'
	                           + '    <option value="0" selected="selected">N</option>'
	                           + '</select>');
		    		}
		    		row.push('<a href="javascript:void(0);" data-function="editUserInfo" data-param="' + user.c_id + '">Edit</a>&nbsp;'
		    		       + '<a href="javascript:void(0);" data-function="deleteUserInfo" data-param="' + user.c_id + '">Delete</a>');
		    		row.push('<input name="checkDelete" type="checkbox" data-param="' + user.c_id + '" />');
		    		
		    		rows.push(row);
		    	});
		    	
		    	userList.grid.fnDestroy();
		    	
		    	var gridOptions = userList.getGridOptions();
		    	gridOptions.data = rows;
		    	
		    	userList.grid.dataTable(gridOptions);
		    })();
	    	
	    	(function renderPageList() {
				
		    	$('#divPagination').html(data.pageList);
		    })();
	    	
	    	userList.currentPage = pageNo;
	    }
    },
    
    approveJoining : function(param, callback) {
        
        callAjax(null
                , 'approveJoining.do'
                , null
                , 'post'
                , 'json'
                , param
                , 'application/json'
                , callback);
    },
    
    init : function() {
    	this.initScreen();
        this.initGrid();
        this.handleEvent();
        
        userList.getList(1);
    }
};

$(document).ready(function() {
    userList.init();
});
</script>
</head>

<body>
<section>
	<div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
	    <div id="divUserManage" class="tablet-mobile alpha bm-remove last">
			<div id="search" class="one-whole boxed p-twenty">
				<form id="formSearchingUser" action="list.do" method="post">
					<div class="responsive-row">
						<label for="inpEmail">이메일</label>
						<input id="inpEmail" name="email" type="text" />
						<label for="comboUserGrade">회원그룹</label>
						<select id="comboUserGrade" name="userGradeCd" style="width: 100px !important">
							<option value="0">전체</option>
						<c:forEach var="userGrade" items="${userGrades}" varStatus="status">
							<option value="${userGrade.c_id}">${userGrade.c_title}</option>
		               </c:forEach>
						</select>
					</div>
					<div class="responsive-row">
						<label for="inpNickname">닉네임</label>
						<input id="inpNickname" name="c_title" type="text" />
						<label for="inpJoinDeBegi">가입일</label>
						<input id="inpJoinDeBegi" name="joinDeBegi" type="text" style="width: 90px !important" />&nbsp;~&nbsp;
						<input id="inpJoinDeEnd" name="joinDeEnd" type="text" style="width: 90px !important" />
					</div>
					<div class="responsive-row">
						<label for="comboJoinApprovalFl">승인여부</label>
						<select id="comboJoinApprovalFl" name="joinApprovalFl" style="width: 70px !important">
							<option value="A">ALL</option>
							<option value="1">Y</option>
							<option value="0">N</option>
						</select>
						<label for="inpLoginDeBegi">최근로그인</label>
						<input id="inpLoginDeBegi" name="loginDeBegi" type="text" style="width: 90px !important" />&nbsp;~&nbsp;
						<input id="inpLoginDeEnd" name="loginDeEnd" type="text" style="width: 90px !important" />
						<button id="btnSearchingUser" type="button" class="compact">검색</button>
					</div>
				</form>
			</div>
	    
	    	<div id="divBtns">
	            <button id="btnDeleteUserInfo" type="button" class="compact">회원삭제</button>
	            <button id="btnAddUserInfo" type="button" class="compact">회원추가</button>
	        </div>
	    	
	        <table id="tblUserList" class="display">
	            <thead>
	                <tr>
	                   <th>이메일</th>
	                   <th>닉네임</th>
	                   <th>회원그룹</th>
	                   <th>최근로그인</th>
	                   <th>가입일</th>
	                   <th>승인여부</th>
	                   <th></th>
	                   <th><input id="checkAll" type="checkbox" /></th>
	                </tr>
	            </thead>
	        </table>
	        <div id="divPagination"></div>
	    </div>
	    <div id="divUserAddition"></div>
	    <div id="divUserInfoModification"></div>
	</div>
</section>
</body>
</html>