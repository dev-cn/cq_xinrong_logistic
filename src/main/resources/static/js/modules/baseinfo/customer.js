$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'baseinfo/customer/list',
        datatype: "json",
        colModel: [
            // { label: 'id', name: 'id', index: 'id', width: 50, key: true },
            {label: '客户名称', name: 'name', index: 'name', width: 80},
            {label: '英文名称', name: 'nameEn', index: 'name_en', width: 80},
            {label: '客户简称', name: 'nameDesc', index: 'name_desc', width: 80},
            {label: '联系方式', name: 'mobile', index: 'mobile', width: 80},
            {label: '邮箱', name: 'email', index: 'email', width: 80},
            {label: 'QQ', name: 'qq', index: 'qq', width: 80},
            {label: '微信', name: 'wechat', index: 'wechat', width: 80},
            {label: '网站地址', name: 'website', index: 'website', width: 80},
            {label: '地址', name: 'address', index: 'address', width: 80},
            {label: '建档时间', name: 'ctime', index: 'ctime', width: 80},
            {label: '级别', name: 'level', index: 'level', width: 80},
            {label: '备注', name: 'comment', index: 'comment', width: 80}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
    Datetime();
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        customer: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.customer = {};
        },
        update: function (event) {
            var id = getSelectedRow();
            if (id == null) {
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        saveOrUpdate: function (event) {
            var url = vm.customer.id == null ? "baseinfo/customer/save" : "baseinfo/customer/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.customer),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "baseinfo/customer/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function (id) {
            $.get(baseURL + "baseinfo/customer/info/" + id, function (r) {
                vm.customer = r.customer;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'name': vm.customer.name},
                page: page
            }).trigger("reloadGrid");
        },
        reset: function (event) {
            vm.customer.name = null;
            $("#name").val("");
            vm.reload();
        }
    }
});

function Datetime() {
    $('#datetimepicker1').val("");
    $('#datetimepicker1').datetimepicker({
        language: 'zh-CN',//显示中文
        format: 'yyyy-mm-dd',//显示格式
        minView: "month",//设置只显示到月份
        initialDate: new Date(),
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        locale: moment.locale('zh-cn')
    }).on('hide', function (ev) {
        vm.customer.ctime = (new Date($("#datetimepicker1").val())).Format("yyyy-MM-dd");
    });
}
