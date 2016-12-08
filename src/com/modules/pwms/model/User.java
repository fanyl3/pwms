package com.modules.pwms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.common.util.StringHelper;


@Entity
@Table(name = "USER")
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 5456666448554635342L;

	private String id;
	private String name;
	
	private String userName;
	private String staffId;
	private String phone;
	private String email;
	private String sex;
	private String password;
	private String permissionRelId;
	

	public User() {
		this.id = StringHelper.uuid();
		this.init();
	}

	public User(String id) {
		this.id = id;
		this.init();
	}

	public void init() {
		// 默认字段
		this.name = "";
	}

	@Id
	@Column(name = "ID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "STAFF_ID")
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	@Column(name = "PHONE")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "SEX")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "PERMISSION_REL_ID")
	public String getPermissionRelId() {
		return permissionRelId;
	}

	public void setPermissionRelId(String permissionRelId) {
		this.permissionRelId = permissionRelId;
	}
	


}

