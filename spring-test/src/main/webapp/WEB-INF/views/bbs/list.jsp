<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<style>
.loginout a{
text-align:left;
}
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
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
	 			<td><a href="<%=request.getContextPath()%>/bbs/detail?id=${board.id}">${board.title}</a></td>
	 			<td>${board.writer}</td>
	 		</tr>
	 	</c:forEach>
	 </table>
	 <a href="<%=request.getContextPath()%>/bbs/register">
	 	<button class="btn btn-outline-primary">등록</button>
	 </a>
 </div>
</body>
</html>