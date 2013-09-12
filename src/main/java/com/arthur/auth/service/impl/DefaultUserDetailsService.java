package com.arthur.auth.service.impl;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.arthur.auth.domain.Auth;
import com.arthur.auth.domain.DefaultUserDetails;
import com.arthur.auth.domain.User;
import com.arthur.auth.mapper.AuthMapper;
import com.arthur.auth.mapper.UserMapper;
import com.google.common.collect.Sets;

/**
 * 
 * @author Arthur
 *
 */
@Component("userDetailsService")
public class DefaultUserDetailsService implements UserDetailsService{
	
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private AuthMapper authMapper;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = loadUserInfoByUsername(username);
		List<Auth> auths = loadAuthoritiesByUsername(username);
		
		return createUserDetails(user, auths);
	}
	
	private User loadUserInfoByUsername(String username){
		List<User> users = userMapper.getUserByUsername(username);
		
		if(null == users || users.isEmpty()){
			LOGGER.error("No users found by username[{}]", username);
			throw new UsernameNotFoundException("No user found of username" + username);
		}
		return users.get(0);
	}
	
	private List<Auth> loadAuthoritiesByUsername(String username){
		return authMapper.getAuthoritiesByUsername(username);
	}
	
	private UserDetails createUserDetails(User user, List<Auth> auths){
		Set<Auth> authorities = Sets.newHashSet(auths);
		return new DefaultUserDetails(user, authorities);
	}

}
