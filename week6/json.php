<?php
$arra = array("uglify-js"=> "1.3.4", "jshint"=> "0.9.1", "recess"=> "1.1.8" ,"connect"=> "2.1.3", "hogan.js"=>"2.0.0"); 
$myarray = array(1=>array(1=>'c1',2=>'c2',3=>'c3'),5=>'red', 7=>'green', 8=>'white');
print(json_encode($arra));
echo "<br>";
print(json_encode($myarray));
?>