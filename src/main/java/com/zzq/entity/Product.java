package com.zzq.entity;

import java.util.Date;

public class Product {
	private int id;
	private String cast_openid;
	private String title;
	private int type_id;
	private String type_name;
	private String content;
	private Date casttime;
	private Date receivetime;
	private String receive_openid;
	private int status;
	private String nickName;   //另加
	
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", cast_openid=" + cast_openid + ", title=" + title + ", type_id=" + type_id
				+ ", type_name=" + type_name + ", content=" + content + ", casttime=" + casttime + ", receivetime="
				+ receivetime + ", receive_openid=" + receive_openid + ", status=" + status + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
	public String getCast_openid() {
		return cast_openid;
	}
	public void setCast_openid(String cast_openid) {
		this.cast_openid = cast_openid;
	}
	public Date getCasttime() {
		return casttime;
	}
	public void setCasttime(Date casttime) {
		this.casttime = casttime;
	}
	public Date getReceivetime() {
		return receivetime;
	}
	public void setReceivetime(Date receivetime) {
		this.receivetime = receivetime;
	}
	public String getReceive_openid() {
		return receive_openid;
	}
	public void setReceive_openid(String receive_openid) {
		this.receive_openid = receive_openid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
}
