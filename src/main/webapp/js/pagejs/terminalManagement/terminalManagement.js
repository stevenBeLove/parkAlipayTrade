 $(function() {

     $("#parentIdSelect").bsSuggest({
         url: ctx + "/agency/selectListSelectAgency",
         effectiveFieldsAlias: {
             agencyId: "机构编号",
             agencyName: "分销商名称",
             layer: "层级"
         },
         effectiveFields: ["agencyId", "agencyName", "layer"],
         searchFields: ["agencyId"],
         autoSelect: false,
         showBtn: true,
         allowNoKeyword: false,
         getDataMethod: "url",
         idField: "agencyId",
         keyField: "agencyName",
         delayUntilKeyup: true,
         showHeader: true,
         showBtn: false
     }).on('onDataRequestSuccess', function(e, result) {
         console.log('onDataRequestSuccess: ', result);
     }).on('onSetSelectValue', function(e, keyword, data) {
         $("#agencyName").val(data.agencyName);
         $("#agencyId").val(data.agencyId);
     }).on('onUnsetSelectValue', function() {
         console.log("onUnsetSelectValue");
     });

     $('.selectize-select').selectize();

     //根据窗口调整表格高度
     $(window).resize(function() {
         $('#mytab').bootstrapTable('resetView', {
             height: tableHeight()
         })
     })

     $('#mytab').bootstrapTable({
         url: ctx + "/terminalManagement/list",
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
                 'termId': $("#termId").val(),
                 'mobile': $("#mobile").val(),
                 'orderMobile': $("#orderMobile").val(),
                 'termActivation': $("#termActivation").val(),
                 'agencyId': $("#agencyId").val(),
                 'agencyName': $("#agencyName").val(),
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
             field: "agencyName",
             title: "隶属机构",
             width: 100,
             align: "center"
         }, {
             field: "termId",
             title: "终端编号",
             width: 100,
             align: "center"
         }, {
             field: "customerName",
             title: "终端使用人",
             width: 200,
             align: "center"
         }, {
             field: "mobile",
             title: "使用人手机号",
             width: 200,
             align: "center"
         }, {
             field: "termActivation",
             title: "终端状态",
             width: 100,
             align: "center",
             formatter: function operateFormatter(value) {
                 if (value == '1') {
                     return "已激活";
                 } else if (value == '0') {
                     return "未激活";
                 }
             }
         }, {
             field: "openDate",
             title: "激活时间",
             width: 100,
             align: "center"
         }, {
             field: "orderName",
             title: "订货人",
             width: 200,
             align: "center"
         }, {
             field: "orderMobile",
             title: "订货人手机号",
             width: 200,
             align: "center"
         }, {
             field: "province",
             title: "省",
             width: 100,
             align: "center"
         }, {
             field: "city",
             title: "市",
             width: 100,
             align: "center"
         }, {
             field: "county",
             title: "区",
             width: 100,
             align: "center"
         }, {
             field: "address",
             title: "详细地址",
             width: 100,
             align: "center"
         }, {
             field: "giveDate",
             title: "发货时间",
             width: 100,
             align: "center"
         }, {
             field: "createId",
             title: "创建人",
             width: 100,
             align: "center"
         }, {
             field: "createdt",
             title: "创建时间",
             width: 100,
             align: "center"
         }, {
             field: "termId",
             title: "操作",
             width: 200,
             align: "center",
             formatter: operateAgencyFormatter
         }],
         locale: 'zh-CN'
     });

 });

 function operateAgencyFormatter(value, row, index) {
     if (row.customerName != '') {
         return "<a href='javascript:void(0);' onclick=\"terminalUnbundling('" + row.termId + "')\">解绑&nbsp;</a>";
     }
 }

 function reloadDate() {
     $("#mytab").bootstrapTable('refresh');
 }

 function tableHeight() {
     return $(window).height() - 50;
 }

 function terminalUnbundling(termId) {
     if (confirm("确认要解绑吗？")) {
         $.ajax({
             type: "GET",
             url: ctx + "/terminalManagement/terminalUnbundling/" + termId,
             success: function(obj) {
                 if (obj.success == 'true') {
                     alert('解绑成功!');
                     $('#mytab').bootstrapTable('refresh');
                 } else {
                     alert('解绑失败!');
                     $('#mytab').bootstrapTable('refresh');
                 }
             }
         });
     }
 }