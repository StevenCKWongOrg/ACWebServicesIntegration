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
<br>
</center>
</td></tr>
</table>
<a href="index.jsp">Back to Main Page</a>

<br><br>
<i>Last Updated: 22-Feb-2018</i>
</div>


</body>
</html>