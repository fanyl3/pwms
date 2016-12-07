package com.modules.pwms.model.system;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.common.util.StringHelper;


@Entity
@Table(name = "PERMISSION")
public class Permission implements java.io.Serializable {
	private static final long serialVersionUID = 5456666448554635342L;

	private String id;
	private String permissionName;
	private String url;
	private int sort;
	
	public Permission() {
		this.id = StringHelper.uuid();
	}

	@Id
	@Column(name = "ID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "PERMISSION_NAME")
	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	@Column(name = "URL")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name = "SORT")
	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}

