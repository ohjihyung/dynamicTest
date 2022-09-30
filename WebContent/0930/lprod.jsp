<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
  <%
  		List<LprodVO>  list = (List<LprodVO>)request.getAttribute("lprodList");
		response.setContentType("application/json;charset=utf-8");
		
		Gson gson = new Gson();
		String result = gson.toJson(list);
		
		out.print(result);
  %>
  
