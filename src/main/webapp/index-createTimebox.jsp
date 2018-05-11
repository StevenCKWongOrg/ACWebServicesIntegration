<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create a new Timebox</title>
</head>
<body>
<div style="text-align: center">

<br>
<table style="width:70%;background-color: beige; border-style: ridge; border-width:medium; margin-left: auto; margin-right:auto">
<tr><td><center><br>
<form name="TimeboxForm" method="POST" action="CreateTimeboxServlet">
<br>
Select Timebox Results Panel Colour: 
	<select name="panelColour">
		<option value="aqua">Aqua</option>
		<option value="blue">Blue</option>
		<option value="beige" selected>Beige</option>
		<option value="cornsilk">Corn Silk</option>
		<option value="floralwhite">Floral White</option>
		<option value="greenyellow">Green Yellow</option>
		<option value="hotpink">Hot Pink</option>
		<option value="lightpink">Light Pink</option>
		<option value="plum">Plum</option>
		<option value="red">Red</option>
	</select><br>
<br>
<input type="hidden" name="apikey" value="_CGJbIEnhQDq45u70AWVPFcMsEmGCkO6tZEhYDyg5Dw" size="40"/> <br>
Specify Project Name: <input type=text name="projectName" value="AC Web Services" /><br>
<br>
Select Timebox to Create: 
	<select name="timeboxType">
		<option value="iteration">Iteration</option>
		<option value="release" selected>Release</option>
		<option value="milestone">Milestone</option>
	</select><br>
<br>
Specify Timebox Name: <input type=text name="timeboxName" value="My New Timebox" /><br>
<br>
Specify Start Date: <input type=text name="timeboxStartDate" value="2018-05-01" /><br>
<br>
Specify End Date: <input type=text name="timeboxEndDate" value="2018-05-13" /><br>
<br>
<div style="font-style:italics">Note: Currently all timeboxes is created in "AC Web Services" team only</div>
<br>
<input type="Submit" value="Create my Timebox!" id="createTimeboxButton" /><br>
</form>
</center>
</td></tr>
</table>
<a href="index.jsp">Back to Main Page</a>
<br><br>
<i>Last Updated: 11th May 2018</i>
</div>
</body>
</html>