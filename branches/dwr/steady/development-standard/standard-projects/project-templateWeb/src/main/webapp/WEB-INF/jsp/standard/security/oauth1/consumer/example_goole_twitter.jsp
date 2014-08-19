<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <link href="<c:url value="/main.css"/>" rel="stylesheet" type="text/css"/>
  <title>tonr</title>
</head>
<body>
<div id="container">

    <ul id="mainlinks">
      <li><a href="<c:url value="/oauth1/google/picasa.do"/>" class="selected">picasa pics</a></li>
      <li><a href="<c:url value="/oauth1/twitter/userinfo.do"/>" >트위터 정보</a></li>
    </ul>

  <div id="content">
    <h1>구글 Picasa Photos 정보 , 트위터 정보</h1>
    <h2>구글 이미지가 등록되어 있지 않을 경우 : https://picasaweb.google.com 해당 사이트에 들어가 업로드 하면 확인 가능 함</h2>
    <ul id="picturelist">
      <c:forEach var="photoUrl" items="${photoUrls}">
        <li><img src="<c:out value="${photoUrl}"/>"/></li>
        <li><c:out value="${photoUrl}"/></li>
      </c:forEach>
    </ul>
         
         트위터 :
    ${twitterInfo}
  </div>
</div>
</body>
</html>