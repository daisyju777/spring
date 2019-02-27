package com.spring.myweb.service;

import java.util.List;

import com.spring.myweb.pagenation.Criteria;
import com.spring.myweb.pagenation.PageMaker;
import com.spring.myweb.vo.AccountVo;
import com.spring.myweb.vo.BoardVo;


public interface BoardService {
  public List<BoardVo> getBoards();

  public void registerBoard(BoardVo board);

  public BoardVo getDetail(Integer id);

  public void deleteDetail(Integer id,AccountVo user);

  public boolean modifyBoard(BoardVo board,AccountVo user);

  public PageMaker getPageMaker(Criteria cri, int i);

  public List<BoardVo> getUsers(Criteria cri);

}
