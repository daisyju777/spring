package com.spring.myweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.myweb.pagenation.Criteria;
import com.spring.myweb.vo.BoardVo;


public interface BoardDao {
  public List<BoardVo> getBoards();

  public void setBoard(@Param("board")BoardVo board);

  public BoardVo getDetail(@Param("id")Integer id);

  public void updateDetail(@Param("board")BoardVo board);

  public int getCountUserLists(@Param("cri") Criteria cri);

  public List<BoardVo> getUserLists(@Param("cri") Criteria cri);

}
