<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
</head>
<body>
 <!--${user.id}    입력된 id가 세션에 저장됨. user.getid()의 의미임. 컨트롤러에서 model.addAttrubute 해주지 않아도됨 -->
 <table class="table table-bordered">
 	<tr>
 		<td>번호</td>
 		<td>제목</td>
 		<td>작성자</td>
 	</tr>
 	<c:forEach items="${list}" var="board">  <!-- list에서 하나씩 꺼내서 board에 저장해서 사용함 -->
 		<tr>
 			<td>${board.id}</td>
 			<td>${board.title}</td>
 			<td>${board.writer}</td>
 		</tr>
 	</c:forEach>
 </table>
</body>
</html>