package com.spring.atom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
  
  @RequestMapping(value = "/t1", method = RequestMethod.GET)
  public String test1() {
    
    return "test/test1";
  }

  @RequestMapping(value = "/t2", method = RequestMethod.GET)
  public String test2(HttpServletRequest httpservletRequest, Model model) {
    String id = httpservletRequest.getParameter("id");
    String pwd = httpservletRequest.getParameter("pwd");
    model.addAttribute("id",id);
    model.addAttribute("pwd",pwd);
    
    return "test/test2";
  }
  
  @RequestMapping(value = "/t2f", method = RequestMethod.GET)
  public String test2Form() {
    
    return "test/test2Form";
  }
  
  @RequestMapping(value = "/test/t2", method = RequestMethod.GET)
  public String test2F(HttpServletRequest httpservletRequest, Model model) {
    String id = httpservletRequest.getParameter("id");
    String pwd = httpservletRequest.getParameter("pwd");
    model.addAttribute("id",id);
    model.addAttribute("pwd",pwd);
    
    return "test/test2";
  }
  
  @RequestMapping(value = "/test/tp2", method = RequestMethod.GET)
  public String test2P(@RequestParam("id") String id, @RequestParam("pwd") String pwd, Model model) {
    model.addAttribute("id",id);
    model.addAttribute("pwd",pwd);
    
    return "test/test2";
  }
  
  @RequestMapping(value = "/test/tv2", method = RequestMethod.GET)
  public String test2V(@RequestParam("id") String id, @RequestParam("pwd") String pwd, Model model) {
    TestVo testVo = new TestVo();
    testVo.setId(id);
    testVo.setPwd(pwd);
    
    //model.addAttribute("id",id);
    //model.addAttribute("pwd",pwd);
    model.addAttribute("testVo",testVo);
    
    return "test/test2Vo";
  }
  
  @RequestMapping(value = "/test/tvV2", method = RequestMethod.GET)
  public String test2Vv(TestVo testVo) { //호출과 동시에 객체생성
  
    return "test/test2Vo";
  }
}
