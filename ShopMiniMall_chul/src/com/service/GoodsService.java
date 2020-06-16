package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.GoodsDAO;
import com.dao.MemberDAO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;

public class GoodsService {

	public List<GoodsDTO> goodsList(String gCategory) {
		// TODO Auto-generated method stub
		SqlSession session= MySqlSessionFactory.getSession();
		List<GoodsDTO> list= null;
		try {
		GoodsDAO dao= new GoodsDAO();
		list= dao.goodsList(session, gCategory);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	public GoodsDTO goodsRetrive(String gCode) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		GoodsDTO dto= null;
		try {
			session= MySqlSessionFactory.getSession();
			GoodsDAO dao= new GoodsDAO();
			dto=  dao.goodsRetrive(session, gCode);
		}finally {
			session.close();
		}
		return dto;
	}
	

}
