<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Timebox</title>
</head>
<body>
<%
	if (request.getAttribute("DeleteStatus").equals("PASSED")) {
%>
	<b> Your timebox has been successfully deleted </b>
<% 		
	} else {
		
%>		

	<b>Your timebox could not be deleted</b>

<%		
	}
%>

<%= request.getAttribute("DeleteReturn") %>
<br><br>
	<a href="index.jsp">Back to Main Page</a><br>
	<a href="index-timeboxmanagement.jsp">Back to Timebox Management page</a><br>
</body>
</html>