<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加成绩</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="js/select-ui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.idTabs.min.js" type="text/javascript" charset="utf-8"></script>
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
			<div id="usual" class="usual">
				<div class="itab">
					<ul>
						<li><a href="#tab1" id="a1">添加成绩</a></li>
						<li><a href="#tab2" id="a2" class="selected">查看成绩</a></li>
					</ul>
				</div>
				<div id="tab1" class="tabson">
					<form action="addGrade" method="post">
						<ul class="formInfo">
							<li>
								<label>课程名称</label>
								<div class="vocation">
									<select class="select" name="course_id">
										<c:forEach var="course" items="${courseList}">
											<option value="${course.getCourse_id()}">${course.getCourse_name()}</option>
										</c:forEach>
									</select>
								</div>
							</li>
							<li><label>学号</label><input type="text" name="student_id" value=""/></li>
							<li><label>成绩</label><input type="text" name="grade"/></li>
							<li><label>&nbsp;</label><input type="submit" value="上传成绩" class="btn" /></li>
						</ul>
					</form>
				</div>
				<div id="tab2" class="tabson">
					<table class="tableList">
    					<thead>
    						<tr>
    							<th>课程名称</th>
    							<th>操作</th>
    						</tr>
    					</thead>
    					<tbody>
    						<c:forEach var="course" items="${courseList}">
    							<tr>
    								<td>${course.getCourse_name()}</td>
    								<td><a href="getStudentGrade?course_id=${course.getCourse_id()}" class="tableLink">查看</a></td>
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