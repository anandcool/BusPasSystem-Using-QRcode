<?php
include "connection.php";
$user_id = $_REQUEST['user_id'];
$sql = "INSERT INTO `pass`(`user_id`, `validity`) VALUES ('$user_id','60')";
$result = mysqli_query($con,$sql);
//echo $row;
if($result){
    echo "60";
}
else
    echo "Pass not create";
?>