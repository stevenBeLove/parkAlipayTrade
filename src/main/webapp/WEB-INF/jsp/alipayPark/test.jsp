<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
  <!-- A11Y：打开页面时，屏幕阅读器会首先阅读 title 的内容，确保 title 准确描述页面 -->
  <title>Examples</title>
 <meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
	<meta name="format-detection" content="telephone=no, email=no" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
	<link rel="stylesheet" href="https://a.alipayobjects.com/g/antui/antui/10.0.18/dpl/antui-all.css"/>
	<script src="https://a.alipayobjects.com/g/antui/antui/10.0.18/antui.js"></script>
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
</head>
<body>
	<div class="head">
		<div class="logo">
			<img src="http://ecopublic-sit.oss-cn-hangzhou.aliyuncs.com/eco/carlife/parking/merchantlogo/yuntingfengchi4008208979.png">
			<span>行呗停车场</span>
		</div>
		<div class="am-ft-center pay-amount">5.00元</div>
	</div>
	<div class="am-list conent-list">
	    <a class="am-list-item">
	        <div class="am-list-content am-list-cell-noflex">应付金额</div>
	        <div class="am-list-extra">5.00</div>
	    </a>
	    <a class="am-list-item">
	        <div class="am-list-content am-list-cell-noflex">已付金额</div>
	        <div class="am-list-extra">0.00</div>
	    </a>
	    <a class="am-list-item">
	        <div class="am-list-content am-list-cell-noflex">优惠金额</div>
	        <div class="am-list-extra">0.00</div>
	    </a>
	</div>
	<div class="am-list conent-list">   
	    <a class="am-list-item">
	        <div class="am-list-content am-list-cell-noflex">车牌号</div>
	        <div class="am-list-extra">浙A5555530</div>
	    </a>
	    <a class="am-list-item">
	        <div class="am-list-content am-list-cell-noflex">入场时间</div>
	        <div class="am-list-extra">2016-12-12 16:21:02</div>
	    </a>
	    <a class="am-list-item">
	        <div class="am-list-content am-list-cell-noflex">停车时长</div>
	        <div class="am-list-extra">0小时20分钟13秒</div>
	    </a>
	</div>
	<div class="footer">
		<div class="am-message week" role="alert">
		  <i class="am-icon message-week info" aria-hidden="true"></i>
		  <div class="am-message-main">请于付款后15分钟内离场，超时将加收停车费</div>
		</div>
		<div class="am-content">
			<button type="button" class="am-button">立即付款</button>
		</div>
	</div>
	<div class="am-ft-center contact">
		<p>本服务由行呗提供</p>
		<p><span>客服电话</span><a tel="400-0000-165">400-0000-165</a><span>(转3号线)</span></p>
	</div>
</body>
</html>