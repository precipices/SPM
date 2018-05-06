<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="admin/css/style.css"/>
<script src="admin/js/jquery.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<div class="place">
    	<span>位置：</span>
   		<ul class="placeul">
    		<li><a href="#">文件审核</a></li>
    	</ul>
    </div>
    <div class="rightInfo">
    	<h3>待审核文件:</h3>
    	<br/>
    	<table class="tableList">
    		<thead>
    			<tr>
    				<th>文件名</th>
    				<th>上传者</th>
    				<th>操作</th>
    			</tr>
    		</thead>
    		<tbody>
    			<c:forEach var="entry" items="${teacherUncheckedMap}">
					<c:forEach var="filename" items="${entry.value}">
						<c:url var="down" value="/DownloadServlet">
							<c:param name="filename" value="${filename}" />
							<c:param name="filePath" value="${entry.key}${'/待审核/'}${filename}" />
						</c:url> 
						<c:url var="del" value="/DeleteFileServlet">
							<c:param name="filename" value="${filename}" />
							<c:param name="filePath" value="${entry.key}${'/待审核/'}${filename}" />
						</c:url>
						<c:url var="agree" value="/UploadAgreeServlet">
							<c:param name="filename" value="${filename}" />
							<c:param name="teacherName" value="${entry.key}" />
						</c:url>
						<tr>
							<td>${filename}</td>
							<td>${entry.key}</td>
							<td>
								<a href="${down}" target="_blank">下载</a>
								<a href="${agree}" target="_blank">通过</a>
								<a href="${del}" target="_blank">拒接</a>
							</td>
						</tr>
					</c:forEach>
				</c:forEach>
    		</tbody>
    	</table>
    	<br/>
    	<br/>
    	<h3>已通过文件:</h3>
    	<br/>
    	<table class="tableList">
			<thead>
				<tr>
					<th>教师姓名</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="teacherName" items="${teachers}">
					<c:url var="showTeacher" value="/ShowTeacherFileServlet">
						<c:param name="userType" value="admin" />
						<c:param name="teacherName" value="${teacherName}" />
					</c:url>
					<tr>
						<td>${teacherName}</td>
						<td><a href="${showTeacher}">查看</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
    </div>
    <script type="text/javascript">
		$('.tableList tbody tr:odd').addClass('odd');
	</script>
</body>
</html>