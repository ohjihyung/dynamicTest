package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;

public interface IBuyerService {
	
	//buyer 이름들 가져오기 
	public List<BuyerVO> getBuyerNames();
	
	//buyer_id를 기준으로 상세보기 가져오기
	public BuyerVO getDetail(String buyerId);
}
