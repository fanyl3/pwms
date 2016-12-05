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
	@Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = true, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name = "NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

