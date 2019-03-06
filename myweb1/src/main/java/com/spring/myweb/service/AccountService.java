package com.spring.myweb.service;

import com.spring.myweb.vo.AccountVo;

public interface AccountService {
  public AccountVo signin(AccountVo loginInfo);

  public boolean signup(AccountVo userInfo);

  public boolean isDuplicated(String id);

}
