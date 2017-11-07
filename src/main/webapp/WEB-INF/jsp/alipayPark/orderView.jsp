<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
	<title>支付宝统一下单并支付接口</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<script type="text/javascript" src="${ctx}/js/jquery-2.0.3.min.js"></script>
	<script src="https://as.alipayobjects.com/g/component/antbridge/1.1.1/antbridge.min.js"></script>
</head>
<body text=#000000 bgColor="#ffffff" leftMargin=0 topMargin=4>
	<p id="result">result: </p>

<script type="application/javascript">
    // 调试时可以通过在页面定义一个元素，打印信息，使用alert方法不够优雅
    function log(obj) {
        $("#result").append(obj).append(" ").append("<br />");
    }

    $(document).ready(function(){
        // 点击payButton按钮后唤起收银台
        $("#payButton").click(function() {
        	$.ajax({
    			type : "POST",
    			url :  "${ctx}/alipayPark/tradeCreate",
    			data : {},
    			beforeSend : function() {
    			},
    			success : function(obj) {
    				if (obj.success == 'true') {
    					 tradePay(obj.message);
    				} else {
    					alert(obj.message);
    				}
    			}
    		});
        });

        // 通过jsapi关闭当前窗口，仅供参考，更多jsapi请访问
        // /aod/54/104510
        $("#closeButton").click(function() {
           AlipayJSBridge.call('closeWebview');
        });
     });

    // 由于js的载入是异步的，所以可以通过该方法，当AlipayJSBridgeReady事件发生后，再执行callback方法
    function ready(callback) {
         if (window.AlipayJSBridge) {
             callback && callback();
         } else {
             document.addEventListener('AlipayJSBridgeReady', callback, false);
         }
    }

    function tradePay(tradeNO) {
        ready(function(){
             // 通过传入交易号唤起快捷调用方式(注意tradeNO大小写严格)
             AlipayJSBridge.call("tradePay", {
                  tradeNO: tradeNO
             }, function (data) {
                 alert(JSON.stringify(data));
                 if ("9000" == data.resultCode) {
                	 //alert("支付成功");
                	 location.href = ctx+"/alipayPark/responseParkAuth/"+ids;
                	 
                 }
                 
                 if ("4000" == data.resultCode) {
               	  Ali.alert({
                         title: '亲',
                         message: '订单支付失败',
                         button: '确定'
                     });
                }
                if ("6001" == data.resultCode) {
                  	  Ali.alert({
                            title: '亲',
                            message: '用户中途取消',
                            button: '确定'
                        });
                 }
             });
        });
    }
</script>
<br />
<br /><br /><br />
应付金额：

取出的车牌${car_number }
<input type="button" name="payButton"  id ="payButton" value="确定支付"/>
</body>
</html>