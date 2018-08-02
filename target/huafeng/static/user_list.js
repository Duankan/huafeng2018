(function ($) {
    var pagesize = 3;
    $(function () {
        Ready.initTime();
        Ready.TableInit();
        Ready.selectInit();
    });

    var Ready = {
        //初始化下拉框
        selectInit: function () {
            $("#sel2").multiselect({
                enableFiltering: true,
                nonSelectedText: "营运类型",
                nSelectedText: "个已选择",
                allSelectedText: "全选",
                filterPlaceholder: "搜索",
                // maxHeight: 300,
                // buttonWidth: '195px',
                maxWidth: 160,
                // enableClickableOptGroups: true,
                // enableCollapsibleOptGroups: true,
                includeSelectAllOption: true,
                enableClickableOptGroups: true,
                enableCollapsibleOptGroups: true,
                buttonWidth: 195,
                maxHeight: 300,
            });
        },
        //初始化时间插件
        initTime: function () {
            var start = laydate.render({
                elem: '#bigintime',
                type: 'date',
                format: 'yyyy-MM-dd',
                calendar: true,              //是否显示节日
            });
            var end = laydate.render({
                elem: '#endtime',
                type: 'date',
                format: 'yyyy-MM-dd',
                calendar: true,              //是否显示节日
            });
        },
        //初始化table列表
        TableInit:function () {
                $('#tab').bootstrapTable({
                    url: '/user/findList',     //请求后台的URL（*）
                    contentType: "application/x-www-form-urlencoded",
                    method: 'post',                              //请求方式（*）
                    toolbar: '#toolbar',                        //工具按钮用哪个容器
                    striped: false,                              //是否显示行间隔色
                    cache: false,                               //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                    pagination: true,                           //是否显示分页（*）
                    sortable: false,                            //是否启用排序
                    sortOrder: "asc",                           //排序方式
                    queryParams: function (params) {
                        return {
                            offset: params.offset,
                            limit: params.limit
                        }
                    },
                    sidePagination: "server",                   //分页方式：client客户端分页，server服务端分页（*）
                    pageNumber: 1,                               //初始化加载第一页，默认第一页
                    pageSize: pagesize,                               //每页的记录行数（*）
                    pageList: [15, 25, 50, 100],                //可供选择的每页的行数（*）
                    search: false,                               //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                    strictSearch: true,
                    showColumns: false,                          //是否显示所有的列
                    showRefresh: false,                          //是否显示刷新按钮
                    minimumCountColumns: 2,                     //最少允许的列数
                    clickToSelect: false,                        //是否启用点击选中行
                    height: 400,                                //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                    uniqueId: 'id',                        //每一行的唯一标识，一般为主键列
                    showToggle: false,                            //是否显示详细视图和列表视图的切换按钮
                    cardView: false,                            //是否显示详细视图
                    detailView: false,                           //是否显示父子表
                    columns: [
                        {
                            field: 'name',
                            align: "left",
                            title: '用户姓名'
                        },
                        {
                            field: 'age',
                            align: "left",
                            title: '年龄'
                        },
                        {
                            field: 'addr',
                            align: "left",
                            title: '地址'
                        },
                        {
                            field: 'pic',
                            align: "left",
                            title: '文件路径'
                        },
                        {
                            field: 'Button',
                            title: '操作',
                            align: "left",
                            formatter: function (value, row, index) {
                                return [
                                    '<button id="btn_del" type="button" class="btn btn-default del" style="color:blue;">\n' +
                                    '        <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>\n' +
                                    '</button>&nbsp;',
                                    '<button id="btn_update" type="button" class="btn btn-default update" style="color:blue;">\n' +
                                    '        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>\n' +
                                    '</button>'
                                ].join('');
                            },
                            events: {
                                //删除
                                "click #btn_del": function (e, value, row, index) {
                                    var url = "/user/del?id=" + row.id;
                                    $.get(url, function (data) {
                                        window.location.href = "/user/list2";
                                    });
                                },
                                //编辑
                                "click #btn_update": function (e, value, row, index) {
                                    var url = "/user/updateUI?id=" + row.id;
                                    // window.location.href=url;
                                    // layer.msg("打开编辑框");
                                    layer.open({
                                        type: 2,
                                        title: '用户编辑',
                                        maxmin: true,
                                        shadeClose: true, //点击遮罩关闭层
                                        area: ['800px', '520px'],
                                        content: [url],
                                    });
                                }
                            },
                        },]
                });
        }
    }
    //添加数据
    var add = $("#add");
    add.click(function () {
        // window.location.href="/user/addUI";
        layer.open({
            type: 2,
            title: '用户新增',
            maxmin: true,
            skin: 'demo-class',
            shadeClose: true, //点击遮罩关闭层
            area: ['800px', '520px'],
            content: '/user/addUI'
        });
    });
})(jQuery);
