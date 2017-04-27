package com.yuhang.service;

import com.yuhang.domain.Setting;


public interface CacheService {
	
	void setObj(String key, Object value, int expireTime);

	void setObj(String key, String field, Object value, int expireTime);
	
	Object getObj(String key);
	
	Setting getSetting(String key);
}
