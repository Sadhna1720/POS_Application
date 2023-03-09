<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.sidenav {
	margin-top: 8.92%;
	height: 79%;
	width: 20%;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #f0f0f0;
	overflow-x: hidden;
	padding-top: 10px;
}

.sidenav a {
	text-decoration: none;
	color: black;
	display: block;
}

.sidenav c {
	font-family: Serif;
	font-size: 25px;
	padding: 8px 10px 0px 100px;
}

.sidenav a:hover {
	color: #a09e9e;
}

svg:hover {
	color: #a09e9e;
}

.main {
	margin-left: 22%;
	margin-right: 10%;
	width: 77%;
	margin-top: 12%;
	height: 100%;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	font-family: Serif;
	font-size: 19px;
	display: none;
	position: relative;
	background-color: #f9f9f9;
	min-width: 10px;
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 10px 0px 10px 97px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #6c757d;
	color: white;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>

<body>

	<nav class="navbar fixed-navbar bg-body-tertiary responsive "
		style="box-shadow: 0px 3px 20px #b8b4b4; font-family: Serif; position: fixed; top: 0; width:100%;height: auto;">
		<div class="row container-fluid ">
			<div class="col col-md-2 " style="width: 30%;">
				<img src="images/Logo.png" alt="Logo" width="30%" height="10%"
					class="d-inline-block align-text-top " style="margin-left: 20%;">
			</div>
			<div class="col ">
				<p class=" fw-bold fs-1">Covai Sprouts Technologies Pvt Ltd</p>
			</div>
			<div class="col col-lg-2 ">
				<form class="d-flex" action="logout.ds">
					<button class="rounded border border-0 " type="submit"
						style="background-color: transparent;">
						<svg xmlns="http://www.w3.org/2000/svg" width="19" height="19"
							fill="currentColor" class="bi bi-box-arrow-right"
							viewBox="0 0 19 19" style="display: flex;width:22em; height: 44px;">
							  <path fill-rule="evenodd"
								d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z" />
							  <path fill-rule="evenodd"
								d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z" />
						   </svg>
					</button>
				</form>
			</div>
		</div>
	</nav>
	<div class="sidenav responsive">
		<div class="row dropdown">
			<c>Category</c>
			<div class="dropdown-content">
				<a href="./categoryAdd.ds">Add Category</a> <a
					href="./categoryList.ds">View Category</a>
			</div>
		</div>
		<hr>
		<div class="row dropdown">
			<c>Product</c>
			<div class="dropdown-content">
				<a href="./productAdd.ds">Add Product</a> <a href="./productList.ds">View
					Products</a>
			</div>
		</div>
		<hr>
		<div class="row dropdown">
			<c>
			<a href="./purchase.ds">Purchase</a> </c>
		</div>
		<hr>
		<div class="row dropdown">
			<c>Supplier</c>
			<div class="dropdown-content">
				<a href="./supplierAdd.ds">Add Supplier</a> <a
					href="./supplierList.ds">View List</a>
			</div>
		</div>
		<hr>
		<div class="row dropdown">
			<c>
			<a href="customer.ds">Customers</a></c>
		</div>
		<hr>
		<div class="row dropdown">
			<c>
			<a href="./inventory.ds">Inventory</a></c>
		</div>
		<hr>
		<div class="row dropdown">
			<c>
			<a href="./sales.ds">Sales</a></c>
		</div>
		<hr>
		<div class="row dropdown">
			<c>Report</c>
			<div class="dropdown-content">
				<a href="./reportSales.ds">Sales Reports</a> <a
					href="./reportPurchase.ds">Purchase Reports</a>
			</div>
		</div>
	</div>
	<div class="fixed-bottom"
		style="text-align: right; box-shadow: 0px 3px 20px #b8b4b4; height: 37px; color: #435A98; font-family: Serif; background-color: #efefef;">
		<p style="padding: 6px 30px 0 0;">
			Powered by <a style="color: #435A98;"
				href="https://www.covai-sprouts.com/">Covai Sprouts Technologies</a>
		</p>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>