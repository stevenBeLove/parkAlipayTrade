 $(function() {
		    
		    $('.selectize-select').selectize();
		    
            //根据窗口调整表格高度
            $(window).resize(function() {
                $('#mytab').bootstrapTable('resetView', {
                    height: tableHeight()
                })
            })
            
             $('#mytab').bootstrapTable({
                url: ctx+"/user/userPagelist",//数据源
                dataType: "json",//期待返回数据类型
                method: "post",//请求方式
                contentType: "application/x-www-form-urlencoded",
                queryParams : function(params) {
                    return {
                    	  'offset': params.offset,
                          'limit': params.limit,
                          'nickname' : $("#nickname").val(),
                          'username' : $("#username").val()
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
                           	{field : "nickname",title : "昵称",width : 200,align : "center"},
							{field : "username",title : "用户名",width : 200,align : "center"},
							{field : "organizationName",title : "所属组织",width : 200,align : "center"},
							{field : "roleNames",title : "角色列表",width : 400,align : "center"}
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
        
        function addUser(){
        	location.href = ctx+"/user/create";
        }
        
        
        function modifyUser(){
        	var ids = $.map($('#mytab').bootstrapTable('getSelections'), function (row) {
                return row.id;
            });
        	if(ids==''){
        		alert('请选择修改的记录!');
        		return;
        	}
        	location.href = ctx+"/user/"+ids+"/update/";
        }
        
        
        
        function deleteUser(){
        	var ids = $.map($('#mytab').bootstrapTable('getSelections'), function (row) {
                return row.id;
            });
        	if(ids==''){
        		alert('请选择修改的记录!');
        		return;
        	}
        	location.href = ctx+"/user/"+ids+"/delete/";
        	
        }
        
        
        function modifyUserPwd(){
        	var ids = $.map($('#mytab').bootstrapTable('getSelections'), function (row) {
                return row.id;
            });
        	if(ids==''){
        		alert('请选择修改的记录!');
        		return;
        	}
        	location.href = ctx+"/user/"+ids+"/changePassword/";
        } 
        
        
