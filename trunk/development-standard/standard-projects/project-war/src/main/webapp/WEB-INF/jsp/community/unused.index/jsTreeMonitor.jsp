<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" autoFlush="true"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<!DOCTYPE html> 
<!--[if lt IE 7 ]> <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie6 older"> <![endif]-->
<!--[if IE 7 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie7 older"> <![endif]-->
<!--[if IE 8 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie8"> <![endif]-->
<!--[if IE 9 ]>    <html xmlns="http://www.w3.org/1999/xhtml" lang="ko-KR" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="ko-KR">
<!--<![endif]-->
<head>
<jsp:include page="/WEB-INF/jsp/community/common/script.inc.jsp"></jsp:include>
<title><decorator:title default="본 페이지는 사이트메쉬 템플릿 엔진을 사용하였습니다." /></title>

<!-- CSS Setting -->
<customTags:nasCSS theRestOfFileName="/scriptPool/jQueryPlugIns/jquery.jqGrid-4.4.3/css/ui.jqgrid.css"></customTags:nasCSS>

<customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/jquery.jqGrid-4.4.3/src/i18n/grid.locale-en.js"></customTags:nasScript>
<customTags:nasScript theRestOfFileName="/scriptPool/jQueryPlugIns/jquery.jqGrid-4.4.3/js/jquery.jqGrid.min.js"></customTags:nasScript>

    <script type="text/javascript">

        function getGrid() {
            var jqDataUrl = '/war/struts/www313cokr/index/menu/jstreeMonitor/getJstreeMonitor.action';
            // Set up the jquery grid
            $("#jqTable").jqGrid({
                // Ajax related configurations
                url        : jqDataUrl,
                datatype   : "json",
                mtype: "POST",
                gridModel  : "gridModel",
                // Specify the column names
                colNames   : ["c_id", "c_parentid", "c_position", "c_left", "c_right", "c_level", "c_title", "c_type"],
                prmNames: {page:"_page",rows:"_rows", sort: "sidx",order: "sord", search:"_search", nd:"nd", id:"id",oper:"oper",editoper:"edit",addoper:"add",deloper:"del", subgridid:"id", npage: null, totalrows:"totalrows"},
                // Configure the columns
                colModel   : [
                    { name: "c_id", index: "c_id", width: 100, align: "left" },
                    { name: "c_parentid", index: "c_parentid", width: 100, align: "left" },
                    { name: "c_position", index: "c_position", width: 100, align: "left" },
                    { name: "c_left", index: "c_left", width: 100, align: "left" },
                    { name: "c_right", index: "c_right", width: 100, align: "left" },
                    { name: "c_level", index: "c_level", width: 100, align: "left" },
                    { name: "c_title", index: "c_title", width: 100, align: "left" },
                    { name: "c_type", index: "c_type", width: 100, align: "left" }
                    
                ],
                // Grid total width and height
                width      : 550,
                height     : 400,
                // Paging
                toppager   : true,
                pager      : $("#jqTablePager"),
                rowNum     : 100,
                rowList    : [100, 200, 300],
                viewrecords: true, // Specify if "total number of records" is displayed
                // Default sorting
                sortname   : "Id",
                sortorder  : "asc",
                
                onSelectRow: function(ids) {
                	alert(ids);
                },
                
                // Grid caption
                caption    : "JstreeMonitor - T_COMPREHENSIVETREE_Viewer"
            }).navGrid("#jqTablePager",
                    { refresh: true, add: false, edit: false, del: false },
                    {}, // settings for edit
                    {}, // settings for add
                    {}, // settings for delete
                    {sopt: ["cn"]} // Search options. Some options can be set on column level
            );

        }
    </script>
</head>
<body onload="getGrid();">
<div>
    <table id="jqTable" class="scroll"></table>
    <div id="jqTablePager"></div>
</div>
</body>
</html>