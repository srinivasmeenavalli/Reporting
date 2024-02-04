<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
 
<html>
    <head>
        <title>My first example using Spring 3 MVC</title>
    </head>
    <body>
    <h1>Record</h1>
    <ul>
    <c:forEach var="record" items="${records}">
      <li>  <c:out value="${record.sendingCountry}"/> </li>
      <li>   <c:out value="${record.sourceID}"/> </li>
      <li>  <c:out value="${record.iChgCtrl}"/> </li>
      <li> <c:out value="${record.status}"/> </li>
      <li>  <c:out value="${record.billOfLadingNumber}"/></li>
      <li>  <c:out value="${record.errorCode}"/></li>
      <li>  <c:out value="${record.errorDescription}"/></li>
      <li>  <c:out value="${record.responseType}"/></li>
   <li>.........................................................................................</li>
</c:forEach>
</ul>
<h1>Facet</h1>
<div>
<ul>
 <c:forEach var="facet" items="${facets}">
<li>  <c:out value="${facet.facetName}"/></li>
     <c:forEach var="facetValue" items="${facet.facetValues}"> 
      <li><div> <c:out value="${facetValue.facetLabel}"/> (
     <c:out value="${facetValue.facetCount}"/>)</div></li>
     <li>.......................................................................................</li>
     </c:forEach>
</c:forEach>
</ul>
</div>
    </body>
</html>