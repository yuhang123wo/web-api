package com.yuhang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuhang.dao.SettingDao;
import com.yuhang.domain.Setting;
import com.yuhang.service.CacheService;
import com.yuhang.util.Config;
import com.yuhang.util.Const;
import com.yuhang.util.JedisTemplate;
import com.yuhang.util.SerializeUtil;
import com.yuhang.util.Tools;

@Service("cacheService")
public class CacheServiceImpl implements CacheService {
	@Resource
	private JedisTemplate jedisTemplate;
	@Resource
	private SettingDao settingDao;

	@Override
	public void setObj(String key, Object value, int expireTime) {
		jedisTemplate.setObj(key, SerializeUtil.serialize(value), expireTime);
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
		Object obj = jedisTemplate.getObj(Const.CACHE_AUTHORIZE, key);
		if (obj == null) {
			List<Setting> settings = settingDao.findByMap(Tools.getMap("key", key));
			if (settings.size() > 0) {
				jedisTemplate.setObj(Const.CACHE_SETTING, key, settings.get(0), Config.CACHE_TIME);
				return settings.get(0);
			}
		} else {
			return (Setting) obj;
		}
		return new Setting();
	}
}
