package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;import com.config.MySqlSessionFactory;
import com.dto.CartDTO;

public class CartDAO {
	
	public int cartUpdate(SqlSession session, HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		int count= session.update("CartMapper.cartUpdate", map);
		return 0;
	}

	public int cartAdd(SqlSession session, CartDTO dto) {
		// TODO Auto-generated method stub
		int count= session.insert("CartMapper.cartAdd", dto);
		return 0;
	}

	public List<CartDTO> cartList(SqlSession session, String userid) {
		// TODO Auto-generated method stub
		List<CartDTO> list= session.selectList("CartMapper.cartList", userid);
		return list;
	}

	public int cartDel(SqlSession session, int num) {
		// TODO Auto-generated method stub
		int count= session.delete("CartMapper.cartDel", num);
		return count;
	}

	public int cartAllDel(SqlSession session, List<String> list) {
		// TODO Auto-generated method stub
		int count= session.delete("CartMapper.cartAllDel", list);
		return count;
	}

	public CartDTO cartByNum(SqlSession session, int num) {
		// TODO Auto-generated method stub
		CartDTO dto= session.selectOne("CartMapper.cartByNum", num);
		return dto;
	}



	

}
