package kr.green.springtest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//특정페이지를 권한이 있는 애들(로그인한 사람들)만 들어가고 권한이 없는 사람들은 못들어가게 해줌
public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession(); //세션에 있는 유저정보를 가져옴
		Object user = session.getAttribute("user");
		//AccountVo user = (AccountVo)session.getAttribute("user"); 
		//이렇게 써도 되지만 지금은 굳이 형변환을 할 필요가 없이 Object로만 써도됨. 유저정보가 있는지 없는지 여부만 판단하면 되므로
		if(user == null) {
			response.sendRedirect(request.getContextPath()+"/");
		}
		return true;
	}
}
