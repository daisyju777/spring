package com.spring.myweb.vo;

public class TopicVo {
  private Integer id;
  private String title;
  private String content;
  private String file;
  private String state;
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
  public String getFile() {
    return file;
  }
  
  public void setFile(String file) {
    this.file = file;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  @Override
  public String toString() {
    return "TopicVo [id=" + id + ", title=" + title + ", content=" + content + ", file=" + file + ", state=" + state
        + "]";
  }

  
}
