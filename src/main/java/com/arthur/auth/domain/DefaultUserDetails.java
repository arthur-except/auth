package com.arthur.auth.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DefaultUserDetails implements UserDetails{

	private static final long serialVersionUID = -8808849656494652454L;
	
	private User user;
	
	private Set<Auth> authorities;
	
	public DefaultUserDetails(){
		
	}
	
	public DefaultUserDetails(User user, Set<Auth> auths){
		this.user = user;
		this.authorities = auths;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.unmodifiableSet(authorities);
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getUsername();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return user.isEnable();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAuthorities(Set<Auth> authorities) {
		this.authorities = authorities;
	}
	
}
