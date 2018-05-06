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
<script src="admin/js/select-ui.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select3").uedSelect({
			width : 100
		});
	});
</script>
</head>
<body>
	<c:set var="page" value="${requestScope.page}"/>
	<c:set var="module_id" value="${requestScope.module_id}"/>
	<c:set var="totalArticle" value="${requestScope.totalArticle}"/>
	<c:set var="articlePerPage" value="${requestScope.articlePerPage}"/>
	<c:set var="totalPage" value="${requestScope.totalPage}"/>
	<c:set var="start" value="${requestScope.start}"/>
	<c:set var="end" value="${requestScope.end}"/>
	<c:set var="list" value="${requestScope.articleList.subList(start,end)}"/>
	<c:set var="moduleList" value="${requestScope.moduleList}"/>
	<div class="place">
    	<span>位置：</span>
   		<ul class="placeul">
    		<li><a href="viewArticle">查看文章</a></li>
    	</ul>
    </div>
    <form action="viewArticle" method="post">
    	<ul class="searchForm">
    		<li>
    			<label>模块</label>  
    			<div class="vocation3">
    				<select class="select3" id="module" name="module">
    					<option value="0">全部</option>
    					<c:forEach var="module" items="${moduleList}">
    						<c:choose>
    							<c:when test="${module.getId()==module_id}">
    								<option value="${module.getId()}" selected="selected">${module.getModule()}</option>
    							</c:when>
    							<c:otherwise>
    								<option value="${module.getId()}">${module.getModule()}</option>
    							</c:otherwise>
    						</c:choose>
    					</c:forEach>
    				</select>
    			</div>
    			<input type="hidden" name="page" id="page" value="1"/>
    		</li>
    		<li><label>&nbsp;</label><input type="submit" value="查询" class="scbtn" /></li>
    	</ul>
    	<div class="rightInfo">
    		<table class="tableList">
    			<thead>
    				<tr>
    					<th>文章标题</th>
    					<th>所属模块</th>
    					<th>发布时间</th>
    					<th>操作</th>
    				</tr>
    			</thead>
    			<tbody>
    				<c:forEach var="article" items="${list}">
    					<tr>
    						<td>${article.getTitle()}</td>
    						<td>${article.getModule()}</td>
    						<td>${article.getAdd_time()}</td>
    						<td><a href="setArticle?id=${article.getArticle_id()}" class="tableLink">修改</a> <a href="deleteArticle?id=${article.getArticle_id()}" class="tableLink">删除</a></td>
    					</tr>
    				</c:forEach>
    			</tbody>
    		</table>
    		<div class="page">
    			<div class="message">共<i>${totalArticle}</i>条记录，当前显示第<i>${page}</i>页</div>
    			<ul class="pageList">
    			<li class="pageItem"><a href="<c:url value='viewArticle?page=${page-1>1?page-1:1}&module=${module_id}'/>"><span class="pagePre">&laquo;</span></a></li>
    			<c:forEach begin="1" end="${totalPage}" varStatus="loop">
    				<c:choose>
    					<c:when test="${loop.index==page}">
    						<li class="pageItem current"><a>${loop.index}</a></li>
    					</c:when>
    					<c:otherwise>
    						<li class="pageItem"><a href="<c:url value='viewArticle?page=${loop.index}&module=${module_id}'/>">${loop.index}</a></li>
    					</c:otherwise>
    				</c:choose>
				</c:forEach>
    			<li class="pageItem"><a href="<c:url value='viewArticle?page=${page+1<totalPage?page+1:totalPage}&module=${module_id}'/>"><span class="pageNext">&raquo;</span></a></li>
    		</ul>
    		</div>
    	</div>
    </form>
    <script type="text/javascript">
		$('.tableList tbody tr:odd').addClass('odd');
	</script>
</body>
</html>