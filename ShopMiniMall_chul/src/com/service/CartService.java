package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dto.CartDTO;
import com.dto.OrderDTO;

public class CartService {

	public int orderDone(OrderDTO dto, String orderNum) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			CartDAO dao = new CartDAO();
			n = dao.orderDone(session, dto);
			n= dao.cartDel(session, Integer.parseInt(orderNum));
			session.commit();
		}catch(Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return n;
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
		}catch(Exception e) {
			session.rollback();
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
		}catch(Exception e) {
			session.rollback();
		}
		finally {
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
		}catch(Exception e) {
			session.rollback();
		
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
		}catch(Exception e) {
			session.rollback();
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
		}catch(Exception e) {
			session.rollback();
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
		}catch(Exception e) {
			session.rollback();
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
		}catch(Exception e) {
			session.rollback();
		}finally {
			session.close();
			
		}
		return cartList;
	}


	

}
