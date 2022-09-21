<%@page import="kr.co.ansany.product.model.vo.Product"%>
<%@page import="kr.co.ansany.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% ArrayList<Product> list =(ArrayList<Product>)request.getAttribute("list");  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
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
	        <li style="border-bottom: 3px solid #F05454"><a href="prodList.do" style="color: #F05454; font-weight: bold;">상품 목록/수정</a></li>
	        <li><a href="orderList.do">주문내역 확인</a></li>
	      </ul>
	      <div class="content-wrap">
	      	<div class="tabcontent" id="productList">
	      		<h2>상품 목록</h2>
	      		<table class="table">
		      		<tr>
		              <th scope="col">상품번호</th>
		              <th scope="col">카테고리코드</th>
		              <th scope="col">상품명</th>
		              <th scope="col">상품가격</th>
		              <th scope="col">재고</th>
		              <th scope="col">이미지</th>             
		              <th scope="col">수정</th>
		              <th scope="col">삭제</th>
		            </tr>
		            <%for(Product p : list){ %>
		            <tr>
		            	<td><%=p.getProductNo() %></td>
		            	<%if (p.getCateCode()==5001){ %>
		            	<td>헤드폰/이어폰</td>
		            	<%} %>
		            	<%if (p.getCateCode()==6001){ %>
		            	<td>스피커</td>
		            	<%} %>
		            	<%if (p.getCateCode()==7001){ %>
		            	<td>턴테이블</td>
		            	<%} %>
		            	<%if (p.getCateCode()==8001){ %>
		            	<td>워크맨</td>
		            	<%} %>
		            	<td><%=p.getProductName() %></td>
		            	<td><%=p.getProductPrice() %></td>
		            	<td><%=p.getProductQty() %></td>
		            	<td><img src="/upload/prodImg/<%=p.getProductImg()%>" style="width:100px; height: 100px;"> </td>		            	
		            	<td>
		            		<button type="button" class="btn btn-outline-dark modification">수정하기</button>
		            	</td>
		            	<td>
		            		<button type="button" class="btn btn-outline-danger deleteProd">삭제</button>
		            	</td>
		            </tr>
		            <%} %>
	      		</table>
	      	</div>
	      </div>
	     </div>
    </div>
	
	
        <script src="/js/admin1.js"></script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>