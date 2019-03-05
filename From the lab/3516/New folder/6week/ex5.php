<?php
date_default_timezone_Set("Asia/Calcutta");
setcookie("Cookie1", date("H:i:s"), time()+3600);
if(isset($_COOKIE['Cookie1'])){
	$visit=$_COOKIE['Cookie1'];
	echo "Your Last visit was-".$visit;
}
?>