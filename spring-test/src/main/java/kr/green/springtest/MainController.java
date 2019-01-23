package kr.green.springtest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "/signup/dup")
	@ResponseBody  //요청정보에대해 내가 원하는 데이터로 전송해줌
	public Map<Object, Object> idcheck(@RequestBody String id){
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean dup = accountService.isDuplicated(id);
		map.put("dup",dup);
		return map;
	}
	
}
