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

}
