package com.controller.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.CartService;

/**
 * Servlet implementation class CartDelServlet
 */
@WebServlet("/CartDelServlet")
public class CartDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		MemberDTO memDTO = (MemberDTO)session.getAttribute("login");
		String nextPage= null;
		if(memDTO != null) {
			String num= request.getParameter("num");
			CartService service= new CartService();
			int n= service.cartDel(Integer.parseInt(num));
			nextPage="CartListServlet";			
		}else {
			nextPage="LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요합니다.");
		}
		response.sendRedirect(nextPage);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
