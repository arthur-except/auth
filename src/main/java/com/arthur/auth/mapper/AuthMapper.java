package com.arthur.auth.mapper;

import java.util.List;

import com.arthur.auth.domain.Auth;

public interface AuthMapper extends AbstractMapper<Auth>{

	List<Auth> getAuthoritiesByUsername(String username);
}
