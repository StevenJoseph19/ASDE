<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="javawebapps.HelloHelper"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demonstrate the use of JSP with Java Beans</title>
</head>
<body>
	<h1>
		<jsp:useBean id="helper" class="javawebapps.HelloHelper" scope="application" ></jsp:useBean>
		<%= helper.getGreeting(request.getLocale())   %> ${param.name }
	</h1>
</body>
</html>