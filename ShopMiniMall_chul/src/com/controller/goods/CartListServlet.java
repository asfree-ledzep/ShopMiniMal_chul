package com.controller.goods;

import java.io.IOException;
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

/**
 * Servlet implementation class CartListServlet
 */
@WebServlet("/CartListServlet")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO memDTO= (MemberDTO)session.getAttribute("login");
		String nextPage= null;
		
		if(memDTO != null) {
			String userid= memDTO.getUserid();
			CartService service= new CartService();
			List<CartDTO> list= service.cartList(userid);
			//System.out.println("CartListServlet list====="+userid+"/"+list);
			request.setAttribute("cartList",  list);
			nextPage="cartList.jsp";
		}else {
			String mesg="로그인이 필요합니다.";
			nextPage="LoginUIServlet";
			session.setAttribute("mesg", mesg);
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
