package kr.green.springtest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.springtest.pagenation.Criteria;
import kr.green.springtest.vo.AccountVo;
import kr.green.springtest.vo.BoardVo;

public interface BoardDao {

	public List<BoardVo> getBoards();

	public void setBoard(@Param("board")BoardVo board);

	public BoardVo getDetail(@Param("id")Integer id);

	public void updateDetail(@Param("board")BoardVo board);

  public int getCountUserLists(@Param("cri") Criteria cri);

  public List<BoardVo> getUserLists(@Param("cri") Criteria cri);

}
