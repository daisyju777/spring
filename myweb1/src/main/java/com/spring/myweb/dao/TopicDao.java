package com.spring.myweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.myweb.vo.TopicVo;

public interface TopicDao {

  public void setTopics(@Param("topic") TopicVo topics);

  public List<TopicVo> getTopics();

  public TopicVo detailTopics(@Param("id") Integer id);

  public void updateTopics(@Param("topic") TopicVo topic);

}
