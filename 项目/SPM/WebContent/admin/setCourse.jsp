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
<script src="admin/js/select-ui.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
    	$(".select1").uedSelect({
			width : 345
		});
    	$(".select2").uedSelect({
			width : 167
		});
	});
</script>
</head>
<body>
	<c:set var="course_name" value="${requestScope.course_name}"/>
	<c:set var="teacher_id" value="${requestScope.teacher_id}"/>
	<c:set var="building_id" value="${requestScope.building_id}"/>
	<c:set var="room_id" value="${requestScope.room_id}"/>
	<c:set var="day_id" value="${requestScope.day_id}"/>
	<c:set var="time_id" value="${requestScope.time_id}"/>
	<c:set var="list" value="${requestScope.teacherList}"/>
	<c:set var="buildingList" value="${requestScope.buildingList}"/>
	<c:set var="roomList" value="${requestScope.roomList}"/>
	<c:set var="dayList" value="${requestScope.dayList}"/>
	<c:set var="timeList" value="${requestScope.timeList}"/>
	<div class="place">
    	<span>位置：</span>
   		<ul class="placeul">
    		<li><a href="#">修改课程</a></li>
    	</ul>
    </div>
    <div class="formBody">
    	<div>
    		<div class="tabson" id="tab">
    			<div class="messText">您好，<b>admin</b>，欢迎使用后台信息管理系统！</div>
    			<form action="setCourse" method="post">
    				<ul class="formInfo">
    					<li><label>课程名称</label><input type="text" name="course_name" value="${course_name}" class="input1"/></li>
    					<li>
    						<label>任课教师</label>
    						<div class="vocation1">
    							<select class="select1" name="teacher">
    								<c:forEach var="teacher" items="${list}">
    									<c:choose>
    										<c:when test="${teacher.getTeacher_id()==teacher_id}">
    											<option value="${teacher.getTeacher_id()}" selected="selected">${teacher.getTeacher_name()}</option>
    										</c:when>
    										<c:otherwise>
    											<option value="${teacher.getTeacher_id()}">${teacher.getTeacher_name()}</option>
    										</c:otherwise>
    									</c:choose>
    								</c:forEach>
    							</select>
    						</div>
    					</li>
    					<li>
    						<label>上课地点</label>
    						<div class="vocation2">
    							<div class="left">
    								<select class="select2" name="building">
    									<c:forEach var="building" items="${buildingList}">
    										<c:choose>
    											<c:when test="${building.getId()==building_id}">
    												<option value="${building.getId()}" selected="selected">${building.getBuilding()}</option>
    											</c:when>
    											<c:otherwise>
    												<option value="${building.getId()}">${building.getBuilding()}</option>
    											</c:otherwise>
    										</c:choose>
    									</c:forEach>
    								</select>
    							</div>
    							<div class="right">
    								<select class="select2" name="room">
    									<c:forEach var="room" items="${roomList}">
    										<c:choose>
    											<c:when test="${room.getId()==room_id}">
    												<option value="${room.getId()}" selected="selected">${room.getRoom()}</option>
    											</c:when>
    											<c:otherwise>
    												<option value="${room.getId()}">${room.getRoom()}</option>
    											</c:otherwise>
    										</c:choose>
    									</c:forEach>
    								</select>
    							</div>
    						</div>
    					</li>
    					<li>
    						<label>上课时间</label>
    						<div class="vocation2">
    							<div class="left">
    								<select class="select2" name="day">
    									<c:forEach var="day" items="${dayList}">
    										<c:choose>
    											<c:when test="${day.getId()==day_id}">
    												<option value="${day.getId()}" selected="selected">${day.getDay()}</option>
    											</c:when>
    											<c:otherwise>
    												<option value="${day.getId()}">${day.getDay()}</option>
    											</c:otherwise>
    										</c:choose>
    									</c:forEach>
    								</select>
    							</div>
    							<div class="right">
    								<select class="select2" name="time">
    									<c:forEach var="time" items="${timeList}">
    										<c:choose>
    											<c:when test="${time.getId()==day_id}">
    												<option value="${time.getId()}" selected="selected">${time.getTime()}</option>
    											</c:when>
    											<c:otherwise>
    												<option value="${time.getId()}">${time.getTime()}</option>
    											</c:otherwise>
    										</c:choose>
    									</c:forEach>
    								</select>
    							</div>
    						</div>
    					</li>
    					<li><label>&nbsp;</label><input type="submit" value="提交" class="btn" /></li>
    				</ul>
    			</form>
    		</div>
    	</div>
    </div>
</body>
</html>