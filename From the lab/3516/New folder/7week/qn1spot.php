<?php
	$name="invalid";
	$type="invalid";
	$dropdown1="invalid";
	$account_number="invalid";
	$checkk="dummy";
	


function luhn($cdno){

	$len = strlen($cdno);
	$c = 0;
	$eve = true;
	$val = 0;
	for($i=0;$i<$len;$i++)
	{
		if($cdno[$i] != '-')
		{
			if($eve)
			{
					$val+=($cdno[$i]*2)%10;
					if(($cdno[$i]*2) > 10)
						$val++;
					$eve = false;
			}
			else
			{
				$val+=$cdno[$i];
				$eve = true;
			}
		}
	}
	echo $val;
	return ($val%10 == 0);

}
	
function valid($cdno,$cdty){
	echo $cdno;
	$n = preg_match("/^\d{16,16}$/",$cdno);
	$m = preg_match("/^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$/",$cdno);
	//echo $n;
	//echo $m;
	if($n == 0 && $m == 0)
		return false;
	$n = preg_match("/^4/",$cdno);
	if($n>0 && strcmp($cdty,"MasterCard")==0)
		return false;
	$n = preg_match("/^5/",$cdno);
	if($n>0 && strcmp($cdty,"Visa") == 0)
		return false;
	return true;
}
	
	if(isset($_POST['name']) && isset($_POST['type']) && isset($_POST['dropdown1']) && isset( $_POST['account_number']))
	{	
	$name=$_POST['name'];
	$type=$_POST['type'];
	$dropdown1=$_POST['dropdown1'];
	$account_number=$_POST['account_number'];
	if($name != "" && $type != "" && $dropdown1 != "" && $account_number != "") 
		
		if(valid($account_number,$dropdown1)&& luhn($account_number))
		{
			$checkk=true;
		}
		else
		{
			$checkk=false;
		}	
	}

else {
	$name =" Not entered";
	$type="Null";
	$dropdown1="Null";
	$account_number="Null";
	$checkk=false;

	}
?>
<html>
<head>
	<title> Details </title>
</head>
<body>
<br/>
<?php
if($checkk)
{	echo "<center><h1>Thanks, sucker!</h1></center><br/>";

	echo "<center><h4>Your information has been recorded.</h4></center><br/>";
 
	echo "<center>Name:".$name."</center><br/>";
	
	echo "<center>Type:".$type."</center><br/>";

	echo "<center>Section:".$dropdown1."</center><br/>";
	
	echo "<center>Account Number:".$account_number."</center><br/>";


$fh = fopen("detailsfile.txt", "a") or die("Failed to create file");
fwrite($fh, "\n".$name.";".$type.";".$account_number.";".$dropdown1) or die("Failed to write file");
fclose($fh);

echo "<center><h4>Here are all the suckers who have submitted here.</h4></center><br/>";
$fh = fopen("detailsfile.txt", "r") or die("Failed to create file");
$line=fread($fh, filesize("detailsfile.txt"));
fclose($fh);
echo "<center>".nl2br($line)."</center>";
}
else
{	
	echo "<center><h1>Sorry</h1></center><br/>";
	echo "<center><h4>You didnt fill out the form completely :/</h4></center>";
	
}

?>	
</body>
</html>
