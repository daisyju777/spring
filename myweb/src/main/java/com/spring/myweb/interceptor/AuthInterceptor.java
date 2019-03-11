package com.spring.myweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.myweb.vo.AccountVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {
  @Override
  public boolean preHandle(HttpServletRequest request, 
      HttpServletResponse response, 
      Object handler)
      throws Exception {
    HttpSession session = request.getSession(); 
    AccountVo user = (AccountVo)session.getAttribute("user");
    //Object user = session.getAttribute("user"); //세션에 있는 유저정보를 가져옴
    //AccountVo user = (AccountVo)session.getAttribute("user"); 
    //이렇게 써도 되지만 지금은 굳이 형변환을 할 필요가 없이 Object로만 써도됨. 유저정보가 있는지 없는지 여부만 판단하면 되므로
    if(user == null) {
      response.sendRedirect(request.getContextPath()+"/login");
      return false; //return true이면 이전에 가려던 경로(컨트롤러에 정해준 경로)로 다시 가게됨
    }
    if(!user.getAuthority().equals("admin")) {
      response.sendRedirect(request.getContextPath()+"/");
      return false; //return true이면 이전에 가려던 경로(컨트롤러에 정해준 경로)로 다시 가게됨
    }
    return true;
    
    
  }
}
