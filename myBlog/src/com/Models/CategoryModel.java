package com.Models;

import java.sql.Timestamp;

public class CategoryModel {
	
	private String id="";
	private String category_title="";
	private Timestamp create_at = null;
	private Timestamp modify_at = null;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory_title() {
		return category_title;
	}
	public void setCategory_title(String category_title) {
		this.category_title = category_title;
	}
	public Timestamp getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Timestamp create_at) {
		this.create_at = create_at;
	}
	public Timestamp getModify_at() {
		return modify_at;
	}
	public void setModify_at(Timestamp modify_at) {
		this.modify_at = modify_at;
	}
	
	
	

}
