package kr.green.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.springtest.service.AccountService;
import kr.green.springtest.vo.AccountVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(Model model, AccountVo loginInfo) {
		AccountVo user = accountService.signin(loginInfo); //accountService.signin(loginInfo)는 결과로 객체정보를 전달해줌
		model.addAttribute("user",user);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(Model model) {
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(Model model, AccountVo userInfo) {
		boolean isUser = accountService.signup(userInfo); //accountService.signin(loginInfo)는 결과로 객체정보를 전달해줌
		if (isUser)
			return "redirect:/";
		return "redirect:/signup"; //아이디 중복일 경우에는 회원가입실패함
	}
	
}
