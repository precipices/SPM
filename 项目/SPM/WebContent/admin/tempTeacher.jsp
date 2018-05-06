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
	<c:set var="totalTeacher" value="${requestScope.totalTeacher}"/>
	<c:set var="totalPage" value="${requestScope.totalPage}"/>
	<c:set var="start" value="${requestScope.start}"/>
	<c:set var="end" value="${requestScope.end}"/>
	<c:set var="list" value="${requestScope.teacherList.subList(start,end)}"/>
	<div class="place">
    	<span>位置：</span>
   		<ul class="placeul">
    		<li><a href="getTempTeacher?page=1">审核注册</a></li>
    	</ul>
    </div>
    <div class="rightInfo">
    	<table class="tableList">
    		<thead>
    			<tr>
    				<th>教师编号</th>
    				<th>教师姓名</th>
    				<th>操作</th>
    			</tr>
    		</thead>
    		<tbody>
    			<c:forEach var="teacher" items="${list}">
    				<tr>
    					<td>${teacher.getTeacher_id()}</td>
    					<td>${teacher.getTeacher_name()}</td>
    					<td><a href="addTeacher?teacher_id=${teacher.getTeacher_id()}" class="tableLink">通过</a> <a href="deleteTeacherTemp?teacher_id=${teacher.getTeacher_id()}" class="tableLink">删除</a></td>
    				</tr>
    			</c:forEach>
    		</tbody>
    	</table>
    	<div class="page">
    		<div class="message">共<i>${totalTeacher}</i>条记录，当前显示第<i>${page}</i>页</div>
    		<ul class="pageList">
    			<li class="pageItem"><a href="<c:url value='getTempTeacher?page=${page-1>1?page-1:1}'/>"><span class="pagePre">&laquo;</span></a></li>
    			<c:forEach begin="1" end="${totalPage}" varStatus="loop">
    				<c:choose>
    					<c:when test="${loop.index==page}">
    						<li class="pageItem current"><a>${loop.index}</a></li>
    					</c:when>
    					<c:otherwise>
    						<li class="pageItem"><a href="<c:url value='getTempTeacher?page=${loop.index}'/>">${loop.index}</a></li>
    					</c:otherwise>
    				</c:choose>
				</c:forEach>
    			<li class="pageItem"><a href="<c:url value='getTempTeacher?page=${page+1<totalPage?page+1:totalPage}'/>"><span class="pageNext">&raquo;</span></a></li>
    		</ul>
    	</div>
    </div>
    <script type="text/javascript">
		$('.tableList tbody tr:odd').addClass('odd');
	</script>
</body>
</html>