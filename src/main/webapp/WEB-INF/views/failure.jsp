<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="${APP_PATH}/package/css/H-ui.css" />
<link type="text/css" rel="stylesheet" href="${APP_PATH}/package/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
<link type="text/css" rel="stylesheet"
	href="${APP_PATH}/package/font/font-awesome.min.css" />
<title>404</title>
</head>
<%
	String value=(String) request.getAttribute("information");
%>
<body>
<nav class="Hui-breadcrumb"><i class="icon-home"></i>
错误 </nav>
<br><br><br><br><br><br><br>
<div align="center" class="text-c"><h3> <%=value%> </div>

<script type="text/javascript" src="${APP_PATH}/package/js/jquery.min.js"></script>
	<script type="text/javascript" src="${APP_PATH}/package/layer/layer.min.js"></script>
	<script type="text/javascript" src="${APP_PATH}/package/js/pagenav.cn.js"></script>
	<script type="text/javascript" src="${APP_PATH}/package/js/H-ui.js"></script>
	<script type="text/javascript"
		src="${APP_PATH}/package/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${APP_PATH}/package/js/H-ui.admin.js"></script>
</body>
</html>