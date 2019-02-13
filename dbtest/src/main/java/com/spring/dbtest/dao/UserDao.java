package com.spring.dbtest.dao;

import org.apache.ibatis.annotations.Param;

public interface UserDao {

  public void register(@Param("id") String id, @Param("pwd") String pwd);

}
