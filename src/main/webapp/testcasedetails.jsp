<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agile Central Get Test Case Details</title>
</head>
<body>
	<h1>Agile Central Test Case Details</h1>
	
	<table style="width: 70%; margin-left: auto; margin-right: auto; border-style: ridge; border-width:medium;">
		<tr>
			<td style="background-color: cyan; text-align: center; vertical-align: middle;">
				<h3>Input Parameters</h3>
				Searching for ID: <%=(String)request.getAttribute("testcaseid") %><br>
				<br>
				API Key: <%=(String)request.getAttribute("apikey") %><br>
				<br>
			</td>
		</tr>
		
		
		<tr>
			<td style="background-color: beige; text-align: left; vertical-align: middle;">
			Raw result: <%=(String)request.getAttribute("rawResult") %>
			</td>
		</tr>
	</table>
	
</body>
</html>