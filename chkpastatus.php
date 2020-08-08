<?php
include "connection.php";
$user_id = $_REQUEST['user_id'];
$sql = "SELECT * FROM `pass` WHERE `user_id` = '$user_id'";
$result = mysqli_query($con,$sql);
$row = mysqli_fetch_assoc($result);
$validity = $row['validity'];
$exp_date = $row['expDate'];
echo $validity.",".$exp_date;
?>