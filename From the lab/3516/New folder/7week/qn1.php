<html>
<head>
	<title>Form Test</title>
</head>
<body>
<form method="post" action="qn1spot.php">
	
	<center>What is your name? 
	<input type="text" name="name"/>
	</center>
	<br/>
	<center> Enter Card Type </center>
	<br/>
	
	<center><input type="radio" name="type" value="Visa"> Visa</center>
	<center><input type="radio" name="type" value="MasterCard"> MasterCard</center><br>
	<br/>
	<center> Enter Section </center>
	<br/>
	
	<center>
	<select name="dropdown1">
	<option value="MA" selected>MA</option>
	<option value="MB" selected>MB</option>
	<option value="MC" selected>MC</option>
	<option value="MD" selected>MD</option>
	<option value="ME" selected>ME</option>
	<option value="MF" selected>MF</option>
	<option value="MG" selected>MG</option>
	<option value="MH" selected>MH</option>
	</select>
	</center>
	<br/>
	<center>
	Enter the Account number: <input type="text" name="account_number"/>
	</center>
	</br>
	<center>
	<input type="submit"/>
	</center>
</form>


</body>
</html>

