$(function() {
	//根据窗口调整表格高度
	$(window).resize(function() {
		$('#mytab').bootstrapTable('resetView', {
			height : tableHeight()
		})
	})

	//审核页面Table
	$('#mytabApproval').bootstrapTable({
		url : ctx + "/agency/list",//数据源
		dataType : "json",//期待返回数据类型
		method : "post",//请求方式
		contentType : "application/x-www-form-urlencoded",
		queryParams : function(params) {
			return {
				'offset' : params.offset,
				'limit' : params.limit,
				'agencyId' : $("#agencyId").val(),
				'agencyName' : $("#agencyName").val(),
				'status' : '01'
			};
		},
		striped : true,
		pagination : true,
		singleSelect : false,
		pageSize : 10,
		pageList : [ 10, 50, 100, 200, 500 ],
		search : false, //不显示 搜索框
		showColumns : false, //不显示下拉框（选择显示的列）
		sidePagination : "server", //服务端请求
		queryParamsType : "limit",//查询参数组织方式
		columns : [ {
			field : 'id',
			radio : true
		}, {
			field : "agencyId",
			title : "机构编码",
			width : 100,
			align : "center"
		}, {
			field : "agencyName",
			title : "分销商名称",
			width : 200,
			align : "center"
		}, {
			field : "parentName",
			title : "上级分销商名称",
			width : 200,
			align : "center"
		},{
			field : "status",
			title : "机构状态",
			width : 100,
			align : "center",
			formatter : function operateFormatter(value) {
				if (value == '00') {
					return "审核通过";
				} else if (value == '01') {
					return "待审核";
				} else if (value == '02') {
					return "待配置参数";
				} else if (value == '03') {
					return "审核驳回";
				}
			}
		}, {
			field : "username",
			title : "创建人",
			width : 100,
			align : "center"
		}, {
			field : "datetime",
			title : "创建时间",
			width : 100,
			align : "center"
		}, {
			field : "customerid",
			title : "操作",
			width : 200,
			align : "center",
			formatter : operateAgencyFormatter
		} ],
		locale : 'zh-CN'
	});

});

//重新加载表格数据
function reloadApproveDate() {
	$("#mytabApproval").bootstrapTable('refresh');
}

function approvalAgency() {
	var ids = $.map($('#mytabApproval').bootstrapTable('getSelections'),
			function(row) {
				return row.agencyId;
			});
	if (ids == '') {
		alert('请选择修改的记录!');
		return;
	}

	if (confirm("确认要审核通过？")) {
		$.ajax({
			type : "GET",
			url : ctx + "/agency/approvalAgencyScale/" + ids,
			success : function(obj) {
				if (obj.success == 'true') {
					alert(obj.message);
					$('#mytabApproval').bootstrapTable('refresh');
				} else {
					alert(obj.message);
					$('#mytabApproval').bootstrapTable('refresh');
				}
			}
		});
	}

}
//审核驳回
function deniedApprovale() {
	var ids = $.map($('#mytabApproval').bootstrapTable('getSelections'),
			function(row) {
				return row.agencyId;
			});
	if (ids == '') {
		alert('请选择修改的记录!');
		return;
	}

	if (confirm("确认要审核驳回？")) {

		$.weeboxs.open(ctx + "/agency/deniedApproval/" + ids, {
			title : '审核驳回',
			contentType : 'iframe',
			width : 650,
			height : 300,
			showButton : false,
			showOk : false,
			showCancel : false
		});
	}
}
