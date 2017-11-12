<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
	<title>停车付费</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" media="screen" href="https://unpkg.com/antd-mobile/dist/antd-mobile.min.css">
	<script type="text/javascript" src="${ctx}/js/jquery-2.0.3.min.js"></script>
	<script src="https://as.alipayobjects.com/g/component/antbridge/1.1.1/antbridge.min.js"></script>
	<script src="https://unpkg.com/antd-mobile/dist/antd-mobile.min.js"></script>
	
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
                 alert(JSON.stringify(data));
                 if ("9000" == data.resultCode) {
                	 //alert("支付成功");
                	 location.href = "${ctx}/alipayPark/OrderSync/"+tradeNO;
                	 
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
</head>
<body text=#000000 bgColor="#ffffff" leftMargin=0 topMargin=4>








	<div class="logo">
        <div class="ui-grid-a" style="background-color: transparent;">
            <div class="ui-btn ui-input-btn ui-corner-all ui-shadow">
               <!--  <img src="http://sass-lang.com/assets/img/logos/logo-b6e1ef6e.svg" /> -->停车费用
            </div>
        </div>
    </div>

    <div class="payment">
        <ul data-role="listview" class="ui-listview">
            <li class="ui-li-static ui-body-inherit ui-first-child" style="text-align: center; font-size: 2em;padding:1.5em 0.5em;">50.00元</li>
        </ul>
    </div>

    <div class="detail">
        <ul data-role="listview" class="ui-listview">
            <li class="ui-li-static ui-body-inherit ui-first-child">
                <div class="ui-grid-a">
                    <div class="ui-block-a"><div class="ui-bar ui-bar-a">应付金额</div></div>
                    <div class="ui-block-b"><div class="ui-bar ui-bar-a">${payMoney }</div></div>
                </div> 
            </li>
            <li class="ui-li-static ui-body-inherit ui-first-child">
                <div class="ui-grid-a">
                    <div class="ui-block-a"><div class="ui-bar ui-bar-a">已付金额</div></div>
                    <div class="ui-block-b"><div class="ui-bar ui-bar-a">${paidMoney}</div></div>
                </div> 
            </li>
            <li class="ui-li-static ui-body-inherit ui-first-child">
                <div class="ui-grid-a">
                    <div class="ui-block-a"><div class="ui-bar ui-bar-a">优惠金额</div></div>
                    <div class="ui-block-b"><div class="ui-bar ui-bar-a">${discountMoney }</div></div>
                </div> 
            </li>
             <li class="ui-li-static ui-body-inherit ui-first-child">
                <div class="ui-grid-a" style="margin:0 0.9em;padding: 0;border-top: 1px solid #ededf3;">
                    <div class="ui-block-a"><div class="ui-bar ui-bar-a" style="display: none;"></div></div>
                    <div class="ui-block-b"><div class="ui-bar ui-bar-a" style="display: none;"></div></div>
                </div> 
            </li>
            <li class="ui-li-static ui-body-inherit ui-first-child">
                <div class="ui-grid-a">
                    <div class="ui-block-a"><div class="ui-bar ui-bar-a">车牌号</div></div>
                    <div class="ui-block-b"><div class="ui-bar ui-bar-a">${car_number }</div></div>
                </div> 
            </li>
            <li class="ui-li-static ui-body-inherit ui-first-child">
                <div class="ui-grid-a">
                    <div class="ui-block-a"><div class="ui-bar ui-bar-a">入场时间</div></div>
                    <div class="ui-block-b"><div class="ui-bar ui-bar-a">${inTime }</div></div>
                </div> 
            </li>
            <li class="ui-li-static ui-body-inherit ui-first-child">
                <div class="ui-grid-a">
                    <div class="ui-block-a"><div class="ui-bar ui-bar-a">停车时长</div></div>
                    <div class="ui-block-b"><div class="ui-bar ui-bar-a">${timeDiffer }</div></div>
                </div> 
            </li>
        </ul>
    </div>
    <div class="footer" style="background-color: #f5f5f5; margin: 1em 0 0 0;border-top: 1px solid #ededf3;">
        <div class="submit">
            <button name="payButton"  id ="payButton" class="ui-btn ui-corner-all">立即支付</button>
        </div>
    </div>
<input  type ="hidden" value="${payMoney }" id="payMoney" name="payMoney"/><br />
<input  type ="hidden" value="${outOrderNo }" id="outOrderNo" name="outOrderNo"/><br />
<input  type ="hidden" value="${inDuration }" id="inDuration" name="inDuration"/><br />
<input  type ="hidden" value="${orderTime }" id="orderTime" name="orderTime"/><br />
<input  type ="hidden" value="${discountMoney }" id="discountMoney" name="discountMoney"/><br />
<c:if test="${not empty msg}">
   ${msg}
</c:if>
</body>
</html>