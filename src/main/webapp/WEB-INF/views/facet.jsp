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
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript" >
/* $(document).ready(function() {
	$('.facet').click(function() {
		var filterQuerys ="${filterQuery}";
		alert(filterQuerys);
		var search="${search}";
		var facetFiled = $(this).attr("name");
		var facetValue = $(this).attr("value");
		var facetQuery="";
		var url = "http://localhost:8080/CustomsReporting/browse?searchTerm="+search+"&page=1&record=48&facetValue="+facetValue+"&facetField="+facetFiled;
		for (i = 0; i < filterQuerys.length; i++){
			var filterQuery = filterQuerys[i];
			if(2 < filterQuery.length){
				facetQuery = facetQuery+"&facetValue="+filterQuery.breadCrumbValue+"&facetField="+filterQuery.breadCrumbValue;
			}
		}
		if (0 !== facetQuery.length){
			url = url + facetQuery;
		}
		window.location.href = url;
	});
});  */
function facet(obj){
	var search="${search}";
	var sel = document.getElementById("display");
    var record = sel.options[sel.selectedIndex].value;
    var page = 1;
	var facetFiled = obj.name;
	var facetValue = obj.value;
	console.log("${breadCrumbLabel}");
/* 	var breadCrumbLabel = "${breadCrumbLabel}";
	var breadCrumbValue = "${breadCrumbValue}"; */
    var array1 = new Array();
    array1 = "${breadCrumbLabel}".split(",");
    var array2 = new Array();
    array2 = "${breadCrumbValue}".split(",");
	/* var breadCrumbValue = "${breadCrumbValue}"; */
	var facetQuery="";
	var url = "http://localhost:8080/CustomsReporting/browse?searchTerm="+search+"&page="+page+"&record="+record+"&facetValue="+facetValue+"&facetField="+facetFiled;
	for (i = 0; i < array1.length && i <array2.length ; i++){
		if(array2[i] !== "" && array1[i] !== ""){
			facetQuery = facetQuery+"&facetValue="+array2[i]+"&facetField="+array1[i];
		}
	}
	if (0 !== facetQuery.length){
		url = url + facetQuery;
	}
	window.location.href = url;
}
$(document).ready(function(){
	$("#display").on('change', function(){
	var search="${search}";
	var sel = document.getElementById("display");
    var record = sel.options[sel.selectedIndex].value;
    var page = 1;
	window.location.href = "http://localhost:8080/CustomsReporting/browse?searchTerm="+search+"&page="+page+"&record="+record;
	});
}); 
$(document).ready(function(){
	var slectedPage = "${selectedPageView}";
	var sel = document.getElementById("display");
	for (var i = 0; i < sel.length; i++) {
        var selValue =sel.options[i].value;
       if(selValue == slectedPage){
    	   $('#display').val(selValue);
       }
    }
});
</script>
</head>
<body>
<div class="pageSelect">
<span>Display:</span> 
<select id ="display">
<c:forEach items="${pageViews}" var="pageView">
<option value="${pageView.pageViewValue.id}"><c:out value="${pageView.pageViewLabel}"/></option>
</c:forEach>
 </select>
 </div>
<c:if test="${begin > 5}">
<a href="http://localhost:8080/CustomsReporting/browse?searchTerm=${search}&page=${begin-1}&record=${selectedPageView}"><c:out value="<"/></a>
</c:if>
<c:forEach var="i" begin="${begin}" end="${end}">
<a href="http://localhost:8080/CustomsReporting/browse?searchTerm=${search}&page=${i}&record=${selectedPageView}"><c:out value="${i}"/></a>
</c:forEach>
<c:if test="${(selectedPageView * end ) < documentNumFound}">
<a href="http://localhost:8080/CustomsReporting/browse?searchTerm=${search}&page=${end+1}&record=${selectedPageView}"><c:out value=">"/></a>
</c:if>
<h1>Facet</h1>
<div>
<ul>
 <c:forEach var="facet" items="${facets}">
<li>  <c:out value="${facet.facetName}"/></li>
     <c:forEach var="facetValue" items="${facet.facetValues}"> 
      <li><input class="facet" type="checkbox" name="${facet.facetName}" value="${facetValue.facetLabel}" onclick="facet(this);"><c:out value="${facetValue.facetLabel}"/> (
     <c:out value="${facetValue.facetCount}"/>)</li>
     </c:forEach>
</c:forEach>
</ul>
</div>
</body>
</html>