<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script
            src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${APP_PATH}/package/css/H-ui.css"/>
    <link type="text/css" rel="stylesheet" href="${APP_PATH}/package/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css"
          href="http://cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
    <link type="text/css" rel="stylesheet"
          href="${APP_PATH}/package/font/font-awesome.min.css"/>
    <title>Insert title here</title>
</head>
<body>
<%
    String encrypt= (String) request.getAttribute("encrypt");
    String check = (String) request.getAttribute("check");
    if (check.equals("encrypt")) {
%>
<script type="text/javascript">
    alert("加密成功！");
</script>
<%
} else if (check.equals("decrypt")) {
%>
<script type="text/javascript">
    alert("解密成功！");
</script>
<%}%>
<nav class="Hui-breadcrumb">
    <i class="icon-home"></i> 首页 <span class="c-gray en">&gt;</span> 加密演示
    <span class="c-gray en">&gt;</span> 乘客管理 <a
        class="btn btn-success radius r mr-20"
        style="line-height: 1.6em; margin-top: 3px"
        href="Passenger" title="刷新"><i
        class="icon-refresh"></i></a>
</nav>
<div class="pd-20">
    <div class="text-c">
        <form action="selectPassenger" method="post">
            乘客查询：
            <select class="select" id="sel_Sub" name="sel_Sub" onChange="SetSubID(this);">
                <option value="0">根据乘客姓名</option>
                <option value="1">根据身份证号</option>
                >
            </select>
            <input type="text" class="input-text" style="width: 250px"
                   placeholder="输入姓名或身份证号" id="sta_name" name="sta_name">&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-success">
                <i class="icon-search"></i> 查询
            </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;<a href="encryptPassenger" class="btn btn-primary radius"><i
                class="icon-plus"></i> 执行<%=encrypt%></a>
        </form>

    </div>
    <div class="mt-20">
        <table id="page"
               class="table table-border table-bordered table-hover table-bg order_table">
            <thead>
            <tr class="text-c">
                <th width="100">姓名</th>
                <th width="50">性别</th>
                <th width="200">电话</th>
                <th width="200">身份证号</th>
                <th width="100">座位号</th>
                <th width="100">航班号</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${passengerlist}" var="temp">
                <tr class="text-c">
                    <td>${temp.name}</td>
                    <td>${temp.age}</td>
                    <td>${temp.tel}</td>
                    <td>${temp.card}</td>
                    <td>${temp.seat}</td>
                    <td>${temp.planeId}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="pageNav" class="pageNav"></div>
</div>
<script type="text/javascript" src="${APP_PATH}/package/layer/layer.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/package/js/pagenav.cn.js"></script>
<script type="text/javascript" src="${APP_PATH}/package/js/H-ui.js"></script>
<script type="text/javascript"
        src="${APP_PATH}/package/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/package/js/H-ui.admin.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('.order_table').DataTable({
            //开启搜索框
            "searching": true,
            //允许分页
            "paging": true,
            //左下角信息 showing 1 to 7 of 7entries
            "info": true,
            //支持国际化，将search转为中文
            language: {
                "search": "在表格中搜索:",
                "oPaginate": {
                    "sPrevious": "上页",
                    "sNext": "下页",
                },
            },
            "columnDefs": [
                {
                    //targets指定列禁止排序功能
                    "orderable": false,
                }
            ]
        });
    });
</script>
</body>
</html>