<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="js/select-ui.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
    	$(".select").uedSelect({
			width : 345
		});
	});
</script>
</head>
<body>
	<div class="topArea" style="text-align:center;">
		<div class="top">
			<div class="topDiv">
				<div class="logo"></div>
				<c:choose>
					<c:when test="${username==null}">
						<div class="toolPanel">
							<div class="loginArea">
								<a id="studentLogin" href="studentLogin.jsp">学&nbsp;生</a>
								<a id="teacherLogin" href="" target="_blank">教&nbsp;师</a>
								<a id="adminLogin" href="admin" target="_blank">后&nbsp;台</a>
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
			<c:choose>
				<c:when test="${userType.equals('学生')}">
					<form action="setUserDetail" method="post">
						<ul class="formInfo">
							<li><label>姓名</label><input type="text" name="student_name" value="${student.getStudent_name()}"/></li>
							<li>
								<label>性别</label>
								<div class="vocation">
									<select class="select" name="sex">
										<c:choose>
											<c:when test="${student.getSex().equals('男')}">
												<option value="男" selected="selected">男</option>
												<option value="女">女</option>
											</c:when>
											<c:when test="${student.getSex().equals('女')}">
												<option value="男">男</option>
												<option value="女" selected="selected">女</option>
											</c:when>
											<c:otherwise>
												<option value="男">男</option>
												<option value="女">女</option>
											</c:otherwise>
										</c:choose>
									</select>
								</div>
							</li>
							<li><label>年龄</label><input type="text" name="age" value="${student.getAge()}"/></li>
							<li><label>院系</label><input type="text" name="sdept" value="${student.getSdept()}"/></li>
							<li><label>&nbsp;</label><input type="submit" value="提交更改" class="btn" /></li>
						</ul>
					</form>
				</c:when>
				<c:otherwise>
					<form action="setUserDetail" method="post">
						<ul class="formInfo">
							<li><label>姓名</label><label>${teacher.getTeacher_name()}</label></li>
							<li>
								<label>性别</label>
								<div class="vocation">
									<select class="select" name="sex">
										<c:choose>
											<c:when test="${teacher.getSex().equals('男')}">
												<option value="男" selected="selected">男</option>
												<option value="女">女</option>
											</c:when>
											<c:when test="${teacher.getSex().equals('女')}">
												<option value="男">男</option>
												<option value="女" selected="selected">女</option>
											</c:when>
											<c:otherwise>
												<option value="男">男</option>
												<option value="女">女</option>
											</c:otherwise>
										</c:choose>
									</select>
								</div>
							</li>
							<li><label>年龄</label><input type="text" name="age" value="${teacher.getAge()}"/></li>
							<li><label>&nbsp;</label><input type="submit" value="提交更改" class="btn" /></li>
						</ul>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>