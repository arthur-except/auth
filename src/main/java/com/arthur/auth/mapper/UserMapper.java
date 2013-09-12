package com.arthur.auth.mapper;

import java.util.List;

import com.arthur.auth.domain.User;


public interface UserMapper extends AbstractMapper<User> {
	
	List<User> getUserByUsername(String username);

}
