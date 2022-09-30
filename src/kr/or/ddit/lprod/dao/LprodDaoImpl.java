package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodDaoImpl implements ILprodDao {

	private SqlMapClient smc = null;
	private static ILprodDao dao = null;
	
	private LprodDaoImpl() {
		smc = SqlMapClientFactory.getSqlClient();
	}
	
	public static ILprodDao getinstance() {
		if (dao ==null) {
			dao = new LprodDaoImpl();
		}
		return dao;
	}
	
	
	@Override
	public List<LprodVO> lprodList() {
		
		List<LprodVO> list = null;
		
		try {
			list = smc.queryForList("lprod.lprodList");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list ;
	}

}
