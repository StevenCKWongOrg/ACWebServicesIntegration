<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Application to Demo Java Integration with Rally</title>
</head>
<body>
<div style="text-align: center">

<h1>Get Rally Display Name Service</h1>
<h3>1. Enter the username that you are trying to lookup</h3>
<h3>2. Provide the Rally API Key</h3>
<h3>3. Click Get Display Name, and we will tell you your Display name</h3>

<table style="width:70%;background-color: beige; border-style: ridge; border-width:medium; margin-left: auto; margin-right:auto">
<tr><td><center><br>
<form name="DisplayNameForm" method=POST action="GetDisplayNameServlet">
Enter Username: <input type="text" name="username" value="stevenck.wong@acme.com" size="40"/> <br>
<br>
Enter API Key: <input type="text" name="apikey" value="_fkTPqTeS62D6PfCEbDViMRT2lotBkskiBlxd677GM" size="40" onblur="document.TestCaseForm.apikeyForTC.value=this.value;" /> <br>
<br>
<input type="Submit" value="Get Display Name" id="getDisplayNameButton" /><br>
</form>
<br>
<form name="TestCaseForm" method="POST" action="GetTestCaseServlet">
<br>
<input type="hidden" name="apikeyForTC" value="_fkTPqTeS62D6PfCEbDViMRT2lotBkskiBlxd677GM" size="40"/> <br>
Enter Test Case ID: <input type="text" name="testcaseid" value="TC50" size="20" /> <br>
<br>
<input type="Submit" value="Get Test Case Details" id="getTestCaseDetailsButton" /><br>
<input type="text" name="colour" value="blue" />
</form>

<br>
</center>
</td></tr>
</table>


<br><br>
<i>Last Updated: 8-February-2018</i>
</div>


</body>
</html>