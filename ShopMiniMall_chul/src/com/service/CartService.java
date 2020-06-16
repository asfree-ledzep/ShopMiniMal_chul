package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dto.CartDTO;
import com.dto.OrderDTO;

public class CartService {

	public int orderDone(OrderDTO orderdto) {
		// TODO Auto-generated method stub
		SqlSession session= null;
		int result=0;
		try {
			session= MySqlSessionFactory.getSession();
			CartDAO dao= new CartDAO();
			 result=dao.orderDone(session, orderdto);
			session.commit();
		}finally {
			session.close();
		}
		return result;
	}

	public int cartAdd(CartDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session= null;
		int count=0;
		try {
				session= MySqlSessionFactory.getSession();
				CartDAO dao= new CartDAO();
				count= dao.cartAdd(session, dto);	
				session.commit();
		}finally {
			session.close();			
		}
		return count;
	}

	public List<CartDTO> cartList(String userid) {
		// TODO Auto-generated method stub
		SqlSession session= null;
		List<CartDTO> list= null;
		try {
			session= MySqlSessionFactory.getSession();
			CartDAO dao= new CartDAO();
			list= dao.cartList(session, userid);
		}finally {
			session.close();
		}
		
		return list;
	}

	public int cartDel(int num) {
		// TODO Auto-generated method stub
		SqlSession session= null;
		int count= 0;
		try {
			session= MySqlSessionFactory.getSession();
			CartDAO dao= new CartDAO();
			count= dao.cartDel(session, num);
			session.commit();
		}finally {
			session.close();			
		}
		return count;
	}

	public int cartUpdate(HashMap<String, Integer> map) {
		SqlSession session= null;
		int count= 0;
		try {
			session= MySqlSessionFactory.getSession();
			CartDAO dao= new CartDAO();
			count= dao.cartUpdate(session, map);
			session.commit();
		}finally {
			session.close();
		}
		return count;
	}

	public int cartAllDel(List<String> list) {
		// TODO Auto-generated method stub
		SqlSession session= null;
		int count=0;
		try {
			session= MySqlSessionFactory.getSession();
			CartDAO dao= new CartDAO();
			count= dao.cartAllDel(session, list);
			session.commit();
		}finally {
			session.close();			
		}
		return count;
	}

	public CartDTO cartByNum(int num) {
		// TODO Auto-generated method stub
		SqlSession session=null;
		CartDTO dto=null;
		try {
			session= MySqlSessionFactory.getSession();
			CartDAO dao= new CartDAO();
			 dto= dao.cartByNum(session, num);			
		}finally {
			session.close();
		}
		
		
		return dto;
	}

	public List<CartDTO> orderAllConfirm(List<String> list) {
		SqlSession session= null;
		List<CartDTO> cartList= null;
		try {
			session= MySqlSessionFactory.getSession();
			CartDAO dao= new CartDAO();
			cartList= dao.orderAllConfirm(session, list);		
		}finally {
			session.close();
			
		}
		return cartList;
	}


	

}
