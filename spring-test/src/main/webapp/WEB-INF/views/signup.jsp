<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>회원가입</title>
	<script src="//code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post" action="<%=request.getContextPath()%>/signup">
		<div>
			<input type="text" name="id" id="id">
			<button id="dup" type="button">중복체크</button>
		</div>
		<div>
			<input type="password" name="pw">
		</div>
		<div>
			<input type="email" name="email">
		</div>
		<div>
			<input type="radio" value="male" name="gender" id="male" checked>
			<label for="male">남성</label>
			<input type="radio" value="male" name="gender" id="female" checked>
			<label for="female">여성</label>
		</div>
		<button>회원가입</button>
	</form>
	<script>
	var dup;
    $('#dup').click( function() {
        var id = "";
        id = $('#id').val();
        $.ajax({
        	async:true,
        	type:'POST',
        	data:id,
            url: '/springtest/signup/dup',
            dataType:'json',
            contentType:'application/json; charset=UTF-8',
            success: function(data) {
				console.log(data.dup);
				if(data.dup){
					alert('이미 사용중인 아이디입니다.');
				} else {
					alert('사용 가능한 아이디입니다.');
				}
            }
        });
    })
	</script>
</body>
</html>
