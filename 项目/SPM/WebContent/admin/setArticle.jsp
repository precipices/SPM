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
<script src="admin/editor/kindeditor.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    KE.show({
       	id : 'content',
       	cssPath : './index.css'
    });
</script>
<script type="text/javascript">
	$(document).ready(function(e) {
    	$(".select1").uedSelect({
			width : 345
		});
	});
</script>
</head>
<body>
	<c:set var="title" value="${requestScope.title}"/>
	<c:set var="module_id" value="${requestScope.module_id}"/>
	<c:set var="content" value="${requestScope.content}"/>
	<c:set var="list" value="${requestScope.moduleList}"/>
	<div class="place">
    	<span>位置：</span>
   		<ul class="placeul">
    		<li><a href="#">修改文章</a></li>
    	</ul>
   	</div>
   	<div class="formBody">
    	<div>
    		<div class="tabson" id="tab">
    			<div class="messText">您好，<b>admin</b>，欢迎使用后台信息管理系统！</div>
    			<form action="setArticle" method="post">
    				<ul class="formInfo">
    					<li><label>文章标题</label><input type="text" name="title" value="${title}" class="input1"/></li>
    					<li>
    						<label>所属模块</label>
    						<div class="vocation1">
    							<select class="select1" name="module">
    								<c:forEach var="module" items="${list}">
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
    					</li>
    					<li>
    						<label>文章内容</label>
    						<textarea id="content" name="content" style="width:700px;height:250px;visibility:hidden;">${content}</textarea>
    					</li>
    					<li><label>&nbsp;</label><input type="submit" value="提交" class="btn" /></li>
    				</ul>
    			</form>
    		</div>
    	</div>
    </div>
</body>
</html>