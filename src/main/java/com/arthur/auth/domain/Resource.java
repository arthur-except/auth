package com.arthur.auth.domain;

import org.springframework.security.access.ConfigAttribute;

public class Resource implements ConfigAttribute{
	
	private static final long serialVersionUID = -8466584696495892333L;
	
	private Long id;
	
	private String resource;
	
	/**
	 * 有两种情况：1.url resource 2.method resource
	 */
	private String resourceType;
	
	/**
	 * 访问该resource需要的权限角色
	 */
	private String role;
	
	private String desc;
	
	public String getAttribute() {
		return this.resource;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resourcePath) {
		this.resource = resourcePath;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
