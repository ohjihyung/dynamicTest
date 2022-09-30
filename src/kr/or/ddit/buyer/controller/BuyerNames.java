package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;

/**
 * Servlet implementation class BuyerNames
 */
@WebServlet("/BuyerNames.do")
public class BuyerNames extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerNames() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0.클라이언트 요청시 전송 데이터 받기 
		
		// 1. service 객체 얻기 
		IBuyerService service = BuyerServiceImpl.getInstance();
		
		//2. service 메서드 getBuyerNames 호출 
		List<BuyerVO> list = service.getBuyerNames();
		
		//3. request객체에 결과값을 저장  ( view 가 알아보기 위해) 
		request.setAttribute("listvalue", list);
		
		//3. 결과값 출력  --> view 페이지로 이동   (request 객체에 저장하여 view로 보낸다, forward 방식으로)
		RequestDispatcher disp = request.getRequestDispatcher("0928/buyerNames.jsp"); // 어느 jsp로 보낼꺼냐..
		disp.forward(request, response); // 어떤 방식으로 보낼꺼냐.. 
		
		
	}

}
