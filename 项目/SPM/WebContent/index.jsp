<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>软件项目管理在线学习网站</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<c:set var="username" value="${sessionScope.username}"/>
	<c:set var="userType" value="${sessionScope.userType}"/>
	<c:set var="list1" value="${requestScope.list1}"/>
	<c:set var="list2" value="${requestScope.list2}"/>
	<c:set var="list3" value="${requestScope.list3}"/>
	<c:set var="list4" value="${requestScope.list4}"/>
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
			<div class="module">
				<div class="title">
					<a>课程介绍</a>
					<a href="moduleDetail?module_id=1" style="font-size:12px;font-weight:normal;float:right;">更多</a>
				</div>
				<div>
					<div>
						<table width="100%" cellpadding="0" cellspacing="0">
							<c:forEach var="article" items="${list1}">
								<tr>
                        			<td width="10" align="center">
                        				<img src="img/index/dot.gif" />
                        			</td>
                        			<td class="newsListStyle">
                            			<table width="100%" cellpadding="0" cellspacing="0" border="0">
                            				<tr>
                            					<td align="left">
                            						<a href="articleDetail?article_id=${article.getArticle_id()}">${article.getTitle()}</a>
                            					</td>
                            					<td width="50" align="right">
                            						<div style="white-space:nowrap">${article.getAdd_time()}</div>
                            					</td>
                            				</tr>
                            			</table>
                        			</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="module">
				<div class="title">
					<a>课程内容</a>
					<a href="moduleDetail?module_id=2" style="font-size:12px;font-weight:normal;float:right;">更多</a>
				</div>
				<div>
					<div>
						<table width="100%" cellpadding="0" cellspacing="0">
							<c:forEach var="article" items="${list2}">
								<tr>
                        			<td width="10" align="center">
                        				<img src="img/index/dot.gif" />
                        			</td>
                        			<td class="newsListStyle">
                            			<table width="100%" cellpadding="0" cellspacing="0" border="0">
                            				<tr>
                            					<td align="left">
                            						<a href="articleDetail?article_id=${article.getArticle_id()}">${article.getTitle()}</a>
                            					</td>
                            					<td width="50" align="right">
                            						<div style="white-space:nowrap">${article.getAdd_time()}</div>
                            					</td>
                            				</tr>
                            			</table>
                        			</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="module">
				<div class="title">
					<a>课程实践</a>
					<a href="moduleDetail?module_id=3" style="font-size:12px;font-weight:normal;float:right;">更多</a>
				</div>
				<div>
					<div>
						<table width="100%" cellpadding="0" cellspacing="0">
							<c:forEach var="article" items="${list3}">
								<tr>
                        			<td width="10" align="center">
                        				<img src="img/index/dot.gif" />
                        			</td>
                        			<td class="newsListStyle">
                            			<table width="100%" cellpadding="0" cellspacing="0" border="0">
                            				<tr>
                            					<td align="left">
                            						<a href="articleDetail?article_id=${article.getArticle_id()}">${article.getTitle()}</a>
                            					</td>
                            					<td width="50" align="right">
                            						<div style="white-space:nowrap">${article.getAdd_time()}</div>
                            					</td>
                            				</tr>
                            			</table>
                        			</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="module">
				<div class="title">
					<a>教学团队</a>
					<a href="moduleDetail?module_id=4" style="font-size:12px;font-weight:normal;float:right;">更多</a>
				</div>
				<div>
					<div>
						<table width="100%" cellpadding="0" cellspacing="0">
							<c:forEach var="article" items="${list4}">
								<tr>
                        			<td width="10" align="center">
                        				<img src="img/index/dot.gif" />
                        			</td>
                        			<td class="newsListStyle">
                            			<table width="100%" cellpadding="0" cellspacing="0" border="0">
                            				<tr>
                            					<td align="left">
                            						<a href="articleDetail?article_id=${article.getArticle_id()}">${article.getTitle()}</a>
                            					</td>
                            					<td width="50" align="right">
                            						<div style="white-space:nowrap">${article.getAdd_time()}</div>
                            					</td>
                            				</tr>
                            			</table>
                        			</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>