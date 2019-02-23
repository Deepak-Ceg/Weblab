<?php

if(isset($_GET['submitbut'])){
$w = $_GET['w1'];
count_words($w);
}


?>
<html>
<head></head>
<body>
<form method="GET" action="#">
Enter word:
<input type = "text" name = "w1">
<input type = "submit" name ="submitbut">
</form>

<?php 
function count_words($str)
{
	echo "<table border = '5'>
<tr>
<th> word</th>
<th> count</th>
</tr>";
	$str = strtolower($str);
	$arr1 = explode(" ",$str);
	$count = array_count_values($arr1);
	arsort($count);
	foreach($count as $word => $w_value) {
    echo "<tr><td>" . $word . "</td><td>" . $w_value."</td></tr>";
	}
	echo "</table>";    
}
?>

</body>
</html>