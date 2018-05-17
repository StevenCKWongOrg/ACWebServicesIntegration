<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.stevenckwong.ACWebServicesIntegration.dom.RallyTimebox" %>
<%@ page import="com.stevenckwong.ACWebServicesIntegration.MyUtility" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rally Timeboxes</title>
</head>
<body>
<h1>We found the following timeboxes for Project <%= request.getAttribute("projectName") %></h1>

<form action="DeleteTimeboxServlet" method="POST">
<input type="hidden" name="apiKey" value="<%= MyUtility.getReadWriteApiKey() %>" />
<table style="width: 70%; margin-left: auto; margin-right: auto; border-style: ridge; border-width:medium;">
	<tr>
		<td>Timebox Type</td>
		<td>Timebox Name</td>
	</tr>
	<tr>
		<td colspan=2 style="background-color: <%=(String)request.getAttribute("panelColour") %>; text-align: center; vertical-align: middle;">
			<h3>Input Parameters</h3>
			Searching for Timeboxes for Project: <%=(String)request.getAttribute("projectName") %><br>
			<br>
			API Key: <%=(String)request.getAttribute("apikey") %><br>
			<br>
		</td>
	</tr>
	
<% 
	ArrayList<RallyTimebox> rallyTimeboxes = (ArrayList<RallyTimebox>)request.getAttribute("RallyTimeboxes"); 
	if (rallyTimeboxes.size()>0) { 
		for (int i=0; i<rallyTimeboxes.size();i++) {
			RallyTimebox eachTimebox = rallyTimeboxes.get(i);
%>

	<tr>
		<td><%=eachTimebox.getType() %><input type="hidden" name="TimeboxType" value="<%=eachTimebox.getType() %>" /></td>
		<td><%=eachTimebox.getName() %> <input type=hidden name="<%=eachTimebox.getName() %>" /></td>
		<td><%=eachTimebox.getObjectID() %> <input type=hidden name="<%=eachTimebox.getObjectID() %>" /></td>
		<td><input type="submit" value="Delete" name="Delete_<%= eachTimebox.getObjectID() %>" /></td>
	</tr>
<%		
		}
	} else {
%>
	<tr><td colspan=4>There are no timeboxes found</td></tr>
<% } %>
	
</table>
</form>

<br><br>
	<a href="index.jsp">Back to Main Page</a><br>
	<a href="index-timeboxmanagement.jsp">Back to Timebox Management page</a><br>
	<a href="index-createTimebox.jsp">Back to Timebox Creation page</a><br>
</body>
</html>