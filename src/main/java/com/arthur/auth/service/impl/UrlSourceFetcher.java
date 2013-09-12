package com.arthur.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arthur.auth.constant.AuthConstant.ResourceType;
import com.arthur.auth.domain.Resource;
import com.arthur.auth.mapper.ResourceMapper;
import com.arthur.auth.service.ResourceFetcher;

/**
 * 
 * @author Arthur
 * 
 * @function:获取资源对应的securitymetadata
 * 
 */
@Component("urlSourceFetcher")
public class UrlSourceFetcher implements ResourceFetcher<Resource> {

	@Autowired
	private ResourceMapper resourceMapper;

	public List<Resource> loadAuthoritiesByUsername(String username,
			String resourceType) {
		return resourceMapper.getByResourceNameAndType(null,
				ResourceType.URL.getType());
	}
}
