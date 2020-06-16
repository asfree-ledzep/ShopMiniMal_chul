package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	public String idSearch(SqlSession session, MemberDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAO mapper 실행전  dto===="+dto);
		String userid= session.selectOne("MemberMapper.idSearch", dto);
		return userid;
	}

	public int memberAdd(SqlSession session, MemberDTO dto) {
		//System.out.println(dto);
		int n= session.insert("MemberMapper.memberAdd", dto);
		
		return n;
	}

	public int idCheck(SqlSession session, String userid) {
		// TODO Auto-generated method stub
		int count=0;
		count= session.selectOne("MemberMapper.idCheck",userid);
		
		return count;
	}

	public MemberDTO login(SqlSession sqlSession, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		MemberDTO dto= sqlSession.selectOne("MemberMapper.login", map);
		System.out.println("dto "+ dto);
		return dto;
	}

	public MemberDTO mypage(SqlSession session, String userid) {
		// TODO Auto-generated method stub
		MemberDTO dto= session.selectOne("MemberMapper.mypage", userid);
		
		return dto;
	}

	public int memberUpdate(SqlSession session, MemberDTO dto2) {
		System.out.println("dao memberUpdate 바로전 ====="+ dto2);
		int count=session.update("MemberMapper.memberUpdate", dto2);
		return count;
	}

	
	
}
