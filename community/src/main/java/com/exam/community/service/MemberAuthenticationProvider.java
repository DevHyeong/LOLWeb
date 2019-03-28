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
		
		
		//userid�� ����Ͽ� user���� ��������(���̵�,��ȣȭ�Ⱥ�й�ȣ,�̸�,�г���,��ȭ����)
		member memberInfo = service.loadUserByUsername((String)authToken.getPrincipal());
		
		
		//userid�� ���ٸ�
		if(memberInfo == null) {
			
			throw new UsernameNotFoundException("�ش��ϴ� ���̵� �����ϴ�.");
			
		}
		
		//userid�� ������ ��й�ȣ�� ��ġ���� ���� ���
		if(!passwordEncoder.matches((String) authToken.getCredentials(),memberInfo.getPassword())) {
			
			throw new BadCredentialsException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			
		}
		
		System.out.println("����");
		//���� �ڵ���� �Դٸ� �α��μ���
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) memberInfo.getAuthorities();
		return new UsernamePasswordAuthenticationToken(memberInfo,null,authorities);
	
	
	}
	
	
	
	
	
	
	
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	
	
	
	
	
	
}
