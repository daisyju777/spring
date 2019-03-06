package com.spring.myweb.vo;

import java.sql.Date;

public class BoardVo {
  private Integer id;
  private String title;
  private String content;
  private String writer;
  private String state;
  private Date registerd_date;
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  public Date getRegisterd_date() {
    return registerd_date;
  }
  public void setRegisterd_date(Date registerd_date) {
    this.registerd_date = registerd_date;
  }
  
  @Override
  public String toString() {
    return "BoardVo [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer + ", state="
        + state + ", registerd_date=" + registerd_date + "]";
  }

}
