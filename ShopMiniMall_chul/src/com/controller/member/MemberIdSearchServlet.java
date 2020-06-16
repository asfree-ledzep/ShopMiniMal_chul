package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class MemberIdSearchServlet
 */
@WebServlet("/MemberIdSearchServlet")
public class MemberIdSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberIdSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username= request.getParameter("username");
		String phone1= request.getParameter("phone1");
		String phone2= request.getParameter("phone2");
		String phone3= request.getParameter("phone3");
		String email1= request.getParameter("email1");
		String email2= request.getParameter("email2");
		
		MemberDTO dto= new MemberDTO();
		dto.setUsername(username);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		MemberService service = new MemberService();
		String  userid = service.idSearch(dto);
		String nextPage= null;
		String mesg=null;
		if(userid==null) {
			System.out.println("serlvet userid는 "+ userid);
			nextPage="MemberSerarchUIServlet";
			mesg="이름 또는 핸드폰이 등록되어 있지 않습니다";
			request.setAttribute("mesg", mesg);
		}else {
			nextPage="SendMailSerlvelt";
			request.setAttribute("mailTo", email1+"@"+email2);
			request.setAttribute("userid", userid);
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
