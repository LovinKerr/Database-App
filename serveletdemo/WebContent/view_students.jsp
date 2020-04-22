
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>

	<c:forEach var="tempStudent" items="${student_list}">
		${tempStudent} <br/> 
	
	</c:forEach>

</body>

</html>