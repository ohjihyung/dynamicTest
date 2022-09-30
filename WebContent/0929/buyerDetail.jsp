<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	BuyerVO vo =   (BuyerVO)request.getAttribute("detailvalue");
%>

<table>
	<tr>
		<td>BUYER_ID</td>
		<td><%= vo.getBuyer_id() %></td>
	</tr>	
		
	<tr>
		<td>NAME</td>
		<td><%= vo.getBuyer_name() %></td>
	</tr>	
		
	<tr>
		<td>LGU</td>
		<td><%= vo.getBuyer_lgu() %></td>
	</tr>	
		
	<tr>
		<td>MAIL</td>
		<td><%= vo.getBuyer_mail() %></td>
	</tr>	
		
	<tr>
		<td>BANK</td>
		<td><%= vo.getBuyer_bank() %></td>
	</tr>	
		
	<tr>
		<td>BANKNAME</td>
		<td><%= vo.getBuyer_bankname() %></td>
	</tr>	
		



</table>

