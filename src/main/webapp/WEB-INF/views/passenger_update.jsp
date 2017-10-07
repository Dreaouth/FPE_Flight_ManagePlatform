<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<% String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<!DOCTYPE html>

<html>
<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
<head>
    <base href="<%=basePath%>">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script
            src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${APP_PATH}/package/css/H-ui.css"/>
    <link type="text/css" rel="stylesheet" href="${APP_PATH}/package/css/H-ui.admin.css"/>
    <link type="text/css" rel="stylesheet" href="${APP_PATH}/package/font/font-awesome.min.css"/>
    <title>添加乘客</title>
</head>
<body>
<script type="text/javascript">
    function check() {
        var name = document.forms[0].name.value;//获取用户名所填的内容
        var age = document.forms[0].age.value;//获取所填的密码
        var tel = document.forms[0].tel.value;//获取用户名所填的内容
        var card = document.forms[0].card.value;//获取用户名所填的内容
        var seat = document.forms[0].seat.value;//获取用户名所填的内容
        var planeId = document.forms[0].planeId.value;//获取用户名所填的内容
        if (name == "") {
            alert("错误提示：姓名不能为空！");
            return false;
        }
        if (age == "") {
            alert("错误提示：年龄不能为空！");
            return false;
        }
        if (tel == "") {
            alert("错误提示：电话不能为空！");
            return false;
        }
        if (card == "") {
            alert("错误提示：身份证号不能为空！");
            return false;
        }
        if (seat == "") {
            alert("错误提示：座位号不能为空！");
            return false;
        }
        if (planeId == "") {
            alert("错误提示：航班号不能为空！");
            return false;
        }
    }
</script>
<%
    String id=(String)request.getAttribute("id");
    if(id==null){
        id="";
    }
    String name=(String)request.getAttribute("name");
    if(name==null){
        name="";
    }
    String age=(String)request.getAttribute("age");
    if(age==null){
        age="";
    }
    String tel=(String)request.getAttribute("tel");
    if(tel==null){
        tel="";
    }
    String card=(String)request.getAttribute("card");
    if(card==null){
        card="";
    }
    String seat=(String)request.getAttribute("seat");
    if(seat==null){
        seat="";
    }
    String planeId=(String)request.getAttribute("planeId");
    if(planeId==null){
        planeId="";
    }
%>
<div class="pd-20">
    <div class="Huiform">
        <form action="passenger/updatePassenger" method="post" onsubmit="return check()" target="_parent">
            <table class="table table-bg">
                <tbody>
                <tr>
                    <th width="100" class="text-r"><span class="c-red">*</span> 乘客ID：</th>
                    <td><input type="text" style="width:300px" placeholder="请输入城市三字码" class="input-text" id="id" name="id" readonly="readonly" value=<%=id %>></td>
                </tr>
                <tr>
                    <th width="100" class="text-r"><span class="c-red">*</span> 姓名：</th>
                    <td><input type="text" style="width:300px" class="input-text"  id="name" name="name" value=<%=name %>></td>
                </tr>
                <tr>
                    <th class="text-r"><span class="c-red">*</span> 年龄：</th>
                    <td><input type="text" style="width:300px" class="input-text" id="age" name="age" value=<%=age %>></td>
                </tr>
                <tr>
                    <th width="100" class="text-r"><span class="c-red">*</span> 电话：</th>
                    <td><input type="text" style="width:300px" class="input-text"  id="tel" name="tel" value=<%=tel %>></td>
                </tr>
                <tr>
                    <th width="100" class="text-r"><span class="c-red">*</span> 身份证号：</th>
                    <td><input type="text" style="width:300px" class="input-text"  id="card" name="card" value=<%=card %>></td>
                </tr>
                <tr>
                    <th width="100" class="text-r"><span class="c-red">*</span> 座位号：</th>
                    <td><input type="text" style="width:300px" class="input-text"  id="seat" name="seat" value=<%=seat %>></td>
                </tr>
                <tr>
                    <th width="100" class="text-r"><span class="c-red">*</span> 航班号：</th>
                    <td><input type="text" style="width:300px" class="input-text"  id="planeId" name="planeId" value=<%=planeId %>></td>
                </tr>
                <tr>
                    <td><button class="btn btn-success radius" type="submit" ><i class="icon-ok"></i> 确定</button>
                    </td></tr>
                </tbody>
            </table>
        </form>
    </div>
</div>
<script type="text/javascript" src="${APP_PATH}/package/js/jquery.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/package/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${APP_PATH}/package/js/H-ui.js"></script>
<script type="text/javascript" src="${APP_PATH}/package/js/H-ui.admin.js"></script>
<script type="text/javascript">
    $(".Huiform").Validform();
</script>

</body>
</html>
