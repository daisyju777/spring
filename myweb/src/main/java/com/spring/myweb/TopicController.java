package com.spring.myweb;

import java.io.IOException;
import java.util.List;

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

  
  @RequestMapping(value = "health/hottopics", method = RequestMethod.GET)
   public String hottopics(Model model) {
    List<TopicVo> list = topicservice.getTopics();
    model.addAttribute("list",list);
    return "health/hottopics";
   }
  
  @RequestMapping(value = "health/addtopics", method = RequestMethod.GET)
  public String addtopicsGet(Model model) {
    return "health/addtopics";
  }
  
  @RequestMapping(value = "health/addtopics", method = RequestMethod.POST)
  public String addtopicsPost(Model model,TopicVo topics, MultipartFile files) throws IOException, Exception {
    if(files.getOriginalFilename() != null && files.getOriginalFilename().length() != 0) {
      String filepath = UploadFileUtils.uploadFile(uploadPath, files.getOriginalFilename(), files.getBytes());
      topics.setFile(filepath);
    }
    topicservice.addTopics(topics);
    return "redirect:/health/hottopics";
  }
  
  @RequestMapping(value = "health/detailtopics", method = RequestMethod.GET)
  public String detailtopicsGet(Model model,Integer id) {
   TopicVo topic = topicservice.detailTopics(id);
   if(topic==null)  //(직접 URI를 입력하는 등의)잘못된 경로로 접근했을때는 null값이 반환되므로 이때는 게시글목록으로 보내줌
     return "redirect:/health/hottopics";
   model.addAttribute("topic",topic);
   return "health/detailtopics";
  }
  
}
