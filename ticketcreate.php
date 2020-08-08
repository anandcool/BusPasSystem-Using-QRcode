<?php
include "connection.php";
$user_id = $_REQUEST['user_id'];
$sql = "INSERT INTO `ticket`(`user_id`, `validity`) VALUES ('$user_id','1')";
$result = mysqli_query($con,$sql);
//echo $row;
if($result){
    echo "1";
}
else
    echo "Ticket not create";
?>