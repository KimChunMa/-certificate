<%@page import="controller.Dto"%>
<%@page import="controller.Dao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생성적</title>
</head>
<body>
	<%@ include file="header.jsp" %>
		<center>
		<table border="1">
			<tr >
				<th> 학번 </th><th> 이름 </th>
				<th> 학년 </th><th> 반 </th>
				<th> 번호 </th><th> 성별 </th>
				<th> 전화번호 </th><th> 주소 </th>
			</tr>
			<% 
				Dao dao = new Dao();
				List<Dto> list = dao.getList();
				
				for(int i = 0 ; i < list.size(); i++){
					Dto dto = list.get(i);
			%>
			
			<tr>
				<td> <%= dto.getSno() %> </td>
				<td> <%= dto.getSname() %> </td>
				<td> <%= dto.getSno().charAt(0) %>  </td>
				<td> <%= dto.getSno().charAt(1)+""+dto.getSno().charAt(2) %>  </td>
				<td> <%= dto.getSno().charAt(3)+""+dto.getSno().charAt(4) %>  </td>
				<td> <%= dto.getSgender().equals("M")?"남":"여" %>  </td>
				<td> <%= dto.getSphone() %>  </td>
				<td> <%= dto.getSaddress() %>  </td>
			</tr>
			
			
			<% } %>
		</table>
		</center>
	<%@ include file="footer.jsp" %>
</body>
</html>