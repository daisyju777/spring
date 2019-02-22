<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
  <style>
    #pagination {
      display : table;
/*       margin : 0 auto; */
    }
  </style>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<h2>전체 리스트</h2>
<c:forEach var="i" items="${list}">
	<p>아이디 : ${i.id} / 비밀번호 : ${i.pwd}</p>
</c:forEach>

<%--검색기 처리 시작 --%>
<form name="searchForm" method="get">
  <div class="search_text">
    <p>
      <!--사이즈가 1이므로 콤보상자 -->
      <select name="type" size="1" class="form-control" style="display:inline-block; width:105px">
      <!--0이면 아이디로 검색함-->
      	<option value="0" <c:if test="${pageMaker.criteria.type==0}">selected</c:if>>아이디</option>
      	<option value="1" <c:if test="${pageMaker.criteria.type==1}">selected</c:if>>비밀번호</option>
      	<option value="2" <c:if test="${pageMaker.criteria.type==2}">selected</c:if>>고유번호</option>
      </select>
      <!-- pageMaker.criteria.search 값이 자동으로 model에 들어감. 그러므로 따로 컨트롤러에서 매개변수를 지정하여 받지 않아도됨-->
      <input type="text" value="${pageMaker.criteria.search}" name="search" placeholder="Search" class="form-control" style="display:inline-block; width:400px"> 
      <input type="submit" value="검색 "  class="btn btn-success" style="padding:5px; margin:0">
    </p>
  </div>
</form>
<%--검색기 처리 끝 --%>

<%-- 페이징 처리 시작 --%>
<div id="pagination">
  <ul class="pagination">
    <%--이전 페이지가 없으면 disabled 로 하겠다 --%>
    <li class="page-item <c:if test="${!(pageMaker.prev)}">disabled</c:if>">
      <a class="page-link" href="<%=request.getContextPath() %>/list?page=${pageMaker.startPage-1}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}">Prev</a>
    </li>
    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="i">
      <li class="page-item <c:if test="${pageMaker.criteria.page == i}">active</c:if>">
        <a class="page-link" href="<%=request.getContextPath() %>/list?page=${i}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}"> ${i} </a>
      </li>
    </c:forEach>
    <li class="page-item <c:if test="${!(pageMaker.next)}">disabled</c:if>">
      <a class="page-link" href="<%=request.getContextPath() %>/list?page=${pageMaker.endPage+1}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}">Next</a>
    </li>
  </ul>
  
</div>
<%-- 페이징 처리 끝 --%>
<p><a href="<%=request.getContextPath() %>/">돌아가기</a></p>
</body>
</html>