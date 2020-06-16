<%@ page import="com.dto.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
<%
	MemberDTO memDTO=(MemberDTO)session.getAttribute("login");
	String userid= memDTO.getUserid();
%>
<h3><%= userid %>님의 장바구니페이지입니다.</h3>
<jsp:include page="common/top.jsp"></jsp:include><br>
<jsp:include page="common/menu.jsp"></jsp:include>
<hr>
<jsp:include page="goods/cartList.jsp"></jsp:include>
</body>
</html>