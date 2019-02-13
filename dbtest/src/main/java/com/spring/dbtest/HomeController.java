package com.spring.dbtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dbtest.service.UserService;


@Controller
public class HomeController {
	@Autowired
	UserService userService;
  
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model, String id, String pwd) {
    model.addAttribute("id",id);
    model.addAttribute("pwd",pwd);
		return "home";
	}
	
	 @RequestMapping(value = "/", method = RequestMethod.POST)
	  public String homePost(Model model, String id, String pwd) {
	    userService.register(id,pwd);
	    model.addAttribute("id",id);
	    model.addAttribute("pwd",pwd);
	    
	    // return "home";
	    return "redirect:/";
	  }
}
