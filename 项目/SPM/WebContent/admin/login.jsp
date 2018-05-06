<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台信息管理系统-管理员登陆</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cloud.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		$('.loginBox').css({'position':'absolute','left':($(window).width()-692)/2});
		$(window).resize(function(){
			$('.loginBox').css({'position':'absolute','left':($(window).width()-692)/2});
		})
	});
</script>
</head>
<body style="background-color:#1C77AC;background-image:url(img/login/light.png);background-repeat:no-repeat;background-position:center top;overflow:hidden">
	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>
	<div class="loginTop">
		<span>欢迎登陆后台管理系统</span>
		<ul>
			<li><a href="#">首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>
	<div class="loginBody">
		<span class="systemLogo"></span>
		<div class="loginBox">
			<form action="../AdminLogin" method="post">
				<ul>
					<li><input type="text" name="username" class="loginUsername" /></li>
					<li><input type="password" name="password" class="loginPassword" /></li>
					<li><input type="submit" value="登录" class="loginButton"/></li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>