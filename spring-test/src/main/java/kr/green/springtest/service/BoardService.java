package kr.green.springtest.service;

import java.util.List;

import kr.green.springtest.vo.AccountVo;
import kr.green.springtest.vo.BoardVo;

public interface BoardService {

	public List<BoardVo> getBoards();

	public void registerBoard(BoardVo board);

	public BoardVo getDetail(Integer id);

	public void deleteDetail(Integer id,AccountVo user);

	public boolean modifyBoard(BoardVo board,AccountVo user);

}
