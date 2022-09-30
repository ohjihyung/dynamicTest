package kr.or.ddit.buyer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;


@WebServlet("/BuyerDetail.do")
public class BuyerDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. 클라이언트 요청시 전송되는 값을  받는다 = buyer_id 값 
		String buyId = request.getParameter("id");  // 여기이름은 ajax에서 옴  data : 
		
		// 1. service 객체를 얻는다 .
		IBuyerService service = BuyerServiceImpl.getInstance();
		
		//2. service 매소드 호출  - 결과값 받기 
		
		BuyerVO vo = service.getDetail(buyId);
		
		//3. request객체에 결과값을 저장 
		
		request.setAttribute("detailvalue", vo);

		//4. 결과값 출력 
		//json 데이터를 생성하여 클라이언트로 응답하기 위함 
		RequestDispatcher disp = request.getRequestDispatcher("0928/buyerDetail.jsp");
		
		//html데이터를 생성 클라이언트 응답 
		//RequestDispatcher disp = request.getRequestDispatcher("0929/buyerDetail.jsp");
		
		disp.forward(request,response);
		
		
	}

}
