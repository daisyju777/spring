package com.spring.myweb;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.myweb.service.AccountService;
import com.spring.myweb.vo.AccountVo;


@Controller
public class MainController {
  @Autowired
  AccountService accountService;
  
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
	}
	
	 @RequestMapping(value = "/hottopics", method = RequestMethod.GET)
	  public String hottopics(Model model) {
	    
	    return "hottopics";
	  }
	 
	
	  @RequestMapping(value = "/signup", method = RequestMethod.GET)
	  public String signupGet(Model model) {
	    return "signup";
	  }
	  
	  @RequestMapping(value = "/signup", method = RequestMethod.POST)
	  public String signupPost(Model model, AccountVo userInfo) {
	    boolean isUser = accountService.signup(userInfo); //accountService.signin(loginInfo)는 결과로 객체정보를 전달해줌
	    if (isUser)
	      return "redirect:/login";
	    return "redirect:/signup"; //아이디 중복일 경우에는 회원가입실패함
	  }
	  
	  @RequestMapping(value = "/signup/dup")
	  @ResponseBody  //요청정보에대해 내가 원하는 데이터로 전송해줌
	  public Map<Object, Object> idcheck(@RequestBody String id){
	    Map<Object, Object> map = new HashMap<Object, Object>();  //bojet 앞에는 키값
	    boolean dup = accountService.isDuplicated(id);
	    map.put("dup",dup);
	    return map;
	  }
	  
	   @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginGet(Model model) {
	      return "login";
	    }
	   
	   @RequestMapping(value = "/login", method = RequestMethod.POST)
	   public String homePost(Model model, AccountVo loginInfo) {
	     AccountVo user = accountService.signin(loginInfo); //accountService.signin(loginInfo)는 결과로 객체정보를 전달해줌
	     if(user != null) {
         model.addAttribute("user",user);
	       return "redirect:/";
	     } else {
	       return "redirect:/login";
	     }
	   
	   }
	 
	   @RequestMapping(value = "/signout", method = RequestMethod.GET)
	   public String signoutGet(Model model,HttpServletRequest request) {
	     HttpSession session = request.getSession();
	     session.removeAttribute("user"); //세션에서  사용자 정보 제거
	     return "redirect:/";
	   }

}
