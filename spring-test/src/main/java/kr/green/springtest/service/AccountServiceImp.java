package kr.green.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.AccountDao;
import kr.green.springtest.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService{
	
	@Autowired
	AccountDao accountDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public AccountVo signin(AccountVo loginInfo) {
		AccountVo user = accountDao.getAccount(loginInfo.getId()); 
		//DB에서 검색이 안되면 user값에 null이 들어감
		//그러므로 아래 조건에 user != null 를 추가해줘야지 비회원이 로그인을 한경우 오류창이 안뜨고 다시 로그인화면으로 돌아옴
		if(user != null && passwordEncoder.matches(loginInfo.getPw(), user.getPw()))
			return user;
		return null;
	}

	@Override
	public boolean signup(AccountVo userInfo) {
		if(accountDao.getAccount(userInfo.getId()) != null) //해당아이디로 가입된회원이 있을때
			return false;
		String encPw = passwordEncoder.encode(userInfo.getPw()); //비밀번호를 암호화해서 넣어줌
		userInfo.setPw(encPw);
		accountDao.setAccount(userInfo);
		return true;
	}

	@Override
	public boolean isDuplicated(String id) {
		if(accountDao.getAccount(id) != null)
			return true;
		return false;
	}

}
