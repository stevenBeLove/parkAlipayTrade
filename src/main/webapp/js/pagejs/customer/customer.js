 $(function() {
            //根据窗口调整表格高度
            $(window).resize(function() {
                $('#mytab').bootstrapTable('resetView', {
                    height: tableHeight()
                })
            })
            
             $('#mytab').bootstrapTable({
                url: ctx+"/customer/list",//数据源
                dataType: "json",//期待返回数据类型
                method: "post",//请求方式
                contentType: "application/x-www-form-urlencoded",
                queryParams : function(params) {
                    return {
                    	  'offset': params.offset,
                          'limit': params.limit,
                          'customerid' : $("#customerid").val(),
 			              'customerName' : $("#customerName").val(),
 			              'mobile':$("#mobile").val(),
 			              'payTerminalId':$("#payTerminalId").val()
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
                columns: [  
							{field : "agencyName",title : "所属机构",width : 250, align : "center"},
							{field : "customerid",title : "客户号",width : 100,align : "center"},
							{field : "customerName",title : "姓名",width : 100,align : "center"},
							{field : "mobile",title : "手机号",width : 100,align : "center"},
							{field : "payTerminalId",title : "终端编号",width : 100,align : "center"},
							{field : "customerid",title : "操作",width : 100,align : "center",
							 formatter: operateAgencyFormatter
							}
                      ],
                locale: 'zh-CN'
            });
           
        });
        
 
 		//刷新表格
 		function reloadDate(){ 
	 			$("#mytab").bootstrapTable('refresh'); 
 		}
        //窗体高度
        function tableHeight() {
            return $(window).height() - 50;
        }
        //格式化输出
        function operateAgencyFormatter(value,row,index){
        	return "<a href='javascript:void(0);' onclick=\"showCustomerDeatil('"+value+"','"+row.payTerminalId+"')\">客户详情&nbsp;</a><br>";
			//return "<a href='javascript:void(0);' onclick=\"showCustomerDeatil('"+value+"')\">客户详情&nbsp;</a>";
        }
        
        //客户详情
        function showCustomerDeatil(value,terminalId){
        	if(terminalId){
        		$.weeboxs.open(ctx+"/customer/showCustomerView/"+value+"/"+terminalId, {
            		title:'客户详情', 
            		contentType:'iframe',
            		width:850, 
            		height:380,
            		showButton:false,
            		showOk:false,
            		showCancel:false
            	});
        	}else{
        		$.weeboxs.open(ctx+"/customer/showCustomerViewWithId/"+value, {
            		title:'客户详情', 
            		contentType:'iframe',
            		width:850, 
            		height:380,
            		showButton:false,
            		showOk:false,
            		showCancel:false
            	});
        	}
        
        }
        
