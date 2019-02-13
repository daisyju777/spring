package com.spring.dbtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dbtest.dao.UserDao;

@Service
public class UserServiceIMP implements UserService {
  @Autowired
  private UserDao userDao;
  
  @Override
  public void register(String id, String pwd) {
    userDao.register(id, pwd);
  }

  
}
