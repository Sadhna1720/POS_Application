<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inventory</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
	

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
	padding: 9px 60px 9px 18px;
	text-align: center;
	background-color: #04AA6D;
	color: white;
}
</style>
</head>

<body>
	
	<%@include file="navbar.jsp"%>
	<div class="main"style="padding: 23px 77px 0 77px;text-align:center;">
		<div class=" container row" style="padding-bottom:36px;width: 102%;">
			<div class=" col ">
				 <form class="d-flex" role="search">
			        <input class="form-control me-2" type="search" placeholder="Search Product here" aria-label="Search">
			        <button class="btn btn-outline-success" type="submit">Search</button>
			      </form>
			</div>
			<div class=" col ms-5 me-0" >
				 <form class="d-flex" role="search">
			        <input class="form-control me-2" type="search" placeholder="Search Category here" aria-label="Search">
			        <button class="btn btn-outline-success" type="submit">Search</button>
			      </form>
			</div>
		</div>
		<div class="border border-1 border-bottom-0" style="padding: 10px 10px 0 10px; font-family: Serif;">
		  <table id="customers">
					<thead class="fs-5">
						<tr>
							<th>S No.</th>
							<th>Product Name</th>
							<th>Product ID</th>
							<th>Category</th>
							<th>Available Qty</th>
						</tr>
					</thead>
					<tbody>
						<%	
						int i = 0;
						%>
						<c:forEach var="b" items="${productList}">
							<tr>
								<td><%=++i%></td>
								<td>${b.name}</td>
								<td>${b.productId}</td>
								<td>${b.category}</td>
								<td>${b.qty}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		  </div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>