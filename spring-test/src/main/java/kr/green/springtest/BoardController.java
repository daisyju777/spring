package kr.green.springtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	@RequestMapping(value="/bbs/list")        //검색을 할때에는 보통 get방식임. 검색어는 딱히 보호되어야 할 정보가 아니므로 주소에 붙어서 감
	public String list() {
		return "bbs/list";
	}
}
