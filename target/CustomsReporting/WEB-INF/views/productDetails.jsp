
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Customs Integrations Platform - Reporting</title>


<spring:url value="/resources/css/discover_electronics.css"
	var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<spring:url value="/resources/images/whitestar.gif" var="ReviewStar" />
<spring:url value="/resources/images/yellowstar.gif" var="yellowstar" />

<script type="text/javascript">
	function openTab(evt, divTag) {

		var i, tabcontent, tablinks;
		var tbContents = document.getElementsByClassName("tabContent");

		for (i = 1; i < tbContents.length; i++) {
			tbContents[i].style.display = "none";
		}
		tablinks = document.getElementsByClassName("tabTitleFocus");

		for (i = 0; i < tablinks.length; i++) {

			tablinks[i].className = tablinks[i].className.replace(
					" tabTitleFocus", "tabTitleUnfocus");
			evt.currentTarget.className = " tabTitleFocus";

		}

		document.getElementById(divTag).style.display = "block";

	}
	function showOverView() {

		document.getElementById("Overview").style.display = "block";
	}
</script>

</head>
<body onload="showOverView();">

	<div class="PageContent">
		<div class="UserPanel">
			<div class="options">
				<a href="#"> Customs Integrations Platform </a>| <a href="#"> Reporting</a>
			</div>
			<div class="ShoppingCartStatus">
				<div class="shoppingCartText">
					<a href="#"> Shopping Cart </a>
				</div>
				<div class="numItems">0</div>
				<div class="itemsText">Items</div>
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
		<div class="clearBoth"></div>
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
	<!-- For PageContent Ending -->


</body>
</html>