package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //주소 한글 깨짐 해결
		HttpSession session= request.getSession();
		MemberDTO dto= (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		if(dto!= null) {
			String userid= request.getParameter("userid");
			String passwd= request.getParameter("passwd");
			String username= request.getParameter("username");
			String post= request.getParameter("post");
			String addr1= request.getParameter("addr1");
			String addr2= request.getParameter("addr2");
			String phone1= request.getParameter("phone1");
			String phone2= request.getParameter("phone2");
			String phone3= request.getParameter("phone3");
			String email1= request.getParameter("email1");
			String email2= request.getParameter("email2");
			
			System.out.println("memberUpdateServlet 파싱데이터 userid"+ userid);
			MemberDTO dto2= new MemberDTO(userid, passwd, username, post, addr1, addr2,phone1, phone2, phone3, email1, email2 );
			System.out.println("memberUpdateServlet 파싱데이터"+ dto2);
			MemberService service= new MemberService();
			int num= service.memberUpdate(dto2);
			
			nextPage="MyPageServlet";
		}else {
			nextPage="LoginServlet";
			request.setAttribute("mesg", "로그인이 필요합니다.");
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
