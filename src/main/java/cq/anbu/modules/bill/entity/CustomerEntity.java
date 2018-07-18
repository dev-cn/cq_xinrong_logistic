package cq.anbu.modules.bill.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 客户信息表
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-18 18:47:04
 */
public class CustomerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //客户名
    private String name;
    //英文名
    private String nameEn;
    //客户名简称
    private String nameDesc;
    //联系方式
    private String mobile;
    //邮箱
    private String email;
    //QQ
    private String qq;
    //微信
    private String wechat;
    //网站地址
    private String website;
    //地址
    private String address;
    //建档时间
    private Date ctime;
    //级别
    private String level;
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
     * 设置：客户名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：客户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：英文名
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    /**
     * 获取：英文名
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * 设置：客户名简称
     */
    public void setNameDesc(String nameDesc) {
        this.nameDesc = nameDesc;
    }

    /**
     * 获取：客户名简称
     */
    public String getNameDesc() {
        return nameDesc;
    }

    /**
     * 设置：联系方式
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取：联系方式
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置：邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置：QQ
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取：QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置：微信
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * 获取：微信
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 设置：网站地址
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * 获取：网站地址
     */
    public String getWebsite() {
        return website;
    }

    /**
     * 设置：地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置：建档时间
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取：建档时间
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置：级别
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * 获取：级别
     */
    public String getLevel() {
        return level;
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
