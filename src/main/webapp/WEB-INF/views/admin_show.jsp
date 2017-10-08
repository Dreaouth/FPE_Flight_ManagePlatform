<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="${APP_PATH}/package/css/H-ui.css" />
<link type="text/css" rel="stylesheet" href="${APP_PATH}/package/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
<link type="text/css" rel="stylesheet"
	href="${APP_PATH}/package/font/font-awesome.min.css" />
<title>Insert title here</title>
<title>管理员列表</title>
</head>
<body>
<%
	String check = (String) request.getAttribute("check");
	if (check.equals("add")) {
%>
<script type="text/javascript">
    alert("添加成功！");
</script>
<%
} else if (check.equals("update")) {
%>
<script type="text/javascript">
    alert("修改成功！");
</script>
<%}%>
<script type="text/javascript">
		function check() {
			var adminname = document.forms[0].name.value;//获取用户名所填的内容
			var newpassword = document.forms[0].password.value;//获取所填的密码
			var newpassword2 = document.forms[0].email.value;//获取用户名所填的内容
			if (adminname == "") {
				alert("错误提示：用户名不能为空！");
				return false;
			}
			if (newpassword == "") {
				alert("错误提示：密码不能为空！");
				return false;
			}
			if (newpassword2 == "") {
				alert("错误提示：邮箱不能为空！");
				return false;
			}
		}
	</script>
	<nav class="Hui-breadcrumb"> <i class="icon-home"></i> 首页 <span
		class="c-gray en">&gt;</span> 用户管理 <span class="c-gray en">&gt;</span>
	管理员列表 <a class="btn btn-success radius r mr-20"
		style="line-height: 1.6em; margin-top: 3px"
		href="queryAdmin" title="刷新"><i
		class="icon-refresh"></i></a></nav>
				<br>
	<div class="pd-20">
		<div class="text-c">
			<form action="insertAdmin" method="post"  onsubmit="return check()">
				<strong>增加管理员：</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：
				<input type="text" class="input-text" style="width: 180px"
					   placeholder="输入用户名" id="name" name="name">&nbsp;&nbsp;&nbsp;密码：
				<input type="text" class="input-text" style="width: 180px"
					   placeholder="输入密码" id="password" name="password">&nbsp;&nbsp;&nbsp;邮箱
				<input type="text" class="input-text" style="width: 180px"
					   placeholder="输入邮箱" id="email" name="email">&nbsp;&nbsp;&nbsp;权限
				<select class="select" id="permission" name="permission">
					<option value="admin">超级管理员</option>
					<option value="user">普通管理员</option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;
				<button type="submit" class="btn btn-success">
					<i class="icon-search"></i> 提交
				</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;
			</form>

		</div>
		<br> <br>
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="7">管理员列表</th>
				</tr>
				<tr class="text-c">
					<th width="40">ID</th>
					<th width="150">用户名</th>
					<th width="250">密码</th>
					<th width="150">邮箱</th>
					<th width="150">权限</th>
					<th width="70">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${adminlist}" var="temp">
					<tr class="text-c">
						<td>${temp.id}</td>
						<td>${temp.name}</td>
						<td>${temp.password}</td>
						<td>${temp.email}</td>
						<td>${temp.permission}</td>
						<td class="f-14 admin-manage"><a title="编辑"
							href="javascript:;"
							onClick="admin_permission_edit('23','751','','修改管理员信息','update?id=${temp.id}&name=${temp.name}&password=${temp.password}&email=${temp.email}&permission=${temp.permission}')"
							class="ml-5" style="text-decoration: none"><i
								class="icon-edit"></i></a> <a title="删除" href="javascript:;"
							onClick="admin_del(this,'${temp.id}')" class="ml-5"
							style="text-decoration: none"><i class="icon-trash"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript" src="${APP_PATH}/package/js/jquery.min.js"></script>
	<script type="text/javascript" src="${APP_PATH}/package/layer/layer.min.js"></script>
	<script type="text/javascript" src="${APP_PATH}/package/js/pagenav.cn.js"></script>
	<script type="text/javascript" src="${APP_PATH}/package/js/H-ui.js"></script>
	<script type="text/javascript"
		src="${APP_PATH}/package/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${APP_PATH}/package/js/H-ui.admin.js"></script>
	<script type="text/javascript">
		var req;
		window.onload = function() {
		}
		function admin_del(obj, id) {
			layer.confirm('确认删除该管理员吗 ', function(index) {
				if (window.XMLHttpRequest) {
					req = new XMLHttpRequest();
				} else if (window.ActiveXObject) {
					req = new ActiveXObject("Microsoft.XMLHTTP");
				}
				if (req) {
					req.open("POST", "deleteAdmin", true);
					req.setRequestHeader("Content-Type",
							"application/x-www-form-urlencoded");
					req.onreadystatechange = callback;
					req.send("sta_id=" + id);
				}
				$(obj).parents("tr").remove();
				layer.msg('已删除!', 1);
			});
		}
		function callback() {
			if (req.readyState == 4) {
				if (req.status == 200) {
					parseMessage();
				} else {
					// alert("Not able to retrieve description" + req.statusText);
				}
			}
		}
		function parseMessage() {
		}
	</script>
</body>
</html>