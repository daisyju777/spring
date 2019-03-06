package com.spring.myweb.service;

import java.util.List;

import com.spring.myweb.vo.TopicVo;

public interface TopicService {

  public void addTopics(TopicVo topics);

  public List<TopicVo> getTopics();

  public TopicVo detailTopics(Integer id);

  public void modifyTopics(TopicVo topic);

  public void deleteTopics(Integer id);

  public List<TopicVo> getVideos();

  public void addVideos(TopicVo topics);

  public TopicVo detailVideos(Integer id);

  public void modifyVideos(TopicVo topic);

  public void deleteVideos(Integer id);

}
