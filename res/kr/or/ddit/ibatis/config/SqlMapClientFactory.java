package kr.or.ddit.ibatis.config;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	
	private static SqlMapClient smc;
	
	static {
		
		try {
			Charset charset = Charset.forName("utf-8");
			Resources.setCharset(charset);
			
			//1 -2 환경 설정 파일을 읽어올 스트림 객체 생성 
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/ibatis/config/sqlMapConfig.xml");
			
			//1 -3  생성된 스트림 객체를 이용하여 환경 설정 파일을 읽어와 환경 설정 내용을 처리한다.
			//  이 때 iBatis를 사용할 객체가 생성 ( 객체명 : sqlMapClient)
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			//1-4 스트림 닫기 
			rd.close();
			
		}catch(IOException e) { e.printStackTrace();}
	}
	
	public static SqlMapClient getSqlClient() {
		return smc;
	}
	
}
