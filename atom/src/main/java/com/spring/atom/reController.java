package com.spring.atom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class reController {
  @RequestMapping("/st")
  public String stGet(HttpServletRequest httpSer, Model model) {
    String id = httpSer.getParameter("id");
    System.out.println("id : " +id);
    
    if(id.equals("admin")) {     // 문자열에서 ==로 비교하면 주소를 비교하게되는것이므로 equals를써야함
      return "redirect:/stOk";
    }
    
    return "redirect:/stNo";
  }
  
  @RequestMapping("/stOk")
  public String stOk() {
    return "st/stOk";
  }
  
  @RequestMapping("/stNo")
  public String stNo() {
    return "st/stNo";
  }
  
}
