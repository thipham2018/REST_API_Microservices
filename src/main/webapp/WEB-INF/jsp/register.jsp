<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>UMS</title>
	<script src="/webjars/jquery/jquery.min.js"></script>
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
		<div class="content">
			<h1>My website</h1>
			<div class="text-underline font-18px">Welcome to our page</div>
			<div>Register Information!</div>
			<div>Name</div>
			<div><input type="text" name="name"></div>
			<div>Email</div>
			<div><input type="email" name="email"></div>
			<div>Password</div>
			<div><input type="password" name="password"></div>
			<div>Role</div>
			<div>
				<input type="checkbox" name="roles" id="role-1" value="eb932dbb-7005-422f-a649-7190af39e984" checked>Producer
				<input type="checkbox" name="roles" id="role-2" value="b479b357-7e25-47fa-8dba-bfdaeecc6c2c" checked>Subscriber
			</div>
			<div><button onclick="registerSubmit()">Submit</button></div>
			<div>Go to Login page: <a href="/login">click here</a></div>
		</div>
	</main>
</body>
<script>
	function registerSubmit(){
		var roles = []
		$(`[name='roles']:checked`).each(function(){
			roles.push({"id": $(this).val()})
		})
		const data = {
			"name": $(`[name="name"]`).val(),
		    "email": $(`[name="email"]`).val(),
		    "password": $(`[name="password"]`).val(),
		    "roles": roles
		}
		$.ajax('/users',{
		    'data': JSON.stringify(data), //{action:'x',params:['a','b','c']}
		    'type': 'POST',
		    'processData': false,
		    'contentType': 'application/json',
		    success: function(res){
		    	const message = res.message
		    	const status = res.status
		    	alert(message)
		    	if(status) location.href = "/login"
		    }
		});
	}
	
	// $.post(
	// 	"/users",
	// 	{
	// 	    "name": $(`[name="name"]`).val(),
	// 	    "email": $(`[name="email"]`).val(),
	// 	    "password": $(`[name="password"]`).val(),
	// 	    "roles": [
	// 	        {"id": "eb932dbb-7005-422f-a649-7190af39e984"}
	// 	    ]
	// 	}
	// )
</script>
</html>