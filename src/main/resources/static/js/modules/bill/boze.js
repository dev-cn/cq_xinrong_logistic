$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'bill/boze/list',
        datatype: "json",
        colModel: [			
			{ label: '序号', name: 'serialNo', index: 'serial_no', width: 120 },
			{ label: '运单号', name: 'trackingNo', index: 'tracking_no', width: 120 },
			{ label: '提货日期', name: 'deliveryDate', index: 'delivery_date', width: 120 },
			{ label: '到货日期', name: 'arrivalDate', index: 'arrival_date', width: 120 },
			{ label: '提货地点', name: 'deliveryAddr', index: 'delivery_addr', width: 180 },
			{ label: '到货地点', name: 'arrivalAddr', index: 'arrival_addr', width: 180 },
			{ label: '货物名称', name: 'goodsName', index: 'goods_name', width: 120 },
			{ label: '装载车型', name: 'loadingModel', index: 'loading_model', width: 120 },
			{ label: '车牌号', name: 'palteNo', index: 'palte_no', width: 120 },
			{ label: '车次', name: 'trainNo', index: 'train_no', width: 120 },
			{ label: '装载数量', name: 'shippedQuantity', index: 'shipped_quantity', width: 120 },
			{ label: '重量', name: 'weight', index: 'weight', width: 120 },
			{ label: '单价', name: 'price', index: 'price', width: 120 },
			{ label: '提货费', name: 'pickUpCharge', index: 'pick_up_charge', width: 120 },
			{ label: '送货费', name: 'deliveryFee', index: 'delivery_fee', width: 120 },
			{ label: '费用合计', name: 'totalExpenses', index: 'total_expenses', width: 120 },
			{ label: '备注', name: 'comment', index: 'comment', width: 120 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        shrinkToFit:false,
        autoScroll:true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "srcoll"});
        }
    });
    Datetime();

    new AjaxUpload('#excelImport', {
        action: baseURL + 'bill/boze/excelImport?token=' + token,
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

});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		boZe: {
    		trackingNo: null
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.boZe = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.boZe.id == null ? "bill/boze/save" : "bill/boze/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.boZe),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "bill/boze/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "bill/boze/info/"+id, function(r){
                vm.boZe = r.boZe;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
            var beginDate = $("#beginDate").val();
            var endDate = $("#endDate").val();
            if(beginDate != "" && endDate!="") {
                if(beginDate>endDate){
                    alert("选择的开始日期不能大于结束日期，请重新选择日期");
                    return;
                }
            }
            if(endDate.trim() =="" || endDate==null){
                endDate = new Date().Format("yyyy-MM-dd");
            }
			$("#jqGrid").jqGrid('setGridParam',{
                postData: {'trackingNo': vm.boZe.trackingNo,'beginDate':beginDate,'endDate':endDate},
                page:page
            }).trigger("reloadGrid");
		},
        excelExport: function (event) {
            excelExport(baseURL + "bill/boze/export?token=" + token);
        },
        reset: function (event) {
			vm.boZe.trackingNo = null;
            $("#beginDate").val("");
            $("#endDate").val("");
            $("#trackingNo").val("");
            vm.reload();
        }
	}
});

function Datetime() {
    $('#datetimepicker1,#datetimepicker2').datetimepicker({
        language: 'zh-CN',//显示中文
        format: 'yyyy-mm-dd',//显示格式
        minView: "month",//设置只显示到月份
        initialDate: new Date(),
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        locale: moment.locale('zh-cn')
    }).on('hide', function (ev) {
        var deliveryDate = $("#datetimepicker1").val();
        var arrivalDate = $("#datetimepicker2").val();
		vm.boZe.deliveryDate = deliveryDate;
		vm.boZe.arrivalDate = arrivalDate;
    });
}