package com.exam.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exam.community.member;

public class MemberAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	memberService service;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;
		
		
		//userid를 사용하여 user정보 가져오기(아이디,암호화된비밀번호,이름,닉네임,전화번도)
		member memberInfo = service.loadUserByUsername((String)authToken.getPrincipal());
		
		
		//userid가 없다면
		if(memberInfo == null) {
			
			throw new UsernameNotFoundException("해당하는 아이디가 없습니다.");
			
		}
		
		//userid는 있으나 비밀번호가 일치하지 않을 경우
		if(!passwordEncoder.matches((String) authToken.getCredentials(),memberInfo.getPassword())) {
			
			throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
			
		}
		
		System.out.println("성공");
		//여기 코드까지 왔다면 로그인성공
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) memberInfo.getAuthorities();
		return new UsernamePasswordAuthenticationToken(memberInfo,null,authorities);
	
	
	}
	
	
	
	
	
	
	
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	
	
	
	
	
	
}
