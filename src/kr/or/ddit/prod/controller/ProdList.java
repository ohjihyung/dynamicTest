package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

@WebServlet("/ProdList.do")
public class ProdList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. 클라이언트 요청시 전송되는 값을 받는다 
		 String lgu = request.getParameter("gu");
		
		// 1. service 객체 얻기
		IProdService service = ProdServiceImpl.getinstance();
	
		// 2. service 메서드 호출 - 결과값받기
		List<ProdVO> list = service.selectProdNames(lgu);
		
		// 3. request에 결과값 저장 
		 request.setAttribute("selectProdNames",list);
			
		 /*
			 * response.setContentType("applocation/json;charset=utf-8"); PrintWriter out =
			 * response.getWriter(); Gson gson = new Gson(); String result =
			 * gson.toJson(vo);
			 * 
			 * out.print(result);
		 */
		 
		// 4. view 페이지 이동 
		
		 RequestDispatcher disp = request.getRequestDispatcher("0930/prodNames.jsp");
		 disp.forward(request, response);
		 
		 
	}

}
