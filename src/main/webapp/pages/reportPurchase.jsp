<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>reportPurchase</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">

<style>
#customers {
	font-family:Serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: #04AA6D;
	color: white;
}
button{
    right: 0px;
    padding: 5px 45px 5px 45px;
}
option{
	background-color: #e9ebed;;
	color:black;
	text-align:left;
}
</style>
</head>

<body>

	<%@include file="navbar.jsp"%>

	<div class=" main container border boder-bottom-0"
		style="width: 70%; margin-left: 24.5%;padding: 0px 10px 16px 10px;font-family: Serif;">
				<div class="row">
					<div class=" col dropdown" style="padding: 21px 0 7px 899px;">
					 <select class="dropdown select btn btn-secondary dropdown-toggle fs-6" name="filter"
								id="fiter" style="padding:9px 0px 8px 56px;">
								<option disabled selected hidden>Filter </option>
								<option>Today</option>
								<option>Week</option>
								<option>Day-to-Day</option>
					 </select>
					</div>
				</div>
		<div class="container fs-5">
			<table id="customers">
				<thead>
					<tr>
						<th>S No.</th>
						<th>Bill number</th>
						<th>Product name</th>
						<th>Supplier</th>
						<th>Amount</th>
					</tr>
				<thead>
				<tbody>
						<%	
						int i = 0;
						%>
						<c:forEach var="b" items="${productList}">
							<tr>
								<td><%=++i%></td>
								<td>${b.billNumber}</td>
								<td>${b.name}</td>
								<td>${b.supplierName}</td>
								<td>${b.sellingPrice}</td>             <!--  selling price is just name here in this we have cost price              -->
							</tr>
						</c:forEach>
					</tbody>
			</table>
		<div class="fixed mt-4" style="margin-left: 86%;">		
		<form action="purchaseReportExport.ds"><button class="rounded border border-1" type="submit" style="padding: 9px 59px 9px 59px;"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-download" viewBox="0 0 16 16">
	  <path d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z"/>
	  <path d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3z"/>
	</svg></button></form>
		</div>
		</div>
		
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>