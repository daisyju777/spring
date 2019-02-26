package com.spring.dbtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dbtest.pagenation.Criteria;
import com.spring.dbtest.pagenation.PageMaker;
import com.spring.dbtest.service.UserService;
import com.spring.dbtest.utils.UploadFileUtils;
import com.spring.dbtest.vo.UserVo;


@Controller
public class HomeController {
	@Autowired
	UserService userService;
	
	@Autowired
	private String uploadPath;
  
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model, String id, String pwd) {
    model.addAttribute("id",id);
    model.addAttribute("pwd",pwd);
		return "home";
	}
	
	 @RequestMapping(value = "/", method = RequestMethod.POST)
  /* public String homePost(Model model, String id, String pwd) { */
   public String homePost(Model model, UserVo userVo, MultipartFile files) throws IOException, Exception {
	   if(files.getOriginalFilename() != null && files.getOriginalFilename().length() != 0) {
	     String filepath = UploadFileUtils.uploadFile(uploadPath, files.getOriginalFilename(), files.getBytes());
	     userVo.setFile(filepath);
	   }
	   
	   System.out.println("vo:" + userVo);
	   
	    userService.register(userVo);
	    //model.addAttribute("id",id);
	    //model.addAttribute("pwd",pwd);
	    
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
	  

/* 다운로드시 추가부분*/

  @ResponseBody  //형식 다른 파일을 다운받을 수 있도록 처리해주는 어노테이션
  @RequestMapping("/download")
  public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
      InputStream in = null;
      ResponseEntity<byte[]> entity = null;
      try{
          HttpHeaders headers = new HttpHeaders();
          in = new FileInputStream(uploadPath+fileName);

          fileName = fileName.substring(fileName.indexOf("_")+1);
          headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
          headers.add("Content-Disposition",  "attachment; filename=\""
        + new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");   //한글문서가 안깨지려면 uff-8 꼭써줘야함
          entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
      }catch(Exception e) {
          e.printStackTrace();
          entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
      }finally {
          in.close();
      }
      return entity;
  }
  
}
