package com.spring.atom;

public class TestVo {
  private String id;
  private String pwd;
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPwd() {
    return pwd;
  }
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
  
  @Override
  public String toString() {
    return "TestVo [id=" + id + ", pwd=" + pwd + "]";
  }
  
  
}
