package com.arthur.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.arthur.auth.domain.Resource;

public interface ResourceMapper extends AbstractMapper<Resource> {

	List<Resource> getByResourceNameAndType(
			@Param("resourceName") String resourceName,
			@Param("resourceType") String resourceType);
}
