package com.yuhang.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuhang.domain.Setting;
import com.yuhang.service.CacheService;
import com.yuhang.util.JedisTemplate;
import com.yuhang.util.SerializeUtil;

@Service("cacheService")
public class CacheServiceImpl implements CacheService {
	@Resource
	private JedisTemplate jedisTemplate;

	@Override
	public void setObj(String key, Object value, int expireTime) {
		jedisTemplate.setObj(key, SerializeUtil.serialize(value), expireTime);
		;
	}

	@Override
	public void setObj(String key, String field, Object value, int expireTime) {
	}

	@Override
	public Object getObj(String key) {
		return jedisTemplate.getObj(key);
	}

	@Override
	public Setting getSetting(String key) {
		return new Setting();
	}
}
