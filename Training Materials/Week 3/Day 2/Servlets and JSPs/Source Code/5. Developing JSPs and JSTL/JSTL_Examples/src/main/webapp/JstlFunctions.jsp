<!-- Demonstrates the use of JSTL Functions -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<HTML>
  <BODY>
    <H1>

					<c:set var="languageCode" value="${header['accept-language']}"/>  

					<c:choose>

						<c:when test="${fn:startsWith(languageCode,'fr')}">
										Bonjour
						</c:when>	
						<c:when test="${fn:startsWith(languageCode, 'de')}">
										Guten Tag
						</c:when>	
						<c:otherwise>
										Hello
						</c:otherwise>
		
					</c:choose> 
		
		  ${fn:toUpperCase(param.name)}
    </H1>
  </BODY>
</HTML>
      