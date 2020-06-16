<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(event){
		$("form").on("submit", function(){
		var userid= $("#userid").val();
		var passwd= $("#passwd").val();
		if(userid.length==0){
			alert("사용자 아이디 입력 필수");
			$("#userid").focus();
			event.preventDefault();	
		}else if(passwd.length==0){
			alert("비밀번호 입력 필수");
			$("#passwd").focus();
			event.preventDefault();
		}
		});
	});





</script>
  <form action="LoginServlet" method="get">
	아이디:<input type="text" name="userid" id="userid">
	비밀번호: <input type="text" name="passwd" id="passwd">
	<input type="submit" value="로그인">
	<input type="reset" value="취소">
	<a href="MemberSerarchUIServlet">아이디찾기</a>
	
</form>
    