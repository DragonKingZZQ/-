package com.zzq.entity;

public class User {
	private int user_id;
	private String openid;
	private String nickName;
	private String avatarUrl;
	private int province_id;
	private int city_id;
	private String province;
	private String city;
	
	
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", openid=" + openid + ", nickName=" + nickName + ", avatarUrl=" + avatarUrl
				+ ", province_id=" + province_id + ", city_id=" + city_id + ", province=" + province + ", city=" + city
				+ "]";
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public int getProvince_id() {
		return province_id;
	}
	public void setProvince_id(int province_id) {
		this.province_id = province_id;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
