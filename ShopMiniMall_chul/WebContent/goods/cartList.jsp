<%@ page import="java.util.List" %>
<%@ page import="com.dto.CartDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	//전체삭제기능 
	$("#delAllCart").on("click", function(){
		
		var num= [];
		$("input:checkbox[name='check']:checked").each(function(idx, data){
			num[idx]= $(this).val();			
		});
		console.log(num);
		location.href="CartDelAllServlet?data="+num;
		//console.log("CartDelAllServlet?data="+num);
	});
	 //전체선택
	 $("#allCheck").on("click", function(){
		var result= this.checked; //주의 
		 console.log("this.checked",  this.checked);
		 console.log("$(this).checked",  $(this).checked);
		 $(".check").each(function(idx, data){
				 console.log(idx," :" ,   data);
				this.checked=  result; //주의 
			 });		 
	 });
	 	
	//수정버튼 -ajax사용
	$(".updateBtn").on("click", function(){
		var num= $(this).attr('data-xxx'); //주의
		var gAmount=$("#cartAmount"+num).val(); //주의 각 항목마다 만들어진 id를 사용 수량획득	
		var gPrice= $(this).attr('data-price'); //주의
		console.log("ajax gAmount= "+ gAmount+ " num= "+num+ "  gPrice= " + gPrice);
		$.ajax({
			url: "CartUpdateServlet",
			type: "get",
			datatype: "text",
			data: {
				num: num,
				gAmount: gAmount				
			},
			success: function(data, status, xhr){
				var sum= gAmount* gPrice;
				$("#sum"+num).text(sum); //주의 각 항목마다 만들어진 id sum+ num을 이용하여 가격출력
			},
			error: function(xhr, status, error){
			}		
		});		
	});
	
	
	//삭제버튼 
	$(".delBtn").on("click", function(){
		var num= $(".delBtn").attr("data-xxx");
		alert(num+"을 삭제합니다.");
		location.href="CartDelServlet?num="+num;
	});
	
	$(".ordreBtn").on("click", function(){
		var num= $(this).attr('data-xxx');
		location.href="CartOrderConfirmServlet?num="+num;
	});
	
});




</script>
    
 <%
 
 
 %>   
    <table width="90%" cellspacing="0" cellpadding="0" border="0">
	<tr>
		<td height="30">
	</tr>
	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>- 장바구니-</b></font> &nbsp;
		</td>
	</tr>
	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center" width="20px">
		<input type="checkbox" name="allCheck" id="allCheck"> <strong>전체선택</strong></td>
		<td class="td_default" align="center"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>
	
	
	
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>



	<form name="myForm">
	<%
		List<CartDTO> list= (List<CartDTO>)request.getAttribute("cartList");
	for(int i=1; i<= list.size(); i++){
		CartDTO dto= list.get(i-1);	
	 int num= dto.getNum();
	 String userid=dto.getUserid();
	 String gCode= dto.getgCode();
	 String gName= dto.getgName();
	 int gPrice= dto.getgPrice();
	 String gSize= dto.getgSize();
	 String gColor= dto.getgColor();
	 int gAmount = dto.getgAmount();
	 String gImage =  dto.getgImage();	
	%>
	<!-- 	 <input type="text" name="<%=num %>" value="<%=num %>" id="<%=num %>">
		<input type="text" name="<%= gImage%>" value="<%= gImage%>" id="<%= gImage%>">
		 <input type="text" name="<%=gName %>" value="<%=gName %>" id="<%=gName %>">
		  <input type="text" name="<%= gSize%>" value="<%= gSize%>" id="<%= gSize%>">
		   <inputsp type="text" name="<%=gColor %>" value="<%=gColor %>" id="<%=gColor %>"> 
		   <input type="text" name="<%= gPrice%>" value="<%= gPrice%>" id="<%= gPrice%>">  
-->
		<tr>
			<td class="td_default" width="80">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. -->
			<!-- checkbox의 id 변경 -->
			<input type="checkbox"
				name="check" id="check<%=num %>" class="check" value="<%=num %>"></td>
			<td class="td_default" width="80"><%=num %></td><!-- 번호 -->
			<td class="td_default" width="80"><img
				src="images/items/<%= gImage%>.gif" border="0" align="center"
				width="80" /></td> <!--  그림 경로 -->
			<td class="td_default" width="300" style='padding-left: 30px'>
			<%=gName %><!--  상품이름 -->
				<br> <font size="2" color="#665b5f">[옵션 : 사이즈(<%= gSize%>)
					, 색상(<%=gColor %>)] <!--  사이즈와 색상 -->
			</font></td>
			<td class="td_default" align="center" width="110">
			<%= gPrice%>
			</td>
			<td class="td_default" align="center" width="90"><input
				class="input_default" type="text" name="cartAmount"
				id="cartAmount<%= num %>" style="text-align: right" maxlength="3"
				size="2" value="<%=gAmount %>"></input></td>
<!-- 상단 수정을   위해   id생성 cartAmout+ num -->
<!--  수정 버튼 수정 ========================================== -->
			<td><input type="button" value="수정" class="updateBtn"
				data-xxx='<%=num %>' data-price='<%=gPrice %>'/></td>
			<td class="td_default" align="center" width="80"
				style='padding-left: 5px'><span id="sum<%=num %>"><!-- 주의  id를 만들어 줌 sum+num 값으로  -->
				<%= gPrice* gAmount %>
				</span></td>
<!-- 주문버튼 수정 -->
			<td><input type="button" value="주문" class="ordreBtn" data-xxx='<%= num %>'>
				</td>
<!-- 삭제버튼수정 =====================================  -->			
			<td class="td_default" align="center" width="30"
				style='padding-left: 10px'><input type="button" value="삭제"
				id=xx'<%= i %>' class='delBtn' data-xxx='<%= num %>'></td>
			<td height="10"></td>
		</tr>
<% 
} //end for
%>

	</form>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5"><a class="a_black"
			href="javascript:orderAllConfirm(myForm)"> 전체 주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp; 
			<!-- 변경함  -->
			<a class="a_black" href="#" id="delAllCart"> 전체 삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="main"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>
