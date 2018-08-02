
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <%--<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <script src="/static/layer/layer.min.js"></script>
    <link href="/static/layer/skin/layer.css">
    <title>编辑</title>
    <style>
        .high{
            color: red;
        }
        .onError{
            color: red;
        }
    </style>
</head>
<body>
<form class="form-inline" role="form" action="/user/update" enctype="multipart/form-data" method="post">
    <input type="hidden" id="id" name="id" value="${user.id}">
    <div class="form-group">
        <label class="sr-only" for="name" style="margin-left: 249px;">姓 名：</label>
        <input type="text" class="form-control required" id="name" name="name" value="${user.name}"
               placeholder="请输入名称" style="margin-bottom: 10px;">
    </div>
    <div class="form-group">
        <label class="sr-only" for="age" style="margin-left: 249px;">年 龄：</label>
        <input type="text" class="form-control required" id="age" name="age" value="${user.age}"
               placeholder="请输入年龄" style="margin-bottom: 10px;">
    </div>
    <div class="form-group">
        <label class="sr-only" for="addr" style="margin-left: 249px;">地 址：</label>
        <input type="text" class="form-control required" id="addr" name="addr" value="${user.addr}"
               placeholder="请输入地址" style="margin-bottom: 10px;">
    </div>
    <div class="form-group">
        <label class="sr-only" for="inputfile" style="margin-left: 249px;">文件输入</label>
        <input type="file" id="inputfile" style="margin-bottom: 10px;" name="file">
    </div>
    <%--<button type="submit" class="btn-success" style="margin-left: 600px;color: darkblue">提交</button>--%>
    <button  class="btn-success submit" style="margin-left: 300px;color: darkblue">提交</button>
</form>
</body>
<script>
    $(function () {
        var ok1=true;
        var ok2=true;
        var ok3=true;
        $("form :input.required").each(function () {
            //创建元素
            var $required = $("<strong class='high'>*</strong>");
            //将它追加到文档中
            $(this).parent().append($required);

            $("form :input").blur(function(){
                var $parent = $(this).parent();
                $parent.find(".msg").remove(); //删除以前的提醒元素
                //验证名称
                if($(this).is("#name")){
                    if($.trim(this.value) == "" || $.trim(this.value).length < 2){
                        var errorMsg = " 请输入至少2位的名称！";
                        //class='msg onError' 中间的空格是层叠样式的格式
                        $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
                        ok1 = false;
                    }
                    else{
                        var okMsg=" 输入正确";
                        $parent.find(".high").remove();
                        $parent.append("<span class='msg onSuccess'>" + okMsg + "</span>");
                        ok1 = true;
                    }
                }

                //验证年龄
                if($(this).is("#age")){
                    if($.trim(this.value) == "" || $.trim(this.value).length < 1){
                        var errorMsg = " 请输入至少1位的年龄！";
                        //class='msg onError' 中间的空格是层叠样式的格式
                        $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
                        ok2 = false;
                    }
                    if(isNaN(parseInt($.trim(this.value)))){
                        var errorMsg = " 请输入数字！";
                        $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
                        ok2 = false;
                    }
                    else{
                        var okMsg=" 输入正确";
                        $parent.find(".high").remove();
                        $parent.append("<span class='msg onSuccess'>" + okMsg + "</span>");
                        ok2 = true;
                    }
                }

                //验证地址
                if($(this).is("#addr")){
                    if($.trim(this.value) == "" || $.trim(this.value).length < 2){
                        var errorMsg = " 请输入至少2位的地址！";
                        //class='msg onError' 中间的空格是层叠样式的格式
                        $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
                        ok3 = false;
                    }
                    else{
                        var okMsg=" 输入正确";
                        $parent.find(".high").remove();
                        $parent.append("<span class='msg onSuccess'>" + okMsg + "</span>");
                        ok3 = true;
                    }
                }

            });
        });
        //提交
        $('.submit').click(function(){
            if(ok1 && ok2 && ok3){
                $('form').submit();
                layer.msg("新增成功！");
                window.layer.closeAll();
            }else{
                return false;
            }
        });
    });
</script>
</html>
