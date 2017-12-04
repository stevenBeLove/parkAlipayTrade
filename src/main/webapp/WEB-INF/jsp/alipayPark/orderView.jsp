<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
	<title>停车付费</title>
	  <meta charset="utf-8" />
	  <meta name="description" content="" />
	  <meta name="keywords" content="" />
	  <meta name="apple-mobile-web-app-capable" content="yes" />
	  <meta name="apple-mobile-web-app-status-bar-style" content="black" />
	  <meta name="format-detection" content="telephone=no, email=no" />
	  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
	<link rel="stylesheet" href="${ctx}/js/antui/dist/antui.min.css"/>
	<script type="text/javascript" src="${ctx}/js/jquery-2.0.3.min.js"></script>
	<script src="https://as.alipayobjects.com/g/component/antbridge/1.1.1/antbridge.min.js"></script>
	<script src="${ctx}/js/antui/dist/antui.min.js"></script>
	<style type="text/css">
			.head {
				position: relative;
				background-color: #fff;
			}
			.head .logo {
				padding-top: 8px;
				font-size: 18px;
				text-align: center;
			}
			.head .logo span {
				position: relative;
				top: -6px;
				margin-left: 5px;
			}
			.pay-amount {
				padding: 30px 0;
				font-size: 40px;
				font-weight: bold;
			}
			.am-list.conent-list {
				padding: 0;
			}
			.footer {
				padding-top: 15px;
			}
			.footer .am-message {
				color: #888;
			}
			.contact {
				padding-top: 30px;
			}
	</style>
	<script type="application/javascript">
	    // 调试时可以通过在页面定义一个元素，打印信息，使用alert方法不够优雅
	    function log(obj) {
	        $("#result").append(obj).append(" ").append("<br />");
	    }
	    
	    document.addEventListener('AlipayJSBridgeReady', function () {
	        console.log(typeof AlipayJSBridge);
	        AlipayJSBridge.call("hideToolbar");
	        AlipayJSBridge.call("hideOptionMenu");
		}, false);
	    $(document).ready(function(){
	        // 点击payButton按钮后唤起收银台
	        $("#payButton").click(function() {
	        	$.ajax({
	    			type : "POST",
	    			url :  "${ctx}/alipayPark/tradeCreate",
	    			data : {
	    				'outOrderNo':$("#outOrderNo").val(),
	    				'payMoney':$("#payMoney").val(),
	    				'inDuration':$("#inDuration").val(),
	    				'orderTime':$("#orderTime").val(),
	    				'discountMoney':$("#discountMoney").val()
	    			},
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
	                 if ("9000" == data.resultCode) {
	                	 orderSync(tradeNO);
	                	 //AlipayJSBridge.call('closeWebview');
	                	 //location.href = "${ctx}/alipayPark/OrderSync/"+tradeNO;
	                 }
	                 if ("4000" == data.resultCode) {
	               	  Ali.alert({
	                         title: '亲',
	                         message: '您已主动取消支付',
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
	    
	    function orderSync(tradeNO){
	    	$.ajax({
				type : "POST",
				url :  "${ctx}/alipayPark/OrderSync/",
				data : {
					'tradeNO':tradeNO
				},
				success : function(obj) {
					if (obj.success == 'true') {
						 AlipayJSBridge.call('closeWebview');
					} else {
						alert(obj.message);
					}
				}
			});
	    }
	</script>
</head>
<body ontouchstart="">

<c:if test="${empty status}">
<div class="head">
		<div class="logo">
			<img src="${merchantLogo }">
			<span>${isvName }</span>
		</div>
		<div class="am-ft-center pay-amount">${payMoney }元</div>
</div>

<div class="am-list conent-list">
	    <a class="am-list-item">
	        <div class="am-list-content am-list-cell-noflex">应付金额</div>
	        <div class="am-list-extra">${payMoney }</div>
	    </a>
	    <a class="am-list-item">
	        <div class="am-list-content am-list-cell-noflex">已付金额</div>
	        <div class="am-list-extra">${paidMoney}</div>
	    </a>
	    <a class="am-list-item">
	        <div class="am-list-content am-list-cell-noflex">优惠金额</div>
	        <div class="am-list-extra">${discountMoney }</div>
	    </a>
	    <a class="am-list-item">
	        <div class="am-list-content am-list-cell-noflex">车牌号</div>
	        <div class="am-list-extra">${car_number }</div>
	    </a>
	    <a class="am-list-item">
	        <div class="am-list-content am-list-cell-noflex">入场时间</div>
	        <div class="am-list-extra">${inTime }</div>
	    </a>
	    <a class="am-list-item">
	        <div class="am-list-content am-list-cell-noflex">停车时长</div>
	        <div class="am-list-extra">${timeDiffer }</div>
	    </a>
</div>
<div class="footer">
		<div class="am-message week" role="alert">
		  <i class="am-icon message-week info" aria-hidden="true"></i>
		  <div class="am-message-main">请于付款后15分钟内离场，超时将加收停车费</div>
		</div>
		<div class="am-content">
			<c:if test="${empty payBtn}">
				<button id ="payButton" class="am-button blue">立即支付</button>
			</c:if>
			<c:if test="${not empty payBtn}">
				<button disabled="disabled" class="am-button disabled" class="am-button blue">立即支付</button>
			</c:if>
		</div>
</div>
<div class="am-ft-center contact">
	<p>本服务由${isvName }提供</p>
	<p><span>客服电话</span><a tel="${isvPhone }">${isvPhone }</a><span></span></p>
</div>

	<input  type ="hidden" value="${payMoney }" id="payMoney" name="payMoney"/><br />
	<input  type ="hidden" value="${outOrderNo }" id="outOrderNo" name="outOrderNo"/><br />
	<input  type ="hidden" value="${inDuration }" id="inDuration" name="inDuration"/><br />
	<input  type ="hidden" value="${orderTime }" id="orderTime" name="orderTime"/><br />
	<input  type ="hidden" value="${discountMoney }" id="discountMoney" name="discountMoney"/><br />
</c:if>
<c:if test="${not empty status}">
		  <div class="am-page-result" style="padding-top:0px;">
	        <div class="am-page-result-wrap combine-page">
	          <div class="am-page-result-pic am-icon page-err"></div>
	          <div class="am-page-result-title">${msg}</div>
	        </div>
	      </div>
</c:if>
</body>
</html>