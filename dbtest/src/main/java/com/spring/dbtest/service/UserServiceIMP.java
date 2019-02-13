package com.spring.dbtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dbtest.dao.UserDao;
import com.spring.dbtest.vo.UserVo;

@Service
public class UserServiceIMP implements UserService {
  @Autowired
  private UserDao userDao;
  
  @Override
  public void register(String id, String pwd) {
    userDao.register(id, pwd);
  }

  @Override
  public List<UserVo> getListView(UserVo userVo) {
    return userDao.getListView(userVo);
  }

  
}
