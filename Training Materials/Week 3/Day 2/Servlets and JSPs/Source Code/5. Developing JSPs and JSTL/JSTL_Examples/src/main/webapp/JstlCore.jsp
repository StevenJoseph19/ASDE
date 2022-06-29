<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demonstrates the use of JSTL Core Tags</title>
</head>
<body>
	<h1>
		<c:set var="languageCode"
			value="${(header['accept-language'].split('-'))[0]}" />
<%-- 					<c:out value="${languageCode}"></c:out> --%>

		<c:choose>

			<c:when test="${languageCode == 'fr'}">
				Bonjour	
			</c:when>
		
		<c:when test="${languageCode == 'de'}">
				Guten Tag	
		</c:when>
		
		<c:otherwise>
				Hello
		</c:otherwise>

		</c:choose>

		${param.name}
		
	</h1>

</body>
</html>