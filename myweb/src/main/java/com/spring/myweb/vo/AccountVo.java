package com.spring.myweb.vo;

import java.sql.Date;

public class AccountVo {
  private String id;
  private String pw;
  private String email;
  private String gender;
  private Date registed_date;
  private String authority;
  private String idImsi;
  
  public String getIdImsi() {
    return idImsi;
  }
  public void setIdImsi(String idImsi) {
    this.idImsi = idImsi;
  }
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPw() {
    return pw;
  }
  public void setPw(String pw) {
    this.pw = pw;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public Date getRegisted_date() {
    return registed_date;
  }
  public void setRegisted_date(Date registed_date) {
    this.registed_date = registed_date;
  }
  public String getAuthority() {
    return authority;
  }
  public void setAuthorty(String authority) {
    this.authority = authority;
  }
  
  @Override
  public String toString() {
    return "AccountVo [id=" + id + ", pw=" + pw + ", email=" + email + ", gender=" + gender + ", registed_date="
        + registed_date + ", authorty=" + authority + ", idImsi=" + idImsi + "]";
  }
  
  
}
