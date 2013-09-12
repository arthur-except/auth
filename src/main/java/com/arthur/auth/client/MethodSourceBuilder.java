package com.arthur.auth.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.method.DelegatingMethodSecurityMetadataSource;
import org.springframework.security.access.method.MapBasedMethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.arthur.auth.constant.AuthConstant.ResourceType;
import com.arthur.auth.domain.Resource;
import com.arthur.auth.service.impl.MethodSourceFetcher;
import com.arthur.auth.utils.BeanUtils;

@Component
public class MethodSourceBuilder implements SourceBuilder {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MethodSourceBuilder.class);

	@Autowired
	private DelegatingMethodSecurityMetadataSource delegatingMethodSecurityMetadataSource;

	@Autowired
	private MethodSourceFetcher methodSourceFetcher;

	public void refresh() {

		if (null == delegatingMethodSecurityMetadataSource) {
			LOGGER.error("No methodSecuritInterceptor found");
			return;
		}

		List<Resource> resources = methodSourceFetcher
				.loadAuthoritiesByUsername(null, ResourceType.METHOD.getType());

		Map<String, List<ConfigAttribute>> methodMap = new HashMap<String, List<ConfigAttribute>>();
		for (Resource resource : resources) {
			String key = resource.getResource();
			String value = resource.getRole();
			methodMap.put(key,
					SecurityConfig.createListFromCommaDelimitedString(value));
		}

		MapBasedMethodSecurityMetadataSource securityMetadataSource = new MapBasedMethodSecurityMetadataSource(
				methodMap);
		List<MethodSecurityMetadataSource> methodSecurityMetadataSources = new ArrayList<MethodSecurityMetadataSource>();
		methodSecurityMetadataSources.add(securityMetadataSource);

		List<MethodSecurityMetadataSource> methodMetadataSources = delegatingMethodSecurityMetadataSource
				.getMethodSecurityMetadataSources();
		methodMetadataSources.clear();

		methodMetadataSources.addAll(methodSecurityMetadataSources);

		@SuppressWarnings("rawtypes")
		Map attributeCache = (Map) BeanUtils.safeGetFieldValue(
				delegatingMethodSecurityMetadataSource, "attributeCache");
		attributeCache.clear();
	}
	
}
