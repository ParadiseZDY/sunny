package com.sunny.common;

import java.util.Date;

/**
 * 公共类 6个基本属性
 * @author zhao.dy
 * @date 12:21 2018/4/16
 */
public class Entry extends Page {

	private static final long serialVersionUID = -6897372035350453832L;

	private Integer id;
	private String createUser;
	private Date createTime;
	private String updateUser;
	private Date updateTime;
	private Integer delFlag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "Entry{" +
				"id=" + id +
				", createUser='" + createUser + '\'' +
				", createTime=" + createTime +
				", updateUser='" + updateUser + '\'' +
				", updateTime=" + updateTime +
				", delFlag=" + delFlag +
				"} " + super.toString();
	}
}
