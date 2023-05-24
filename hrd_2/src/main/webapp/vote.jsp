<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<h3> 투표하기 </h3>
	<form name="voteForm" action="/hrd_2/vote" method="post">
	<center>
		<table border="1" style="border-collapse:collapse; width:500px; ">
			<tr>
				<th> 주민 번호 </th> 
				<td> <input type="text" name="v_jumin" >  예: 8906153154726</td>
			</tr>
			
			<tr>
				<th> 성명</th> 
				<td> <input type="text" name="v_name"> </td>
			</tr>
			
			<tr>
				<th> 투표 번호 </th> 
				<td> 
					<select class="m_no" name="m_no">
						<option></option>
						<option value="1"> [1] 김후보 </option>
						<option value="2"> [2] 이후보 </option>
						<option value="3"> [3] 박후보 </option>
						<option value="4"> [4] 조후보 </option>
						<option value="5"> [5] 최후보 </option>
					</select>
				</td>
			</tr>
			
			<tr>
				<th> 투표 시간 </th> 
			
				<td> <input type="text" name="v_time" class="v_time" placeholder="예)0930">  </td>
			</tr>
			
			<tr>
				<th> 투표 장소 </th> 
				 <td> <input type="text" name="v_area" class="v_area" placeholder="예)제1투표장">  </td>
			</tr>
			
			<tr>
				<th> 유권자 확인 </th> 
				<td> 
					 <input type="radio" name="v_confirm"  value="Y">확인 
					 <input type="radio" name="v_confirm" value="N">미확인 
					 
				</td>
			</tr>			
			
			<tr>
				<td colspan="2" style="text-align:center">
				<button type="button" onclick="vote()"> 투표하기 </button>
				<button type="button" onclick="voteReset()"> 다시하기 </button>
				</td>
			</tr>
		</table>
		 </center>
	</form>
	<%@ include file="footer.jsp" %>
	<script src="vote.js"></script>
</body>
</html>