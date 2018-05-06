<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
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
			<h3>已通过文件:</h3>
			<table class="tableList">
				<thead>
					<tr>
						<th>文件名</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="filename" items="${checkedList}">
						<c:url var="del" value="/DeleteFileServlet">
							<c:param name="filename" value="${filename}" />
							<c:param name="filePath" value="${teacherName}${'/已通过/'}${filename}" />
						</c:url>
						<c:url var="down" value="/DownloadServlet">
							<c:param name="filename" value="${filename}" />
							<c:param name="filePath" value="${teacherName}${'/已通过/'}${filename}" />
						</c:url>
						<tr>
							<td>${filename}</td>
							<td>
								<a href="${del}" target="_blank">删除</a>
								<a href="${down}" target="_blank">下载</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<h3>待审核文件:</h3>
			<table class="tableList">
				<thead>
					<tr>
						<th>文件名</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="filename" items="${uncheckedList}">
						<c:url var="del" value="/DeleteFileServlet">
							<c:param name="filename" value="${filename}" />
							<c:param name="filePath" value="${teacherName}${'/待审核/'}${filename}" />
						</c:url>
						<tr>
							<td>${filename}</td>
							<td><a href="${del}">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br/><br/><br/>
			<table>
				<form action="${pageContext.request.contextPath}/UploadServlet" enctype="multipart/form-data" method="post">
					<tr>
						<td>上传文件：</td>
						<td><input type="file" name="uploadFile" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="上传" /></td>
						<td><input type="reset" value="重置" /></td>
					</tr>
				</form>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$('.tableList tbody tr:odd').addClass('odd');
	</script>
</body>
</html>