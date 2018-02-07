<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Application to Demo Java Integration with Rally</title>
</head>
<body>
<form method=POST action="GetDisplayNameServlet">

<h1>Get Rally Display Name Service</h1>
<h3>1. Enter the username that you are trying to lookup</h3>
<h3>2. Provide the Rally API Key</h3>
<h3>3. Click Get Display Name, and we will tell you your Display name</h3>

<table width="50%" border="1">
<tr><td><center>
Enter Username: <input type="text" name="username" value="stevenck.wong@acme.com" size="40"/> <br>
<br>
Enter API Key: <input type="text" name="apikey" value="_fkTPqTeS62D6PfCEbDViMRT2lotBkskiBlxd677GM" size="40"/> <br>
<br>

<input type="Submit" value="Get Display Name" id="getDisplayNameButton" /><br>
<br>
</center>
</td></tr>
</table>
<br><br>
<i>Last Updated: 8-Feb-2018</i>


</form>
</body>
</html>