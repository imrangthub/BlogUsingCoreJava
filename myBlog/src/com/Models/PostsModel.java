package com.Models;

import java.sql.Timestamp;

public class PostsModel {
	
	private String id="";
	private String postTitle="";
	private String postBody="";
	private String postImage="";
	private String category="";
	private Timestamp create_at = null;
	private Timestamp modify_at = null;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostBody() {
		return postBody;
	}
	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPostImage() {
		return postImage;
	}
	public void setPostImage(String postImage) {
		this.postImage = postImage;
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
