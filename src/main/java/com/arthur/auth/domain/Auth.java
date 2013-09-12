package com.arthur.auth.domain;

import org.springframework.security.core.GrantedAuthority;

public class Auth implements GrantedAuthority{

	private static final long serialVersionUID = -2627300570894076034L;
	
	private Long id;
	
	private String username;
	
	private String role;

	public String getAuthority() {
		return role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		
		if(obj instanceof Auth){
			return username.equals(((Auth)obj).getUsername())? role.equals(((Auth)obj).getRole()): false;
		}
		return false;
	}
	
}
