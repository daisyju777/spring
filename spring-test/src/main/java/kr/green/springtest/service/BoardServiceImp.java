package kr.green.springtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.BoardDao;
import kr.green.springtest.pagenation.Criteria;
import kr.green.springtest.pagenation.PageMaker;
import kr.green.springtest.vo.AccountVo;
import kr.green.springtest.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService {
	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<BoardVo> getBoards() {
		return boardDao.getBoards();
	}

	@Override
	public void registerBoard(BoardVo board) {
		boardDao.setBoard(board);
	}

	@Override
	public BoardVo getDetail(Integer id) {
		if(id==null)
			return null;
		 return boardDao.getDetail(id);
	}

	@Override
	public void deleteDetail(Integer id, AccountVo user) {
		BoardVo board = boardDao.getDetail(id);
		/* 1.해당 id를 가진 게시글이 없거나 이미 삭제된 경우이거나 
		 * 2.로그인한 유저가 게시판 작성자가 아닌 경우
		 * 에는 게시판 삭제 동작이 실행되지 않고 게시판 리스트 페이지로 넘어간다
		 */
		if(board == null||!board.getWriter().equals(user.getId())) return; 
		//조건을 만족하면 메소드를 멈추고 강제종료
		board.setState("D");
		/*boardDao에 updateBoard를 만들어 놓으면 게시판을 삭제할때와 수정할때 모두 쓰일 수 있기 때문에 deleteBoard가 아닌
		 * updateBoard로 함
		 */
		boardDao.updateDetail(board);
	}

	@Override
	public boolean modifyBoard(BoardVo board, AccountVo user) {
		BoardVo oriBoard = boardDao.getDetail(board.getId());
		if(oriBoard == null || !oriBoard.getWriter().equals(user.getId()))
			return false;
		board.setRegisterd_date(oriBoard.getRegisterd_date());
		board.setState(oriBoard.getState());
		boardDao.updateDetail(board);
		return true;
	}

  @Override
  public PageMaker getPageMaker(Criteria cri, int displayPageNum) {
    int totalCount = boardDao.getCountUserLists(cri);
    
    PageMaker pageMaker = new PageMaker();
    pageMaker.setCriteria(cri);
    pageMaker.setDisplayPageNum(displayPageNum);
    pageMaker.setTotalCount(totalCount);
    
    return pageMaker;
  }
  
  @Override  //페이징처리시 필요
  public List<BoardVo> getUsers(Criteria cri) {
    return boardDao.getUserLists(cri);
  }


}


