<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>

<html>
<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
<head>
    <base href="<%=basePath%>">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script
            src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${APP_PATH}/package/css/H-ui.css"/>
    <link type="text/css" rel="stylesheet" href="${APP_PATH}/package/css/H-ui.admin.css"/>
    <link type="text/css" rel="stylesheet"
          href="${APP_PATH}/package/font/font-awesome.min.css"/>
    <title>添加车站</title>
</head>
<body>
<script type="text/javascript">
    function check() {
        var id = document.forms[0].id.value;
        var start_drome = document.forms[0].start_drome.value;
        var arrive_drome = document.forms[0].arrive_drome.value;
        var company = document.forms[0].company.value;
        var airlineCode = document.forms[0].airlineCode.value;
        var start_time = document.forms[0].start_time.value;
        var arrive_time = document.forms[0].arrive_time.value;
        var mode = document.forms[0].mode.value;
        var date = document.forms[0].date.value;
        var number = document.forms[0].number.value;
        var price = document.forms[0].price.value;
        if (id == "") {
            alert("错误提示：城市代码不能为空！");
            return false;
        }
        if (start_drome == "") {
            alert("错误提示：城市代码不能为空！");
            return false;
        }
        if (arrive_drome == "") {
            alert("错误提示：城市代码不能为空！");
            return false;
        }
        if (company == "") {
            alert("错误提示：公司代码不能为空！");
            return false;
        }
        if (airlineCode == "") {
            alert("错误提示：航线代码不能为空！");
            return false;
        }
        if (start_time == "") {
            alert("错误提示：起飞时间不能为空！");
            return false;
        }
        if (arrive_time == "") {
            alert("错误提示：降落时间不能为空！");
            return false;
        }
        if (mode == "") {
            alert("错误提示：机型不能为空！");
            return false;
        }
        if (date == "") {
            alert("错误提示：日期不能为空！");
            return false;
        }
        if (number == "") {
            alert("错误提示：机票数量不能为空！");
            return false;
        }
        if (price == "") {
            alert("错误提示：单价不能为空！");
            return false;
        }
    }
</script>
<%
    String id = (String) request.getParameter("id");
    if (id == null) {
        id = "";
    }
    String start_drome = (String) request.getParameter("start_drome");
    if (start_drome == null) {
        start_drome = "";
    }
    String arrive_drome = (String) request.getParameter("arrive_drome");
    if (arrive_drome == null) {
        arrive_drome = "";
    }
    String company = (String) request.getParameter("company");
    if (company == null) {
        company = "";
    }
    String airlineCode = (String) request.getParameter("airlineCode");
    if (airlineCode == null) {
        airlineCode = "";
    }
    String start_time = (String) request.getParameter("start_time");
    if (start_time == null) {
        start_time = "";
    }
    String arrive_time = (String) request.getParameter("arrive_time");
    if (arrive_time == null) {
        arrive_time = "";
    }
    String mode = (String) request.getParameter("mode");
    if (mode == null) {
        mode = "";
    }
    String date = (String) request.getParameter("date");
    if (date == null) {
        date = "";
    }
    String number = (String) request.getParameter("number");
    if (number == null) {
        number = "";
    }
    String price = (String) request.getParameter("price");
    if (price == null) {
        price = "";
    }
%>
<div class="pd-20">
    <div class="Huiform">
        <form action="plane/updatePlane" onsubmit="return check()"
              method="post" target="_parent">
            <table class="table table-bg">
                <tbody>
                <tr>
                    <th width="100" class="text-r"><span class="c-red"></span>
                        航班ID：
                    </th>
                    <td><input type="text" style="width: 300px" readonly="readonly"
                               class="input-text" id="id" name="id" value=<%=id %>></td>
                </tr>
                <tr>
                    <th width="100" class="text-r"><span class="c-red">*</span>
                        起始城市：
                    </th>
                    <td><input type="text" style="width: 300px"
                               class="input-text" id="start_drome" name="start_drome" value=<%=start_drome %>></td>
                </tr>
                <tr>
                    <th width="100" class="text-r"><span class="c-red">*</span>
                        到达城市：
                    </th>
                    <td><input type="text" style="width: 300px"
                               class="input-text" id="arrive_drome" name="arrive_drome" value=<%=arrive_drome %>></td>
                </tr>
                <tr>
                    <th class="text-r"><span class="c-red">*</span> 所属公司：</th>
                    <td><input type="text" style="width: 300px"
                               class="input-text" id="company" name="company" value=<%=company %>></td>
                </tr>
                <tr>
                    <th class="text-r"><span class="c-red">*</span> 航线号：</th>
                    <td><input type="text" style="width: 300px"
                               class="input-text" id="airlineCode" name="airlineCode" value=<%=airlineCode %>></td>
                </tr>
                <tr>
                    <th class="text-r"><span class="c-red">*</span> 起始时间：</th>
                    <td><input type="text" id="start_time"
                               name="start_time" value=<%=start_time %>
                                       onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm:ss'})"
                               class="Wdate"/></td>
                </tr>
                <tr>
                    <th class="text-r"><span class="c-red">*</span> 到达时间：</th>
                    <td><input type="text" id="arrive_time"
                               name="arrive_time" value=<%=arrive_time %>
                                       onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm:ss'})"
                               class="Wdate"/></td>
                </tr>
                <tr>
                    <th class="text-r"><span class="c-red">*</span> 机型号：</th>
                    <td><input type="text" style="width: 300px"
                               class="input-text" id="mode" name="mode"
                               value=<%=mode %>>
                    </td>
                </tr>
                <tr>
                    <th class="text-r"><span class="c-red">*</span> 日期：</th>
                    <td><input type="text" id="date" name="date"
                               value=<%=date %> onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"
                               class="Wdate"></td>
                </tr>
                <tr>
                    <th class="text-r"><span class="c-red">*</span> 余票：</th>
                    <td><input type="text" style="width: 300px"
                               class="input-text" id="number" name="number" value=<%=number %>></td>
                </tr>
                <tr>
                    <th class="text-r"><span class="c-red">*</span> 单价：</th>
                    <td><input type="text" style="width: 300px"
                               class="input-text" id="price" name="price" value=<%=price %>></td>
                </tr>
                <tr>
                    <td>
                        <button class="btn btn-success radius" type="submit">
                            <i class="icon-ok"></i> 确定
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</div>
<script type="text/javascript" src="${APP_PATH}/package/js/jquery.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/package/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${APP_PATH}/package/js/H-ui.js"></script>
<script type="text/javascript" src="${APP_PATH}/package/js/H-ui.admin.js"></script>
<script type="text/javascript"
        src="${APP_PATH}/package/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    $(".Huiform").Validform();
</script>

</body>
</html>