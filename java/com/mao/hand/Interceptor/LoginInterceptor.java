package com.mao.hand.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {

		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI().toString();
		String name =(String) request.getSession().getAttribute("name");
		if(name!=null){
			return true;
		}

		if(url.endsWith("Login.do")){
			System.out.println(1);
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/Login.jsp");
		System.out.println(2);
		return false;
	}

}
