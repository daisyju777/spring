package kr.green.springtest.vo;

import java.sql.Date;

//mysql테이블 속성명을 자료형에 맞에 입력해주면됨
public class AccountVo {
	private String id;
	private String pw;
	private String email;
	private String gender;
	private Date registed_date;
	private String authorty;
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
	public String getAuthorty() {
		return authorty;
	}
	public void setAuthorty(String authorty) {
		this.authorty = authorty;
	}
	@Override
	public String toString() {
		return "AccountVo [id=" + id + ", pw=" + pw + ", email=" + email + ", gender=" + gender + ", registed_date="
				+ registed_date + ", authorty=" + authorty + "]";
	}
	
	
}
