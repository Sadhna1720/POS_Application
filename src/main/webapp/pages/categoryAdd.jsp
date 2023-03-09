<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>categoryAdd</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>

<body>
	
	<%@include file="navbar.jsp"%>
	<div class="main container table-responsive "style="padding: 90px 26px 0px 331px;text-align:center;">
		<div class="container rounded  border border-2  mb-3" style="height: 260px; margin-left: 1%;width:96%">
				<div class="row">
					<div class="col heading fs-4 "  >
						<label style="padding: 59px 0 5px 250px;"> Category</label>
					</div>
					<div class=" col inner" style="padding: 63px 200px 5px 0;">
						<input type="text" name="category" id="category"  placeholder="Oil" style="padding: 5px 21px 5px 21px;">
					</div>
				</div>
				<div class="row" style="font-family: Serif; color: white;padding: 60px 0px 0px 210px;">
					<input type="Submit" value="ADD" class="btn btn"
						style="background-color: #3f78cc; font-family: Serif; color: white; width: 70%;align-items:center; margin-bottom: 5%;">
				</div>
		  </div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>