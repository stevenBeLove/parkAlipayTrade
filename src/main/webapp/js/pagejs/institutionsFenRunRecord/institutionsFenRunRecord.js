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
		    
		    

     $('.datepicker').datetimepicker({
         format: 'yyyymmdd',
         language: 'zh-CN',
         weekStart: 1,
         todayBtn: 0,
         autoclose: 1,
         todayHighlight: 1,
         minView: 2,
         forceParse: 0
     });

  
  
     //根据窗口调整表格高度
     $(window).resize(function() {
         $('#mytab').bootstrapTable('resetView', {
             height: tableHeight()
         })
     })

     $('#mytab').bootstrapTable({
         url: ctx + "/institutionsFenRunRecord/list",
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
                 'localBeginDate': $("#localBeginDate").val(),
                 'localEndDate': $("#localEndDate").val(),
                 'businessType': $("#businessType").val(),
                 'localLogno': $("#localLogno").val(),
                 'mobile': $("#mobile").val(),
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
             field: "frid",
             title: "序号",
             width: 100,
             align: "center",  
             formatter : function(value, row, index) {  
                 var page = $('#mytab').bootstrapTable("getPage");  
                 return page.pageSize * (page.pageNumber - 1) + index + 1;  
             } 
         },{
             field: "localLogno",
             title: "交易流水号",
             width: 100,
             align: "center",
         }, {
             field: "localDate",
             title: "交易日期",
             width: 100,
             align: "center",
         }, {
             field: "agencyName",
             title: "隶属机构",
             width: 200,
             align: "center",
         }, {
             field: "agencyId",
             title: "隶属机构编号",
             width: 200,
             align: "center",
         }, {
             field: "businessType",
             title: "交易类型编码",
             width: 200,
             align: "center",
             hidden : true,
         },{
             field: "businessName",
             title: "交易类型",
             width: 200,
             align: "center",formatter : function(value, row, index) {  
                    if (row.businessType) {  
                        return row.businessName;  
                    } else {  
                        return value;  
                    }  
                }  
         },  {
             field: "amount",
             title: "交易金额（元）",
             width: 100,
             align: "center"
         }, {
             field: "customername",
             title: "交易人",
             width: 100,
             align: "center"
         }, {
             field: "mobile",          
             title: "交易人手机号",
             width: 100,
             align: "center"
         }, {
             field: "superAgencyName",          
             title: "可分润机构",
             width: 100,
             align: "center"
         }, {
             field: "superAgencyId",          
             title: "可分润机构编号",
             width: 100,
             align: "center"
         }, {
             field: "rate",
             title: "分润比",
             width: 100,
             align: "center"
         }, {
             field: "monthProfit",
             title: "分润金额",
             width: 100,
             align: "center"
         } ],
         locale: 'zh-CN'
     });
     
	$('#mytab').bootstrapTable('hideColumn', 'businessType');
 });

 function reloadDate() {
     $("#mytab").bootstrapTable('refresh');
 }

 function tableHeight() {
     return $(window).height() - 50;
 }