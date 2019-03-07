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

}