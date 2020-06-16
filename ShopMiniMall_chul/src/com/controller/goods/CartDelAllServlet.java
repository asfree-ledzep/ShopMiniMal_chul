package com.controller.goods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.CartService;

/**
 * Servlet implementation class CartDelAllServlet
 */
@WebServlet("/CartDelAllServlet")
public class CartDelAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDelAllServlet() {
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
		if(memDTO!= null) {
			String data = request.getParameter("data");
			System.out.println(data);
			String[] x= data.split(",");
			List<String> list = Arrays.asList(x);
			CartService service= new CartService();
			for(int i=0; i< list.size(); i++) {
				String num= list.get(i);
				service.cartDel(Integer.parseInt(num));
			}
//			int n= service.cartAllDel(list);
//			nextPage="CartListServlet";				
					
		}else {
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
