<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
  <!-- A11Y：打开页面时，屏幕阅读器会首先阅读 title 的内容，确保 title 准确描述页面 -->
  <title>Examples</title>
  <meta name="description" content="" />
  <meta name="keywords" content="" />
  <meta name="apple-mobile-web-app-capable" content="yes" />
  <meta name="apple-mobile-web-app-status-bar-style" content="black" />
  <meta name="format-detection" content="telephone=no, email=no" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
  <!-- A11Y：如果有无障碍方面的需求，建议使用下面的 viewport 设置，不要禁止页面缩放 -->
  <!--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />-->
  <link rel="stylesheet" type="text/css" href="../dist/antui.min.css" media="all">
  <link rel="stylesheet" href="https://as.alipayobjects.com/g/component/swiper/3.2.7/swiper.min.css" />
  <script src="../dist/antui.min.js"></script>
  

  
    <style>
html{height: 100%;}
body{height:100%;overflow-x: hidden;}
.widget-list-panel{
	position: relative;
	background: -webkit-linear-gradient(-120deg, #2288CD, #1471B2) top right no-repeat;
	-webkit-background-size:100%;
	height: 100%;
}
.widget-list-panel .header{
	position:relative;
	padding-bottom: 32px;
	color: #fff;
	text-align: center;
	z-index: 1;
}
.widget-list-panel h1{
	font-size: 40px;
	line-height: 48px;
	font-weight: 300;
	padding-top: 32px;
}
.widget-list-panel .header-info{
	font-size: 17px;
	line-height: 21px;
	padding-top: 6px;
}
.x-bg{
	position: absolute;
	width: 50%;
	min-width: 325px;
	height: 100%;
	right: 0;
	top: 0;
	background: url('https://os.alipayobjects.com/rmsportal/ZbQiBgorAUacvlC.png') no-repeat right top;
	background-size: 100% auto;
	z-index: 1;
}

.widget-list{
	padding: 0px 15px 15px 0;
	list-style: none;
	display:table;
	table-layout: fixed;
	box-sizing: border-box;
	width: 100%;
	max-width: 1200px;
	margin: 0 auto;
}
.widget-list .widget-item {
	display: inline-block;
	list-style: none;
	width: 50%;
	padding: 15px 0 0 15px;
	box-sizing: border-box;
	text-align: center;
}
.widget-list .widget-wrap{
	display: block;
	width: 100%;
	height: 100%;
	background: rgba(255, 255, 255, 0.8);
	border-radius: 3px;
	padding: 23px 15px 20px;
	box-sizing: border-box;
}
.widget-list .widget-wrap:active{
	background: rgba(238, 238, 238, 0.85);
	border-radius: 3px;
}
.widget-list .icon{
	display: inline-block;
	width: 30px;
	height: 30px;
	background: url('https://os.alipayobjects.com/rmsportal/ErzQirFUtUPzGTm.png') no-repeat center;
	background-size: 32px auto;
}
.widget-list .icon.button{
	background-position: -1px -1px;
}

.widget-list .icon.list {
	background-position: -1px -65px;
}
.widget-list .icon.message {
	background-position: -1px -97px;
}
.widget-list .icon.notice {
	background-position: -1px -129px;
}

.widget-list .icon.popmenu {
	background-position: -1px -193px;
}
.widget-list .icon.process {
	background-position: -1px -225px;
}

.widget-list .icon.search {
	background-position: -1px -289px;
}

.widget-list .icon.tab {
	background-position: -1px -321px;
}

.widget-list .icon.dialog {
	background-position: -1px -33px;
}

.widget-list .icon.loading {
	background-position: -1px -256px;
}

.widget-list .icon.page-result {
	background-position: -1px -160px;
}

.widget-list .name{
	font-size: 15px;
	color: #000;
	margin: 9px 0 4px;
	line-height: 17px;
	font-weight: 300;
}
.widget-list .info{
	font-size: 12px;
	color: #888;
}
.widget-demo-show-panel{
	background: #fff;
}

.demo .am-button, .demo .am-tab, .demo .am-message, .demo .am-notice, .demo .am-inform{
	margin-bottom: 5px;
}

.demo .am-message.multi,
.demo .am-button-wrap .am-button,
.demo .am-button-group .am-button,
.demo .am-button.bottom:last-child{
	margin-bottom: 0;
}
.demo .am-button.bottom{
	position: relative;
}

.demo .demo-content{
	padding-bottom: 60px;
}

.demo.demo-button .demo-content:last-child,
.demo.demo-loading .demo-content{
	padding-bottom: 0;
}

.demo-dialog .demo-content{
	min-height: 450px;
	background: rgba(1,1,1,0.35);
	position: relative;
}
.demo-toast .demo-content{
	min-height: 300px;
	position: relative;
}
.demo-toast .am-toast{
	position: absolute;
}
.demo-page-result .demo-content{
	min-height: 300px;
}
.demo-header{
	text-align: center;
	font-size: 30px;
	padding-top: 32px;
}
.demo-header-brief{
	text-align: center;
	color: #888;
	font-size: 18px;
	padding-bottom: 32px;
	font-weight: 300;
	margin-bottom: -11px;
}
.demo-search .demo-type-title{
	font-weight: 300;
}
.demo-search .demo-type-title,
.demo-notice .demo-type-title{
	color: #888;
	font-size: 13px;
	padding: 60px 15px 9px;
	display: inline-block;
	width: 100%;
	box-sizing: border-box;
}
.demo-popmenu .demo-type-title,
.demo-dialog .demo-type-title,
.demo-page-result .demo-type-title,
.demo-toast .demo-type-title,
.demo-loading .demo-type-title{
	margin-top: 50px;
	font-size: 15px;
	padding: 11px 15px;
	background-color: #3a3a3a;
	color: #fff;
	text-align: center;
	position: relative;
}
.demo-loading .demo-type-title{
	margin-top: 0;
}
.demo-popmenu .demo-type-title i.dot{
	position: absolute;
	right: 15px;
	top: 0px;
	font-size: 24px;
	line-height: 30px;
}
.demo-popmenu .demo-content{
	position: relative;
	min-height: 160px;
}
.demo-popmenu .am-popmenu-mask{
	position: absolute;
}

.swiper-slide{
	height: auto;
	position: static;
	display: block;

}

@media only screen and (min-width: 800px) {
	.widget-list .widget-item{
		width: 33%;
	}
}
</style>
</head>
<body>

    <div class="widget-demo-show-panel" style="">
	  <div class="demo demo-article">
	  	 <div class="am-ft-center">
		 		<img width="30px;" src="https://os.alipayobjects.com/rmsportal/OhSzVdRBnfwiuCK.png" alt=""> &nbsp;
		 		 文字中对齐
		</div>
	    <div class="demo-header">30.00</div>
	    <div class="demo-header-brief"></div>
	
	    </div>
	 </div>
    
    
    <div class="am-flexbox-item">
		<div class="am-list am-list-twoline-side">
		
		    <div class="am-list-body">
		        <div class="am-list-item">
		            <div class="am-list-content">
		                <div class="am-list-title">标题一</div>
		            </div>
		            <div class="am-list-extra">
		                <div class="am-list-brief">标题二</div>
		            </div>
		        </div>
		        
		         <div class="am-list-item">
		            <div class="am-list-content">
		                <div class="am-list-title">标题一</div>
		            </div>
		            <div class="am-list-extra">
		                <div class="am-list-brief">标题二</div>
		            </div>
		        </div>
		        <div class="am-list-item">
		            <div class="am-list-content">
		                <div class="am-list-title">标题一</div>
		            </div>
		            <div class="am-list-extra">
		                <div class="am-list-brief">标题二</div>
		            </div>
		        </div>
		    </div>
		    
		      <div class="am-list-body">
		        <div class="am-list-item">
		            <div class="am-list-content">
		                <div class="am-list-title">标题一</div>
		            </div>
		            <div class="am-list-extra">
		                <div class="am-list-brief">标题二</div>
		            </div>
		        </div>
		        
		         <div class="am-list-item">
		            <div class="am-list-content">
		                <div class="am-list-title">标题一</div>
		            </div>
		            <div class="am-list-extra">
		                <div class="am-list-brief">标题二</div>
		            </div>
		        </div>
		        <div class="am-list-item">
		            <div class="am-list-content">
		                <div class="am-list-title">标题一</div>
		            </div>
		            <div class="am-list-extra">
		                <div class="am-list-brief">标题二</div>
		            </div>
		        </div>
		    </div>
		    
		    
		</div>
    
    
    <div class="demo-content" style="margin: 0 15px 60px;">
    	  <button type="button" class="am-button blue">蓝色按钮(主按钮)</button>
    </div>
    
    
    
    </div>



</body>
</html>