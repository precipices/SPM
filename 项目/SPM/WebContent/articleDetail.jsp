<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${article.getTitle()}</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<c:set var="article" value="${requestScope.article}"/>
	<div class="topArea" style="text-align:center;">
		<div class="top">
			<div class="topDiv">
				<div class="logo"></div>
				<c:choose>
					<c:when test="${username==null}">
						<div class="toolPanel">
							<div class="loginArea">
								<a id="studentLogin" href="studentLogin.jsp">学&nbsp;生</a>
								<a id="teacherLogin" href="teacherLogin.jsp">教&nbsp;师</a>
								<a id="adminLogin" href="admin">后&nbsp;台</a>
							</div>
							<div class="clearBoth"></div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="toolPanel">
							<div class="loginArea">
								<a>${userType}用户：<b>${username}</b></a>
								<a href="PersonalCenter">个人中心</a>
								<a href="logout">退出登录</a>
							</div>
							<div class="clearBoth"></div>
						</div>
					</c:otherwise>
				</c:choose>
				<div class="clearBoth"></div>
			</div>
			<div class="navDiv">
				<div class="nav">
					<ul>
						<li><a href="getArticleList">首&nbsp;页</a></li>
						<li><a href="ListFileServlet">资源区</a></li>
						<c:choose>
							<c:when test="${userType.equals('学生')}">
								<li><a href="getCourseList">选课系统</a></li>
								<li><a href="studentGrade">成绩管理</a></li>
							</c:when>
							<c:when test="${userType.equals('教师')}">
								<li><a href="getStudentList">选课系统</a></li>
								<li><a href="addGrade">成绩管理</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="#">选课系统</a></li>
								<li><a href="#">成绩管理</a></li>
							</c:otherwise>
						</c:choose>
						<li><a href="#">留言板</a></li>
						<li><a href="#">网上测试</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<div class="mainBox">
		<div class="mainBoxArea">
			<div class="articleTitle">
				<h1>${article.getTitle()}</h1>
			</div>
			<div class="time">
				${article.getAdd_time()}
			</div>
			<div>
				${article.getContent()}
			</div>
		</div>
	</div>
</body>
</html>