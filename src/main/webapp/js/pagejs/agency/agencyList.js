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
		    
		    $("#pageListAgencySelect").bsSuggest({
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
		    	//$("#agencyId").val(data.agencyId);
		    }).on('onUnsetSelectValue', function () {
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
                url: ctx+"/agency/list",//数据源
                dataType: "json",//期待返回数据类型
                method: "post",//请求方式
                contentType: "application/x-www-form-urlencoded",
                queryParams : function(params) {
                    return {
                    	  'offset': params.offset,
                          'limit': params.limit,
                          'agencyId' : $("#agencyId").val(),
 			              'agencyName' : $("#agencyName").val(),
 			              'status':$("#status option:selected").val()
                        };
                },
                striped: true,
                pagination: true,
                singleSelect: false,
                pageSize: 10,
                pageList: [10, 50, 100, 200, 500],
                search: false, //不显示 搜索框
                showColumns: false, //不显示下拉框（选择显示的列）
                sidePagination: "server", //服务端请求
                queryParamsType: "limit",//查询参数组织方式
                columns: [ 	{radio: true}, 
                           	{field : "agencyId",title : "机构编码",width : 100,align : "center"},
							{field : "agencyName",title : "分销商名称",width : 200,align : "center"},
							{field : "parentName",title : "上级分销商名称",width : 200,align : "center"},
							{field : "status",title : "机构状态",width : 100,align : "center",formatter: function operateFormatter(value){
								if(value == '00'){
									return "审核通过";
								}else if(value == '01'){
									return "待审核";
								}else if(value == '02'){
									return "待配置参数";
								}else if(value == '03'){
									return "审核驳回";
								}
								}
							},
							{field : "username",title : "创建人",width : 100,align : "center"},
							{field : "datetime",title : "创建时间",width : 100,align : "center"},
							{field : "customerid",title : "操作",width : 200,align : "center",
							formatter: operateAgencyFormatter
							}
                      ],
                locale: 'zh-CN'
            });
            
        });
        
		 function operateAgencyFormatter(value,row,index){
				return "<a href='javascript:void(0);' onclick=\"showAgencyDeatil('"+row.agencyId+"')\">机构详情&nbsp;</a><a href='javascript:void(0);' onclick=\"showScaleDeatil('"+row.agencyId+"')\">参数详情</a>";
		}
 
 		function reloadDate(){
	 			$("#mytab").bootstrapTable('refresh'); 
 		}
        
        function tableHeight() {
            return $(window).height() - 50;
        }
        
        function addAgency(){
        	location.href = ctx+"/agency/create";
        }
        
        function modifyAgency(){
        	var ids = $.map($('#mytab').bootstrapTable('getSelections'), function (row) {
                return row.agencyId;
            });
        	if(ids==''){
        		alert('请选择修改的记录!');
        		return;
        	}
        	location.href = ctx+"/agency/update/"+ids;
        }
        
        
        
        function deleteAgency(){
        	var ids = $.map($('#mytab').bootstrapTable('getSelections'), function (row) {
                return row.agencyId;
            });
        	if(ids==''){
        		alert('请选择修改的记录!');
        		return;
        	}
        	
        	if (confirm("确认要删除？")) {
           		   $.ajax({   
           		   	   type:"GET",
           		       url:  ctx+"/agency/delete/"+ids,
           		       success:function(obj){
           		    	  if(obj.success=='true'){
      							alert(obj.message);
      							$('#mytab').bootstrapTable('refresh');
      						}else{
      							alert(obj.message);
      							$('#mytab').bootstrapTable('refresh');
      						}
           		          }	          
           		     }); 
            }
        	
        }
        
        
        function createScale(){
        	var ids = $.map($('#mytab').bootstrapTable('getSelections'), function (row) {
                return row.agencyId;
            });
        	if(ids==''){
        		alert('请选择修改的记录!');
        		return;
        	}
        	location.href = ctx+"/agency/createScale/"+ids;
        } 
        
        //机构详情
        function showAgencyDeatil(agencyId){
        	$.weeboxs.open(ctx+"/agency/showAgencyView/"+agencyId, {
        		title:'机构详情', 
        		contentType:'iframe',
        		width:950, 
        		height:450,
        		showButton:false,
        		showOk:false,
        		showCancel:false
        	});
        }
        
        
        //分佣详情
        function showScaleDeatil(agencyId){
        	$.weeboxs.open(ctx+"/agency/showScaleView/"+agencyId, {
        		title:'分佣详情', 
        		contentType:'iframe',
        		width:950, 
        		height:450,
        		showButton:false,
        		showOk:false,
        		showCancel:false
        	});
        }
        
        
