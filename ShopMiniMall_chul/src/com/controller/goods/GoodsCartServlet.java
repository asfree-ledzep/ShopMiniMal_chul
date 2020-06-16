package com.controller.goods;

import java.io.IOException;
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
 * Servlet implementation class GoodsCartServlet
 */
@WebServlet("/GoodsCartServlet")
public class GoodsCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		MemberDTO memDTO= (MemberDTO)session.getAttribute("login");
		String nextPage= null;
	if(memDTO != null){
		
		String userid= memDTO.getUserid(); //사용자 아이디 획득
		String gImage= request.getParameter("gImage");
		String gCode= request.getParameter("gCode");
		String gName= request.getParameter("gName");
		String gPrice= request.getParameter("gPrice");
		String gSize= request.getParameter("gSize");
		String gColor= request.getParameter("gColor");
		String gAmount= request.getParameter("gAmount");
		
		CartDTO dto= new CartDTO();
		
		dto.setgAmount(Integer.parseInt(gAmount));
		dto.setgCode(gCode);
		dto.setgColor(gColor);
		dto.setgImage(gImage);
		dto.setgName(gName);
		dto.setgPrice(Integer.parseInt(gPrice));
		dto.setgSize(gSize);
		dto.setUserid(userid); //사용자 아이디 저장
		System.out.println("GoodsCartServlet Longin 정보 획득 dto class= "+ dto);
		
		CartService service= new CartService();
		int n= service.cartAdd(dto);
		nextPage="GoodsRetrieveServlet?gCode="+gCode;
		session.setAttribute("mesg", gCode+" Cart저장성공");
	}else {
		session.setAttribute("mesg", "로그인이 필요합니다");
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
