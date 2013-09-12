package com.arthur.auth.service;

import java.util.List;

import com.arthur.auth.domain.Resource;

public interface ResourceFetcher<T> {
	
	List<Resource> loadAuthoritiesByUsername(String username, String resourceType);

}
