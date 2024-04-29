package com.springboot.user.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author yueye
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

	/**
	 * @id 用户编号
	 */
	private Long id;

	
	private Long createId;
	/**
	 * @nickname 用户名
	 */
	private String nickname;

	/**
	 * @username 登陆帐户
	 */
	private String username;

	/**
	 * @password 密码
	 */
	private String password;

	/**
	 * @usertype 1' COMMENT '人员类型(1:经办员;2:管理员;3:系统内置人员;)
	 */
	private String usertype;

	/**
	 * @sex 性别(0:未知;1:男;2:女)
	 */
	private Integer sex;

	/**
	 * @remark 备注
	 */
	private String remark;

	/**
	 * @enabled 启用状态
	 */
	private Integer enabled;

	/**
	 * @deptid 部门编号
	 */
	private String deptid;

	/**
	 * @telephone 用户电话
	 */
	private String telephone;

	/**
	 * @address 用户地址
	 */
	private String address;

	/**
	 * @age 年龄
	 */
	private Integer root;

	/**
	 * @idCard 身份证号
	 */
	private String idCard;

	/**
	 * @email 邮箱地址
	 */
	private String email;

	/**
	 * @workUnit 工作单位
	 */
	private String workUnit;

	/**
	 * @income 收入
	 */
	private Integer income;

	/**
	 * @delFlag 是否删除 0未删除 1删除
	 */
	private Integer delFlag;

	
	
	/**
	 * 用户编号
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 用户编号
	 */
	public User setId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * 用户名
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 用户名
	 */
	public User setNickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	/**
	 * 登陆帐户
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 登陆帐户
	 */
	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	/**
	 * 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 密码
	 */
	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * 1' COMMENT '人员类型(1:经办员;2:管理员;3:系统内置人员;)
	 */
	public String getUsertype() {
		return usertype;
	}

	/**
	 * 1' COMMENT '人员类型(1:经办员;2:管理员;3:系统内置人员;)
	 */
	public User setUsertype(String usertype) {
		this.usertype = usertype;
		return this;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	/**
	 * 性别(0:未知;1:男;2:女)
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * 性别(0:未知;1:男;2:女)
	 */
	public User setSex(Integer sex) {
		this.sex = sex;
		return this;
	}

	/**
	 * 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注
	 */
	public User setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	/**
	 * 启用状态
	 */
	public Integer getEnabled() {
		return enabled;
	}

	/**
	 * 启用状态
	 */
	public User setEnabled(Integer enabled) {
		this.enabled = enabled;
		return this;
	}

	/**
	 * 部门编号
	 */
	public String getDeptid() {
		return deptid;
	}

	/**
	 * 部门编号
	 */
	public User setDeptid(String deptid) {
		this.deptid = deptid;
		return this;
	}

	/**
	 * 用户电话
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * 用户电话
	 */
	public User setTelephone(String telephone) {
		this.telephone = telephone;
		return this;
	}

	/**
	 * 用户地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 用户地址
	 */
	public User setAddress(String address) {
		this.address = address;
		return this;
	}


	public Integer getRoot() {
		return root;
	}

	public void setRoot(Integer root) {
		this.root = root;
	}

	/**
	 * 身份证号
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * 身份证号
	 */
	public User setIdCard(String idCard) {
		this.idCard = idCard;
		return this;
	}

	/**
	 * 邮箱地址
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 邮箱地址
	 */
	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * 工作单位
	 */
	public String getWorkUnit() {
		return workUnit;
	}

	/**
	 * 工作单位
	 */
	public User setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
		return this;
	}

	/**
	 * 收入
	 */
	public Integer getIncome() {
		return income;
	}

	/**
	 * 收入
	 */
	public User setIncome(Integer income) {
		this.income = income;
		return this;
	}

	/**
	 * 是否删除 0未删除 1删除
	 */
	public Integer getDelFlag() {
		return delFlag;
	}

	/**
	 * 是否删除 0未删除 1删除
	 */
	public User setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
		return this;
	}

}
