package com.Models;

import java.sql.Timestamp;

public class adminModel {
	
	private String adminId="";
	private String adminName="";
	private String adminPass="";
	private String adminEmail="";
	private Timestamp created_at = null;
	private Timestamp modify_at = null;
	private Timestamp deleted_at =null;
	
	
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getModify_at() {
		return modify_at;
	}
	public void setModify_at(Timestamp modify_at) {
		this.modify_at = modify_at;
	}
	public Timestamp getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(Timestamp deleted_at) {
		this.deleted_at = deleted_at;
	}
	
	
	
	

}
