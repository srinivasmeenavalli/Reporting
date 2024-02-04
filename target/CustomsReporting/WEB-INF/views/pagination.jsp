<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
<c:if test="${begin > 5}">
<a href="#" onclick="change('6')"><c:out value="<"/></a>
</c:if>
<c:forEach var="i" begin="${begin}" end="${end}">
<a href="#" onclick="change('2')"><c:out value="${i}"/></a>
</c:forEach>
<c:if test="${(selectedPageView * end ) < documentNumFound}">
<a href="#" onclick="change('6')"><c:out value=">"/></a>
</c:if>
</body>
</html>