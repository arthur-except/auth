package com.arthur.auth.mapper;

import java.util.List;
import java.util.Map;

public interface AbstractMapper<T> {
	
	long insert(T t);
	
	T get(T t);
	
	void delete(T t);
	
	List<T> searchByConditions(Map<String, Object> conditions);
	
	int update(T t);

}
