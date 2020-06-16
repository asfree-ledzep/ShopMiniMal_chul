<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" ></script>
<script>
/*
$(document).ready(function(){
	$("form").on("submit", function(event){
			if($("#username").val()==""){
					alert("이름을 입력하세요");
					$("#username").focus();
					return false;
			}else if($("#phone1").val()|| $("#phone2").val==null|| $("phone3").val()==null){
				alert("전화번호를 입력하세요");
				 event.preventDefault();
			}	
	});	
}); */
</script>
<% String mesg= (String)request.getAttribute("mesg"); 
 if (mesg != null){
%>
    <script> alert("<%= mesg %>")</script>
 <%}%>
    <form action="MemberIdSearchServlet" method="get">
  이름<input type="text" name="username" id="username"><br>
 휴대폰<select name="phone1" >
       <option value="011">011</option>
       <option value="010">010</option>
     </select>-
      <input type="text" name="phone2">-
      <input type="text" name="phone3"><br>
이메일<input type="text"  name="email1">@
     <input type="text"  name="email2" id="email2" placeholder="직접 입력">
   <input type="submit" value="메일 보내기">  
</form>
    