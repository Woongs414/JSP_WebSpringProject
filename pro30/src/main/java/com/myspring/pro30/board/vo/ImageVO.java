package com.myspring.pro30.board.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("imageVO")
public class ImageVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	public ImageVO() {
		
	}
	
	public ImageVO(String id, String pwd, String name, String email) {
		this.id=id;
		this.pwd=pwd;
		this.name=name;
		this.email=email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	

}
