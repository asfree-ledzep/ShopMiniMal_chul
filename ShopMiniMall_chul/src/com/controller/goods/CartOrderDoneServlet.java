package com.controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.OrderDTO;
import com.service.CartService;

/**
 * Servlet implementation class CartOrderDoneServlete
 */
@WebServlet("/CartOrderDoneServlet")
public class CartOrderDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartOrderDoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		HttpSession session= request.getSession();
		MemberDTO memdto= (MemberDTO)session.getAttribute("login");
		String nextPage="";
		if(memdto != null) {
			String userid= memdto.getUserid();
			String gCode= request.getParameter("gCode");
			String gName= request.getParameter("gName");
			int  gPrice= Integer.parseInt(request.getParameter("gPrice"));
			String gSize= request.getParameter("gSize");
			String gColor= request.getParameter("gColor");
			int gAmount= Integer.parseInt(request.getParameter("gAmount"));
			String gImage= request.getParameter("gImage");
			String orderName= request.getParameter("orderName");
			String post= request.getParameter("post");
			String addr1= request.getParameter("addr1");
			String addr2= request.getParameter("addr2");
			String phone= request.getParameter("phone");
			String payMethod= request.getParameter("payMethod");
			//String orderNum= request.getParameter("orderNum");
			
			//OrderDTO생성
			OrderDTO orderdto= new OrderDTO(0, userid, gCode, gName, gPrice, gSize, gColor,
					gAmount, gImage, orderName, post, addr1, addr2, phone, payMethod, null);
			//num은 0으로 orderday는 null로 설정
			//System.out.println("CartOrderDoneServlet  orderdto========"+orderdto);
			CartService service= new CartService();
			int result= service.orderDone(orderdto);
			request.setAttribute("orderDTO", orderdto);
			nextPage="orderDone.jsp";
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
