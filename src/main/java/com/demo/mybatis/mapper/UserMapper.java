package com.demo.mybatis.mapper;

import com.demo.mybatis.domain.User;

public interface UserMapper {

    User findUserName(String id);
}
