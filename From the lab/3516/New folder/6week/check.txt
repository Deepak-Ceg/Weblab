<?php
session_start();
class Account
{
	var $bal;
	public function __Construct($b){
		if($b <0)
			$this->bal=0;
		else
			$this->bal=$b;
	}
	
	public function credit($amount){
		$this->bal+=$amount;
	}
	public function debit($amount){
		$this->bal-=$amount;
	}
	public function getBalance(){
		echo $this->bal."<br/>";
	}
}

if(isset($_GET["init"]))
{
	$obj = new Account($_GET['initial']);
	$obj->getBalance();
	$_SESSION['obj']=serialize($obj);
}
if(isset($_GET["cred"]))
{
	$obj = unserialize($_SESSION['obj']);
	$obj->credit($_GET["credit"]);
	$obj->getBalance();
	$_SESSION['obj']=serialize($obj);
}

if(isset($_GET["deb"]))
{
	$obj = unserialize($_SESSION['obj']);
	$obj->debit($_GET["debit"]);
	$obj->getBalance();
	$_SESSION['obj']=serialize($obj);
}

?>


<html>
<body>
<form method="GET" action="#">
Intial Balance:
<input type="text" name="initial">
<input type="submit" name="init">
</form>
<form method="GET" action="#">
Credit Money
<input type="text" name="credit">
<input type="submit" name="cred">
</form>
<form method="GET" action="#">
Debit money:
<input type="text" name="debit">
<input type="submit" name="deb">
</form>


</body>
</html>







