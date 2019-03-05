<html>
<head></head>
<body>
<form method="GET" action="#">
Enter Word:
<input type="text" name="w1">
<input type="submit" name="Submitbut">
</form>

<?php

function count_words($str)
{
	echo "<table border='5'>
	<tr>
	<th> word </th>
	<th> count </th>
	</tr>";
	$str=strtolower($str);
	$arr1=explode(" ", $str);
	$count=array_count_values($arr1);
	arsort($count);
	foreach($count as $word => $w_value){
		echo "<tr><td>".$word."</td><td>".$w_value."</td></tr>";
	}
	echo "</table";
}

if(isset($_GET['Submitbut'])){
	$w=$_GET['w1'];
	count_words($w);
}
?>

</body>
</html>
