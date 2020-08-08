<?php
include "connection.php";
$fname = $_REQUEST['fname'];
$pass = $_REQUEST['pass'];
$email = $_REQUEST['email'];
$pno = $_REQUEST['pno'];
$sql = "INSERT INTO `user`(`fname`, `pass`, `email`, `pno`) VALUES ('$fname','$pass','$email','$pno')";
$result = mysqli_query($con,$sql);
if($result){
    echo "User Add";
}


?>