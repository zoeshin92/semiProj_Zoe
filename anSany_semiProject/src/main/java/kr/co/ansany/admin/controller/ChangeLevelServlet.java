package kr.co.ansany.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ansany.member.model.service.MemberService;

/**
 * Servlet implementation class ChangeLevelServlet
 */
@WebServlet(name = "ChangeLevel", urlPatterns = { "/changeLevel.do" })
public class ChangeLevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeLevelServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int memberLevel = Integer.parseInt(request.getParameter("memberLevel"));
		MemberService service = new MemberService();
		int result = service.changeLevel(memberNo, memberLevel);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title","등급 변경 성공");
			request.setAttribute("msg","회원 등급 변경에 성공했습니다.");
			request.setAttribute("icon","success");
		}else {		
			request.setAttribute("title","등급변경 실패");
			request.setAttribute("msg","등급변경 중 문제가 발생했습니다");
			request.setAttribute("icon","warning");
		}
		request.setAttribute("loc","/adminPage.do");
		view.forward(request, response);			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
