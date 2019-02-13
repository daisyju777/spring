package com.spring.dbtest.service;

public interface UserService {

  public void register(String id, String pwd);  //추상메소드. 이 인터페이스를 구현하는 클래스는 이 메소드를 만드시 재정의해줘야함
     
}
