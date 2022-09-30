package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService{
	
	private static IProdService service = null;
	private IProdDao dao = null;
	
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
		
	}
	
	public static IProdService getinstance() {
		if(service ==null) service = new ProdServiceImpl();
		return service;
	}
	
	@Override
	public List<ProdVO> selectProdNames(String lprod_gu) {
		// TODO Auto-generated method stub
		return dao.selectProdNames(lprod_gu);
	}

	@Override
	public ProdVO prodIdByDetail(String prod_id) {
		// TODO Auto-generated method stub
		return dao.prodIdByDetail(prod_id);
	}

}
