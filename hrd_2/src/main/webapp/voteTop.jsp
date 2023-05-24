<%@page import="hrd_2.Dao"%>
<%@page import="hrd_2.Dto"%>
<%@page import="java.util.List"%>
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
			<h3> 후보 등수 </h3>
			<table border="1" style="border-collapse:collapse; width:700px; text-align:center">
				<tr>
					<th> 후보번호 </th><th> 성명 </th><th> 총투표건수</th>
				</tr>
				<% Dao dao = new Dao();
					List<Dto> list = dao.getVoteTop();
					for(int i = 0 ; i < list.size() ; i++){
						Dto dto = list.get(i);
				%>
					<tr>
						<td> <%= dto.getM_no() %>  </td>
						<td> <%= dto.getM_name() %>  </td>
						<td> <%= dto.getV_confirm() %>  </td>
					</tr>
				
				<% } %>
				
			</table>
		</center>
		
	<%@ include file="footer.jsp" %>
</body>
</html>