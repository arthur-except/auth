package com.arthur.auth.domain;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7921267597550021244L;
	
	private Long id;

	private String username;
	
	private String password;
	
	private boolean enable;

	public Long getId() {
		return id;
	}

	public void setId(Long uid) {
		this.id = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
}
