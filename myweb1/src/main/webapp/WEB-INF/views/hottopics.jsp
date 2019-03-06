<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
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
<%@ include file="header.jsp" %>
 <div class="box">
	 <div class="left-box">
		<h1 class="newstitle">
			NEWS
		</h1>
		<div class="newsbox">
			<div class="newsimg">
			</div>
			<div class="newscontent"> 
				<h2>Top 7 Food Safety Tips for Your Next Dinner Party</h2>
				Creating dinners for your family and friends can be one of life's greatest pleasures. But pleasure can turn to pain if any of your guests get a nasty case of food poisoning from your cooking! ...
				<button>Read more</button>
			</div>
		</div>
	</div>
	<div class="right-box">
		<img src="<%=request.getContextPath()%>/resources/img/ads.jpg">
	</div>
 </div>
</body>
</html>