package com.Models;

import java.sql.Timestamp;

public class CommentsModel {
	
	
	private String id="";
	private String post_id="";
	private String email="";
	private String comment="";
	private Timestamp create_at = null;
	private Timestamp modify_at = null;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
