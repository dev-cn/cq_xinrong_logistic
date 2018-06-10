package cq.xinrong.modules.bill.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 运费汇总表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-10 09:48:20
 */
public class BillCollectEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//序号
	private Long serialNo;
	//地点
	private String address;
	//运输供应商
	private String transpotSupplier;
	//运费类型
	private String freightType;
	//运输单号
	private String transpotNo;
	//日期
	private Date date;
	//起点
	private String lineStart;
	//线路终点
	private String lineEnd;
	//运输产品
	private String transpotProduct;
	//运输方式
	private String transpotMode;
	//车型
	private String motorcycleType;
	//运输单价(含税保险)
	private BigDecimal transpotPrice;
	//数量
	private BigDecimal quantity;
	//总体积
	private BigDecimal voluneSum;
	//总重量
	private BigDecimal weightSum;
	//提送运费
	private BigDecimal deliveryFee;
	//预提运费合计（含税10%
	private BigDecimal advanceFeeIncludeTax;
	//预提运费合计（不含税）
	private BigDecimal advanceFeeNoTax;
	//
	private Integer status;
	//备注
	private String comment;
	//预留字段1
	private String reserveOne;
	//预留字段2
	private String reserveTwo;
	//
	private Date createAt;
	//
	private String createBy;
	//
	private Date updateAt;
	//
	private String updateBy;
	//
	private Integer isDelete;

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
	 * 设置：地点
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地点
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：运输供应商
	 */
	public void setTranspotSupplier(String transpotSupplier) {
		this.transpotSupplier = transpotSupplier;
	}
	/**
	 * 获取：运输供应商
	 */
	public String getTranspotSupplier() {
		return transpotSupplier;
	}
	/**
	 * 设置：运费类型
	 */
	public void setFreightType(String freightType) {
		this.freightType = freightType;
	}
	/**
	 * 获取：运费类型
	 */
	public String getFreightType() {
		return freightType;
	}
	/**
	 * 设置：运输单号
	 */
	public void setTranspotNo(String transpotNo) {
		this.transpotNo = transpotNo;
	}
	/**
	 * 获取：运输单号
	 */
	public String getTranspotNo() {
		return transpotNo;
	}
	/**
	 * 设置：日期
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * 获取：日期
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * 设置：起点
	 */
	public void setLineStart(String lineStart) {
		this.lineStart = lineStart;
	}
	/**
	 * 获取：起点
	 */
	public String getLineStart() {
		return lineStart;
	}
	/**
	 * 设置：线路终点
	 */
	public void setLineEnd(String lineEnd) {
		this.lineEnd = lineEnd;
	}
	/**
	 * 获取：线路终点
	 */
	public String getLineEnd() {
		return lineEnd;
	}
	/**
	 * 设置：运输产品
	 */
	public void setTranspotProduct(String transpotProduct) {
		this.transpotProduct = transpotProduct;
	}
	/**
	 * 获取：运输产品
	 */
	public String getTranspotProduct() {
		return transpotProduct;
	}
	/**
	 * 设置：运输方式
	 */
	public void setTranspotMode(String transpotMode) {
		this.transpotMode = transpotMode;
	}
	/**
	 * 获取：运输方式
	 */
	public String getTranspotMode() {
		return transpotMode;
	}
	/**
	 * 设置：车型
	 */
	public void setMotorcycleType(String motorcycleType) {
		this.motorcycleType = motorcycleType;
	}
	/**
	 * 获取：车型
	 */
	public String getMotorcycleType() {
		return motorcycleType;
	}
	/**
	 * 设置：运输单价(含税保险)
	 */
	public void setTranspotPrice(BigDecimal transpotPrice) {
		this.transpotPrice = transpotPrice;
	}
	/**
	 * 获取：运输单价(含税保险)
	 */
	public BigDecimal getTranspotPrice() {
		return transpotPrice;
	}
	/**
	 * 设置：数量
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	/**
	 * 获取：数量
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}
	/**
	 * 设置：总体积
	 */
	public void setVoluneSum(BigDecimal voluneSum) {
		this.voluneSum = voluneSum;
	}
	/**
	 * 获取：总体积
	 */
	public BigDecimal getVoluneSum() {
		return voluneSum;
	}
	/**
	 * 设置：总重量
	 */
	public void setWeightSum(BigDecimal weightSum) {
		this.weightSum = weightSum;
	}
	/**
	 * 获取：总重量
	 */
	public BigDecimal getWeightSum() {
		return weightSum;
	}
	/**
	 * 设置：提送运费
	 */
	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	/**
	 * 获取：提送运费
	 */
	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}
	/**
	 * 设置：预提运费合计（含税10%
	 */
	public void setAdvanceFeeIncludeTax(BigDecimal advanceFeeIncludeTax) {
		this.advanceFeeIncludeTax = advanceFeeIncludeTax;
	}
	/**
	 * 获取：预提运费合计（含税10%
	 */
	public BigDecimal getAdvanceFeeIncludeTax() {
		return advanceFeeIncludeTax;
	}
	/**
	 * 设置：预提运费合计（不含税）
	 */
	public void setAdvanceFeeNoTax(BigDecimal advanceFeeNoTax) {
		this.advanceFeeNoTax = advanceFeeNoTax;
	}
	/**
	 * 获取：预提运费合计（不含税）
	 */
	public BigDecimal getAdvanceFeeNoTax() {
		return advanceFeeNoTax;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
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
	 * 设置：预留字段1
	 */
	public void setReserveOne(String reserveOne) {
		this.reserveOne = reserveOne;
	}
	/**
	 * 获取：预留字段1
	 */
	public String getReserveOne() {
		return reserveOne;
	}
	/**
	 * 设置：预留字段2
	 */
	public void setReserveTwo(String reserveTwo) {
		this.reserveTwo = reserveTwo;
	}
	/**
	 * 获取：预留字段2
	 */
	public String getReserveTwo() {
		return reserveTwo;
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
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
}
