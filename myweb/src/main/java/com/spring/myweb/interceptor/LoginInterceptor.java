package com.spring.myweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.myweb.vo.AccountVo;

public class LoginInterceptor extends HandlerInterceptorAdapter{
  @Override
  public void postHandle(
      HttpServletRequest request, HttpServletResponse response, //response는 컨트롤러에서 보내는정보. 
      Object handler, ModelAndView modelAndView)
      throws Exception {
      ModelMap modelMap = modelAndView.getModelMap();
      AccountVo user = (AccountVo)modelMap.get("user"); // 컨트롤러에서 jsp로 user를 넘겨주기 전에 가로챔

      if(user != null) {
          HttpSession session = request.getSession();
          session.setAttribute("user", user);
      }
  }

}
