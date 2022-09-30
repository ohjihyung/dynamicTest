package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;


/*
 	SqlMapClient 가 필요 
 	
 	자신의 객체를 생성해서 리턴하는 메서드
*/

public class BuyerDaoImpl implements IBuyerDao{
	
	private static IBuyerDao dao = null;
	private SqlMapClient smc = null;
	
	private BuyerDaoImpl(){
		smc = SqlMapClientFactory.getSqlClient();
	}
	
	public static IBuyerDao getInstance() {
		if(dao == null) dao = new BuyerDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<BuyerVO> getBuyerNames() {
		
		List<BuyerVO> list = null;
		try {
			list = smc.queryForList("buyer.buyerNames");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public BuyerVO getDetail(String buyerId) {
		BuyerVO buyerVo = null;
		
		try {
			buyerVo = (BuyerVO) smc.queryForObject("buyer.buyerDetail", buyerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return buyerVo;
	}

}
