 $(function() {
		    $("#importAgencySelect").bsSuggest({
		    	url: ctx+"/agency/select",
		    	effectiveFieldsAlias: {agencyId: "机构编号",  companyname: "企业名称"}, 
		    	effectiveFields: ["agencyId", "companyname"],
		    	searchFields: [ "agencyId"],
		        autoSelect: false,
		        showBtn: true,
		        allowNoKeyword: false,
		        getDataMethod: "url",
		        idField: "agencyId",
		        keyField: "companyname",
		        delayUntilKeyup: true,
		        showHeader: true,
		        showBtn: false
		    }).on('onDataRequestSuccess', function (e, result) {
		        console.log('onDataRequestSuccess: ', result);
		    }).on('onSetSelectValue', function (e, keyword, data) {
		        selectValue(data);
		    }).on('onUnsetSelectValue', function () {
		        console.log("onUnsetSelectValue");
		    });
		    
		    
		    $("#parentIdSelect").bsSuggest({
		    	url: ctx+"/agency/selectParentId",
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
		    	$("#parentId").val(data.agencyId);
		    	$("#parentName").val(data.agencyName);
		    	var parentLayer = parseInt(data.layer)+1;
		    	$("#layer").val(parentLayer);
		    }).on('onUnsetSelectValue', function () {
		        console.log("onUnsetSelectValue");
		    });
		    
		    $('.selectize-select').selectize();
		    
        });
        
        function tableHeight() {
            return $(window).height() - 50;
        }
        
        function addAgency(){
        	location.href = ctx+"/agency/create";
        }
        
        function selectValue(data){
        	$("#systemid").val(data.systemid);
	        $("#agencyId").val(data.agencyId);
	        $("#agencyName").val(data.companyname);
	        $("#companyaddr").val(data.companyaddr);
	        $("#contactsname").val(data.contactsname);
	        $("#legalInfo").val(data.legalInfo);
	        
        }
        //表单验证
        function check() {
    		if ($("#agencyId").val() == '') {
    			alert('机构不能为空');
    			return false;
    		}

    		if ($("#parentId").val() == '') {
    			alert('请选择上级机构');
    			return false;
    		}
    		var re = /^1\d{10}$/;
    		var mobile = $("#mobile").val();
    		if (!re.test(mobile) || mobile == '') {
    			alert("结算人手机填写错误!");
    			return false;
    		}
    		var name = $("#name").val();
    		if (name == '') {
    			alert('结算人姓名不能为空!');
    			return false;
    		}
    		var idCardNum = $("#idCardNum").val();
    		if (idCardNum == '') {
    			alert('结算人身份证号!');
    			return false;
    		}
    		var accountno = $("#accountno").val();
    		if (accountno == '') {
    			alert('银行卡号!');
    			return false;
    		}

    	}

        //验证三要素
    	function validateThreeElement() {
    		var re = /^1\d{10}$/;
    		var mobile = $("#mobile").val();
    		if (!re.test(mobile) || mobile == '') {
    			alert("结算人手机填写错误!");
    			return;
    		}
    		var name = $("#name").val();
    		if (name == '') {
    			alert('结算人姓名不能为空!');
    			return;
    		}
    		var idCardNum = $("#idCardNum").val();
    		if (idCardNum == '') {
    			alert('结算人身份证号!');
    			return;
    		}
    		var accountno = $("#accountno").val();
    		if (accountno == '') {
    			alert('银行卡号!');
    			return;
    		}
    		var params = $("#agencyForm").serialize();
    		//验证三要素
    		$.ajax({
    			type : "POST",
    			url : ctx + "/agency/validateTreeElement/",
    			data : params,
    			beforeSend : function() {
    				$.weeboxs.open('正在提交，请稍等。。。。。。。', {
    					title : '提示',
    					showButton : false,//不显示按钮栏
    					showOk : false,//不显示确定按钮
    					showCancel : false
    				//不显示取消按钮		
    				});
    			},
    			complete : function() {
    				$.weeboxs.close();
    			},
    			error : function() {
    				$.weeboxs.close();
    			},
    			success : function(obj) {
    				$.weeboxs.close();
    				if (obj.success == 'true') {
    					$("#name").attr("readonly","readonly");
    					$("#idCardNum").attr("readonly","readonly");
    					$("#accountno").attr("readonly","readonly");
    					alert(obj.message);
    				} else {
    					alert(obj.message);
    				}
    			},
    		});

    	}
