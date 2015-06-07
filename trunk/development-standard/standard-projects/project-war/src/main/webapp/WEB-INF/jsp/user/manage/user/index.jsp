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
.rdo {
    width: 13px !important;
    height: 13px !important;
}
input[type="text"] {
    height: 30px !important;
}

#divBtns {
    text-align: right;
    margin-top: 10px;
}
#divBtns button {
    min-width: 71px;
    min-height: 37px;
}
</style>

<script type="text/javascript">
var userList = {
	
	grid : null,
		
    initGrid : function() {
        
        userList.grid = $('#tblUserList').dataTable({
            searching : false,
            lengthChange : false,
            ordering : false,
        });
    },
    
    handleEvent : function() {
        
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
// 	    	console.log(userList.grid);
	    	userList.grid.fnDraw();
	    }
    },
    
    init : function() {
        this.initGrid();
        this.handleEvent();
    }
};

$(document).ready(function() {
    userList.init();
});
</script>

<section>
    <form id="frmJoinField" action="save.do" method="post">
        <div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
            <div id="samDiv" class="tablet-mobile alpha bm-remove last">
            	<div id="divBtns">
                    <button id="btnDeleteUserInfo" type="button">회원삭제</button>
                    <button id="btnAddUserInfo" type="button">회원추가</button>
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
    </form>
</section>