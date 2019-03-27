package com.exam.community.security;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		
		
		// TODO Auto-generated method stub
		try {
			if(request.getSession().getAttribute("user") == null) {
				
				System.out.println(log);
				System.out.println(request.getContextPath());
				response.sendRedirect(request.getContextPath()+"/login");
				return false;
			}else {
				
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return super.preHandle(request, response, handler);
	}
	
}
