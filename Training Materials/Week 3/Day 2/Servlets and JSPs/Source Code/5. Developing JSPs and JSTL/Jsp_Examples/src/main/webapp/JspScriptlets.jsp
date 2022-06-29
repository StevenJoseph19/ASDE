<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.Locale"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demonstrate the use of JSP Scriptlets</title>
</head>
<body>
	<h1>
		<%
		// 	Set content type
		// 	response.setContentType("text/plain");

		// 	 Get QueryString value
		String name = request.getParameter("name");

		if (name == null) {
			name = "";

		}

		// Determine language to use
		Locale locale = request.getLocale();

		String languageTag = locale.toLanguageTag().substring(0, 2);

		// Determine Greeting Language

		String greeting;

		switch (languageTag) {
		case "fr": // French
			greeting = "Bonjour ";
			break;

		case "de": // German
			greeting = "Guten Tag ";
			break;

		default: // anything else
			greeting = "Hello ";
			break;
		}

		// 	Write greeting to name
		out.print(greeting + " " + name);

		// 	response.setHeader("Content-Language", languageTag);
		%>
	</h1>
</body>
</html>