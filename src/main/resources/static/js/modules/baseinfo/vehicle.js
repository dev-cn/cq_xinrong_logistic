$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'baseinfo/vehicle/list',
        datatype: "json",
        colModel: [
            // { label: 'id', name: 'id', index: 'id', width: 50, key: true },
            {label: '车牌号', name: 'palteNo', index: 'palte_no', width: 80},
            {label: '驾驶人', name: 'driver', index: 'driver', width: 80},
            {label: '装载车型', name: 'loadingModel', index: 'loading_model', width: 80},
            {label: '车载量', name: 'shippedQuantity', index: 'shipped_quantity', width: 80},
            {label: '所属区域', name: 'belongArea', index: 'belong_area', width: 80},
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
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        vehicle: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.vehicle = {};
        },
        update: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        saveOrUpdate: function (event) {
            var url = vm.vehicle.id == null ? "baseinfo/vehicle/save" : "baseinfo/vehicle/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.vehicle),
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
                    url: baseURL + "baseinfo/vehicle/delete",
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
            $.get(baseURL + "baseinfo/vehicle/info/" + id, function (r) {
                vm.vehicle = r.vehicle;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'palteNo': vm.vehicle.palteNo},
                page: page
            }).trigger("reloadGrid");
        },
        reset: function (event) {
            vm.vehicle.palteNo = null;
            $("#palteNo").val("");
            vm.reload();
        }
    }
});