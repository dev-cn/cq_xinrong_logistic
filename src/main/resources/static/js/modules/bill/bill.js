$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'bill/bill/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '序号', name: 'serialNo', index: 'serial_no', width: 80 }, 			
			{ label: '运单号', name: 'trackingNo', index: 'tracking_no', width: 80 }, 			
			{ label: '提货日期', name: 'deliveryDate', index: 'delivery_date', width: 80 }, 			
			{ label: '到货日期', name: 'arrivalDate', index: 'arrival_date', width: 80 }, 			
			{ label: '提货地点', name: 'deliveryAddr', index: 'delivery_addr', width: 80 }, 			
			{ label: '到货地点', name: 'arrivalAddr', index: 'arrival_addr', width: 80 }, 			
			{ label: '货物名称', name: 'goodsName', index: 'goods_name', width: 80 }, 			
			{ label: '装载车型', name: 'loadingModel', index: 'loading_model', width: 80 }, 			
			{ label: '车牌号', name: 'palteNo', index: 'palte_no', width: 80 }, 			
			{ label: '车次', name: 'trainNo', index: 'train_no', width: 80 }, 			
			{ label: '装载数量', name: 'shippedQuantity', index: 'shipped_quantity', width: 80 }, 			
			{ label: '重量', name: 'weight', index: 'weight', width: 80 }, 			
			{ label: '单价', name: 'price', index: 'price', width: 80 }, 			
			{ label: '提货费', name: 'pickUpCharge', index: 'pick_up_charge', width: 80 }, 			
			{ label: '送货费', name: 'deliveryFee', index: 'delivery_fee', width: 80 }, 			
			{ label: '费用合计', name: 'totalExpenses', index: 'total_expenses', width: 80 }, 			
			{ label: '备注', name: 'comment', index: 'comment', width: 80 }, 			
			{ label: '', name: 'createAt', index: 'create_at', width: 80 }, 			
			{ label: '', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '', name: 'updateAt', index: 'update_at', width: 80 }, 			
			{ label: '', name: 'updateBy', index: 'update_by', width: 80 }, 			
			{ label: '', name: 'isDelete', index: 'is_delete', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
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
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		bill: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.bill = {};
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
			var url = vm.bill.id == null ? "bill/bill/save" : "bill/bill/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.bill),
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
				    url: baseURL + "bill/bill/delete",
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
			$.get(baseURL + "bill/bill/info/"+id, function(r){
                vm.bill = r.bill;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});