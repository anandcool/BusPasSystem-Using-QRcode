<?php
include "connection.php";
$user_id = $_REQUEST['user_id'];
$sql = "SELECT `validity` FROM `ticket` WHERE `user_id` = '$user_id'";
$result = mysqli_query($con,$sql);
$row = mysqli_fetch_assoc($result);
$validity = $row['validity'];
$new_validity = (int)$validity - 1;
$sql1 = "DELETE FROM `ticket` WHERE `user_id` = '$user_id'";
echo $validity;
$result1 = mysqli_query($con,$sql1);

// if($result){
//     echo "Pass Created";
// }
// else
//     echo "Pass not create";
?>