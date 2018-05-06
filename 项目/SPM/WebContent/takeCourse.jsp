<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选课系统</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.idTabs.min.js" type="text/javascript" charset="utf-8"></script>
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
			<div id="usual" class="usual">
				<div class="itab">
					<ul>
						<li><a href="#tab1" id="a1" class="selected">学生选课</a></li>
						<li><a href="#tab2" id="a2">选课结果</a></li>
					</ul>
				</div>
				<div id="tab1" class="tabson">
					<table class="tableList">
    					<thead>
    						<tr>
    							<th>课程名称</th>
    							<th>任课教师</th>
    							<th>上课地点</th>
    							<th>上课时间</th>
    							<th>操作</th>
    						</tr>
    					</thead>
    					<tbody>
    						<c:forEach var="course" items="${courseList}">
    							<tr>
    								<td>${course.getCourse_name()}</td>
    								<td>${course.getTeacher()}</td>
    								<td>${course.getBuilding()}${course.getRoom()}</td>
    								<td>${course.getDay()}${course.getTime()}</td>
    								<td><a href="<c:url value='takeCourse?course_id=${course.getCourse_id()}&student_id=${username}'/>" class="tableLink">选课</a></td>
    							</tr>
    						</c:forEach>
    					</tbody>
    				</table>
				</div>
			</div>
		</div>
		<div id="tab2" class="tabson">
			<div class="mainBox">
				<div class="mainBoxArea">
					<table class="tableList">
    					<thead>
    						<tr>
    							<th>课程名称</th>
    							<th>任课教师</th>
    							<th>上课地点</th>
    							<th>上课时间</th>
    							<th>状态</th>
    							<th>操作</th>
    						</tr>
    					</thead>
    					<tbody>
    						<c:forEach var="course" items="${tempResultList}">
    							<tr>
    								<td>${course.getCourse_name()}</td>
    								<td>${course.getTeacher()}</td>
    								<td>${course.getBuilding()}${course.getRoom()}</td>
    								<td>${course.getDay()}${course.getTime()}</td>
    								<td>未确认</td>
    								<c:url var="del" value="/deleteTake">
										<c:param name="type" value="1" />
										<c:param name="username" value="${username}" />
										<c:param name="course_id" value="${course.getCourse_id()}" />
									</c:url>
    								<td><a href="${del}" class="tableLink">退课</a></td>
    							</tr>
    						</c:forEach>
    						<c:forEach var="course" items="${resultList}">
    							<tr>
    								<td>${course.getCourse_name()}</td>
    								<td>${course.getTeacher()}</td>
    								<td>${course.getBuilding()}${course.getRoom()}</td>
    								<td>${course.getDay()}${course.getTime()}</td>
    								<td>已确认</td>
    								<c:url var="del" value="/deleteTake">
										<c:param name="type" value="2" />
										<c:param name="username" value="${username}" />
										<c:param name="course_id" value="${course.getCourse_id()}" />
									</c:url>
    								<td><a href="${del}" class="tableLink">退课</a></td>
    							</tr>
    						</c:forEach>
    					</tbody>
    				</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
      	$("#usual ul").idTabs();
    </script>
	<script type="text/javascript">
		$('.tableList tbody tr:odd').addClass('odd');
	</script>
</body>
</html>