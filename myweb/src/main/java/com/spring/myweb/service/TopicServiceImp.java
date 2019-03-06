package com.spring.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myweb.dao.TopicDao;
import com.spring.myweb.vo.TopicVo;

@Service
public class TopicServiceImp implements TopicService {
  @Autowired
  TopicDao topicdao;

  
  //health
  
  @Override
  public void addTopics(TopicVo topics) {
    topicdao.setTopics(topics);
  }

  @Override
  public List<TopicVo> getTopics() {
    return topicdao.getTopics();
  }

  @Override
  public TopicVo detailTopics(Integer id) {
    if(id==null)
      return null;
     return topicdao.detailTopics(id);
  }

  @Override
  public void modifyTopics(TopicVo topic) {
    TopicVo oriTopic = topicdao.detailTopics(topic.getId());
    topic.setState(oriTopic.getState());
    if (topic.getFile()==null) topic.setFile(oriTopic.getFile());  //수정할때 다시 따로 파일지정을 안해주면 기존에 있던 파일을 불러옴
    topicdao.updateTopics(topic);
  }

  @Override
  public void deleteTopics(Integer id) {
    TopicVo topic = topicdao.detailTopics(id);
    topic.setState("D");
    topicdao.updateTopics(topic);
  }

  
  //fitness
  
  @Override
  public List<TopicVo> getVideos() {
      return topicdao.getVideos();
  }

  @Override
  public void addVideos(TopicVo topics) {
    topicdao.setVideos(topics);
  }

  @Override
  public TopicVo detailVideos(Integer id) {
    if(id==null)
      return null;
     return topicdao.detailVideos(id);
  }

  @Override
  public void modifyVideos(TopicVo topic) {
    TopicVo oriVideo = topicdao.detailVideos(topic.getId());
    topic.setState(oriVideo.getState());
    if (topic.getFile()==null) topic.setFile(oriVideo.getFile());  //수정할때 다시 따로 파일지정을 안해주면 기존에 있던 파일을 불러옴
    topicdao.updateVideos(topic);
    
  }

  @Override
  public void deleteVideos(Integer id) {
    TopicVo topic = topicdao.detailVideos(id);
    topic.setState("D");
    topicdao.updateVideos(topic);
  }

}
