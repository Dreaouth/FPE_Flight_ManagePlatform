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
    <span class="c-gray en">&gt;</span> 航班管理 <a
        class="btn btn-success radius r mr-20"
        style="line-height: 1.6em; margin-top: 3px"
        href="Plane" title="刷新"><i
        class="icon-refresh"></i></a>
</nav>
<div class="pd-20">
    <div class="text-c">
        <form action="selectPlane" method="post">
            航班查询：&nbsp;&nbsp;&nbsp;&nbsp;起始机场：
            <input type="text" class="input-text" style="width: 250px"
                   placeholder="输入机场代号" id="start" name="start">&nbsp;&nbsp;&nbsp;到达机场：
            <input type="text" class="input-text" style="width: 250px"
                   placeholder="输入机场代号" id="end" name="end">&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-success">
                <i class="icon-search"></i> 查询
            </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;<a href="encryptPlane" class="btn btn-primary radius" ><i
                class="icon-plus"></i> 执行<%=encrypt%></a>
        </form>

    </div>
    <div class="mt-20">
        <table id="page"
               class="table table-border table-bordered table-hover table-bg order_table">
            <thead>
            <tr class="text-c">
                <th width="50">ID</th>
                <th width="50">起始机场</th>
                <th width="50">到达机场</th>
                <th width="50">航空公司</th>
                <th width="50">航线号</th>
                <th width="100">起飞时间</th>
                <th width="100">降落时间</th>
                <th width="50">机型</th>
                <th width="100">日期</th>
                <th width="50">数量</th>
                <th width="50">单价</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${planelist}" var="temp">
                <tr class="text-c">
                    <td>${temp.id}</td>
                    <td>${temp.startDrome}</td>
                    <td>${temp.arriveDrome}</td>
                    <td>${temp.company}</td>
                    <td>${temp.airlinecode}</td>
                    <td>${temp.startTime}</td>
                    <td>${temp.arriveTime}</td>
                    <td>${temp.mode}</td>
                    <td>${temp.date}</td>
                    <td>${temp.number}</td>
                    <td>${temp.price}</td>
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