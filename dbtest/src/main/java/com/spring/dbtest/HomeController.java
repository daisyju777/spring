package com.spring.dbtest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dbtest.pagenation.Criteria;
import com.spring.dbtest.pagenation.PageMaker;
import com.spring.dbtest.service.UserService;
import com.spring.dbtest.vo.UserVo;


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
	    
	    /* return "redirect:/"; */
	    return "home";
	  }
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 //public String listGet(Model model, UserVo userVo) {
	 public String listGet(Model model, HttpServletRequest request, Criteria cri) {
	   //List<UserVo> getList =  userService.getListView(userVo);
	   //model.addAttribute("list",getList);
	   
	   /*페이징처리*/
	   PageMaker pageMaker = userService.getPageMaker(cri,5);
	   List<UserVo> list = userService.getUsers(cri);
	   model.addAttribute("cri",cri);
	   model.addAttribute("list",list);
	   model.addAttribute("pageMaker",pageMaker);
	   
	   
	   return "list";
	 }
	 
	  @RequestMapping(value="/search", method=RequestMethod.GET)
	  public String searchGet(Model model, UserVo userVo, String search) {
	    List<UserVo> getSearch = userService.getSearchView(search);
	    model.addAttribute("search", getSearch);
	    
	    return "search";
	  }
	  
	  @RequestMapping(value="/search", method=RequestMethod.POST)
	  public String searchPost(Model model, UserVo userVo, String search) {
	    
	    return "redirect:/search";
	  }
	  
	  @RequestMapping(value="/update", method=RequestMethod.GET)
	  public String updateGet(Model model, UserVo userVo, String search) {
	    List<UserVo> getSearch = userService.getSearchView(search);
	    model.addAttribute("search", getSearch);
	      
	    return "update";
	  }
	  
	  @RequestMapping(value="/update", method=RequestMethod.POST)
	  public String updatePost(Model model, UserVo userVo, String id, String pwd) {
	    //오류가 나면 찍어보기
	    //System.out.println("처리전 : id= "+id+",pwd="+pwd);
	    userService.userUpdate(id, pwd);
	    //System.out.println("처리후 : id= "+id+",pwd="+pwd);
	    return "redirect:/list";
	  }
	  
	   @RequestMapping(value="/delete", method=RequestMethod.GET)
	    public String deleteGet(Model model, UserVo userVo, String search) {
	      List<UserVo> getSearch = userService.getSearchView(search);
	      model.addAttribute("search", getSearch);
	      
	      return "delete";
	    }
	  
	  @RequestMapping(value="/delete", method=RequestMethod.POST)
	  public String deletePost(String id, String pwd) {
	    userService.userDelete(id, pwd);
	    return "redirect:/list";
	  }
}
