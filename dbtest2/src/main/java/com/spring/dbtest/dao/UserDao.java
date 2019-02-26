package com.spring.dbtest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.dbtest.pagenation.Criteria;
import com.spring.dbtest.vo.UserVo;

public interface UserDao {

  public void register(@Param("vo") UserVo userVo);

  public List<UserVo> getListView(@Param("vo") UserVo userVo);

  public List<UserVo> getSearchView(@Param("search") String search);

  public void userUpdate(@Param("id") String id, @Param("pwd") String pwd);

  public void userDelete(@Param("id") String id, @Param("pwd") String pwd);

  public int getCountUserLists(@Param("cri") Criteria cri);

  public List<UserVo> getUserLists(@Param("cri") Criteria cri);

}
