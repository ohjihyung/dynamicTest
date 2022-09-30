package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.vo.BuyerVO;

public class BuyerServiceImpl implements IBuyerService{

	private static IBuyerService service = null;
	private IBuyerDao dao = null;
	
	private BuyerServiceImpl() {
		 dao = BuyerDaoImpl.getInstance();
	};
	
	public static IBuyerService getInstance() {
		if(service == null) {
			service = new BuyerServiceImpl();
		}
		return service;
	}

	@Override
	public List<BuyerVO> getBuyerNames() {
		
		return dao.getBuyerNames();
	}

	@Override
	public BuyerVO getDetail(String buyerId) {
		
		return dao.getDetail(buyerId);
	}

}
