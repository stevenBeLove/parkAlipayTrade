 $(function() {

     $("#parentIdSelect").bsSuggest({
         url: ctx + "/agency/selectParentId",
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
         showHeader: true
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
         url: ctx + "/hisTerminalManagement/list",
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
             field: "havePsam",
             title: "是否绑定PSAM卡",
             width: 200,
             align: "center",
             formatter: function operateFormatter(value) {
                 if (value == '0') {
                     return "未绑定";
                 } else if (value == '1') {
                     return "已绑定";
                 }
             }
         }, {
             field: "psamId",
             title: "PSAM卡号",
             width: 200,
             align: "center",
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
             title: "开通时间",
             width: 100,
             align: "center"
         }, {
             field: "unbuildId",
             title: "解绑人",
             width: 100,
             align: "center"
         }, {
             field: "unbuildDate",
             title: "解绑时间",
             width: 100,
             align: "center"
         }],
         locale: 'zh-CN'
     });

 });


 function reloadDate() {
     $("#mytab").bootstrapTable('refresh');
 }

 function tableHeight() {
     return $(window).height() - 50;
 }