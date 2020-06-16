package com.controller.goods;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.CartService;

/**
 * Servlet implementation class CartUpdateServlet
 */
@WebServlet("/CartUpdateServlet")
public class CartUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		MemberDTO dto= (MemberDTO)session.getAttribute("login");
		String nextPage= null;
		if(dto!= null) {
			String num= request.getParameter("num");
			String gAmount= request.getParameter("gAmount");
			//System.out.println("num"+ num+ "gAmout"+ gAmount);
			HashMap<String, Integer> map= new HashMap<>();
			map.put("num", Integer.parseInt(num));
			map.put("gAmount", Integer.parseInt(gAmount));
			
			CartService service= new CartService();
			int n= service.cartUpdate(map);
			//ajax을 사용하여 nextPage없음		
		}else {
			nextPage="LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요합니다.");
			response.sendRedirect(nextPage);
		}
		//주의
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
