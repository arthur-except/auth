package com.arthur.auth.client;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;
import org.springframework.stereotype.Component;

import com.arthur.auth.constant.AuthConstant.ResourceType;
import com.arthur.auth.domain.Resource;
import com.arthur.auth.service.impl.UrlSourceFetcher;

@Component("urlSourceBuilder")
public class UrlSourceBuilder implements SourceBuilder {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UrlSourceBuilder.class);

	@Autowired
	private FilterSecurityInterceptor filterSecurityInterceptor;

	@Autowired
	@Qualifier("urlSourceFetcher")
	private UrlSourceFetcher urlSourceFetcher;

	public void refresh() {

		if (null == filterSecurityInterceptor || null == urlSourceFetcher) {
			LOGGER.error("No filterInvocationSecurityMetadataSource or urlSourceFetcher found");
			return;
		}

		List<Resource> resources = urlSourceFetcher.loadAuthoritiesByUsername(
				null, ResourceType.URL.getType());

		LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();

		for (Resource resource : resources) {
			String key = resource.getResource();
			String value = resource.getRole();
			requestMap.put(new AntPathRequestMatcher(key),
					SecurityConfig.createListFromCommaDelimitedString(value));
		}
		FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource = new DefaultFilterInvocationSecurityMetadataSource(
				requestMap);
		filterSecurityInterceptor
				.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
	}

}
