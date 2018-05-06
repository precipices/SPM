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
	<c:set var="list" value="${requestScope.moduleList}"/>
	<div class="place">
    	<span>位置：</span>
   		<ul class="placeul">
    		<li><a href="addArticle">添加文章</a></li>
    	</ul>
   	</div>
   	<div class="formBody">
    	<div>
    		<div class="tabson" id="tab">
    			<div class="messText">您好，<b>admin</b>，欢迎使用后台信息管理系统！</div>
    			<form action="addArticle" method="post">
    				<ul class="formInfo">
    					<li><label>文章标题</label><input type="text" name="title" value="请填写文章标题" class="input1" onclick="JavaScript:this.value=''" /></li>
    					<li>
    						<label>所属模块</label>
    						<div class="vocation1">
    							<select class="select1" name="module">
    								<c:forEach var="module" items="${list}">
    									<option value="${module.getId()}">${module.getModule()}</option>
    								</c:forEach>
    							</select>
    						</div>
    					</li>
    					<li>
    						<label>文章内容</label>
    						<textarea id="content" name="content" style="width:700px;height:250px;visibility:hidden;"></textarea>
    					</li>
    					<li><label>&nbsp;</label><input type="submit" value="提交" class="btn" /></li>
    				</ul>
    			</form>
    		</div>
    	</div>
    </div>
</body>
</html>