<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/header.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/signup.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>HealthCare | Health and Fitness News, Recipes, Natural Remedies </title>
</head>
<body>
<%@ include file="header.jsp" %>
<br><br>
	<form method="post" action="<%=request.getContextPath()%>/signup" id="form" class="mysignupform">
		<div id="mysignupcontainer">
			<h1>회원가입</h1>
			<p>회원 정보를 입력해주세요.</p>
	    	<hr>
			
			<label for="id">ID</label>
			<input type="text" placeholder="아이디를 입력해주세요" name="id" id="id" class="form-control" required>
			<button id="dup" type="button" class="btn btn-primary btn-sm">중복체크</button>
			
			<label for="pw">Password</label>
			<input type="password" placeholder="비밀번호를 입력해주세요" name="pw" id="pw" class="form-control" required>
			
			<label for="email">Email</label>
			<input type="email" placeholder="이메일을 입력해주세요" name="email" id="email" class="form-control" required>
			
			<label>성별</label>
			<input type="radio" value="male" name="gender" id="male" checked>
			<label for="male">남성</label>
			<input type="radio" value="male" name="gender" id="female" checked>
			<label for="female">여성</label>
	
			<button type="button" id="btnOk" class="btn btn-outline-secondary clearfix">회원가입</button>
		</div>
	</form>
	<script>
	var dup = 0; 
    $('#dup').click( function() {
        var id = "";
        id = $('#id').val();
        $.ajax({ //json형태로 데이터가들어감. $.ajax({})안에 객체가 값으로 들어옴
        	async:true,      //동기화 여부 결정
        	type:'POST',
        	data:id,  //보낼 데이터를 적어줌. 여기서는 id만 보내줌. 여러개를 보내고 싶으면 배열이나 오브젝트로 보냄
            url: '/myweb/signup/dup',
            dataType:'json', /*json을 사용하기 위해서 pom.xml에 의존성 추가*/
            contentType:'application/json; charset=UTF-8', 
            success: function(data) {
				//console.log(data.dup);
				if(data.dup){
					dup = 1;
					alert('이미 사용중인 아이디입니다.');
				} else {
					dup = -1;
					alert('사용 가능한 아이디입니다.');
				}
            }, 
            error:function(jqXHR,testStatus,errorThorwn){
             //성공은 aucces 실패는 eer로 처리함
            }
        });
    })
    $("#btnOk").click(function(){
    	if(dup == 0){
    		alert("아이디 중복 체크를 하세요");
    		return false;
    	}
    	if(dup == 1){
    		alert("중복된 아이디입니다. 다른 아이디를 입력하세요.");
    		return false;
    	}
    	$('#form').submit();
    	return true;
    })
    
	</script>
</body>
</html>
