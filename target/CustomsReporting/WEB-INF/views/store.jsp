<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Customs Integrations Platform - Reporting</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript">
	function facet(obj) {
		var search = "${search}";
		var page = 1;
		var record = 12;
		var sel = document.getElementById("display");
		if (sel != null) {
			record = sel.options[sel.selectedIndex].value;
		}
		var facetFiled = obj.name;
		var facetValue = obj.value;
		var array1 = new Array();
		array1 = "${breadCrumbLabel}".split("#");
		var array2 = new Array();
		array2 = "${breadCrumbValue}".split("#");
		var facetQuery = "";
		var hostName = createHostName();
		var url = hostName + "/CustomsReporting/browse?&page=" + page + "&record="
				+ record + "&facetValue=" + facetValue + "&facetField="
				+ facetFiled;
		if (search.length > 0) {
			url = url + "&searchTerm=" + search;
		}
		var sort = document.getElementById("sort");
		if (sort != null) {
			var sortValue = sort.options[sort.selectedIndex].value;
			url = url + "&sort=" + sortValue;
		}
		for (i = 0; i < array1.length && i < array2.length; i++) {
			if (array2[i] !== "" && array1[i] !== "") {
				facetQuery = facetQuery + "&facetValue=" + array2[i]
						+ "&facetField=" + array1[i];
			}
		}
		if (0 !== facetQuery.length) {
			url = url + facetQuery;
		}
		window.location.href = url;
	}
	$(document)
			.ready(
					function() {
						$("#display")
								.on(
										'change',
										function() {
											var search = "${search}";
											var sel = document
													.getElementById("display");
											var record = sel.options[sel.selectedIndex].value;
											var page = 1;
											var array1 = new Array();
											array1 = "${breadCrumbLabel}"
													.split("#");
											var array2 = new Array();
											array2 = "${breadCrumbValue}"
													.split("#");
											var facetQuery = "";
											var hostName = createHostName();
											var url = hostName
													+ "/CustomsReporting/browse?&page="
													+ page + "&record="
													+ record;
											if (search.length > 0) {
												url = url + "&searchTerm="
														+ search;
											}
											var sort = document
													.getElementById("sort");
											if (sort != null) {
												var sortValue = sort.options[sort.selectedIndex].value;
												url = url + "&sort="
														+ sortValue;
											}
											for (i = 0; i < array1.length
													&& i < array2.length; i++) {
												if (array2[i] !== ""
														&& array1[i] !== "") {
													facetQuery = facetQuery
															+ "&facetValue="
															+ array2[i]
															+ "&facetField="
															+ array1[i];
												}
											}
											if (0 !== facetQuery.length) {
												url = url + facetQuery;
											}
											window.location.href = url;
										});
					});
	$(document).ready(function() {
		var slectedPage = "${selectedPageView}";
		var sel = document.getElementById("display");
		if (sel != null) {
			for (var i = 0; i < sel.length; i++) {
				var selValue = sel.options[i].value;
				if (selValue == slectedPage) {
					$('#display').val(selValue);
				}
			}
		}
	});
	function removeIcon(facetFiled, facetValue) {
		var search = "${search}";
		var page = 1;
		var record = 12;
		var sel = document.getElementById("display");
		if (sel != null) {
			record = sel.options[sel.selectedIndex].value;
		}
		var array1 = new Array();
		array1 = "${breadCrumbLabel}".split("#");
		var array2 = new Array();
		array2 = "${breadCrumbValue}".split("#");
		/*  start */
		var j = array1.indexOf(facetFiled);
		if (j != -1) {
			array1.splice(j, 1);
		}
		var k = array2.indexOf(facetValue);
		if (k != -1) {
			array2.splice(k, 1);
		}
		/* end */
		var facetQuery = "";
		var hostName = createHostName();
		var url = hostName + "/CustomsReporting/browse?";
		if (search.length > 0) {
			url = url + "&searchTerm=" + search;
		}
		var sort = document.getElementById("sort");
		if (sort != null) {
			var sortValue = sort.options[sort.selectedIndex].value;
			url = url + "&sort=" + sortValue;
		}
		if ((array1.length > 1 && array2.length > 1) || (search.length > 0)) {
			url = url + "&page=" + page + "&record=" + record;
		}
		for (i = 0; i < array1.length && i < array2.length; i++) {
			if (array2[i] !== "" && array1[i] !== "") {
				facetQuery = facetQuery + "&facetValue=" + array2[i]
						+ "&facetField=" + array1[i];
			}
		}
		if (0 !== facetQuery.length) {
			url = url + facetQuery;
		}
		window.location.href = url;
	}
	$(document)
			.ready(
					function() {
						$("#sort")
								.on(
										'change',
										function() {
											var search = "${search}";
											var page = 1;
											var record = 12;
											var sel = document
													.getElementById("display");
											if (sel != null) {
												record = sel.options[sel.selectedIndex].value;
											}
											var hostName = createHostName();
											var url = hostName
													+ "/CustomsReporting/browse?&page="
													+ page + "&record="
													+ record;
											if (search.length > 0) {
												url = url + "&searchTerm="
														+ search;
											}
											var sort = document
													.getElementById("sort");
											if (sort != null) {
												var sortValue = sort.options[sort.selectedIndex].value;
												url = url + "&sort="
														+ sortValue;
											}
											var array1 = new Array();
											array1 = "${breadCrumbLabel}"
													.split("#");
											var array2 = new Array();
											array2 = "${breadCrumbValue}"
													.split("#");
											var facetQuery = "";
											for (i = 0; i < array1.length
													&& i < array2.length; i++) {
												if (array2[i] !== ""
														&& array1[i] !== "") {
													facetQuery = facetQuery
															+ "&facetValue="
															+ array2[i]
															+ "&facetField="
															+ array1[i];
												}
											}
											if (0 !== facetQuery.length) {
												url = url + facetQuery;
											}
											window.location.href = url;
										});
					});
	$(document).ready(function() {
		var slectedSort = "${selectedsortOption}";
		var sort = document.getElementById("sort");
		if (sort != null) {
			for (var i = 0; i < sort.length; i++) {
				var sortValue = sort.options[i].value;
				if (sortValue == slectedSort) {
					$('#sort').val(sortValue);
				}
			}
		}
	});
	function pageClick(pageNo) {
		var search = "${search}";
		var page = pageNo;
		var record = 12;
		var sel = document.getElementById("display");
		if (sel != null) {
			record = sel.options[sel.selectedIndex].value;
		}
		var array1 = new Array();
		array1 = "${breadCrumbLabel}".split("#");
		var array2 = new Array();
		array2 = "${breadCrumbValue}".split("#");
		var facetQuery = "";
		var hostName = createHostName();
		var url = hostName + "/CustomsReporting/browse?&page=" + page + "&record="
				+ record;
		if (search.length > 0) {
			url = url + "&searchTerm=" + search;
		}
		var sort = document.getElementById("sort");
		if (sort != null) {
			var sortValue = sort.options[sort.selectedIndex].value;
			url = url + "&sort=" + sortValue;
		}
		for (i = 0; i < array1.length && i < array2.length; i++) {
			if (array2[i] !== "" && array1[i] !== "") {
				facetQuery = facetQuery + "&facetValue=" + array2[i]
						+ "&facetField=" + array1[i];
			}
		}
		if (0 !== facetQuery.length) {
			url = url + facetQuery;
		}
		window.location.href = url;
	}
	function createHostName() {
		var http = location.protocol;
		var slashes = http.concat("//");
		var host = location.host;
		var hostName = slashes + host;
		return hostName;
	}
</script>
<spring:url value="/resources/css/discover_electronics.css"
	var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<spring:url value="/resources/images/whitestar.gif" var="ReviewStar" />
<spring:url value="/resources/images/yellowstar.gif" var="yellowstar" />

</head>
<body>
	<div class="PageContent">
		<div class="UserPanel">
			<div class="options">
				<a href="#"> Customs Integrations Platform </a>| <a href="#"> Reporting</a>
			</div>
			<div class="ShoppingCartStatus">
				<div class="shoppingCartText">
					
				</div>
				<div class="clearFloat"></div>
			</div>

			<div class="clearFloat"></div>
		</div>
		<div class="PageLogo">
			
		</div>
		<div class="PageHeader">
			<div class="SearchBox">
				<form action="/CustomsReporting/browse" method="GET">
					<span class="searchBoxContainer" style="float: left;"> <label>Search:</label>
						<input class="searchInput" name="searchTerm" type="text"
						id="searchText"></span> <input class="submit" type="submit"
						value="">
				</form>
			</div>

		</div>
		<c:choose>
			<c:when test="${documentNumFound == 0 && empty suggestions}">
		<center>
		 <div class="zeroResults">
                <span class="sorry">We're Sorry</span>, no results were found.
            </div>
            <div class="zeroResultsAdvice">Please try another search.</div>
            </center>
		</c:when>
		<c:when test="${documentNumFound == 0 && not empty suggestions}">
		<center>
		<h1>Did you mean for </h1><br>
            <c:if test="${not empty suggestions}">
            <c:forEach items="${suggestions}" var="suggestion">
            <a href="/CustomsReporting/browse?searchTerm=${suggestion.suggestWord}" id="productDetails">
            <c:out value="${suggestion.suggestWord}"></c:out>
            (<c:out value="${suggestion.freq}"></c:out>)
            </a> <br>
            </c:forEach>
            </c:if>
            </center>
		</c:when>
			<c:otherwise>
				<div class="PageLeftColumn">
					<c:if test="${breadCrumbLabel != null  || breadCrumbValue != null}">
						<div class="Breadcrumbs">
							<div class="breadcrumbsHeaderText">Your Selections</div>
							<div class="WidgetBox">
								<div class="DimensionCrumb">
									<c:forEach items="${selections}" var="selection">
										<span class="breadcrumbDimText"> <c:out
												value="${selection.breadCrumbLabel}"></c:out><br></span>
										<!-- <input type="image" src="/CustomsReporting/resources/images/remove_X.png"> -->
										<a class="breadcrumbRemoveIcon"
											onclick="removeIcon('${selection.breadCrumbLabel}','${selection.breadCrumbValue}')"><img
											src="/CustomsReporting/resources/images/remove_X.png"
											alt="Remove Breadcrumb"> </a>
										<div class="floatLeft">
											<span class="breadcrumbText"> <c:choose>
													<c:when test="${selection.breadCrumbLabel == 'Price'}">
									 [ <c:out value="${selection.breadCrumbValue}"></c:out> - <c:out
															value="${selection.breadCrumbValue + 499}"></c:out> ]
									</c:when>
													<c:otherwise>
														<c:out value="${selection.breadCrumbValue}"></c:out>
													</c:otherwise>
												</c:choose>
											</span>
										</div>
										<%-- <input type="hidden" name="breadCrumbLabel" value="${breadCrumbLabel}" />
                     <input type="hidden" name="breadCrumbValue" value="${breadCrumbValue}" />
                     <input type="hidden" name="selectedLabel" value="${selection.breadCrumbLabel}" />
                     <input type="hidden" name="selectedValue" value="${selection.breadCrumbValue}" /> --%>
										<div class="clearBoth"></div>
									</c:forEach>
								</div>
								<div class="clearAllLink">
									<a class="breadcrumbsClearAllText" href="browse">Clear All</a>
								</div>
							</div>
						</div>
					</c:if>
					<div class="WidgetBoxTitle">Narrow Your Results</div>
					<div class="WidgetBox">
						<c:forEach var="facet" items="${facets}">
							<div class="RefinementDimension">
								<c:if test="${not empty facet.facetValues}">
									<div class="RefinementDimensionHeader">
										<span class="refinementDimensionHeaderText"><c:out
												value="${facet.facetName}" /></span><br>
									</div>
								</c:if>
								<div class="RefinementDimensionText">
									<c:forEach var="facetValue" items="${facet.facetValues}">
										<c:choose>
											<c:when test="${facet.facetName == 'Price'}">
												<input class="facet" type="checkbox"
													name="${facet.facetName}" value="${facetValue.facetLabel}"
													onclick="facet(this);">
									 [ <c:out value="${facetValue.facetLabel}"></c:out> - <c:out
													value="${facetValue.facetLabel + 499}"></c:out> ]
									 ( <c:out value="${facetValue.facetCount}" />)<br>
											</c:when>
											<c:otherwise>
												<input class="facet" type="checkbox"
													name="${facet.facetName}" value="${facetValue.facetLabel}"
													onclick="facet(this);">
												<c:out value="${facetValue.facetLabel}" /> (
     											<c:out value="${facetValue.facetCount}" />)<br>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="PageCenterColumn">
					<div class="PagingRecordList">
						<c:if test="${breadCrumbLabel != null  || search != null}">
							<div class="ResultsStatistic">
								<div class="PagingRecordListCount">
									<div class="PagingRecordListPagination">
										<c:if test="${begin > 5}">
											<a href="#" class="" onclick="pageClick('${begin-1}')"><c:out
													value="<"></c:out></a>
											<%-- <a href="http://localhost:8080/CustomsReporting/browse?searchTerm=${search}&page=${begin-1}&record=${selectedPageView}"><c:out value="<"/></a> --%>
										</c:if>
										<c:forEach var="i" begin="${begin}" end="${end}">
											<c:if test="${ i <= pageCreation}">
												<a href="#" class="" onclick="pageClick('${i}')"><c:out
														value="${i}" /></a>
												<%-- <a href="http://localhost:8080/CustomsReporting/browse?searchTerm=${search}&page=${i}&record=${selectedPageView}"><c:out value="${i}"/></a> --%>
											</c:if>
										</c:forEach>
										<c:if test="${(selectedPageView * end ) < documentNumFound}">
											<a href="#" class="" onclick="pageClick('${end+1}')"><c:out
													value=">" /></a>
											<%-- <a href="http://localhost:8080/CustomsReporting/browse?searchTerm=${search}&page=${end+1}&record=${selectedPageView}"><c:out value=">"/></a> --%>
										</c:if>
									</div>
									<div class="count">
										Showing result
										<c:out value="${((selectedPageNO -1 )*selectedPageView) + 1}" />
										-
										<c:choose>
											<c:when
												test="${(selectedPageNO*selectedPageView) < documentNumFound}">
												<c:out value="${(selectedPageNO * selectedPageView)}" />
											</c:when>
											<c:otherwise>
												<c:out value="${documentNumFound}" />
											</c:otherwise>
										</c:choose>
										of
										<c:out value="${documentNumFound}" />
										items
									</div>
								</div>
							</div>
							<div class="PagingRecordListHeader">
								<div class="rightAlignedOptions">
									<div class="display" style="float: left; width: auto;">
										<span>Display:</span> <select id="display">
											<c:forEach items="${pageViews}" var="pageView">
												<option value="${pageView.pageViewValue.id}"><c:out
														value="${pageView.pageViewLabel}" /></option>
											</c:forEach>
										</select>
									</div>
									<div class="sort" style="width: auto; float: right">
										<span>Sort By:</span> <select name="sort" id="sort">
											<c:forEach items="${sortOptions}" var="sortOption">
												<option value="${sortOption.sortOptionValue.id}"><c:out
														value="${sortOption.sortOptionLabel}" /></option>
											</c:forEach>
										</select>
									</div>
									<div style="clear: both;"></div>
								</div>
							</div>
						</c:if>
						<div class="PagingRecordListRecordBox">
							<div class="Record">
								<c:forEach var="record" items="${records}">
									<div class="thumbnail">

										 <a href="/CustomsReporting/productDetails/${record.id}"
											id="productDetails">
											sourceID:<c:out value="${record.sendingCountry}" />
									</div>
									<div class="productPurchase">
										<div class="price">${record.billOfLadingNumber}</div>

										<div class="addToCart">
										</div>
										<div class="addToWishlist">
										</div>
									</div>
									<div class="basicProductInfo">
										<div class="productBrand">
										  <c:if test="${not empty record.sendingCountry}">
											sendingCountry:<c:out value="${record.sendingCountry}" />
										  </c:if>
										</div>
										<div class="productName">
										    <c:if test="${not empty record.status}">
											 status:<c:out value="${record.status}" />
											</c:if>
										</div>
										<div class="productDesc">
										    <c:if test="${not empty record.iChgCtrl}">
											   iChgCtrl:<c:out value="${record.iChgCtrl}" />
											</c:if>
										</div>
										<div class="productDesc">
										  <c:if test="${not empty record.errorCode}">
											errorCode:<c:out value="${record.errorCode}" />										
										  </c:if>
										</div>
										<div class="productDesc">
										    <c:if test="${not empty record.errorDescription}">
											   errorDescription:<c:out value="${record.errorDescription}" />
											</c:if>
										</div>
										<div class="productDesc">
										    <c:if test="${not empty record.responseType}">
											  responseType:<c:out value="${record.responseType}" />
											</c:if>
										</div>
										<div class="productDesc">
										   <c:if test="${not empty record.receiverReference}">
											 receiverReference:<c:out value="${record.receiverReference}" />
											</c:if>
										</div>
										<div style="clear: both;"></div>
									</div>
									<div style="clear: both;"></div>
									<hr style="height:1px;border:none;color:#e2e2e2;background-color:#e2e2e2;" />
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
