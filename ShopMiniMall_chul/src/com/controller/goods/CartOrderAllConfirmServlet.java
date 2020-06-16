package com.controller.goods;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.MemberService;

/**
 * Servlet implementation class CartOrderAllConfirmServlet
 */
@WebServlet("/CartOrderAllConfirmServlet")
public class CartOrderAllConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartOrderAllConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		MemberDTO memDTO= (MemberDTO)session.getAttribute("login");
		String nextPage= null;
		System.out.println("CartOrderAllConfirmServlet 실행됨====");
		if(memDTO!= null) {
			String num[]= request.getParameterValues("check");
			System.out.println("array======" + num);
			List<String> list= Arrays.asList(num);
			System.out.println("list======" + list);
			CartService cartservice= new CartService();
			List<CartDTO> cartlist= cartservice.orderAllConfirm(list);
			request.setAttribute("cartList", cartlist);
			
			MemberService memService= new MemberService();
			String userid= memDTO.getUserid();
			MemberDTO mDTO = memService.mypage(userid);
			request.setAttribute("memberDTO", mDTO);
			System.out.println("CartOrderAllConfirmServlet cartlist===="+ cartlist);
			nextPage="orderAllConfirm.jsp";		
		}else {
			session.setAttribute("mesg", "로그인이 필요합니다.");	
			nextPage="loginUI";
		}
		RequestDispatcher dis= request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
