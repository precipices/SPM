<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生注册</title>
<link rel="stylesheet" type="text/css" href="css/register.css"/>
</head>
<body>
	<div class="login-form">
		<div class="top-login">
			<span><img src="images/student.png" alt=""/></span>
		</div>
		<h1>学生注册</h1>
		<div class="login-top">
			<form id="signupForm" action="StudentRegister" method="post">
				<label for="userid">&nbsp;</label>
				<div class="login-ic">
					<i></i>
					<input type="text" id="userid" name="username" placeholder="用户名"/>
					<div class="clear"></div>
				</div>
				<label for="userpassword">&nbsp;</label>
				<div class="login-ic">
					<i class="icon"></i>
					<input type="password" id="userpassword" name="password1" placeholder="密码"/>
					<div class="clear"></div>
				</div>
				<label for="userpasswordcheck">&nbsp;</label>
				<div class="login-ic">
					<i class="icon"></i>
					<input type="password" id="userpasswordcheck" name="password2" placeholder="重复密码"/>
					<div class="clear"></div>
				</div>
				<div class="log-bwn">
					<input type="submit"  value="注册">
				</div>
			</form>
		</div>
	</div>
</body>
</html>