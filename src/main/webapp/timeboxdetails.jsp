<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.stevenckwong.ACWebServicesIntegration.dom.RallyTimebox" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rally Timeboxes</title>
</head>
<body>
<h1>We found the following timeboxes for Project <%= request.getAttribute("projectName") %></h1>
<table>
<tr><td>Type</td><td>Name</td><td>Start Date</td><td>End Date</td></tr>
<% 
	ArrayList<RallyTimebox> rallyTimeboxes = (ArrayList<RallyTimebox>)request.getAttribute("RallyTimeboxes"); 
	if (rallyTimeboxes.size()>0) { 
		for (int i=0; i<rallyTimeboxes.size();i++) {
			RallyTimebox eachTimebox = rallyTimeboxes.get(i);
%>
	<tr>
		<td><%=eachTimebox.getType() %></td>
		<td><%=eachTimebox.getName() %></td>
		<td><%=eachTimebox.getStartDate() %></td>
		<td><%=eachTimebox.getEndDate() %></td>
	</tr>
<%		
		}
	} else {
%>
	<tr><td colspan=4>There are no timeboxes found</td></tr>
<% } %>
	
</table>
</body>
</html>