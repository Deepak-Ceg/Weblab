<?php
function count_words($str)
{
	$str=strtolower($str);
	$arr1=explode(" ", $str);
	$count=array_count_values($arr1);
	foreach($count as $word => $w_value){
	echo "Word=" .$word;
	echo "Count=" .$w_value;
	echo "<br>";
	}
}

if(isset($_GET['Submitbut'])){
	$w=$_GET['w1'];
	count_words($w);
}
?>

<html>
<head></head>
<body>
<form method: "GET" action ='#'>
Enter word:
<input type= "text" name="w1">
<input type= "submit" name="Submitbut">
</form>
</body>
</html>
