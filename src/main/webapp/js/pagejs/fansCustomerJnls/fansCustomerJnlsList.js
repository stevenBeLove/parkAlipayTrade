 $(function() {

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
         url: ctx + "/fansCustomerJnls/list",
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
                 'locallogno': $("#locallogno").val(),
                 'mobile': $("#mobile").val(),
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
         }, {
             field: "locallogno",
             title: "交易流水号",
             width: 100,
             align: "center"
         }, {
             field: "localdate",
             title: "交易日期",
             width: 100,
             align: "center"
         }, {
             field: "agencyName",
             title: "隶属机构",
             width: 200,
             align: "center"
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
             field: "customerName",
             title: "交易人",
             width: 100,
             align: "center"
         }, {
             field: "mobile",          
             title: "交易人手机号",
             width: 100,
             align: "center"
         }, {
             field: "parentcustomername",
             title: "上一级分佣人",
             width: 100,
             align: "center"
         }, {
             field: "parentuserid",
             title: "上一级手机号",
             width: 100,
             align: "center"
         }, {
             field: "parentRate",
             title: "上一级分佣比",
             width: 100,
             align: "center"
         }, {
             field: "parentProfit",
             title: "上一级分佣金额（元）",
             width: 100,
             align: "center"
         }, {
             field: "twocustomername",
             title: "上二级分佣人",
             width: 100,
             align: "center"
         }, {
             field: "twouserid",
             title: "上二级手机号",
             width: 100,
             align: "center"
         }, {
             field: "twoRate",
             title: "上二级分佣比",
             width: 100,
             align: "center"
         }, {
             field: "twoProfit",
             title: "上二级分佣金额（元）",
             width: 100,
             align: "center"
         }, {
             field: "topcustomername",
             title: "上三级分佣人",
             width: 100,
             align: "center"
         }, {
             field: "topuserid",
             title: "上三级手机号",
             width: 100,
             align: "center"
         }, {
             field: "topRate",
             title: "上三级分佣比",
             width: 100,
             align: "center"
         }, {
             field: "topProfit",
             title: "上三级分佣金额（元）",
             width: 100,
             align: "center"
         }, ],
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