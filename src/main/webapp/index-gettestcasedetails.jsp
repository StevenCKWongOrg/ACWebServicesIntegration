<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Application to Demo Java Integration with Rally</title>
</head>
<body>
<div style="text-align: center">
<h1>Get Rally Test Case Details Service</h1>
<h3>1. Enter the Test Case ID that you are trying to lookup</h3>
<h3>2. Select the Colour of the Result Panel</h3>
<h3>3. Click Get Test Case Details, and we will display the details of the Test Case</h3>

<br>
<table style="width:70%;background-color: beige; border-style: ridge; border-width:medium; margin-left: auto; margin-right:auto">
<tr><td><center><br>
<form name="TestCaseForm" method="POST" action="GetTestCaseServlet">
<br>
Select Test Case Details Panel Colour: 
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
<input type="hidden" name="apikeyForTC" value="_fkTPqTeS62D6PfCEbDViMRT2lotBkskiBlxd677GM" size="40"/> <br>
Enter Test Case ID: <input type="text" name="testcaseid" value="TC50" size="20" /> <input type="Submit" value="Get Test Case Details" id="getTestCaseDetailsByIDButton" name="getTestCaseDetailsByIDButton" /><br> <br>
<br>

Enter Test Name: <input type="text" name="testcasename" value="Test Get First Name - User Exists" size="50" /> <input type="Submit" value="Get Test Case by Name" id="getTestCaseDetailsByNameButton" name="getTestCaseDetailsByNameButton" /><br><br>
<br>
Enter Owner's UserName: <input type="text" name="ownerUsername" value="tm1-a1@stevenckwong.com" size="50" /> <input type="Submit" value="Get Test Case by Owner's Username" id="getTestCaseByOwnerUserNameButton" name="getTestCaseByOwnerUserNameButton" /><br><br>

</form>
</center>
</td></tr>

</table>
<a href="index.jsp">Back to Main Page</a>
<br><br>
<i>Last Updated: 22-Feb-2018</i>
</div>


</body>
</html>