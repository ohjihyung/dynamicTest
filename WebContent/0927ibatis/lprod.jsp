<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    
<%
    SqlMapClient client = SqlMapClientFactory.getSqlClient();

	List<LprodVO> list = client.queryForList("lprod.lprodList");
  
%>

[
	<%
		for(int i = 0; i<list.size(); i++){	
			LprodVO vo = list.get(i);
			if(i>0) out.print(",");
	%>
		{
			"nm"  : "<%= vo.getLprod_nm() %>",
			"gu" : "<%= vo.getLprod_gu() %>",
			"id"  : "<%= vo.getLprod_id() %>"
		
		}
		
	<% } %>
	
]
