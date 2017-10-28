<%@page import="java.util.jar.Attributes.Name"%>
<%@page import="com.dreaouth.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html style="overflow-y: hidden;">
<% pageContext.setAttribute("APP_PATH",request.getContextPath()); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="package/css/H-ui.css" rel="stylesheet" type="text/css" />
<link href="package/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="package/font/font-awesome.min.css" type="text/css"
	rel="stylesheet" />
<title>航班信息系统主页面</title>
</head>
<body>
	<%
		User a = (User) request.getAttribute("users");
		String permission="";
		if (a.getPermission().equals("admin")){
		    permission="超级管理员";
		}else {
		    permission="普通管理员";
		}
		String title = permission + "：" + a.getName();
		String status = a.getPermission();
	%>
	<header class="Hui-header cl">
		<a class="Hui-logo l" title="H-ui.admin v2.1" href="welcome.jsp">中国航空客户服务系统后台管理系统</a>
		<a class="Hui-logo-m l" href="welcome.jsp" title="H-ui.admin">my12306</a>
		<span class="Hui-subtitle l">V1.0</span> <span class="Hui-userbox"><span
			class="c-white"><%=title%></span> <a
			class="btn btn-danger radius ml-10" href="login.jsp" title="退出"><i
				class="icon-off"></i> 退出</a></span> <a aria-hidden="false"
			class="Hui-nav-toggle" id="nav-toggle" href="#"></a>
	</header>
	<div class="cl Hui-main">
		<aside class="Hui-aside" style="">
			<input runat="server" id="divScrollValue" type="hidden" value="" />
			<div class="menu_dropdown bk_2">
				<dl id="menu-user">
					<dt>
						<i class="icon-user"></i> 基础数据<b></b>
					</dt>
					<dd>
						<ul>
							<li>
								<%
									if (status.compareTo("admin") == 0 || status.compareTo("user") == 0) {
								%><a _href="plane/queryPlane"> <%
 	} else {
 %> <a _href="forbid"> <%
 	}
 %>航班管理
								</a>
							</li>
							<li>
								<%
									if (status.compareTo("admin") == 0 || status.compareTo("user") == 0) {
								%><a _href="passenger/queryPassenger"> <%
 	} else {
 %> <a _href="forbid"> <%
 	}
 %>乘客管理
								</a>
							</li>
							<li>
								<%
									if (status.compareTo("admin") == 0 || status.compareTo("user") == 0) {
								%><a _href="city/queryCity"> <%
 	} else {
 %> <a _href="forbid.jsp"> <%
 	}
 %>机场管理
								</a>
							</li>
							<li>
								<%
									if (status.compareTo("admin") == 0 || status.compareTo("user") == 0) {
								%><a _href="company/queryCompany"> <%
 	} else {
 %> <a _href="forbid.jsp"> <%
 	}
 %>航空公司管理
								</a>
							</li>
						</ul>
					</dd>
				</dl>
				<dl id="menu-comments">
					<dt>
						<i class="icon-comments"></i> 加密展示<b></b>
					</dt>
					<dd>
						<ul>
							<li>
								<%
									if (status.compareTo("admin") == 0) {
								%><a _href="encrypt/Passenger"> <%
 	} else {
 %> <a _href="forbid.jsp"> <%
 	}
 %>乘客信息
								</a>
							</li>
							<li>
								<%
									if (status.compareTo("admin") == 0) {
								%><a _href="encrypt/Plane"> <%
 	} else {
 %> <a _href="forbid.jsp"> <%
 	}
 %>航班信息
								</a>
							</li>
						</ul>
					</dd>
				</dl>
				<dl id="menu-product">
					<dt>
						<i class="icon-beaker"></i> 用户管理<b></b>
					</dt>
					<dd>
						<ul>
							<li>
								<%
									if (status.compareTo("admin") == 0) {
								%><a _href="admin/queryAdmin"> <%
 	} else {
 %> <a _href="forbid"> <%
 	}
 %>用户管理
								</a>
							</li>
						</ul>
					</dd>
				</dl>
			</div>
		</aside>
		<div class="dislpayArrow">
			<a class="pngfix" href="javascript:void(0);"></a>
		</div>
		<section class="Hui-article">
			<div id="Hui-tabNav" class="Hui-tabNav">
				<div class="Hui-tabNav-wp">
					<ul id="min_title_list" class="acrossTab cl">
						<li class="active"><span title="我的桌面"
							data-href="welcome.html">欢迎访问</span><em></em></li>
					</ul>
				</div>
				<div class="Hui-tabNav-more btn-group">
					<a id="js-tabNav-prev" class="btn radius btn-default btn-small"
						href="javascript:;"><i class="icon-step-backward"></i></a><a
						id="js-tabNav-next" class="btn radius btn-default btn-small"
						href="javascript:;"><i class="icon-step-forward"></i></a>
				</div>
			</div>
			<div id="iframe_box" class="Hui-articlebox">
				<div class="show_iframe">
					<div style="display: none" class="loading"></div>
					<iframe scrolling="yes" frameborder="0" src="load"></iframe>
				</div>
			</div>
		</section>
	</div>
	<script type="text/javascript" src="package/js/jquery.min.js"></script>
	<script type="text/javascript" src="package/js/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript" src="package/layer/layer.min.js"></script>
	<script type="text/javascript" src="package/js/H-ui.js"></script>
	<script type="text/javascript" src="package/js/H-ui.admin.js"></script>
</body>
</html>