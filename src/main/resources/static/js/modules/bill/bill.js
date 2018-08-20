$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'bill/bill/list',
        datatype: "json",
        colModel: [
            // { label: 'id', name: 'id', index: 'id', width: 50, key: true },
            {label: '序号', name: 'serialNo', index: 'serial_no', width: 80},
            {label: '运单号', name: 'trackingNo', index: 'tracking_no', align: "center", width: 120},
            {label: '提货日期', name: 'deliveryDate', index: 'delivery_date', align: "center", width: 120},
            {label: '到货日期', name: 'arrivalDate', index: 'arrival_date', align: "center", width: 120},
            {label: '提货地点', name: 'deliveryAddr', index: 'delivery_addr', width: 180},
            {label: '到货地点', name: 'arrivalAddr', index: 'arrival_addr', width: 180},
            {label: '货物名称', name: 'goodsName', index: 'goods_name', width: 180},
            {label: '装载车型', name: 'loadingModel', index: 'loading_model', width: 80},
            {label: '车牌号', name: 'palteNo', index: 'palte_no', width: 120},
            {label: '车次', name: 'trainNo', index: 'train_no', width: 80},
            {label: '装载数量', name: 'shippedQuantity', index: 'shipped_quantity', width: 80},
            {label: '重量', name: 'weight', index: 'weight', width: 80},
            {label: '单价', name: 'price', index: 'price', width: 80, formatter: amountPermissionNo},
            {label: '提货费', name: 'pickUpCharge', index: 'pick_up_charge', width: 80, formatter: amountPermissionNo},
            {label: '送货费', name: 'deliveryFee', index: 'delivery_fee', width: 80, formatter: amountPermissionNo},
            {label: '费用合计', name: 'totalExpenses', index: 'total_expenses', width: 80, formatter: amountPermissionNo},
            {label: '备注', name: 'comment', index: 'comment', width: 180}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        shrinkToFit: false,
        autoScroll: true,
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
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "srcoll"});
        }
    });

    new AjaxUpload('#excelImport', {
        action: baseURL + 'bill/bill/excelImport?token=' + token,
        name: 'file',
        autoSubmit: true,
        responseType: "json",
        onSubmit: function (file, extension) {
            if (!(extension && /^(xlsx|xls)$/.test(extension.toLowerCase()))) {
                alert('只支持xlsx、xls格式的excel！');
                return false;
            }
        },
        onComplete: function (file, r) {
            if (r.code === 0) {
                alert(file + '导入成功', function (index) {
                    vm.reload();
                });
            } else {
                alert(r.msg);
            }
        }
    });


    /*    vm.getSelectForCustomer();
        vm.getSelectForVehicle();*/

});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        bill: {
            trackingNo: null
        }/*,
        customerList: {},
        vehicleList: {}*/
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.bill = {};
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
            var url = vm.bill.id == null ? "bill/bill/save" : "bill/bill/update";
            var data = JSON.stringify(vm.bill);
            // v
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: data,
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reset();
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
                    url: baseURL + "bill/bill/delete",
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
            $.get(baseURL + "bill/bill/info/" + id, function (r) {
                vm.bill = r.bill;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            var beginDate = $("#beginDate").val();
            var endDate = $("#endDate").val();
            if (beginDate != "" && endDate != "") {
                if (beginDate > endDate) {
                    alert("选择的开始日期不能大于结束日期，请重新选择日期");
                    return;
                }
            }
            if (endDate.trim() == "" || endDate == null) {
                endDate = new Date().Format("yyyy-MM-dd");
            }
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'trackingNo': vm.bill.trackingNo, 'beginDate': beginDate, 'endDate': endDate},
                page: page
            }).trigger("reloadGrid");
        },
        excelExport: function (event) {
            excelExport(baseURL + "bill/bill/export?token=" + token);
        },
        reset: function (event) {
            vm.bill.trackingNo = null;
            $("#beginDate").val("");
            $("#endDate").val("");
            $("#trackingNo").val("");
            vm.reload();
        }/*,
        getSelectForCustomer: function (event) {
            $.ajax({
                type: "POST",
                url: baseURL + "baseinfo/customer/list/select",
                contentType: "application/json",
                success: function (r) {
                    vm.customerList = r.select;
                }
            });
        },
        getSelectForVehicle: function (event) {
            $.ajax({
                type: "POST",
                url: baseURL + "baseinfo/vehicle/list/select",
                contentType: "application/json",
                success: function (r) {
                    vm.vehicleList = r.select;
                }
            });
        }*/
    }
});

