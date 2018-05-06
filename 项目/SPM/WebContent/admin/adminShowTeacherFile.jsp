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
    	<br/>
    	<table class="tableList">
    		<thead>
    			<tr>
    				<th>文件名</th>
    				<th>操作</th>
    			</tr>
    		</thead>
    		<tbody>
    			<c:forEach var="filename" items="${checkedList}">
					<c:url var="down" value="/DownloadServlet">
						<c:param name="filename" value="${filename}" />
						<c:param name="filePath" value="${teacherName}${'/已通过/'}${filename}" />
					</c:url>
					<c:url var="del" value="/DeleteFileServlet">
						<c:param name="filename" value="${filename}" />
						<c:param name="filePath" value="${teacherName}${'/已通过/'}${filename}" />
					</c:url>
					<tr>
						<td>${filename}</td>
						<td>
						<a href="${down}" target="_blank">下载</a>
						<a href="${del}" target="_blank">移除</a>
						</td>
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