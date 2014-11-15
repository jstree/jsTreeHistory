<%--
  Class Name : EgovIncTopnav.jsp
  Description : 상단메뉴(include)
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2011.08.31   JJY       경량환경 버전 생성
 
    author   : 실행환경개발팀 JJY
    since    : 2011.08.31 
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="egovframework.com.cmm.LoginVO" %>

<script type="text/javascript">
    function fn_main_headPageMove(menuNo, url){
	    document.selectOne.menuNo.value=menuNo;
	    if(url.indexOf(".do") > -1){
	    	document.selectOne.link.value="";
	        document.selectOne.action = "<c:url value='/' />"+url;
	    }else{
	    	document.selectOne.link.value=url;
		    document.selectOne.action = "<c:url value='/EgovPageLink.do'/>";
	    }
	    //alert(document.selectOne.action);
	    document.selectOne.submit();
    }
    function fn_main_headPageAction(menuNo, url){
        document.selectOne.menuNo.value=menuNo;
        document.selectOne.link.value="";
        document.selectOne.action = "<c:url value='/' />"+url;
        document.selectOne.method = "post";
        //alert(document.selectOne.action);
        document.selectOne.submit();
    }
</script>
<!-- topmenu start -->
<form name="selectOne" action="#LINK">
<input name="menuNo" type="hidden" />
<input name="link" type="hidden" />
</form>
<ul>
<c:set var = "loginVo" value = "${sessionScope.LoginVO }" />
<c:forEach var="result" items="${ menuList}" varStatus="status">
	<c:choose>
		<c:when  test = "${result.c_id == '7428' and loginVo ne null}">
			<li><a href="#LINK" onclick="javascript:fn_main_headPageMove('${result.c_id}','${result.url }')">${result.c_title}</a></li>
		</c:when>
		<c:when  test = "${result.c_id != '7428'}">
			<li><a href="#LINK" onclick="javascript:fn_main_headPageMove('${result.c_id}','${result.url }')">${result.c_title}</a></li>
		</c:when>
	</c:choose>
</c:forEach> 
</ul>

<!-- //topmenu end -->