package com.spring.myweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.myweb.vo.TopicVo;

public interface TopicDao {

  public void setTopics(@Param("topic") TopicVo topics);

  public List<TopicVo> getTopics();

  public TopicVo detailTopics(@Param("id") Integer id);

  public void updateTopics(@Param("topic") TopicVo topic);

  public List<TopicVo> getVideos();

  public void setVideos(@Param("topic") TopicVo topics);

  public TopicVo detailVideos(@Param("id") Integer id);

  public void updateVideos(@Param("topic") TopicVo topic);

}
