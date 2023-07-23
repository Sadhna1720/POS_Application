<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ProductAdd</title>

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

	<div style="padding: 192px 192px 0px 476px;">
		<form action="productAdd.ds">
			<div class="container rounded border border-2 "
				style="padding: 42px 111px 0px 90px;">
				<div class="row" style="">
					<div class="col center">
						<div class="  fw-bold">
							<label>Product Name</label>
						</div>
						<div class="inner mt-3">
							<input type="text" name="productName" id="productName">
						</div>
					</div>
					<div class="col center">
						<div class="  fw-bold">
							<label>Product ID</label>
						</div>
						<div class="inner mt-3">
							<input type="text" name="productId" id="productId">
						</div>
					</div>
				</div>
				<div class="row" style="margin-top: -40px;">
					<div class="col center">
						<div class="  fw-bold">
							<label>Selling Price</label>
						</div>
						<div class="inner mt-3">
							<input type="text" name="sellPrice" id="sellPrice">
						</div>
					</div>
					<div class="col center">
						<div class="  fw-bold">
							<label>Tax</label>
						</div>
						<div class="inner mt-3">
							<input type="text" name="tax" id="tax">
						</div>
					</div>
				</div>
				<div class="row center" style="margin-top: -34px;">
					<div class="  fw-bold">
						<label>Category</label>
					</div>
					<div class="inner mt-2">
						<div style="font-family: Serif; color: white;">
							<select
								class="dropdown select btn btn-secondary dropdown-toggle "
								name="category" id="category"
								style="padding: 10px 56px 10px 56px;">
								<option disabled selected hidden>Select</option>
								<c:forEach var="category" items="${categoryList}">
									<option>${category}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="row" style="padding: 22px 112px 46px 94px;">
					<input type="submit"
						style="padding: 8px 40px 15px 40px; margin-left: 5%;" value="ADD"
						class="btn btn-outline-primary">
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