package com.modules.pwms.model.system;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.common.util.StringHelper;


@Entity
@Table(name = "PERMISSION_REL")
public class PermissionRel implements java.io.Serializable {
	private static final long serialVersionUID = 5456666448554635342L;

	private String id;
	private String permissionRelId;
	
	private String permissionId;
	

	public PermissionRel() {
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

	@Column(name = "PERMISSION_REL_ID")
	public String getPermissionRelId() {
		return permissionRelId;
	}

	public void setPermissionRelId(String permissionRelId) {
		this.permissionRelId = permissionRelId;
	}

	@Column(name = "PERMISSION_ID")
	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}


	

}

