<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>UMS</title>
</head>
<style>
	body {
		margin: 0;
		padding: 0;
		background-color: #191E2D;
	}

	.content{
		width: 250px;
		text-align: center;
		color: #FCD116;
		margin: auto;
	}

	.text-underline{
		text-decoration: underline;
	}

	.font-18px{
		font-size: 18px;
	}

	div{
		margin-top: 8px;
	}

	a{
		color: #6C86FD;
	}
</style>
<body>
	<main>
		<form class="content" method="POST">
			<h1>My website</h1>
			<div class="text-underline font-18px">Welcome to our page</div>
			<div>Login Information!</div>
			<div>Email</div>
			<div><input type="email" name="email"></div>
			<div>Password</div>
			<div><input type="password" name="password"></div>
			<div><button type="submit">Submit</button></div>
			<div>Login with GitHub: <a href="/oauth2/authorization/github">click here</a></div>
			<div>Register: <a href="/register">click here</a></div>
		</form>
	</main>
</body>
</html>