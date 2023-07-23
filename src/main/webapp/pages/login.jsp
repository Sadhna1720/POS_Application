<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>


<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<style>
.image {
	background-image: url("images/login_bg.jpg");
	background-size: cover;
}

.image-overlay {
	width: 100%;
	height: 100vh;
	background-color: white;
	opacity: 0.8;
}

.h1 {
	font-family: Serif;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<div class="image">
		<div class="image-overlay">
			<div class="container"
				style="text-align: center; background-color: transparent;">
				<div class="row ">
					<div class="col container">
						<div class="row "
							style="width: 50%; margin-top: 30%; margin-left: 20%;">
							<img src="images/Logo.png" class="rounded float-start mt-3 "
								alt="lodd">
						</div>
						<div class="row mt-4">
							<h1 class="h1">Covai Sprouts Technologies Pvt Ltd</h1>
						</div>
					</div>

					<div class="col" style="padding: 15% 0;">
						<form action="login.ds" method="post">
							<div class="container "
								style="width: 70%; border-radius: 8px; box-shadow: -9px 10px 300px #302f2f; background-color: transparent;">
								<h1 class="h1 fw-bold "
									style="text-align: center; color: black; padding-top: 23px; text-shadow: 4px 2px 4px #575762;">Login</h1>
								<div class="input-group " style="padding: 28px 78px 15px;">
									<span class="input-group-text">@</span> <span
										class="input-group-text"> <input class="form-control"
										type="text" id="UserId" name="UserId" autocomplete="off"
										placeholder="User ID" required onclick="removeErrMsg()"></span>
								</div>
								<div class="input-group" style="padding: 8px 78px 15px;">
									<span class="input-group-text">#</span> <span
										class="input-group-text"> <input class="form-control"
										type="Password" name="Password" id="Password"
										placeholder="Password" required>
									</span>
								</div>
								<div style="padding: 25px;">
									<input type="Submit" class="btn btn"
										style="background-color: #235195; font-family: Serif; color: white; width: 40%" onclick="loginErr()"
										placeholder="Submit">

									<div class="mt-3">
										<span id="errSpan">${errorMsg}  </span>
									</div>

								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="fixed-bottom mx-4 "
				style="text-align: right; background-color: transparent; padding: 5px; color: #435A98; font-family: Serif;">
				<p>
					Powered by <a
						style="color: #435A98; background-color: transparent;"
						href="https://www.covai-sprouts.com/">Covai Sprouts
						Technologies</a>
			</div>
		</div>
	</div>
	<script>
		 function removeErrMsg(){
			 console.log("......in removeErrMsg");
			 '${errorMsg}'
		 }
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>