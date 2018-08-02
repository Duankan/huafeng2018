<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- bootstrap-table -->
    <link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
    <!--layer弹出层-->
    <script src="/static/layer/layer.min.js"></script>
    <link href="/static/layer/skin/layer.css">
    <!--laydate日期插件-->
    <script src="/static/laydate/laydate.js"></script>
    <!--bootstrap select-->
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap-multiselect/0.9.15/css/bootstrap-multiselect.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/bootstrap-multiselect/0.9.15/js/bootstrap-multiselect.js"></script>
    <!--bootstarp-treeview-->
    <script src="/static/bootstrap-treeview.js"></script>
    <link href="/static/css/Myselect.css">
    <title>列表</title>
    <style>
        .table{
            width: 930px;margin-left: 250px;
        }
        .pagination-info{
            margin-left: 231px;
        }
        ul.pagination{
            /*position: absolute;*/
            /*top: 152.8;*/
        }
        div.bootstrap-table{
            width: 1445px;
            margin-left: 0px;
        }
        .layui-layer-title{
            background-color: #337ab7;
        }
        .btn-group{
            width: 195px;top: -58px;left: 639px;
        }
    </style>
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
</table>
<div class="query-wrapper long-query" style="margin-left: 80px">
    <span class="text" style="position: absolute;left: 249px;font-weight:700">起止时间:</span>
    <div class="input-wrapper">
        <div class="form-group">
            <div class="input-daterange input-group">
                <input type="text" class="input-sm form-control" id="bigintime"
                       placeholder="开始时间"
                       value="${startTime}" name="bigintime"
                       style="width:168px;font-size: 10px;left: 238px;top: -4;">
                <span class="input-group-addon" style="position: absolute;left: 419px;top: -2;border-left-width: 0px;width: 36px;background-color: #337ab7;color:white;">到</span>
                <input type="text" class="input-sm form-control" id="endtime"
                       placeholder="截止时间"
                       value="${endTime}" name="endtime"
                       style="width:162px;font-size: 10px;left: 296px;top: -4;">
            </div>
        </div>
    </div>
</div>
<div style="width: 100%; margin:20px">
    <label class="col-sm-1 control-label" style="padding-right: 0px;right: -30px;top: -50px;left: 697px;">户型 ：</label>
    <select id="sel2" multiple="multiple">
        <option>一室一厅</option>
        <option>两室一厅</option>
        <option>三室一厅</option>
    </select>
</div>
<div id="procitytree" style="height: 400px;overflow-y :scroll;"></div>
<!--用bootstrap实时刷新列表js-->
<script type="text/javascript" src="/static/user_list.js"></script>
</body>
<script>
</script>
</html>
