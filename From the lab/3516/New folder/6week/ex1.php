<?php
function count_words($str)
{
	$str=strtolower($str);
	$arr1=explode(" ", $str);
	$count = array_count_values($arr1);
	foreach($count as $word => $w_value)
	{
		echo "word : " .$word;
		echo "   count: " .$w_value;
		echo "<br>";
	}
}
$w=$_GET['w1'];
count_words(
$w);
?>