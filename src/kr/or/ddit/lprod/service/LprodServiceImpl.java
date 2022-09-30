package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodServiceImpl implements IlprodService{
 
	private static IlprodService service = null;
	private ILprodDao dao = null;
	
	private LprodServiceImpl() {
		dao = LprodDaoImpl.getinstance();
	}
	
	public static IlprodService getinstance() {
		if(service == null) {
			service = new LprodServiceImpl();
		}
		return service;
	}
	

	
	@Override
	public List<LprodVO> lprodList() {
		// TODO Auto-generated method stub
		return dao.lprodList();
	}

}
