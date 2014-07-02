<%@ page language="java" contentType="application/vnd.ms-excel"%>
<html>
	<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"/></head>
<% 
	String name = request.getParameter("filename");
	response.setHeader("Content-Disposition", "attachment; filename=\""+name+".xls\"");
	response.setHeader("Content-Disposition", "JSP Generated Data");
%>
	<body>
<%
	out.println(request.getParameter("postData"));
%>
	</body>
</html>