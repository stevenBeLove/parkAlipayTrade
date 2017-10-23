 $(function() {
			 $('.datepicker').datetimepicker({
		     	format: 'yyyymmdd',
		        language:  'zh-CN',
		        weekStart: 1,
		        todayBtn:  0,
		 		autoclose: 1,
		 		todayHighlight: 1,
		 		minView: 2,
		 		forceParse: 0
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
							{field : "systemid",title : "来源系统",width : 100,align : "center"},
							{field : "agencyName",title : "分销商名称",width : 200,align : "center"},
							{field : "parentName",title : "上级分销商名称",width : 200,align : "center"},
							{field : "scale",title : "分佣参数",width : 100,align : "center"},
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
							formatter: function operateFormatter(value){
								 return '<a>机构详情</a>&nbsp;&nbsp;<a>参数详情</a>'; 
							}
							}
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
        
        function createTable(){
        	var agencyId = $("#agencyId").val();
        	var businessTxt = jQuery("#businessType option:selected").text();
        	var businessType = jQuery("#businessType option:selected").val();
        	if(businessType==''){
        		alert('交易类型,不能为空!');
        		return;
        	}
        	var mycost = $("#mycost").val();
        	if(mycost==''){
        		alert('起始分佣比,不能为空!');
        		return;
        	}
        	var finalRate = $("#finalRate").val();
        	if(finalRate==''){
        		alert('上三级分佣,不能为空!');
        		return;
        	}
        	var secondRate = $("#secondRate").val();
        	if(secondRate==''){
        		alert('上二级分佣,不能为空!');
        		return;
        	}
        	var nextRate = $("#nextRate").val();
        	if(nextRate==''){
        		alert('上一级分佣,不能为空!');
        		return;
        	}
        	var sumAmount = parseInt(finalRate)+parseInt(secondRate)+parseInt(nextRate);
        	if(sumAmount > parseInt(mycost)){
        		alert('三级之和不能大于起始分佣比!');
        		return;
        	}
        	
        	var userid = $("#userid").val();
        	var begindate = $("#begindate").val();
        	if(begindate==''){
        		alert('生效日期,不能为空!');
        		return;
        	}
        	var userid = $("#userid").val();
        	var nickname = $("#nickname").val();
        	
//        	if(canSave(businessTxt)){
//        		alert('交易类型，不能重复添加!');
//        		return;
//        	}
        	 if (isNaN($("#mycost").val())){
    			 alert("起始分佣比,非法字符！"); 
    			  return false;
    		 }
    		 if (isNaN($("#finalRate").val())){
    			 alert("上一级分佣,非法字符！"); 
    			  return false;
    		 } 
    		 
    		 if (isNaN($("#secondRate").val())){
    			 alert("上二级分佣,非法字符！"); 
    			  return false;
    		 } 
    		 
    		 if (isNaN($("#nextRate").val())){
    			 alert("上三级分佣,非法字符！"); 
    			  return false;
    		 } 
        	
        	var createDate = '';
        	
        	var enddate = '';
        	
        	$("#scaleListTab .no-records-found").remove();
//        	var tdVal = $("#scaleListTab tr").find("td:nth-child(1)").text();
        	var rowCount = Number($("#scaleListTab tr").length) -1;
        	var mytableCell = document.getElementById("scaleListTab").rows[rowCount].cells[0].innerHTML;  
        	var _len = Number(mytableCell)+1;
//        	var _len = Math.floor(tdVal%10)+1; 
//        	var _len = $("#scaleListTab tr").length; 
        	$("#scaleListTab").append(
        			"<tr id="+_len+" class='tr-class-1'>"
        			+ "<td>"+_len+"</td>"
        			+ "<td class='td-class-2'>"+businessTxt+"</td>" 
        			+"<td>"+mycost+"</td>"
        			+"<td>"+nextRate+"</td>"
        			+"<td>"+secondRate+"</td>"
        			+"<td>"+finalRate+"</td>"
        			+"<td>"+begindate+"</td>"
        			+"<td>"+enddate+"</td>"
        			+"<td>"+nickname+"</td>"
        			+"<td>"+createDate+"</td>"
        			+"<td>是</td>"+"<td>未生效</td>"
        			+"<td id='td-id-3' class='td-class-3'>"
        			//+"<a href='#' onclick=''>修改</a>&nbsp;&nbsp;"
        			+"<a href='#' onclick='removeScale("+_len+");'>删除</a>"
        			+"</tr>"
        	);
        }
        
        function removeScale(index){
        	if (confirm("确认要删除？")) {
        		   $.ajax({   
        		   	   type:"GET",
        		       url:  ctx+"/agency/deleteAgencyScale/"+index,
        		       success:function(obj){
        		    	  if(obj.success=='true'){
   							alert(obj.message);
   							$("tr[id='"+index+"']").remove();//删除当前行
   							location.reload();
   						}else{
   							alert(obj.message);
   						}
        		          }	          
        		     }); 
         }
        }
        
        var jsondate="";
        function saveTableCol(){
        	var _len = $("#scaleListTab tr").length-1; 
    		$("#scaleListTab tr:gt(0)").each(function(j){
    			var a = new Array();
    			$(this).children("td").each(function(k){
    				a[k]=$(this).text();
        	    });
    			saveScale(a);
        	});
        }
        
        function saveScale(a){
        	var data = {
				"agencyId" : $("#agencyId").val(),
				"businessType":a[1],
				"mycost" : a[2],
				"nextRate" : a[3],
				"secondRate" : a[4],
				"finalRate" : a[5],
				"begindate" : a[6],
				"userid" : $("#userid").val(),
				"datetime" : a[8],
				"pageAdd":a[10]
	       };
        	jsondate += JSON.stringify(data)+",";
        	$("#jsonValue").val(jsondate);
        	
        }
        
        function canSave(txt){
        	var _len = $("#scaleListTab tr").length-1; 
        	var sta = false;
        	for(i=0; i<_len; i++){
        		$("#scaleListTab tr:gt("+i+")").each(function(j){
            	    $(this).children("td").each(function(k){
            	    	if($(this).text()==txt){
            	    		sta = true;
            	    	}
            	    });
            	})
        	}
        	return sta;
        }
        
 /*       function getNowFormatDate() {
            var date = new Date();
            var seperator1 = "-";
            var seperator2 = ":";
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
                    + " " + date.getHours() + seperator2 + date.getMinutes()
                    + seperator2 + date.getSeconds();
            return currentdate;
        }*/
        
        function showUpdateScaleForm(id){
        	$.weeboxs.open(ctx+"/agency/"+id+"/showUpdateScaleForm/", {
        		title:'分佣信息修改', 
        		contentType:'iframe',
        		width:800, 
        		height:350,
        		showButton:false,
        		showOk:false,
        		showCancel:false
        	});
        }
