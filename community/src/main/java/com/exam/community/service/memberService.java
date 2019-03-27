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
		
		
		if(user == null) { // ���̵� Ʋ�����
			
			return user;
			
		}else if(passwordEncoder.matches(member.getPassword(), user.getPassword())) {
			//��й�ȣ ��ġ, �α��� ����
			
			return user;
			
		}else {
			// ��й�ȣ ����ġ
		
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
