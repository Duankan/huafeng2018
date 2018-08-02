<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>列表</title>
</head>
<body>
<h1 style="margin-left: 545px;">用户列表</h1>
<button id="add" type="button" class="btn btn-default"
         style="color:blue;color:blue;margin-left: 1001px;position: absolute;left: -200;">
    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
</button>
<input type="text" id="search" placeholder="请输入任意字符" name="search" style="margin-left: 860px;">
<button ype="button" class="btn btn-default search"><span class="glyphicon glyphicon-search"></span></button>
<table id="tab" class="table table-striped" style="width: 930px;margin-left: 250px;">
    <thead>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>地址</td>
        <td>文件路径</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody id="tbody">
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.addr}</td>
            <td>${user.pic}</td>
            <td>
                <button  type="button" class="btn btn-default del"
                         style="color:blue;" value="${user.id}">
                    <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                </button>
                <button type="button" class="btn btn-default update"
                        style="color:blue;" value="${user.id}">
                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                </button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
<script>
    $(function () {
        //添加数据
       var add = $("#add");
       add.click(function () {
           window.location.href="/user/addUI";
       });

       //删除数据
        $(".del").on('click', function (e) {
            var index = $('.del').index(this);
            var id = e.target.value;
            //如果点击的是里面的span，则拿它父节点
            if(typeof(id)=="undefined" ){
                id = e.currentTarget.value;
            }

            var url = "/user/del?id="+id;
            $.get(url,function (data) {
                 window.location.href="/user/list";
            });
        });

        //修改数据
        $(".update").on('click', function (e) {
            var id = e.target.value;
            //如果点击的是里面的span，则拿它父节点
            if(typeof(id)=="undefined" ){
                id = e.currentTarget.value;
            }
            var url = "/user/updateUI?id="+id;
            window.location.href=url;
        });
        //模糊搜素
        $(".search").click(function () {
            var kw = $("#search").val();
            var url = "/user/search?kw="+kw;
            $.get(url,function (data) {
                $("#tbody").empty();
                for(var i= 0;i<data.users.length;i++){
                    var tr = $("<tr></tr>");
                    var tdName = $("<td></td>").text(data.users[i].name);
                    var tdage = $("<td></td>").text(data.users[i].age);
                    var tdaddr = $("<td></td>").text(data.users[i].addr);
                    var tdpic = $("<td></td>").text(data.users[i].pic);
                    var buttondel = $("<button  type='button' class='btn btn-default del' style='color:blue;'>").attr("value",data.users[i].id);
                    var spandel = $("<span class='glyphicon glyphicon-minus' aria-hidden='true'></span>");
                    var buttonEDIT= $("<button  type='button' class='btn btn-default update' style='color:blue;'>").attr("value",data.users[i].id);
                    var spanupdate = $("<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>");
                   buttondel.append(spandel);
                   buttonEDIT.append(spanupdate);
                   var tdButton = $("<td></td>");
                   tdButton.append(buttondel);
                   tdButton.append(buttonEDIT);
                    tr.append(tdName);
                    tr.append(tdage);
                    tr.append(tdaddr);
                    tr.append(tdpic);
                    tr.append(tdButton);
                    $("#tbody").append(tr);
                }
            });
        });

        var test = $("#tab").children('td');
    });
</script>
</html>
