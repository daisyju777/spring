<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/header.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/hottopics.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
		<title>HealthCare | Health and Fitness News, Recipes, Natural Remedies </title>
</head>
<body>
<%@ include file="../header.jsp" %>
 <div class="box">
	 <div class="left-box">
		<h1 class="newstitle">
			FITNESS VIDEOS
		</h1>
		<c:forEach var="list" items="${list}">
			<div class="newsbox">
				<div class="newsimg">
					<img src="<%=request.getContextPath()%>/resources/img${list.file}">
				</div>
				<div class="newscontent"> 
					<a href="<%=request.getContextPath()%>/fitness/detailvideos?id=${list.id}"><h2>${list.title}</h2></a>
					<div class="newscontentin">
						${list.content}
					</div>
					<a href="<%=request.getContextPath()%>/fitness/detailvideos?id=${list.id}"><button>Read more</button></a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="right-box">
		<img src="<%=request.getContextPath()%>/resources/img/ads.jpg">
	</div>
 </div>
</body>
</html>