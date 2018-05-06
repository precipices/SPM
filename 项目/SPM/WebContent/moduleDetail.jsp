<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${module}</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<c:set var="module" value="${requestScope.module}"/>
	<c:set var="articleList" value="${requestScope.articleList}"/>
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
			<div class="title" style="text-align:center;">
				<a>${module}</a>
			</div>
			<div>
				<div>
					<table width="100%" cellpadding="0" cellspacing="0">
						<c:forEach var="article" items="${articleList}">
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
</body>
</html>