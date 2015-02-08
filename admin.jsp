<%@page import="postG.test.GetJson"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String name =request.getParameter("userName");
GetJson getS = new GetJson();
String x =getS.GetJsonByID(3);

%>
<h1> welcome Admin  the json is <%=x %></h1>
</body>
</html>