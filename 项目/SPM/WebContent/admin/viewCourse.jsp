<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="admin/css/style.css"/>
<script src="admin/js/jquery.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<c:set var="page" value="${requestScope.page}"/>
	<c:set var="totalCourse" value="${requestScope.totalCourse}"/>
	<c:set var="totalPage" value="${requestScope.totalPage}"/>
	<c:set var="start" value="${requestScope.start}"/>
	<c:set var="end" value="${requestScope.end}"/>
	<c:set var="list" value="${requestScope.courseList.subList(start,end)}"/>
	<div class="place">
    	<span>位置：</span>
   		<ul class="placeul">
    		<li><a href="viewCourse?page=1">查看课程</a></li>
    	</ul>
    </div>
    <div class="rightInfo">
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
    			<c:forEach var="course" items="${list}">
    				<tr>
    					<td>${course.getCourse_name()}</td>
    					<td>${course.getTeacher()}</td>
    					<td>${course.getBuilding()}${course.getRoom()}</td>
    					<td>${course.getDay()}${course.getTime()}</td>
    					<td><a href="setCourse?id=${course.getCourse_id()}" class="tableLink">修改</a> <a href="deleteCourse?id=${course.getCourse_id()}" class="tableLink">删除</a></td>
    				</tr>
    			</c:forEach>
    		</tbody>
    	</table>
    	<div class="page">
    		<div class="message">共<i>${totalCourse}</i>条记录，当前显示第<i>${page}</i>页</div>
    		<ul class="pageList">
    			<li class="pageItem"><a href="<c:url value='viewCourse?page=${page-1>1?page-1:1}'/>"><span class="pagePre">&laquo;</span></a></li>
    			<c:forEach begin="1" end="${totalPage}" varStatus="loop">
    				<c:choose>
    					<c:when test="${loop.index==page}">
    						<li class="pageItem current"><a>${loop.index}</a></li>
    					</c:when>
    					<c:otherwise>
    						<li class="pageItem"><a href="<c:url value='viewCourse?page=${loop.index}'/>">${loop.index}</a></li>
    					</c:otherwise>
    				</c:choose>
				</c:forEach>
    			<li class="pageItem"><a href="<c:url value='viewCourse?page=${page+1<totalPage?page+1:totalPage}'/>"><span class="pageNext">&raquo;</span></a></li>
    		</ul>
    	</div>
    </div>
    <script type="text/javascript">
		$('.tableList tbody tr:odd').addClass('odd');
	</script>
</body>
</html>