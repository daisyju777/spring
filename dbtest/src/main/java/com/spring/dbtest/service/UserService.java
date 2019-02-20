package com.spring.dbtest.service;

import java.util.List;

import com.spring.dbtest.vo.UserVo;

public interface UserService {

  public void register(String id, String pwd);  //추상메소드. 이 인터페이스를 구현하는 클래스는 이 메소드를 만드시 재정의해줘야함

  public List<UserVo> getListView(UserVo userVo);

  public List<UserVo> getSearchView(String search);

  public void userUpdate(String id, String pwd);

  public void userDelete(String id, String pwd);
     
}
