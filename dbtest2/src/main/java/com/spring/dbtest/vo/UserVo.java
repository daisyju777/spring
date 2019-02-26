package com.spring.dbtest.vo;

public class UserVo {
  private int idx;
  private String id;
  private String pwd;
  private String file;
  
  public int getIdx() {
    return idx;
  }
  public void setIdx(int idx) {
    this.idx = idx;
  }
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
  public String getFile() {
    return file;
  }
  
  public String getOriFile() {
    if(file==null) {
      return "";
    }
    return file.substring(file.indexOf("_")+1);
  }
  
  public void setFile(String file) {
    this.file = file;
  }
  @Override
  public String toString() {
    return "UserVo [idx=" + idx + ", id=" + id + ", pwd=" + pwd + ", file=" + file + "]";
  }
  
  
  
  /*
   * @Override public String toString() { return "UserVo [idx=" + idx + ", id=" +
   * id + ", pwd=" + pwd + "]"; }
   */
  
}
