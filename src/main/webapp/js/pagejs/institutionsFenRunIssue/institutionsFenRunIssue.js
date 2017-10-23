 $(function() {


   $("#parentIdSelect").bsSuggest({
		    	url: ctx+"/agency/selectListSelectAgency",
		    	effectiveFieldsAlias: {agencyId: "机构编号",  agencyName: "分销商名称", layer:"层级"}, 
		    	effectiveFields: ["agencyId", "agencyName", "layer"],
		    	searchFields: [ "agencyId"],
		        autoSelect: false,
		        showBtn: true,
		        allowNoKeyword: false,
		        getDataMethod: "url",
		        idField: "agencyId",
		        keyField: "agencyName",
		        delayUntilKeyup: true,
		        showHeader: true,
		        showBtn: false
		    }).on('onDataRequestSuccess', function (e, result) {
		        console.log('onDataRequestSuccess: ', result);
		    }).on('onSetSelectValue', function (e, keyword, data) {
		    	$("#agencyName").val(data.agencyName);
		    	$("#agencyId").val(data.agencyId);
		    }).on('onUnsetSelectValue', function () {
		        console.log("onUnsetSelectValue");
		    });


     $('.selectize-select').selectize();


     $('.datepicker').datetimepicker({
         format: 'yyyymm',
         language: 'zh-CN',
         weekStart: 1,
         todayBtn: 0,
         autoclose: 1,
         todayHighlight: 1,
         minView: 2,
         startView:3,
         minView:3,
         forceParse: 0
     });

     //根据窗口调整表格高度
     $(window).resize(function() {
         $('#mytab').bootstrapTable('resetView', {
             height: tableHeight()
         })
     })

     $('#mytab').bootstrapTable({
         url: ctx + "/institutionsFenRunIssue/list",
         //数据源
         dataType: "json",
         //期待返回数据类型
         method: "post",
         //请求方式
         contentType: "application/x-www-form-urlencoded",
         queryParams: function(params) {
             $("#offset").val(params.offset);
             $("#limit").val(params.limit);
             return {
                 'offset': params.offset,
                 'limit': params.limit,
                 'localDate': $("#localDate").val(),
                 'agencyId' : $("#agencyId").val(),
 			     'agencyName' : $("#agencyName").val(),
                 'typeHidden': $("#typeHidden").val()
             };
         },
         striped: true,
         pagination: true,
         singleSelect: false,
         pageSize: 10,
         pageList: [10, 50, 100, 200, 500],
         search: false,
         //不显示 搜索框
         showColumns: false,
         //不显示下拉框（选择显示的列）
         sidePagination: "server",
         //服务端请求
         queryParamsType: "limit",
         //查询参数组织方式
         columns: [{
             field: "localDate",
             title: "分润月份",
             width: 100,
             align: "center"
         }, {
             field: "agencyName",
             title: "隶属机构",
             width: 200,
             align: "center"
         }, {
             field: "monthProfit",
             title: "当月分润（元）",
             width: 100,
             align: "center"
         }, ],
         locale: 'zh-CN'
     });

 });

 function reloadDate() {
     $("#mytab").bootstrapTable('refresh');
 }

 function tableHeight() {
     return $(window).height() - 50;
 }