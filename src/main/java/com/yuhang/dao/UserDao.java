package com.yuhang.dao;

import org.apache.ibatis.annotations.Param;

import com.yuhang.domain.User;

@MyBatisRepository
public interface UserDao {

	User loadUserById(@Param("id") long id);

	User loadUserByName(@Param("userName") String userName);
}
