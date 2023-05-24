<%@page import="java.text.DecimalFormat"%>
<%@page import="controller.Dto"%>
<%@page import="java.util.List"%>
<%@page import="controller.Dao"%>
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
	<center>
		<h3> 학생 성적</h3>
		<table border="1" style="border-collapse:collapse; text-align:center;">
			<tr>
				<th> 학년 </th><th> 반 </th>
				<th> 번호 </th><th> 이름 </th>
				
				<th> 국어 </th><th> 수학 </th>
				<th> 영어 </th><th> 역사 </th>
				
				<th> 합계 </th><th> 평균 </th>
				<th> 순위 </th>
			</tr>
			
			<!-- 반복문 -->
			<%
				Dao dao = new Dao();
				List<Dto> list = dao.getCreditList();
				
				//과목별 합계
				int[] sumArray = {0, 0, 0, 0, 0, 0};
				double count = 0 ;
				double[] avgArray = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
				for(int i = 0 ; i < list.size(); i++){
					Dto dto = list.get(i);
					sumArray[0]+= dto.getEkor();//국어
					sumArray[1]+= dto.getEmath();//수학
					sumArray[2]+= dto.getEeng();//영어
					sumArray[3]+= dto.getEhist();//역사
					sumArray[4]+= dto.getSum();//총합
					sumArray[5]+= dto.getAvg();//평균합
				
					//점수가 있으면
					if(dto.getEkor() != 0){	count++;		%>
						<tr>
							<td> <%= dto.getGrade() %> </td>
							<td> <%= dto.getGroup() %> </td>
							<td> <%= dto.getSnumber() %> </td>
							<td> <%= dto.getSname() %> </td>
							
							<td> <%= dto.getEkor() %> </td><td> <%= dto.getEmath() %> </td>
							<td> <%= dto.getEeng() %> </td><td> <%= dto.getEhist() %> </td>
							
							<td> <%= dto.getSum() %> </td><td> <%= dto.getAvg() %> </td>
							<td> <%= dto.getRank() %> </td>
						</tr>
					<% }else{  %>
						<tr>
							<td> <%= dto.getGrade() %> </td>
							<td> <%= dto.getGroup() %> </td>
							<td> <%= dto.getSnumber() %> </td>
							<td> <%= dto.getSname() %> </td>
							
							<td>  </td><td> </td>
							<td>  </td><td>  </td>
							
							<td> </td><td>  </td>
							<td>  </td>
						</tr>
					<% } %>
				<% } %>	
			<tr>
				<td colspan="4"> 총 합 </td> 
				<% for(int i = 0 ; i <= 5 ; i++){ %>
					<td><%= sumArray[i] %> </td>
				<% } %>
				<td></td> 
			</tr>
			
			<tr>
				<% DecimalFormat df = new DecimalFormat("#.#"); %>
				<td colspan="4"> 총평균 </td>
				<% for(int i = 0 ; i <= 5 ; i++){ %>
					<td><%= df.format( sumArray[i]/count ) %> </td>
				<% } %>
				<td></td> 
			</tr>
			
		</table>
	</center>
	<%@ include file="footer.jsp" %>
</body>
</html>