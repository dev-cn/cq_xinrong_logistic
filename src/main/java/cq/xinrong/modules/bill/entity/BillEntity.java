package cq.xinrong.modules.bill.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-10 09:48:20
 */
public class BillEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//序号
	private Long serialNo;
	//运单号
	private Long trackingNo;
	//提货日期
	private Date deliveryDate;
	//到货日期
	private Date arrivalDate;
	//提货地点
	private String deliveryAddr;
	//到货地点
	private String arrivalAddr;
	//货物名称
	private String goodsName;
	//装载车型
	private String loadingModel;
	//车牌号
	private String palteNo;
	//车次
	private String trainNo;
	//装载数量
	private Long shippedQuantity;
	//重量
	private Double weight;
	//单价
	private Double price;
	//提货费
	private Double pickUpCharge;
	//送货费
	private Double deliveryFee;
	//费用合计
	private Double totalExpenses;
	//备注
	private String comment;
	//
	private Date createAt;
	//
	private String createBy;
	//
	private Date updateAt;
	//
	private String updateBy;
	//
	private String isDelete;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：序号
	 */
	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}
	/**
	 * 获取：序号
	 */
	public Long getSerialNo() {
		return serialNo;
	}
	/**
	 * 设置：运单号
	 */
	public void setTrackingNo(Long trackingNo) {
		this.trackingNo = trackingNo;
	}
	/**
	 * 获取：运单号
	 */
	public Long getTrackingNo() {
		return trackingNo;
	}
	/**
	 * 设置：提货日期
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	/**
	 * 获取：提货日期
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	/**
	 * 设置：到货日期
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * 获取：到货日期
	 */
	public Date getArrivalDate() {
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
	public void setShippedQuantity(Long shippedQuantity) {
		this.shippedQuantity = shippedQuantity;
	}
	/**
	 * 获取：装载数量
	 */
	public Long getShippedQuantity() {
		return shippedQuantity;
	}
	/**
	 * 设置：重量
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	/**
	 * 获取：重量
	 */
	public Double getWeight() {
		return weight;
	}
	/**
	 * 设置：单价
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：单价
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * 设置：提货费
	 */
	public void setPickUpCharge(Double pickUpCharge) {
		this.pickUpCharge = pickUpCharge;
	}
	/**
	 * 获取：提货费
	 */
	public Double getPickUpCharge() {
		return pickUpCharge;
	}
	/**
	 * 设置：送货费
	 */
	public void setDeliveryFee(Double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	/**
	 * 获取：送货费
	 */
	public Double getDeliveryFee() {
		return deliveryFee;
	}
	/**
	 * 设置：费用合计
	 */
	public void setTotalExpenses(Double totalExpenses) {
		this.totalExpenses = totalExpenses;
	}
	/**
	 * 获取：费用合计
	 */
	public Double getTotalExpenses() {
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
	/**
	 * 设置：
	 */
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	/**
	 * 获取：
	 */
	public Date getCreateAt() {
		return createAt;
	}
	/**
	 * 设置：
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：
	 */
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateAt() {
		return updateAt;
	}
	/**
	 * 设置：
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 设置：
	 */
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：
	 */
	public String getIsDelete() {
		return isDelete;
	}
}
