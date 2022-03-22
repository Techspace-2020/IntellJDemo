package com.acc.demo.dao;

import com.acc.demo.entity.UserInfo;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDAO extends JpaRepository<UserInfo,Integer> {
    UserInfo findUserByUsername(String username);
  //  void addUser(UserInfo user);
}
