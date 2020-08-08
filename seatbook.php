<?php
include "connection.php";
$busname = $_REQUEST['bus_name'];
$userid = $_REQUEST['user_id'];
$seatnumber = $_REQUEST['seatnumber'];
$sql = "INSERT INTO `passenger`(`user_id`, `bus_name`, `seat_number`) VALUES ('$userid','$busname','$seatnumber')";
$result = mysqli_query($con,$sql);
if($result){
    echo "Seat Booked";
}


?>