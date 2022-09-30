package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdDaoImpl implements IProdDao {
	
	private static IProdDao dao = null;
	private SqlMapClient smc = null;
	
	private ProdDaoImpl() {
		smc = SqlMapClientFactory.getSqlClient();
	}
	
	public static IProdDao getInstance() {
		
		if(dao == null) {
			dao = new ProdDaoImpl();
		}
		
		return dao;
	}
	
	
	

	@Override
	public List<ProdVO> selectProdNames(String lprod_gu) {
		
		List<ProdVO> list = null;
		try {
			 list = smc.queryForList("prod.selectProdNames", lprod_gu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ProdVO prodIdByDetail(String prod_id) {
			ProdVO vo = null;
			
			try {
				vo = (ProdVO)smc.queryForObject("prod.prodIdByDetail", prod_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return vo;
	}

}
