<%@page import="kr.co.ansany.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
	        <li style="border-bottom: 3px solid #F05454"><a href="searchMemberFrm.do" style="color: #F05454; font-weight: bold;">회원 조회/수정</a></li>
	        <li><a href="productInsertFrm.do">상품등록</a></li>
	        <li><a href="prodList.do">상품 목록/수정</a></li>
	        <li><a href="orderList.do">주문내역 확인</a></li>
	      </ul>
	      <div class="content-wrap">
	      	<div class="tabcontent">
	      	<h2>회원 조회/수정</h2>
	      	
	            <table class="table findMembertbl">
	              <tr>
	                <th scop="col">조회분류</th>
	                <th scop="col"></th>
	                <th scop="col"></th>
	              </tr>
	              <tr>
	                <td>
	                  <select class="btn btn-outline-dark">
	                    <option selected>조회분류</option>
	                    <option value="memberNo">회원번호</option>
	                    <option value="memberId">회원아이디</option>
	                    <option value="memberName">회원이름</option>
	                  </select>
	                </td>
	                <td>
	                  <input type="text" class="form-control">
	                </td>
	                <td>
	                  <button type="button" class="btn btn-outline-dark searchBtn">검색</button>
	                </td>
	              </tr>
	            </table>
           
	      	</div>
	      	<div>
	      		<table class="table result">
	      			<tr>		             
		              <th scope="col">회원번호</th>
		              <th scope="col">회원아이디</th>
		              <th scope="col">이름</th>
		              <th scope="col">생년월일</th>
		              <th scope="col">전화번호</th>
		              <th scope="col">주소</th>
		              <th scope="col">이메일</th>
		              <th scope="col">가입일</th>
		              <th scope="col">회원등급</th>
		              <th scope="col">등급변경</th>
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