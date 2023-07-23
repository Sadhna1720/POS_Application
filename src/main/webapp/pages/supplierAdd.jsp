<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SupplierAdd</title>

<style>
.center {
	text-align: center;
	padding: 30px;
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
	<div class=" main">
		<form action="supplierAdd.ds">
			<div class="border border-2" style="margin: 162px;">
				<div class="container rounded row "
					style="padding: 25px 45px 0px 45px;">
					<div class="col center">
						<div class=" heading fw-bold">
							<label>Supplier Name</label>
						</div>
						<div class="inner mt-3">
							<input type="text" name="supplierName" id="supplierName">
						</div>
					</div>
					<div class="col center">
						<div class=" heading fw-bold">
							<label>Contact number</label>
						</div>
						<div class="inner mt-3 ">
							<input type="text" name="supplierContact" id="supplierContact">
						</div>
					</div>
				</div>
				<div class="row" style="padding: 0px 45px 21px 45px;">
					<div class="col center">
						<div class=" heading fw-bold">
							<label>Address</label>
						</div>
						<div class="inner mt-3">
							<textarea id="supplierAddress" name="supplierAddress" rows="2"
								cols="25"></textarea>
						</div>
					</div>
					<div class="col center" style="font-family: Serif; color: white;">
						<input type="Submit" value="ADD" class="btn btn"
							style="background-color: #3f78cc; font-family: Serif; color: white; width: 52%; margin-left: 1%; margin-top: 15%; margin-bottom: 5%;">

					</div>
				</div>
			</div>
		</form>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>