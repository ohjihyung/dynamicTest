package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.IlprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.LprodVO;

/**
 * Servlet implementation class LprodList
 */
@WebServlet("/LprodList.do")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//0. 클라이언트 요청시 전송되는 값을 받는다 = lprod_id
		
		//1. service객체를 얻는다.
		 IlprodService service = LprodServiceImpl.getinstance();
		
		//2. service 메서드 호출 - 결과값 받기
		List<LprodVO> list = service.lprodList(); 
		
		//3. request 객체에 결과값 저장 
		request.setAttribute("lprodList", list);
		
		//4. view 페이지로 이동   0930/Lprod_prod.jsp
		RequestDispatcher disp = request.getRequestDispatcher("0930/lprod.jsp");
		disp.forward(request, response);
	}


}
