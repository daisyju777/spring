package kr.green.springtest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.springtest.pagenation.Criteria;
import kr.green.springtest.pagenation.PageMaker;
import kr.green.springtest.service.BoardService;
import kr.green.springtest.vo.AccountVo;
import kr.green.springtest.vo.BoardVo;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/bbs/list", method=RequestMethod.GET)
	public String list(Model model,HttpServletRequest request, Criteria cri) {
		//List<BoardVo> list = boardService.getBoards();
	  
    /*페이징처리*/
    PageMaker pageMaker = boardService.getPageMaker(cri,5);
    List<BoardVo> list = boardService.getUsers(cri);
    //System.out.println("page:"+pageMaker.criteria.getPage());
    model.addAttribute("cri",cri);
		model.addAttribute("list",list);
		model.addAttribute("pageMaker",pageMaker);
		return "bbs/list";
	}
	
	@RequestMapping(value="/bbs/register", method=RequestMethod.GET)
	public String registerGet(Model model) {
		return "bbs/register";
	}
	@RequestMapping(value="/bbs/register", method=RequestMethod.POST)
	public String registerPost(Model model,BoardVo board) {
		boardService.registerBoard(board);
		return "redirect:/bbs/list";
	}
	@RequestMapping(value="/bbs/detail", method=RequestMethod.GET)
	public String detailGet(Model model, Integer id, Criteria cri) { //id타입을 Integer로 해도 상관없음
		//1. 전달받은 id값을 콘솔에 출력
		//System.out.println(id);
		//2. 서비스에서 id값을 이용하여 해당 게시글을 가져오는 메소드 호출
		BoardVo board = boardService.getDetail(id);
		//System.out.println(board);
		if(board==null)  //(직접 URI를 입력하는 등의)잘못된 경로로 접근했을때는 null값이 반환되므로 이때는 게시글목록으로 보내줌
			return "redirect:/bbs/list";
		//3. 해당게시글을 jsp로 전달
		model.addAttribute("board",board);
		model.addAttribute("cri",cri);
		return "bbs/detail";
	}
	
	//삭제버튼을 누르면 DB의 state값을 D로 바꾸고 게시글 목록에서 삭제된것처럼 보이게 하기
	@RequestMapping(value="/bbs/delete", method=RequestMethod.GET)
	public String deleteGet(Model model,Integer id,HttpServletRequest request) {
		//request에서 session 정보를 가져와서 session에 저장된 user 정보를 가져옴
		HttpSession session = request.getSession();
		AccountVo user = (AccountVo)session.getAttribute("user");
		/*삭제 권한이 없는 유저가 URI를 통해 삭제를 시도할 수 있기 때문에 
		 * 권한이 없는 유저가 삭제를 시도하면 막아주기 위해서 게시판 id와 현재 로그인한 유저정보를 전달*/
		boardService.deleteDetail(id, user);
		return "redirect:/bbs/list";
	}
	
	@RequestMapping(value="/bbs/modify", method=RequestMethod.GET)
	public String modifyGet(Model model,Integer id) {
		BoardVo board = boardService.getDetail(id);
		if(board==null)
			return "redirect:/bbs/list";
		model.addAttribute("board",board);
		return "bbs/modify";
	}
	@RequestMapping(value="/bbs/modify", method=RequestMethod.POST)
	public String modifyPost(Model model,BoardVo board, HttpServletRequest request) {
		HttpSession session = request.getSession();
		AccountVo user = (AccountVo)session.getAttribute("user");

		if(!boardService.modifyBoard(board, user)) //앞쪽은 수정되야할글, user는 원래게시판글. 둘이 같지않으면 게시판목록을 보여줌 
			return "redirect:/bbs/list";
			
		model.addAttribute("id",board.getId());
		return "redirect:/bbs/detail";
	}
}
