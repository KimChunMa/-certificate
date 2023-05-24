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
			<h3> 성적 입력</h3>
			<form name="addForm" action="/HRD_2/add" method="post">
				<table border="1">
					<tr>
						<th>학번</th><td> <input type="text" name="sno" class="sno"/> </td>
					</tr>
					
					<tr>
						<th>국어점수</th><td> <input type="text" name="ekor" class="ekor"/> </td>
					</tr>
					
					<tr>
						<th>수학점수</th><td> <input type="text" name="emath" class="emath"/> </td>
					</tr>
					
					<tr>
						<th>영어점수</th><td> <input type="text" name="eeng" class="eeng" /> </td>
					</tr>
					
					<tr>
						<th>역사점수</th><td> <input type="text" name="ehist" class="ehist" /> </td>
					</tr>
					
					<tr>
						<td colspan="2" >
							<center><button type="button" onclick="add()"> 성적입력 </button></center>
						</td>
					</tr>
				</table>
			</form>
		</center>
	<%@ include file="footer.jsp" %>
</body>
<script src="index.js"></script>
</html>