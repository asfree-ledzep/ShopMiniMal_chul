package com.controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String userid= request.getParameter("userid");
		 String passwd= request.getParameter("passwd");
		 HashMap<String, String> map= new HashMap<>();
		 map.put("userid", userid);
		 map.put("passwd", passwd);
		 
		 MemberService service= new MemberService();
		 MemberDTO dto= service.login(map);
		 String nextPage= null;
		 if(dto != null) {
			 nextPage= "main";
			// System.out.println("LoginSevlet db data==="+ dto);
			 HttpSession session = request.getSession();
			 session.setAttribute("login", dto);
			 System.out.println("LoginSevlet db data==="+ dto);
		 }else {
			 nextPage="LoginUIServlet";
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
