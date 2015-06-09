<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
.center {
    text-align: center;
}
.right {
    text-align: right;
}
.chk {
    height: 13px !important;
}
select {
	height: 100%;
}
input[type="text"] {
	width: 192px !important;
    height: 30px !important;
    display: inline !important;
}
select {
	width: 130px !important;
	display: inline !important;
}
#divBtns {
    text-align: right;
    margin-top: 10px;
}
.compact {
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

<script type="text/javascript">
var userList = {
	
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
        
        $('#tblUserList').dataTable({
            searching : false,
            lengthChange : false,
            ordering : false,
        });
    },
    
    handleEvent : function() {
        
    	$('#btnSearchingUser').on('click', function() {
    		
//     		frmSearchingUser

			
    	});
    	
        $('#btnDeleteUserInfo').on('click', function() {
			
        	var $checkboxesForDeleting = $(':checkbox[name="checkDelete"]:checked');
        	
        	if ( $checkboxesForDeleting.length == 0 ) {
        		alert('삭제할 회원 정보를 선택해주세요.');
        		return false;
        	}
        	
        	var params = [];
        	
        	$checkboxesForDeleting.each(function() {
        		
        		params.push({
    				c_id : $(this).parent().parent().data('c_id')
    			});
        	});

        	userList.deleteUserInfo(params)
        });
        
		$('#btnAddUserInfo').on('click', function() {
        	
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
        
        $('#tblUserList a').each(function() {
        	
        	var $a = $(this);
        	
        	$a.on('click', function() {
        		
        		var c_id = $a.parent().parent().data('c_id');
        		
        		var func = $a.data('function');
        		
        		if (func == 'editUserInfo') {
        			
        			var params = 'c_id=' + c_id;
        		}
        		else if (func == 'deleteUserInfo') {
            		
        			var params = [];
        			params.push({
        				c_id : c_id
        			});
        			
        			userList.deleteUserInfo(params);
            	}
    		});
        });
    },
	
    editUserInfo : function(params) {
    	
    	
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
	    	
	    	$('#tblUserList tr').each(function(i, tr) {
	    		
	    		var $tr = $(tr);
	    		
	    		$(params).each(function(j, param) {
					
	    			if ( $tr.data('c_id') == param.c_id ) {
						
	    				$tr.remove();
	    			}
	    		});
	    	});
	    }
    },
    
    init : function() {
    	this.initScreen();
        this.initGrid();
        this.handleEvent();
    }
};

$(document).ready(function() {
    userList.init();
});
</script>

<section>
	<div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
	    <div id="samDiv" class="tablet-mobile alpha bm-remove last">
			<div id="search" class="one-whole boxed p-twenty">
				<form id="frmSearchingUser" action="list.do" method="post">
					<div class="responsive-row">
						<label for="inpEmail">이메일</label>
						<input id="inpEmail" name="email" type="text" />
						<label for="comboUserGrade">회원그룹</label>
						<select id="comboUserGrade" name="userGrade">
							<option>전체</option>
						<c:forEach var="userGrade" items="${userGrades}" varStatus="status">
							<option value="${userGrade.c_id}">${userGrade.c_title}</option>
		               </c:forEach>
						</select>
					</div>
					<div class="responsive-row">
						<label for="inpNickname">닉네임</label>
						<input id="inpNickname" name="c_id" type="text" />
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
	            <tbody>
	           	<c:forEach var="user" items="${userList}" varStatus="status">
	           		<tr data-c_id="${user.c_id}">
	           			<td>${user.email}</td>
	           			<td>${user.c_title}</td>
	           			<td>${user.userGrade}</td>
	           			<td>${user.loginDt}</td>
	           			<td>${user.joinDt}</td>
	           			<td>${user.joinStateCd}</td>
	           			<td>
	           				<a href="javascript:void(0);" data-function="editUserInfo">Edit</a>
	           				<a href="javascript:void(0);" data-function="deleteUserInfo">Delete</a>
	           			</td>
	           			<td class="center"><input name="checkDelete" type="checkbox" /></td>
	           		</tr>
	            </c:forEach>
	            </tbody>
	        </table>
	    </div>
	</div>
</section>