$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'baseinfo/abparameter/list',
        datatype: "json",
        colModel: [
            // { label: 'id', name: 'id', index: 'id', width: 50, key: true },
            {label: '参数编码', name: 'paraCode', index: 'para_code', width: 80},
            {label: '参数名称', name: 'paraDesc', index: 'para_desc', width: 80},
            {label: '上级参数', name: 'paraParentCode', index: 'para_parent_code', width: 80},
            {label: '序号', name: 'seq', index: 'seq', width: 80},
            {label: '创建时间', name: 'createAt', index: 'create_at', width: 80},
            {label: '参建人', name: 'createBy', index: 'create_by', width: 80},
            {label: '更新时间', name: 'updateAt', index: 'update_at', width: 80},
            {label: '更新人', name: 'updateBy', index: 'update_by', width: 80},
            {label: '是否删除', name: 'isDelete', index: 'is_delete', width: 80}
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
        abParameter: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.abParameter = {};
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
            var url = vm.abParameter.id == null ? "baseinfo/abparameter/save" : "baseinfo/abparameter/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.abParameter),
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
                    url: baseURL + "baseinfo/abparameter/delete",
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
            $.get(baseURL + "baseinfo/abparameter/info/" + id, function (r) {
                vm.abParameter = r.abParameter;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'paraDesc': vm.abParameter.paraDesc, 'paraParentCode': vm.abParameter.paraParentCode},
                page: page
            }).trigger("reloadGrid");
        },
        reset: function (event) {
            vm.abParameter.paraDesc = null;
            vm.abParameter.paraParentCode = null;
            $("#paraDesc").val("");
            $("#paraParentCode").val("");
            vm.reload();
        }
    }
});

