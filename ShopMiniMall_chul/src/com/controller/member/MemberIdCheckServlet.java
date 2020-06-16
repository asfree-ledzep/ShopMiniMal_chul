package com.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MemberService;

/**
 * Servlet implementation class MemberIdCheckServlet
 */
@WebServlet("/MemberIdCheckServlet")
public class MemberIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberIdCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid= request.getParameter("userid");
		MemberService service= new MemberService();
		int count=service.idCheck(userid);
		String mesg= "아이디 사용가능합니다.";
		System.out.println("servlet count="+ count);
		if(count==1) {
			mesg=" 아이디가 중복 됩니다 ";
		}
		System.out.println("servlet mesg==="+mesg );
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out= response.getWriter();
		out.print(mesg);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
