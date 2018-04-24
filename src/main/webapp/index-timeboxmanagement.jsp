<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Timebox Management Demonstration</title>
</head>
<body>
<div style="text-align: center">

<br>
<table style="width:70%;background-color: beige; border-style: ridge; border-width:medium; margin-left: auto; margin-right:auto">
<tr><td><center><br>
<form name="TimeboxForm" method="POST" action="GetTimeboxServlet">
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
<input type="hidden" name="apikey" value="_BRkPjjnfSLuH0zxapb2XyJOzETEybERZpsxrZ69OSI" size="40"/> <br>
Specify Project Name: <input type=text name="projectName" value="AC Web Services" /><br>
<br>
Select Timebox to Query: 
	<select name="timeboxType">
		<option value="iteration" selected>Iterations</option>
		<option value="release">Releases</option>
		<option value="milestone">Milestones</option>
	</select><br>
<br>
<input type="Submit" value="Get Timeboxes" id="getTimeboxesButton" /><br>
</form>
</center>
</td></tr>
</table>
<a href="index.jsp">Back to Main Page</a>
<br><br>
<i>Last Updated: 23-Mar-2018</i>
</div>
</body>
</html>