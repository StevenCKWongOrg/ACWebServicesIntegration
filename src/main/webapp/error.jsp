<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Oops... Sorry... The system encountered an error</title>
</head>
<body>
	<%  
		String errorTitle = (String)request.getAttribute("ErrorTitle");
		String errorDetailedMessage = (String)request.getAttribute("ErrorDetailedMessage");
	%>
	<div style="text-align: center">
	<h1>The system encountered an error with your request.</h1>
	<table style="width: 70%; margin-left: auto; margin-right: auto; border-style: ridge; border-width:medium;">
		<tr>
			<td style="background-color: cyan; text-align: center; vertical-align: middle;">
				<h1><%=errorTitle %></h1>
			</td>
		</tr>
		<tr>
			<td style="padding: 10px; text-align:center; background-color: beige;">
				<h3>Detailed Error Message</h3>
				<div style="font-style: italics; text-align: center;">
					<%= errorDetailedMessage %>
				</div>
				
			</td>
		</tr>	
	</table>
	<br>	
	<input type="button" value="Go Back to Main Page" onClick="location.href='index.jsp'" />
	<br>
	</div>
</body>
</html>