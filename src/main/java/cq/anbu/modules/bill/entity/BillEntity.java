package cq.anbu.modules.bill.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cq.anbu.common.base.BaseEntity;

import java.math.BigDecimal;


/**
 * 账单表
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-10 09:48:20
 */
public class BillEntity extends BaseEntity {

    //序号
    @Excel(name = "序号")
    private BigDecimal serialNo;
    //运单号
    @Excel(name = "运单号")
    private String trackingNo;
    //提货日期
    @Excel(name = "提货日期")
    private String deliveryDate;
    //到货日期
    @Excel(name = "到货日期")
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
    //BigDecimal装载数量
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

    /**
     * 设置：序号
     */
    public void setSerialNo(BigDecimal serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 获取：序号
     */
    public BigDecimal getSerialNo() {
        return serialNo;
    }

    /**
     * 设置：运单号
     */
    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    /**
     * 获取：运单号
     */
    public String getTrackingNo() {
        return trackingNo;
    }

    /**
     * 设置：提货日期
     */
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * 获取：提货日期
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * 设置：到货日期
     */
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * 获取：到货日期
     */
    public String getArrivalDate() {
        return arrivalDate;
    }

    /**
     * 设置：提货地点
     */
    public void setDeliveryAddr(String deliveryAddr) {
        this.deliveryAddr = deliveryAddr;
    }

    /**
     * 获取：提货地点
     */
    public String getDeliveryAddr() {
        return deliveryAddr;
    }

    /**
     * 设置：到货地点
     */
    public void setArrivalAddr(String arrivalAddr) {
        this.arrivalAddr = arrivalAddr;
    }

    /**
     * 获取：到货地点
     */
    public String getArrivalAddr() {
        return arrivalAddr;
    }

    /**
     * 设置：货物名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取：货物名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置：装载车型
     */
    public void setLoadingModel(String loadingModel) {
        this.loadingModel = loadingModel;
    }

    /**
     * 获取：装载车型
     */
    public String getLoadingModel() {
        return loadingModel;
    }

    /**
     * 设置：车牌号
     */
    public void setPalteNo(String palteNo) {
        this.palteNo = palteNo;
    }

    /**
     * 获取：车牌号
     */
    public String getPalteNo() {
        return palteNo;
    }

    /**
     * 设置：车次
     */
    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    /**
     * 获取：车次
     */
    public String getTrainNo() {
        return trainNo;
    }

    /**
     * 设置：装载数量
     */
    public void setShippedQuantity(BigDecimal shippedQuantity) {
        this.shippedQuantity = shippedQuantity;
    }

    /**
     * 获取：装载数量
     */
    public BigDecimal getShippedQuantity() {
        return shippedQuantity;
    }

    /**
     * 设置：重量
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * 获取：重量
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * 设置：单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取：单价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置：提货费
     */
    public void setPickUpCharge(BigDecimal pickUpCharge) {
        this.pickUpCharge = pickUpCharge;
    }

    /**
     * 获取：提货费
     */
    public BigDecimal getPickUpCharge() {
        return pickUpCharge;
    }

    /**
     * 设置：送货费
     */
    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    /**
     * 获取：送货费
     */
    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    /**
     * 设置：费用合计
     */
    public void setTotalExpenses(BigDecimal totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    /**
     * 获取：费用合计
     */
    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    /**
     * 设置：备注
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取：备注
     */
    public String getComment() {
        return comment;
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
