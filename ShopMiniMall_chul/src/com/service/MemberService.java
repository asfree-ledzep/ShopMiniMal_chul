package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberService {
	

	public String idSearch(MemberDTO dto) {
		SqlSession session= null;
		MemberDAO dao= null;
		String userid=null;
		try {
			session= MySqlSessionFactory.getSession();
			dao= new MemberDAO();
			userid= dao.idSearch(session, dto);			;
		}finally {
			session.close();
		}
		
		return userid;
	}

	public int memberAdd(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n=0;
		try {
			MemberDAO dao= new MemberDAO();
			
			n= dao.memberAdd(session, dto);
			session.commit();			
		}finally {
			session.close();
		}
		return n;
	}

	public int idCheck(String userid) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		int count=0;
		try {
		MemberDAO dao= new MemberDAO();
		count = dao.idCheck(session, userid);
		
		}finally{
			session.close();
		}
		
		return count;
	}

	public MemberDTO login(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		
		SqlSession sqlSession= MySqlSessionFactory.getSession();
		MemberDAO dao=null;
		MemberDTO dto=null;
		try {
		dao= new MemberDAO();
		 dto= dao.login(sqlSession, map);
		}finally {
		sqlSession.close();
		}
		return dto;
	}

	public MemberDTO mypage(String userid) {
		// TODO Auto-generated method stub
		SqlSession session= null;
		MemberDAO dao= null;
		MemberDTO dto= null;
		try {
			session= MySqlSessionFactory.getSession();
			dao= new MemberDAO();
			dto= dao.mypage(session, userid);
			
		}finally {
			session.close();
		}
		
		return dto;
	}

	public int memberUpdate(MemberDTO dto2) {
		// TODO Auto-generated method stub
		int count=0;
		SqlSession session=null;
		try {
			session= MySqlSessionFactory.getSession();
			MemberDAO dao= new MemberDAO();
			
			count= dao.memberUpdate(session, dto2);
			session.commit();//주의 
		}finally {
			session.close();			
		}
		return count;
	}

}
