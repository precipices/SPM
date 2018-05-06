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
<script src="admin/js/jquery.idTabs.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<c:set var="page1" value="${requestScope.page1}"/>
	<c:set var="totalTeacher" value="${requestScope.totalTeacher}"/>
	<c:set var="totalPage1" value="${requestScope.totalPage1}"/>
	<c:set var="start1" value="${requestScope.start1}"/>
	<c:set var="end1" value="${requestScope.end1}"/>
	<c:set var="page2" value="${requestScope.page2}"/>
	<c:set var="totalStudent" value="${requestScope.totalStudent}"/>
	<c:set var="totalPage2" value="${requestScope.totalPage2}"/>
	<c:set var="start2" value="${requestScope.start2}"/>
	<c:set var="end2" value="${requestScope.end2}"/>
	<c:set var="teacherList" value="${requestScope.teacherList.subList(start1,end1)}"/>
	<c:set var="studentList" value="${requestScope.studentList.subList(start2,end2)}"/>
	<div class="place">
    	<span>位置：</span>
   		<ul class="placeul">
    		<li><a href="#">查看用户</a></li>
    	</ul>
   	</div>
   	<div id="usual" class="usual">
		<div class="itab">
			<ul>
				<li><a href="#tab1" id="a1" class="selected">教师用户</a></li>
				<li><a href="#tab2" id="a2">学生用户</a></li>
			</ul>
		</div>
		<div id="tab1" class="tabson">
			<div class="rightInfo">
    			<table class="tableList">
    				<thead>
    					<tr>
    						<th>教师编号</th>
    						<th>教师姓名</th>
    						<th>性别</th>
    						<th>年龄</th>
    						<th>操作</th>
    					</tr>
    				</thead>
    				<tbody>
    					<c:forEach var="teacher" items="${teacherList}">
    						<tr>
    							<td>${teacher.getTeacher_id()}</td>
    							<td>${teacher.getTeacher_name()}</td>
    							<td>${teacher.getSex()}</td>
    							<td>${teacher.getAge()}</td>
    							<td><a href="" class="tableLink">查看</a> <a href="" class="tableLink">删除</a></td>
    						</tr>
    					</c:forEach>
    				</tbody>
    			</table>
    			<div class="page">
    				<div class="message">共<i>${totalTeacher}</i>条记录，当前显示第<i>${page1}</i>页</div>
    				<ul class="pageList">
    					<li class="pageItem"><a href="<c:url value='viewUser?page1=${page1-1>1?page1-1:1}'/>"><span class="pagePre">&laquo;</span></a></li>
    					<c:forEach begin="1" end="${totalPage1}" varStatus="loop">
    						<c:choose>
    							<c:when test="${loop.index==page1}">
    								<li class="pageItem current"><a>${loop.index}</a></li>
    							</c:when>
    							<c:otherwise>
    								<li class="pageItem"><a href="<c:url value='viewUser?page1=${loop.index}'/>">${loop.index}</a></li>
    							</c:otherwise>
    						</c:choose>
						</c:forEach>
    					<li class="pageItem"><a href="<c:url value='viewUser?page1=${page1+1<totalPage1?page1+1:totalPage1}'/>"><span class="pageNext">&raquo;</span></a></li>
    				</ul>
    			</div>
    		</div>
		</div>
		<div id="tab2" class="tabson">
			<div class="rightInfo">
    			<table class="tableList">
    				<thead>
    					<tr>
    						<th>学号</th>
    						<th>学生姓名</th>
    						<th>性别</th>
    						<th>年龄</th>
    						<th>院系</th>
    						<th>操作</th>
    					</tr>
    				</thead>
    				<tbody>
    					<c:forEach var="student" items="${studentList}">
    						<tr>
    							<td>${student.getStudent_id()}</td>
    							<td>${student.getStudent_name()}</td>
    							<td>${student.getSex()}</td>
    							<td>${student.getAge()}</td>
    							<td>${student.getSdept()}</td>
    							<td><a href="" class="tableLink">查看</a> <a href="" class="tableLink">删除</a></td>
    						</tr>
    					</c:forEach>
    				</tbody>
    			</table>
    			<div class="page">
    				<div class="message">共<i>${totalStudent}</i>条记录，当前显示第<i>${page2}</i>页</div>
    				<ul class="pageList">
    					<li class="pageItem"><a href="<c:url value='viewUser?page2=${page2-1>1?page2-1:1}'/>"><span class="pagePre">&laquo;</span></a></li>
    					<c:forEach begin="1" end="${totalPage2}" varStatus="loop">
    						<c:choose>
    							<c:when test="${loop.index==page2}">
    								<li class="pageItem current"><a>${loop.index}</a></li>
    							</c:when>
    							<c:otherwise>
    								<li class="pageItem"><a href="<c:url value='viewUser?page2=${loop.index}'/>">${loop.index}</a></li>
    							</c:otherwise>
    						</c:choose>
						</c:forEach>
    					<li class="pageItem"><a href="<c:url value='viewUser?page2=${page2+1<totalPage2?page2+1:totalPage2}'/>"><span class="pageNext">&raquo;</span></a></li>
    				</ul>
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