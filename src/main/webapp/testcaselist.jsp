<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.stevenckwong.ACWebServicesIntegration.dom.RallyTestCase" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rally Test Cases</title>
</head>
<body>
<h1>We found the following Test Cases for Owner <%= request.getAttribute("owner") %></h1>
<table>
<tr><td>Formatted ID</td><td>Name</td><td>Work Product</td><td>Owner</td></tr>
<% 
	ArrayList<RallyTestCase> rallyTestCases = (ArrayList<RallyTestCase>)request.getAttribute("testCases"); 
	if (rallyTestCases.size()>0) { 
		for (int i=0; i < rallyTestCases.size();i++) {
			RallyTestCase eachTestCase = rallyTestCases.get(i);
%>
	<tr>
		<td><%=eachTestCase.getFormattedID() %></td>
		<td><%=eachTestCase.getName() %></td>
		<td><%=eachTestCase.getWorkProduct() %></td>
		<td><%=eachTestCase.getOwner() %></td>
	</tr>
<%		
		}
	} else {
%>
	<tr><td colspan=4>There are no testcases found</td></tr>
<% } %>
	
</table>
</body>
</html>