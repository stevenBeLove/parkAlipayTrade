package com.qt.sales.model;

import java.math.BigDecimal;
import java.util.Date;

import com.qt.sales.common.RSConsts;

public class OrderBean {

    private String     orderNo;

    private String     userId;

    private String     outParkingId;

    private String     parkingName;

    private String     carNumber;

    private String     outOrderNo;

    /**
     * 订单状态 0：创建 1支付宝同步创建 2支付成功
     */
    private String     orderStatus;

    private String     orderTime;

    private String     payTime;

    private String     payType;

    private BigDecimal payMoney;

    private String     inTime;

    private String     parkingId;

    private String     inDuration;

    private String     cardNumber;

    private BigDecimal discountMoney;

    private BigDecimal paidMoney;

    private String     sellerId;

    private String     outTime;

    /**
     * 订单是否同步
     */
    private String     orderSynStatus;

    /**
     * 订单支付状态
     */
     private String orderPayStatus;

    /**
     * 车辆ID
     */
    private String     carId;

    private String     carType;

    private String     carColor;

    /**
     * 交易号
     */
    private String     orderTrade;

    /**
     * 车牌颜色
     */
    private String     carNumberColor = RSConsts.car_number_color_blue;

    /**
     * 外部申请退款请求流水，ISV唯一
     */
    private String     outRefundNo;
    
    /**
     * 退款金额
     */
    private BigDecimal refundMoney;
    
    


    // 订单状态
    public enum OrderStatus {
        /**
         * 成功
         */
        sucess("0"),
        /**
         * 失败
         */
        failed("1"),
        /**
         * 退款
         */
        refund("2");
        private String val;

        private OrderStatus(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    // 订单状态
    public enum OrderSynStatus {
        /**
         * 创建
         */
        create("0"),
        /**
         * 同步创建
         */
        sync("1"),
        /**
         * 支付成功
         */
        paysucess("2");
        private String val;

        private OrderSynStatus(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    public enum PayTypeStatus {
        /**
         * 在线缴费
         */
        onlinePay("1"),
        /**
         * 支付宝代扣
         */
        insteadAlipay("2");
        private String val;

        private PayTypeStatus(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    public enum AgreementStatus {
        /**
         * 车牌代扣状态，0：为支持代扣，1：为不支持代扣
         */
        agree("0"),
        /**
         * 支付宝代扣
         */
        disagree("1");
        private String val;

        private AgreementStatus(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    public enum OrderPayStatus {
        /**
         * 交易成功
         */
        success("0"),
        /**
         * 退款成功
         */
        refund("1"),
        /**
         * 退款失败
         */
        refundFailed("2");
        private String val;

        private OrderPayStatus(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 外部申请退款请求流水，ISV唯一
     * 返回类型：@return outRefundNo .<br/>
     */
    public String getOutRefundNo() {
        return outRefundNo;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2017年11月24日 下午9:12:08 <br/>
     * 外部申请退款请求流水，ISV唯一
     * 参数: @param  outRefundNo 设置值.  <br/>
     */
    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getOrderTrade() {
        return orderTrade;
    }

    public void setOrderTrade(String orderTrade) {
        this.orderTrade = orderTrade;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return carType .<br/>
     */
    public String getCarType() {
        return carType;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2017年11月9日 下午1:48:24 <br/>
     * 参数: @param carType 设置值. <br/>
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return carColor .<br/>
     */
    public String getCarColor() {
        return carColor;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2017年11月9日 下午1:48:24 <br/>
     * 参数: @param carColor 设置值. <br/>
     */
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOutParkingId() {
        return outParkingId;
    }

    public void setOutParkingId(String outParkingId) {
        this.outParkingId = outParkingId == null ? null : outParkingId.trim();
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName == null ? null : parkingName.trim();
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo == null ? null : outOrderNo.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime == null ? null : orderTime.trim();
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime == null ? null : payTime.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime == null ? null : inTime.trim();
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId == null ? null : parkingId.trim();
    }

    public String getInDuration() {
        return inDuration;
    }

    public void setInDuration(String inDuration) {
        this.inDuration = inDuration == null ? null : inDuration.trim();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public BigDecimal getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(BigDecimal discountMoney) {
        this.discountMoney = discountMoney;
    }

    public BigDecimal getPaidMoney() {
        return paidMoney;
    }

    public void setPaidMoney(BigDecimal paidMoney) {
        this.paidMoney = paidMoney;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return outTime .<br/>
     */
    public String getOutTime() {
        return outTime;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2017年11月10日 下午5:53:08 <br/>
     * 参数: @param outTime 设置值. <br/>
     */
    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getOrderSynStatus() {
        return orderSynStatus;
    }

    public void setOrderSynStatus(String orderSynStatus) {
        this.orderSynStatus = orderSynStatus == null ? null : orderSynStatus.trim();
    }

    //
    // public String getOrderPayStatus() {
    // return orderPayStatus;
    // }
    //
    // public void setOrderPayStatus(String orderPayStatus) {
    // this.orderPayStatus = orderPayStatus == null ? null :
    // orderPayStatus.trim();
    // }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return carNumberColor .<br/>
     */
    public String getCarNumberColor() {
        return carNumberColor;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2017年11月24日 上午10:00:33 <br/>
     * 参数: @param carNumberColor 设置值. <br/>
     */
    public void setCarNumberColor(String carNumberColor) {
        this.carNumberColor = carNumberColor;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return orderPayStatus .<br/>
     */
    public String getOrderPayStatus() {
        return orderPayStatus;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2017年11月24日 下午10:34:04 <br/>
     * 参数: @param  orderPayStatus 设置值.  <br/>
     */
    public void setOrderPayStatus(String orderPayStatus) {
        this.orderPayStatus = orderPayStatus;
    }

	public BigDecimal getRefundMoney() {
		return refundMoney;
	}

	public void setRefundMoney(BigDecimal refundMoney) {
		this.refundMoney = refundMoney;
	}
    
    

}