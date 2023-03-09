<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Purchase</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">

<style>
#customers {
	font-family: Arial, Helvetica, sans-serif;
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
	padding: 9px 14px 9px 14px;
	text-align: center;
	background-color: #04AA6D;
	color: white;
}
</style>

</head>

<body>

	<%@include file="navbar.jsp"%>
	<div class="main container border border-1"
		style="width: 70%; margin-left: 24.5%; padding: 20px 10px 0 10px; font-family: Serif;">
		<div class=" row ">
			<div class="col ">
				<table id="customers">
					<thead>
						<tr>
							<th>S No.</th>
							<th><select
								class="dropdown select btn btn-sucess dropdown-toggle"
								name="PayMethod" id="PayMethod"
								style="width: 100%; height: 100%; color: white;">
									<option disabled selected hidden>Product Name</option>
									<c:forEach var="payMethod" items="${productName}">
										<option>${productName}</option>
									</c:forEach>
							</select></th>
							<th><select
								class="dropdown select btn btn-sucess dropdown-toggle"
								name="PayMethod" id="PayMethod"
								style="width: 100%; color: white;">
									<option disabled selected hidden>Supplier</option>
									<c:forEach var="payMethod" items="${supplierName}">
										<option>${supplierName}</option>
									</c:forEach>
							</select></th>
							<th><input type="text" name="qty" id="qty" placeholder="Qty"
								style="width: 100%;"></th>
							<th><input type="text" name="price" id="price"
								placeholder="Price" style="width: 100%;"></th>
						</tr>
					</thead>
					<c:forEach var="b" items="${test}">
						<tr>
							<td>1</td>
							<td scope="row">${b}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="fixed-bottom mb-4" style="background-color: transparent;position:relative;">
				<div class=row>
					<div class="col" style="padding: 26px 0 0 772px;">
						<button type="button" style="padding: 15px 48px 15px 48px;"
							class="btn btn-outline-success">Done</button>
						<button type="button" style="padding: 15px 48px 15px 48px;"
							class="btn btn-outline-danger">Cancel</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>