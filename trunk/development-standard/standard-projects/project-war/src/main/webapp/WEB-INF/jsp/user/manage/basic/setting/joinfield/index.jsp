<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

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

#divBottom {
    text-align: right;
    margin-top: 10px;
}
#divBottom button {
    min-width: 71px;
    min-height: 37px;
}
</style>

<script type="text/javascript">
var joinField = {

    initGrid : function() {
        
        var joinFields = JSON.parse('${joinFields}');
        
        var $tblJoinFields = $('#tblJoinFields');
        var $tbody = $tblJoinFields.find('tbody');
        
        $.each(joinFields, function(i, joinField) {
            
            var row = '<tr id="' + joinField.c_id + '">';
            row += '<td>' + joinField.c_title + '</td>';
            row += '<td class="center"><input type="checkbox" value="' + joinField.useFl + '" /></td>';
            row += '<td class="center"><input type="checkbox" value="' + joinField.infoOpenFl + '" /></td>';
            if (joinField.esseInputFl == '1') {
                row += '<td class="center"><input type="radio" checked="checked" />필수 <input type="radio" />선택</td>';
            } else {
                row += '<td class="center"><input type="radio" />필수 <input type="radio" checked="checked" />선택</td>';
            }
            row += '</tr>';
            
            $tbody.append(row);
        });
        
        $('#tblJoinFields').dataTable({
            searching : false,
            lengthChange : false,
            paging : false,
            ordering : false,
            info : false
        });
    },
        
    handleEvent : function() {
        
        // TODO 류강하 : 공통 js로 옮겨야 함.
        $('input[type="checkbox"]').each(function() {
            
            this.checked = Number(this.value);
        });
        $('input[type="checkbox"]').on('click', function() {
            
            var $checkbox = $(this);
            
            $checkbox.val( $checkbox.prop('checked') ? 1 : 0 );
        });
        
        var form = 'frmJoinField';
        var $form = $('#' + form);
        
        $form.on('submit', function() {
            
            if (!confirm('저장하시겠습니까?')) {
                return false;
            }
            
            callAjax(form
                   , $form.prop('action')
                   , null
                   , $form.prop('method')
                   , 'json'
                   , null
                   , callback);
            
            function callback(r) {
            }
            
            return false;
        });
    },
        
    init : function() {
        this.initGrid();
        this.handleEvent();
    }
};

$(document).ready(function() {
    joinField.init();
});
</script>

<section>
    <form id="frmJoinField" action="save.do" method="post">
     <div class="three-quarter last boxed p-twenty clearfix" data-anim-type="fade-in" data-anim-delay="0">
         <div id="samDiv" class="tablet-mobile alpha bm-remove last">
             <table id="tblJoinFields" class="display">
                <thead>
                    <tr>
                        <th>필드명</th>
                        <th>사용여부</th>
                        <th>정보공개여부</th>
                        <th>필수/선택입력여부</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
             </table>
             
<!--          <div id="jstreeTable_wrapper" class="dataTables_wrapper no-footer"> -->
<!--              <table id="jstreeTable" class="display responsive nowrap" cellspacing="0" width="100%"> -->
<!--                  <thead> -->
<!--                      <tr> -->
<!--                          <th>c_id</th> -->
<!--                          <th>c_parent_id</th> -->
<!--                          <th class="not-mobile">c_position</th> -->
<!--                          <th class="not-tablet">c_left</th> -->
<!--                          <th>c_right</th> -->
<!--                          <th>c_level</th> -->
<!--                          <th>c_title</th> -->
<!--                      </tr> -->
<!--                  </thead> -->
              
            <div id="divBottom">
                <button id="btnSave" type="submit">저장하기</button>
            </div>
         </div>
     </div>
    </form>
</section>