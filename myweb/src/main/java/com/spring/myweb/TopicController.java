package com.spring.myweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.spring.myweb.service.TopicService;
import com.spring.myweb.utils.UploadFileUtils;
import com.spring.myweb.vo.TopicVo;


@Controller
public class TopicController {
  @Autowired
  TopicService topicservice;
  
  @Autowired
  private String uploadPath;


  @RequestMapping(value = "/admin", method = RequestMethod.GET)
  public String adminGet() {
    return "admin/adminMain";
  }
  
  @RequestMapping(value = "/admin/left", method = RequestMethod.GET)
  public String leftGet() {
    return "admin/left";
  }

  @RequestMapping(value = "/admin/right", method = RequestMethod.GET)
  public String rightGet() {
    return "admin/right";
  }

  //health
  
  @RequestMapping(value = "/admin/health/hottopics/list", method = RequestMethod.GET)
  public String healthlistGet(Model model) {
    List<TopicVo> list = topicservice.getTopics();
    model.addAttribute("list",list);
    return "admin/health/hottopics/list";
  }
  
  @RequestMapping(value = "/admin/health/hottopics/register", method = RequestMethod.GET)
  public String healthregisterGet() {
    return "admin/health/hottopics/register";
  }
  
  @RequestMapping(value = "/admin/health/hottopics/register", method = RequestMethod.POST)
  public String addtopicsPost(Model model,TopicVo topics, MultipartFile files) throws IOException, Exception {
    if(files.getOriginalFilename() != null && files.getOriginalFilename().length() != 0) {
      String filepath = UploadFileUtils.uploadFile(uploadPath, files.getOriginalFilename(), files.getBytes());
      topics.setFile(filepath);
    }
    topicservice.addTopics(topics);
    return "redirect:/admin/health/hottopics/list";
  }
  
  @RequestMapping(value = "/admin/health/hottopics/detail", method = RequestMethod.GET)
  public String detailtopicsGet(Model model,Integer id) {
   TopicVo topic = topicservice.detailTopics(id);
   if(topic==null)  //(직접 URI를 입력하는 등의)잘못된 경로로 접근했을때는 null값이 반환되므로 이때는 게시글목록으로 보내줌
     return "redirect:/admin/health/hottopics/list";
   model.addAttribute("topic",topic);
   //System.out.println(topic.getFile());
   return "admin/health/hottopics/detail";
  }
  
  @RequestMapping(value="/admin/health/hottopics/modify", method=RequestMethod.GET)
  public String modifyGet(Model model,Integer id) {
    TopicVo topic = topicservice.detailTopics(id);
    if(topic==null)  //(직접 URI를 입력하는 등의)잘못된 경로로 접근했을때는 null값이 반환되므로 이때는 게시글목록으로 보내줌
      return "redirect:/admin/health/hottopics/detail";
    model.addAttribute("topic",topic);
    return "admin/health/hottopics/modify";
  }
  
  @RequestMapping(value="/admin/health/hottopics/modify", method=RequestMethod.POST)
  public String modifyPost(Model model,TopicVo topic, MultipartFile files) throws IOException, Exception {
    if(files.getOriginalFilename() != null && files.getOriginalFilename().length() != 0) {
      String filepath = UploadFileUtils.uploadFile(uploadPath, files.getOriginalFilename(), files.getBytes());
      topic.setFile(filepath);
    } 
    topicservice.modifyTopics(topic);
    model.addAttribute("id",topic.getId());
    return "redirect:/admin/health/hottopics/detail";
  }
  
  @RequestMapping(value="/admin/health/hottopics/delete", method=RequestMethod.GET)
  public String deleteGet(Model model,Integer id) {
    topicservice.deleteTopics(id);
    return "redirect:/admin/health/hottopics/detail";
  }
  
  
//  fitness
  
  @RequestMapping(value = "/admin/fitness/videos/list", method = RequestMethod.GET)
  public String videoslistGet(Model model) {
    List<TopicVo> list = topicservice.getVideos();
    model.addAttribute("list",list);
    return "admin/fitness/videos/list";
  }
  
  @RequestMapping(value = "/admin/fitness/videos/register", method = RequestMethod.GET)
  public String videosregisterGet() {
    return "/admin/fitness/videos/register";
  }
  
  @RequestMapping(value = "/admin/fitness/videos/register", method = RequestMethod.POST)
  public String addvideosPost(Model model,TopicVo topics, MultipartFile files) throws IOException, Exception {
    if(files.getOriginalFilename() != null && files.getOriginalFilename().length() != 0) {
      String filepath = UploadFileUtils.uploadFile(uploadPath, files.getOriginalFilename(), files.getBytes());
      topics.setFile(filepath);
    }
    topicservice.addVideos(topics);
    return "redirect:/admin/fitness/videos/list";
  }
  
  @RequestMapping(value = "/admin/fitness/videos/detail", method = RequestMethod.GET)
  public String detailvideosGet(Model model,Integer id) {
   TopicVo topic = topicservice.detailVideos(id);
   if(topic==null)  //(직접 URI를 입력하는 등의)잘못된 경로로 접근했을때는 null값이 반환되므로 이때는 게시글목록으로 보내줌
     return "redirect:/admin/fitness/videos/list";
   model.addAttribute("topic",topic);
   //System.out.println(topic.getFile());
   return "/admin/fitness/videos/detail";
  }
  
  @RequestMapping(value="/admin/fitness/videos/modify", method=RequestMethod.GET)
  public String videosmodifyGet(Model model,Integer id) {
    TopicVo topic = topicservice.detailVideos(id);
    if(topic==null)  //(직접 URI를 입력하는 등의)잘못된 경로로 접근했을때는 null값이 반환되므로 이때는 게시글목록으로 보내줌
      return "redirect:/admin/fitness/videos/detail";
    model.addAttribute("topic",topic);
    return "admin/fitness/videos/modify";
  }
  
  @RequestMapping(value="/admin/fitness/videos/modify", method=RequestMethod.POST)
  public String videosmodifyPost(Model model,TopicVo topic, MultipartFile files) throws IOException, Exception {
    if(files.getOriginalFilename() != null && files.getOriginalFilename().length() != 0) {
      String filepath = UploadFileUtils.uploadFile(uploadPath, files.getOriginalFilename(), files.getBytes());
      topic.setFile(filepath);
    } 
    topicservice.modifyVideos(topic);
    model.addAttribute("id",topic.getId());
    return "redirect:/admin/fitness/videos/detail";
  }
  
  @RequestMapping(value="/admin/fitness/videos/delete", method=RequestMethod.GET)
  public String videodeleteGet(Model model,Integer id) {
    topicservice.deleteVideos(id);
    return "redirect:/admin/fitness/videos/detail";
  }
  
  
  
}
