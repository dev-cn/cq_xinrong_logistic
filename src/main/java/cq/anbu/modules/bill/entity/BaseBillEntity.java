package cq.anbu.modules.bill.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cq.anbu.common.base.BaseEntity;

import java.math.BigDecimal;

public class BaseBillEntity extends BaseEntity {

    //序号
    @Excel(name = "序号")
    private BigDecimal serialNo;
    //运单号
    @Excel(name = "运单号")
    private String trackingNo;
    //提货日期
    @Excel(name = "提货日期",format="yyyy-MM-dd")
    private String deliveryDate;
    //到货日期
    @Excel(name = "到货日期",format="yyyy-MM-dd")
    private String arrivalDate;
    //提货地点
    @Excel(name = "提货地点")
    private String deliveryAddr;
    //到货地点
    @Excel(name = "到货地点")
    private String arrivalAddr;
    //货物名称
    @Excel(name = "货物名称")
    private String goodsName;
    //装载车型
    @Excel(name = "装载车型")
    private String loadingModel;
    //车牌号
    @Excel(name = "车牌号")
    private String palteNo;
    //车次
    @Excel(name = "车次")
    private String trainNo;
    //装载数量
    @Excel(name = "装载数量")
    private BigDecimal shippedQuantity;
    //重量
    @Excel(name = "重量")
    private BigDecimal weight;
    //单价
    @Excel(name = "单价")
    private BigDecimal price;
    //提货费
    @Excel(name = "提货费")
    private BigDecimal pickUpCharge;
    //送货费
    @Excel(name = "送货费")
    private BigDecimal deliveryFee;
    //费用合计
    @Excel(name = "费用合计")
    private BigDecimal totalExpenses;
    //备注
    @Excel(name = "备注")
    private String comment;

    private String beginDate;

    private String endDate;

    public BigDecimal getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(BigDecimal serialNo) {
        this.serialNo = serialNo;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDeliveryAddr() {
        return deliveryAddr;
    }

    public void setDeliveryAddr(String deliveryAddr) {
        this.deliveryAddr = deliveryAddr;
    }

    public String getArrivalAddr() {
        return arrivalAddr;
    }

    public void setArrivalAddr(String arrivalAddr) {
        this.arrivalAddr = arrivalAddr;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getLoadingModel() {
        return loadingModel;
    }

    public void setLoadingModel(String loadingModel) {
        this.loadingModel = loadingModel;
    }

    public String getPalteNo() {
        return palteNo;
    }

    public void setPalteNo(String palteNo) {
        this.palteNo = palteNo;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public BigDecimal getShippedQuantity() {
        return shippedQuantity;
    }

    public void setShippedQuantity(BigDecimal shippedQuantity) {
        this.shippedQuantity = shippedQuantity;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPickUpCharge() {
        return pickUpCharge;
    }

    public void setPickUpCharge(BigDecimal pickUpCharge) {
        this.pickUpCharge = pickUpCharge;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(BigDecimal totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
