<%@page import="kr.co.ansany.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역확인</title>
   <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
   <link rel="stylesheet" href="/css/header.css">
   <link rel="stylesheet" href="/css/footer.css">
   <link rel="stylesheet" href="/css/admin1.css">
   <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<style>
	.page-content{
		padding-top: 81px;
		background-color: #fff;
		height: 100%;
	}
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
	    <div class="admin-wrap">
	      <ul class="tabs">
	      	<li><a href="adminPage.do">전체회원 목록</a></li>
	        <li><a href="searchMemberFrm.do">회원 조회/수정</a></li>
	        <li><a href="productInsertFrm.do">상품등록</a></li>
	        <li><a href="prodList.do">상품 목록/수정</a></li>
	        <li style="border-bottom: 3px solid #F05454"><a href="orderList.do" style="color: #F05454; font-weight: bold;">주문내역 확인</a></li>
	      </ul>
	      <div class="content-wrap">
	      	<div class="tabcontent">
	      		<h2>주문 확인/수정</h2>
	      		<table class="table">
	      			<tr>
	      				<th scope="col">주문번호</th>
	      				<th scope="col">회원아이디</th>
	      				<th scope="col">제품번호</th>
	      				<th scope="col">총금액</th>
	      				<th scope="col">주문자이름</th>
	      				<th scope="col">배송주소</th>
	      				<th scope="col">주문자번호</th>
	      				<th scope="col">주문날짜</th>
	      				<th scope="col">배송상태</th>
	      			</tr>
	      		</table>
	      	</div>
	      </div>
	     </div>
    </div>
	
	
        <script src="/js/admin1.js"></script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>