<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"> --%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<style>
.loginout a{
text-align:left;
}
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

#pagination {
   display : table;
   margin : 0 auto; 
 }
</style>
</head>
<body>
<div class="loginout">
	 <c:if test="${user != null}">
	 	<a href="<%=request.getContextPath()%>/signout" >로그아웃</a>
	 </c:if>
	 <c:if test="${user == null}">
	 	<a href="<%=request.getContextPath()%>/" >로그인</a>
	 </c:if>
</div>
<%--
 <c:choose>
 	<c:when test="${user != null}">
 		<a href="<%=request.getContextPath()%>/signout">로그아웃</a>
 	</c:when>
 	<c:otherwise>
 		<a href="<%=request.getContextPath()%>/">로그인</a>
 	</c:otherwise>
 </c:choose>
 choose, otherwise문을 이용해도 결과는 같음
 조건을 더 추가하고싶으면 처음 when밑에 when문을 이어서 또 써주면됨(else if구문과 비슷함)
  --%>
  
 <!--${user.id}    입력된 id가 세션에 저장됨. user.getid()의 의미임. 컨트롤러에서 model.addAttrubute 해주지 않아도됨 -->
 <div class="container">
     <h1>게시판</h1>
     <hr>
	 <table class="table table-striped">
	 	<tr>
	 		<th>번호</th>
	 		<th>제목</th>
	 		<th>작성자</th>
	 	</tr>
	 	<c:forEach items="${list}" var="board">  <!-- list에서 하나씩 꺼내서 board에 저장해서 사용함 -->
	 		<tr>
	 			<td>${board.id}</td>
	 			<td><a href="<%=request.getContextPath()%>/bbs/detail?id=${board.id}&page=${pageMaker.criteria.page}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}">${board.title}</a></td>
	 			<td>${board.writer}</td>
	 		</tr>
	 	</c:forEach>
	 </table>
	 
	 <%--검색기 처리 시작 --%>
	<form name="searchForm" method="get">
	  <div class="search_text">
	    <p>
	      <!--사이즈가 1이므로 콤보상자 -->
	      <select name="type" size="1" class="form-control" style="display:inline-block; width:105px">
	      <!--0이면 아이디로 검색함-->
	      	<option value="0" <c:if test="${pageMaker.criteria.type==0}">selected</c:if>>제목</option>
	      	<option value="1" <c:if test="${pageMaker.criteria.type==1}">selected</c:if>>내용</option>
	        <option value="2" <c:if test="${pageMaker.criteria.type==2}">selected</c:if>>글쓴이</option>
	        <option value="3" <c:if test="${pageMaker.criteria.type==3}">selected</c:if>>글번호</option>
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
	      <a class="page-link" href="<%=request.getContextPath() %>/bbs/list?page=${pageMaker.startPage-1}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}">Prev</a>
	    </li>
	    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="i">
	      <li class="page-item <c:if test="${pageMaker.criteria.page == i}">active</c:if>">
	        <a class="page-link" href="<%=request.getContextPath() %>/bbs/list?page=${i}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}"> ${i} </a>
	      </li>
	    </c:forEach>
	    <li class="page-item <c:if test="${!(pageMaker.next)}">disabled</c:if>">
	      <a class="page-link" href="<%=request.getContextPath() %>/bbs/list?page=${pageMaker.endPage+1}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}">Next</a>
	    </li>
	  </ul>  
	</div>
	<%-- 페이징 처리 끝 --%>

	 <a href="<%=request.getContextPath()%>/bbs/register">
	 	<button class="btn btn-outline-primary">등록</button>
	 </a>
 </div>
</body>
</html>