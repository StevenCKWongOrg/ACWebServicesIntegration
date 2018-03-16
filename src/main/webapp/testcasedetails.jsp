<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.stevenckwong.ACWebServicesIntegration.dom.RallyTestCase" %>

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
			<td style="background-color: blue; text-align: center; vertical-align: middle;">
				<table style="width: 50%; margin-left: auto; margin-right: auto; border-style: ridge; border-width:medium;">
					<% RallyTestCase tcObject = (RallyTestCase)request.getAttribute("testCaseObject"); %>
					<tr><td align="right"><b>Object ID:</b> </td><td align="left"><%=tcObject.getObjectID() %> <input type="hidden" name="tcID" value="<%=tcObject.getObjectID() %>" /></td></tr>
					<tr><td align="right"><b>Formatted ID:</b> </td><td align="left"><%=tcObject.getFormattedID() %> <input type="hidden" name="tcFormattedID" value="<%=tcObject.getFormattedID() %>" /></td></tr>
					<tr><td align="right"><b>Name:</b> </td><td align="left"><%=tcObject.getName() %> <input type="hidden" name="tcName" value="<%=tcObject.getName() %>" /></td></tr>
					<tr><td align="right"><b>Description:</b> </td><td align="left"><%=tcObject.getDescription() %> <input type="hidden" name="tcDescription" value="<%=tcObject.getDescription() %>" /></td></tr>
					<tr><td align="right"><b>Owner:</b> </td><td align="left"><%=tcObject.getOwner() %> <input type="hidden" name="tcOwner" value="<%=tcObject.getOwner() %>" /></td></tr>
					<tr><td align="right"><b>Work Product:</b> </td><td align="left"><%=tcObject.getWorkProduct() %> <input type="hidden" name="tcWorkProduct" value="<%=tcObject.getWorkProduct() %>" /></td></tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style="background-color: pink; text-align: left; vertical-align: middle;">
			Raw result: <%=(String)request.getAttribute("rawResult") %>
			</td>
		</tr>
	</table>
	
</body>
</html>