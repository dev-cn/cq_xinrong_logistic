package cq.anbu.modules.bill.entity;

import cq.anbu.common.base.BaseEntity;


/**
 * 字典
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-18 13:28:53
 */
public class AbParameterEntity extends BaseEntity {

	//id
	private Long id;
	//参数编码
	private String paraCode;
	//参数名称
	private String paraDesc;
	//上级参数
	private String paraParentCode;
	//序号
	private Integer seq;

	/**
	 * 设置：id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：参数编码
	 */
	public void setParaCode(String paraCode) {
		this.paraCode = paraCode;
	}
	/**
	 * 获取：参数编码
	 */
	public String getParaCode() {
		return paraCode;
	}
	/**
	 * 设置：参数名称
	 */
	public void setParaDesc(String paraDesc) {
		this.paraDesc = paraDesc;
	}
	/**
	 * 获取：参数名称
	 */
	public String getParaDesc() {
		return paraDesc;
	}
	/**
	 * 设置：上级参数
	 */
	public void setParaParentCode(String paraParentCode) {
		this.paraParentCode = paraParentCode;
	}
	/**
	 * 获取：上级参数
	 */
	public String getParaParentCode() {
		return paraParentCode;
	}
	/**
	 * 设置：序号
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	/**
	 * 获取：序号
	 */
	public Integer getSeq() {
		return seq;
	}
}
