package cq.anbu.modules.baseinfo.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 车辆信息表
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-18 18:47:04
 */
public class VehicleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //车牌号
    private String palteNo;
    //驾驶人
    private String driver;
    //装载车型
    private String loadingModel;
    //车载量
    private BigDecimal shippedQuantity;
    //所属区域
    private String belongArea;
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
     * 设置：驾驶人
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * 获取：驾驶人
     */
    public String getDriver() {
        return driver;
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
     * 设置：车载量
     */
    public void setShippedQuantity(BigDecimal shippedQuantity) {
        this.shippedQuantity = shippedQuantity;
    }

    /**
     * 获取：车载量
     */
    public BigDecimal getShippedQuantity() {
        return shippedQuantity;
    }

    /**
     * 设置：所属区域
     */
    public void setBelongArea(String belongArea) {
        this.belongArea = belongArea;
    }

    /**
     * 获取：所属区域
     */
    public String getBelongArea() {
        return belongArea;
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
