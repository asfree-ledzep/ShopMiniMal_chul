package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;
import com.dto.MemberDTO;

public class GoodsDAO {

	public List<GoodsDTO> goodsList(SqlSession session, String gCategory) {
		// TODO Auto-generated method stub
		List<GoodsDTO> list= null;
		try {
			list= session.selectList("GoodsMapper.goodsList", gCategory);
			System.out.println("db접근성공");
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
			
		}
		return list;
	}

	public GoodsDTO goodsRetrive(SqlSession session, String gCode) {
		
		GoodsDTO dto= session.selectOne("GoodsMapper.goodsRetrive", gCode);
		return dto;
	}

	
	
}
