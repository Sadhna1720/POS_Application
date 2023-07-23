<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sales</title>
<style>
#customers {
	font-family: Serif;;
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
	padding: 11px 22px 11px 22px;
	background-color: #04AA6D;
	color: white;
}
</style>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>

<body>

	<%@include file="navbar.jsp"%>
	<div style="padding: 170px 0px 0px 299px; height: 100%;">
		<div class="row ms-3 " style="width: 94%;">
			<div class="col-8">
				<div class="container row" style="width: auto;">
					<form class="d-flex" role="search">
						<input class="form-control" type="search" placeholder="Search"
							aria-label="Search">
						<button class="btn btn-outline-primary" type="submit">Search</button>
					</form>
				</div>
				<div
					class="container table-responsive mt-4 border border-1 border-bottom-0">
					<table id="customers" style="font-family: Serif; margin-top: 2%;">
						<thead>
							<tr class="fs-5">
								<th>S No.</th>
								<th>Product Name</th>
								<th>Product ID</th>
								<th>Category</th>
								<th>Qty</th>
								<th>Price</th>
							</tr>
						</thead>
						<tbody>
						<%	
						int i = 0;
						%>
							<c:forEach var="b" items="${salesList}">
								<tr>
									<td><%=++i%></td>
									<td>${b.name}</td>
									<td>${b.productId}</td>
									<td>${b.category}</td>
									<td></td>
									<td>${b.sellingPrice}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-4 rounded container border border-3 fs-4"
				style="padding:31px 40px 25px 40px;">

				<div class="row">
					<div class="col">
						<label>Subtotal</label>
					</div>
					<div class="col"></div>

				</div>
				<hr>
				<div class="row">
					<div class="col">
						<label>Tax</label>
					</div>
					<div class="col"></div>
				</div>
				<hr>
				<div class="row">
					<div class="col">
						<label>discount</label>
					</div>
					<div class="col"></div>
				</div>
				<hr>
				<div class="row">
					<div class="col">
						<label>Total</label>
					</div>
					<div class="col"></div>
				</div>
				<hr>
				<div class=" row" >
					<form class="d-flex" role="search">
						<input class="form-control" type="search" placeholder="Search customer name/contact"
							aria-label="Search">
						 <!-- <button class="btn btn-outline-primary" type="submit">Search</button>  -->
					</form>
				</div>
				<hr>
				<div class="row">
					<select class="dropdown select btn btn-secondary dropdown-toggle"
						name="PayMethod" id="PayMethod">
						<option disabled selected hidden>Payment Method</option>
						<c:forEach var="payMethod" items="${payMethod}">
							<option>${payMethod}</option>
						</c:forEach>
					</select>
				</div>
				<hr>
				<div class="row">
					<button type="button" style="padding: 12px 40px 12px 40px;"
						class="btn btn-outline-success">Done</button>
				</div>
				<div class="row mt-2">
					<button type="button" style="padding: 12px 40px 12px 40px;"
						class="btn btn-outline-danger">Cancel</button>
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