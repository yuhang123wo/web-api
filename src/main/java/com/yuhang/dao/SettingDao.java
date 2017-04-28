package com.yuhang.dao;

import java.util.List;
import java.util.Map;

import com.yuhang.domain.Setting;

@MyBatisRepository
public interface SettingDao {

	List<Setting> findByMap(Map<String, Object> map);

}
