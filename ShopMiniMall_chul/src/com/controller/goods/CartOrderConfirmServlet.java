package com.controller.goods;

import java.io.IOException;

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
 * Servlet implementation class CartOrderConfirmServlet
 */
@WebServlet("/CartOrderConfirmServlet")
public class CartOrderConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartOrderConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		MemberDTO login= (MemberDTO)session.getAttribute("login");
		String nextPage="";
		if(login != null) {
			int num= Integer.parseInt(request.getParameter("num"));
			CartService cartService= new CartService();
			CartDTO cartdto= cartService.cartByNum(num);  //제품정보 cart에서 얻어오기
			System.out.println("CartOderConfirmServlet cartdto==="+ cartdto);
			String userid= cartdto.getUserid();
			MemberService memService= new MemberService();
			MemberDTO memdto= memService.mypage(userid);
			
			request.setAttribute("cDTO", cartdto);
			request.setAttribute("mDTO", memdto);
			nextPage="orderConfirm.jsp";
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
