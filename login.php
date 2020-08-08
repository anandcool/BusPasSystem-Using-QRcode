<?php
include "connection.php";
$email = $_REQUEST['email'];
$pass = $_REQUEST['pass'];
$sql = "SELECT * FROM `user` WHERE email = '$email' AND pass = '$pass'";
$result = mysqli_query($con,$sql);
$row = mysqli_num_rows($result);
$result1 = mysqli_fetch_assoc($result);
if($row != 1){
    echo "invalid";
}
else
    echo $result1['fname'];
?>