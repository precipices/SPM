<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		$('.menuson li').click(function(){
			$('.menuson li.active').removeClass('active')
			$(this).addClass('active')
		});
		$('.title').click(function(){
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if($ul.is(':visible')){
				$(this).next('ul').slideUp();
			}else{
				$(this).next('ul').slideDown();
			}
		});
	})
</script>
</head>
<body style="background:#F0F9FD;">
	<div class="leftTop"><span></span>欢迎您，管理员<b>admin</b></div>
	<dl class="leftMenu">
		<dd>
			<div class="title">
				<span><img src="img/left/leftico01.png" /></span>文章信息
			</div>
			<ul class="menuson">
				<li class="active"><cite></cite><a href="../addArticle" target="rightFrame">添加文章</a><i></i></li>
				<li><cite></cite><a href="../viewArticle" target="rightFrame">查看文章</a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="img/left/leftico02.png" /></span>课程信息
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="../addCourse" target="rightFrame">添加课程</a><i></i></li>
				<li><cite></cite><a href="../viewCourse" target="rightFrame">查看课程</a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="img/left/leftico03.png" /></span>用户信息
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="../getTempTeacher" target="rightFrame">审核注册</a><i></i></li>
				<li><cite></cite><a href="../viewUser" target="rightFrame">查看用户</a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="img/left/leftico04.png" /></span>文件管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="../ListFileServlet?userType=admin" target="rightFrame">文件审核</a><i></i></li>
			</ul>
		</dd>
	</dl>
</body>
</html>