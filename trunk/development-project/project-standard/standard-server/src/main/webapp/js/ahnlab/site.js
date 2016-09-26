//공통 페이지 네비게이션 
function pageForm(curPage){
    /*
	$("#curPage").attr("value", curPage);
    $("#form").attr("target", "_self");
    $("#form").submit();
    */
    location.href = "?curPage=" + curPage;
}