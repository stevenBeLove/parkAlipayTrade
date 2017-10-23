 $(function() {
 
  $('.datepicker').datetimepicker({
		    	        format: 'yyyymmddhhii',
                        startView:1,
				        language:  'zh-CN',
				        weekStart: 1,
				        todayBtn:  0,
				 		autoclose: 1,
				 		todayHighlight: 1,
				 		minView: 2,
				 		forceParse: 0,
				 		
				     });
		    
            //根据窗口调整表格高度
            $(window).resize(function() {
                $('#mytab').bootstrapTable('resetView', {
                    height: tableHeight()
                })
            })
            
             $('#mytab').bootstrapTable({
                url: ctx+"/systemManagement/list",//数据源
                dataType: "json",//期待返回数据类型
                method: "post",//请求方式
                contentType: "application/x-www-form-urlencoded",
                queryParams : function(params) {
                    return {
                    	  'offset': params.offset,
                          'limit': params.limit,
                          'parName' : $("#parName").val()
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
                columns: [ 	{field: 'idd',radio: true}, 
                            {field : "id",title : "序号",width : 100,align : "center",  
			                    formatter : function(value, row, index) {  
			                        var page = $('#mytab').bootstrapTable("getPage");  
			                        return page.pageSize * (page.pageNumber - 1) + index + 1;  
			                    } 
			                },
                			{field : "parNo",title : "参数编码",width : 100,align : "center"},
                           	{field : "parName",title : "参数名称",width : 100,align : "center"},
                           	{field : "parMin",title : "参数最小值",width : 100,align : "center"},
                           	{field : "parMax",title : "参数最大值",width : 100,align : "center"},
							{field : "parRemark",title : "参数说明",width : 100,align : "center"},
							{field : "createDate",title : "创建日期",width : 100,align : "center"},
							{field : "status",title : "状态",width : 100,align : "center",formatter: function operateFormatter(value){
								if(value == '0'){
									return "无效";
								}else if(value == '1'){
									return "有效";
								}
								}
							},
                      ],
                locale: 'zh-CN'
            });
           
        });
        
 		function reloadDate(){
	 			$("#mytab").bootstrapTable('refresh'); 
 		}
        
        function tableHeight() {
            return $(window).height() - 50;
        }
        
        
      
        
        
        
        
        
