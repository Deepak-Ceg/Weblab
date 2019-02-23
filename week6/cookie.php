<?php
date_default_timezone_set("Asia/Calcutta");
setcookie("cookie1", date("H:i:s"), time()+3600);
if(isset($_COOKIE['cookie1']))
 
{
$visit = $_COOKIE['cookie1'];
echo "Your last visit was - ". $visit;
}

?>