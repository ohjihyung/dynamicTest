<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	List<ProdVO> list = (List<ProdVO>)request.getAttribute("selectProdNames");
    	JsonObject obj = new JsonObject();	
    
    	//list 값  null아닐때 
    	if(list != null && list.size() > 0){
	    	
    		obj.addProperty("sw", "OK");
    		
    		Gson gson = new Gson();
	    	JsonElement jele = gson.toJsonTree(list);
	    		    	
	    	obj.add("data",jele);
    		
    	 }else {
    		 obj.addProperty("sw", "NO");
    		 
    	} 
    
    		out.print(obj);
    %>