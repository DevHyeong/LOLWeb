package com.exam.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exam.community.member;
import com.exam.community.dao.memberDao;

@Service
public class memberService implements ImemberService, UserDetailsService {
	
	@Autowired
	memberDao dao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void memberJoin(member member) {
		// TODO Auto-generated method stub
		String password = member.getPassword();
		member.setPassword(passwordEncoder.encode(password));
		
		dao.memberJoin(member);
	}

	@Override
	public int idCheck(String userID) {
		// TODO Auto-generated method stub
		return dao.idCheck(userID);
	}

	@Override
	public int NicknameCheck(String name) {
		// TODO Auto-generated method stub
		return dao.NicknameCheck(name);
	}

	@Override
	public member memberLogin(member member) {
		// TODO Auto-generated method stub
		String userid = member.getUserid();
		member user = dao.memberLogin(userid);
		
		
		if(user == null) { // 아이디가 틀린경우
			
			return user;
			
		}else if(passwordEncoder.matches(member.getPassword(), user.getPassword())) {
			//비밀번호 일치, 로그인 성공
			
			return user;
			
		}else {
			// 비밀번호 불일치
		
			return null;
			
		}
		
		
		
		
		
		
	}

	@Override
	public member loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		member memberInfo = null;
		
		
		try {
			
			memberInfo = dao.memberLogin(username);
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return memberInfo;
	}

}
