package com.spring.dbtest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.dbtest.vo.UserVo;

public interface UserDao {

  public void register(@Param("id") String id, @Param("pwd") String pwd);

  public List<UserVo> getListView(@Param("vo") UserVo userVo);

}
