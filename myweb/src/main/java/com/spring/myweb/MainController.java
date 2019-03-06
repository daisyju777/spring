package com.spring.myweb;

import java.util.HashMap;
import java.util.List;
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
import com.spring.myweb.service.TopicService;
import com.spring.myweb.vo.AccountVo;
import com.spring.myweb.vo.TopicVo;


@Controller
public class MainController {
  @Autowired
  AccountService accountService;
  
  @Autowired
  TopicService topicservice;

  
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
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
	   
	   @RequestMapping(value = "/health/hottopics", method = RequestMethod.GET)
	   public String hottopics(Model model) {
	     List<TopicVo> list = topicservice.getTopics();
	     model.addAttribute("list", list);
	     return "health/hottopics";
	   }
	   
	   
	   @RequestMapping(value = "/health/detailtopics", method = RequestMethod.GET)
	   public String detailtopicsGet(Model model,Integer id) {
	    TopicVo topic = topicservice.detailTopics(id);
	    if(topic==null)  //(직접 URI를 입력하는 등의)잘못된 경로로 접근했을때는 null값이 반환되므로 이때는 게시글목록으로 보내줌
	      return "redirect:/health/hottopics";
	    model.addAttribute("topic",topic);
	    //System.out.println(topic.getFile());
	    return "health/detailtopics";
	   }
	   
     @RequestMapping(value = "/fitness/videos", method = RequestMethod.GET)
     public String videos(Model model) {
       List<TopicVo> list = topicservice.getVideos();
       model.addAttribute("list", list);
       return "fitness/videos";
     }
	   
     @RequestMapping(value = "/fitness/detailvideos", method = RequestMethod.GET)
     public String detailvideosGet(Model model,Integer id) {
      TopicVo topic = topicservice.detailVideos(id);
      if(topic==null)  //(직접 URI를 입력하는 등의)잘못된 경로로 접근했을때는 null값이 반환되므로 이때는 게시글목록으로 보내줌
        return "redirect:/fitness/videos";
      model.addAttribute("topic",topic);
      //System.out.println(topic.getFile());
      return "fitness/detailvideos";
     }
     
}
