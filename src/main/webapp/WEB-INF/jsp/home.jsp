<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>HOME</title>
	<script src="/webjars/jquery/jquery.min.js"></script>
</head>
<style>
	body {
		margin: 0;
		padding: 0;
		background-color: #191E2D;
	}

	.content{
		width: 500px;
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

	table{
		width: 100%;
		margin: auto;
	}

	a{
		color: #6C86FD;
	}
</style>
<body>
	<main>
		<div class="content">
			<table border="1">
				<tr>
					<td>UUID</td>
					<td id="user_uuid"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td id="user_name"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td id="user_email"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td id="user_password"></td>
				</tr>
				<tr>
					<td>Created</td>
					<td id="user_created"></td>
				</tr>
				<tr>
					<td>Role</td>
					<td id="user_roles"></td>
				</tr>
				<tr>
					<td colspan="2"><a href="/logout">Logout</a></td>
				</tr>
			</table>
		</div>
	</main>
</body>
<script>
	$.get("/users/info", function(data){
		const userInfo = data.data
		$("#user_uuid").html(userInfo.id)
		$("#user_name").html(userInfo.name)
		$("#user_email").html(userInfo.email)
		$("#user_password").html(userInfo.password)
		$("#user_created").html(new Date(userInfo.created*1000))

		var roleName = userInfo.roles.map((r) => { return r['name']+"<br>" })
		$("#user_roles").append(roleName)
	})
</script>
</html>
