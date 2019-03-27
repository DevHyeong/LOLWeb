package com.exam.community.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.exam.community.member;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	private static int TIME = 60 * 60; // 1시간
	
	// 내가 원하는 기능
	// session 설정 session.setAttribute("user");
	// redirect 설정. --> requestmapping("/");
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Url="/";
		HttpSession session = request.getSession();
		member user = (member)authentication.getPrincipal();
		
		System.out.println("여기안들어오시나");
		
		if(session !=null) {
			String redirectUrl = (String) session.getAttribute("prevPage");
			if(redirectUrl !=null) {
				session.removeAttribute("prevPage");
				request.getSession().setAttribute("user", user);
				request.getSession().setMaxInactiveInterval(TIME);
				redirectStrategy.sendRedirect(request, response, redirectUrl);
			}else {
				request.getSession().setAttribute("user", user);
				request.getSession().setMaxInactiveInterval(TIME);
				redirectStrategy.sendRedirect(request, response, Url);
				
				
				
			}
			
		}else {
		
		//세션관리.
			request.getSession().setAttribute("user", user);
			request.getSession().setMaxInactiveInterval(TIME);
			redirectStrategy.sendRedirect(request, response, Url);
			
		
		}
	}
	
	
	
	
}
