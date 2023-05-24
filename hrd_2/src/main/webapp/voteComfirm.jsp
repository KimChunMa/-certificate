<%@page import="java.time.LocalDate"%>
<%@page import="hrd_2.Dto"%>
<%@page import="java.util.List"%>
<%@page import="hrd_2.Dao"%>
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
			<h3> 투표검수조회</h3>
			<table border="1" style="border-collapse:collapse; width:700px; text-align:center">
				<tr>
					<th> 성명</th><th> 셩년월일</th>
					<th> 나이</th><th> 성별</th>
					<th> 후보번호</th><th> 투표시간</th>
					<th> 유권자확인</th>
				</tr>
				<% 
					Dao dao= new Dao();
					List<Dto> list = dao.voteComfirm();
					for(int i = 0 ; i < list.size() ; i++){
					Dto dto = list.get(i);		
				%>
					<tr>
						<td> <%= dto.getV_name() %></td>
						<td> <%= dto.getV_jumin().substring(0,2)+"년"+
								dto.getV_jumin().substring(2,4)+"월"+
								dto.getV_jumin().substring(4,6)+"일" %> </td>
								
						<td> <%= 
							"만 " +( LocalDate.now().getYear()-Integer.parseInt("19"+dto.getV_jumin().subSequence(0,2)) )+ " 세"%></td>
						
						<td> <%= dto.getV_jumin().charAt(6) == '1'? "남":"여" %></td>
						<td> <%= dto.getM_no() %></td>
						<td> <%= dto.getV_time().substring(0,2)+":"+dto.getV_time().substring(2,4) %></td>
						<td> <%= dto.getV_confirm().equals("Y")?"확인":"미확인" %></td>
					</tr>
				<% }%>
		</center>		
		
	<%@ include file="footer.jsp" %>
</body>
</html>