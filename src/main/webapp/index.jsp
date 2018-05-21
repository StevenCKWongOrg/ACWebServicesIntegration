<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web Application to Demo Java Integration with Rally</title>
</head>
<body>
<h1 style="text-align:center;">Demo Application - Access Agile Central using WSAPI</h1>
<table style="width: 70%; margin-left: auto; margin-right: auto; border-style: inset; border-width:medium; text-align:center;">
	<tr>
		<td style="border-style: inset; border-width:medium; width: 33%;">
			<h2>User Management</h2>
		</td>
		<td style="border-style: inset; border-width:medium; width: 33%;">
			<h2>Test Case Management</h2>
		</td>
		<td style="border-style: inset; border-width:medium; width: 33%;">
			<h2>Timebox Management</h2>
		</td>
	</tr>
	<tr>
		<td>
			<a href="index-getuserdetails.jsp">Retrieve User Details</a>
		</td>
		<td>
			<a href="index-gettestcasedetails.jsp">Retrieve Test Case Details</a>
		</td>
		<td>
			<a href="index-timeboxmanagement.jsp">Retrieve Timebox Details</a><br>
			<a href="index-createTimebox.jsp">Create a new Timebox</a>
		</td>
	</tr>
</table>
<br><hr>
</body>
</html>